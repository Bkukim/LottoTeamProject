<template>
  <div class="container col-md-8 mt-2" style="text-align: center">
    <h3>취소 신청</h3>
  </div>
  <div class="container refundInfo-div">
    <div class="container col-md-8 mt-4" style="text-align: center">
      <label style="font-size: 25px; font-weight: bold"
        >환불 신청이 완료되었습니다.</label
      >
    </div>
    <div class="container col-md-8 inner">
      <!-- 선택한 상품 정보 표시 -->
      <div class="container mt-3 mb-3">
        <h4>취소 상품</h4>
      </div>
      <div class="product-info d-flex align-items-center"
      v-for="(data, index) in prodInfoList" :key="index">
        <img
          :src="data.prodImgUrl"
          alt="product-image"
          class="product-image"
          style="width: 100px; height: 100px;"
        />
        <div class="product-details ml-3">
          <h5>{{data.prodName}}</h5>
          <p>{{data.orderAmount}}개</p>
          <p>금액: {{data.prodPrice * data.orderAmount}}원</p>
        </div>
      </div>

      <!-- 옅은 구분선 -->
      <hr />

      <!-- 환불 예정일 -->
      <div class="refund-info">
        <label class="refund-label">환불 예정일</label>
        <label class="refund-date" style="color: green">평일 3~7일 이내</label>
      </div>

      <!-- 옅은 구분선 -->
      <hr />

      <!-- 환불 수단 -->
      <div class="refund-info" v-if="order">
        <label class="refund-label">환불 수단</label>
        <label class="refund-date" style="margin-left: 15px"
          >{{order.paymentType}}</label
        >
      </div>
    </div>

    <!-- 버튼 태그 시작 -->
    <div class="buttonsss">
      <button class="btnns prev" @click="goToMyPage">
        {{ "신청내역 확인하기" }}
      </button>
      <button class="btnns next" @click="goToHome">{{ "쇼핑 계속하기" }}</button>
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>
<script>
import OrderService from "@/services/product/OrderService";

export default {
  data() {
    return {
      order: null,
      prodInfoList: [],
    };
  },
  methods: {
    // TODO: orderId로 상세조회하는 함수
    async retrieveOrder(orderId) {
      try {
        let response = await OrderService.getOrderInfo(orderId);
        this.order = response.data;
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: orderId로 prodId 조회하는 함수
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
    // TODO: 상품 상세 조회 함수
    async getProductInfo(orderProdId) {
      try {
        let response = await OrderService.getProductInfo(orderProdId);

        this.prodInfoList.push(...response.data);
      } catch (e) {
        console.log(e);
      }
    },        
    goToMyPage() {
      this.$router.push("/member/mypage");
    },
    goToHome() {
      this.$router.push("/");
    },
  },
  mounted() {
    this.retrieveOrder(this.$route.params.orderId);
    this.getProdId(this.$route.params.orderId);
    this.getProductInfo(this.$route.params.orderProdId);
  },
};
</script>

<style scoped>
.refundInfo-div {
  width: 800px;
  height: auto;
  border: 1px solid black;
  border-radius: 10px;
  background-color: whitesmoke;
  margin-top: 25px;
  margin-bottom: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.product-info {
  display: flex;
  align-items: flex-start;
  margin-bottom: 20px;
  background-color: #f9f9f9;
  border-radius: 10px;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.product-image {
  height: 100px !important;
  width: 100px !important;
  margin: 0px !important;
}

.product-details {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding-left: 12px;
}

/* 선택적: 상품 정보 텍스트 스타일 조정 */
.product-details h5,
.product-details p {
  margin: 0;
  padding: 2px 0;
}

.refInfo {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.divider {
  height: 1px;
  background-color: #ccc;
  width: 100%;
  margin: 0 auto;
}

.buttonsss {
  display: flex !important;
  justify-content: space-between !important;
  margin-top: 30px !important;
  width: 80% !important;
  max-width: 750px !important;
  margin-left: auto !important;
  margin-right: auto !important;
  margin-bottom: 20px !important;
}

.btnns {
  flex-grow: 1 !important;
  padding: 10px 20px !important;
  font-size: 16px !important;
  margin: 0 10px !important;
  cursor: pointer !important;
  border: 1px solid #ccc !important;
  transition: background-color 0.3s ease !important;
}

.prev {
  background-color: #ffffff !important;
  color: #000000 !important;
}

.next {
  background-color: #342a26 !important;
  color: #ffffff !important;
}

.prev:hover {
  background-color: #e6e6e6;
}

.next:hover {
  background-color: #8a7465;
}

.inner {
  border: 1px solid black;
  border-radius: 10px;
  background-color: white;
  margin-top: 25px;
  width: 75%;
}

.refund-info {
  display: flex;
  align-items: center;
  margin-top: 20px;
  margin-bottom: 20px;
}

.refund-label {
  flex: 0 0 auto;
  margin-right: 20px;
}

.refund-date {
  flex-grow: 1;
  font-size: 20px;
}

@media (max-width: 992px) {
  .refundInfo-div,
  .inner {
    width: 100%; /* 화면의 너비에 맞춰 조절 */
    margin-top: 20px;
    margin-bottom: 20px;
  }
}

@media (max-width: 768px) {
  .refundInfo-div,
  .inner {
    width: 100%; /* 화면의 너비에 맞춰 조절 */
    margin-top: 10px;
    margin-bottom: 10px;
  }
}
</style>
