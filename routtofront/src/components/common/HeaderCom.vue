<template>
  <!-- header 전체박스 -->
  <div class="kim-frame-14">
  <!-- header 중앙 정렬박스 -->
    <div class="container center">
    <img class="kim-routto-logo" src="../../../src/assets/images/routto__4__1.png" />
    <img class="kim-div" src="../../../src/assets/images/______1.png" />
    <img class="kim-div2" src="../../../src/assets/images/b.png" />
    <div class="navbar">
      <div to="" class="kim-div3">BEST</div>
      <div class="kim-div3">SKIN</div>
      <div class="kim-div3">MAKE UP</div>
      <div class="kim-div3">BODY</div>
      <div class="kim-div3">NOTICE</div>
    </div>
    <div class="kim-frame-142">
      <div class="kim-div4">공지사항</div>
      <div class="kim-div4">상품문의</div>
      <div class="kim-faq">FAQ</div>
    </div>
    <img class="kim-vector-4" src="../../../src/assets/images/unederbar.png" />
    <img class="kim-_1" src="../../../src/assets/images/se.png" />
    <div class="kim-frame-15">
      <div class="kim-login">LOGIN</div>
      <div class="kim-join">JOIN</div>
      <div class="kim-cart">CART</div>
      <div class="kim-my-page">MY PAGE</div>
    </div>
  <!-- header 중앙 정렬박스 -->
  </div>
  <!-- header 전체박스 -->
  </div>     
</template>

<style>
/* @import '@/assets/css/IndexStyle.css'; */
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

.navbar {
  display: flex;
  flex-direction: row;
  gap: 5px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: 111px;
  top: 255px;
  align-items: flex-end;
  justify-content: flex-end;
}

/* .navbar > .div3 {
  margin-right: -50px;
}

.div3:last-child {
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
  left: 16vw;
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
  width: 8.78%;
  height: 0%;
  position: absolute;
  right: 14.87%;
  left: 76.35%;
  bottom: 65.47%;
  top: 34.53%;
  overflow: visible;
}

.kim-_1 {
  width: 30px;
  height: 30px;
  display: flex;
  flex-direction: row;
  gap: 25px;
  align-items: flex-start;
  justify-content: flex-start;
  position: absolute;
  left: calc(50% + 409px);
  top: 45%;
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