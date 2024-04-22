<template>
  <br />
  <br />
  <br />
  <div class="container mt-5">
    <div class="row">
      <div class="col"></div>
      <div class="col-10">
        <!-- 회원유형 테이블 시작 -->
        <table class="table">
          <thead>
            <tr>
              <h1 scope="col">회원가입</h1>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">회원 유형</th>
              <td>
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="radio"
                    name="flexRadioDefault"
                    id="flexRadioDefault1"
                    value="user"
                    v-model="user.role"
                    checked
                  />
                  <label class="form-check-label" for="flexRadioDefault1">
                    회원
                  </label>
                </div>
              </td>
              <td>
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="radio"
                    name="flexRadioDefault"
                    id="flexRadioDefault2"
                    value="admin"
                    v-model="user.role"
                  />
                  <label class="form-check-label" for="flexRadioDefault2">
                    관리자
                  </label>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
        <!-- 회원 유형 테이블 끝 -->
        <br />
        <br />
        <br />

        <!-- 기본 정보 테이블 시작-->
        <table class="table">
          <thead>
            <tr>
              <h3 scope="col">기본 정보</h3>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <!-- 아이디 tr -->

            <tr>
              <th scope="row">
                <label class="insert-id" for="id">아이디</label>
              </th>
              <td>
                <div class="col">
                  <input
                    class="form-control"
                    type="text"
                    name="id"
                    v-model="user.userId"
                  />
                </div>
              </td>
              <td>(영문소문자/숫자, 4~16자)</td>
            </tr>
            <!-- 비밀번호 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="pwd">비밀번호</label>
              </th>
              <td>
                <div class="col">
                  <input
                    class="form-control"
                    type="password"
                    name="pwd"
                    v-model="user.password"
                  />
                </div>
              </td>
              <div class="col">
                <td>
                  (영문 대소문자/숫자/특수문자 중 3가지 이상 조합, 8자~16자)
                </td>
              </div>
            </tr>
            <!-- 비밀번호 확인 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="pwdCheck">비밀번호 확인</label>
              </th>
              <td>
                <div class="col">
                  <input
                    class="form-control"
                    type="password"
                    name="pwdCheck"
                    id="pwdCheck"
                    v-model="confirmPassword"
                    @input="checkPasswordMatch"
                  />
                </div>
              </td>
              <td><p v-if="passwordMatchError" style="color: red">
                  비밀번호가 일치하지 않습니다.
                </p></td>
            </tr>
            <!-- 비밀번호 확인 질문 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="address"
                  >비밀번호 확인 질문</label
                >
              </th>
              <td>
                <select class="form-select" aria-label="Default select example">
                  <option selected>자신이 가장 존경하는 인물은?</option>
                  <option value="1">기억에 남는 추억의 장소는?</option>
                  <option value="2">자신의 인생 좌우명은?</option>
                  <option value="3">인상깊게 읽은 책 이름은?</option>
                </select>
              </td>
              <td></td>
            </tr>
            <!-- 비밀번호 질문 확인 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="pwdAskCheck"
                  >비밀번호 질문 확인</label
                >
              </th>
              <td>
                <input class="form-control" type="text" name="pwdAskCheck" />
              </td>
              <td>
              </td>
            </tr>
            <!-- 이름 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="userName">이름</label>
              </th>
              <td>
                <input class="form-control" type="text" name="userName" v-model="user.userName">
              </td>
              <td></td>
            </tr>
            <!-- email tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="email">email</label>
              </th>
              <td>
                <input class="form-control" type="email" name="email" v-model="user.email"/>
              </td>
              <td></td>
            </tr>

            <!-- 주소 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="address">주소</label>
              </th>
              <td>
                <div class="row mb-1">
                  <!-- 우편번호 -->
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      v-model="postcode"
                      placeholder="우편번호"
                      disabled
                    />
                  </div>
                  <!-- 주소검색 버튼 -->
                  <div class="col">
                    <button
                      class="btn"
                      type="button"
                      @click="execDaumPostcode()"
                      value="우편번호 찾기"
                      id="addressBtn"
                    >주소 검색</button>
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      v-model="address"
                      placeholder="주소"
                      disabled
                    />
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      v-model="extraAddress"
                      placeholder=""
                      disabled
                    />
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      id="detailAddress"
                      placeholder="상세주소"
                      v-model="user.detailAddress"
                    />
                  </div>
                </div>
                
              </td>
              <td></td>
            </tr>
            <!-- 전화 번호 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="address">일반 전화 번호</label>
              </th>
              <td>
                <div class="row">
                  <div class="col-3">
                    <select
                      class="form-select"
                      aria-label="Default select example"
                      v-model="callNum.first"
                    >
                      <option selected>02</option>
                      <option value="1">032</option>
                      <option value="2">042</option>
                      <option value="3">051</option>
                      <option value="3">052</option>
                      <option value="3">053</option>
                      <option value="3">062</option>
                      <option value="3">064</option>
                      <option value="3">031</option>
                      <option value="3">033</option>
                      <option value="3">041</option>
                      <option value="3">043</option>
                      <option value="3">054</option>
                      <option value="3">055</option>
                      <option value="3">061</option>
                      <option value="3">063</option>
                    </select>
                  </div>
                  _
                  <div class="col-3">
                    <input
                      class="form-control"
                      type="text"
                      name="call"
                      v-model="callNum.second"
                    />
                  </div>
                  _
                  <div class="col-3">
                    <input
                      class="form-control"
                      type="text"
                      name="call"
                      v-model="callNum.third"
                    />
                  </div>
                </div>
              </td>
              <td></td>
            </tr>
            <!-- 휴대폰 번호 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="address">휴대폰 번호</label>
              </th>
              <td>
                <div class="row">
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
                  <div class="col-3">
                    <input
                      class="form-control"
                      type="text"
                      name="call"
                      v-model="phoneNum.second"
                    />
                  </div>
                  _
                  <div class="col-3">
                    <input
                      class="form-control"
                      type="text"
                      name="call"
                      v-model="phoneNum.third"
                    />
                  </div>
                </div>
              </td>
              <td></td>
            </tr>
          </tbody>
        </table>
        <!-- 기본 정보 테이블 끝 -->
        <br />
        <br />
        <br />
        <!-- 추가 정보 테이블 시작-->
        <table class="table">
          <thead>
            
            <!-- 생년월일 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="userName">생년월일</label>
              </th>
              <td>
                <div class="col">
                  <input class="form-control" type="text" name="pwd" v-model="user.birthday"/>
                </div>
              </td>
              <td>주민번호 앞 6자리 ex ) 990115</td>
            </tr>
          </thead>
          <tbody></tbody>
        </table>
        <!-- 추가 정보 테이블 끝 -->
      </div>
      <div class="col"></div>
    </div>
  </div>

  <br />
  <br />
  <div class="container text-center">
    <div class="row justify-content-md-center">
      <div class="col-md-auto">
        <button class="text-light singUpBtn btn-sm mt-4" id="" type="button" @click="handleRegister">
          회원가입
        </button>
      </div>
    </div>
  </div>
  <br />
  <br />
  <br />
  <br />
