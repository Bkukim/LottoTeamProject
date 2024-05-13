<!-- 고객센터 faq->UserId view -->
<template>
    <div class="mt-5 text-center">
      <h4 class="mb-5 main_text" style="text-align: left;">내 글 찾기</h4>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">번호 </th>
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
                {{ data.faqId }}
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
            class="col-12 mb-3"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveFaq"
          ></b-pagination>
        </div>
      </div>

      <!-- 질문하기 등록-->
      <div class="row justify-content-end">
        <button type="button" id="button1" class="mt-5 btn">
          <router-link to="/shop/inquiry" class="router-link-exact-active"
            >질문하기</router-link
          >
        </button>
      </div>
      
    </div>
  
</template>

<script>
import FaqListService from "@/services/noticeQnA/FaqListService";

export default {
  data() {
    return {
      faqList: [],
      userId:this.$store.state.user.userId,
      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // 전체조회 함수
    async retrieveFaqUserId() {
      try {
        // TODO: 1) 공통 전체조회 함수 실행
        let response = await FaqListService.getAllUserId(
          this.userId, // 검색어
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

    // 삭제함수
    async deleteFaq() {
      try {
        let response = await FaqListService.delete(this.faqList.faqId);
        this.$router.push("/shop/faqList");

        // 로깅
        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");
      } catch (e) {
        alert("로그아웃");
        console.log(e);
      }
    },
    
  },
  mounted() {
    this.retrieveFaqUserId()
    window.scrollTo(0, 0); 
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
