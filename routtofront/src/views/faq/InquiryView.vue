<!-- InquiryView.vue :: Add문의 등록 form-->
<template>
  <div class="mt-5 mb-5 col-13">
    <!-- 카테고리 -->
    <h5 class="text-center main_text">문의사항</h5>
    <br />
    <div class="box_border">
      <div class="col-12 mb-3">
        <label class="mb-3 text-left">제목 </label>
        <input
          type="text"
          class="borderA form-control"
          id="exampleFormControlInput1"
          placeholder="제목 적어주세요"
          v-model="faq.faqTitle"
        />
      </div>
      <div class="col-4">
        <label class="mb-3 text-left">문의 유형 </label>
        <select
          class="borderA form-select "
          aria-label="Default select example"
          v-model="faq.faqType"
        >
          <option selected>문의내용</option>
          <option value="상품문의">상품문의</option>
          <option value="배송문의">배송문의</option>
          <option value="기타문의">기타문의</option>
        </select>
      </div>
      <div class="mb-3">
      <!-- 회원아이디 ::이거 로그인 한 사람 아이디 어캐 불러오지?
      <label for="exampleFormControlInput1" class="form-label mt-3 text-left">
        ID</label
      > -->
      <!-- <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="id를 적어주세요"
        v-model="faq.userId"
      /> -->
    </div>
    <!-- 본문적는곳 -->
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="form-label text-left"
        >내용</label
      >
      <textarea
        class="borderA form-control"
        id="exampleFormControlTextarea1"
        rows="10"
        v-model="faq.faqContent"
      ></textarea>
    </div>
    </div>

   

    <!-- 비밀번호 등록 -->
    <!-- <div class="mb-3 row">
      <label for="inputPassword" class="col-sm-2 col-form-label"
        >Password</label
      >
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword" />
      </div>
    </div> -->

    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 메인 페이지로 이동 -->
      <button id="button2" class="btn me-md-2" type="button">
        <router-link to="/" class="alltext router-link-exact-active"
          >취소</router-link
        >
      </button>
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <button
        id="button1"
        class="btn"
        type="button"
        @click="saveFaq"
      >
        등록
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
      // TODO: 저장(추가:insert) 함수 : CRUD (비동기)
      // TODO: 비동기 코딩 : async ~ await
      faq: {},
      // submitted: false  // 저장버튼 클릭하면 true 바뀜
    };
  },
  methods: {
    //  저장함수
    async saveFaq() {
      try {
        // 임시 객체 변수
        let data = {
          faqTitle: this.faq.faqTitle,
          userId: this.$store.state.user.userId, //TODO:  아이디 불러오는것
          faqType: this.faq.faqType,
          faqContent: this.faq.faqContent,
        };

        // TODO: 벡엔드로 객체 추가 요청
        let response = await FaqListService.create(data);
        this.$router.push("/shop/faqList");
        // TODO: 콘솔에 결과 출력
        console.log(response);
        // this.submitted = true; // 저장유무변수=true 변경
      } catch (e) {
        console.log(e);
      }
    },
  },mounted() {
    
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
