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

    <!-- 주문자 정보 -->
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
            <label class="insert-user" for="user">이름</label>
          </th>
          <td>
            <div class="col-6">
              <input class="form-control" type="text" name="user" />
            </div>
          </td>
        </tr>

        <!-- 이메일 확인 tr -->
        <tr>
          <th scope="row">
            <label class="form-label" for="email">이메일</label>
          </th>
          <td>
            <div class="col-6">
              <input class="form-control" type="text" name="email" id="email" />
            </div>
          </td>
          <td></td>
        </tr>

        <!-- 연락처 tr -->
        <tr>
          <th scope="row">
            <label class="form-label" for="address">휴대폰 번호</label>
          </th>
          <td>
            <div class="row">
              <div class="col-2">
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
              <div class="col-2">
                <input class="form-control" type="text" name="call" />
              </div>
              _
              <div class="col-2">
                <input class="form-control" type="text" name="call" />
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

    <!-- 배송지 정보 -->
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
            <label class="insert-receiver" for="receiver">받는분</label>
          </th>
          <td>
            <div class="col-4">
              <input class="form-control" type="text" name="receiver" />
            </div>
            <!-- <div class="col"></div> -->
          </td>
          <td></td>
        </tr>
        <!-- 배송지명 tr -->
        <tr>
          <th scope="row">
            <label class="form-label" for="alias">배송지명</label>
          </th>
          <td>
            <div class="col-4">
              <input
                class="form-control log-form"
                type="text"
                name="alias"
                id="alias"
              />
            </div>
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
              <!-- 우편번호 입력 -->
              <div class="col">
                <input class="form-control" type="text" name="address" />
              </div>
              <!-- 버튼 -->
              <div class="col">
                <button class="addressBtn btn-sm" type="submit">
                  주소검색
                </button>
              </div>
            </div>
            <!-- 주소 자동 입력란 -->
            <div class="row mb-1">
              <div class="col">
                <input
                  class="form-control"
                  type="text"
                  name="address"
                  id="address"
                  disabled
                />
              </div>
            </div>
            <!-- 상세주소 -->
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
          </td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />

    <!-- 배송 요청사항 -->
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
            <label class="insert-receiver" for="receiver">배송 요청사항</label>
          </th>
          <td>
            <!-- 배송 메세지 선택 옵션 -->
            <div class="row mb-3">
              <div class="col-12">
                <select class="form-select" aria-label="Default select example">
                  <option selected>배송메세지를 선택해주세요</option>
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

    <!-- 배송 상품 -->
    <div>
      <h2>배송 상품</h2>
    </div>
    <!-- 기본 정보 테이블 시작-->
    <table class="table">
      <thead>
        <tr>
          <!-- 제목 : 상품정보, 판매가, 수량, 구매가 -->
          <th scope="col">상품정보</th>
          <th scope="col">판매가</th>
          <th scope="col">수량</th>
          <th scope="col">구매가</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <!-- 1. 배송 상품 -->
          <th scope="row">
            <label class="insert-receiver" for="receiver">배송상품</label>
          </th>
          <!-- 2. 판매가 -->
          <td>판매가</td>
          <!-- 3. 수량 -->
          <td>수량</td>
          <!-- 4. 구매가 -->
          <td>구매가</td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />

    <div style="display: flex">
      <!-- 결제 수단 -->
      <div class="col-sm-8">
        <div>
          <h2>결제 수단</h2>
        </div>

        <div>
          <hr />
        </div>
        <!-- 결제 수단 시작-->
        <div>
          <table class="table">
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
      <!-- 최종 결제 정보 -->
      <div class="col-sm-4" style="text-align: right; align-item: center;">
        <h2>최종 결제 정보</h2>
        <div class="final">
          <hr>
          <hr>
          <hr>
          <hr >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.orderbox {
  /* background-color: antiquewhite; */
  height: 5vw;
  border: 1px solid #342a26;
  color: #342a26;
}
.addressBtn {
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

</style>