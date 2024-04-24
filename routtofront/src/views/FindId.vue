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
            <p>＊휴대폰 번호를 입력하여 아이디 찾기가 가능합니다.<br>
                ＊회원 유형과 이름, 휴대폰 번호를 입력해주세요.</p>
          </div>
          <div class="mt-5" id="box">
            <div class="col-11">
              <p>회원 유형</p>

              <select class="form-select" aria-label="Default select example" v-model="role">
                <option selected value="user">회원</option>
                <option value="admin">관리자</option>
              </select>
            </div>
            <div class="mt-4 col-11">
              <label class="form-label" for="userName">이름</label>
              <input class="form-control" type="text" name="userName" v-model="userName"/>
            </div>
            <div class="row mt-4">
              <label class="form-label" for="address">휴대폰 번호</label>
              <div class="col-3">
                <select class="form-select" aria-label="Default select example" v-model="phoneNum.first">
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
                <input class="form-control" type="text" name="call" v-model="phoneNum.second"/>
              </div>
              _
              <div class="col-4">
                <input class="form-control" type="text" name="call" v-model="phoneNum.third"/>
              </div>
            </div>
            <p v-if="message">{{message}}</p>
          </div>
        </div>
      </div>
    </div>
    <div class="col-3"></div>
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
    </div>
  </div>
  <br />
  <br />
  <br />
</template>
<script>
import UserService from '@/services/user/UserService';
export default {
  data() {
    return {
      phoneNum: {
        first: "", // 폰 번호 첫자리
        second: "",
        third: "",
      },
      userName:"",
      role:"",

      // 결과가 나오면 id를, 결과가 없으면 "존재하지 않는 회원입니다."를 보여줄 메세지
      message:"",
    }
  },
  methods: {
    async findId(){
      try {
        let data = {
          role : this.role,
          userName : this.userName,
          phoneNum : this.phoneNum.first + this.phoneNum.second + this.phoneNum.third
        }
        let response = UserService.findId(data.role,data.userName,data.phoneNum);
        console.log(response.data);
        this.message = response.data;
        console.log(this.message);
      } catch (e) {
        console.log(e);
      }
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
</style>
