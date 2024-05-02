<template>
  <br />
  <br />
  <br />
  <div class="container mt-5">
    <h1 class="mt-4">상품 상세보기</h1>
    <hr />


    <br />
    <br />
    <br />

    <!-- 4. 배송 상품 -->
    <div>
      <h2>배송 상품</h2>
    </div>
    <!-- 기본 정보 테이블 시작-->
    <table class="table">
      <thead>
        <tr>
          <!-- 제목 : 상품정보, 판매가, 수량, 구매가 -->
          <th scope="col">상품정보</th>
          <th scope="col"></th>
          <th scope="col">상품가격</th>
          <th scope="col">수량</th>
          <th scope="col">총 상품가격</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <!-- 1) 배송 상품 -->
          <td scope="row">
            <img
              :src="product.prodImgUrl"
              style="width: 100px; height: 100px"
            />
          </td>
          <td>
            <p style="margin-top: 35px">{{ product.prodName }}</p>
          </td>
          <!-- 2) 상품가격 -->
          <td>
            <p style="margin-top: 35px">
              {{
                this.product.defaultPrice *
                (1 - this.product.discountRate / 100)
              }}원
            </p>
          </td>
          <!-- 3) 수량 -->
          <td style="text-align: left">
            <p style="margin-top: 35px">{{ orderAmount }}개</p>
          </td>
          <!-- 4) 총 상품가격 -->
          <td style="text-align: left">
            <p style="margin-top: 35px">
              {{
                this.product.defaultPrice *
                (1 - this.product.discountRate / 100) *
                orderAmount
              }}원
            </p>
          </td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />
  </div>
</template>

<script>
import UserService from "@/services/user/UserService";
import ProductService from "@/services/product/ProductService";
import OrderService from "@/services/product/OrderService";
// import OrderService from "@/services/product/OrderService";

