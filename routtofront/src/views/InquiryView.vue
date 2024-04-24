<!-- InquiryView.vue :: Add문의 등록 form-->
<template>
  <div class="mt-5 mb-5 col-13">
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
        v-model="faq.faqTitle"
      />
    </div>
    <div class="col-4">
      <label class="mb-3 text-left">문의 유형 </label>
      <select
        class="form-control form-select"
        aria-label="Default select example"
        v-model="faq.faqType"
      >
        <option selected>문의내용</option>
        <option value="1">상품문의</option>
        <option value="2">배송문의</option>
        <option value="3">기타문의</option>
      </select>
    </div>

    <div class="mb-3">
      <!-- 회원아이디 -->
      <label for="exampleFormControlInput1" class="form-label mt-3 text-left">
        ID</label
      >
      <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="id를 적어주세요"
        v-model="faq.userId"
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
        v-model="faq.faqContent"
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
        <router-link to="/" class="cencle router-link-exact-active"
          >취소</router-link
        >
      </button>
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <button
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="createFaq"
      >
        <router-link to="/faqList" class="router-link-exact-active"
          >등록</router-link
        >
      </button>
    </div>
  </div>
</template>

<script>
import FaqListService from "@/services/noticeQnA/FaqListService";
export default {
  // 바인딩속성정의
  data() {
    return {
      message: "", // 성공메세지 변수
      // TODO: 저장(추가:insert) 함수 : CRUD (비동기)
      // TODO: 비동기 코딩 : async ~ await
      // 그외의걸 담을 객체
      faq: {
        userId: this.faq.userId, //유저 아이디 입력
        faqId: this.faq.faqId, //faqID 자동으로 매겨져야하는데 이건 나중에 백엔드에서 알아보기
        faqTitle: this.faq.faqTitle, // 제목
        faqType: this.faq.faqType, //유형
        faqContent: this.faq.faqContent, //내용
        faqPassword: this.faq.faqPassword, //게시글 패스워드
      },
      faqImg: undefined, // 이미지 담을 빈객체
    };
  },
  methods: {
    // TODO: 파일 선택상자에서 이미지 선택하면 변수에 저장하는 함수
    selectImage() {
      // 1) 파일선택상자에서 1st 로 선택한 이미지를 변수에 저장
      // ref="file" 접근 -> 내부 속성 : files[번호]
      // TODO: 사용법 : this.$refs.변수명 => input type="file" ref="변수명" 태그 접근
      this.faqImg = this.$refs.file.files[0];
      // 성공메세지 변수 초기화
      this.message = "";
    },
    // 이미지 제외 전체 객체 전달 하기(생성하기) :::: addfileDB참고
    async createFaq() {
      try {
        // TODO: 벡엔드로 객체 추가 요청
        let response = await FaqListService.create(this.faq, this.faqImg);
        // TODO: 콘솔에 결과 출력
        console.log(response);
        this.message = response.data;
      } catch (e) {
        // 현재선택된 이미지 변수 초기화
        this.faqImg = undefined;
        this.message = "";
        console.log(e);
      }
    },
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
