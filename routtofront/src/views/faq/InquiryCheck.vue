<!-- inquiryCheck.vue :: Add문의 등록 form-->
<template>
  <div class="mb-5 col-13" v-if="faqList">
    <!-- 카테고리 -->
    <div class="container">
      <h2 class="mb-5 main_text">문의사항</h2>
      <table class="borderA table table-bordered">
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
            <th scope="row" class="table_check">내용</th>
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
      <div v-if="faqList.userId === this.$store.state.user.userId">
        <router-link :to="'/shop/inquiry-update/' + faqList.faqId">
          <button id="button1" class="btn btn-primary" type="button">
            수정
          </button>
        </router-link>
        <button id="button1" class="btn" type="button" @click="deleteFaq">
          삭제
        </button>
      </div>
    </div>

    <!-- TODO: 관리자 수정 댓글 창 -->
    <div class="mt-5 row rebox text-aling"
    v-if="this.$store.state.user.role=='ROLE_ADMIN'"
    >
      <label for="username" class="mt-5 col-sm-1 col-form-label">제목</label>
      <div class="col-sm-8">
        <input
          type="text"
          class="mt-5 borderA form-control"
          id="username"
          v-model="reTitle"
          placeholder="이름을 입력하세요"
        />
      </div>
      <!-- 댓글 입력 -->
      <div class="row mt-3">
        <label for="comment" class="col-sm-1 col-form-label">답변</label>
        <div class="col-sm-11">
          <textarea
            class="borderA form-control"
            id="comment"
            rows="5"
            placeholder="답변을 입력하세요"
          ></textarea>
        </div>

        <!-- 등록답변 -->
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <button
            id="button1"
            class="mt-4 btn"
            type="button"
            @click="deleteFaq"
          >
            답변
          </button>
        </div>
      </div>
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
  },
  mounted() {
    this.get(this.$route.params.faqId);
    window.scrollTo(0, 0);
  },
  computed: {
    reTitle() {
      return "RE:  " + this.faqList.faqTitle;
    },
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
