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
      <button type="button" class="btn RBtn">주문조회</button>
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
        <img src="" alt="">
        일반주문 <input type="checkbox" name="전체" id="" />
      </label>
      <label class="chbox">
        오늘출발 <input type="checkbox" name="전체" id="" />
      </label>
      <label class="chbox">
        도착보장 <input type="checkbox" name="전체" id="" />
      </label>
    </div>
  </div>
  <!-- 주문 유형 선택 배너 끝 -->

  <!-- 반품/환불 상황 배너 시작 -->
  <div class="container mt-4" style="border: 1px solid black; display: flex; flex-direction: column; justify-content: space-around; align-items: center; height: auto; padding: 20px; box-sizing: border-box;">
    <div class="refbanner" style="display: flex; justify-content: space-between; width: 100%; align-items: center;">
      <div class="label" id="urgent" style="flex-grow: 1; text-align: left;">빠르게 확인해주세요 !</div>
      <div class="label" style="flex-grow: 1; text-align: center;">반품지연</div>
      <div class="label" style="flex-grow: 1; text-align: center;">자동 환불대기</div>
      <div class="label" style="flex-grow: 1; text-align: center;">환불보류</div>
      <div class="label" style="flex-grow: 1; text-align: center;">자동 수거요청 실패</div>
    </div>

    <hr style="width: 100%; margin: 20px 0;">

    <div class="refbanner" style="display: flex; justify-content: space-between; width: 100%; align-items: center;">
      <div class="label" id="urgent" style="flex-grow: 1; text-align: left;">반품처리를 진행해주세요.</div>
      <div class="label" style="flex-grow: 1; text-align: center;">반품요청</div>
      <div class="label" style="flex-grow: 1; text-align: center;">반품수거중</div>
      <div class="label" style="flex-grow: 1; text-align: center;">반품수거완료</div>
      <div class="label" style="flex-grow: 1; text-align: center;">반품완료(최근3일)</div>
    </div>   
  </div>
  <!-- 반품/환불 상황 배너 끝 -->

  <!-- 조회기간 및 처리상태 박스 시작 -->
<div class="container mt-4" style="border: 1px solid black; display: flex; flex-direction: column; align-items: flex-start; height: auto; padding: 10px;">

  <div style="display: flex; justify-content: space-between; width: 100%;">
    <!-- 조회기간과 반품요청일 -->
    <div>
      <span>조회기간:</span>
      <select>
        <option>반품요청일</option>
      </select>
    </div>
    <!-- 상세조건 -->
    <div>
      <span>상세조건:</span>
      <select>
        <option>전체</option>
        <!-- 추가 상세 조건 옵션 가능 -->
      </select>
    </div>
  </div>

  <!-- 기간 선택 버튼 -->
  <div style="margin-top: 10px; display: flex; justify-content: flex-start; width: 100%;">
    <button>오늘</button>
    <button>일주일</button>
    <button>1개월</button>
    <button>3개월</button>
    <button>6개월</button>
  </div>

  <!-- 기간 입력 필드 -->
  <div style="margin-top: 10px; display: flex; justify-content: flex-start; width: 100%;">
    <input type="text" placeholder="시작일 0000.00.00">
    <input type="text" placeholder="종료일 0000.00.00">
  </div>

  <!-- 처리상태 -->
  <div style="margin-top: 10px; display: flex; justify-content: flex-start; width: 100%;">
    <span>처리상태:</span>
    <select>
      <option>전체</option>
      <option>처리중</option>
      <option>처리완료</option>
      <option>처리불가</option>
    </select>
  </div>

  <!-- 검색 버튼 -->
  <div style="margin-top: 10px; width: 100%; display: flex; justify-content: center;">
    <button class="btn RBtn">검색</button>
  </div>
</div>
<!-- 조회기간 및 처리상태 박스 끝 -->

