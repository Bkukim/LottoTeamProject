<!-- InquiryView.vue :: Add문의 등록 form-->
<template>
  <div class="mt-5 mb-5  col-13">
    <!-- 카테고리 -->
    <h5 class="text-center">문의사항</h5>
    <br />
    <div class="col-4 mb-3">
      <label class="mb-3 text-left">제목 </label>
      <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="제목 적어주세요"
      />
    </div>
  <div class="col-4">
    <label class="mb-3 text-left">문의 유형 </label>
    <select
        class="form-control form-select"
        aria-label="Default select example"
      >
        <option selected>문의내용</option>
        <option value="1">상품문의</option>
        <option value="2">배송문의</option>
        <option value="3">기타문의</option>
      </select>
  </div>

    <div class="mb-3">
      <!-- 이메일 주소 -->
      <label for="exampleFormControlInput1" class="form-label mt-3 text-left"
        > ID</label
      >
      <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="id를 적어주세요"
      />
    </div>
    <!-- 본문적는곳 -->
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="form-label text-left"
        >내용</label
      >
      <textarea
        class="form-control"
        id="exampleFormControlTextarea1"
        rows="10"
      ></textarea>
    </div>
    <!-- 첨부파일 -->
    <div class="mb-3">
      <label for="formFileSm" class="form-label text-left">첨부파일 </label>
      <input class="form-control" id="formFileSm" type="file" />
    </div>

    <!-- 비밀번호 등록 -->
    <div class="mb-3 row">
      <label for="inputPassword" class="col-sm-2 col-form-label"
        >Password</label
      >
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword" />
      </div>
    </div>

    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 메인 페이지로 이동 -->
      <button id="button2" class="btn btn-primary me-md-2" type="button">
        <router-link to="/" class="cencle router-link-exact-active">취소</router-link>
      </button>
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <button id="button1" class="btn btn-primary" type="button">
        <router-link to="/faqList" class=" router-link-exact-active">등록</router-link>
      </button>
    </div>
  </div>
</template>

<script>
import FaqListService from "@/services/noticeQnA/FaqListService"
export default {
  // 바인딩속성정의
data() {
  return {
    faq: [], //빈객체
    submitted: false,
 // TODO: 저장(추가:insert) 함수 : CRUD (비동기)
        // TODO: 비동기 코딩 : async ~ await 
        async saveFaq() {
            try {
                // 임시 객체 변수 , 제목, 아이디, 내용, 첨부파일, 패스워드
                let data = {
                  faqId: this.faq.faqId,
                  faqTitle: this.faq.faqTitle,
                  faqContent: this.faq.faqContent,
                  faqImg: this.faq.faqImg,
                  faqPassword: this.faq.faqPassword,

                };

                // TODO: 벡엔드로 객체 추가 요청
                let response = await FaqListService.create(data);
                // TODO: 콘솔에 결과 출력
                console.log(response);
                this.submitted = true; // 저장유무변수=true 변경
            } catch(e) {
                console.log(e);
            }
        },
  }
},
methods: {
  
},
  
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
