<!-- Notice view -->
<template>
  <div class="container">
    <div class="mt-3">
      <router-link class="text-decoration-none fs-5" to="/notice"
        >공지사항</router-link
      >
      |
      <router-link class="text-decoration-none" to="/faqList"
        >고객센터</router-link
      >
    </div>
    <div class="mt-5">
      <!-- 서치 -->
        <form class="d-flex mt-3 col-5" role="search">
        <input
          class="form-control me-2"
          type="search"
          placeholder="Search"
          aria-label="Search"
        />
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      

      <!-- 테이블 시작 -->
      <table class="table mt-5 ">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
        </tbody>
      </table>
      <!-- 관리자 등록 버튼 :: 공지사항 글등록으로 이동-->
      <button type="button" id="button1" class="mt-5 btn btn-primary">
    <router-link to="/adimn-notice">공지사항 등록</router-link>
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
