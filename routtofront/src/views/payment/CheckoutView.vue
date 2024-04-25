<template>
  <div class="wrapper modal-overlay" v-if="isModalVisible">
    <div class="box_section modal-content">
      <div id="payment-method"></div>
      <div id="agreement"></div>
      <button
        :disabled="!inputEnabled"
        @click="requestPayment"
        class="button payment-button"
        id="payment-button"
      >
        결제하기
      </button>
      <button @click="closeModal" class="button close-button" id="close-button">
        닫기
      </button>
    </div>
  </div>
</template>

<script>
import { loadPaymentWidget, ANONYMOUS } from "@tosspayments/payment-widget-sdk";
import { nanoid } from "nanoid";

export default {
  data() {
    return {
      paymentWidget: null,
      paymentMethodWidget: null,
      clientKey: "test_ck_5OWRapdA8dYakkjpB21W3o1zEqZK",
      customerKey: nanoid(),
      amount: 50000,
      inputEnabled: false,
      isModalVisible: true,
    };
  },
  methods: {
    async requestPayment() {
      try {
        const orderId = nanoid();
        await this.paymentWidget.requestPayment({
          orderId,
          orderName: "토스 티셔츠 외 2건",
          customerName: "김토스",
          customerEmail: "customer123@gmail.com",
          customerMobilePhone: "01012341234",
          successUrl: `${window.location.origin}/order/success`,
          failUrl: `${window.location.origin}/order/fail`,
        });
      } catch (error) {
        console.error(error);
      }
    },
    closeModal() {
      this.isModalVisible = false;
    },
  },
  async mounted() {
    this.paymentWidget = await loadPaymentWidget(this.clientKey, ANONYMOUS);

    this.paymentMethodWidget = this.paymentWidget.renderPaymentMethods(
      "#payment-method",
      { value: this.amount },
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
  background-color: #fff; /* 배경색 추가 */
  padding: 20px; /* 적절한 패딩 추가 */
  border-radius: 5px; /* 모서리 둥글게 */
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 그림자 추가 */
  width: 30%; /* 너비를 자동으로 조정 */
  max-width: 100%; /* 최대 너비를 화면의 90%로 조정 */
  height: auto; /* 높이를 자동으로 조정 */
  max-height: 100vh; /* 최대 높이를 뷰포트의 90%로 조정 */
  overflow-y: auto; /* 내부 콘텐츠가 넘칠 경우 스크롤바 생성 */
}

.button {
  display: block;
  width: 100%;
  padding: 10px;
  margin: 5px 0; /* 버튼 간 위아래 간격 조정 */
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
