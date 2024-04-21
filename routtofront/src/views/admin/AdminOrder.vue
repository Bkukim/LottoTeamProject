<template>
  <div class="container">
    <!-- 1) 주문 조회 배너 시작 -->
    <div
      class="container mt-5"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 50px;
      "
    >
      <label><b>주문 내역 검색</b></label>
    </div>
    <!-- 주문 조회 배너 끝 -->

    <!-- 1. 검색조건 시작 -->
    <div
      class="container mt-4"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 60px;
      "
    >
      <div
        style="
          display: flex;
          justify-content: space-between;
          align-items: center;
        "
      >
        <label id="category1"> 검색조건 </label>
        <label style="align-items: right" id="searchOpt">
          <!-- 주문번호/상품명 select box -->
          <select class="form-select" aria-label="Default select example">
            <option selected>주문번호</option>
            <option value="1">상품명</option>
          </select>
        </label>
        <div class="col">
          <input class="form-control" type="text" name="prodNum" />
        </div>
      </div>
    </div>
    <!-- 검색조건 끝 -->

    <!-- 2. 주문상태 시작 -->
    <div
      class="container mt-4"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 60px;
      "
    >
      <div
        style="
          display: flex;
          justify-content: space-between;
          align-items: center;
        "
      >
        <label id="category2"> 주문상태 </label>
        <label style="align-items: right" id="searchOpt">
          <!-- 주문번호/상품명 select box -->
          <select class="form-select" aria-label="Default select example" >
            <option selected>주문관리</option>
            <option value="1">상품명</option>
          </select>
        </label>
        <!-- 결제확인중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            결제확인중
          </label>
        </div>
        <!-- 결제확인 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            결제확인
          </label>
        </div>
        <!-- 상품준비중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            상품준비중
          </label>
        </div>
        <!-- 배송준비중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            배송준비중
          </label>
        </div>
        <!-- 배송중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            배송중
          </label>
        </div>
        <!-- 배송완료 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            배송완료
          </label>
        </div>
        <!-- 거래완료 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            거래완료
          </label>
        </div>
      </div>
    </div>
    <!-- 주문상태 끝 -->

    <!-- 3) 결제수단 시작 -->
    <div
      class="container mt-4"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 60px;
      "
    >
      <div
        style="
          display: flex;
          justify-content: space-between;
          align-items: center;
        "
      >
        <label id="salaryStatus1">결제 수단</label>
        <!-- 신용카드 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            신용카드
          </label>
        </div>
        <!-- PAYCO 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            PAYCO
          </label>
        </div>
        <!-- 카카오페이 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            카카오페이
          </label>
        </div>
        <!-- 네이버페이 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            네이버페이
          </label>
        </div>
        <!-- 휴대폰결제 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            휴대폰결제
          </label>
        </div>
        <!-- 계좌이체 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            계좌이체
          </label>
        </div>
        <!-- 토스페이 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status1">
            토스페이
          </label>
        </div>
      </div>
    </div>
    <!-- 결제수단 끝 -->

      <!-- 2. 검색/초기화 버튼 -->
  <div class="container text-center">
    <button
      type="button"
      class="text-light signUpBtn btn-sm mt-4"
      style="margin-left: 10px"
    >
      검색
    </button>
  </div>
  </div>
</template>
<script>
export default {};
</script>
<style>
#category1 {
  margin-right: 5vw;
}
#category2 {
  margin-right: 5vw;
}
#searchOpt {
  margin-right: 1vw;
}

#status1 {
  margin-right: 3vw;
}

#salaryStatus1{
    margin-right:5vw;
}
.signUpBtn {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
</style>
