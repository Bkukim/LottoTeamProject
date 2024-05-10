<template>
  <div>
    <div>
      <h3>MY PAGE</h3>
      <hr />
    </div>

    <!-- mysave -->
    <div class="mysave container text-center">
      <div class="row">
        <div class="col">
          보유 마일리지
          <button type="button" class="btn btn-outline-secondary">조회</button>
        </div>

        <div class="col no-border1">
          보유 쿠폰
          <button type="button" class="btn btn-outline-secondary">조회</button>
        </div>
      </div>
    </div>
    <!-- mysave -->

    <div class="mypage_all_box container mt-5 mb-5">
      <!-- mypage_all_box_in1 -->
      <div class="mypage_all_box_in1 container text-left">
        <p class="mapage_p">
          <b class="mapage_b">나의 주문 처리 현황</b>
          <span>(최근 3개월 기준)</span>
        </p>
      </div>
      <!-- mypage_all_box_in1 -->

      <div class="container text-center mt-3 mb-3">
        <div class="row mapage_b2">
          <div class="col">
            입금 전<br /><br />
            {값}
          </div>
          <div class="col mapage_b2">
            배송 준비중 <br /><br />
            {값}
          </div>
          <div class="col mapage_b2">
            배송중 <br /><br />
            {값}
          </div>
          <div class="col mapage_b2">
            배송완료 <br /><br />
            {값}
          </div>

          <div class="col no-border2">
            <div class="row container text-center">취소{값}</div>
            <br />
            <div class="row container text-center">교환{값}</div>
            <br />
            <div class="row container text-center">반품{값}</div>
          </div>
        </div>
      </div>
      <!-- container -->
    </div>
    <!-- mypage_all_box -->

    <!-- mysave2 -->
    <div class="mysave2 container text-center mt-5">
      <div class="mysave2_in row">
        <div class="col no-border3">
          <img src="@/assets/images/mypage_1.png" />
          <br />
          <b>Order</b> <br />
          <p class="mini_box1">주문 내역 조회</p>
          <p class="mini_box2">
            고객님께서 주문하신 상품의 주문내역을 <br />확인하실 수 있습니다.
          </p>
        </div>

        <div class="col no-border3">
          <img src="@/assets/images/mypage_2.png" />
          <br />
          <b>ProFile</b> <br />
          <p class="mini_box1">회원정보</p>
          <p class="mini_box2">
            회원이신 고객님의 개인정보를 <br />
            관리하는 공간입니다.
          </p>
        </div>

        <div class="col no-border3">
          <img src="@/assets/images/mypage_3.png" />
          <br />
          <b>WishList</b> <br />
          <p class="mini_box1">관심 상품</p>
          <p class="mini_box2">
            관심상품으로 등록하신 <br />
            상품의 목록을 보여드립니다.
          </p>
        </div>

        <div class="col no-border3">
          <img src="@/assets/images/mypage_4.png" />
          <br />
          <b>Consult</b> <br />
          <p class="mini_box1">고객센터</p>
          <p class="mini_box2">
            고객님의 궁금하신 문의사항에 대하여<br />
            1:1맞춤상담 내용을<br />
            확인하실 수 있습니다.
          </p>
        </div>

        <router-link to="/" class="col no-border3 ">
          <img src="@/assets/images/mypage_5.png" />
          <br />
          <b>Board</b> <br />
          <p class="mini_box1">게시물 관리</p>
          <p class="mini_box2">
            고객님께서 작성하신 게시물을<br />
            관리하는 공간입니다.
          </p>
        </router-link>


      </div>
    </div>
    <!-- mysave2 -->
  </div>
</template>
<script>
export default {};
</script>
<style>
@font-face {
  font-family: "Pretendard-Regular";
  src: url("https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff")
    format("woff");
  font-weight: 400;
  font-style: normal;
}






.btn {
  width: 50px;
  height: 30px;
  font-size: 12px;
  margin-left: 30px;
  border-color: #342a2680;
}

.btn:hover {
  background-color: #342a26bd;
  border-color: #ffffff;
}

.col {
  border-right: 1px dashed #cccccc;
  letter-spacing: -1.5px;
}

.row {
  padding: 10px 0 0 0;
}
.mysave {
  height: 100px;
  padding-top: 20px;
}

.mypage_all_box {
  border: 1px solid #342a26;
  padding: 0px;
}

.mypage_all_box_in1 {
  background-color: #342a26;
  padding: 10px 0 0 0;
  border-bottom: 1px solid #cccccc;
}

.mapage_p {
  padding-left: 20px;
  color: #ffffff;
}

.no-border1 {
  border-right: none;
}

.no-border2 {
  border-right: none;
}

.no-border3 {
  border: 1px solid #cccccc87;
  height: 300px;
  margin-right: 15px;
  padding-top: 50px;
}


.no-border3:hover {
  border-top: 3px solid #342a26;
  border-radius: 30px 0 30px 0;
  color: #2e2e2e;

}

.no-border3 {
  color: #2e2e2e; 
  text-decoration: none; 
}

.no-border3 >  b {
  color: #2e2e2e;
  text-decoration: none; 
}




img {
  height: 70px;
  width: 70px;
  margin-bottom: 20px;
}



.mapage_b {
  font-size: 15px;
  letter-spacing: -1.5px;
  font-weight: 500;
  margin-right: 20px;
}

.mapage_b2 {
  letter-spacing: -1.5px;
  font-weight: bold;
  font-size: 13px;
}

b {
  font-size: 25px;
  letter-spacing: -1.3px;
}

span {
  font-size: 10px;
  color: #342a26;
  color: #ffffff;
}

h3 {
  font-family: "Lora", serif;
  font-optical-sizing: auto;
  /* font-weight: <weight>; */
  font-style: normal;
}

.mini_box1 {
  letter-spacing: -2px;
  font-size: 13px;
  padding-top: 3px;
}

.mini_box2 {
  letter-spacing: -1px;
  font-size: 12px;
  color: #999999;
}
</style>