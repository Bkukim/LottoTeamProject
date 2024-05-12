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
import ProductService from '@/services/product/ProductService';

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
    async retrieveProduct(prodId) {
      try {
        console.log("상품정보", prodId)
        let response = await ProductService.get(prodId);
        this.product = response.data;
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
            orderName:  "테스트 명",
            successUrl: `${window.location.origin}/order/success`,

            
            failUrl: `${window.location.origin}/order/fail`,
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
    await this.retrieveProduct(this.$route.params.prodId);
    this.paymentWidget = await loadPaymentWidget(this.clientKey, ANONYMOUS);
    this.paymentMethodWidget = this.paymentWidget.renderPaymentMethods(
      "#payment-method",
      { value: this.order.orderPrice+3000 },
      { variantKey: "DEFAULT" }
    );
    this.paymentWidget.renderAgreement("#agreement", {
      variantKey: "AGREEMENT",
    });

    this.paymentMethodWidget.on("ready", () => {
      this.inputEnabled = true;
    });
  },
  mounted() {
    
    window.scrollTo(0, 0);
  },
};
</script>

<style scoped>
@import "@/assets/css/Payment/tosspay.css";
</style>
