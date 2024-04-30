<!-- NoticeCheck.vue -->
<template>
  <div class="mt-5 mb-5 col-13">
    <!-- 카테고리 -->
    <div class="container">
      <h2 class="mb-5">공지사항</h2>
      <table class="table table-bordered">
        <tbody>
          <tr>
            <th scope="row" class="col-2">제목</th>
            <td>{{ notice.title }}</td>
          </tr>

          <tr>
            <th scope="row">내용</th>
            <td>
              {{ notice.content }}
            </td>
          </tr>
          <tr>
            <th scope="row">첨부파일</th>
            <td>
              <a href="#">{{ notice.noticeImg }}</a>
            </td>
          </tr>
          <!-- Add more rows as needed -->
        </tbody>
      </table>
    </div>

    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <button id="button1" class="btn btn-primary" type="button">
        <router-link to="/shop/admin-notice" class="router-link-exact-active"
          >수정</router-link
        >
      </button>
      <button
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="deleteNotice"
      >
        삭제
      </button>
    </div>
  </div>
</template>

<script>
import NoticeListService from "@/services/noticeQnA/NoticeListService";
export default {
  data() {
    return {
      notice: {
        // 웹 매개변수 전달방식 :: 필기옮겨오기
        // todo: 사용법 : this.$router.params.기본키명
        // todo: 참조) router/index.js=>path: /fileDb/:uuid
        // tpdo : 2개의 변수명이 일치해야함 : uuid
        announcementId: this.$route.params.announcementId,
        title: "",
        content: "", 
        announcementImg: "",
        announcementImgUrl: "",
        announcementImgUuid: "",
      },

      // 단일 문의사항을 저장할 객체
    };
  },
  methods: {
    async getPost() {
      try {
        // 특정 fnqID에 해당하는 문의사항 데이터 받아오기
        let announcementId = this.$route.params.announcementId; // 라우터의 fnqID 파라미터 가져오기
        // 상세조회 2 fnq id
        let response = await NoticeListService.getNoticeId(announcementId); // 백엔드에서 해당 ID에 해당하는 문의사항 데이터 받아오기
        this.notice = response.data; // 받아온 데이터를 inquiry 객체에 저장
      } catch (e) {
        console.log(e);
      }
    },
    async get(announcementId) {
      // todo: 공통 상세조회 함수: get()
      // 비동기 코딩!!!!
      try {
        let response = await NoticeListService.getNoticeId(announcementId);
        this.notice = response.data; //spring 결과 -> fileDb 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    async deleteNotice(announcementId) {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await NoticeListService.remove(announcementId);
        // 로깅
        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    this.get(this.$route.params.announcementId);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
