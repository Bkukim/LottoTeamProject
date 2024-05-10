<!-- Adming Notice view ::어드민 헤더보이는 똑같은 코드임~-->
<template>
  <AdminHeaderCom/>
  
  <div class="container">
    <div class="main_text">
      <router-link
        class="top_notice router-link-exact-active fs-5"
        to="/shop/notice"
        >공지사항</router-link
      >
      |
      <router-link class="top_notice2 text-decoration-none" to="/shop/faqList"
        >FAQ</router-link
      >
    </div>
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
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
          </tr>
        </thead>
        <tbody>
          <!-- 반복문 시작할 행 -->

          <tr
            v-for="(data, index) in notice"
            :key="index"
            @click="goNoticeCheck"
          >
            <th scope="col">
              <router-link
                :to="'/shop/notice-check/' + data.announcementId"
                class="router-link-exact-active cencle"
              >
                {{ data.announcementId }}</router-link
              >
            </th>

            <th scope="col">
              <router-link
                :to="'/shop/notice-check/' + data.announcementId"
                class="router-link-exact-active cencle"
              >
                {{ data.title }}
              </router-link>
            </th>
            <th scope="col">ADMIN</th>
          </tr>
        </tbody>
      </table>

      <!-- 페이징 -->
      <!-- {/* paging 시작 */} -->
      <div class="row justify-content-center mt-4">
        <div class="col-auto">
          <b-pagination
            class="col-12 mb-3"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveNotice"
          ></b-pagination>
        </div>
      </div>

      <!-- 관리자 등록 버튼 :: 공지사항 글등록으로 이동-->
      <div class="row justify-content-end">
        <button type="button" id="button1" class="mt-5 btn">
          <router-link to="/shop/admin-notice" class="router-link-exact-active"
            >공지사항 등록</router-link
          >
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import NoticeListService from "@/services/noticeQnA/NoticeListService";
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
      notice: [],
      searchTitle: "",

      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // 전체조회 함수
    async retrieveNotice() {
      try {
        // TODO: 1) 공통 전체조회 함수 실행
        let response = await NoticeListService.getAll(
          this.searchTitle, // 검색어
          this.page - 1, // 현재페이지번호-1
          this.pageSize // 1페이지당개수(size)
        );

        console.log("여기는 프론트" + response.data);
        // TODO: 복습 : 2) 객체분할 할당
        const { notice, totalItems } = response.data; // 부서배열(벡엔드 전송)
        // TODO: 3) 바인딩변수(속성)에 저장
        this.notice = notice; // 부서배열(벡엔드 전송)
        this.count = totalItems; // 전체페이지수(벡엔드 전송)
        // TODO: 4) 프론트 로깅 : console.log
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // goNoticeCheck(){
    //   this.$router.push("/shop/notice-check");
    // }
  },
  // 조회
  mounted() {
    this.retrieveNotice();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
