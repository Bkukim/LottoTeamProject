<template>
  <br />
  <br />
  <br />
  <div class="container mt-5">
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
                v-model="order.receiver"
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
                  v-model="order.zipcode"
                  placeholder="우편번호"
                  disabled
                />
              </div>
              <!-- 주소검색 버튼 -->
              <div class="col">
                <input
                  class="btn"
                  type="button"
                  @click="execDaumPostcode()"
                  value="우편번호 찾기"
                  id="addressBtn"
                />
              </div>
            </div>
            <div class="row mb-1">
              <div class="col">
                <input
                  class="form-control"
                  type="text"
                  v-model="orderAddress"
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
                  v-model="orderDetailAddress"
                  placeholder="상세주소"
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
            <div class="row mb-3">
              <div class="col-12">
                <select class="form-select" aria-label="Default select example">
                  <option selected value="0">배송메세지를 선택해주세요</option>
                  <option value="1">배송전 미리 연락해주세요.</option>
                  <option value="2">부재 시 경비실에 맡겨주세요.</option>
                  <option value="3">부재 시 문 앞에 놓아주세요.</option>
                  <option value="4">벨을 누르지 말아주세요.</option>
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
          <th scope="col">판매가</th>
          <th scope="col">수량</th>
          <th scope="col">구매가</th>
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
          <!-- 2) 판매가 -->
          <td>
            <p style="margin-top: 35px">
              {{
                product.defaultPrice -
                (product.defaultPrice * product.discountRate) / 100
              }}
            </p>
          </td>
          <!-- 3) 수량 -->
          <td><p style="margin-top: 35px"></p></td>
          <!-- 4) 구매가 -->
          <td><p style="margin-top: 35px"></p></td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />

    <!-- 5. 결제 수단 -->
    <div style="display: flex; justify-content: space-between">
      <div class="col-md-8">
        <div>
          <h2>결제 수단</h2>
        </div>

        <div>
          <hr />
        </div>
        <!-- 결제 수단 시작-->
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
                      />
                      <label class="form-check-label" for="tossPayment">
                        토스페이
                      </label>
                    </li>
                  </ul>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <div class="payment-container">
        <!-- 최종 결제 정보 -->
        <div class="col-md-4 payment-section">
          <h2>최종 결제 정보</h2>
          <div class="paymentInfo">
            <div id="payinfo">
              <!-- 총 상품 금액 -->
              <div class="paymentTr">
                <div class="payTitle">총 상품 금액</div>
                <div class="price">00 원</div>
              </div>
              <!-- 쿠폰 할인 금액 -->
              <div class="paymentTr">
                <div class="payTitle">쿠폰 할인 금액</div>
                <div class="price">00 원</div>
              </div>
              <!-- 총 배송비 -->
              <div class="paymentTr">
                <div class="payTitle">총 배송비</div>
                <div class="price">00 원</div>
              </div>
              <!-- 최종 결제 금액 -->
              <div class="paymentTr">
                <div class="payTitle">최종 결제 금액</div>
                <div class="price">00 원</div>
              </div>
            </div>
          </div>
          <!-- 7. 결제 버튼 -->
          <div class="mt-4">
            <button type="button" id="btnPay" @click="goPayment">
              결제하기
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- 결제 버튼 -->
    <div class="payment-button">
      <button
        type="button"
        id="btnPay"
        @click="togglePaymentModal"
        style="width: 100%"
      >
        결제하기
      </button>
    </div>
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
import OrderService from '@/services/product/OrderService';
// import OrderService from "@/services/product/OrderService";

export default {
  components: {
    CheckoutViewVue,
  },
  data() {
    return {
      address: "",
      orderAddress: "",
      extraAddress: "",
      isModalVisible: false,
      orderAmount:1,
      user: {
        userName: "",
        // email: "",
        phoneNum: "",
      },
      product: {},
      order: {
        userId: this.$store.state.userId,
        // orderName: this.user.userName,
        orderName: "",
        orderPrice: 0,
        shoppingFee: 0,
        zipcode: "",
        orderAddress: this.orderAddress + "," + this.extraAddress,
        orderDetailAddress: "",
        orderRequest: "",
        receiver: "",
      },
    };
  },
  methods: {
    // 주문 저장함수
    async saveOrder() {

      // 주문 상품 객체 : 상품id, 상품 수량
      let orderProduct={
        prodId:this.product.prodId,
        orderAmount:this.orderAmount
      }
      // 주문 상품 배열
      let orderProductList = [];

      // 배열에 값 넣기
      orderProductList.push(orderProduct);

      // 임시 객체 data에 dto 속성 넣기
      let data = {
        userId:this.userId,
        orderName: this.order.orderName,
        orderPrice:this.product.defaultPrice*(1-this.product.discountRate/100),
        shoppingFee : 3000,
        zipCode : this.order.zipcode,
        orderAddress:this.order.orderAddress,
        orderDetailAddress:this.order.orderDetailAddress,
        orderRequest:this.order.orderRequest,
        receiver:this.order.receiver,
        orderProductList,
      };
      try {
        let response = await OrderService.post(data);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    },

    // userID로 상세조회하는 함수
    async retrieveUser(userId) {
      console.log(userId);
      try {
        let response = await UserService.get(userId);
        console.log(response.data);
        this.user.userName = response.data.userName;
        this.user.phoneNum = response.data.phoneNum;
      } catch (error) {
        console.log(error);
      }
    },
    // prodId로 상세조회하는 함수
    async retrieveProduct(prodId) {
      try {
        let response = await ProductService.get(prodId);
        console.log(response.data);
        this.product = response.data;
      } catch (error) {
        console.log(error);
      }
    },
    // 주소 함수
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
    // 결제하기로 이동하는 함수
    goPayment() {
      this.$router.push("/order/tosspay");
    },
    togglePaymentModal() {
      this.isModalVisible = !this.isModalVisible; // 결제하기 버튼 클릭 시 모달 상태 토글
    },
    // 주문/결제 페이지 정보를 저장하는 함수
    // async saveOrder() {
    //   try {
    //     let data = {

    //     };
    //     let response = await OrderService.create(data);
    //   } catch (error) {
    //     console.log(error);
    //   }
    // },
  },
  mounted() {
    this.retrieveUser(this.$store.state.userId).then(() => {
      this.order.orderName = this.user.userName; // retrieveUser 완료 후에 호출
    });
    this.retrieveProduct(this.$route.params.prodId);
    console.log(this.product);  // console로 찍기
        // 직접 입력 옵션을 선택했을 때
    document.querySelector("select.form-select").addEventListener("change", function() {
        var orderMessageInput = document.getElementById("ordermessage");
        if (this.value === "5") { // 직접 입력 옵션 선택 시
            orderMessageInput.style.display = "block"; // 텍스트 상자 보이기
        } else {
            orderMessageInput.style.display = "none"; // 다른 옵션일 경우 숨기기
        }
    });

    // 페이지 로드 시 초기 설정
    document.addEventListener("DOMContentLoaded", function() {
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
