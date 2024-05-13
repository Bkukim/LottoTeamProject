<template>
  <!-- 결제 성공 시 -->
  <section v-if="confirmed">
    <div class="box_section" style="width: 600px">
      <img
        style="width: 100px"
        src="https://static.toss.im/illusts/check-blue-spot-ending-frame.png"
      />
      <h2>결제를 완료했어요</h2>

      <div class="p-grid typography--p" style="margin-top: 50px">
        <div class="p-grid-col text--left"><b>결제금액</b></div>
        <div class="p-grid-col text--right" id="price">
          {{ jsonData.totalAmount }}원
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>주문번호</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData.orderId }}
        </div>
      </div>
      <!-- 주문 확인하기 버튼 -->
      <button
        class="button"
        type="button"
        id="payment-button"
        style="margin-top: 30px"
        @click="goToMyPage"
      >
        주문 확인하기
      </button>
    </div>
  </section>
</template>

<script>
import { confirmPayment } from "@/services/payment/confirmPayment";
import PaymentService from "@/services/payment/PaymentService";
import OrderService from "@/services/product/OrderService";
// import UserService from '@/services/user/UserService';
// import AdminManageService from '@/services/admin/AdminManageService';

export default {
  data() {
    return {
      requestData: {
        orderId: this.$route.query.orderId, // 쿼리스트링 방식
        amount: this.$route.query.amount, // 쿼리스트링 방식
        paymentKey: this.$route.query.paymentKey, // 쿼리스트링 방식 , 필수
      },
      confirmed: false,
      jsonData: null,
      // user: null,
      // product: {},
      // products: [],
    };
  },
  methods: {
    // TODO: 토스 결재 함수
    async confirm() {
      try {
        const { response, json } = await confirmPayment(this.requestData);
        console.log(json);
        if (!response.ok) {
          // TODO: 결재 실패시 이동
          this.$router.push(`/fail?message=${json.message}&code=${json.code}`);
        } else {
          // TODO: 결재 성공시 테이블 저장
          this.confirmed = true;
          this.jsonData = json;

          // 결재 테이블 저장
          this.confirmApproval();
        }
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 결제 저장 함수
    async confirmApproval() {
      try {
        // 임시 객체
        let data = {
          paymentCode: null, // 결재번호
          orderId: this.$route.query.orderId, // 주문번호
          paymentType: this.jsonData.method,
          totalPrice: this.jsonData.totalAmount, // 주문금액(결재금액)
          payPg: this.jsonData.easyPay.provider,
          approveTime: this.jsonData.approvedAt, // 승인시간
          payTime: this.jsonData.requestedAt, // 결제일
        };

        console.log("confirmApproval", data);

        // 1) 주문 테이블에 데이터 수정
        let response = await PaymentService.create(data);
        this.payment = response.data;
        console.log(response.data);

        // 2) 주문 상태를 '결제완료'로 변경
        await this.updateOrderStatus(data.orderId, "결제완료");

        // alert("결제가 완료되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },
    async updateOrderStatus(orderId, data) {
      try {
        let response = await OrderService.change(orderId, data);
        console.log("주문 상태 업데이트 성공", response.data);
      } catch (e) {
        console.log("주문 상태 업데이트 실패", e);
      }
    },
    //     // TODO: userId로 연락처 받아오기
    // async retrieveUser(userId) {
    //   try {
    //     console.log("주문자 정보" + userId)
    //     let response = await UserService.get(userId);
    //     this.user = response.data;
    //     console.log("주문자 정보보보", response.data);
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    // // TODO: orderProdId로 주문 상품 정보 받아오기
    // async retrieveProduct(orderProdId) {
    //   try {
    //     console.log("주문번호" + orderProdId)
    //     let response = await OrderService.getProdInfo(orderProdId);
    //     this.products = response.data;
    //     console.log("주문 번호", response.data);
    //   } catch (error) {
    //     console.log(error);
    //   }
    // },
    // // TODO: prodId로 주문 상품 정보 받아오기
    //     async getProduct(prodId) {
    //   try {
    //     console.log("상품 정보",prodId)
    //     let response = await AdminManageService.get(prodId);
    //     this.product = response.data; // 전체조회에서는 배열이었으나, 여기서는 객체 한개다. spring 결과를 바인딩 속성변수 product 에 저장
    //     // 로깅
    //     console.log("상품 정정보", response.data);
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    goToMyPage() {
      this.$router.push("/member/mypage");
    },
  },
  mounted() {
    this.confirm();
    // this.retrieveUser(this.$route.params.userId);
    // console.log("유저 아이디", this.$route.params.userId)
    // console.log("주문상품 번호", this.$route.params.orderProdId)
    // console.log("상품 번호",this.$route.params.prodId)
    // this.retrieveProduct(this.$route.params.orderProdId);
    // this.getProduct(this.$route.params.prodId);
  },
};
</script>

<style scpoed>
@import "@/assets/css/Payment/tosspay.css";
</style>
