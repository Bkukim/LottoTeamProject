<template>
  <!-- header 전체박스 -->
  <div :class="{ scrolled: scrolled }" class="kim-frame-14">
    <!-- header 중앙 정렬박스 -->
    <div class="kim-frame-14-in">
      <!--로고이미지  -->
      <router-link to="/shop/admin/order">
        <img
          class="kim-routto-logo"
          src="../../../src/assets/images/routto__4__1.png"
        />
      </router-link>

      <!-- 메뉴 바 -->
      <div class="kim-navbar">
        <router-link to="/shop/admin/order" class="kim-div3"
          >주문관리</router-link
        >
        <router-link to="/admin/notice" class="kim-div3">공지사항</router-link>
        <router-link to="/shop/admin/add-product" class="kim-div3"
          >상품등록</router-link
        >
        <router-link to="/shop/admin/manage" class="kim-div3"
          >상품조회/수정</router-link
        >
        <router-link to="/shop/admin/refund" class="kim-div3"
          >환불관리</router-link
        >
        <router-link to="/admin/inquiry/qnaList" class="kim-div3">상품 QNA</router-link>
        <router-link to="/admin/admin-faqList" class="kim-div3">고객문의</router-link>
        <router-link to="/admin/banner-list" class="kim-div3">홍보배너관리</router-link>
      </div>

      <!-- 오른쪽 박스 -->
      <div>
        <div class="kim-frame-15" v-if="!this.$store.state.loggedIn">
          <router-link to="/member/login" class="kim-login">LOGIN</router-link>
          <router-link to="/member/join" class="kim-join">JOIN</router-link>
        </div>
        <div class="kim-frame-15" v-else>
          
          <li>
            <a href class="kim-login" @click.prevent="handleLogout"> LOGOUT </a>
          </li>
        </div>
      </div>

      <!-- header 중앙 정렬박스 -->
    </div>
    <!-- header 전체박스 -->
  </div>
  <br />
  <br />
</template>

<script>
import AuthService from "@/services/auth/AuthService";
export default {
  
  data() {
    return {
      scrolled: false, 
      // 헤더의 스크롤 상태를 나타내는 데이터 변수

      searchQuery: "", // 검색어를 저장할 데이터
    };
  },
  created() {
    window.addEventListener("scroll", this.handleScroll); // 스크롤 이벤트 리스너 등록
  },
  beforeUnmount() {
    window.removeEventListener("scroll", this.handleScroll); // 컴포넌트 파괴 시 이벤트 리스너 제거
  },
  mounted() {},
  methods: {
   
    // 네비바 위치 조정
// 네비바 transition 초기화
// 로고 위치 조정
// 로고 위치 조정

    // 검색창
    search() {
      // 여기서 검색어(searchQuery)를 이용하여 검색을 수행하는 로직을 작성
      console.log("검색어:", this.searchQuery);
      // 예를 들어, 검색 결과를 서버에 요청하거나 라우팅을 통해 검색 결과 페이지로 이동
    },
    handleLogout() {
      let result = confirm("정말로 로그아웃 하시겠습니까?");
      if (result) {
        AuthService.logout(); // LOCAL저장소에서 USER객체 삭제해주기
        this.$store.commit("logout"); //
        this.$router.push("/member/login");
      } else {
        return;
      }
    },
  },
};
</script>

<style>
@import "@/assets/css/AdminHeader.css";
</style>
