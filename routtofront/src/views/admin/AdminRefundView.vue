// 관리자 환불 페이지
<template>
  <!-- 반품관리 배너 시작 -->
  <div
    class="container mt-5 RWD"
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
        class="input-box"
      />
      <button type="button" class="btn RBtn">주문조회</button>
    </label>
  </div>
  <!-- 반품관리 배너 끝 -->


  <!-- 조회기간 및 처리상태 박스 시작 -->
  <div
    class="container mt-4 RWD"
    style="
      border: 1px solid black;
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      height: auto;
      padding: 10px;
    "
  >
  <div class="sch">
    <div style="margin-left: 100px;">
      <span>조회기간:</span>
      <select class="slbox">
        <option selected>반품요청일</option>
        <option>수거완료일</option>
        <option>결제일</option>
      </select>
    </div>
    <div style="padding-right: 100px;">
      <span>상세조건:</span>
      <select class="slbox">
        <option selected>상세조건</option>
        <option>수취인명</option>
        <option>구매자명</option>
        <option>구매자 ID</option>
        <option>주문번호</option>
        <option>상품번호</option>
      </select>
    </div>
  </div>

    <!-- 기간 선택 버튼 시작 -->
    <div class="dur">
      <button class="period-btn" @click="setPeriod('day')">오늘</button>
      <button class="period-btn" @click="setPeriod('week')">일주일</button>
      <button class="period-btn" @click="setPeriod('month')">1개월</button>
      <button class="period-btn" @click="setPeriod('months')">3개월</button>
    </div>
    <!-- 기간 선택 버튼 끝 -->

    <!-- 기간 입력 필드 시작 -->
    <div class="cal">
      <div class="datepicker-container">
        <VueDatePicker
          locale="ko"
          :format="formatDate"
          :enable-time-picker="false"
          v-model="startDate"
          week-start="0"
          position="left"
          placeholder="시작 날짜 선택"
          auto-apply
          @input="onStartDateChange"
        />
      </div>

      <div class="datepicker-container">
        <VueDatePicker
          locale="ko"
          :format="formatDate"
          :enable-time-picker="false"
          v-model="endDate"
          week-start="0"
          position="left"
          :disabled-dates="disabledDates"
          placeholder="종료 날짜 선택"
          auto-apply
        />
      </div>
    </div>
    <!-- 기간 입력 필드 끝 -->

    <!-- 처리상태 -->
    <div
      style="
        margin-top: 10px;
        margin-left: 100px;
        display: flex;
        justify-content: flex-start;
        width: 100%;
      "
    >
      <span>처리상태:</span>
      <select class="slbox">
        <option>전체</option>
        <option>처리중</option>
        <option>처리완료</option>
        <option>처리불가</option>
      </select>
    </div>

    <!-- 검색 버튼 -->
    <div
      style="
        margin-top: 10px;
        width: 100%;
        display: flex;
        justify-content: center;
      "
    >
      <button class="btn RBtn" style="width: 100px;">검 색</button>
    </div>
  </div>
  <!-- 조회기간 및 처리상태 박스 끝 -->

  <!-- 목록 박스 시작 -->
  <div
    class="container mt-4 RWD"
    style="
      border: 1px solid black;
      display: flex;
      flex-direction: column;
      align-items: flex-start; /* 왼쪽 정렬을 위해 수정 */
      padding: 10px;
    "
  >
    <b style="align-self: flex-start">목록 (총 0개)</b>
    <!-- 왼쪽 정렬을 위해 수정 -->
    <hr style="width: 100%" />

   <!-- 버튼 그룹 시작 -->
<div style="display: flex; justify-content: space-between; width: 100%; margin-bottom: 20px;">
  <!-- 왼쪽 버튼 그룹 -->
  <div style="display: flex; gap: 10px">
    <div class="divider-style">
      <button class="button-style">반품처리 한번에 하기</button>
    </div>
    <div style="display: flex; gap: 10px">
      <button class="button-style">반품 완료처리</button>
      <button class="button-style">반품 거부(철회)처리</button>
      <button class="button-style">교환으로 변경</button>
    </div>
  </div>

  <!-- 오른쪽 버튼 그룹 -->
  <div style="display: flex; gap: 10px">
    <button class="button-style">구매확정 후 취소 처리 바로가기 ></button>
    <button class="button-style">판매자 직접 반품 접수 바로가기 ></button>
  </div>
</div>
<!-- 버튼 그룹 끝 -->

    <!-- 목록 태그 시작 -->
    <!-- 여기부터 표 부분 -->
    <div style="width: 100%; overflow-x: auto; margin-bottom: 20px">
      <!-- 아래쪽 간격 추가 -->
      <table style="width: 100%; border-collapse: collapse">
        <thead>
          <tr>
            <th class="datalist">선택</th>
            <!-- 글자 중앙 정렬 추가 -->
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
    class="container mt-4 RWD"
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
    class="container mt-4 RWD"
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
    class="container mt-4 mb-4 RWD"
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
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

