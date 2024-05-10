<template>
  <div class="wrapper">
    <div class="box_section">
      <!-- 결제 UI -->
      <div id="payment-method"></div>
      <!-- 이용약관 UI -->
      <div id="agreement"></div>
      <!-- 결제하기 버튼 -->
      <button
        :disabled="!inputEnabled"
        @click="requestPayment"
        class="button"
        id="payment-button"
        style="margin-top: 30px"
      >
        결제하기
      </button>
    </div>
  </div>
</template>

<script>
import { loadPaymentWidget, ANONYMOUS } from "@tosspayments/payment-widget-sdk";
import OrderService from '@/services/product/OrderService';

export default {
  data() {
    return {
      order: null, // 주문 정보 객체

      paymentWidget: null,
      paymentMethodWidget: null,
      clientKey: "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm",
      customerKey: this.$route.params.orderId,
      amount: 50000,
      inputEnabled: false,
    };
  },
  methods: {
    async retrieveOrder(orderId) {
      try {
        console.log("주문정보", orderId)
        let response = await OrderService.get(orderId);
        this.order = response.data;
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    async requestPayment() {
      try {
        if (this.paymentWidget) {
          let data = {
            orderId: this.$route.params.orderId,
            orderName: this.order.orderName || "테스트 이름",
            successUrl: `${window.location.origin}/success`,
            failUrl: `${window.location.origin}/fail`,
          };
          console.log(data);
          await this.paymentWidget.requestPayment(data);
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
  async mounted() {
    await this.retrieveOrder(this.$route.params.orderId);
    this.paymentWidget = await loadPaymentWidget(this.clientKey, ANONYMOUS);
    this.paymentMethodWidget = this.paymentWidget.renderPaymentMethods(
      "#payment-method",
      { value: this.order.orderPrice },
      { variantKey: "DEFAULT" }
    );
    this.paymentWidget.renderAgreement("#agreement", {
      variantKey: "AGREEMENT",
    });

    this.paymentMethodWidget.on("ready", () => {
      this.inputEnabled = true;
    });
  },
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 30%;
  max-width: 100%;
  height: auto;
  max-height: 100vh;
  overflow-y: auto;
}

.button {
  display: block;
  width: 100%;
  padding: 10px;
  margin: 5px 0;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s;
}
.payment-button {
  background-color: blue;
  color: white;
}
.close-button {
  background-color: white;
  color: black;
  border: 1px solid #ccc;
}
.payment-button:hover,
.close-button:hover {
  opacity: 0.8;
}
</style>
