<!-- InquiryUpdate.vue :: 
    문의글 수정페이지 -->
<template>
  <div class="mb-5 col-13">
    <!-- 카테고리 -->
    <h5 class="text-center main_text">상품문의글 수정</h5>
    <br />
    <div class="box_border">
      <div class="col-12 mb-3">
        <label class="mb-3 text-left"> 제목 </label>
        <input
          type="text"
          class="borderA form-control"
          id="exampleFormControlInput1"
          placeholder=""
          v-model="qnaList.qnaTitle"
        />
      </div>
      <!-- 본문적는곳 -->
      <div class="mb-3">
        <label
          for="exampleFormControlTextarea1"
          class="mt-3 form-label text-left"
          >내용</label
        >
        <textarea
          class="borderA form-control"
          id="exampleFormControlTextarea1"
          rows="15"
          v-model="qnaList.qnaContent"
        ></textarea>
      </div>
    </div>
    <!--  문의글 버튼 -->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 관리자 페이지로 이동 -->
      <button id="button2" class="btn me-md-2" type="button" @click="deleteQna">
        취소
      </button>
      <!-- 등록시 공지사항 목록으로 재이동 -->
      <button
        id="button1"
        class="btn"
        type="button"
        @click="updateQna"
      >
        수정완료
      </button>
    </div>
  </div>
</template>
<script>
import QnaService from '@/services/product/QnaService';
export default {
  data() {
    return {
      message: "", // 성공메세지 변수
      // TODO: 저장(추가:insert) 함수 : CRUD (비동기)
      // TODO: 비동기 코딩 : async ~ await
      // 그외의걸 담을 객체
      qnaList: {}
    };
  },
  methods: {
    // 상세조회
    async getQnaId(qnaId) {
      try {
        // 상세조회 공통함수 실행 :faqListService.getfaqId()
        let response = await QnaService.getQnaId(qnaId);
        this.qnaList = response.data; // spring 결과를 바인딩 속성변수 faq 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },

    // 수정요청함수
    async updateQna() {
      try {
        // console.log(this.faqList);
        // console.log("여기는 프론트" + this.faqList);
        let response = await QnaService.update(
          this.qnaList.qnaId,
          this.qnaList
        );
        alert("수정이 완료되었습니다.");
        this.$router.push("/product/inquiry/detail/" + this.qnaList.qnaId);
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },

    async deleteQna(){
      try {
        alert("수정이 취소되었습니다.");
        this.$router.push("/product/inquiry/detail/" + this.qnaList.qnaId);
      } catch (error) {
        console.log(error);
      }
    }
  },
  mounted() {
    window.scrollTo(0, 0);
    this.getQnaId(this.$route.params.qnaId); // 상세조회 실행
    this.message = ""; //초기화
  },
};
</script>
<style>
@import "@/assets/css/Button.css";
</style>
