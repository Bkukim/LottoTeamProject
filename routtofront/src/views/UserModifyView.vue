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
                <h1 scope="col">회원정보수정 테스트트트트ㅡ트</h1>
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
              <tr >
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
                    <input class="form-control" type="text" name="id" />
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
                    <input class="form-control" type="text" name="pwd" />
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
                      type="text"
                      name="pwdCheck"
                      id="pwdCheck"
                    />
                  </div>
                </td>
                <td></td>
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
                <td></td>
              </tr>
              <!-- 이름 tr -->
              <tr>
                <th scope="row">
                  <label class="form-label" for="userName">이름</label>
                </th>
                <td>
                  <input class="form-control" type="text" name="userName" />
                </td>
                <td></td>
              </tr>
              <!-- email tr -->
              <tr>
                <th scope="row">
                  <label class="form-label" for="email">email</label>
                </th>
                <td>
                  <input class="form-control" type="email" name="email" />
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
                      <input class="form-control" type="text" name="postcode"
                      v-model="postcode" />
                    </div>
                    <!-- 주소검색 버튼 -->
                    <div class="col">
                    <input type="button" class="addressBtn btn-sm"
                    @click="execDaumPostcode"
                    value="주소검색"
                    >
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
                      />
                    </div>
                  </div>
                  <div class="row mb-1">
                    <div class="col">
                      <input
                        class="form-control"
                        type="text"
                        name="address"
                        placeholder="상세주소"
                      />
                    </div>
                  </div>
                  <input
                  class="form-control"
                  type="text"
                  id="extraAddress"
                  v-model="extraAddress"
                  >
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
                    <div class="col-3">
                      <select
                        class="form-select"
                        aria-label="Default select example"
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
                      <input class="form-control" type="text" name="call" />
                    </div>
                    _
                    <div class="col-3">
                      <input class="form-control" type="text" name="call" />
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
                      <input class="form-control" type="text" name="call" />
                    </div>
                    _
                    <div class="col-3">
                      <input class="form-control" type="text" name="call" />
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
              <tr>
                <th scope="row">성별</th>
                <td>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="성별"
                      id="sex"
                      checked
                    />
                    <label class="form-check-label" for="flexRadioDefault3">
                      남자
                    </label>
                  </div>
                </td>
                <td>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="성별"
                      id="sex"
                    />
                    <label class="form-check-label" for="flexRadioDefault4">
                      여자
                    </label>
                  </div>
                </td>
              </tr>
              <!-- 생년월일 tr -->
              <tr>
                <th scope="row">
                  <label class="form-label" for="userName">생년월일</label>
                </th>
                <td>
                  <div class="col">
                    <input class="form-control" type="text" name="pwd" />
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
          >
            회원정보수정
          </button>
        </div>
        <!-- 회원 탈퇴 버튼 -->
        <div class="col-md-auto">
          <button
            class="singUpBtn btn-sm mt-4"
            id="withDraw"
            type="submit"
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
export default {
    data() {
        return {
            postcode: "",
            address: "",
            extraAddress: "",
        };
    },
    methods: {
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

  #withDraw{
    background-color: #ffffff;
    color: #342a26;  
    font-size: 1rem;
    width: 100px;
    height: 30px;
  }
  </style>
  