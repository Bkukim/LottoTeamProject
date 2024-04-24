
import router from '@/router';
<template>
  <!-- header 전체박스 -->
  <div class="kim-frame-14">
    <!-- header 중앙 정렬박스 -->
    <div class="kim-frame-14-in">
      <!-- 검색팝업 -->
      <div class="header">
        <button id="searchIcon">
          <img src="../../../src/assets/images/se.png" />
        </button>
        <div id="searchPopup" class="search-popup">
          <input type="text" placeholder="검색어를 입력하세요" />
          <button id="closeSearch">닫기</button>
        </div>
      </div>

      <!--로고이미지  -->
      <router-link to="/"
        ><img
          class="kim-routto-logo"
          src="../../../src/assets/images/routto__4__1.png"
        />
      </router-link>

      <!-- 홈 아이콘 -->
      <!-- <img class="kim-div" src="../../../src/assets/images/______1.png" /> -->

      <!-- 햄버거 아이콘
    <img class="kim-div2" src="../../../src/assets/images/hb.png" /> -->

      <!-- 메뉴 바 -->
      <div class="kim-navbar">
        <router-link to="#" class="kim-div3">BEST</router-link>
        <router-link to="#" class="kim-div3">SKIN</router-link>
        <router-link to="#" class="kim-div3">MAKE UP</router-link>
        <router-link to="#" class="kim-div3">BODY</router-link>
        <router-link to="/notice" class="kim-div3">NOTICE</router-link>
      </div>

      <!-- 왼쪽 박스 -->
      <div class="kim-frame-142">
        <router-link to="/notice" class="kim-div4">공지사항</router-link>
        <router-link to="#" class="kim-div4">FAQ</router-link>
      </div>

      <div class="header">
        <!-- 검색 아이콘 -->
        <button id="searchIcon">
          <img
            class="kim-vector-4"
            src="../../../src/assets/images/unederbar.png"
          />
        </button>
        <div id="searchPopup" class="search-popup">
          <input type="text" placeholder="검색어를 입력하세요" />
          <button id="closeSearch">닫기</button>
        </div>
      </div>


      <img class="kim-_1" src="../../../src/assets/images/se.png" />
      <!-- <router-link to="/member/login" class="kim-login">LOGIN</router-link> -->

      <!-- 오른쪽 박스 -->
      <div class="kim-frame-15">
        <router-link to="/member/login" class="kim-login">LOGIN</router-link>
        <router-link to="/member/join" class="kim-join">JOIN</router-link>
        <router-link to="/cart" class="kim-cart">CART</router-link>
        <router-link to="/member/mypage" class="kim-my-page"
          >MY PAGE</router-link
        >
      </div>

      <!-- header 중앙 정렬박스 -->
    </div>
    <!-- header 전체박스 -->
  </div>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>

  <br>
</template>

<script>
export default {
  mounted() {
    const searchIcon = document.getElementById("searchIcon");
    const searchPopup = document.getElementById("searchPopup");
    const closeSearch = document.getElementById("closeSearch");

    searchIcon.addEventListener("click", function () {
      searchPopup.style.display = "block";
    });

    closeSearch.addEventListener("click", function () {
      searchPopup.style.display = "none";
    });
  },
};
</script>


<style>
@import "@/assets/css/Header.css";
</style>