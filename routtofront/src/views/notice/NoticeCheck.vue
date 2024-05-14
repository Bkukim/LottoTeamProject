<!-- NoticeCheck.vue ::공지사항 상세조회-->
<template>
  <div class="mb-5 col-13">
    <!-- 카테고리 -->
    <div class="container">
      <h4 class="main_text">공지사항</h4>
      <table scope="row" class="table table-bordered borderA">
        <tbody>
          <tr>
            <th scope="row" class="col-1">제목</th>
            <td>{{ announcement.title }}</td>
          </tr>

          <tr>
            <th scope="row">내용</th>
            <td>
              {{ announcement.content }}
              <br />
              <br />
              <img
                :src="announcement.announcementImgUrl"
                class="img_size"
                alt="첨부이미지"
              />
            </td>
          </tr>
          <!-- Add more rows as needed -->
        </tbody>
      </table>
    </div>

    <!-- 문의사항 등록 버튼  :: 공지사항거 들고오기-->
    <div
      v-if="this.$store.state.user?.role == 'ROLE_ADMIN'"
      class="row justify-content-end"
    >
      <!-- 등록시 고객센터 글 목록으로 재이동 -->
      <div class="col-auto">
        <router-link :to="'/shop/notice-update/' + announcement.announcementId">
          <button id="button1" class="btn btn-primary" type="button">
            수정
          </button>
        </router-link>
      </div>
      <!-- 삭제 버튼 -->
      <div class="col-auto">
        <button
          id="button2"
          class="btn btn-primary"
          type="button"
          @click="deleteNotice"
        >
          삭제
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import NoticeListService from "@/services/noticeQnA/NoticeListService";
export default {
  data() {
    return {
      announcement: {
        // 웹 매개변수 전달방식 :: 필기옮겨오기
        // todo: 사용법 : this.$router.params.기본키명
        // todo: 참조) router/index.js=>path: /fileDb/:uuid
        // tpdo : 2개의 변수명이 일치해야함 : uuid
        // 아래의 거 쓸때 /:announcementId가 붙어있어야함
        announcementId: this.$route.params.announcementId,
        title: "",
        content: "",
        announcementImg: "",
        announcementImgUrl: "",
        announcementImgUuid: "",
      },
    };
  },
  methods: {
    // async getPost() {
    //   try {
    //     // 특정 fnqID에 해당하는 문의사항 데이터 받아오기
    //     let announcementId = this.$route.params.announcementId; // 라우터의 fnqID 파라미터 가져오기
    //     // 상세조회 2 fnq id
    //     let response = await NoticeListService.getNotice(announcementId); // 백엔드에서 해당 ID에 해당하는 문의사항 데이터 받아오기
    //     this.announcement = response.data; // 받아온 데이터를 announcement 객체에 저장
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    // 상세조회
    async get(announcementId) {
      // todo: 공통 상세조회 함수: get()
      // 비동기 코딩!!!!
      try {
        let response = await NoticeListService.getNotice(announcementId);
        this.announcement = response.data; //spring 결과 -> announcement 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    async deleteNotice() {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await NoticeListService.delete(
          this.announcement.announcementId
        );
        this.$router.push("/shop/notice");
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
    window.scrollTo(0, 0);
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
