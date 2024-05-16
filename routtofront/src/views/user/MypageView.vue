<template>
  <div>
    <div>
      <h3>MY PAGE</h3>
      <hr />
    </div>

    <!-- mysave -->
    <!-- <div class="mysave container text-center">
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
    </div> -->
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

      <!-- <div class="container text-center mt-3 mb-3">
        <div class="row mapage_b2">
          <div class="col mapage_b2">
            회원 ID <br /><br />
            {값}
          </div>

          <div class="col mapage_b2">
            주문번호 <br /><br />
            {값}
          </div>

          <div class="col">
            주문상태<br /><br />
            {{order?.orderStatus}}
          </div> -->

      <table class="container text-center mt-3 mb-3">
        <tr class="row mapage_b2">
          <th class="col mapage_b2" style="border-right: 2px solid #342a26;" >주문번호</th>
          <th class="col mapage_b2" style="border-right: 2px solid #342a26;">주문 일</th>

          <th class="col mapage_b2" style="border-right: none;">주문상태</th>
          <th class="col mapage_b2"></th>
        </tr>
        <tr class="row mapage_b2" v-for="(data, index) in order" :key="index">
          <td class="col mapage_b2">
            <br /><br />
            {{ data.orderId }}
          </td>
          <td class="col mapage_b2">
            <br /><br />
            {{ data.orderTime }}
          </td>
          <td class="col">
            <br /><br />
            {{ data.orderStatus }}
          </td>
           <td class="col">
            <br /><br />
            <button @click="goToRefundPage(data.orderId)">환불</button>
          </td>

          <!-- <div class="col mapage_b2">
            배송완료 <br /><br />
            {값}
          </div> -->

          <!-- <div class="col no-border2">
            <div class="row container text-center">취소{값}</div>
            <br />
            <div class="row container text-center">교환{값}</div>
            <br />
            <div class="row container text-center">반품{값}</div>
          </div> -->
        </tr>
      </table>
      <!-- container -->
    </div>
    <!-- mypage_all_box -->

    <!-- mysave2 -->
    <div class="mysave2 container text-center mt-5">
      <div class="mysave2_in row">
        <!-- <div class="col no-border3">
          <img src="@/assets/images/mypage_1.png" />
          <br />
          <b>Order</b> <br />
          <p class="mini_box1">주문 내역 조회</p>
          <p class="mini_box2">
            고객님께서 주문하신 상품의 주문내역을 <br />확인하실 수 있습니다.
          </p>
        </div> -->

        
          <router-link to="/member/user-modify" class="col no-border3"
            ><img src="@/assets/images/mypage_2.png"
          />
          <br />
          <b>ProFile</b> <br />
          <p class="mini_box1">회원정보</p>
          <p class="mini_box2">
            회원이신 고객님의 개인정보를 <br />
            관리하는 공간입니다.
          </p>
        </router-link>

        <router-link to="/order/cart" class="col no-border3">
          <img src="@/assets/images/mypage_3.png" />
          <br />
          <b>Cart</b> <br />
          <p class="mini_box1">장바구니</p>
          <p class="mini_box2">
            장바구니에 담은 <br />
            상품의 목록을 보여드립니다.
          </p>
        </router-link>

        
          <router-link to="/shop/faqList" class="col no-border3"><img src="@/assets/images/mypage_4.png" />
          <br />
          <b>Consult</b> <br />
          <p class="mini_box1">고객센터</p>
          <p class="mini_box2">
            고객님의 궁금하신 문의사항에 대하여<br />
            1:1맞춤상담 내용을<br />
            확인하실 수 있습니다.
          </p>
        </router-link>

        <!-- <router-link to="/" class="col no-border3">
          <img src="@/assets/images/mypage_5.png" />
          <br />
          <b>Board</b> <br />
          <p class="mini_box1">게시물 관리</p>
          <p class="mini_box2">
            고객님께서 작성하신 게시물을<br />
            관리하는 공간입니다.
          </p>
        </router-link> -->
      </div>
    </div>
    <!-- mysave2 -->
  </div>
</template>
<script>
import OrderService from "@/services/product/OrderService";

export default {
  data() {
    return {
      order: [], // 초기값
    };
  },
  methods: {
    // TODO: 상세조회요청 함수 : 화면 뜰때
    // TODO: 비동기 코딩 : async ~ await
    async getOrder(userId) {
      try {
        // 상세조회 공통함수 실행 : DeptService.get()
        let response = await OrderService.getOrder(userId);

        this.order = response.data; // spring 결과를 바인딩 속성변수 dept 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
goToRefundPage(orderId){
  this.$router.push({ name: 'RefundRequest', params: { orderId: orderId } });
},
  },

  // TODO: 화면에 뜰때 자동 실행되는 함수
  mounted() {
    this.message = ""; // 변수 초기화
    // TODO: 뷰 사용법 : 주소(라우터주소)에서 변수 가져오기 방법
    // TODO: 사용법 : this.$route.params.변수명
    // TODO: 변수명 확인 : router/index.js => url 정의 (:dno)
    this.getOrder(this.$store.state.user.userId); // 상세조회 함수 실행
    window.scrollTo(0, 0);
  },
};
</script>
<style>
@font-face {
  font-family: "Pretendard-Regular";
  src: url("https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff")
    format("woff");
  font-weight: 400;
  font-style: normal;
}

th{
  padding-bottom: 15px;
  border-bottom: 2px solid #342a26;
}

button{
  background-color:#ffffff ;
  border: 1px solid #342a26;
  color: #342a26;
  border-radius: 5px;
  font-size: 12px;
  letter-spacing: -1.5px;
}


button:hover{
  background-color:#342a26 ;
  border: 1px solid #342a26;
  color: #ffffff;
  border-radius: 5px;
  font-size: 12px;
  letter-spacing: -1.5px;
  font-weight: bold;
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
  background-color: #342a26ee;
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

.no-border3 > b {
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
