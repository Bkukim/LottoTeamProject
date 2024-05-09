<template>
  <div class="container">
    <h1 class="mt-4">주문/결제</h1>
    <hr />

    <br />
    <br />
    <br />

    <!-- 1. 주문자 정보 -->
    <div>
      <h2>주문자 정보</h2>
    </div>
    <!-- 기본 정보 테이블 시작-->
    <table class="table">
      <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <!-- 이름 tr -->
        <tr>
          <th scope="row">
            <label class="form-label" for="user">이름</label>
          </th>
          <td>
            <div class="col-6">
              <input
                class="form-control"
                type="text"
                name="user"
                v-model="user.userName"
                disabled
              />
            </div>
          </td>
        </tr>

        <!-- 연락처 tr -->
        <tr>
          <th scope="row">
            <label class="form-label" for="address">휴대폰 번호</label>
          </th>
          <td>
            <div class="col-6">
              <input
                class="form-control"
                type="text"
                name="call"
                :value="
                  user.phoneNum
                    ? user.phoneNum.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3')
                    : ''
                "
                disabled
              />
            </div>
          </td>
          <td></td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />

    <!-- 2. 배송지 정보 -->
    <div>
      <h2>배송지 정보</h2>
    </div>
    <!-- 기본 정보 테이블 시작-->
    <table class="table">
      <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <!-- 주문자 tr -->
        <tr>
          <th scope="row">
            <label for="receiver">받는분</label>
          </th>
          <td>
            <div class="col-4">
              <input
                class="form-control"
                type="text"
                name="receiver"
                v-model="receiver"
              />
            </div>
            <!-- <div class="col"></div> -->
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
                  v-model="zipCode"
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
                >
                  주소 검색
                </button>
              </div>
            </div>
            <div class="row mb-1">
              <div class="col">
                <input
                  class="form-control"
                  type="text"
                  v-model="address.normalAddress"
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
                  v-model="address.extraAddress"
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
                  v-model="orderDetailAddress"
                />
              </div>
            </div>
          </td>
          <td></td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />

    <!-- 3. 배송 요청사항 -->
    <div>
      <h2>배송 요청사항</h2>
    </div>
    <!-- 기본 정보 테이블 시작-->
    <table class="table">
      <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <!-- 배송 요청사항 tr -->
        <tr>
          <th scope="row">
            <label for="receiver">배송 요청사항</label>
          </th>
          <td>
            <!-- 배송 메세지 선택 옵션 -->
            <div class="row mb-1">
              <div class="col-12">
                <select
                  class="form-select"
                  aria-label="Default select example"
                  v-model="orderRequest"
                >
                  <option selected value="">배송메세지를 선택해주세요</option>
                  <option value="배송전 미리 연락해주세요">
                    배송전 미리 연락해주세요
                  </option>
                  <option value="부재 시 경비실에 맡겨주세요">
                    부재 시 경비실에 맡겨주세요
                  </option>
                  <option value="부재 시 문 앞에 놓아주세요">
                    부재 시 문 앞에 놓아주세요
                  </option>
                  <option value="벨을 누르지 말아주세요">
                    벨을 누르지 말아주세요
                  </option>
                  <option value="5">직접 입력</option>
                </select>
              </div>
            </div>

            <!-- 직접 입력 누를 시 나오는 박스 -->
            <div class="row">
              <div class="col-12">
                <input
                  class="form-control"
                  type="text"
                  name="ordermessage"
                  id="ordermessage"
                  v-model="orderRequestDetail"
                />
              </div>
            </div>
          </td>
          <td></td>
        </tr>
      </tbody>
    </table>

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
        <tr v-for="(data, index) in cartList" :key="index">
          <!-- 1) 배송 상품 -->
          <td scope="row">
            <img
              :src="data.prodImgUrl"
              style="width: 100px; height: 100px"
            />
          </td>
          <td>
            <p style="margin-top: 35px">{{ data.prodName }}</p>
          </td>
          <!-- 2) 상품가격 -->
          <td>
            <p style="margin-top: 35px">
              {{Math.ceil(data.prodPrice)}}원
            </p>
          </td>
          <!-- 3) 수량 -->
          <td style="text-align: left">
            <p style="margin-top: 35px">{{ data.cartProdCount }}개</p>
          </td>
          <!-- 4) 총 상품가격 -->
          <td style="text-align: left">
            <p style="margin-top: 35px">
              {{Math.ceil(data.totalPrice)}}원
            </p>
          </td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />

    <!-- 5. 결제 수단 -->
    <div style="display: flex; justify-content: space-between">
      <div class="col-md-8">
        <!-- 결제 수단 -->
        <div>
          <h2>결제 수단</h2>
        </div>

        <div>
          <hr />
        </div>
        <!-- 결제 수단 목록-->
        <div>
          <table class="table" id="payMethod">
            <tbody>
              <tr>
                <th scope="row">
                  <div>결제방법</div>
                </th>
                <td>
                  <ul>
                    <!-- 신용카드 -->
                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="creditCard"
                        v-model="paymentType"
                        value="신용카드"
                      />
                      <label class="form-check-label" for="creditCard">
                        신용카드
                      </label>
                    </li>

                    <!-- PAYCO -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="payco"
                        v-model="paymentType"
                        value="PAYCO"
                      />
                      <label class="form-check-label" for="payco">
                        PAYCO
                      </label>
                    </li>

                    <!-- 카카오페이 -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="kakaoPay"
                        v-model="paymentType"
                        value="카카오페이"
                      />
                      <label class="form-check-label" for="kakaoPay">
                        카카오페이
                      </label>
                    </li>

                    <!-- 네이버페이 -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="naverPay"
                        v-model="paymentType"
                        value="네이버페이"
                      />
                      <label class="form-check-label" for="naverPay">
                        네이버페이
                      </label>
                    </li>

                    <!-- 휴대폰결제 -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="mobilePayment"
                        v-model="paymentType"
                        value="휴대폰결제"
                      />
                      <label class="form-check-label" for="mobilePayment">
                        휴대폰결제
                      </label>
                    </li>

                    <!-- 계좌이체 -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="bankTransfer"
                        v-model="paymentType"
                        value="계좌이체"
                      />
                      <label class="form-check-label" for="bankTransfer">
                        계좌이체
                      </label>
                    </li>

                    <!-- 토스페이 -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="tossPayment"
                        v-model="paymentType"
                        value="토스페이"
                      />
                      <label class="form-check-label" for="tossPayment">
                        토스페이
                      </label>
                    </li>

                    <!-- 무통장입금 -->

                    <li>
                      <input
                        class="form-check-input"
                        type="radio"
                        name="flexRadioDefault"
                        id="tossPayment"
                        v-model="paymentType"
                        value="무통장입금"
                      />
                      <label class="form-check-label" for="bankTransferPayment">
                        무통장입금
                      </label>
                    </li>
                  </ul>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <!-- 6. 최종 결제 정보 -->
      <div class="payment-container">
        <div class="col-md-4 payment-section">
          <h2>최종 결제 정보</h2>
          <div class="paymentInfo">
            <div id="payinfo">
              <!-- 총 상품 금액 -->
              <div class="paymentTr">
                <div class="payTitle">총 상품 금액</div>
                <div class="price">
                  {{
                   cartTotalPrice
                  }}
                  원
                </div>
              </div>
              <!-- 쿠폰 할인 금액 -->
              <!-- <div class="paymentTr">
                <div class="payTitle">쿠폰 할인 금액</div>
                <div class="price">00 원</div>
              </div> -->
              <!-- 총 배송비 -->
              <div class="paymentTr">
                <div class="payTitle">총 배송비</div>
                <div class="price">{{ shoppingFee }} 원</div>
              </div>
              <!-- 최종 결제 금액 -->
              <div class="paymentTr">
                <div class="payTitle">최종 결제 금액</div>
                <div class="price" >
                 {{cartTotalPrice+3000}}
                  원
                </div>
              </div>
            </div>
          </div>
          <!-- 7. 결제 버튼 -->
          <!-- <div class="mt-4">
            <button type="button" id="btnPay" @click="togglePaymentModal">
              결제하기
            </button>
          </div> -->

          <!-- 임시 결제 버튼 -->
          <div class="mt-4">
            <button type="button" id="btnPay" @click="saveOrder">
              주문확인
            </button>
          </div>
        </div>
        <!-- 7. 결제 버튼 -->
        <div class="mt-4">
          <button type="button" id="btnPay" @click="togglePaymentModal">결제하기</button>
        </div>
      </div>
    </div>
    <!-- 결제 버튼 -->
    <!-- <div class="payment-button">
      <button
        type="button"
        id="btnPay"
        @click="togglePaymentModal"
        style="width: 100%"
      >
        결제하기
      </button>
    </div> -->
  </div>

  <div>
    <div>
      <!-- 결제 모달 -->
      <CheckoutViewVue
        v-if="isModalVisible"
        @close="isModalVisible = false"
      ></CheckoutViewVue>
    </div>
    <br />
  </div>
