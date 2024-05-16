<template>
<AdminHeaderCom/>
  <!-- Bootstrap CSS 파일 포함 -->
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    rel="stylesheet"
  />
  <div class="container mt-5">
    <div class="container">
      <div class="mt-5">
        <h3>상품문의</h3>
      </div>
      <div class="mt-5 text-center">
        <table
          class="table mt-5"
          :style="{ 'vertical-align': 'middle', 'text-align': 'center' }"
        >
          <!-- 테이블 제목 행 -->
          <thead>
            <tr class="text-center">
              <th scope="col">번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">내용</th>
            </tr>
          </thead>
          <tbody>
            <!-- 아이디 -->
            <tr v-for="(data, index) in qnaList" :key="index">
              <td scope="col">
                {{ data.qnaId }}
              </td>

              <td scope="col">
                <!-- <router-link
                :to="'/product/inquiry/' + data.qnaId"
                style="text-decoration: none;"
              > -->
                <!-- <router-link :to="'/product/inquiry/' + data.qnaId">
                {{ data.qnaTitle }}</router-link> -->
                <!-- </router-link> -->
                <router-link :to="`/product/inquiry/detail/${data.qnaId}`">{{
                  data.qnaTitle
                }}</router-link>
              </td>
              <td scope="col">
                {{ data.writerId }}
              </td>
              <td scope="col">
                {{ data.qnaContent }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 페이징 -->
      <!-- {/* paging 시작 */} -->
      <div class="row justify-content-center mt-4">
        <div class="col-auto">
          <b-pagination
            class="custom-pagination col-12 mb-3"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveQna"
          ></b-pagination>
        </div>
      </div>


      <!-- 관리자 등록 버튼 :: 공지사항 글등록으로 이동-->
      <!-- <div class="row justify-content-end">
      <button type="button" id="button1" class="mt-5 btn">
        <router-link to="/shop/admin-notice" class="router-link-exact-active"
          >공지사항 등록</router-link
        >
      </button>
    </div> -->
    </div>
  </div>
</template>

<script>
import QnaService from "@/services/product/QnaService";
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";
export default {
  components:{
    AdminHeaderCom
  },
  data() {
    return {
      // qna 테이블에 불러오는 배열
      qnaList: [],

      productCount: 1, // 상품 수량
      // image: require("@/assets/images/skincare.jpg"),
      product: {
        // prodId: this.$route.params.prodId,
        // prodName: "",
        // defaultPrice: "",
        // prodCategory: "",
        // prodImg: "",
        // prodImg2: "",
        // prodDetailPage: "",
        // discountRate: "",
        // prodStock: "",
        // saleEnd: "",
        // saleStart: "",
        // prodStatus: "",
        // soldCount:""
        // point: 5,
        // reviewContent: "만족스럽습니다.",
      },
      message: "", // 장바구니 추가 성공메세지(화면에 출력)
      // cartCount: 0, // 장바구니 개수

      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // 상품문의 전체조회 함수
    async retrieveAdminQna() {
      try {
        // TODO: 1) 공통 전체조회 함수 실행
        let response = await QnaService.getAllAdminQna(
          this.page - 1, // 현재페이지번호-1
          this.pageSize // 1페이지당개수(size)
        );
        // TODO: 복습 : 2) 객체분할 할당
        const { qnaList, totalItems } = response.data; // 부서배열(벡엔드 전송)
        // TODO: 3) 바인딩변수(속성)에 저장
        this.qnaList = qnaList; // 부서배열(벡엔드 전송)
        this.count = totalItems; // 전체페이지수(벡엔드 전송)
        // TODO: 4) 프론트 로깅 : console.log
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },

  },
  mounted() {
    // 화면 뜰때 상단이 뜨게 해주는 함수
    window.scrollTo(0, 0);
    this.retrieveAdminQna();
  },
};
</script>

<style>
/* 페이징 번호 디자인 */
.custom-pagination .page-item.active .page-link {
  background-color: #342a26;
  border-color: #ffffff;
  color: white;
}

.custom-pagination .page-link {
  color: #342a26;
}

.custom-pagination .page-link:hover {
  background-color: #ffffff;
  border-color: 1px solid#8f8f8f;
  color: #342a26;
  /* border: none; */
}

.custom-pagination .page-link:focus {
  outline: none;
  box-shadow: 0 0 0 0.2rem #342a26bf;
  border-color: #342a26bf;
}

/* 또는 밑에처럼 완전히 새로운 스타일을 지정가능 */
/* .custom-pagination .page-link:focus {
  outline: none;
  box-shadow: 0 0 0 0.2rem rgba(0, 86, 179, 0.25); 
  border-color: #0056b3; 
} */

.router-link-active,
.router-link-exact-active {
  color: inherit; /* 부모 요소의 색상 사용 */
}

.router-link-active,
.router-link-exact-active {
  color: #333; /* 원하는 색상으로 변경 */
}

.router-link-active:hover {
  text-decoration: underline;
  font-weight: bold;
  color: #333;
}

/* ------------------------------------------ */
#mysave {
  border: 1px solid #cccccc;
  height: 70px;
  padding: 25px;
  margin-top: 60px;
  letter-spacing: -1.5px;
  font-size: 13px;
}

#mysave:hover {
  /* background-color: #342a26; */
  /* color: #ffffff; */
  border-top: 10px solid #342a26;
  /* border-left: none;
  border-right: none;
  border-bottom: none; */
}

hr {
  opacity: 0.2;
}

h1 {
  font-family: "Lora", serif;
  font-optical-sizing: auto;
  font-style: normal;
  font-weight: bold;
  font-size: 30px;
}

.box {
  background-color: white;
  max-width: 100%;
  height: 50vw;
  border: 1px solid #e2e2e2;
  /* padding: 1vw; */
}

#name {
  background-color: white;
  height: 5vw;
  font-weight: 200;
  letter-spacing: -1.8px;
  /* border: 1px solid #e2e2e2; */
}

