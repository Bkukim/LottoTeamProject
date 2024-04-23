<!-- 고객센터 faq view -->
<template>
  <div class="container">
    <div class="mt-5">
      <router-link class="top_notice router-link-exact-active fs-5" to="/faqList"
        >고객센터</router-link
      >
      |
      <router-link class="top_notice2 text-decoration-none" to="/notice"
        >공지사항</router-link
      >
    </div>
    <div class="mt-5 text-center">
      <!-- 서치 -->
      <div class="row justify-content-end">
        <form class="d-flex mt-3 col-5" role="search">
          <input
            class="form-control me-2"
            type="search"
            placeholder="검색"
            aria-label="Search"
          />
          <button class="btn btn-outline-success" type="submit">검색</button>
        </form>
      </div>

      <!-- 테이블 시작 -->
      <table class="table mt-5">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <!-- 반복문 시작할 행 -->
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
          </tr>
        </tbody>
      </table>

      <!-- 페이징 -->
      <!-- {/* paging 시작 */} -->
      <!-- TODO: 1페이지당 화면에 보일 개수 조정(select태그) -->
      <div class="row justify-content-center mt-4">
        <div class="col-auto">
          <b-pagination
            class="col-12 mb-3"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveSimpleProduct"
          ></b-pagination>
        </div>
      </div>

      <!-- 질문하기 등록-->
      <div class="row justify-content-end">
        <button type="button" id="button1" class="mt-5 btn">
          <router-link to="/inquiry" class="router-link-exact-active"
            >질문하기</router-link
          >
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import "@/assets/css/Button.css";
</style>
