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
                v-model="user.phoneNum"
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
    <div style="display: flex">
      <div class="col-sm-8">
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

      <!-- 6. 최종 결제 정보 -->
      <div class="col-sm-4" style="text-align: right; align-item: center">
        <h2>최종 결제 정보</h2>
        <div class="paymentInfo">
          <!-- <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
              </tr>
          </thead> -->

          <div id="payinfo">
            <!-- 총 상품 금액 -->
            <tr id="paymentTr">
              <th scope="row">
                <p id="payTitle">총 상품 금액</p>
              </th>
              <td>
                <div>
                  <p id="price">00 원</p>
                </div>
              </td>
            </tr>
            <!-- 쿠폰 할인 금액 -->
            <tr id="paymentTr">
              <th scope="row">
                <p id="payTitle">쿠폰 할인 금액</p>
              </th>
              <td>
                <div id="price">
                  <p>00 원</p>
                </div>
              </td>
            </tr>

            <!-- 총 배송비 tr -->
            <tr id="paymentTr">
              <th scope="row">
                <p id="payTitle">총 배송비</p>
              </th>
              <td>
                <div id="price">
                  <p>00 원</p>
                </div>
              </td>
            </tr>

            <!-- 최종 결제 금액 tr -->
            <tr id="paymentTr">
              <th scope="row">
                <p id="payTitle">최종 결제 금액</p>
              </th>
              <td>
                <div id="price">
                  <p>00 원</p>
                </div>
              </td>
              <td></td>
            </tr>
          </div>
        </div>
        <!-- 7. 결제 버튼 -->
        <div class="mt-4">
          <button type="button" id="btnPay" @click="goPayment">결제하기</button>
        </div>
        <br />
      </div>
    </div>
  </div>
</template>

<script>
import UserService from "@/services/user/UserService";
import ProductService from "@/services/product/ProductService";
// import OrderService from "@/services/product/OrderService";

export default {
  data() {
    return {
      address: "",
      orderAddress:"",
      extraAddress: "",
      user: {
        userName: "",
        // email: "",
        phoneNum: "",
      },
      product: {},
      order: {
        userId: this.$store.state.userId,
        // orderName: this.user.userName,
        orderName:"",
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
      this.$router.push("/order/payment");
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
  this.retrieveUser(this.$store.state.userId)
    .then(() => {
      this.order.orderName = this.user.userName; // retrieveUser 완료 후에 호출
    });
  this.retrieveProduct(this.$route.params.prodId);
}
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
.paymentInfo {
  margin: 20px;
  border: 1px solid #cccccc;
  /* width: 27vw; */
  height: 11vw;
  /* padding: 50px; */
  /* background-color: #342a26; */
  /* color: white; */
}
/* #paymentTr { */
/* padding: 90px; */
/* padding: 50px; */
/* background-color: #342a26; */
/* } */
#payMethod {
  height: 11vw;
}
#btnPay {
  width: 12vw;
  height: 3vw;
  background-color: #342a26;
  color: white;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}
#payTitle {
  margin-right: 5vw;
}
</style>