</template>
<script>
import AuthService from "@/services/auth/AuthService";
export default {
  data() {
    return {
      confirmPassword: "", // 비밀번호 확인
      passwordMatchError: false, // 비밀 번호확인이 다르면 true

      // 주소검색 변수들
      postcode: "",
      address: "",
      extraAddress: "",


      phoneNum: {
        first: "", // 폰 번호 첫자리
        second: "",
        third: "",
      },
      callNum: {
        first: "", // 일반전화 첫 자리
        second: "",
        third: "",
      },
      user: {
        userId: "",
        password: "",
        userName: "",
        birthday: "",
        email: "",
        role: "",
        detailAddress: "",
      },
    };
  },
  methods: {
    /* 회원가입 버튼 누르면 실행될 함수 */
    async handleRegister() {
      let data = {
        userId: this.user.userId,
        password: this.user.password,
        userName: this.user.userName,
        birthday: this.user.birthday,
        phoneNum:
          this.phoneNum.first + this.phoneNum.second + this.phoneNum.third,
        callNum: this.callNum.first + this.callNum.second + this.callNum.third,
        email: this.user.email,
        role: this.user.role,
        normalAddress: this.address + "," + this.extraAddress,
        detailAddress: this.user.detailAddress,
      };
      try {
        let response = await AuthService.register(data);
        console.log(response.data);
        this.$store.commit("registerSuccess");
        this.$router.push("/");
      } catch (e) {
        // 공유 저장소의 register 실해함수 실행
        this.$store.commit("registerFailure");
        this.message = "에러 :" + e;
        console.log(e); // 에러 출력
      }
    },

    /* 비밀번호 확인이 일치하지 않으면 메세지가 뜨게 할  */
    checkPasswordMatch: function () {
      if (this.user.password !== this.confirmPassword) {
        this.passwordMatchError = true;
        alert;
      } else {
        this.passwordMatchError = false;
      }
    },  
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                this.extraAddress !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    },
  },
};
</script>
<style>
#addressBtn {
  /* 주소 검색 버튼 */
  width: 100px;
  height: 37px;
  background-color: #342a26;
  color: white;
}
.singUpBtn {
  background-color: #342a26;
  color: white;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
</style>
