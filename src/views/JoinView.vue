<template>
  <div class="container mt-5">
    <div class="row">
      <div class="col"></div>

      <div class="col-10">
        <!-- 회원유형 테이블 시작 -->
        <table class="table">
          <thead>
            <tr>
              <h4 scope="col">회원가입</h4>
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
                    checked
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
              <h4 scope="col">기본 정보</h4>
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
                <input
                  class="form-control log-form"
                  type="text"
                  name="id"
                  id="id"
                />
              </td>
              <td></td>
            </tr>
            <!-- 비밀번호 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="pwd">비밀번호</label>
              </th>
              <td>
                <input
                  class="form-control log-form"
                  type="text"
                  name="pwd"
                  id="pwd"
                />
              </td>
              <td></td>
            </tr>
            <!-- 비밀번호 확인 tr -->
            <tr>
              <th scope="row">
                <label class="form-label" for="pwdCheck">비밀번호 확인</label>
              </th>
              <td>
                <input
                  class="form-control"
                  type="text"
                  name="pwdCheck"
                  id="pwdCheck"
                />
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
                <input
                  class="form-control"
                  type="text"
                  name="pwdAskCheck"
                  id="pwdAskCheck"
                />
              </td>
              <td></td>
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
                  id="userName"
                />
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
                      name="address"
                      id="address"
                    />
                  </div>
                  <!-- 주소검색 버튼 -->
                  <div class="col">
                    <button class="btn addressBtn btn-sm" id="find-idpw" type="submit">주소검색</button>
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      name="address"
                      id="address"
                    />
                  </div>
                </div>
                <div class="row mb-1">
                  <div class="col">
                    <input
                      class="form-control"
                      type="text"
                      name="address"
                      id="address"
                    />
                  </div>
                </div>
              </td>
              <td></td>
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
                  id="userName"
                />
              </td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="col"></div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style>
.addressBtn{ /* 주소 검색 버튼 */
  background-color: #342a26;
  color: white;
}
</style>
