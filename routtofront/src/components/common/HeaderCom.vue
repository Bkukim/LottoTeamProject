
import router from '@/router';
<template>
  <!-- header 전체박스 -->
  <div class="kim-frame-14">
  <!-- header 중앙 정렬박스 -->
    <div class="container center">

    <!--로고이미지  -->
    <router-link to="/"><img class="kim-routto-logo" src="../../../src/assets/images/routto__4__1.png" /> </router-link>

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
      <router-link to="#" class="kim-div3">NOTICE</router-link>
    </div>

    <!-- 왼쪽 박스 -->
    <div class="kim-frame-142">
      <router-link to="#" class="kim-div4">공지사항</router-link>
      <router-link to="#" class="kim-div4">FAQ</router-link>
    </div>

    <!-- 검색 아이콘 -->
    <img class="kim-vector-4" src="../../../src/assets/images/unederbar.png" />
    <img class="kim-_1" src="../../../src/assets/images/se.png" />

    <!-- 오른쪽 박스 -->
    <div class="kim-frame-15">
      <router-link to="/member/login" class="kim-login">LOGIN</router-link>
      <router-link to="/member/join" class="kim-join">JOIN</router-link>
      <router-link to="/order/cart" class="kim-cart">CART</router-link>
      <router-link to="/member/mypage" class="kim-my-page">MY PAGE</router-link>
    </div>

  <!-- header 중앙 정렬박스 -->
  </div>
  <!-- header 전체박스 -->
  </div>     
</template>




<style>
@import '@/assets/css/Header.css';

</style>