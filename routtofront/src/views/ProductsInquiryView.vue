
<template>
  <div class="container">
    <h4> 상품문의 </h4>
    <!-- <div class="mt-5">
      <router-link
        class="top_notice router-link-exact-active fs-5"
        to="/faqList"
        >Q&A</router-link
      >
      |
      <router-link class="top_notice2 text-decoration-none" to="/notice"
        >공지사항</router-link
      >
    </div> -->
    <div class="mt-5 text-center">
      <!-- 서치 -->
      <div class="row justify-content-end">
        <form class="d-flex mt-3 col-5" role="search">
          <input
            class="form-control me-2"
            type="search"
            placeholder="검색"
            aria-label="Search"
          />
          <button class="btn btn-outline-success" type="submit">검색</button>
        </form>
      </div>

      <!-- 테이블 시작 -->
      <table class="table mt-5">
        <thead>
          <tr class="table-light">
            <th scope="col">번호</th>
            <th scope="col">카테고리</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
            <th scope="col">조회</th>
          </tr>
        </thead>
        <tbody> 
          <!-- 반복문 시작할 행 -->
          <tr v-for="(data, index) in ProductsDetail" :key="index">
            <th scope="row">{{ data.prodId }}</th>
            <td>{{ data.proTitle }}</td>
            <td>{{ data.userId }}</td>
            <td>{{ created }}</td>
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

      <!-- 질문하기 등록-->
      <!-- <div class="row justify-content-end">
        <button type="button" id="button1" class="mt-5 btn">
          <router-link to="/inquiry" class="router-link-exact-active"
            >질문하기</router-link
          >
        </button>
      </div> -->
    </div>
  </div>

  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />

  <div class="qna_rmf">
    <b>상품결제정보</b>
    <br />
    <br />
    <p>
      고액결제의 경우 안전을 위해 카드사에서 확인전화를 드릴 수도 있습니다.
      확인과정에서 도난 카드의 사용이나 타인 명의의 주문등 정상적인 주문이
      아니라고 판단될 경우 임의로 주문을 보류 또는 취소할 수 있습니다. <br />
      <br />무통장 입금은 상품 구매 대금은 PC뱅킹, 인터넷뱅킹, 텔레뱅킹 혹은
      가까운 은행에서 직접 입금하시면 됩니다. 주문시 입력한 입금자명과
      실제입금자의 성명이 반드시 일치하여야 하며, 7일 이내로 입금을 하셔야 하며
      입금되지 않은 주문은 자동취소 됩니다.
      <br /> 
      <br />
      <b>배송정보</b> 
      <br />
      <br />배송 방법 : 택배 
      <br />배송 지역
      : 전국지역 
      <br />배송 비용 : 3,000원 
      <br />배송 기간 : 1일 ~ 3일 
      <br />배송 안내 : -당일
      오후2시까지 결제 완료 시 당일 출고, 오후 2시 이후 결제 완료 시 익일 출고
      됩니다. (출고부터 배송완료까지 영업일 기준으로 1~2일 소요되며, 이는 택배사
      사정에 따라 달라질 수 있습니다.) -
      <br />제주도 지역은 3,000원, 기타 도서산간
      지역은 지역별 3,000원~9,000원의 배송비가 추가 발생합니다.
    </p>
  </div>
</template>

<script>
import FaqListService from "@/services/noticeQnA/FaqListService";
export default {
  data() {
    return {
      faqList: [],
      faqTitle: "",

      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)

      // 날짜함수
      currentDate: "",
    };
  },
  methods: {
    // 전체조회 함수
    async retrieveFaq() {
      try {
        // TODO: 1) 공통 전체조회 함수 실행
        let response = await FaqListService.getAll(
          this.faqTitle, // 검색어
          this.page - 1, // 현재페이지번호-1
          this.pageSize // 1페이지당개수(size)
        );
        // TODO: 복습 : 2) 객체분할 할당
        const { faqList, totalItems } = response.data; // 부서배열(벡엔드 전송)
        // TODO: 3) 바인딩변수(속성)에 저장
        this.faqList = faqList; // 부서배열(벡엔드 전송)
        this.count = totalItems; // 전체페이지수(벡엔드 전송)
        // TODO: 4) 프론트 로깅 : console.log
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    created() {
      //  이걸 백엔드에 전해주려면 어캐함?
      this.currentDate = new Date().toLocaleDateString();
    },
  },
  mounted() {
    this.retrieveFaq();
  },
};
</script>

<style>
/* @import "@/assets/css/Button.css"; */


.qna_rmf > p{
  font-size: 12px;
  color: #353535;
  line-height: 18px;
}

.qna_rmf > b{
  font-size: 12px;
}
</style>