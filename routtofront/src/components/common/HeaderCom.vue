<template>
  <!-- header 전체박스 -->
  <div :class="{ scrolled: scrolled }" class="kim-frame-14">
    <!-- header 중앙 정렬박스 -->
    <div class="kim-frame-14-in">
      <!--로고이미지  -->
      <router-link to="/">
        <img
          class="kim-routto-logo"
          src="../../../src/assets/images/routto__4__1.png"
        />
      </router-link>

      <!-- 메뉴 바 -->
      <div class="kim-navbar">
        <router-link to="/product/example" class="kim-div3">BEST</router-link>
        <router-link to="/" class="kim-div3">SKIN</router-link>
        <router-link to="/" class="kim-div3">HAIR</router-link>
        <router-link to="/" class="kim-div3">MAKE UP</router-link>
        <router-link to="/" class="kim-div3">BODY</router-link>
        <router-link to="/notice" class="kim-div3">NOTICE</router-link>
      </div>

      <!-- 왼쪽 박스 -->
      <div class="kim-frame-142">
        <router-link to="/notice" class="kim-div4">공지사항</router-link>
        <router-link to="#" class="kim-div4">FAQ</router-link>
      </div>

      <!-- 오른쪽 박스 -->
      <div class="kim-frame-15">
        <router-link to="/member/login" class="kim-login">LOGIN</router-link>
        <router-link to="/member/join" class="kim-join">JOIN</router-link>
        <router-link to="/cart" class="kim-cart">CART</router-link>
        <router-link to="/member/mypage" class="kim-my-page"
          >MY PAGE</router-link
        >
      </div>

      <!-- 검색창 -->
      <div class="search_header">
        <input type="text" v-model="searchQuery" placeholder="" />
        <router-link to="/member/searchproduct" class="se_button">
          <img src="../../../src/assets/images/se.png" />
        </router-link>
      </div>

      <!-- header 중앙 정렬박스 -->
    </div>
    <!-- header 전체박스 -->
  </div>
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
</template>

<script>
export default {
  data() {
    return {
      scrolled: false, // 헤더의 스크롤 상태를 나타내는 데이터 변수

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
    // 헤더 스크롤
    handleScroll() {
      // 스크롤 위치를 확인하여 헤더의 상태를 업데이트
      if (window.scrollY > 50) {
        this.scrolled = true;
        document.querySelector(".kim-frame-14").classList.add("scrolled"); // 헤더 클래스 변경
        document.querySelector(".kim-frame-14").style.height = "6vw"; // 스크롤 시 헤더 높이 변경
        document.querySelector(".kim-routto-logo").style.width = "7vw"; // 로고 너비 변경
        document.querySelectorAll(".kim-div3").forEach((item) => {
          item.style.fontSize = "0.6vw"; // 메뉴 폰트 크기 변경
        });
        document.querySelector(".kim-navbar").style.top = "4.8vw"; // 네비바 위치 조정
        document.querySelector(".kim-navbar").style.transition = "top 0.3s"; // 네비바 transition 설정
        document.querySelector(".kim-routto-logo").style.bottom = "1.5vw"; // 로고 위치 조정
        document.querySelector(".kim-routto-logo").style.top = "-1vw"; // 로고 위치 조정

        // search_header
      } else {
        this.scrolled = false;
        document.querySelector(".kim-frame-14").classList.remove("scrolled"); // 헤더 클래스 초기화
        document.querySelector(".kim-frame-14").style.height = "11.5vw"; // 헤더 높이 변경
        document.querySelector(".kim-routto-logo").style.width = "16.5104vw"; // 로고 너비 변경
        document.querySelectorAll(".kim-div3").forEach((item) => {
          item.style.fontSize = "1vw"; // 메뉴 폰트 크기 변경
        });
        document.querySelector(".kim-navbar").style.top = "9.4vw"; // 네비바 위치 조정
        document.querySelector(".kim-navbar").style.transition = "0.3s"; // 네비바 transition 초기화
        document.querySelector(".kim-routto-logo").style.bottom = "3.125vw"; // 로고 위치 조정
        document.querySelector(".kim-routto-logo").style.top = "-3.4375vw"; // 로고 위치 조정
      }
    },

    // 검색창
    search() {
      // 여기서 검색어(searchQuery)를 이용하여 검색을 수행하는 로직을 작성
      console.log("검색어:", this.searchQuery);
      // 예를 들어, 검색 결과를 서버에 요청하거나 라우팅을 통해 검색 결과 페이지로 이동
    },
  },
};
</script>

<style>
@import "@/assets/css/Header.css";
</style>
