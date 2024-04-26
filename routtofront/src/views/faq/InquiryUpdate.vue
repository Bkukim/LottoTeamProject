<!-- InquiryUpdate.vue :: 
    문의글 수정페이지 -->
<template>
    <div class="mt-5 mb-5 col-13">
    <!-- 카테고리 -->
    <h5 class="text-center">문의글 수정</h5>
    <br />
    <div class="col-4 mb-3">
      <label class="mb-3 text-left">제목 </label>
      <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder=""
        v-model="faq.title"
      />
    </div>
    <!-- 본문적는곳 -->
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="mt-3 form-label text-left"
        >내용</label
      >
      <textarea
        class="form-control"
        id="exampleFormControlTextarea1"
        rows="15"
        v-model="faq.content"
      ></textarea>
    </div>
    <!-- 첨부파일 -->
    <div class="mb-3">
      <label for="formFileSm" class="form-label text-left">첨부파일 </label>
      <input
        class="form-control"
        id="formFileSm"
        type="file"
        @click="selectImage"
      />
    </div>

    <!--  문의글 버튼 -->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 관리자 페이지로 이동 -->
      <button id="button2" class="btn btn-primary me-md-2" type="button">
        <router-link to="/faqList" class="cencle router-link-exact-active"
          >취소</router-link
        >
      </button>
      <!-- 등록시 공지사항 목록으로 재이동 -->
      <button
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="updateFaq"
      >
        <router-link to="/faqList" class="router-link-exact-active"
          >등록</router-link
        >
      </button>
    </div>
  </div>
</template>
<script>
import FaqListService from "@/services/noticeQnA/FaqListService"
export default {
  data() {
    return {
      message: "", // 성공메세지 변수
      // TODO: 저장(추가:insert) 함수 : CRUD (비동기)
      // TODO: 비동기 코딩 : async ~ await
      // 그외의걸 담을 객체
      faq: {
        faqId: this.$route.params.faqId, //faqID 자동으로 매겨져야하는데 이건 나중에 백엔드에서 알아보기
        userId: "", //유저 아이디는 로그인시 적용이 되어야할텐데 ㅅㅍ 모르것네 이건 원리를
        faqTitle: "", // 제목
        faqType: "", //유형
        faqContent: "", //내용
        faqPassword: "", //게시글 패스워드
      },
      faqImg: undefined, // 이미지 담을 빈객체
    }
  },
  methods: {
    // 상세조회
    async getFaqId(faqId) {
      try {
        // 상세조회 공통함수 실행 :faqListService.getfaqId()
        let response = await FaqListService.getFaqId(faqId);
        this.faq = response.data; // spring 결과를 바인딩 속성변수 faq 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // 이미지 선택함수
    selectImage() {
      // todo: 파일 선택 상자에서 1st 선택한 이미지를 currentImage 변수에 저장
      // 사용법 this.faqImg=this.$refs.변수명.files[0]
      this.faqImg = this.$refs.file.files[0]; // 파일 선택상자에서 가지고 있음  고정 : files[0]
    },
    // 수정요청함수
    async updateFaq() {
      try {
        // TODO: 비동기 코딩 : async ~ await
        let response = await FaqListService.update(
          this.faq,
          this.faqImg
        );
        // 로깅
        console.log(response.data);
        // 화면에 성공메세지 출력 : message
        this.message = "수정에 성공했습니다.";
      } catch (e) {
        this.faqImg = undefined; //초기화
        this.message = "에러" + e; //에러출력
        console.log(e);
      }
    },
    
  },
  mounted() {
    this.getFaqId(this.$route.params.faqId); // 상세조회 실행
    this.message = ""; //초기화
  },
    
}
</script>
<style>
    
</style>