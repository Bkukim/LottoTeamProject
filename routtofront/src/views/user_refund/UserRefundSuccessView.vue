<template>
  <div class="container col-md-8 mt-5" style="text-align: center">
    <h3>취소 신청</h3>
  </div>
  <div class="container refundInfo-div">
    <div class="container col-md-8 mt-4" style="text-align: center">
      <label style="font-size: 25px; font-weight: bold"
        >환불 신청이 완료되었습니다.</label
      >
    </div>
    <div class="container col-md-8 inner">
      <!-- 선택한 상품 정보 표시 -->
      <div class="container mt-3 mb-3">
        <h4>취소 상품 1 건</h4>
      </div>
      <div class="product-info d-flex align-items-center">
        <img
          src="https://via.placeholder.com/100"
          alt="product-image"
          class="product-image"
        />
        <div class="product-details ml-3">
          <h5>{{ prodName }}</h5>
          <p>{{ prodCount }}개</p>
          <p>금액: {{ prodAmount }}원</p>
        </div>
      </div>

      <!-- 옅은 구분선 -->
      <hr />

      <!-- 환불 예정일 -->
      <div class="refund-info">
        <label class="refund-label">환불 예정일</label>
        <label class="refund-date" style="color: green;"
          >평일 3~7일 이내</label
        >
      </div>

      <!-- 옅은 구분선 -->
      <hr />

      <!-- 환불 수단 -->
      <div class="refund-info">
        <label class="refund-label">환불 수단</label>
        <label class="refund-date" style="margin-left: 15px;"
          >신용카드/체크카드</label
        >
      </div>
    </div>

    <!-- 버튼 태그 시작 -->
    <div class="buttons">
      <button class="btn prev" @click="goToMyPage">
        {{ "신청내역 확인하기" }}
      </button>
      <button class="btn next" @click="goToHome">{{ "쇼핑 계속하기" }}</button>
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      // 예시 데이터
      prodName: "의자",
      prodCount: "1",
      prodAmount: "50,000",

      refundWay: "토스뱅크카드 / 일시불 ",
    };
  },
  methods: {
    goToMyPage() {
      this.$router.push("/member/mypage");
    },
    goToHome() {
      this.$router.push("/");
    },
  },
  mounted() {},
};
</script>

<style>
.refundInfo-div {
  width: 800px;
  height: 600px;
  border: 1px solid black;
  border-radius: 10px;
  background-color: whitesmoke;
  margin-top: 25px;
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

.refund-info {
  display: flex;
  align-items: center; /* 라벨 태그들을 div의 높이 중앙으로 위치시킴 */
  margin-top: 20px; /* 위쪽 간격 */
  margin-bottom: 20px; /* 아래쪽 간격 */
}

.refund-label {
  flex: 0 0 auto; /* 라벨의 크기가 내용에 따라 결정되도록 하고, 확장되지 않게 설정합니다. */
  margin-right: 20px; /* 라벨과 날짜/수단 사이의 간격을 조정합니다. 필요에 따라 값을 조정하세요. */
}

.refund-date {
  flex-grow: 1;
  font-size: 20px;
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
