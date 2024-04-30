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
        <label id="category1" for="searchOption"> 주문번호 검색 </label>
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
          <input
            class="form-control"
            type="text"
            name="prodNum"
            v-model="searchOptionInput"
          />
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
        <!-- <label style="align-items: right" id="searchOpt"> -->
        <!-- 주문번호/상품명 select box -->
        <!-- <select class="form-select" aria-label="Default select example"> -->
        <!-- <option selected>주문관리</option> -->
        <!-- <option value="1">상품명</option> -->
        <!-- </select> -->
        <!-- </label> -->
        <!-- 결제확인중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            결제확인중
          </label>
        </div>
        <!-- 결제확인 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            결제확인
          </label>
        </div>
        <!-- 상품준비중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            상품준비중
          </label>
        </div>
        <!-- 배송준비중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            배송준비중
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
            checked
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
            checked
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            배송완료
          </label>
        </div>
        <!-- 거래완료 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault"
            v-model="selectedOrderStatus"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault" id="status1">
            거래완료
          </label>
        </div>
      </div>
    </div>
    <!-- 주문 상태 끝 -->

    <!-- 3. 결제수단 시작 : selectedPayMethod-->
    <!-- <div
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
        신용카드 버튼
         <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
            v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            신용카드
          </label>
        </div> -->
    <!-- PAYCO 버튼 -->
    <!-- <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
            v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            PAYCO
          </label>
        </div> -->
    <!-- 카카오페이 버튼 -->
    <!-- <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
             v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            카카오페이
          </label>
        </div> -->
    <!-- 네이버페이 버튼 -->
    <!-- <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
             v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            네이버페이
          </label>
        </div> -->
    <!-- 휴대폰결제 버튼 -->
    <!-- <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
             v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            휴대폰결제
          </label>
        </div> -->
    <!-- 계좌이체 버튼 -->
    <!-- <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
             v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            계좌이체
          </label>
        </div> -->
    <!-- 토스페이 버튼 -->
    <!-- <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault2"
             v-model="selectedPayMethod"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault2" id="status2">
            토스페이
          </label>
        </div> -->
    <!-- </div> -->
    <!-- </div> -->
    <!-- 결제수단 끝 -->

    <!-- 4. 검색 버튼 : @click="searchOrder"-->
    <div class="container text-center">
      <button
        type="button"
        class="text-light signUpBtn btn-sm mt-4"
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
          <th scope="col">
            <input
              class="form-check-input"
              type="checkbox"
              value=""
              id="flexCheckDefault"
            />
          </th>
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
          <th scope="row">
            <label class="form-label" for="user"
              ><input
                class="form-check-input"
                type="checkbox"
                value=""
                id="flexCheckDefault"
            /></label>
          </th>

          <td>
            <div>
              <p>{{ data.orderId }}</p>
            </div>
          </td>
          <td>
            <div>
              <p>{{ data.orderTime }}</p>
            </div>
          </td>
          <td>
            <!-- <div v-for="(data2, index) in data.orderProds" :key="index">
              <p>{{ data.prodName }}</p>
            </div> -->
          </td>
          <td>
            <div>
              <p>{{ data.userId }}</p>
            </div>
          </td>
          <td>
            <div>
              <p>{{ data.paymentType }}</p>
            </div>
          </td>
          <td>
            <label style="align-items: right">
              <select
                class="form-select"
                aria-label="Default select example"
                id="orderStatus"
              >
                <option selected>상품준비중</option>
                <option value="1">결제확인중</option>
                <option value="2">결제확인</option>
                <option value="3">배송준비중</option>
                <option value="4">배송완료</option>
                <option value="5">거래완료</option>
              </select>
            </label>
          </td>
          <td>
            <p>{{data.orderStatus}}</p>
          </td>
          <td>
          <div>
            <button
              type="button"
              class="text-light saveBtn btn-sm mt-4"
              style="margin-left: 10px"
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
          @click="retrieveFaq"
        ></b-pagination>
      </div>
    </div>

    <!-- 6. 저장 버튼 -->
    <!-- <div class="container text-center">
      <button
        type="button"
        class="text-light signUpBtn btn-sm mt-4"
        style="margin-left: 10px"
      >
        저장
      </button>
    </div> -->

    <br />
    <br />
  </div>
</template>
<script>
import AdminOrderservice from "@/services/admin/AdminOrderService";
export default {
  data() {
    return {
      orders: [],
      searchOrderId: 11,

      searchOptionInput: "", // 입력한 주문번호를 저장할 데이터 속성
      selectedOrderStatus: "", // 선택한 주문 상태를 저장할 데이터 속성
      searchOptionResult: "", // 주문번호 검색 결과를 표시하는 데이터 속성
      searchOrderResult: "", // 주문 상태 결과를 표시하는 데이터 속성
      // orderNumberInput:""             // 검색한 주문번호의 결과를 표시하는 데이터 속성

      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // TODO: 전체조회(장바구니) 함수 : 검색어 버튼, 화면이뜰때 자동 실행
    async retrieveOrder() {
      try {
        // TODO: 공통 장바구니 전체 조회 서비스 함수 실행
        // TODO: 비동기 코딩 : async ~ await
        let response = await AdminOrderservice.getAll(
          this.searchOrderId,
          this.page - 1,
          this.pageSize
        );
        const { orders, totalItems } = response.data;
        this.orders = orders;
        this.count = totalItems;
        // 로깅
        console.log(response.data); // 웹브라우저 콘솔탭에 벡엔드 데이터 표시
      } catch (e) {
        console.log(e); // 웹브라우저 콘솔탭에 에러 표시
      }
    },
    searchOrder() {
      // this.searchResult = this.searchOptionInput;

      // 주문번호 입력값 가져오기
      var orderNumberInput = this.searchOptionInput;

      // 선택된 주문 상태 가져오기
      var selectedOrderStatus = document.querySelector(
        'input[name="flexRadioDefault"]:checked'
      );

      // 선택된 주문 번호가 없을 경우
      if (!orderNumberInput) {
        alert("주문번호를 입력해주세요.");
        return;
      }

      // 선택된 주문 상태가 없을 경우
      if (!selectedOrderStatus) {
        alert("주문 상태를 선택해주세요.");
        return;
      }
    },
  },
  mounted() {
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

.signUpBtn {
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
  height: 50px;
}
#orderStatus {
  width: 11vw;
}
</style>
