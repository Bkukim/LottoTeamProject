<template>
  <div class="container col-md-8 mt-5" style="text-align: center">
    <h3>취소 신청</h3>
  </div>
  <div class="container refundInfo-div" v-if="order">
    <div class="container col-md-8 inner">
      <!-- 선택한 상품 정보 표시 -->
      <div class="container mt-3 mb-3">
        <h4>선택한 상품 1 건</h4>
      </div>
      <div class="product-info d-flex align-items-center">
        <img
          :src="product.prodImgUrl"
          alt="product-image"
          class="product-image"
          
        />
        <div class="product-details ml-3">
          <h5>{{ product.prodName }}</h5>
          <p>{{ products.orderAmount }}개</p>
          <p>금액: {{ order.orderPrice }}원</p>
        </div>
      </div>

      <!-- 옅은 구분선 -->
      <hr />

      <!-- 선택한 사유 표시 -->
      <h5>선택한 사유</h5>
      <div>{{ selectedOption }}</div>
    </div>

    <div class="container col-md-8 mt-4" style="text-align: center">
      <label style="font-size: 25px; font-weight: bold"
        >환불 정보를 확인해주세요!</label
      >
    </div>

    <div class="container col-md-8 inner">
      <div>
        <div class="mb-2 mt-2">
          <label style="font-size: 20px; font-weight: bold">환불정보</label>
        </div>
        <div class="refInfo">
          <span>상품금액</span>
          <span>{{order.orderPrice}} 원</span>
        </div>
        <div class="refInfo">
          <span>즉시할인</span>
          <span>0 원</span>
        </div>
        <div class="refInfo">
          <span>배송비</span>
          <span>{{order.shoppingFee}} 원</span>
        </div>
        <div class="refInfo">
          <span>반품비</span>
          <span>0 원</span>
        </div>
      </div>
      <div class="divider"></div>
      <!-- 구분선 추가 -->
      <div>
        <div class="mb-2 mt-2 refInfo">
          <span style="font-size: 20px; font-weight: bold">환불 예상금액</span>
          <span style="color: red; font-weight: bold">{{order.orderPrice + order.shoppingFee}} 원</span>
        </div>
        <div class="refInfo">
          <span>환불수단</span>
          <span>{{ order.paymentType }} / {{ order.orderPrice + order.shoppingFee }} 원</span>
        </div>
      </div>
    </div>
    <!-- 버튼 태그 시작 -->
    <div class="buttons">
      <button class="btn prev" @click="goBack">{{ "< 이전단계" }}</button>
      <button class="btn next" @click="showPopup">{{ "신청하기" }}</button>
      <RefundPopup v-if="isPopupVisible" @close="isPopupVisible = false" />
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>
<script>
import RefundPopup from './RefundPopupView.vue';
import { computed } from 'vue';
import { useStore } from 'vuex';
import OrderService from '@/services/product/OrderService';
import AdminManageService from '@/services/admin/AdminManageService';

export default {
  components: {
    RefundPopup,
  },
  setup() {
    const store = useStore();
    const selectedOption = computed(() => store.state.selectedOption);

    return {
      selectedOption
    };
  },
  data() {
    return {
      // 예시 데이터
      order:null,
      product: {},
      products: [],

      // 팝업창 표시 여부 제어 속성  
      isPopupVisible: false,
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
        // TODO: prodId로 주문 상품 정보 받아오기
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
        async getProduct(prodId) {
      try {
        console.log("상품 정보",prodId)
        let response = await AdminManageService.get(prodId);
        this.product = response.data; // 전체조회에서는 배열이었으나, 여기서는 객체 한개다. spring 결과를 바인딩 속성변수 product 에 저장
        // 로깅
        console.log("상품 쟁보", response.data);
      } catch (e) {
        console.log(e);
      }
    },
    goBack() {
      this.$router.push("/order/refund-request");
    },
    showPopup() {
      this.isPopupVisible = true; // 팝업창을 띄우는 메소드
    }
  },
  mounted() {
    console.log(this.$route.query.selectedOption);
    this.retrieveOrder(this.$route.params.orderId);
    this.retrieveProduct(this.$route.params.orderProdId);
    this.getProduct(this.$route.params.prodId);
  },
};
</script>

<style>
.refundInfo-div {
  width: 1000px;
  height: 800px;
  border: 1px solid black;
  border-radius: 10px;
  background-color: whitesmoke;
  margin-bottom: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.product-info {
  display: flex;
  align-items: flex-start;
}

.product-image {
  height: 100px;
  width: auto;
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

.buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 30px;
  width: 80%;
  max-width: 750px;
  margin-left: auto;
  margin-right: auto;
}

.btn {
  flex-grow: 1;
  padding: 10px 20px;
  font-size: 16px;
  margin: 0 10px;
  cursor: pointer;
  border: 1px solid #ccc; 
  transition: background-color 0.3s ease; 
}

.prev {
  background-color: #ffffff;
  color: #000000;
}

.next {
  background-color: #342a26;
  color: #ffffff;
}

.prev:hover {
  background-color: #e6e6e6; /* 이전단계 버튼의 배경색을 마우스 오버 시 더 어둡게 */
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

/* 태블릿과 모바일 화면 크기에 대응하기 위한 미디어 쿼리 */
@media (max-width: 992px) {
  /* 태블릿 */
  .refundInfo-div,
  .inner {
    width: 100%; /* 화면의 너비에 맞춰 조절 */
    margin-top: 20px;
    margin-bottom: 20px;
  }
}

@media (max-width: 768px) {
  /* 모바일 */
  .refundInfo-div,
  .inner {
    width: 100%; /* 화면의 너비에 맞춰 조절 */
    margin-top: 10px;
    margin-bottom: 10px;
  }
}
</style>
