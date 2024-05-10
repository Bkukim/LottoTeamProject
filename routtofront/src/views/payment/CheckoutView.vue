<template>
  <div class="wrapper modal-overlay" v-if="isModalVisible">
    <div class="box_section modal-content">
      <div id="payment-method"></div>
      <div id="agreement"></div>
      <!-- 결제하기 버튼 -->
      <button
        :disabled="!inputEnabled"
        @click="requestPayment"
        class="button payment-button"
        id="payment-button"
      >
        결제하기
      </button>
      <!-- 닫기 버튼 -->
      <button @click="closeModal" class="button close-button" id="close-button">
        닫기
      </button>
    </div>
  </div>
</template>

<script>
// import { loadPaymentWidget, ANONYMOUS } from "@tosspayments/payment-widget-sdk";
// // import PaymentService from '@/services/payment/PaymentService';
// import OrderService from '@/services/product/OrderService';

// export default {
//   data() {
//     return {
//       order: null, // 주문 정보 객체

//       paymentWidget: null,
//       paymentMethodWidget: null,
//       // TODO: clientKey는 개발자센터의 결제위젯 연동 키 > 클라이언트 키로 바꾸세요.
//       // TODO: customerKey는 구매자와 1:1 관계로 무작위한 고유값을 생성하세요.
//       clientKey: "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm",
//       customerKey: this.$route.params.orderId,
//       amount: 50000,
//       inputEnabled: false,
//       isModalVisible: true,
//     };
//   },
//   methods: {
//     // TODO: 주문 상세 조회
//     async retrieveOrder(orderId) {
//       try {
//         let response = await OrderService.get(orderId);
//         this.order = response.data;

//         console.log(response.data);
//       } catch (e) {
//         console.log(e);
//       }
//     },
//     // TODO: 토스 API 결제
//     async requestPayment() {
//       try {
//           if (this.paymentWidget) {
//           // TODO: 결재 요청 임시 정보
//           let data = {
//             orderId: this.$route.params.orderId,                // TODO: 주문번호(6자리이상이어야함), 필수
//             orderName: "테스트 이름",                           // 필수
//             successUrl: `${window.location.origin}/success`, // 성공 url, 필수
//             failUrl: `${window.location.origin}/fail`,       // 실패 url, 필수
//           };
//           console.log(data);
//           // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
//           // 결제를 요청하기 전에 orderId, amount를 서버에 저장하세요.
//           // 결제 과정에서 악의적으로 결제 금액이 바뀌는 것을 확인하는 용도입니다.
//           // @docs https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
//           await this.paymentWidget.requestPayment(data);
//         }
//       } catch (error) {
//         console.error(error);
//       }
//     },
//     closeModal() {
//       this.isModalVisible = false;
//     },
//   },
//   async mounted() {
//     console.log(this.order);
//     // TODO: 주문조회 : 비동기로 실행
//     await this.retrieveOrder(this.$route.params.orderId);

//     // TODO: 토스 API ------  결제위젯 초기화 ------
//     // @docs https://docs.tosspayments.com/reference/widget-sdk#sdk-설치-및-초기화
//     this.paymentWidget = await loadPaymentWidget(this.clientKey, ANONYMOUS);

//     // TODO: 토스 API ------  결제 UI 렌더링 ------
//     // @docs https://docs.tosspayments.com/reference/widget-sdk#renderpaymentmethods선택자-결제-금액-옵션
//     this.paymentMethodWidget = this.paymentWidget.renderPaymentMethods(
//       "#payment-method",
//       { value: this.order.orderPrice },
//       { variantKey: "DEFAULT" }
//     );

//     // TODO: 토스 API ------  이용약관 UI 렌더링 ------
//     // @docs https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자-옵션
//     this.paymentWidget.renderAgreement("#agreement", {
//       variantKey: "AGREEMENT",
//     });

//     // TODO: 토스 API  
//     this.paymentMethodWidget.on("ready", () => {
//       this.inputEnabled = true;
//     });
//   },
// };
import { loadPaymentWidget, ANONYMOUS } from "@tosspayments/payment-widget-sdk";
import OrderService from '@/services/product/OrderService';

export default {
    props: ['orderInfo'],
  data() {
    return {
      order: null, // 주문 정보 객체

      paymentWidget: null,
      paymentMethodWidget: null,
      clientKey: "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm",
      customerKey: this.$route.params.orderId,
      amount: 50000,
      inputEnabled: false,
      isModalVisible: true,
    };
  },
  methods: {
    // async retrieveOrder(orderId) {
    //   try {
    //     console.log("주문정보", orderId)
    //     let response = await OrderService.get(orderId);
    //     this.order = response.data;
    //     console.log(response.data);
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    // async requestPayment() {
    //   try {
    //     if (this.paymentWidget) {
    //       let data = {
    //         orderId: this.$route.params.orderId,
    //         orderName: this.order.orderName || "테스트 이름",
    //         successUrl: `${window.location.origin}/success`,
    //         failUrl: `${window.location.origin}/fail`,
    //       };
    //       console.log(data);
    //       await this.paymentWidget.requestPayment(data);
    //     }
    //   } catch (error) {
    //     console.error(error);
    //   }
    // },
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
    closeModal() {
      this.isModalVisible = false;
    },
  },
  async mounted() {
    await this.retrieveOrder(this.$route.params.orderId);
    this.paymentWidget = await loadPaymentWidget(this.clientKey, ANONYMOUS);
    this.paymentMethodWidget = this.paymentWidget.renderPaymentMethods(
      "#payment-method",
      { value: this.orderInfo.orderPrice },
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