export default {
  data() {
    return {
      address: {
        normalAddress: "",
        extraAddress: "",
      },

      isModalVisible: false,

      // 주문 수량
      orderAmount: 2,

      user: {
        //  userId;
        //  password;
        //  userName;
        //  birthday;
        //  phoneNum;
        //  callNum;
        //  email;
        //  role;
        //  normalAddress;
        //  detailAddress;
      },
      product: {
        //       prodId;       // 기본키, 시퀀스, 상품id
        // prodName;      // 상품 이름
        //  defaultPrice; // 원가
        // prodCategory;  // 카테고리
        // prodImg;       // 상품 이미지
        // prodDetailPage; // 상품 상세 페이지
        //  discountRate; // 할인율
        //  prodStock;    // 재고
        // prodStatus;    // 상품 판매 상태
        //  soldCount;    // 상품 판매 횟수
        // prodImgUrl;     // 상품 이미지 url
        // prodDetailPageUrl; // 상품 상세 이미지 url
        // prodImgUuid;       // 상품 이미지 uuid
        // prodDetailPageUuid; // 상품 상세 이미지 uuid
      },

      // orderName: this.user.userName,
      orderName: "",
      shoppingFee: 3000,
      zipCode: "",
      orderDetailAddress: "",
      orderRequest: "",
      orderRequestDetail: "", // 주문 요청사항이 직접 입력이면 여기에 저장
      receiver: "",
      paymentType: "", // 결제수단
    };
  },
  methods: {
    // // TODO: 결제 수단 저장
    // savePaymentMethod() {
    //   // 선택한 결제 수단을 저장하거나 처리하는 로직
    //   console.log("Selected Payment Method:", this.paymentType);
    //   // 여기에 선택한 결제 수단을 서버로 전송하여 저장하는 로직을 추가할 수 있습니다.
    // },

    // TODO: 주문 저장함수
    async saveOrder() {
      let now = new Date(); // js 날짜 객체
      // 날짜포맷 : yyyy-mm-dd hh:mi:ss 형태
      // 년도 : now.getFullYear()
      // 월 : now.getMonth()
      // 일 : noew.getDate()
      // 시 : now.getHours()
      // 분 : now.getMinutes()
      // 초 : noww.getSeconds()
      let formatNow = `${now.getFullYear()}-${
        now.getMonth() + 1
      }-${now.getDate()} ${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
      // 주문 상품 객체 : 선택한 상품의 id, 주문 수량을 orderProduct 객체에 저장
      let orderProd = {
        prodId: this.product.prodId,
        orderAmount: this.orderAmount,
      };

      // 배열 생성
      let orderProds = [];

      // 이를 orderProductList 주문 상품 배열로 값 넣기
      orderProds.push(orderProd);

      // 주문 정보 객체 생성 : 임시 객체 data에 dto 주문 속성 넣기
      let data = {
        userId: this.user.userId,
        orderName: this.user.userName,
        orderPrice:
          this.product.defaultPrice *
          (1 - this.product.discountRate / 100) *
          this.orderAmount,
        shoppingFee: 3000,
        zipCode: this.zipCode,
        orderAddress:
          this.address.normalAddress + "," + this.address.extraAddress,
        orderDetailAddress: this.orderDetailAddress,
        orderTime: formatNow,
        orderRequest: this.orderRequest,
        receiver: this.receiver,
        paymentType: this.paymentType,
        orderProds,
      };
      // 주문 요청 사항 : 직접 배송일 때 작성한 요청사항이 저장
      if (this.orderRequest == "5") {
        data.orderRequest = this.orderRequestDetail;
      }

      try {
        let response = await OrderService.saveOrder(data); // 주문 정보를 서버에 전송(post 요청 수행)
        console.log(response.data);
        this.$router.push("/order/payment");
      } catch (error) {
        console.log(error);
      }
    },

    // TODO: userID로 상세조회하는 함수
    async retrieveUser(userId) {
      try {
        let response = await UserService.get(userId);
        this.user = response.data;

        console.log(this.user); // console로 찍기
      } catch (error) {
        console.log(error);
      }
    },
    // TODO: prodId로 상세조회하는 함수

    async retrieveProduct(prodId) {
      try {
        let response = await ProductService.get(prodId);
        console.log(response.data);
        this.product = response.data;
        this.orderPrice = response.data.defaultPrice; // 비동기 함수이기에 언제 값이 들어올지 모른다. 그러면 이 함수에 의한 데이터가 들어가기 전에 먼저 orderprice가 값이 안 들어간 product에서 값을 가져오게 된다.
        // todo : 진짜 해야하는 일 = amount를 가져오게 되면 orderPrice의 값 바꾸기
      } catch (error) {
        console.log(error);
      }
    },
    // TODO: 주문 저장, 결제하기로 이동하는 함수
    async goPayment() {
      // saveOrder 함수 호출
      try {
        let response = await this.saveOrder(); // saveOrder 함수 호출 및 await로 비동기 처리
        console.log(response);
      } catch (error) {
        console.error("에러 발생 : ", error);
        // 주문 저장 중 오류가 발생한 경우에 대한 처리
      }
      this.$router.push("/order/Payment");
    },

    // TODO: 결제 모달 여는 로직 (비동기, saveOrder 추가했음)
    async togglePaymentModal() {
      this.isModalVisible = !this.isModalVisible; // 결제하기 버튼 클릭 시 모달 상태 토글

      // saveOrder 함수 호출
      try {
        let response = await this.saveOrder(); // saveOrder 함수 호출 및 await로 비동기 처리
        console.log(response);
      } catch (error) {
        console.error("에러 발생 : ", error);
        // 주문 저장 중 오류가 발생한 경우에 대한 처리
      }
    },
  },
  mounted() {
    // TODO: userId로 조회해서 주문자에 자동입력 후 -> prodId로 주문 페이지 뜸
    // this.retrieveUser(this.$store.state.userId).then(() => {
    //   this.order.orderName = this.user.userName; // retrieveUser 완료 후에 호출
    // });
    this.retrieveUser(this.$store.state.userId);
    this.retrieveProduct(this.$route.params.prodId);
    console.log(this.product); // console로 찍기



    // TODO: 페이지 로드 시 초기 설정
    document.addEventListener("DOMContentLoaded", function () {
      var orderMessageInput = document.getElementById("ordermessage");
      orderMessageInput.style.display = "none"; // 페이지 로드 시 텍스트 상자 숨기기
    });
  },
};
</script>

<style>
.orderbox {
  height: 5vw;
  border: 1px solid #342a26;
  color: #342a26;
}
#addressBtn {
  /* 주소 검색 버튼 */
  background-color: #342a26;
  color: white;
}
#ordermessage {
  height: 5vw;
  border: 1px solid #cccccc;
}
ul {
  list-style-type: none; /* 리스트 스타일을 없앰 */
}
.final {
  border: 1px solid #cccccc;
  height: 10vw;
}
.payment-container {
  width: 100%; /* 전체 컨테이너의 가로 길이를 화면 전체로 설정 */
  display: flex;
  flex-direction: column;
  align-items: center; /* 내부 요소들을 가운데 정렬 */
}
.payment-section h2 {
  text-align: center; /* 텍스트를 중앙 정렬합니다 */
  margin: 0 auto; /* 상하 마진을 0으로 설정하고 좌우 마진을 자동으로 설정하여 중앙 정렬 효과를 줍니다 */
  width: 100%; /* h2 태그의 너비를 부모 요소의 전체 너비로 설정합니다 */
}
.payment-section {
  width: 80%; /* 최종 결제 정보 섹션의 가로 길이를 넓혀줍니다 */
  margin-bottom: 20px; /* 아래쪽 여백 추가 */
}
.payment-button {
  width: 80%; /* 결제 버튼의 가로 길이를 넓혀줍니다 */
}
.paymentInfo {
  margin: 20px;
  border: 1px solid #cccccc;
  display: flex;
  flex-direction: column;
}
.paymentTr {
  display: flex;
  justify-content: space-between;
  font-size: 15px;
  margin-bottom: 30px; /* 원하는 간격으로 조정하세요. */
}
.paymentTr:last-child {
  margin-bottom: 0;
}
.paymentTr + .paymentTr {
  margin-top: 15px; /* 항목 사이의 간격을 조절합니다. 필요에 따라 값을 조정하세요. */
}
#payMethod {
  height: 11vw;
}
#btnPay {
  display: block; /* 버튼을 블록 요소로 만들어 전체 너비를 차지하게 합니다. */
  width: 100%; /* 버튼의 너비를 조정합니다. */
  margin-top: 20px; /* 버튼과 최종 결제 정보 사이의 간격을 조절합니다. */
  height: 3vw;
  background-color: #342a26;
  color: white;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}
.payTitle {
  text-align: left;
}
.price {
  text-align: right;
}
#payTitle {
  margin-right: 5vw;
}
</style>
