// 주문 완료 페이지
<template>
  <main class="mt-5" v-if="order">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8">
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
                {{ formatCurrency(order.orderPrice + order.shoppingFee) }} 원
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
                "(" +
                order.zipCode +
                ")" +
                " " +
                order.orderAddress +
                " " +
                order.orderDetailAddress
              }}</label>
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
              <label class="col-md-10 col-form-label">{{ phone }}</label>
            </div>
            <!-- 배송 요청 사항 -->
            <div
              class="delivery-item"
              style="display: flex; align-items: center; border-bottom: none"
            >
              <label class="col-md-2 col-form-label">배송 요청</label>
              <!-- 배송 요청 사항이 있으면 출력 -->
              <label class="col-md-10 col-form-label">{{
                order.orderRequest
              }}</label>
              <!-- 배송 요청 사항이 없으면 출력 -->
              <label class="col-md-10 col-form-label"></label>
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
              class="product-info"
              style="display: flex; align-items: center"
              v-for="(data, index) in prodInfoList"
              :key="index"
            >
              <div class="col-md-2 col-form-label" style="min-width: 100px">
                <img
                  :src="data.prodImgUrl"
                  alt="상품 이미지"
                  style="width: 100px; height: 100px"
                />
              </div>
              <div
                class="col-md-10 col-form-label"
                style="
                  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                  margin-left: 10px;
                "
              >
                상품 정보
                <br />
                <label>상품명 : {{ data.prodName }}</label>
                <br />
                <label>수량 : {{ data.orderAmount }} 개</label>
                <br />
                <label
                  >금액 :
                  {{
                    formatCurrency(data.prodPrice * data.orderAmount)
                  }}원</label
                >
                <br />
              </div>
            </div>
            <div></div>
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
                >{{ formatCurrency(order.orderPrice) }} 원</label
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
                >{{ formatCurrency(order.shoppingFee) }} 원</label
              >
            </div>
            <!-- 총 결제금액 -->
            <div class="amount">
              <label class="col-md-2 col-form-label" style="min-width: 100px"
                >결제금액</label
              >
              <label class="col-md-10 col-form-label" style="text-align: right"
                >{{
                  formatCurrency(order.orderPrice + order.shoppingFee)
                }}
                원</label
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
import OrderService from "@/services/product/OrderService";

export default {
  data() {
    return {
      order: null,
      phone: "",
      prodInfoList: [],
      // 주문완료 이미지 경로
      ordercompleteimg: require("@/assets/images/ordercomplete_icon.png"),
    };
  },
  methods: {
    // TODO: 금액에 쉼표 찍어주는 함수
    formatCurrency(value) {
      if (!value) return "";
      return value.toLocaleString("ko-KR");
    },
    // TODO: orderId로 상세조회하는 함수
    async retrieveOrder(orderId) {
      try {
        let response = await OrderService.getOrderInfo(orderId);
        this.order = response.data;
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: orderId로 연락처 받아오기
    async retrieveUser(orderId) {
      try {
        let response = await OrderService.getOrderPhone(orderId);
        this.phone = response.data;
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: orderId로 prodId 받아오는 함수
    async getProdId(orderId) {
      try {
        let response = await OrderService.getOrderProduct(orderId);
        this.prodId = response.data;

        let promises = this.prodId.map((id) => this.getProductInfo(id));

        await Promise.all(promises);
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: orderProdId로 상품 정보 받아오는 함수
    async getProductInfo(orderProdId) {
      try {
        let response = await OrderService.getProductInfo(orderProdId);

        this.prodInfoList.push(...response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 주문 확인하기 버튼 클릭시 실행될 함수
    goToMyPage() {
      this.$router.push("/member/mypage");
    },
    // TODO: 쇼핑 계속하기 버튼 클릭시 실행될 함수
    goToHome() {
      this.$router.push("/");
    },
  },
  mounted() {
    this.retrieveOrder(this.$route.params.orderId);
    this.retrieveUser(this.$route.params.orderId);
    this.getProdId(this.$route.params.orderId);
    this.getProductInfo(this.$route.params.orderProdId);

    window.scrollTo(0, 0);
  },
};
</script>

<style scoped>
.product-info {
  background-color: #f9f9f9;
  border-radius: 10px;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-bottom: 10px;
}

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

/* 반응형 스타일 */
@media (min-width: 992px) {
  .col-lg-8 {
    max-width: 800px;
  }
}

@media (max-width: 991.98px) {
  .col-md-8 {
    max-width: 100%;
  }
}
</style>
