<!-- ProductsInquiryDetail.vue :: 
  등록글 상세조회
  댓글
  admin v-if로 댓글 답변 등록가능
  Add문의 등록 form-->
<template>
  <div class="mb-5 col-13">
    <!-- 카테고리 -->
    <div class="container">
      <h4 class="mb-5 main_text">상품문의</h4>
      <table class="borderA table table-bordered">
        <tbody>
          <tr>
            <th scope="row" class="col-2">제목</th>
            <td>{{ qnaList.qnaTitle }}</td>
          </tr>
          <tr>
            <th scope="row" class="table_check">내용</th>
            <td>
              {{ qnaList.qnaContent }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 등록시 고객센터 글 목록으로 재이동 :: -->
      <!-- TODO: v-if , 본인아이디가 아니면 수정과 삭제가 안보이게 해둠-->
      <!--챗지피티가 제시해준 오류수정 
        근데 role null오류가 또 뜸-> TODO: 선생님이 널값 방지용으로 ? 사용법 알려줌 user?.userId로 수정하니 됨
        <div v-if="faqList && this.$store.state.user && faqList.userId === this.$store.state.user.userId"> -->
      <div v-if="qnaList.writerId=== this.$store.state.user?.userId">
        <router-link :to="'/product/inquiry/update/' + qnaList.qnaId">
          <button id="button1" class="btn" type="button">
            수정
          </button>
        </router-link>
        <button id="button1" class="btn" type="button" @click="deleteQna">
          삭제
        </button>
      </div>
    </div>

    <!-- <div class="container"> -->
      <!-- TODO: 회원한테 보이는 답변댓글 (상세)조회창 -->

      <!-- <div class="re_div">
        <h5 class="text-main"></h5>
        {{ this.faqList.faqAnswer }}
        <div class="row justify-content-end">
          <div class="col-auto mt-5">
            <p class="updateTime">{{ this.faqList.updateTime }}</p>
          </div>
        </div>
      </div> -->

      <!-- TODO: 관리자 수정 댓글 창 -->
      <!-- <div
        class="mt-5 row rebox text-aling"
        v-if="this.$store.state.user?.role == 'ROLE_ADMIN'"
      >
        <h5 class=""></h5> -->

        <!-- 댓글 입력 -->
        <!-- <div class="row mt-3">
          <label for="comment" class="col-sm-5 col-form-label main_text"
            >No: {{ faqList.faqId }} 관리자 답변</label
          > -->
          <!-- <div class="col-sm-12">
            <textarea
              class="borderA form-control"
              id="comment"
              rows="8"
              v-model="this.faqList.faqAnswer"
            ></textarea>
          </div> -->

          <!-- 등록답변 -->
          <!-- <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button
              id="button1"
              class="mt-4 btn"
              type="button"
              @click="updateFaqAnswer"
            >
              답변등록
            </button>
          </div> -->
        <!-- </div> -->
      <!-- </div> -->
    <!-- </div> -->
  </div>
</template>

<script>
import QnaService from '@/services/product/QnaService';

export default {
  data() {
    return {
      // 배열일경우만 list
      qnaList: {
        qnaId: this.$route.params.qnaId,
        prodId: "",
        qnaTitle: "",
        qnaContent: "",
        writerId: "",
        // faqAnswer: "",
        // UPDATE_TIME
        updateTime: "",
      }, // 단일 문의사항을 저장할 객체
    };
  },
  methods: {
    // qnaId로 상세조회 : 화면뜰 때 실행
    async retrieveGet(qnaId) {
      try {
        let response = await QnaService.getQnaId(qnaId);
        this.qnaList = response.data; 
        console.log(response.data);
      } catch (e) {
        alert("에러");
        console.log(e);
      }
    },

    // 문의글 삭제 함수
    async deleteQna() {
      try {
        let response = await QnaService.delete(this.qnaList.qnaId);
        this.$router.push("/product/" + this.qnaList.qnaId);
        // 로깅
        console.log(response.data);
        alert("문의글이 삭제되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },

    // 답변 저장함수
    async updateFaqAnswer() {
      try {
        console.log("11", this.qnaList.qnaId, this.faqList.faqAnswer);
        // TODO: 비동기 코딩 : async ~ await
        // TODO: 객체가 전체가넘어가야함 수정이어도 하나만 수정하기 불가능 한듯?
        let response = await FaqListService.updateAnswer(
          this.faqList.faqId,
          this.faqList
        );
        console.log("22");

        this.$router.push("/shop/inquiry-check/" + this.faqList.faqId);
        // 로깅
        console.log(response.data);
        // 화면에 성공메세지 출력 : message
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    window.scrollTo(0, 0);
    this.retrieveGet(this.$route.params.qnaId);
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