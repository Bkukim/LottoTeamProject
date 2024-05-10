// 주문 완료 페이지
<template>
  <main class="mt-5">
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
              justify-content: space-between;
            "
          >
            <div class="row amount">
              <label class="col-md-3 col-form-label">주문번호 :</label>
              <label
                class="col-md-9 col-form-label"
                style="text-align: right; color: blue; font-weight: bold"
              >
                {{ odid.orderId }}
              </label>
            </div>
            <div class="row amount">
              <label class="col-md-3 col-form-label">결제금액 :</label>
              <label
                class="col-md-9 col-form-label"
                style="text-align: right; color: blue; font-weight: bold"
                id="amount"
              >
                {{ odid.orderPrice }} 원
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
                odid.paymentType
              }}</label>
            </div>

            <!-- 결제수단 : 계좌이체 -->
            <div class="mb-1 row" v-if="odid.paymentType === '계좌이체'">
              <label class="col-md-2 col-form-label">입금자명</label>
              <label class="col-md-10 col-form-label">{{
                odid.depositor
              }}</label>
            </div>
            <div class="mb-1 row" v-if="odid.paymentType === '계좌이체'">
              <label class="col-md-2 col-form-label">입금은행</label>
              <label class="col-md-10 col-form-label">{{ odid.bank }}</label>
            </div>

            <!-- 결제수단 : 카드 결제 -->
            <div class="mb-3 row" v-if="odid.paymentType === '카드 결제'">
              <label class="col-md-3 col-form-label">카드사명</label>
              <label class="col-md-9 col-form-label">{{ odid.payPg }}</label>
            </div>

            <!-- 결제수단 : 간편 결제 -->
            <div class="mb-3 row" v-if="odid.paymentType === '간편 결제'">
              <label class="col-md-3 col-form-label">간편결제</label>
              <label class="col-md-9 col-form-label">{{ odid.payPg }}</label>
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
                deliv.orderName
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
              <label class="col-md-10 col-form-label">{{ deliv.addr }}</label>
            </div>
            <!-- 연락처 -->
            <div
              class="delivery-item"
              style="
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                display: flex;
                align-items: center;
              "
            >
              <label class="col-md-2 col-form-label">연락처</label>
              <label class="col-md-10 col-form-label">{{ deliv.phNum }}</label>
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
                v-if="deliv.orderRequest == true"
                >{{ deliv.orderRequest }}</label
              >
              <!-- 배송 요청 사항이 없으면 출력 -->
              <label
                class="col-md-10 col-form-label"
                v-if="deliv.orderRequest == false"
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
              v-for="(product, index) in products"
              :key="index"
              style="display: flex; align-items: center"
            >
              <div class="col-md-2 col-form-label" style="min-width: 100px">
                <img
                  :src="product.imageUrl"
                  alt="상품 이미지"
                  style="max-width: 100%"
                />
              </div>
              <div
                class="col-md-10 col-form-label"
                style="border-bottom: 1px solid rgba(0, 0, 0, 0.1)"
                v-for="product in products" :key="product.id"
              >
                상품 정보
                <br />
                <label>상품명 : {{ product.name }}</label>
                <br />
                <label>수량 : {{ product.quantity }}</label>
                <br />
                <label>금액 : {{ product.price }}</label>
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
                >원</label
              >
            </div>
            <!-- 할인/부가결제 금액 -->
            <div class="amount">
              <label class="col-md-2 col-form-label" style="min-width: 100px"
                >할인/부가결제</label
              >
              <label class="col-md-10 col-form-label" style="text-align: right"
                >원</label
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
                >3000원</label
              >
            </div>
            <!-- 총 결제금액 -->
            <div class="amount">
              <label class="col-md-2 col-form-label" style="min-width: 100px"
                >결제금액</label
              >
              <label class="col-md-10 col-form-label" style="text-align: right"
                >{{jsonData.totalAmount}}원</label
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
import { mapState } from "vuex";
import CheckoutView from '../payment/CheckoutView.vue';

export default {
      setup() {

    },
  computed: {
    // Vuex 스토어의 상태를 매핑합니다.
    ...mapState(['accountNumber']),
    CheckoutView,
  },
  data() {
    return {

      // 주문완료 이미지 경로
      ordercompleteimg: require("@/assets/images/ordercomplete_icon.png"),

    };
  },
  methods: {


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
