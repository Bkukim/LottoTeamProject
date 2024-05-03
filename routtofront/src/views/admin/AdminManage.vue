// 관리자 조회/수정 페이지
<template>
  <AdminHeaderCom />
  <!-- 1. 조회 -->
  <div class="container">
    <!-- 1) 조회 배너 시작 -->
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
      <label><b>상품 조회</b></label>
    </div>
    <!-- 조회 배너 끝 -->

    <!-- 2) 전체 상태 -->
    <div
      class="container mt-4"
      style="
        border: 1px solid #342a26;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 200px;
        flex-direction: row;
      "
    >
      <div class="circle"></div>
      <div class="text-container">
        <div>전체</div>
        <div>0건</div>
      </div>
      <div class="circle"></div>
      <div class="text-container">
        <div>판매중</div>
        <div>0건</div>
      </div>
      <div class="circle"></div>
      <div class="text-container">
        <div>판매중지</div>
        <div>0건</div>
      </div>
      <div class="circle"></div>
      <div class="text-container">
        <div>품절</div>
        <div>0건</div>
      </div>
      <div class="circle"></div>
      <div class="text-container">
        <div>판매종료</div>
        <div>0건</div>
      </div>
    </div>
    <!-- 전체 상태 끝-->

    <!-- <br /> -->

    <!-- 3) 검색어 시작 -->
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
        <label id="searchWord">검색어</label>

        <!-- 상품번호 시작 -->

        <div class="form-check" id="prodNum">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label
            class="form-check-label"
            for="flexRadioDefault1"
            id="form-check-label"
          >
            상품번호
          </label>
        </div>
        <div class="col">
          <input class="form-control" type="text" name="prodNum" />
        </div>

        <!-- 상품번호 끝 -->

        <!-- <label style="align-items: right"> -->
        <!-- 상품명 시작 -->

        <div class="form-check" id="prodId">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label
            class="form-check-label"
            for="flexRadioDefault1"
            id="form-check-label"
          >
            상품명
          </label>
        </div>
        <div class="col">
          <input class="form-control" type="text" name="prodName" />
        </div>

        <!-- 상품명 끝 -->
        <!-- </label> -->
      </div>
    </div>
    <!-- 검색어 끝 -->

    <!-- 4) 판매상태 시작 -->
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
        <label id="salaryStatus"> 판매 상태 </label>
        <!-- 전체 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status">
            전체
          </label>
        </div>
        <!-- 판매중 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status">
            판매중
          </label>
        </div>
        <!-- 판매중지 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status">
            판매중지
          </label>
        </div>
        <!-- 품절 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status">
            품절
          </label>
        </div>
        <!-- 판매종료 버튼 -->
        <div class="form-check">
          <input
            class="form-check-input"
            type="radio"
            name="flexRadioDefault"
            id="flexRadioDefault1"
            checked
          />
          <label class="form-check-label" for="flexRadioDefault1" id="status">
            판매종료
          </label>
        </div>
      </div>
    </div>
    <!-- 판매상태 끝 -->

    <!-- 5) 카테고리 시작 -->
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
        <label id="category"> 카테고리 </label>
        <label style="align-items: right">
          <select class="form-select" aria-label="Default select example">
            <option selected>스킨케어</option>
            <option value="1">메이크업</option>
            <option value="2">바디</option>
            <option value="3">헤어</option>
          </select>
        </label>
      </div>
    </div>
    <!-- 카테고리 끝 -->
  </div>

  <br />

  <!-- 2. 검색/초기화 버튼 -->
  <div class="container text-center">
    <button
      type="button"
      class="text-light signUpBtn btn-sm mt-4"
      style="margin-left: 10px"
    >
      검색
    </button>
    <button
      type="button"
      class="text-light signUpBtn btn-sm mt-4"
      style="margin-left: 10px"
    >
      초기화
    </button>
  </div>

  <!-- 3. 수정 페이지 -->
  <div class="container">
    <!-- 1) 수정 배너 시작 -->
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
      <label><b>상품 수정</b></label>
    </div>
    <!-- 수정 배너 끝 -->

    <br />

    <!-- 2) 상품 항목 시작 -->
    <div>
      <!-- 기본 정보 테이블 시작-->
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
            <th scope="col" id="modifyCol">수정</th>
            <th scope="col" id="modifyCol">복사</th>
            <th scope="col">상품번호</th>
            <th scope="col">상품명</th>
            <th scope="col">상세설명</th>
            <th scope="col">판매상태</th>
            <th scope="col">재고수량</th>
            <th scope="col">판매가</th>
          </tr>
        </thead>
        <tbody>
          <!-- 1행 -->
          <tr class="text-center">
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
              <button
                type="button"
                class="text-light updateBtn btn btn-success"
              >
                수정
              </button>
            </td>
            <td>
              <button
                type="button"
                class="text-light updateBtn btn btn-success"
              >
                복사
              </button>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
          </tr>
          <!-- 2행 tr -->
          <tr class="text-center">
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
              <button
                type="button"
                class="text-light updateBtn btn btn-success"
              >
                수정
              </button>
            </td>
            <td>
              <button
                type="button"
                class="text-light updateBtn btn btn-success"
              >
                복사
              </button>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
          </tr>
          <!-- 3행 tr -->
          <tr class="text-center">
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
              <button
                type="button"
                class="text-light updateBtn btn btn-success"
              >
                수정
              </button>
            </td>
            <td>
              <button
                type="button"
                class="text-light updateBtn btn btn-success"
              >
                복사
              </button>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
            <td>
              <div>
                <input class="form-control" type="text" name="user" />
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <!-- 상품 항목 끝 -->
  </div>
  <!-- 4. 수정 항목 저장 버튼 -->
  <div class="container text-center">
    <button
      type="button"
      class="text-light signUpBtn btn-sm mt-4"
      style="margin-left: 10px"
    >
      수정 항목 저장
    </button>
  </div>

  <br />
  <br />
</template>

<script>
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";

export default {
  components: {
    AdminHeaderCom,
  },
};
</script>

<style>
.searchBtn {
  background-color: #342a26;
  color: white;
}

.circle {
  width: 2.94vw;
  height: 2.94vw;
  background-color: #342a26; /* 동그라미의 색상 */
  border-radius: 50%; /* 원 모양으로 만들기 위해 50%로 설정 */
  display: flex;
  justify-content: center;
  align-items: center;
}

.text-container {
  text-align: center;
}

#salaryStatus {
  margin-right: 6.94vw;
}

#searchWord {
  margin-right: 8vw;
}

/* #prodNum {
  margin-right: 6vw;
} */

#status {
  margin-right: 7vw;
}

#form-check-label {
  margin-right: 2vw;
}

#prodId {
  margin-left: 10vw;
}

.signUpBtn {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}

#category {
  margin-right: 7vw;
}
#modifyCol {
  width: 5vw;
}
</style>
