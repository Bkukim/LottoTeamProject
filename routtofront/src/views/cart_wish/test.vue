// 장바구니 // 기능 : 전체선택, 선택삭제, 전제삭제, 주문하기
<template>
  <div class="container">
    <!-- 장바구니 타이틀 -->
    <h1 style="margin-top: 80px; margin-bottom: 20px">장바구니</h1>
    <div>
      <!-- 장바구니 리스트 -->
      <table class="table text-center">
        <!-- 장바구니 리스트명 -->
        <thead class="table-light">
          <tr>
            <th scope="col-1">
              <!-- 전체선택 체크박스 -->
              <input
                class="form-check-input"
                type="checkbox"
                @click="checkedAll"
              />
            </th>
            <th scope="col">상품</th>
            <th scope="col">옵션</th>
            <th scope="col">수량</th>
            <th scope="col">가격</th>
          </tr>
        </thead>
        <tbody class="table-group-divider align-middle">
          <tr v-for="(data, index) in cart" :key="index">
            <td class="col-1">
              <input
                class="form-check-input"
                type="checkbox"
                :value="data"
                v-model="orderList"
                @change="selectProduct"
              />
            </td>
            <td class="col-4">
              <div class="d-flex align-items-center text-start">
                <div class="flex-shrink-0">
                  <img
                    type="button"
                    :src="data.pdThumblail"
                    class="img-thumbnail me-3"
                    style="width: 100px; height: 100px"
                    @click="goProduct(data.pdId)"
                  />
                </div>
                <div
                  type="button"
                  class="flex-grow-1 ms-3"
                  @click="goProduct(data.pdId)"
                >
                  {{ data.pdName }}
                </div>
              </div>
            </td>
            <td class="col-1">{{ data.opName }}</td>

            <td class="col-2">
              <div>
                <!-- 장바구니 수량 -->
                <div class="btn-group" role="group" aria-label="Basic example">
                  <button
                    type="button"
                    class="btn btn-outline-secondary"
                    @click="decreaseCount(data)"
                  >
                    -
                  </button>
                  <!-- 장바구니 개수 표시 : 버튼 제목 -->
                  <button
                    type="button"
                    class="btn btn-outline-dark"
                    style="width: 60px"
                    disabled
                  >
                    {{ data.cartCount }}
                  </button>
                  <button
                    type="button"
                    class="btn btn-outline-secondary"
                    @click="increaseCount(data)"
                  >
                    +
                  </button>
                </div>
              </div>
              <button
                type="button"
                class="btn btn-outline-dark mt-2"
                style="
                  --bs-btn-padding-y: 0.25rem;
                  --bs-btn-padding-x: 0.5rem;
                  --bs-btn-font-size: 0.75rem;
                "
                @click="selectedCount(data)"
              >
                수량변경
              </button>
            </td>
            <td class="col-2">
              {{ data.pdPrice + data.opPrice }}
            </td>
          </tr>
        </tbody>
      </table>
      <!-- 삭제버튼 -->
      <button
        type="button"
        class="btn btn-dark mb-3"
        style="
          --bs-btn-padding-y: 0.25rem;
          --bs-btn-padding-x: 0.5rem;
          --bs-btn-font-size: 0.75rem;
        "
        name="check"
        @click="deleteCart(cart.cartId)"
      >
        선택삭제
      </button>
      <div class="card-group justify-content-center">
        <div class="card text-center mb-3" style="max-width: 18rem">
          <div class="card-header">총 가격</div>
          <div class="card-body">
            <h3 class="card-title">{{ totalPrice }} 원</h3>
          </div>
        </div>
        <div class="card text-center mb-3" style="max-width: 18rem">
          <div class="card-header">배송비</div>
          <div class="card-body">
            <h3 class="card-title">{{ shipPrice }} 원</h3>
          </div>
        </div>
        <div class="card text-center mb-3" style="max-width: 18rem">
          <div class="card-header">결제 예상금액</div>
          <div class="card-body">
            <h3 class="card-title">{{ totalPrice + shipPrice }} 원</h3>
          </div>
        </div>
      </div>

      <div class="d-grid gap-2 d-md-block text-center">
        <button
          class="btn btn-outline-dark btn-lg me-md-2 col-2"
          type="button"
          @click="sendOrderList"
        >
          선택주문
        </button>
        <button
          class="btn btn-outline-dark btn-lg col-2"
          type="button"
          @click="goOrder"
        >
          전체주문
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import CartService from "@/services/shop/CartService";

