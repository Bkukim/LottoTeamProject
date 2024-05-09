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
      <label><b>상품 조회 / 수정</b></label>
    </div>
    <!-- 조회 배너 끝 -->

    <!-- 2) 검색어 시작 -->
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
          <label
            class="form-check-label"
            for="flexRadioDefault1"
            id="form-check-label"
          >
            상품명
          </label>
        </div>
        <div class="col">
          <input
            class="form-control"
            type="text"
            name="prodNum"
            v-model="findProdName"
          />
        </div>

        <!-- 상품번호 끝 -->

        <!-- </label> -->
      </div>
    </div>
    <!-- 검색어 끝 -->

    <!-- 카테고리 끝 -->
  </div>

  <br />

  <!-- 2. 검색/초기화 버튼 -->
  <div class="container text-center">
    <button
      type="button"
      class="text-light signUpBtn btn-sm mt-4"
      style="margin-left: 10px"
      @click="retrieveProduct"
    >
      검색
    </button>
    <!-- <button
      type="button"
      class="text-light signUpBtn btn-sm mt-4"
      style="margin-left: 10px"
    >
      초기화
    </button> -->
  </div>

  <!-- 3. 수정 페이지 -->
  <div class="container">
    <br />
    <br />

    <!-- 2) 상품 항목 시작 -->
    <div>
      <!-- 기본 정보 테이블 시작-->
      <table class="table table-bordered" style="border: 1px solid #342a26">
        <!-- 테이블 제목 행 -->
        <thead>
          <tr class="text-center">
            <!-- <th scope="col">
              <input
                class="form-check-input"
                type="checkbox"
                value=""
                id="flexCheckDefault"
              />
            </th> -->
            <!-- <th scope="col" id="modifyCol">수정</th> -->
            <th scope="col" id="prodNumber">상품번호</th>
            <th scope="col">상품명</th>
            <th scope="col">판매상태</th>
            <th scope="col" id="prodCategory">카테고리</th>
            <th scope="col">판매가</th>
            <th scope="col" id="prodNumber">재고수량</th>
            <th scope="col" id="modifyCol">수정</th>
            <!-- <th scope="col" id="modifyCol">삭제</th> -->
          </tr>
        </thead>
        <tbody>
          <!-- 반복문 돌리기 -->
          <tr
            class="text-center"
            v-for="(data, index) in products"
            :key="index"
          >
            <td>
              <div>
                <p>{{ data.prodId }}</p>
              </div>
            </td>
            <td>
              <div>
                <p>{{ data.prodName }}</p>
              </div>
            </td>
            <td>
              <div>
                <p>{{ data.prodStatus }}</p>
              </div>
            </td>
            <td>
              <div>
                <p>{{ data.prodCategory }}</p>
              </div>
            </td>
            <td>
              {{
               data.prodPrice
              }}
            </td>
            <td>
              <div>
                <p>{{ data.prodStock }}</p>
              </div>
            </td>
            <td>
              <button type="button" class="text-ligh btn" id="modifySaveBtn" @click="goModifyPage(data.prodId)">
                수정
              </button>
            </td>            
            <!-- <td>
              <button type="button" class="text-ligh btn" id="modifySaveBtn" @click="deleteProduct(data.prodId)">
                삭제
              </button>
            </td> -->
          </tr>
        </tbody>
      </table>
    </div>
    <!-- 상품 항목 끝 -->
  </div>
</template>

<script>
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";
import AdminManageService from "@/services/admin/AdminManageService";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
      findProdName: "", // 사용자가 검색할 검색어
      products: [], // 테이블에 나오는 배열정보들
    };
  },
  methods: {
    // 전체조회 + prodName으로 검색
    async retrieveProduct() {
      try {
        let response = await AdminManageService.getAll(this.findProdName);
        this.products = response.data; // 부서 배열(백엔드에서 배열을 이름없이 전송했음. 이걸 products 라는 배열에 집어넣기)
        // console.log("나와주세요" + response.data);
        // console.log(response.data);   // 콘솔로 찍기
      } catch (e) {
        console.log(e);
      }
    },
    // 수정 버튼 클릭 시 상품 수정 페이지로 이동
    goModifyPage(prodId) {
      this.$router.push(`/shop/admin/prod-modify/${prodId}`);
    },
    // // 상품 삭제 버튼
    // async deleteProduct(prodId){
    //         try {
    //     if (confirm("정말로 삭제하시겠습니까?")) {
    //       // 삭제 동작을 수행하는 코드
    //       let response = await AdminManageService.delete(prodId);
    //       console.log(response);
    //       alert("삭제되었습니다.");
    //        this.retrieveProduct();
    //     } else {
    //       // 삭제를 취소하는 코드
    //       console.log("삭제가 취소되었습니다.");
    //       this.$router.push("/shop/admin/manage");
    //     }
    //   } catch (e) {
    //     console.log(e);
    //   }
    // }
  },
  mounted() {
    // 최초 화면이 뜰 때 전체조회 실행(장바구니)
    this.retrieveProduct();
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

.updateBtn {
  width: 5vw;
}

#modifySaveBtn {
  background-color: #342a26;
  color: white;
  width: 5vw;
}

#prodNumber {
  width: 7vw;
}
</style>
