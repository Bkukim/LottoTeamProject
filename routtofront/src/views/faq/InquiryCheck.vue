<!-- inquiryCheck.vue :: 
  등록글 상세조회
  댓글
  admin v-if로 댓글 답변 등록가능
  Add문의 등록 form-->
<template>
  <!-- v-ㅑㄹ -->
  <div class="mb-5 col-13">
    <!-- 카테고리 -->
    <div class="container">
      <h4 class="mb-5 main_text">문의사항</h4>
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
      <!-- 등록시 고객센터 글 목록으로 재이동 :: -->
      <!-- TODO: v-if , 본인아이디가 아니면 수정과 삭제가 안보이게 해둠-->
      <!--챗지피티가 제시해준 오류수정 
        근데 role null오류가 또 뜸-> TODO: 선생님이 널값 방지용으로 ? 사용법 알려줌 user?.userId로 수정하니 됨
        <div v-if="faqList && this.$store.state.user && faqList.userId === this.$store.state.user.userId"> -->
      <div v-if="faqList.userId === this.$store.state.user?.userId">
        <router-link :to="'/shop/inquiry-update/' + faqList.faqId">
          <button id="button1" class="btn" type="button">
            수정
          </button>
        </router-link>
        <button id="button1" class="btn" type="button" @click="deleteFaq">
          삭제
        </button>
      </div>
    </div>

    <div class="container">
      <!-- TODO: 회원한테 보이는 답변댓글 (상세)조회창 -->

      <div class="re_div">
        <h5 class="text-main"></h5>
        {{ this.faqList.faqAnswer }}
        <div class="row justify-content-end">
          <div class="col-auto mt-5">
            <p class="updateTime">{{ this.faqList.updateTime }}</p>
          </div>
        </div>
      </div>

      <!-- TODO: 관리자 수정 댓글 창 -->
      <div
        class="mt-5 row rebox text-aling"
        v-if="this.$store.state.user?.role == 'ROLE_ADMIN'"
      >
        <h5 class=""></h5>

        <!-- 댓글 입력 -->
        <div class="row mt-3">
          <label for="comment" class="col-sm-5 col-form-label main_text"
            >No: {{ faqList.faqId }} 관리자 답변</label
          >
          <div class="col-sm-12">
            <textarea
              class="borderA form-control"
              id="comment"
              rows="8"
              v-model="this.faqList.faqAnswer"
            ></textarea>
          </div>

          <!-- 등록답변 -->
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button
              id="button1"
              class="mt-4 btn"
              type="button"
              @click="updateFaqAnswer"
            >
              답변등록
            </button>
          </div>
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
        faqAnswer: "",
        // UPDATE_TIME
        updateTime: "",
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
        alert("로그아웃");

        console.log(e);
      }
    },
    async deleteFaq() {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
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

    // 답변저장
    //  저장함수
    async updateFaqAnswer() {
      try {
        console.log("11", this.faqList.faqId, this.faqList.faqAnswer);
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
