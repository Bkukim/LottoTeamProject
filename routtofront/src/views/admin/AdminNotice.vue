<!-- /adimn-notice ::공지사항 등록폼ADD -->
<template>
  <div class="mt-5 mb-5 col-13">
    <!-- 카테고리 -->
    <h5 class="text-center">공지사항등록</h5>
    <br />
    <div class="col-4 mb-3">
      <label class="mb-3 text-left">제목 </label>
      <input
        type="text"
        class="form-control"
        id="exampleFormControlInput1"
        placeholder="제목 적어주세요"
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
      <button id="button1" class="btn btn-primary" type="button" @click="createNotice">
        <router-link to="/notice" class="router-link-exact-active"
          >등록</router-link
        >
      </button>
    </div>
  </div>
</template>

<script>
import NoticeListService from '@/services/noticeQnA/NoticeListService';
export default {
  // 바인딩속성들
  data() {
    return {
      message: "",
      // 이미지
      noticeImg: undefined,
      // 공지사항 넘겨주기
      notice: {
        announcementId: null, //기본키
        title: "",
        content: "",
      },
    };
  },
  // 함수
  methods: {
    // TODO: 파일 선택상자에서 이미지 선택하면 변수에 저장하는 함수
    selectImage() {
      // 1) 파일선택상자에서 1st 로 선택한 이미지를 변수에 저장
      // ref="file" 접근 -> 내부 속성 : files[번호]
      // TODO: 사용법 : this.$refs.변수명 => input type="file" ref="변수명" 태그 접근
      this.noticeImg = this.$refs.file.files[0];
      // 성공메세지 변수 초기화
      this.message = "";
    },
    // 전체 객체 전달 하기(생성하기) :::: addfileDB참고
    async createNotice() {
      try {
        // TODO: 벡엔드로 객체 추가 요청
        let response = await NoticeListService.create(this.notice, this.noticeImg);
        // TODO: 콘솔에 결과 출력
        console.log(response);
        this.message = response.data;
      } catch (e) {
        // 현재선택된 이미지 변수 초기화
        this.noticeImg = undefined;
        this.message = "";
        console.log(e);
      }
    },
  },
  mounted() {},
};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