export default {
  components: {
    VueDatePicker,
  },
  data() {
    return {
      startDate: null,
      endDate: null,
    };
  },
  methods: {
    handleDateInput(date) {
      // 사용자가 날짜를 선택하면 실행되는 메소드
      const formattedDate = this.formatDate(date);
      this.selectedDate = formattedDate;
    },
    formatDate(date) {
      // 날짜를 '년/월/일' 형식으로 포매팅하는 메소드
      const d = new Date(date);
      const year = d.getFullYear();
      const month = String(d.getMonth() + 1).padStart(2, "0");
      const day = String(d.getDate()).padStart(2, "0");
      return `${year}/${month}/${day}`;
    },
    onStartDateChange() {
      // 시작 날짜가 변경될 때마다 종료 날짜 초기화
      if (this.startDate > this.endDate) {
        this.endDate = null;
      }
    },
    setPeriod(period) {
      const today = new Date();
      let start = new Date();

      switch (period) {
        case "day":
          start = new Date();
          break;
        case "week":
          start.setDate(today.getDate() - 7);
          break;
        case "month":
          start.setMonth(today.getMonth() - 1);
          break;
        case "months":
          start.setMonth(today.getMonth() - 3);
          break;
        default:
          start = new Date();
      }

      this.startDate = start;
      this.endDate = today;
    },
  },
  computed: {
    disabledDates() {
      return (date) => {
        // 시작 날짜 이전의 모든 날짜 비활성화
        return date < this.startDate || date > this.currentDate;
      };
    },
  },
};
</script>

<style scoped>
.RWD {
  display: flex;
  flex-wrap: wrap; 
  justify-content: space-around;
  transition: width 0.3s ease;
  box-sizing: border-box;
}
.input-box {
  height: 35px; 
  margin-right: 10px;
  border: 1px solid #ccc; 
  padding: 0 10px; 
  color: black; 
}
.input-box:focus {
  outline: none;
  border-color: #342a26; 
}

@media (max-width: 600px) {
  .RWD {
    width: 90%;
  }
  .sch > div {
    width: 100%; 
    margin-bottom: 10px;
  }
}

@media (min-width: 601px) and (max-width: 1024px) {
  .RWD {
    width: 80%;
  }
  .sch > div {
    width: 48%;
  }
}

@media (min-width: 1025px) {
  .RWD {
    width: 100%;
  }
  .sch > div {
    width: auto;
  }
}

@media (max-width: 768px) {
  .sch > div {
    margin-left: 0;
    padding-right: 0;
    margin-bottom: 20px;
  }
  .dur, .cal{
    flex-direction: column;
    align-items: flex-start;
  }
  .period-btn, .datepicker-container {
    margin-bottom: 10px;
  }

  .period-btn, .datepicker-container {
    width: auto;
    margin-bottom: 10px;
  }
  
  .datepicker-container {
    max-width: 100%; 
  }
  
  .datepicker-container .vuejs-datepicker {
    width: 100%; 
  }
}

.datepicker-container {
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
}

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
  margin-right: 20px;
  flex-grow: 1;
  text-align: center;
}

.datalist {
  border: 1px solid black;
  padding: 10px;
  text-align: center;
}

.sch {
  margin-top: 10px;
  display: flex;
  justify-content: space-between;
  width: 100%;
  flex-wrap: wrap;
  box-sizing: border-box;
}

.sch > div {
  margin-left: 100px;
  padding-right: 100px; 
}

.slbox {
  margin-left: 10px;
  width: 150px;
}

.dur {
  margin-top: 10px;
  margin-left: 177px;
  display: flex;
  justify-content: flex-start;
  width: 100%;
}

.cal {
  margin-top: 10px;
  margin-left: 177px;
  display: flex;
  justify-content: space-between;
  gap: 20px;
  width: 400px;
}

.period-btn {
  padding: 10px 20px;
  background-color: white;
  border: 1px solid #ddd;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.3s;
  width: 100px;
  height: 30px;
  line-height: 10px;
}

.period-btn:hover {
  background-color: #f0f0f0;
  transform: translateY(-2px); 
}

.datepicker-container button {
  width: 100px; 
  height: 30px; 
}

.button-style {
  background-color: #5D4037;
  color: white;
  padding: 5px 10px;
  font-size: 14px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.button-style:hover {
  background-color: #4E342E;
}

.divider-style {
  display: flex;
  flex-direction: column;
  align-items: center;
  border-right: 1px solid #8D6E63;
  padding-right: 10px;
}
</style>
