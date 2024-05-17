// 관리자 환불 페이지
<template>
  <AdminHeaderCom />
  <div class="container">
    <!-- 반품관리 배너 시작 -->
    <h2 class="mb-3">환불 관리</h2>
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
              <td class="datalist">{{ formatCurrency(data.orderPrice) }}</td>
              <td class="datalist">{{ data.orderStatus }}</td>
              <td class="datalist">
                <button
                  class="button-style"
                  @click="handleRefund(data.orderId, data)"
                >
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
  </div>
</template>

<script>
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";
import AdminRefundService from "@/services/admin/AdminRefundService";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
      order: {},
      message: "",

      searchQuery: "",
      searchType: "orderId", // 검색 유형 초기화
      filteredOrders: [],

      paymentCode: null,
    };
  },
  methods: {
    // TODO: 금액에 쉼표 찍어주는 함수
    formatCurrency(value) {
      if (!value) return "";
      return value.toLocaleString("ko-KR");
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
    // TODO: orderId로 paymentCode 받아오는 함수
    async retrievePayco(orderId) {
      try {
        let response = await AdminRefundService.getPayCode(orderId);
        this.paymentCode = response.data;
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 환불 처리 함수
    async handleRefund(orderId, data) {
      try {
        // retrievePayco 함수 실행
        await this.retrievePayco(orderId);
        // paymentCode를 사용하여 주문 테이블 삭제
        let response = await AdminRefundService.remove(this.paymentCode);

        console.log(response.data);

        // orderId에 해당하는 주문의 상태를 환불 완료로 변경
        data.orderStatus = "환불완료";
        let refundResponse = await AdminRefundService.completeRefund(
          orderId,
          data
        );
        console.log(refundResponse.data);

        this.message = "환불 처리되었습니다.";
        alert("환불 처리가 완료되었습니다.");

        this.getAllRefund(); // 환불 처리가 완료된 후 getAllRefund() 함수 호출하여 화면 새로고침
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 환불신청으로 되어있는 주문 정보 건 모두 확인
    async getAllRefund() {
      try {
        let response = await AdminRefundService.findAllByOrderStatus(
          "환불신청"
        );
        this.filteredOrders = response.data;
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    this.message = "";
    window.scrollTo(0, 0);
    this.getAllRefund();
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
  .dur,
  .cal {
    flex-direction: column;
    align-items: flex-start;
  }

  .period-btn,
  .datepicker-container {
    margin-bottom: 10px;
  }

  .datepicker-container {
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
  background-color: #4e342e;
}

.divider-style {
  display: flex;
  flex-direction: column;
  align-items: center;
  border-right: 1px solid #8d6e63;
  padding-right: 10px;
}
</style>
