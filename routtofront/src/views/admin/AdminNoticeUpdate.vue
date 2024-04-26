<!-- AdminNoticeUpdate.vue -->
<!-- 관리자 공지사항 수정페이지 -->

<template>
  <div class="mt-5 mb-5 col-13">
    <!-- 카테고리 -->
    <h5 class="text-center">공지사항 수정</h5>
    <br />
    <div class="col-4 mb-3">
      <label class="mb-3 text-left">제목 </label>
      <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder=""
        v-model="notice.title"
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
        v-model="notice.content"
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

    <!-- 관리자-공지사항 등록 버튼 -->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 관리자 페이지로 이동 -->
      <button id="button2" class="btn btn-primary me-md-2" type="button">
        <router-link to="/admin" class="cencle router-link-exact-active"
          >취소</router-link
        >
      </button>
      <!-- 등록시 공지사항 목록으로 재이동 -->
      <button
        id="button1"
        class="btn btn-primary"
        type="button"
        @click="updateNotice"
      >
        <router-link to="/notice" class="router-link-exact-active"
          >수정</router-link
        >
      </button>
    </div>
  </div>
</template>

<script>
import NoticeListService from "@/services/noticeQnA/NoticeListService";
export default {
  // 바인딩속성들
  data() {
    return {
      message: "",
      // 이미지
      noticeImg: undefined,
      // 공지사항 넘겨주기
      notice: {
        announcementId: this.$route.params.announcementId, //기본키
        title: "",
        content: "",
      },
    };
  },
  // 함수
  methods: {
    //상세조회 공지사항 아이디
    async getNotice(announcementId) {
      try {
        // 상세조회 공통함수 실행 : NoticeListService.getNoticeId()
        let response = await NoticeListService.getNoticeId(announcementId);
        this.notice = response.data; // spring 결과를 바인딩 속성변수 notice 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    //todo: 파일선택상자에서 이미지를 선택할때 실행될 함수
    selectImage() {
      // todo: 파일 선택 상자에서 1st 선택한 이미지를 currentImage 변수에 저장
      // 사용법 this.noticeImg=this.$refs.변수명.files[0]
      this.noticeImg = this.$refs.file.files[0]; // 파일 선택상자에서 가지고 있음  고정 : files[0]
    },
    // TODO: 수정요청 함수 : 시점(상세조회가 끝난후)
    async updateNotice() {
      try {
        // TODO: 비동기 코딩 : async ~ await
        let response = await NoticeListService.update(
          this.notice,
          this.noticeImg
        );
        // 로깅
        console.log(response.data);
        // 화면에 성공메세지 출력 : message
        this.message = "수정에 성공했습니다.";
      } catch (e) {
        this.noticeImg = undefined; //초기화
        this.message = "에러" + e; //에러출력
        console.log(e);
      }
    },

    // // todo: 수정함수(update)
    // async update() {
    //     // 공통 수정(update) 함수 실행 : update()
    //     try{
    //         let response= await FileDbService
    //                     .update(this.fileDb, this.currentImage)
    //         // 성공 메세지 출력
    //         this.message=response.data;
    //     }catch(e){
    //         this.currentImage = undefined;  //초기화
    //         this.message="에러"+e;                 //에러출력
    //         console.log(e);
    //     }
    // },
  },
  mounted() {
    this.getNotice(this.$route.params.announcementId); // 상세조회 실행
    this.message = ""; //초기화
  },
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
