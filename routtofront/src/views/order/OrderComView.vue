// 주문 완료 페이지
<template>
  <main class="mt-5" v-if="order">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <h1 class="mb-3" style="text-align: center">주문완료</h1>
          <div
            class="col-md-8 container"
            style="display: flex; justify-content: center"
          >
            <img :src="ordercompleteimg" style="width: 60px; height: auto" />
          </div>
          <div
            class="col-md-8 mt-2 container"
            style="display: flex; justify-content: center; text-align: center"
          >
            <p style="font-weight: bold; font-size: 20px">
              고객님의 주문이 <br />정상적으로 완료되었습니다.
            </p>
          </div>

          <div
            style="border-top: 1px dashed #ccc; width: 95%; margin: 20px auto"
          ></div>

          <div
            class="mb-3 row"
            style="
              display: flex;
              flex-direction: column;
              justify-content: space-between;"
          >
            <div class="row amount">
              <label class="col-md-3 col-form-label">주문번호 :</label>
              <label
                class="col-md-9 col-form-label"
                style="text-align: right; color: blue; font-weight: bold"
              >
                {{ order.orderId }}
              </label>
            </div>
            <div class="row amount">
              <label class="col-md-3 col-form-label">결제금액 :</label>
              <label
                class="col-md-9 col-form-label"
                style="text-align: right; color: blue; font-weight: bold"
                id="amount"
              >
                {{ order.orderPrice + order.shoppingFee }} 원
              </label>
            </div>
          </div>

          <!-- 결제수단 박스 시작 -->
          <div
            class="mb-3 row"
            style="border-top: 1px solid black; border-bottom: 1px solid black"
          >
            <div
              class="col-md-12 mb-3 mt-3 pb-3"
              style="border-bottom: 1px solid rgba(0, 0, 0, 0.2)"
            >
              <b>결제수단</b>
            </div>
            <div>
              <label class="col-md-2 col-form-label">결제수단</label>
              <label class="col-md-10 col-form-label">{{
                order.paymentType
              }}</label>
            </div>
          </div>
          <!-- 결제수단 박스 끝 -->

          <!-- 배송지 박스 시작 -->
          <div
            class="mb-3 row"
            style="border-top: 1px solid black; border-bottom: 1px solid black"
          >
            <div
              class="col-md-12 mt-3 pb-3"
              style="
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                display: flex;
                align-items: center;
              "
            >
              <b>배송 정보</b>
            </div>
            <!-- 받는 사람 -->
            <div
              class="delivery-item"
              style="
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                display: flex;
                align-items: center;
              "
            >
              <label class="col-md-2 col-form-label">받는 사람</label>
              <label class="col-md-10 col-form-label">{{
                order.receiver
              }}</label>
            </div>
            <!-- 주소 -->
            <div
              class="delivery-item"
              style="
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                display: flex;
                align-items: center;
              "
            >
              <label class="col-md-2 col-form-label">주소</label>
              <label class="col-md-10 col-form-label">{{
                "(" + order.zipCode + ")" + " " +
                order.orderAddress + " " + order.orderDetailAddress }}</label>
            </div>
            <!-- 연락처 -->
            <div
              class="delivery-item"
              style="
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                display: flex;
                align-items: center;
              "
              v-if="user"
            >
              <label class="col-md-2 col-form-label">연락처</label>
              <label class="col-md-10 col-form-label">{{ user.phoneNum }}</label>
            </div>
            <!-- 배송 요청 사항 -->
            <div
              class="delivery-item"
              style="display: flex; align-items: center; border-bottom: none"
            >
              <label class="col-md-2 col-form-label">배송 요청</label>
              <!-- 배송 요청 사항이 있으면 출력 -->
              <label
                class="col-md-10 col-form-label"
                
                >{{ order.orderRequest }}</label
              >
              <!-- 배송 요청 사항이 없으면 출력 -->
              <label
                class="col-md-10 col-form-label"

              ></label>
            </div>
          </div>
          <!-- 배송지 박스 끝 -->

          <!-- 주문 상품 정보 박스 시작 -->
          <div
            class="mb-3 row"
            style="border-top: 1px solid black; border-bottom: 1px solid black"
          >
            <div
              class="col-md-12 mb-3 mt-3 pb-3"
              style="border-bottom: 1px solid rgba(0, 0, 0, 0.1)"
            >
              <b>주문 상품</b>
            </div>
            <!-- 주문 상품 사진 및 상품 정보 -->
            <div
              style="display: flex; align-items: center"
            >
              <div class="col-md-2 col-form-label" style="min-width: 100px">
                <img
                  :src="product.prodImgUrl"
                  alt="상품 이미지"
                  style="width: 100px; height: 100px"
                />
              </div>
              <div
                class="col-md-10 col-form-label"
                style="border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                       margin-left: 10px;"
                
              >
                상품 정보
                <br />
                <label>상품명 : {{ product.prodName }}</label>
                <br />
                <label>수량 : {{ products.orderAmount }} 개</label>
                <br />
                <label>금액 : {{ order.orderPrice }}</label>
                <br />
                <label>할인 금액 : 0원</label>
              </div>
            </div>
            <div>
            </div>
          </div>
          <!-- 주문 상품 정보 박스 끝 -->

          <!-- 결제 정보 박스 시작 -->
          <div
            class="mb-3 row"
            style="border-top: 1px solid black; border-bottom: 1px solid black"
          >
            <div
              class="col-md-12 mt-3 pb-3"
              style="border-bottom: 1px solid rgba(0, 0, 0, 0.1)"
            >
              <b>결제정보</b>
            </div>
            <!-- 주문 상품 금액 -->
            <div class="amount">
              <label class="col-md-2 col-form-label">주문 상품</label>
              <label class="col-md-10 col-form-label" style="text-align: right"
                >{{ order.orderPrice }} 원</label
              >
            </div>
            <!-- 할인/부가결제 금액 -->
            <div class="amount">
              <label class="col-md-2 col-form-label" style="min-width: 100px"
                >할인/부가결제</label
              >
              <label class="col-md-10 col-form-label" style="text-align: right"
                >0 원</label
              >
            </div>
            <!-- 배송비 금액 -->
            <div class="amount">
              <label
                class="col-md-2 col-form-label pr-2"
                style="min-width: 100px"
                >배송비</label
              >
              <label class="col-md-10 col-form-label" style="text-align: right"
                >{{order.shoppingFee}} 원</label
              >
            </div>
            <!-- 총 결제금액 -->
            <div class="amount">
              <label class="col-md-2 col-form-label" style="min-width: 100px"
                >결제금액</label
              >
              <label class="col-md-10 col-form-label" style="text-align: right"
                >{{order.orderPrice + order.shoppingFee}} 원</label
              >
            </div>
          </div>
          <!-- 결제 정보 박스 끝 -->

          <!-- 버튼 div 시작 -->
          <div class="row mt-5 mb-5">
            <div class="d-flex justify-content-between align-items-center">
              <!-- 주문확인하기 버튼 -->
              <div class="col-6 d-grid p-1">
                <button
                  type="button"
                  class="btn btn-lg btn-outline-dark"
                  @click="goToMyPage"
                >
                  주문 확인하기
                </button>
              </div>
              <!-- 쇼핑 계속하기 버튼 -->
              <div class="col-6 d-grid p-1">
                <button
                  type="button"
                  class="btn btn-lg keepShopBtn btn-outline-dark"
                  @click="goToHome"
                >
                  쇼핑 계속하기
                </button>
              </div>
            </div>
          </div>
          <!-- 버튼 div 끝 -->
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import OrderService from '@/services/product/OrderService';
import { mapState } from "vuex";
import CheckoutView from '../payment/CheckoutView.vue';
import UserService from '@/services/user/UserService';
import AdminManageService from '@/services/admin/AdminManageService';
// import PaymentService from '@/services/payment/PaymentService';

