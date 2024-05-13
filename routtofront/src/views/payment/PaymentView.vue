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
      <!-- 결제 취소 버튼 -->
      <button
       class="button"
       id="payment-button"
       style="margin-top: 30px"
       @click="cancelPayment"       
      >
        취소하기
      </button>
    </div>
  </div>
</template>

<script>
import { loadPaymentWidget, ANONYMOUS } from "@tosspayments/payment-widget-sdk";
import OrderService from '@/services/product/OrderService';
import AdminOrderService from '@/services/admin/AdminOrderService';

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
        let response = await OrderService.goPayment(orderId);
        this.order = response.data;
        console.log("결제 정보",response.data);
      } catch (e) {
        console.log(e);
      }
    },
    async requestPayment() {
      try {
        if (this.paymentWidget) {
          let data = {
            orderId: this.$route.params.orderId,
            orderName:  "루또",
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

    async cancelPayment() {
          let response = await AdminOrderService.delete(this.order.orderId);
          // 로깅
          console.log(response.data);
          // TODO: this.$router.push("이동할 url")
          this.$router.go(-1);
          setTimeout(() => window.location.reload(), 5); // 5ms 후에 페이지 새로고침
    },
  },
  async mounted() {
    await this.retrieveOrder(this.$route.params.orderId);
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
};
</script>

<style scoped>
@import "@/assets/css/Payment/tosspay.css";
</style>
