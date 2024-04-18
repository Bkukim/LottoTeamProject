<!-- /adimn-notice -->
<template>
  <div class="mt-5">
    <!-- 카테고리 -->
    <h5 class="text-center">공지사항등록</h5>
    <br />
    <div class="col-4">
      <label class="mb-3 text-left">제목 </label>
      <select class="form-controll form-select" aria-label="Default select example">
        <option selected>알립니다</option>
        <option value="1">지연공지</option>
        <option value="2">이벤트당첨자</option>
      </select>
    </div>

    <!-- 본문적는곳 -->
    <div class="mb-3">
      <label for="exampleFormControlTextarea1" class="mt-3 form-label text-left"
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

    <!-- 관리자-공지사항 등록 버튼 -->
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <!-- 취소시 관리자 페이지로 이동 -->
      <button id="button2" class="btn btn-primary me-md-2" type="button">
        <router-link to="#">취소</router-link>
      </button>
      <!-- 등록시 공지사항 목록으로 재이동 -->
      <button id="button1" class="btn btn-primary" type="button">
        <router-link to="notice">등록</router-link>
      </button>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
