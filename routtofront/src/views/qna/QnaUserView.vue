<!-- qna -> writerId -->
<template>
  <div class="text-center">
    <h4 class="mb-5 main_text" style="text-align: left">내가 쓴 글</h4>
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
        <tr v-for="(data, index) in qnaList" :key="index">
          <th scope="row">
            {{ data.qnaId }}
          </th>
          <td class="col-8">
            <router-link :to="`/product/inquiry/detail/${data.qnaId}`" style="text-decoration: none;" class="alltext router-link-exact-active custom-pagination">{{
              data.qnaTitle
            }}</router-link>
          </td>
          <td>
            {{ data.writerId }}
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
          @click="retrieveQnaUserId"
        ></b-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import QnaService from "@/services/product/QnaService";

export default {
  data() {
    return {
      qnaList: [],
      writerId: this.$store.state.user.userId,
      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 10, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // 전체조회 함수
    async retrieveQnaUserId() {
      try {
        // TODO: 1) 공통 전체조회 함수 실행
        let response = await QnaService.getAllUserId(
          this.writerId, // 검색어
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
    this.retrieveQnaUserId();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
