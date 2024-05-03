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

    <!-- 1. 검색조건 시작 : searchOpt -->
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
        <!-- 검색 조건 : for="searchOption" -->
        <label id="category1" for="searchOption"> 주문일 검색 </label>
        <!-- 주문번호/상품명 label : id="searchOpt" -->
        <!-- <label style="align-items: right" id="searchOpt"> -->
        <!-- 주문번호/상품명 select box : id="searchOption"-->
        <!-- <select class="form-select" aria-label="Default select example" id="searchOption"> -->
        <!-- <option selected>주문번호</option> -->
        <!-- <option value="1">상품명</option> -->
        <!-- </select> -->
        <!-- </label> -->
        <!-- 주문번호/상품명 입력란 : id="searchInputContainer" -->
        <div class="col">
          <!-- <input
            class="form-control"
            type="text"
            name="prodNum"
            v-model="searchOptionInput"
          /> -->
          <div class="datepicker-container">
            <VueDatePicker
              v-model="selectedDate"
              locale="ko"
              format="yyyy-MM-dd"
              :enable-time-picker="false"
              week-start="0"
              position="left"
              placeholder="날짜 선택"
              auto-apply
              :max-date="maxDate"
            />
          </div>
        </div>
      </div>
    </div>
    <!-- 검색조건 끝 -->

    <!-- 2. 주문상태 시작 : selectedOrderStatus -->
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
        <label id="salaryStatus1" for="StatusOption">주문 상태</label>

        <!-- 결제확인 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            value="결제완료"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            결제완료
          </label>
        </div>
        <!-- 상품준비중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            value="상품준비중"
            v-model="selectedOrderStatus"
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            상품준비중
          </label>
        </div>
        <!-- 배송중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            value="배송중"
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            배송중
          </label>
        </div>
        <!-- 배송완료 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            value="배송완료"
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            배송완료
          </label>
        </div>
        <!-- 구매확정 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            value="구매확정"
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            구매확정
          </label>
        </div>
      </div>
    </div>
    <!-- 주문 상태 끝 -->

    <!-- 4. 검색 버튼 : @click="searchOrder"-->
    <div class="container text-center">
      <button
        type="button"
        class="text-light searchBtn btn-sm mt-4"
        style="margin-left: 10px"
        @click="searchOrder"
      >
        검색
      </button>
    </div>

    <br />
    <br />

    <!-- 5. 테이블 시작-->
    <table class="table table-bordered" style="border: 1px solid #342a26">
      <!-- 테이블 제목 행 -->
      <thead>
        <tr class="text-center">
          <th scope="col">주문번호</th>
          <th scope="col">주문일</th>
          <th scope="col">주문상품정보</th>
          <th scope="col">주문자정보</th>
          <th scope="col">결제수단</th>
          <th scope="col">주문상태변경</th>
          <th scope="col">주문상태</th>
          <th scope="col">주문상태저장</th>
        </tr>
      </thead>
      <tbody>
        <!-- 1행 -->
        <tr class="text-center" v-for="(data, index) in orders" :key="index">
          <!-- 주문번호 -->
          <td>
            <div>
              <p>{{ data.orderId }}</p>
            </div>
          </td>
          <!-- 주문일 -->
          <td>
            <div>
              <p>{{ data.orderTime }}</p>
            </div>
          </td>
          <!-- 주문상품정보 -->
          <td>
            <!-- <div v-for="(data2, index) in data.orderProds" :key="index">
              <p>{{ data.prodName }}</p>
            </div> -->
            <button
              type="button"
              class="text-light detailBtn btn-sm mt-1"
              style="margin-left: 5px"
              @click="goProdDetail(data.orderId)"
            >
              상세보기
            </button>
          </td>
          <!-- 주문자 정보 -->
          <td>
            <div>
              <p>{{ data.userId }}</p>
            </div>
          </td>
          <!-- 결제 수단 -->
          <td>
            <div>
              <p>{{ data.paymentType }}</p>
            </div>
          </td>
          <!-- 주문 상태 변경 -->
          <td>
            <label style="align-items: right">
              <select
                class="form-select"
                aria-label="Default select example"
                id="orderStatus"
                v-model="data.orderStatus"
              >
                <option selected>결제완료</option>
                <option value="상품준비중">상품준비중</option>
                <option value="배송중">배송중</option>
                <option value="배송완료">배송완료</option>
                <option value="구매확정">구매확정</option>
                <!-- <option value="5">구매확정</option> -->
              </select>
            </label>
          </td>
          <!-- 주문 상태 -->
          <td>
            <p>{{ data.orderStatus }}</p>
          </td>
          <td>
            <!-- 주문 상태 저장 -->
            <div>
              <button
                type="button"
                class="text-light saveBtn btn-sm mt-1"
                style="margin-left: 5px"
                @click="update(data)"
              >
                저장
              </button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>

    <!-- 페이징 -->
    <!-- {/* paging 시작 */} -->
    <!-- TODO: 1페이지당 화면에 보일 개수 조정(select태그) -->
    <div class="row justify-content-center mt-4">
      <div class="col-auto">
        <b-pagination
          class="col-12 mb-3"
          v-model="page"
          :total-rows="count"
          :per-page="pageSize"
          @click="retrieveOrder"
        ></b-pagination>
      </div>
    </div>

    <br />
    <br />
  </div>
