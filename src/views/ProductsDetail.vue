<template>
  <div class="container mt-5">
    <h1 class="mt-4">Product</h1>
    <hr />

    <br />
    <br />
    <br />

    <div class="row">
      <!-- 왼쪽 -->
      <div class="col-sm-6">
        <img :src="image" alt="example" />

        <!-- 1. 평점 별점 -->
        <div class="box mt-5 text-center">
          <h2>평점 별점</h2>
        </div>
        <!-- 2. 리뷰 -->
        <div class="box mt-5 text-center">
          <h2>리뷰</h2>
        </div>
      </div>

      <div class="col-sm-1"></div>
      <!-- 오른쪽 -->
      <div class="col-sm-5">
        <!-- 1. 상품 이름 -->
        <div id="name">
          <h2>상품 이름</h2>
        </div>

        <!-- 2. 상품 설명 -->
        <h4 class="mt-3">
          상품 설명 : 피부에 완벽 밀착되는 내추럴 에어핏 피팅으로 자연스럽고
          매끄러운 피부 연출이 가능한 스틱 파운데이션
        </h4>

        <!-- 3. 상품 원가 -->
        <div class="mt-4">
          <h4><del>원가</del></h4>
        </div>

        <!-- 4. 상품 최종가 -->
        <div id="price">
          <h4>상품 가격 :</h4>
        </div>

        <hr />

        <!-- 5. 드롭다운 시작 -->
        <div class="dropdown mt-3">
          <!-- 1) 드롭다운 이름 -->
          <button
            class="btn dropdown-toggle btn-lg"
            type="button"
            data-bs-toggle="dropdown"
            id="btn1"
          >
            Choose option
          </button>

          <!-- 2) 드롭다운 메뉴 -->
          <ul class="dropdown-menu">
            <li><a class="dropdown-item">option 1</a></li>
            <li><hr class="dropdown-divider" /></li>
            <li><a class="dropdown-item">option 2</a></li>
            <li><hr class="dropdown-divider" /></li>
            <li><a class="dropdown-item">option 3</a></li>
          </ul>
        </div>
        <!-- 드롭다운 끝 -->

        <hr />

        <!-- 6. 총 상품 금액 -->
        <div id="total">
          <h4>총 상품 금액 :</h4>
        </div>

        <!-- 7. 버튼 -->
        <div class="mt-5">
          <button type="button" id="btn2">장바구니</button>

          <button type="button" id="btn3">주문하기</button>
        </div>
      </div>
    </div>

    <!-- 상세 페이지 -->
    <div class="mt-5">
      <div id="page">
        <h2>상세 페이지</h2>
      </div>
    </div>
    <!-- 상세 페이지 끝 -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      image: require("@/assets/images/skincare.jpg"),
    };
  },
};
</script>

<style>
.box {
  background-color: antiquewhite;
  max-width: 100%;
  height: 3vw;
  border: 5px solid #342a26;
  /* padding: 1vw; */
}

#name {
  background-color: antiquewhite;
  height: 5vw;
  border: 5px solid #342a26;
}

#page {
  background-color: #342a26;
  color: white;
  height: 40vw;
}

#price {
  background-color: antiquewhite;
  width: 16vw;
  height: vw;
  border: 5px solid #342a26;
  padding: 0.5vx;
}

.dropdown {
  position: relative;
}

.dropdown-menu {
  position: absolute;
  display: none;
  min-width: 100%; /* 드롭다운 메뉴의 최소 너비를 100%로 설정 */
  z-index: 1000;
}

#total {
  background-color: antiquewhite;
  height: 5vw;
  border: 5px solid #342a26;
  padding: 0.5vw;
  z-index: 0;
}

#btn1 {
  background-color: antiquewhite;
  width: 100%;
  height: 3vw;
  border: 5px solid #342a26;
}

#btn2 {
  background-color: antiquewhite;
  width: 12vw;
  height: 4vw;
  border: 5px solid #342a26;
  margin-right: 1.5vw;
}

#btn3 {
  background-color: antiquewhite;
  width: 12vw;
  height: 4vw;
  border: 5px solid #342a26;
}
</style>
