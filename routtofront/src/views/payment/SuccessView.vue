<template>
  <!-- 결제 성공 시 -->
  <section v-if="confirmed">
    <div class="box_section" style="width: 600px">
      <img
        style="width: 100px"
        src="https://static.toss.im/illusts/check-blue-spot-ending-frame.png"
      />
      <h2>결제를 완료했어요</h2>

      <div class="p-grid typography--p" style="margin-top: 50px">
        <div class="p-grid-col text--left"><b>결제금액</b></div>
        <div class="p-grid-col text--right" id="price">
          {{ jsonData.totalAmount }}원
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>주문번호</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData.orderId }}
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>결제 요청 시간</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData.requestedAt }}
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>결제 승인 시간</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData.approvedAt }}
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>결제 수단</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData.method }}
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>카드?</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData.card }}
        </div>
      </div>
      <div class="p-grid typography--p" style="margin-top: 10px">
        <div class="p-grid-col text--left"><b>테스트</b></div>
        <div class="p-grid-col text--right" id="orderId">
          {{ jsonData }}
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { confirmPayment } from "@/services/payment/confirmPayment";
import PaymentService from "@/services/payment/PaymentService";

export default {
  data() {
    return {
      requestData: {
        orderId: this.$route.query.orderId, // 쿼리스트링 방식
        amount: this.$route.query.amount, // 쿼리스트링 방식
        paymentKey: this.$route.query.paymentKey, // 쿼리스트링 방식 , 필수
      },
      confirmed: false,
      jsonData: null,
    };
  },
  methods: {
    // TODO: 토스 결재 함수
    async confirm() {
      try {
        const { response, json } = await confirmPayment(this.requestData);
        console.log(json);
        if (!response.ok) {
          // TODO: 결재 실패시 이동
          this.$router.push(`/fail?message=${json.message}&code=${json.code}`);
        } else {
          // TODO: 결재 성공시 테이블 저장
          this.confirmed = true;
          this.jsonData = json;

          // 결재 테이블 저장
          this.confirmApproval();
        }
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 결제 저장 함수
    async confirmApproval() {
      try {
        // 임시 객체
        let data = {
          paymentCode: null, // 결재번호
          orderId: this.$route.query.orderId, // 주문번호
          paymentType: this.jsonData.method,
          totalPrice: this.jsonData.totalAmount, // 주문금액(결재금액)
          payPg: this.jsonData.easyPay.provider,
          approveTime: this.jsonData.approvedAt, // 승인시간
          payTime: this.jsonData.requestedAt, // 결제일
        };

        console.log("confirmApproval", data);

        // 1) 주문 테이블에 데이터 수정
        let response = await PaymentService.create(data);
        this.payment = response.data;
        console.log(response.data);

        // alert("결제가 완료되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    this.confirm();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Payment/tosspay.css";
</style>