</template>
<script>
import AdminOrderservice from "@/services/admin/AdminOrderService";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

export default {
  components: {
    VueDatePicker,
  },
  data() {
    return {
      // 상품 상세보기 시 조회할 변수 : 주문상품번호
      orderProdId: "",
      // todo 주문일 날짜
      // formatDate: 'YYYY-MM-DD', // 예시로 사용된 날짜 포맷, 실제 필요에 따라 변경
      selectedDate: "", // 사용자가 선택한 날짜를 저장할 데이터 속성
      maxDate: new Date(), // 오늘 날짜를 최대 날짜로 설정

      // selectedOrders:[],  // 체크박스 : 각 체크박스에서 선택된 주문들의 id를 저장하기 위해 배열로 생성

      orders: [], // 테이블에 나오는 배열정보들


      // searchOptionInput: "", // 입력한 주문번호를 저장할 데이터 속성
      selectedOrderStatus: "", // 선택한 주문 상태를 저장할 데이터 속성
      // searchOptionResult: "", // 주문번호 검색 결과를 표시하는 데이터 속성
      // searchOrderResult: "", // 주문 상태 결과를 표시하는 데이터 속성

      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 3, // 1페이지당개수(select태그)
    };
  },
  methods: {
//   주문 상태 변경(수정) 함수
      async update(data) {
      try {
        let response = await AdminOrderservice.update(data);
        console.log(response.data); // 로깅
        alert("주문상태가 변경되었습니다."); // 화면에 성공메세지 출력 : message 바인딩 변수
        this.retrieveOrder();   // 화면 재조회함수
      } catch (e) {
        console.log(e);
      }
    },
    // 상세보기 클릭 시 상품 상세조회로 가는 페이지
    goProdDetail(orderId) {
      this.$router.push(`/orderProduct/${orderId}`);
    },
    // 전체조회(장바구니) 함수 : 검색어 버튼, 화면이뜰때 자동 실행
    async retrieveOrder() {
      try {
        if (this.selectedDate == "") {
          // 주문일 검색에서 선택안했을 때
          let formattedDate = ""; // 쿼리문에 날짜가 아닌 빈칸이 들어가야 전체 데이터가 나온다.
          // 공통 장바구니 전체 조회 서비스 함수 실행
          let response = await AdminOrderservice.getAll(
            formattedDate,
            this.selectedOrderStatus,
            this.page - 1,
            this.pageSize
          );
          const { orders, totalItems } = response.data;
          this.orders = orders;
          this.count = totalItems;
          // 로깅
          // console.log("결과출력", response.data); // 웹브라우저 콘솔탭에 벡엔드 데이터 표시
        } else {
          let date = new Date(this.selectedDate);
          // 날짜 포맷 설정
          let options = { year: "numeric", month: "numeric", day: "numeric" };
          // 날짜 포맷팅
          let formattedDate = date
            .toLocaleDateString("ko-KR", options)
            .replace(/\. /g, "-") // 공백과 점을 -로 대체
            .slice(0, -1); // 맨 끝 문자열 제거
          let response = await AdminOrderservice.getAll(
            formattedDate,
            this.selectedOrderStatus,
            this.page - 1,
            this.pageSize
          );
          const { orders, totalItems } = response.data;
          this.orders = orders;
          this.count = totalItems;
          // 로깅
          // console.log("결과출력", response.data); // 웹브라우저 콘솔탭에 벡엔드 데이터 표시
        }
      } catch (e) {
        console.log(e); // 웹브라우저 콘솔탭에 에러 표시
      }
    },
    async searchOrder() {
      // this.searchResult = this.searchOptionInput;

      // 주문일 입력값 가져오기
      var orderDateInput = this.selectedDate;

      // 선택된 주문 상태 가져오기
      var selectedOrderStatus = document.querySelector(
        'input[name="flexRadioDefault"]:checked'
      );

      // 선택된 주문일이 없을 경우
      if (!orderDateInput) {
        alert("주문일을 입력해주세요.");
        return;
      }

      // 선택된 주문 상태가 없을 경우
      if (!selectedOrderStatus) {
        alert("주문 상태를 선택해주세요.");
        return;
      }

      // retrieveOrder 함수 실행
      await this.retrieveOrder();
    },
  },
  mounted() {
    // 최초 화면이 뜰 때 전체조회 실행(장바구니)
    this.retrieveOrder();
  },
};
</script>

<style>
#category1 {
  margin-right: 5vw;
}

#salaryStatus1 {
  margin-right: 7vw;
}
/* #category2 {
  margin-right: 5.5vw;
} */
#searchOpt {
  margin-right: 1vw;
}

#status1,
#status2 {
  margin-right: 3vw;
}

.searchBtn {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
.saveBtn {
  background-color: #342a26;
  color: white;
  font-size: 15px;
  width: 70px;
  height: 35px;
}
.detailBtn {
  background-color: #342a26;
  color: white;
  font-size: 15px;
  width: 80px;
  height: 35px;
}
#orderStatus {
  width: 11vw;
}
</style>
