<template>
  <div class="container mt-3">
    <div class=" ">
      <h3 class="mb-4 mt-5">로그인</h3>
      <hr />
      <!-- 로그인 회원가입 라인 -->
      <div class="row">
        <!-- 로그인 시작 -->
        <div class="col log col-divider">
          <h5 class="mb-4 mt-4 log-form"><strong>회원 로그인</strong></h5>
          <form action="login.jsp" method="post">
            <div class="mb-3">
              <label class="insert-id log-form" for="id">아이디</label>
              <input
                class="form-control log-form"
                type="text"
                placeholder="ID"
                name="id"
                id="id"
              />
            </div>
            <div class="mb-3">
              <label class="form-label log-form" for="pwd">비밀번호</label>
              <input
                class="form-control log-form"
                type="password"
                placeholder="PASSWORD"
                name="pwd"
                id="pwd"
              />
            </div>

            <div class="mb-3">
              <button
                class="btn text-light btn-sm mt-4 log-form"
                id="login-bt"
                type="submit"
              >
                로그인
              </button>
            </div>
          </form>
        </div>
        <!-- 회원가입 시작 -->
        <div class="col join">
          <h5 class="mb-1 mt-4 join-form"><strong>회원가입</strong></h5>
          <form action="login.jsp" method="post">
            <div class="mb-3 join-form">
              <button
                class="btn text-light btn-sm mt-4"
                id="login-bt"
                type="submit"
              >
                회원가입
              </button>
              <div class="mt-5">
                <h5><strong>ID/PW 찾기</strong></h5>
              </div>
            </div>
            <div class="join-form mt-0">
              <button class="btn btn-sm" id="find-idpw" type="submit">
                아이디 찾기
              </button>
              <button class="btn btn-sm mt-4 mb-3" id="find-idpw" type="submit">
                비밀번호 찾기
              </button>
            </div>
          </form>
        </div>
      </div>
      <!-- 소셜로그인 -->
      <div class="row text-center mt-5">
        <div>
          <button class="btn btn-custom naver mt-4 mb-3" id="find-idpw" type="submit">
            <img src="@/assets/img/N.png">     &nbsp;&nbsp;        네이버 로그인 / 회원가입
          </button>
        </div>
      </div>
      <div class="row text-center">
        <div>
          <button class="btn btn-custom naver mt-4 mb-3" id="find-idpw" type="submit">
            <img src="@/assets/img/K.png">     &nbsp;&nbsp;        카카오 로그인 / 회원가입
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style>
#id {
  width: 483px;
  height: 65px;
}
#pwd {
  width: 483px;
  height: 65px;
}
#login-bt {
  width: 483px;
  height: 65px;
  background-color: #342a26;
}
#find-idpw {
  width: 483px;
  height: 65px;
  background-color: white;
  border-color: black;
  color: black;
}
.col-divider {
  border-right: 1px solid #ccc; /* 수직선 스타일 설정 */
  padding-right: 0.7813vw; /* 선택적으로 간격을 추가할 수 있습니다. */
}
.log {
  margin-top: 3.6458vw;
}
.join {
  margin-top: 3.6458vw;
}
.log-form {
  margin-left: 3.6458vw;
}
.join-form {
  margin-left: 3.6458vw;
}
.naver{
  color: #4CBB18;
  font-size: 20px;
}
.naver img{
  width: 25px; /* 이미지의 너비를 원하는 크기로 조절합니다. */
}
</style>
