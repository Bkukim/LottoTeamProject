<template>
  <div class="container refund-div">
    <div class="container text-center">
      <label>취소사유를 선택해주세요</label>
    </div>
    <div class="container col-md-8 inner">
  <div class="radio-option">
    <input type="radio" id="option1" class="radiobtn" name="radio" value="상품이 마음에 들지 않음 (단순 변심)" v-model="selectedOption" />
    <label for="option1" class="lab">상품이 마음에 들지 않음 (단순 변심)</label>
  </div>
  <div class="divider"></div> <!-- 구분선 추가 -->
  <div class="radio-option">
    <input type="radio" id="option2" class="radiobtn" name="radio" value="다른 상품 추가 후 재주문 예정" v-model="selectedOption" />
    <label for="option2" class="lab">다른 상품 추가 후 재주문 예정</label>
  </div>
</div>
    <!-- 버튼 태그 시작 -->
    <div class="buttons">
      <button class="btn prev" @click="goToMyPage">{{ "< 이전단계" }}</button>
      <button class="btn next" @click="goToRefundInfo">{{ "다음단계 >" }}</button>
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedOption: null, // 라디오 버튼 선택값을 저장할 데이터 속성
    }
  },
  methods: {
    goToMyPage() {
      this.$router.push('/mypage');
    },
    // 환불 정보 확인 페이지로 이동
    goToRefundInfo() {
      this.$router.push({ name: 'refund-info', params: { selectedOption: this.selectedOption } });
      // this.$store.dispatch('updateSelectedOption', this.selectedOption); // 라디오 버튼선택값 저장
      // this.$router.push('/order/refund-info'); // 동시에 페이지 이동
    }
  },
};
</script>

<style>
.refund-div {
  width: 800px;
  height: 600px;
  border: 1px solid black;
  border-radius: 10px;
  background-color: whitesmoke;
  margin-top: 50px;
  margin-bottom: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.text-center {
    margin-top: -20px;
  text-align: center;
  font-weight: bold;
  font-size: 20px;
  width: 100%;
}

.radio-option {
  margin-left: 20px;
  padding: 10px 0;
}

.divider {
  height: 1px;
  background-color: #ccc; /* 옅은 회색 구분선 */
  width: 100%;
  margin: 0 auto; /* 중앙 정렬 */
}

.lab {
    margin-left: 10px;
    font-size: 18px;
}

.radiobtn {
  transform: scale(1.5); /* 1.5배로 확대 */
  margin: 10px; /* 주변과의 거리를 조정 */
}

.buttons {
  display: flex;
  justify-content: space-between;
  margin-top: 30px;
  width: 100%; /* 부모 요소의 가로 길이에 맞추기 */
  max-width: 600px; /* Bootstrap의 col-md-8에 해당하는 최대 가로 길이 */
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
  .refund-div,
  .inner {
    width: 100%; /* 화면의 너비에 맞춰 조절 */
    margin-top: 20px;
    margin-bottom: 20px;
  }
}

@media (max-width: 768px) {
  /* 모바일 */
  .refund-div,
  .inner {
    width: 100%; /* 화면의 너비에 맞춰 조절 */
    margin-top: 10px;
    margin-bottom: 10px;
  }
}
</style>
