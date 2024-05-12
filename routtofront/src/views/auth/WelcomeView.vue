<template>
  <div class="container">
    <br />
    <br />
    <br />
    <br />
    <br />
    <h2 class="text-center">회원가입 완료</h2>
    <div class="container">
      <div class="row justify-content-md-center">
        <div class="col-8">
        
          <div class="mt-5" id="box">
            <!-- 로고 이미지 -->
            <div class="text-center">
              <img src="@/assets/images/ROUTTO_logo_wh.png">
            </div>
            <!-- 루또에 오신 것을 환영합니다 . 시작  -->
           <div class="text-center">
            <h3>루또에 오신 것을 환영합니다.</h3>
           </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col"></div>
  </div>
  <br />
  <br />
  <div class="container text-center">
    <div class="row justify-content-md-center">
      <div class="col-md-auto">
        <button
          class="text-light go-login btn-sm mt-4"
          id=""
          type="submit"
          @click="goLogin"
        >
          로그인 하러 가기
        </button>
      </div>
      
    </div>
  </div>
  <br />
  <br />
  <br />
</template>
<script>
export default {
  
  methods: {
  
    goLogin(){
      this.$router.push("/member/login")
    }
  },mounted() {
    
    window.scrollTo(0, 0);
  },
};
</script>
<style>
#box {
  border: 1px solid #cccccc;
  padding: 60px 100px 60px 80px;
}
.go-login {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}

</style>
