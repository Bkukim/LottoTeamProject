// 관리자 환불 페이지
<template>
  <!-- 반품관리 배너 시작 -->
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
    <label><b>반품관리</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="상세조회 내용"
        style="height: 35px; margin-right: 10px"
      />
      <button type="button" class="btn searchBtn">주문조회</button>
    </label>
  </div>
  <!-- 반품관리 배너 끝 -->

  <!-- 주문 유형 선택 배너 시작 -->
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
    <div>
      주문 유형을 선택해주세요 !
      <label class="chbox">
        전체 <input type="checkbox" name="전체" id="" />
      </label>
      <label class="chbox">
        전체 <input type="checkbox" name="전체" id="" />
      </label>
      <label class="chbox">
        전체 <input type="checkbox" name="전체" id="" />
      </label>
      <label class="chbox">
        전체 <input type="checkbox" name="전체" id="" />
      </label>
      <label class="chbox">
        전체 <input type="checkbox" name="전체" id="" />
      </label>
    </div>
  </div>
  <!-- 주문 유형 선택 배너 끝 -->

  <!-- 반품/환불 상황 배너 시작 -->
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
    <div>
        <label for="">빠르게 확인해주세요 !</label>
    </div>
  </div>
  <!-- 반품/환불 상황 배너 끝 -->

  <!-- 조회기간 및 처리상태 박스 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 60px;
    "
  ></div>
  <!-- 조회기간 및 처리상태 박스 끝 -->

  <!-- 목록 박스 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 60px;
    "
  ></div>
  <!-- 목록 박스 끝 -->

  <!-- 반품처리 박스 시작 -->
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
      style="display: flex; justify-content: space-between; align-items: center"
    >
      <label> 반품 처리 </label>
      <label style="align-items: right">
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          수거 완료 처리
        </button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          반품 완료 처리
        </button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          반품 거부(철회) 처리
        </button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          교환으로 변경
        </button>
      </label>
    </div>
  </div>
  <!-- 반품처리 박스 끝 -->

  <!-- 환불보류 박스 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 60px;
    ">
    <div
      style="display: flex; justify-content: space-between; align-items: center"
    >
      <label> 환불 보류 </label>
      <label style="align-items: right">
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          환불 보류 설정
        </button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          환불 보류 해제
        </button>
      </label>
    </div>
  </div>
  <!-- 환불보류 박스 끝 -->

  <!-- 정보 수정 박스 시작 -->
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
      style="display: flex; justify-content: space-between; align-items: center"
    >
      <label> 정보 수정 </label>
      <label style="align-items: right">
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          반품 사유 수정
        </button>
        <button type="button" class="btn btn-primary" style="margin-left: 10px">
          수거 정보 수정
        </button>
      </label>
    </div>
  </div>
  <!-- 정보 수정 박스 끝 -->
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
</style>
