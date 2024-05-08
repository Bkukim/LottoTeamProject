// 관리자 환불 페이지
<template>
  <AdminHeaderCom />
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
    <label><b>반품관리</b></label>
    <label style="display: flex; align-items: center; height: 100%">
      <select v-model="searchType" style="margin-right: 10px">
        <option value="orderId">주문번호</option>
        <option value="orderTime">주문 일시</option>
        <option value="orderStatus">주문 상태</option>
        <option value="orderPrice">주문 가격</option>
      </select>
      <input
        type="text"
        placeholder="상세조회 내용"
        v-model="searchQuery"
        class="input-box"
      />
      <button type="button" class="btn RBtn" @click="searchOrders">
        주문조회
      </button>
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
      <div style="margin-left: 100px">
        <span>조회기간:</span>
        <select class="slbox">
          <option selected>반품요청일</option>

          <option>수거완료일</option>
          <option>결제일</option>
        </select>
      </div>
      <div style="padding-right: 100px">
        <span>상세조건:</span>
        <select class="slbox">
          <option selected>상세조건</option>
          <option>수취인명</option>
          <option>구매자명</option>
          <option>구매자 ID</option>
          <option>주문번호</option>
          <option>상품번호</option>
          <option>결제일</option>
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

    <!-- 검색 버튼 -->
    <div
      style="
        margin-top: 10px;
        width: 100%;
        display: flex;
        justify-content: center;
      "
    >
      <button class="btn RBtn" style="width: 100px">검 색</button>
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
      align-items: flex-start;
      padding: 10px;
    "
  >
    <b style="align-self: flex-start">목록</b>
    <!-- 왼쪽 정렬을 위해 수정 -->
    <hr style="width: 100%" />



    <!-- 목록 태그 시작 -->
    <!-- 여기부터 표 부분 -->
    <div style="width: 100%; overflow-x: auto; margin-bottom: 20px">
      <!-- 아래쪽 간격 추가 -->
      <table style="width: 100%; border-collapse: collapse">
        <thead>
          <tr>
            <!-- 글자 중앙 정렬 추가 -->
            <th class="datalist">주문번호</th>
            <th class="datalist">주문 일시</th>
            <th class="datalist">주문자명</th>
            <th class="datalist">수취인명</th>
            <th class="datalist">주문 가격</th>
            <th class="datalist">주문상태</th>
            <th class="datalist">상태 변경</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(data, index) in filteredOrders" :key="index">
            <td class="datalist">{{ data.orderId }}</td>
            <td class="datalist">{{ data.orderTime }}</td>
            <td class="datalist">{{ data.orderName }}</td>
            <td class="datalist">{{ data.receiver }}</td>
            <td class="datalist">{{ data.orderPrice }}</td>
            <td class="datalist">{{ data.orderStatus }}</td>
            <td class="datalist">
              <button class="button-style" @click="handleRefund(data.orderId)">
                환불 처리
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <!-- 여기까지 표 부분 -->
    </div>
    <!-- 목록 태그 끝 -->
  </div>
  <!-- 목록 박스 끝 -->
</template>

<script>
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";

import AdminRefundService from "@/services/admin/AdminRefundService";


export default {
  components: {
    VueDatePicker,
    AdminHeaderCom,
  },
  data() {
    return {
      // 달력 시작 날짜와 마지막 날짜 값 초기화
      startDate: null,
      endDate: null,

      searchQuery: "",
      searchType: "orderId", // 검색 유형 초기화
      filteredOrders: [],

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
    async searchOrders() {
      let response;
      // 검색 유형에 따라 적절한 함수 호출
      switch (this.searchType) {
        case "orderId":
          console.log(this.searchType);
          console.log(this.searchQuery);
          response = await AdminRefundService.findByOrderId(this.searchQuery);
          this.filteredOrders = response.data;
          console.log(response.data);
          break;
        case "orderTime":
          response = await AdminRefundService.findByOrderTime(this.searchQuery);
          this.filteredOrders = response.data;
          break;
        case "orderStatus":
          response = await AdminRefundService.findByOrderStatus(
            this.searchQuery
          );
          this.filteredOrders = response.data;
          break;
        case "orderPrice":
          response = await AdminRefundService.findByOrderPrice(
            this.searchQuery
          );
          this.filteredOrders = response.data;
          break;
      }
      // 결과를 filteredOrders에 저장
      if (response && response.data) {
        this.filteredOrders = response.data;
      } else {
        this.filteredOrders = [];
      }
    },
    // 환불 완료 처리 함수
async handleRefund(orderId) {
  try {
    console.log("환불", orderId);
    const response = await AdminRefundService.completeRefund(orderId);
    if (response.status === 200) {
      console.log(response.status);
      console.log("환불 처리가 완료되었습니다.");
      alert("환불 처리가 완료되었습니다."); // 사용자에게 환불 완료 알림
      this.searchOrders(); // 환불 처리가 완료된 후 searchOrders 함수 호출하여 화면 새로고침
    } else {
      console.log(response);
    }
  } catch (error) {
    console.error("Error during refund processing", error);
    alert(`환불 처리 중 오류가 발생했습니다: ${error.message}`);
  }
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
  mounted() {},
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
  .dur,
  .cal {
    flex-direction: column;
    align-items: flex-start;
  }

  /* 버튼과 달력 컨테이너 간격 조정 */


  .period-btn,
  .datepicker-container {
    margin-bottom: 10px;
  }


  .datepicker-container {
    width: auto; /* 버튼과 날짜 선택기의 너비를 자동으로 조절 */
    margin-bottom: 10px; /* 요소 사이의 간격 조정 */
  }


  /* 날짜 선택기와 관련된 추가 조정이 필요한 경우 */
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
  background-color: #5d4037;
  color: white;
  padding: 5px 10px;
  font-size: 14px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.button-style:hover {

  background-color: #4e342e; /* 호버 시 더 짙은 브라운으로 변경 */

}

.divider-style {
  display: flex;
  flex-direction: column;
  align-items: center;
  border-right: 1px solid #8d6e63; /* 짙은 브라운 계열의 경계선 */
  padding-right: 10px;
}
</style>
