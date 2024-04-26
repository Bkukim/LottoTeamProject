<!-- inquiryCheck.vue :: Add문의 등록 form-->
<template>
  <div class="mt-5 mb-5 col-13">
    <!-- 카테고리 -->
    <div class="container">
      <h2 class="mb-5">문의사항</h2>
      <table class="table table-bordered">
        <tbody>
          <tr>
            <th scope="row" class="col-2">제목</th>
            <td>{{inquiry.faqTitle}}</td>
          </tr>
          <tr>
            <th scope="row">문의유형</th>
            <td>{{inquiry.faqType}}</td>
          </tr>
          <tr>
            <th scope="row">내용</th>
            <td>
              {{inquiry.faqContent}}
            </td>
          </tr>
          <tr>
            <th scope="row">첨부파일</th>
            <td><a href="#">{{ inquiry.faqImg }}</a></td>
          </tr>
          <!-- Add more rows as needed -->
        </tbody>
      </table>
      
    </div>


    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <button id="button1" class="btn btn-primary" type="button" @click="goUapdate">
        수정
      </button>
    </div>
  </div>
</template>

<script>
import FaqListService from "@/services/noticeQnA/FaqListService";
export default {
  data() {
    return {
      inquiry: {} // 단일 문의사항을 저장할 객체
    };
  },
  methods: {
    async getPost() {
    try {
      // 특정 fnqID에 해당하는 문의사항 데이터 받아오기
      let faqId = this.$route.params.faqId; // 라우터의 fnqID 파라미터 가져오기
      // 상세조회 2 fnq id
      let response = await FaqListService.getFaqId(faqId); // 백엔드에서 해당 ID에 해당하는 문의사항 데이터 받아오기
      this.inquiry = response.data; // 받아온 데이터를 inquiry 객체에 저장
    } catch (e) {
      console.log(e);
    }
  }
  ,
  // 패스워드 쓰지않음
  goUapdate() {
      this.$router.push("/inquiry-update");
    },
  },
  

};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
