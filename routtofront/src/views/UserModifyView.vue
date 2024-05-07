<template>
  <br />
  <br />
  <br />
  <div class="container mt-5">
    <div class="row">
      <div class="col"></div>
      <div class="col-10">
        <!-- 회원정보 수정 상단 시작 시작 -->
        <table class="table">
          <thead>
            <tr>
              <h1 scope="col">회원정보수정</h1>
              <th scope="col"></th>
            </tr>
          </thead>
        </table>
        <!-- 회원정보수정 상단 끝 -->
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
                    disabled
                    v-model="user.userId"
                  />
                </div>
              </td>
            </tr>

            <!-- 이름 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="userName">이름</label>
              </th>
              <td>
                <input
                  class="form-control"
                  type="text"
                  name="userName"
                  v-model="user.userName"
                />
              </td>
              <td></td>
            </tr>
            <!-- email tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="email">email</label>
              </th>
              <td>
                <input
                  class="form-control"
                  type="email"
                  name="email"
                  v-model="user.email"
                />
              </td>
              <td></td>
            </tr>
            <!-- 주소 템플릿 -->
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
                      name="postcode"
                      v-model="user.postcode"
                      disabled
                    />
                  </div>
                  <!-- 주소검색 버튼 -->
                  <div class="col">
                    <input
                      type="button"
                      class="addressBtn btn-sm"
                      @click="execDaumPostcode"
                      value="주소검색"
                    />
                    <!--  -->
                    <!-- <button class="addressBtn btn-sm" type="submit">
                        주소검색
                      </button> -->
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <!-- disabled if문 -->
                    <input
                      class="form-control"
                      type="text"
                      name="address"
                      id="address"
                      v-model="address"
                      disabled
                    />
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      name="address"
                      disabled
                      v-model="extraAddress"
                    />
                  </div>
                </div>
                <input
                  class="form-control"
                  type="text"
                  id="extraAddress"
                  v-model="user.detailAddress"
                />
              </td>
              <td></td>
            </tr>
            <!-- 주소 템플릿 끝 -->
            <!-- 전화 번호 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="address">일반 전화 번호</label>
              </th>
              <td>
                <div class="row">
                  <div class="col-6">
                    <input
                      class="form-control"
                      type="text"
                      name="call"
                      v-model="user.callNum"
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
                  <div class="col-6">
                    <input
                      class="form-control"
                      type="text"
                      name="call"
                      v-model="user.phoneNum"
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
            <!-- 성별 tr -->
            <tr>
              <h4 scope="col">추가 정보</h4>
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>

            <!-- 생년월일 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="userName">생년월일</label>
              </th>
              <td>
                <div class="col">
                  <input
                    class="form-control"
                    type="text"
                    name="pwd"
                    v-model="user.birthday"
                  />
                </div>
              </td>
              <td>주민번호 앞 6자리 ex ) 990115</td>
            </tr>
          </thead>
        </table>
        <!-- 추가 정보 테이블 끝 -->
      </div>
      <div class="col"></div>
    </div>
  </div>

  <br />
  <br />
  <!-- 회원정보 수정 버튼 -->
  <div class="container text-center">
    <div class="row justify-content-md-center">
      <div class="col-md-auto">
        <button
          class="text-light singUpBtn btn-sm mt-4"
          id=""
          type="submit"
          @click="updateUser"
        >
          회원정보수정
        </button>
      </div>
      <!-- 회원 탈퇴 버튼 -->
      <div class="col-md-auto">
        <button
          class="btn-sm mt-4"
          id="withDraw"
          type="submit"
          @click="deleteUser"
        >
          회원탈퇴
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
import UserService from "@/services/user/UserService";

export default {
  data() {
    return {
      user: {
        //   userId;
        //   password;
        //   userName;
        //   birthday;
        //   phoneNum;
        //   callNum;
        //   email;
        //   role;
        //   normalAddress;
        //   detailAddress;
        //   pastPw;
        //   pwUpdateTime;
        //   pwQuestion;
        //   pwAnswer;
      },

      postcode: "",
      address: "",
      extraAddress: "",
    };
  },
  methods: {
    // 유저정보 불러오는 함수
    async getUser(userId) {
      try {
        let response = await UserService.get(userId);
        console.log(response.data);
        this.user = response.data;
        let address = response.data.normalAddress.split(",");
        this.address = address[0];
        this.extraAddress = address[1];
      } catch (e) {
        console.log(e);
      }
    },

    // 유저 정보 수정 함수
    async updateUser() {
      let data = {
        userId: this.user.userId,
        userName: this.user.userName,
        birthday: this.user.birthday,
        phoneNum: this.user.phoneNum,
        callNum: this.user.callNum,
        email: this.user.email,
        normalAddress: this.address + "," + this.extraAddress,
        detailAddress: this.user.detailAddress,
      };
      try {
        let response = await UserService.updateUser(data);
        console.log(response.data);
        this.$router.push("/member/mypage");
      } catch (e) {
        console.log(e); // 에러 출력
      }
    },

    // 유저 소프트 삭제 함수
    async deleteUser() {
      try {
        let result = confirm("정말로 탈퇴 하시겠습니까?");
        if (result) {
          let response = UserService.deleteUser(this.user.userId);
          console.log(response);
          AuthService.logout(); // LOCAL저장소에서 USER객체 삭제해주기
          this.$store.commit("logout"); //
          alert("회원 탈퇴가 완료되었습니다");
          this.$router.push("/");
        } else {
          return;
        }
      } catch (e) {
        console.log(e);
      }
    },

    // 유저 삭제 확인 함수
    confirmDeleteUser() {
      if (confirm("정말로 탈퇴 하시겠습니까?")) {
        console.log("회원 탈퇴 완료");
      } else {
        console.log("회원 탈퇴 취소");
        return;
      }
    },

    // 주소함수
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
  mounted() {
    this.getUser(this.$store.state.user.userId);
  },
};
</script>
<style>
.addressBtn {
  /* 주소 검색 버튼 */
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

#withDraw {
  background-color: white;
  color: black;
  font-size: 20px;
  width: 200px;
  height: 50px;
}
</style>
