
import router from '@/router';
<template>
  <!-- header 전체박스 -->
  <div class="kim-frame-14">
  <!-- header 중앙 정렬박스 -->
    <div class="container center">

    <!--로고이미지  -->
    <router-link to="/shop"><img class="kim-routto-logo" src="../../../src/assets/images/routto__4__1.png" /> </router-link>

    <!-- 홈 아이콘 -->
    <!-- <img class="kim-div" src="../../../src/assets/images/______1.png" /> -->

    <!-- 햄버거 아이콘 -->
    <img class="kim-div2" src="../../../src/assets/images/hb.png" />
    
    <!-- 메뉴 바 -->
    <div class="kim-navbar">
      <router-link to="#" class="kim-div3">BEST</router-link>
      <router-link to="#" class="kim-div3">SKIN</router-link>
      <router-link to="#" class="kim-div3">MAKE UP</router-link>
      <router-link to="#" class="kim-div3">BODY</router-link>
      <router-link to="/shop/notice" class="kim-div3">NOTICE</router-link>
    </div>

    <!-- 왼쪽 박스 -->
    <div class="kim-frame-142">
      <router-link to="/shop/notice" class="kim-div4">공지사항</router-link>
      <router-link to="/shop/faqList" class="kim-div4">FAQ</router-link>

      <!-- <div class="kim-div4">공지사항</div> -->
      <!-- <div class="kim-faq">FAQ</div> -->
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
<!-- 
      <div class="kim-login">LOGIN</div>
      <div class="kim-join">JOIN</div>
      <div class="kim-cart">CART</div>
      <div class="kim-my-page">MY PAGE</div> -->
    </div>

  <!-- header 중앙 정렬박스 -->
  </div>
  <!-- header 전체박스 -->
  </div>     
</template>




<style>
/* @import '@/assets/css/IndexStyle.css'; */


.router-link-exact-active {
  color: #ffffff;
  text-decoration: none; /* 언더라인 제거 */
} 

/* 호버 시 색상 변경 */
.router-link-exact-active:hover {
  color: rgba(248, 224, 178, 0.705); /* 원하는 호버 색상으로 변경 */
}

/* router-link가 렌더링하는 <a> 태그에 적용되는 스타일 */
.kim-frame-15 a {
  color: #ffffff;
  text-decoration: none; /* 언더라인 제거 */
}

/* 호버 시 색상 변경 */
.kim-frame-15 a:hover {
  color: rgba(248, 224, 178, 0.705); /* 원하는 호버 색상으로 변경 */
}


.kim-frame-142 a {
  color: #ffffff;
  text-decoration: none; /* 언더라인 제거 */
}

/* 호버 시 색상 변경 */
.kim-frame-142 a:hover {
  color: rgba(248, 224, 178, 0.705); /* 원하는 호버 색상으로 변경 */
}


.kim-frame-15 > router-link{
  text-decoration: none; /* 언더라인 제거 */
}


/* router-link가 렌더링하는 <a> 태그에 적용되는 스타일 */
  .kim-navbar a {
  color: #ffffff;
  text-decoration: none; /* 언더라인 제거 */
}

/* 호버 시 색상 변경 */
.kim-navbar a:hover {
  color: rgba(248, 224, 178, 0.705); /* 원하는 호버 색상으로 변경 */
}


/* ------------- */


.kim-frame-14 {
  background: #342a26;
  height: 333px;
  width: 100%;
  position: relative;
  overflow: hidden;
}

.kim-routto-logo {
  width: 317px;
  height: 58.86%;
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: 28.83%;
  top: 12.31%;
  object-fit: cover;
}

.kim-div {
  width: 2.0833vw;
  height: 2.0833vw;
  position: absolute;
  right: 85.73%;
  left: 12.5%;
  bottom: 77.48%;
  top: 12.31%;
  object-fit: cover;
}

.kim-div2 {
  width: 2.0833vw;
  height: 2.0833vw;
  position: absolute;
  right: 85.36%;
  left: 12.55%;
  bottom: 12.61%;
  top: 78.98%;
  overflow: visible;
}

.kim-navbar {
  display: flex;
  flex-direction: row;
  gap: 70px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: 650px;
  top: 255px;
  align-items: flex-end;
  justify-content: flex-end;
}


/* .div3:last-child {
  margin-right: 0;
} */ 

.kim-div3 {
  color: #ffffff;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: relative;
  margin-right: 5vw;
}

.kim-frame-142 {
  display: flex;
  flex-direction: row;
  gap: 22px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: 12.7vw;
  top: 49px;
}

.kim-div4,
.kim-faq {
  color: #ffffff;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 15px;
  font-weight: 400;
  position: relative;
}

.kim-vector-4 {
  display: flex;
  flex-direction: row;
  gap: 25px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: calc(50% + 450px);
  top: 125px;
  align-items: flex-end;
  justify-content: flex-end;
}

.kim-_1 {
  width: 40px;
  height: 40px;
  display: flex;
  flex-direction: row;
  gap: 5px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: calc(50% + 625px);
  top: 85px;
  align-items: flex-end;
  justify-content: flex-end;
}


.kim-frame-15 {
  display: flex;
  flex-direction: row;
  gap: 25px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: calc(50% + 409px);
  top: 38px;
  align-items: flex-end;
  justify-content: flex-end;
}

.kim-login,
.kim-join,
.kim-cart,
.kim-my-page {
  color: #ffffff;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 15px;
  font-weight: 400;
  position: relative;
}
</style>