// 관리자 환불 페이지
<template>
  <!-- 카테코리 선택 배너 -->
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
    <label><b>카테고리</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <select class="" aria-label="Default select example">
        <option selected>스킨케어</option>
        <option value="1">메이크업</option>
        <option value="2">바디</option>
        <option value="3">헤어</option>
      </select>
    </label>
  </div>
  <!-- 카테코리 배너 끝 -->

  <!-- 상품명 배너 시작 -->
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
    <label><b>상품명</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="상품명을 입력하세요"
        style="height: 35px; margin-right: 10px"
      />
    </label>
  </div>
  <!-- 상품명 배너 끝 -->

  <!-- 판매가 배너 시작 -->
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
    <label><b>판매가</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="판매가를 입력하세요"
        style="height: 35px; margin-right: 10px"
      />원
    </label>
  </div>
  <!-- 판매가 배너 끝 -->

  <!-- 할인율 배너 시작 -->
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
    <label><b>할인율</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="할인율을 입력하세요"
        style="height: 35px; margin-right: 10px"
      />%
    </label>
  </div>
  <!-- 할인율 배너 끝 -->

  <!-- 할인가 배너 시작 -->
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
    <label><b>할인율 적용가</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      원
    </label>
  </div>
  <!-- 할인가 배너 끝 -->

  <!-- 재고 배너 시작 -->
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
    <label><b>재고 수량</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="재고 수량을 입력하세요"
        style="height: 35px; margin-right: 10px"
      />개
    </label>
  </div>
  <!-- 재고 배너 끝 -->

  <!-- 옵션 배너 시작 -->
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
    <label><b>옵션 입력</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="옵션을 입력하세요"
        style="height: 35px; margin-right: 10px"
      />
    </label>
  </div>
  <!-- 옵션 배너 끝 -->

  <!-- 이미지 추가 배너 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      height: auto;
    "
  >
    <label><b>사진 추가</b> </label>
    <div>
      <div id="img-add">
        <label class="mt-3 mb-3">이미지를 추가해주세요</label>
        <br />
        <div class="text-center">
          <button id="img-btn">
            <div class="text-center mb-2">
              <b>+</b>
            </div>
          </button>
        </div>
      </div>
    </div>
  </div>
  <!-- 이미지 추가 배너 끝 -->

  <!-- 상세페이지 추가 배너 시작 -->
  <div class="container mt-4" style="border: 1px solid black; height: auto">
    <label><b>상세 페이지</b> </label>
    <hr />
    <div class="container">
      <div class="row">
        <!-- 사이드 공간 -->
        <div class="col"></div>
        <!-- 분홍색 상자 -->
        <div class="col-10" id="detailFile">
          <!-- 첨부파일 -->
          <div id="file">
            <input type="file" ref="fileInput" style="display: none" />
          </div>
          <dvi class="container text-center">
            <button
              class="btn text-light btn-sm mt-4 log-form"
              id="addFile-btn"
            >
              파일추가
            </button>
          </dvi>
        </div>
        <!-- 사이드 공간 -->
        <div class="col"></div>
      </div>
    </div>
  </div>
  <!-- 이미지 추가 배너 끝 -->
  <div class="container text-center mt-5 mb-5">
    <div class="row">
      <div class="col"></div>
      
      <div class="col">
        <button class="btn text-light btn-sm mt-4 log-form" id="addFile-btn">
          저장
        </button>
        <button class="btn text-light btn-sm mt-4 log-form" id="addFile-btn">
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.searchBtn {
  background-color: #342a26;
  color: white;
}

.chbox {
  margin-left: 20px;
}
#img-btn {
  border: 1px solid black;
  width: 100px;
  height: 100px;
  font-size: 50px;
  margin-bottom: 40px;
}
#img-add {
  margin-right: 50px;
}
#detailFile {
  width: 58vw;
  height: auto;
  background-color: #f3eae8;
  margin: 2.6042vw;
}
#file {
  margin: 20px;
  min-height: 10vw;
}
#addFile-btn {
  width: 9.5313vw;
  height: 45px;
  background-color: #342a26;
  margin: 20px;
}
#save-btn {
  width: 9.5313vw;
  height: 45px;
  background-color: #342a26;
  margin: 20px;
}
#cancel-btn {
  width: 9.5313vw;
  height: 45px;
  background-color: #342a26;
  margin: 20px;
}
</style>
