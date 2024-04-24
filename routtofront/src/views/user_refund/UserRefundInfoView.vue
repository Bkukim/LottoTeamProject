<template>
  <div class="container col-md-8 mt-5" style="text-align: center">
    <h3>취소 신청</h3>
  </div>
  <div class="container refundInfo-div">
    <div class="container col-md-8 inner">
      <!-- 선택한 상품 정보 표시 -->
      <div class="container mt-3 mb-3">
        <h4>선택한 상품 1 건</h4>
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

      <!-- 선택한 사유 표시 -->
      <h5>선택한 사유</h5>
      <div>{{ selectedOption }}</div>
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
          <span>상품금액</span>
          <span>원</span>
        </div>
        <div class="refInfo">
          <span>즉시할인</span>
          <span>원</span>
        </div>
        <div class="refInfo">
          <span>배송비</span>
          <span>원</span>
        </div>
        <div class="refInfo">
          <span>반품비</span>
          <span>원</span>
        </div>
      </div>
      <div class="divider"></div>
      <!-- 구분선 추가 -->
      <div>
        <div class="mb-2 mt-2 refInfo">
          <span style="font-size: 20px; font-weight: bold">환불 예상금액</span>
          <span style="color: red; font-weight: bold">원</span>
        </div>
        <div class="refInfo">
          <span>환불수단</span>
          <span>{{ refundWay }} 10,000 원</span>
        </div>
      </div>
    </div>
    <!-- 버튼 태그 시작 -->
    <div class="buttons">
      <button class="btn prev" @click="goBack">{{ "< 이전단계" }}</button>
      <button class="btn next" @click="showPopup">{{ "신청하기" }}</button>
      <RefundPopup v-if="isPopupVisible" @close="isPopupVisible = false" />
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>
<script>
import RefundPopup from './RefundPopup.vue';

export default {
  components: {
    RefundPopup,
  },
  data() {
    return {
      // 예시 데이터
      prodName: "의자",
      prodCount: "1",
      prodAmount: "50,000",

      refundWay: "토스뱅크카드 / 일시불 ",

      selectedOption: this.$route.params.selectedOption,

      // 팝업창 표시 여부 제어 속성  
      isPopupVisible: false,
    };
  },
  methods: {
    goBack() {
      this.$router.push("/order/refund-request");
    },
    showPopup() {
      this.isPopupVisible = true; // 팝업창을 띄우는 메소드
    }
  },
};
</script>

<style>
.refundInfo-div {
  width: 1000px;
  height: 800px;
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
  align-items: flex-start; /* 상단 정렬 */
}

.product-image {
  height: 100px; /* 이미지 높이 고정 */
  width: auto; /* 이미지 비율 유지 */
}

.product-details {
  display: flex;
  flex-direction: column;
  justify-content: center; /* 세로 방향 중앙 정렬 */
  padding-left: 12px; /* 이미지와 텍스트 사이 간격 */
}

/* 선택적: 상품 정보 텍스트 스타일 조정 */
.product-details h5,
.product-details p {
  margin: 0; /* 상하 간격 제거 */
  padding: 2px 0; /* 필요시 적절한 간격 추가 */
}

.refInfo {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.divider {
  height: 1px;
  background-color: #ccc; /* 옅은 회색 구분선 */
  width: 100%;
  margin: 0 auto; /* 중앙 정렬 */
}

.buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 30px;
  width: 80%; /* 부모 요소의 가로 길이에 맞추기 */
  max-width: 750px;
  margin-left: auto; /* 가로 중앙 정렬을 위해 */
  margin-right: auto; /* 가로 중앙 정렬을 위해 */
}

.btn {
  flex-grow: 1;
  padding: 10px 20px; /* 버튼 내부의 패딩을 조정하여 크기를 키움 */
  font-size: 16px; /* 글자 크기를 키움 */
  margin: 0 10px; /* 버튼들 사이의 간격을 지정 */
  cursor: pointer; /* 마우스 오버 시 커서 변경 */
  border: 1px solid #ccc; /* 테두리 스타일 지정 */
  transition: background-color 0.3s ease; /* 배경색 변경 시 애니메이션 효과 */
}

.prev {
  background-color: #ffffff;
  color: #000000;
}

.next {
  background-color: #808080;
  color: #ffffff;
}

.prev:hover {
  background-color: #e6e6e6; /* 이전단계 버튼의 배경색을 마우스 오버 시 더 어둡게 */
}

.next:hover {
  background-color: #666666; /* 다음단계 버튼의 배경색을 마우스 오버 시 더 어둡게 */
}

.inner {
  border: 1px solid black;
  border-radius: 10px;
  background-color: white;
  margin-top: 25px;
  width: 75%;
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
