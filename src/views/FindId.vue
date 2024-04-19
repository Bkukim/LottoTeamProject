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

              <select class="form-select" aria-label="Default select example">
                <option selected>회원</option>
                <option value="1">관리자</option>
              </select>
            </div>
            <div class="mt-4 col-11">
              <label class="form-label" for="userName">이름</label>
              <input class="form-control" type="text" name="userName" />
            </div>
            <div class="row mt-4">
              <label class="form-label" for="address">휴대폰 번호</label>
              <div class="col-3">
                <select class="form-select" aria-label="Default select example">
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
                <input class="form-control" type="text" name="call" />
              </div>
              _
              <div class="col-4">
                <input class="form-control" type="text" name="call" />
              </div>
            </div>
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
export default {};
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
