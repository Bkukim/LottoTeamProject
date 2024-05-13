<template>
  <div class="container">
    <br />
    <br />
    <br />
    <br />
    <br />
    <h2 class="text-center">새로운 비밀번호 설정</h2>
    <div class="container">
      <div class="row justify-content-md-center" v-if="result">
        <div class="col-8">
          <div class="mt-5 text-center" id="box" style="height: 300px">
            <div style="margin-top: 70px">
              <h3>비밀번호가 성공적으로 변경되었습니다.</h3>
            </div>
          </div>
        </div>
      </div>
      <div class="row justify-content-md-center" v-else>
        <div class="col-8">
          <div class="mt-5" id="comment">
            <p>
              ＊새로운 비밀번호를 입력하세요.<br />
              ＊영문 대소문자/숫자/특수문자 중 3가지 이상 조합, 8자~16자
              이상으로 입력하세요.
            </p>
          </div>
          <div class="mt-5" id="box">
            <div class="mt-4" style="font-size: 20px">
              <label class="form-label">새로운 비밀번호</label>
              <input
                class="form-control"
                type="password"
                name="id"
                v-model="newPw"
                style="height: 50px"
                @input="checkPasswordMatch"
              />
            </div>

            <div style="margin-top: 70px; font-size: 20px">
              <label class="form-label">새로운 비밀번호 확인</label>
              <input
                class="form-control"
                type="password"
                name="pwdAskCheck"
                v-model="newPwCheck"
                style="height: 50px; margin-bottom: 50px"
                @input="checkPasswordMatch"
              />
            </div>
            <div class="mt-5 text-center">
              <p v-if="passwordMatchError" style="color: red">
                비밀번호가 일치하지 않습니다.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-3"></div>
  </div>
  <br />
  <br />
  <div class="container text-center" v-if="result">
    <div class="row justify-content-md-center">
      <div class="col-md-auto">
        <button
          class="text-light findPwdBtn btn-sm mt-4"
          id=""
          type="submit"
          @click="goLogin"
        >
          로그인 하러 가기
        </button>
      </div>
    </div>
  </div>
  <div class="container text-center" v-else>
    <div class="row justify-content-md-center">
      <div class="col-md-auto">
        <button
          class="text-light findPwdBtn btn-sm mt-4"
          id=""
          type="submit"
          @click="updatePw"
        >
          확인
        </button>
      </div>
    </div>
  </div>
  <br />
  <br />
  <br />
</template>
<script>
import AuthService from "@/services/auth/AuthService";

export default {
  beforeRouteLeave(to, from, next) {
    this.$store.state.userId = ""
    next();
  },
  data() {
    return {
      // 비밀번호 확인이 같으면 true
      passwordMatchError: false,

      userId: this.$store.state.userId,
      newPw: "",
      newPwCheck: "",
      result: false,
    };
  },
  methods: {
    // 비밀번호 업데이트 함수
    async updatePw() {
      try {
        let data = {
          userId: this.userId,
          newPw: this.newPw,
        };
        console.log(data);
        if (this.newPw == this.newPwCheck) {
          // 비밀번호 확인이 같을때만 실행
          let response = await AuthService.updatePw(data); // 수정이 되면  true를 반환하고 안되면 false를 반환
          if (response.data) {
            this.$store.state.userId = "";
            this.result = true;
          } else {
            alert("세션이 만료되었습니다. 로그인 창으로 이동합니다.");
            this.$router.push("/member/login");
          }
        } else {
          alert("비밀번호가 일치하지 않습니다.");
        }
      } catch (e) {
        console.log(e);
      }
    },
    checkPasswordMatch: function () {
      if (this.newPw !== this.newPwCheck) {
        this.passwordMatchError = true;
        this.passwordMatchError = true;
      } else {
        this.passwordMatchError = false;
      }
    },
    goLogin() {
      this.$router.push("/member/login");
    },
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
.findPwdBtn {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
</style>
