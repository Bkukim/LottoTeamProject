<!-- 고객센터 faq view -->
<template>
  <div class="container">
    <div class="main_text">
      <router-link
        class="top_notice router-link-exact-active fs-5"
        to="/shop/faqList"
        >FAQ</router-link
      >
      |
      <router-link class="top_notice2 text-decoration-none" to="/shop/notice"
        >공지사항</router-link
      >
    </div>
    <div class="mt-5 text-center">
      <!-- 테이블 시작 -->
      <!-- 내가쓴글 확인하기 : v-if="faqList.userId === this.$store.state.user?.userId"-->
      <div
        class="row mt-5"
      >
        <button type="button" id="button3" class="btn" @click="goUserId">
          내가쓴글 확인하기
        </button>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <!-- 반복문 시작할 행 -->
          <tr v-for="(data, index) in faqList" :key="index">
            <th scope="row">
              <router-link
                :to="'/shop/inquiry-check/' + data.faqId"
                class="router-link-exact-active cencle"
              >
                {{  (page - 1) * pageSize + index + 1  }}
              </router-link>
            </th>
            <td class="col-8">
              <router-link
                :to="'/shop/inquiry-check/' + data.faqId"
                class="router-link-exact-active cencle"
              >
                {{ data.faqTitle }}
              </router-link>
            </td>
            <td>
              <router-link
                :to="'/shop/inquiry-check/' + data.faqId"
                class="router-link-exact-active cencle"
              >
                {{ data.userId }}
              </router-link>
            </td>
            <td>{{ data.insertTime }}</td>
          </tr>
        </tbody>
      </table>

      <!-- 페이징 -->
      <!-- {/* paging 시작 */} -->
      <!-- TODO: 1페이지당 화면에 보일 개수 조정(select태그) -->
      <div class="row justify-content-center mt-4">
        <div class="col-auto">
          <b-pagination
            class="col-12 mb-3 custom-pagination"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveFaq"
          ></b-pagination>
        </div>
      </div>

      <!-- 질문하기 등록-->
      <div class="row justify-content-end">
        <button type="button" id="button1" class="mt-5 btn" @click="goInquiry">
          질문하기
        </button>
      </div>
    </div>
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
    goUserId() {
      if (!this.$store.state.user?.userId) {
        alert("로그인페이지로 이동합니다");
        this.$router.push("/member/login");
      } else{
        this.$router.push("/shop/faqList/userId");
      }
    },
    goInquiry() {
      if (!this.$store.state.user?.userId) {
        alert("로그인페이지로 이동합니다");
        this.$router.push("/member/login");
      } else{
        this.$router.push("/shop/inquiry");

      }
    },
  },
  mounted() {
    this.retrieveFaq();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
