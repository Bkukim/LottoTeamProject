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
          {{ formatCurrency(jsonData.totalAmount) }}원
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

export default {
  data() {
    return {
      requestData: {
        orderId: this.$route.query.orderId,
        amount: this.$route.query.amount,
        paymentKey: this.$route.query.paymentKey,
      },
      confirmed: false,
      jsonData: null,
    };
  },
  methods: {
    // TODO: 금액에 쉼표 찍어주는 함수
    formatCurrency(value) {
      if (!value) return "";
      return value.toLocaleString("ko-KR");
    },
    // TODO: 토스 결제 함수
    async confirm() {
      try {
        const { response, json } = await confirmPayment(this.requestData);
        console.log(json);
        if (!response.ok) {
          // TODO: 결제 실패시 이동
          this.$router.push(`/fail?message=${json.message}&code=${json.code}`);
        } else {
          // TODO: 결제 성공시 테이블 저장
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
          paymentCode: null, // 결제번호
          orderId: this.$route.query.orderId, // 주문번호
          paymentType: this.jsonData.method,
          totalPrice: this.jsonData.totalAmount, // 주문금액(결재금액)
          payPg: this.jsonData.easyPay.provider,
          approveTime: this.jsonData.approvedAt, // 승인시간
          payTime: this.jsonData.requestedAt, // 결제일
        };

        // 1) 결제테이블 생성
        let response = await PaymentService.create(data);
        this.payment = response.data;

        // 2) 주문 상태를 '결제완료'로 변경
        data.orderStatus = "결제완료";
        let payResponse = await OrderService.change(data.orderId, data); // orderId와 data를 전달
        console.log(payResponse.data);

        alert("결제가 완료되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },
    goToMyPage() {
      this.$router.push({ path: `/order/completed/${this.jsonData.orderId}` });
    },
  },
  mounted() {
    this.confirm();
    window.scrollTo(0, 0);
  },
};
</script>

<style scoped>
@import "@/assets/css/Payment/tosspay.css";
</style>