export default {
  data() {
    return {
      cart: [], // 장바구니 객체배열
      
      userId: this.$store.state.userId, // 회원아이디 받아오기
      shipPrice: 3000, // 배송비
      totalPrice: 0, // 총 가격

      orderList: [], // 선택된 체크박스 배열 저장
    };
  },
  methods: {
    // 장바구니 전체조회
    async allCart(userId) {
      try {
        let response = await CartService.getAll(userId);
        this.cart = response.data;
        console.log(response.data); // 웹브라우저 콘솔탬에 백앤드 데이터 표시
        this.getTotalPrice(); // 총 가격
      } catch (e) {
        console.log(e);
      }
    },
    // 해당 상품페이지 이동
    goProduct(pdId) {
      this.$router.push(`/product/${pdId}`);
    },

    // 체크 가격
    selectProduct() {
      this.getTotalPrice(); // 개수 감소 가격
    },
    // TODO: 장바구니 개수 증가 함수
    increaseCount(data) {
      data.cartCount += 1;
      this.getTotalPrice(); // 개수 감소 가격
    },
    // TODO: 장바구니 개수 감소 함수
    decreaseCount(data) {
      if (data.cartCount > 1) {
        data.cartCount -= 1;
        this.getTotalPrice(); // 개수 감소 가격
      }
    },
    // 장바구니 수량 변경
    async selectedCount(data) {
      // data는 클릭한 객체를 나타냄
      console.log("정보 :", data);
      try {
        let response = await CartService.updated(data, data.cartId); // cartId 수량 변경
        console.log("수정 : ", response);
      } catch (e) {
        console.log(e);
      }
    },

    // 장바구니 삭제 함수 : delete 버튼 태그
    async deleteCart() {
      try {
        // 선택된 체크박스만 삭제
        const check = this.cart
          .filter((product) => product.selected) // 필터가 선택된 체크박스만 찾아 배열로 만들어줌
          .map((product) => product.cartId); // 필터된 cartId만 배열로 추출
        if (check === 0) {
          return;
        }
        // 장바구니 삭제 서비스 함수
        let response = await CartService.remove(check);
        console.log(response.data);
        // 삭제 후 재조회
        this.allCart();
      } catch (e) {
        console.log(e);
      }
    },

    // 장바구니 총 가격
    getTotalPrice() {
      if (this.orderList.length > 0) {
        this.totalPrice = this.orderList
          .map((data) => (data.pdPrice + data.opPrice) * data.cartCount)
          .reduce((acc, cur) => acc + cur);
        // 총 가격이 60000 이상이면 배송비 무료
        this.shipPrice = this.totalPrice >= 60000 ? 0 : 3000;
      }
    },
    // 체크박스 전체선택
    checkedAll() {
      if (this.orderList.length === this.cart.length) {
        this.orderList = [];
      } else {
        this.orderList = [...this.cart]; // 카트에 있는 배열을 모두 orderList로 넣기
      }
    },

    // 선택주문
    sendOrderList() {
      try {
        // 선택된 상품이 있는지 확인
        if (this.orderList.length > 0) {
          console.log(this.orderList);
          this.$store.commit("setOrderList", this.orderList);
          this.$router.push("/order");
        } else {
          alert("상품을 선택해주세요.");
        }
      } catch (e) {
        console.log(e);
        this.orderList = [];
      }
    },

    // TODO: 전체주문
    goOrder() {
      try {
        this.$store.commit("setOrderList", this.cart);
        console.log("카트배열", this.cart);
        this.$router.push("/order");
      } catch (e) {
        console.log(e);
        this.orderList = [];
      }
    },
  },
  mounted() {
    this.allCart(this.$store.state.user.userId);
  },
};
</script>

<style></style>
