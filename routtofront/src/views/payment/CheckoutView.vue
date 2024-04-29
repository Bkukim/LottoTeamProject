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

      // 무통장 입금 선택시 생성된 계좌번호 저장할 
      bankAccountNumber: '', // 계좌번호를 저장할 새로운 데이터 속성 추가
      isBankTransfer: false, // 무통장 입금 여부를 저장할 새로운 데이터 속성 추가
    };
  },
  methods: {
async requestPayment() {
  try {
    const orderId = nanoid();
    const response = await this.paymentWidget.requestPayment({
      orderId,
      orderName: "토스 티셔츠 외 2건",
      customerName: "김토스",
      customerEmail: "asdasd@a.com",
      customerMobilePhone: "01011111111",
      successUrl: `${window.location.origin}/order/completed`,
      failUrl: `${window.location.origin}/order/fail`,
    });

    // 결제 성공 후 응답에서 무통장 입금 계좌번호 추출
    if (response.paymentMethod === '가상계좌') {
      this.bankAccountNumber = response.bankAccountNumber; // 계좌번호 저장
      this.isBankTransfer = true; // 무통장 입금 선택됨을 표시
    }

    // 결제 성공 후 OrderComView.vue로 리디렉션하고 필요한 데이터를 query로 전달
    this.$router.push({
      name: 'OrderComView', // Vue Router에 정의된 경로의 이름
      query: {
        orderId: orderId,
        paymentMethod: response.paymentMethod,
        bankAccountNumber: response.paymentMethod === '가상계좌' ? response.bankAccountNumber : null,
      },
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