<!-- 목록 박스 시작 -->
<div
  class="container mt-4"
  style="
    border: 1px solid black;
    display: flex;
    flex-direction: column;
    align-items: flex-start; /* 왼쪽 정렬을 위해 수정 */
    padding: 10px;
  "
>
<b style="align-self: flex-start;">목록 (총 0개)</b> <!-- 왼쪽 정렬을 위해 수정 -->
<hr style="width: 100%;">

<!-- 버튼 그룹 시작 -->
<div style="display: flex; justify-content: space-between; width: 100%; margin-bottom: 20px;"> <!-- 아래쪽 간격 추가 -->
  <!-- 왼쪽 버튼 그룹 -->
  <div style="display: flex; gap: 10px;"> <!-- 간격 추가 -->
    <div style="display: flex; flex-direction: column; align-items: center; border-right: 1px solid lightgrey; padding-right: 10px;"> <!-- 세로 구분선 추가 -->
      <button>반품처리 한번에 하기</button>
    </div>
    <div style="display: flex; gap: 10px;"> <!-- 버튼 간 간격 추가 -->
      <button>반품 완료처리</button>
      <button>반품 거부(철회)처리</button>
      <button>교환으로 변경</button>
    </div>
  </div>

  <!-- 오른쪽 버튼 그룹 -->
  <div style="display: flex; gap: 10px;"> <!-- 간격 추가 -->
    <button>구매확정 후 취소 처리 바로가기 ></button>
    <button>판매자 직접 반품 접수 바로가기 ></button>
  </div>
</div>
<!-- 버튼 그룹 끝 -->

<!-- 목록 태그 시작 -->
  <!-- 여기부터 표 부분 -->
  <div style="width: 100%; overflow-x: auto; margin-bottom: 20px;"> <!-- 아래쪽 간격 추가 -->
    <table style="width: 100%; border-collapse: collapse;">
      <thead>
        <tr>
          <th class="datalist">선택</th> <!-- 글자 중앙 정렬 추가 -->
          <th class="datalist">상품주문번호</th>
          <th class="datalist">주문번호</th>
          <th class="datalist">주문상태</th>
          <th class="datalist">배송속성</th>
          <th class="datalist">반품 처리상태</th>
          <th class="datalist">수거방법</th>
          <th class="datalist">수거상황</th>
        </tr>
      </thead>
      <tbody>
      <!-- 임시 데이터 추가 -->
      <tr>
        <td class="datalist">✓</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
        <td class="datalist">20240422-ABCD1234ABCD1234ABCD1234</td>
      </tr>
      </tbody>
    </table>
  <!-- 여기까지 표 부분 -->
</div>
<!-- 목록 태그 끝 -->

</div>
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
        <button type="button" class="btn RBtn" style="margin-left: 10px">
          수거 완료 처리
        </button>
        <button type="button" class="btn RBtn" style="margin-left: 10px">
          반품 완료 처리
        </button>
        <button type="button" class="btn RBtn" style="margin-left: 10px">
          반품 거부(철회) 처리
        </button>
        <button type="button" class="btn RBtn" style="margin-left: 10px">
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
        <button type="button" class="btn RBtn" style="margin-left: 10px">
          환불 보류 설정
        </button>
        <button type="button" class="btn RBtn" style="margin-left: 10px">
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
        <button type="button" class="btn RBtn" style="margin-left: 10px">
          반품 사유 수정
        </button>
        <button type="button" class="btn RBtn" style="margin-left: 10px">
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

<style scoped>
.RBtn {
  background-color: #342a26;
  color: white;
}

.chbox {
  margin-left: 20px;
}

.refbanner {
  display: flex;
  flex-direction: row;
  align-items: center;
}
.label {
  margin-right: 20px; /* 라벨 간 간격 */
}
#urgent {
  margin-right: 40px; /* '빠르게 확인해주세요 !'와 다음 라벨 간의 간격 */
}

.datalist {
  border: 1px solid black;
  padding: 10px;
  text-align: center;
}
</style>
