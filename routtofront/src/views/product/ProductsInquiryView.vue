<!-- ProductsInquiryView.vue :: Add문의 등록 form-->
<template>
  <div class="mt-5 mb-5 col-13">
    <h5 class="text-center main_text">상품문의 작성</h5>

    <br />
    <div class="box_border">
      <div class="col-12 mb-3">
        <label class="mb-3 text-left">제목 </label>
        <input
          type="text"
          class="borderA form-control"
          id="exampleFormControlInput1"
          placeholder="제목을 적어주세요"
          v-model="qna.qnaTitle"
        />
      </div>

      <div class="col-4">
        <label class="mb-3 text-left">작성자</label>
        <div class="col-6">
          <input
            class="form-control"
            type="text"
            name="user"
            v-model="user.userId"
            disabled
          />
        </div>
      </div>
      <div class="mb-3"></div>

      <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label text-left"
          >내용</label
        >
        <textarea
          class="borderA form-control"
          id="exampleFormControlTextarea1"
          rows="10"
          v-model="qna.qnaContent"
        ></textarea>
      </div>
    </div>

    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 문의 리스트 페이지로 이동 -->
      <button
        id="button2"
        class="btn btn-primary me-md-2"
        type="button"
        @click="goDelete"
      >
        취소
      </button>
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <button id="button1" class="btn" type="button" @click="saveQna">
        등록
      </button>
    </div>
  </div>
</template>

<script>
import QnaService from "@/services/product/QnaService";
export default {
  data() {
    return {
      user: {
        userId: this.$store.state.user.userId,
        //  password;
        //  userName;
        //  birthday;
        //  phoneNum;
        //  callNum;
        //  email;
        //  role;
        //  normalAddress;
        //  detailAddress;
      },
      // TODO: 저장(추가:insert) 함수 : CRUD (비동기)
      // TODO: 비동기 코딩 : async ~ await
      qna: {
        // qnaId:"",
        prodId: "",
        qnaTitle: "",
        qnaContent: "", // 화면에 처음 보이는 초기값, 입력시 여기로 들어오고 아래 let data로 들어가서, qnaTitle로 들어가서 함수실행. 위 html과 바인딩하려면 여기 명과 같아야함
      },
      // submitted: false  // 저장버튼 클릭하면 true 바뀜
    };
  },
  methods: {
    // 취소 버튼
    goDelete() {
      alert("상품문의가 취소되었습니다.");
      this.$router.push("/product/" + this.$route.params.prodId);
    },

    //  저장함수
    async saveQna() {
      // 임시 객체 변수
      let data = {
        prodId: this.$route.params.prodId,
        qnaTitle: this.qna.qnaTitle,
        writerId: this.user.userId,
        qnaContent: this.qna.qnaContent,
      };

      try {
        // TODO: 벡엔드로 객체 추가 요청
        let response = await QnaService.create(data);
        alert("상품문의가 등록되었습니다.");
        this.$router.push("/product/" + this.$route.params.prodId);
        // console.log(this.$route);
        // TODO: 콘솔에 결과 출력
        console.log(response);
        // this.submitted = true; // 저장유무변수=true 변경
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
