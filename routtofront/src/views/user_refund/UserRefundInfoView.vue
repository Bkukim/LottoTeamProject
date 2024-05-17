<template>
  <div class="container col-md-8 mt-2" style="text-align: center">
    <h3>취소 신청</h3>
  </div>
  <div class="container refundInfo-div" v-if="order">
    <div class="container col-md-8 inner">
      <!-- 선택한 상품 정보 표시 -->
      <div class="container mt-3 mb-3">
        <h4>선택한 상품</h4>
      </div>
      <div
        class="product-info d-flex align-items-center"
        v-for="(data, index) in prodInfoList"
        :key="index"
      >
        <img
          :src="data.prodImgUrl"
          alt="pdImg"
          class="pdImg"
          style="width: 100px; height: 100px"
        />
        <div class="product-details ml-3">
          <h5 style="font-weight: bold">{{ data.prodName }}</h5>
          <p>수량 : {{ data.orderAmount }}개</p>
          <p>금액 : {{ formatCurrency(data.prodPrice * data.orderAmount) }}원</p>
        </div>
      </div>

      <!-- 옅은 구분선 -->
      <hr />

      <!-- 선택한 사유 표시 -->
      <h5>선택한 사유</h5>
      <div style="margin-bottom: 20px">{{ selectedOption }}</div>
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
          <label>상품금액</label>
          <label>{{ formatCurrency(order.orderPrice) }} 원</label>
        </div>
        <div class="refInfo">
          <label>배송비</label>
          <label>{{ formatCurrency(order.shoppingFee) }} 원</label>
        </div>
        <div class="refInfo">
          <label>반품비</label>
          <label>0 원</label>
        </div>
      </div>
      <div class="divider"></div>
      <!-- 구분선 추가 -->
      <div>
        <div class="mb-2 mt-2 refInfo">
          <label style="font-size: 20px; font-weight: bold"
            >환불 예상금액</label
          >
          <label style="color: red; font-weight: bold"
            >{{ formatCurrency(order.orderPrice + order.shoppingFee) }} 원</label
          >
        </div>
        <div class="refInfo">
          <label>환불수단</label>
          <label
            >{{ order.paymentType }} /
            {{ formatCurrency(order.orderPrice + order.shoppingFee) }} 원</label
          >
        </div>
      </div>
    </div>
    <!-- 버튼 태그 시작 -->
    <div class="buttonsiu">
      <button class="btnn prev" @click="goBack">{{ "< 이전단계" }}</button>
      <button class="btnn next" @click="goConfirm(this.orderId)">
        {{ "신청하기" }}
      </button>
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>
<script>
import { computed } from "vue";
import { useStore } from "vuex";
import OrderService from "@/services/product/OrderService";
import RefundService from "@/services/payment/RefundService";

export default {
  computed: {
    orderId() {
      return this.$route.params.orderId;
    },
  },
  setup() {
    const store = useStore();
    const selectedOption = computed(() => store.state.selectedOption);

    return {
      selectedOption,
    };
  },
  data() {
    return {
      order: null,
      prodInfoList: [],
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
    async getProductInfo(orderProdId) {
      try {
        let response = await OrderService.getProductInfo(orderProdId);

        this.prodInfoList.push(...response.data);
      } catch (e) {
        console.log(e);
      }
    },
    goBack() {
      this.$router.go(-1);
    },
    async goConfirm(orderId) {
      try {
        let data = {
          orderId: orderId,
          orderStatus: "환불신청",
        };
        let response = await RefundService.requestRefund(orderId, data);

        console.log(response.data);

        // 주문자 환불 완료 페이지로 이동
        this.goToRefundSuccessPage(orderId);
      } catch (e) {
        console.log(e);
      }
    },
    goToRefundSuccessPage(orderId) {
      this.$router.push({
        name: "RefundSuccess",
        params: { orderId: orderId },
      });
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
  width: 1000px;
  height: auto;
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
  margin-bottom: 20px;
  background-color: #f9f9f9;
  border-radius: 10px;
  padding: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.pdImg {
  height: 100px !important;
  width: 100px !important;
  margin: 0 !important;
  align-self: center !important;
}

.product-details {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding-left: 12px;
}

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

.buttonsiu {
  display: flex;
  justify-content: space-between;
  margin-top: 30px;
  width: 80%;
  max-width: 750px;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 30px;
}

.btnn {
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

@media (max-width: 992px) {
  .refundInfo-div,
  .inner {
    width: 100%;
    margin-top: 20px;
    margin-bottom: 20px;
  }
}

@media (max-width: 768px) {
  .refundInfo-div,
  .inner {
    width: 100%;
    margin-top: 10px;
    margin-bottom: 10px;
  }
}
</style>
