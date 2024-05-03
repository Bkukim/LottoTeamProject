<template>
  <div class="container">
    <br />
    <br />
    <br />
    <br />
    <br />
    <h2 class="text-center">아이디 찾기</h2>
    <div class="container">
      <div class="row justify-content-md-center">
        <div class="col-8">
          <div class="mt-5" id="comment">
            <p>
              ＊휴대폰 번호를 입력하여 아이디 찾기가 가능합니다.<br />
              ＊회원 유형과 이름, 휴대폰 번호를 입력해주세요.
            </p>
          </div>
          <div class="mt-5" id="box">
            <div class="col-11">
              <p>회원 유형</p>

              <select
                class="form-select"
                aria-label="Default select example"
                v-model="role"
              >
                <option selected value="ROE_USER">회원</option>
                <option value="ROLE_ADMIN">관리자</option>
              </select>
            </div>
            <div class="mt-4 col-11">
              <label class="form-label" for="userName">이름</label>
              <input
                class="form-control"
                type="text"
                name="userName"
                v-model="userName"
              />
            </div>
            <div class="row mt-4">
              <label class="form-label" for="address">휴대폰 번호</label>
              <div class="col-3">
                <select
                  class="form-select"
                  aria-label="Default select example"
                  v-model="phoneNum.first"
                >
                  <option selected>010</option>
                  <option value="1">011</option>
                  <option value="2">016</option>
                  <option value="3">017</option>
                  <option value="3">018</option>
                  <option value="3">019</option>
                </select>
              </div>
              _
              <div class="col-4">
                <input
                  class="form-control"
                  type="text"
                  name="call"
                  v-model="phoneNum.second"
                />
              </div>
              _
              <div class="col-4">
                <input
                  class="form-control"
                  type="text"
                  name="call"
                  v-model="phoneNum.third"
                />
              </div>
            </div>
            <div>
              <div v-if="message" class="mt-5 text-center">
                <h4>{{ message }}</h4>
              </div>
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
          class="text-light FindIdBtn btn-sm mt-4"
          id=""
          type="submit"
          @click="findId"
        >
          확인
        </button>
      </div>
      <div class="col-md-auto">
        <button
          class="text-light btn-sm mt-4"
          id="go-login"
          type="submit"
          @click="goLogin"
        >
          <p>로그인</p>
        </button>
      </div>
    </div>
  </div>
  <br />
  <br />
  <br />
</template>
<script>
import AuthService from '@/services/auth/AuthService';

export default {
  data() {
    return {
      phoneNum: {
        first: "", // 폰 번호 첫자리
        second: "",
        third: "",
      },
      userName: "",
      role: "",

      // 결과가 나오면 id를, 결과가 없으면 "존재하지 않는 회원입니다."를 보여줄 메세지
      message: "",
    };
  },
  methods: {
    async findId() {
      try {
        let data = {
          role: this.role,
          userName: this.userName,
          phoneNum:
            this.phoneNum.first + this.phoneNum.second + this.phoneNum.third,
        };
        let response = await AuthService.findId(
          data.role,
          data.userName,
          data.phoneNum
        );
        if (response.data.message == "존재하지 않는 회원입니다.") {
          this.message = response.data.message;
        } else {
          this.message = response.data.userName + "님의 회원 ID는 \"" + response.data.userId + "\" 입니다.";
        }
        

        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    goLogin(){
      this.$router.push("/member/login")
    }
  },
};
</script>
<style>
#box {
  border: 1px solid #cccccc;
  padding: 60px 100px 60px 80px;
}
.FindIdBtn {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
#go-login {
  background-color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
#go-login > p {
  padding-top: 6px ;
  color: #342a26;
}
</style>