export default {
  computed: {
    // Vuex 스토어의 상태를 매핑합니다.
    ...mapState(['accountNumber']),
    CheckoutView,
  },
  data() {
    return {
      order: null,
      user: null,
      product: {},
      products:[],
      // payment: null,
      // userPhoneNum: this.user.userPhoneNum,
      // 주문완료 이미지 경로
      ordercompleteimg: require("@/assets/images/ordercomplete_icon.png"),

    };
  },
  methods: {
    // TODO: orderId로 상세조회하는 함수
    async retrieveOrder(orderId) {
      try {
        console.log("주문정보", orderId)
        let response = await OrderService.getOrderInfo(orderId);
        this.order = response.data;
        console.log("주문 정보", response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: userId로 연락처 받아오기
    async retrieveUser(userId) {
      try {
        console.log("주문자 정보" + userId)
        let response = await UserService.get(userId);
        this.user = response.data;
        console.log("주문자 정보보보", response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: orderProdId로 주문 상품 정보 받아오기
    async retrieveProduct(orderProdId) {
      try {
        console.log("주문번호" + orderProdId)
        let response = await OrderService.getProdInfo(orderProdId);
        this.products = response.data;
        console.log("주문 번호", response.data);
      } catch (error) {
        console.log(error);
      }
    },
    // TODO: prodId로 주문 상품 정보 받아오기
        async getProduct(prodId) {
      try {
        console.log("상품 정보",prodId)
        let response = await AdminManageService.get(prodId);
        this.product = response.data; // 전체조회에서는 배열이었으나, 여기서는 객체 한개다. spring 결과를 바인딩 속성변수 product 에 저장
        // 로깅
        console.log("상품 정보보보", response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // // TODO: 다시 조회해보자
    //     async retrieveOrderProduct(orderId) {
    //   // alert(orderId)
    //   // todo: orderId로 조회하기 : 주문상세테이블
    //   try {
    //     let response = await OrderService.getOrderId(orderId); 
    //     console.log(response.data);
    //     this.orderProds = response.data; // 백엔드에서 배열이 들어옴(response에는 헤더_파일 형식, 바디_데이터 정보가 다 있다. 우리가 궁금한건 바디부분이라서 .data)
    //   } catch (error) {
    //     console.error("에러 발생 : ", error);
    //   }
    // },
    // async getOrderInfo(orderId) {
    //   try {
    //     let response = await OrderService.getOrderInfo(orderId);
    //     this.order = response.data;
    //     console.log(response.data)
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    // async getPaymentInfo(paymentCode) {
    //   try {
    //     let response = await PaymentService.getPaymentInfo(paymentCode);
    //     this.payment = response.data;
    //     console.log(response.data)
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    // 주문 확인하기 버튼 클릭시 실행될 함수
    goToMyPage() {
      this.$router.push("/member/mypage");
    },
    // 쇼핑 계속하기 버튼 클릭시 실행될 함수
    goToHome() {
      this.$router.push("/");
    },
  },
  mounted() {

    // this.getOrderInfo(this.$route.params.orderId); // 주문 정보 상세 조회 함수
    // this.getPaymentInfo(this.$route.param.paymentCode); // 결제 정보 상세 조회 함수
    this.retrieveOrder(this.$route.params.orderId);
    this.retrieveUser(this.$route.params.userId);
    // console.log(product);
    this.retrieveProduct(this.$route.params.orderProdId);
    this.getProduct(this.$route.params.prodId);
    // this.retrieveOrderProduct(this.$route.parmas.orderId);

    window.scrollTo(0, 0);

  },
};
</script>

<style>
.keepShopBtn {
  background-color: #342a26;
  color: white;
}

.delivery-item .col-form-label {
  display: flex;
  align-items: center;
  height: 100%;
}

.amount {
  display: flex;
  justify-content: space-between;
}
</style>