</template>

<script>
import CheckoutViewVue from "../payment/CheckoutView.vue";
import UserService from "@/services/user/UserService";
import ProductService from "@/services/product/ProductService";
import OrderService from "@/services/product/OrderService";

export default {
  components: {
    CheckoutViewVue,
  },
  data() {
    return {
      cartList: [
  //         CartId(); // 기본키  시퀀스 장바구니 번호
  // UserId(); //회원번호
  // CartProdCount(); // 각 상품의 갯수

  // ProdId();       // 상품번호
  // ProdName();      // 상품 이름
  // DefaultPrice(); // 원가
  // DiscountRate(); // 할인율
  // ProdImgUrl(); // 상품 이미지 Url
  // ProdPrice(); // 할인율 적용한 상품 가격
  // TotalPrice(); // 배송비 포함한 총 가격

      ], // cart에서 목록 가져오는 배열

      cartTotalPrice:0,

      address: {
        normalAddress: "",
        extraAddress: "",
      },

      isModalVisible: false,

      // 주문 수량
      orderAmount: 1,

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
    async retreiveCartAll(userId) {
      try {
        let response = await OrderService.get(userId);
        console.log(response.data);
        this.cartList = response.data;
        this.sumTotalPrice();
        // this.user = response.data;
      } catch (error) {
        console.log(error);
      }
    },
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
      // 초 : now.getSeconds()
      let formatNow = `${now.getFullYear()}-${
        now.getMonth() + 1
      }-${now.getDate()} ${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
      // 주문 상품 객체 : 선택한 상품의 id, 주문 수량을 orderProduct 객체에 저장
     
      // 배열 생성
      let orderProds = [];

      // cartList 배열만큼 prodId, cartProdCount 넣기 (OrderProd에도 DB저장되어야하는데 orderProdId, orderId는 알아서 들어옴)
      for (let i = 0; i < this.cartList.length; i++) {
        let orderProd={
          prodId: this.cartList[i].prodId,
        orderAmount: this.cartList[i].cartProdCount,
        }
         orderProds.push(orderProd);
        
      }

      // 이를 orderProductList 주문 상품 배열로 값 넣기
     

      // 주문 정보 객체 생성 : 임시 객체 data에 dto 주문 속성 넣기
      let data = {
        userId: this.user.userId,
        orderName: this.user.userName,
        orderPrice: this.cartTotalPrice,
          // this.product.defaultPrice *
          // (1 - this.product.discountRate / 100) *
          // this.orderAmount,
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
        this.orderAmount = this.$store.state.orderAmount;
        this.$store.state.orderAmount = 1;
        // todo : 진짜 해야하는 일 = amount를 가져오게 되면 orderPrice의 값 바꾸기
      } catch (error) {
        console.log(error);
      }
    },
    // TODO: 주소 함수
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.address.extraAddress !== "") {
            this.address.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.address.normalAddress = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.address.normalAddress = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.address.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.address.extraAddress +=
                this.address.extraAddress !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.address.extraAddress !== "") {
              this.address.extraAddress = `(${this.address.extraAddress})`;
            }
          } else {
            this.address.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.zipCode = data.zonecode;
        },
      }).open();
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
    sumTotalPrice(){
      for (let i = 0; i < this.cartList.length; i++) {
        this.cartTotalPrice += this.cartList[i].totalPrice;
    }
  },},
  mounted() {
    // 화면 뜰때 상단이 뜨게 해주는 함수
    window.scrollTo(0, 0);
    // alert(this.$store.state.user.userId);
    // userId로 조회해서 주문자에 자동입력 후 -> prodId로 주문 페이지 뜸
    // this.retrieveUser(this.$store.state.userId).then(() => {
    //   this.order.orderName = this.user.userName; // retrieveUser 완료 후에 호출
    // });
    this.retrieveUser(this.$store.state.user.userId);
    // 배송 요청 사항 : 직접 입력 옵션을 선택했을 때 텍스트 상자
    document
      .querySelector("select.form-select")
      .addEventListener("change", function () {
        var orderMessageInput = document.getElementById("ordermessage");
        if (this.value === "5") {
          // 직접 입력 옵션 선택 시
          orderMessageInput.style.display = "block"; // 텍스트 상자 보이기
        } else {
          orderMessageInput.style.display = "none"; // 다른 옵션일 경우 숨기기
        }
      });

    // 페이지 로드 시 초기 설정
    document.addEventListener("DOMContentLoaded", function () {
      var orderMessageInput = document.getElementById("ordermessage");
      orderMessageInput.style.display = "none"; // 페이지 로드 시 텍스트 상자 숨기기
    });

    // 페이지 초기 화면 : 상품 뜨게 하기
    this.retreiveCartAll(this.$store.state.user.userId);

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
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.payment-section h2 {
  text-align: center;
  margin: 0 auto;
  width: 100%;
}
.payment-section {
  width: 80%;
  margin-bottom: 20px;
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
  margin-bottom: 30px;
}
.paymentTr:last-child {
  margin-bottom: 0;
}
.paymentTr + .paymentTr {
  margin-top: 15px;
}
#payMethod {
  height: 11vw;
}
#btnPay {
  display: block;
  width: 100%;
  margin-top: 20px;
  height: 3vw;
  background-color: #342a26;
  color: white;
  border-radius: 5px;
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
