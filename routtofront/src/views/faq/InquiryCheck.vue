<!-- inquiryCheck.vue :: Add문의 등록 form-->
<template>
  <div class="mt-5 mb-5 col-13" v-if="faqList">
    <!-- 카테고리 -->
    <div class="container">
      <h2 class="mb-5 main_text">문의사항</h2>
      <table class="table table-bordered">
        <tbody>
          <tr>
            <th scope="row" class="col-2">제목</th>
            <td>{{ faqList.faqTitle }}</td>
          </tr>
          <tr>
            <th scope="row">문의유형</th>
            <td>{{ faqList.faqType }}</td>
          </tr>
          <tr>
            <th scope="row">내용</th>
            <td>
              {{ faqList.faqContent }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <!-- <router-link :to="'/shop/inquiry-update/' + faqList.userId">
        <button id="button1" class="btn btn-primary" type="button">수정</button>
      </router-link>
      <button
        
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="deleteFaq"
      >
        삭제
        {{ faqList.userId }}
      </button> -->
      <!-- <router-link
        v-if="faqList.userId === this.$store.state.user.userId"
        :to="'/shop/inquiry-update/' + faqList.faqId"
      >
        <button id="button1" class="btn btn-primary" type="button">수정</button>
      </router-link> -->

      <!-- <button
        v-if="faqList?.userId === this.$store.state.user.userId"
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="deleteFaq"
      >
        삭제
      </button> -->
      <button
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="deleteFaq"
      >
        삭제
      </button>
    </div>
  </div>
</template>

<script>
import FaqListService from "@/services/noticeQnA/FaqListService";
export default {
  data() {
    return {
      // 배열일경우만 list
      faqList: {
        faqId: this.$route.params.faqId,
        userId: "", // userId,
        faqTitle: "",
        faqContent: "",
        faqType: "",
      }, // 단일 문의사항을 저장할 객체
    };
  },
  methods: {
    async get(faqId) {
      // todo: 공통 상세조회 함수: get()
      // 비동기 코딩!!!!
      try {
        let response = await FaqListService.getFaqId(faqId);
        this.faqList = response.data; //spring 결과 -> announcement 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    async deleteFaq() {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await FaqListService.delete(this.faqList.faqId);
        // 로깅
        console.log(response.data);
        this.$router.push("/shop/faqList");
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },
    // 패스워드 쓰지않음
    // goUapdate() {
    //   this.$router.push('/inquiry-update'+faq.faqId);
    // },
  },
  mounted() {
    this.get(this.$route.params.faqId);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
