// 주문 완료 페이지
<template>
  <main class="mt-5">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <h1 class="text-center mb-3">주문완료</h1>
          <div
            class="col-md-8 container"
            style="display: flex; justify-content: center"
          >
            <img :src="ordercompleteimg" style="width: 60px; height: auto" />
          </div>
          <div
            class="col-md-8 mt-2 container"
            style="display: flex; justify-content: center; text-align: center"
          >
            <p>고객님의 주문이 <br />정상적으로 완료되었습니다.</p>
          </div>
          <div
            class="mb-3 row"
            style="
              display: flex;
              justify-content: space-between;
              border: 1px solid black;
            "
          >
            <label class="col-md-3 col-form-label">주문번호 :</label>
            <label class="col-md-3 col-form-label" style="text-align: right">{{
              data.orderId
            }}</label>
          </div>
          <div
            class="mb-3 row"
            style="
              display: flex;
              justify-content: space-between;
              border: 1px solid black;
            "
          >
            <label class="col-md-3 col-form-label">주문금액 :</label>
            <label
              class="col-md-3 col-form-label"
              style="text-align: right"
              id="odid"
              >{{ data.orderPrice }} 원</label
            >
          </div>
          <div class="mb-3 row" style="border: 1px solid black">
            <div class="col-md-2 mb-3" style="border-bottm: 1px solid black;">
              결제수단
            </div>
            <!-- <label class="col-md-2 col-form-label" style="border-bottm: 1px solid black;">결제수단</label> -->
            <div>
              <label class="col-md-2 col-form-label">결제수단</label>
              <label class="col-md-10 col-form-label">{{
                data.paymentType
              }}</label>
            </div>
            <!-- 결제수단 : 계좌이체 -->
            <div class="mb-3 row" v-if="data.paymentType === '계좌이체'">
              <label class="col-md-2 col-form-label">입금자명</label>
              <label class="col-md-10 col-form-label">{{
                data.depositor
              }}</label>
            </div>
            <div class="mb-3 row" v-if="data.paymentType === '계좌이체'">
              <label class="col-md-2 col-form-label">입금은행</label>
              <label class="col-md-10 col-form-label">{{ data.bank }}</label>
            </div>

            <!-- 결제수단 : 카드 결제 -->
            <div class="mb-3 row" v-if="data.paymentType === '카드 결제'">
              <label class="col-md-3 col-form-label">카드사명</label>
              <label class="col-md-9 col-form-label">{{
                data.payPg
              }}</label>
            </div>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">결제 금액</label>
            <label class="col-md-9 col-form-label">원</label>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">받으시는 분</label>
            <label class="col-md-9 col-form-label"> </label>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">배송지</label>
            <label class="col-md-9 col-form-label"></label>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">휴대폰번호</label>
            <label class="col-md-9 col-form-label"></label>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">요청사항</label>
            <label class="col-md-9 col-form-label"></label>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">주문처리상태</label>
            <div class="col-md-9">
              <select class="form-select">
                <option :key="i" v-for="(status, i) in statusList">
                  {{ status.status }}
                </option>
              </select>
            </div>
          </div>
          <div class="mb-3 row">
            <label class="col-md-3 col-form-label">운송장번호</label>
            <div class="col-md-9">
              <input type="text" class="form-control" />
            </div>
          </div>
          <div class="row mt-5">
            <div class="d-flex justify-content-between align-items-center">
              <div class="col-6 d-grid p-1">
                <button type="button" class="btn btn-lg btn-outline-dark">
                  CANCEL
                </button>
              </div>
              <div class="col-6 d-grid p-1" id="sex">
                <button type="button" class="btn btn-lg btn-outline-dark">
                  SAVE
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  data() {
    return {
      data: {
        // 주문 정보를 저장할 객체
        orderId: "",
        orderPrice: "",
        paymentType: "",
        bank: "",
        depositor: "",
        payPg: "",
      },
      OrderedList: [], // 주문 상품 객체 배열
      ordercompleteimg: require("../assets/images/ordercomplete_icon.png"),
    };
  },
  methods: {
    retrieveOrder() {
      // API 요청 등을 통해 주문번호와 주문금액을 조회하는 로직 구현
      // 예시를 위해 임시 데이터 사용
      let retrievedData = {
        orderId: "123456789",
        orderPrice: "45000",
        paymentType: "카드 결제",
        bank: "국민은행",
        depositor: "공민식",
        payPg: "토스뱅크카드",
      };

      // 조회된 데이터를 data 객체에 저장
      this.data.orderId = retrievedData.orderId;
      this.data.orderPrice = retrievedData.orderPrice;
      this.data.paymentType = retrievedData.paymentType;
      this.data.bank = retrievedData.bank;
      this.data.depositor = retrievedData.depositor;
    },
  },
  created() {
    this.retrieveOrder(); // 컴포넌트 생성 시 주문 정보 조회
  },
};
</script>

<style></style>