#page {
  background-color: white;
  border: 1px solid #e2e2e2;
  color: black;
  height: 100vw;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
  text-align: center;
}

#price {
  width: 16vw;
  padding: 0.5vx;
  /* border-radius: 5px;  */
  /* border: 1px solid #e2e2e2; */
  /* background-color: white; */
}

#price_1 {
  color: #999999;
  font-size: 16px;
  letter-spacing: -1.8px;
  margin-right: 40px;
}

h4 {
  font-size: 20px;
  font-weight: 500;
}

/* 두번째 상품명(수량선택 위) */
#quantity_jy1 {
  font-size: 15px;
  font-weight: lighter;
  margin: 20px 0 0 0;
  color: #999999;
}

.quantity_jy {
  font-size: 15px;
  font-weight: bold;
  margin: 20px 0 20px 0;
}

/* .dropdown {
  position: relative;
} */

#selectOption {
  /* position: absolute; */
  /* display: none; */
  min-width: 100%; /* 드롭다운 메뉴의 최소 너비를 100%로 설정 */
  /* z-index: 1000; */
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

/* 총 상품금액/ 총 주문 금액 */
#total {
  background-color: white;
  height: auto;
  /* border: 1px solid #e2e2e2; */
  padding: 0.5vw;
  z-index: 0;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

.shipping {
  font-size: 15px;
  letter-spacing: -1px;
  margin-top: 53px;
  color: #727272;
  font-weight: 600;
}

.won_1 {
  font-size: 1vw;
  letter-spacing: -1.7px;
  margin: 0 300px 100px 0;
  font-weight: 500;
}

#btn2 :hover {
  width: 9vw;
  height: 4vw;
  margin-right: 1.5vw;
  background-color: rgb(240, 92, 92);
  border: 1px solid #e2e2e2;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}
.won_1_2 {
  font-size: 1vw;
  letter-spacing: -1.7px;
  margin: 0 300px 100px 0;
  font-weight: bold;
}

.won_2 {
  font-size: 23px;
  letter-spacing: -1.5px;
  font-weight: bold;
  color: #252525;
}

#star {
  color: red;
}

#addReview-btn {
  width: 3.8vw;
  height: 43px;
  background-color: #342a26;
  margin: 20px;
  color: white;
}

#reviewWrite {
  background-color: #342a26;
  color: white;
}
/* 장바구니 버튼 */
.shop_button {
  /* border: 1px solid #cccccc; */
  padding: auto;
}

.shop_button {
  margin-bottom: 15px;
  letter-spacing: -1.7px;
}

.shop_button > #btn1 {
  width: 100%;
  height: 3vw;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  font-size: 20px;
}

#btn1:hover {
  color: #ff0000;
  font-size: 35px;
  /* border: 1px solid #cccccc; */
}

/* #btn1:hover::after {
  content: "♥"; 
}
#btn1:hover::before {
  content: none 
} */

#btn1::before {
  content: attr(data-original-text); /* 원래 텍스트를 보여주는 가상 요소 */
}

#btn1:hover::before {
  content: none; /* 호버 시 원래 텍스트를 숨김 */
}

#btn1::after {
  content: "♡"; /* 기본 텍스트 설정 */
}

#btn1:hover::after {
  content: "♥"; /* 호버 시 새로운 텍스트로 변경 */
}
#btn2 :hover {
  width: 9vw;
  height: 4vw;
  margin-right: 1.5vw;
  background-color: rgb(240, 92, 92);
  border: 1px solid #e2e2e2;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

.shop_button > #btn2 {
  width: 100%;
  height: 3vw;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  letter-spacing: -1px;
}

#btn2:hover {
  background-color: #5e0000d2;
  color: #ffffff;
  border: none;
}

.shop_button > #btn3 {
  width: 100%;
  height: 3vw;
  background-color: #342a26;
  border: none;
  color: #ffffff;
  letter-spacing: -1px;
}

#btn3:hover {
  background-color: #5e0000d2;
  color: #ffffff;
  border: none;
}

.shop_button > #btn4 {
  width: 100%;
  height: 3vw;
  background-color: #342a2635;
  border: none;
  letter-spacing: -1px;
  color: #ffffff;
}

#btn4:hover {
  background-color: #5e0000d2;
  color: #ffffff;
  border: none;
}

#addReview-btn {
  width: 3.8vw;
  height: 43px;
  background-color: #342a26;
  margin: 20px;
  color: white;
}

#reviewWrite {
  background-color: #342a26;
  color: white;
}
</style>
