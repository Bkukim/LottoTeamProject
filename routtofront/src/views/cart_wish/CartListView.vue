<!-- CartList.vue -->
<template>
  <div class="container mt-5 mb-5">
    <h5 class="text-center mt-5">장바구니</h5>
    <!-- 상품리스트 테이블 -->

    <table class="table mt-5 text-center">
      <thead>
        <tr>
          <!-- 전체선택 체크박스 -->
          <th class="text-center">
            <input
              type="checkbox"
              v-model="selectAll"
              @change="selectAllItems"
            />
          </th>
          <th class="text-center">상품</th>
          <th class="text-center">상품명</th>
          <th class="text-center">수량</th>
          <th class="text-center">가격</th>
          <th class="text-center">선택</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr v-for="(data, index) in cart" :key="index" class="mb-3">
          <!-- 체크박스 -->
          <td class="check_td text-center"><input type="checkbox" /></td>
          <!-- 상품이미지 -->
          <td class="text-center">
            {{ data.prodImg }}
          </td>
          <!-- 상품명 -->
          <td class="text-center">
            {{ data.prodName }}
          </td>
          <!-- 위아래로 수량조절 -->
          <td class="text-center col-2">
            <div
              class="btn-group col"
              role="group"
              aria-label="Basic outlined example"
            >
              <!-- 장바구니 개수 감소 버튼  -->
              <button
                type="button"
                class="btn btn-outline-secondary opacity-100"
                @click="decreaseCount"
              >
                -
              </button>
              <!-- 장바구니 개수 표시 : 버튼제목 -->
              <button type="button" class="btn btn-outline-dark" disabled>
                {{ cartCount }}
              </button>
              <!-- 장바구니 개수 증가 버튼 -->
              <button
                type="button"
                class="btn btn-outline-secondary opacity-100"
                @click="increaseCount"
              >
                +
              </button>
            </div>
          </td>
          <!-- 총가격 -->
          <td class="text-center">{{ calculateTotalPrice }}</td>
          <!-- 구매하기 ::버튼 -->
          <td class="text-center">
            <div class="row mb-1">
              <div class="col">
                <button
                  id="button_bg1"
                  class="btn btn-primary btn-block"
                  @click="goOrder"
                >
                  구매하기
                </button>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <button
                  id="button_bg2"
                  class="btn btn-secondary btn-block"
                  @click="deleteCart"
                >
                  삭제하기
                </button>
              </div>
            </div>
          </td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 페이징 -->
    <div class="row justify-content-center">
      <div class="col-auto">
        <b-pagination
          class="mb-3"
          v-model="page"
          :total-rows="count"
          :per-page="pageSize"
          @click="retrieveCart"
        ></b-pagination>
      </div>
    </div>

    <!-- 총액 테이블 -->
    <table class="table col-auto mt-5">
      <thead>
        <tr>
          <th class="text-center">금액</th>
          <th class="text-center">-</th>
          <th class="text-center">할인금액</th>
          <th class="text-center">+</th>
          <th class="text-center">배송비</th>
          <th class="text-center">총금액</th>
        </tr>
      </thead>
      <tbody>
        <!-- 합산해야할 tr -->
        <tr>
          <td class="text-center">{{ calculateTotalPrice.defaultPrice }}</td>
          <td class="text-center small_td"></td>
          <td class="text-center">{{ calculateTotalPrice.discountPrice }}</td>
          <td class="text-center small_td"></td>
          <td class="text-center">0원</td>
          <td class="text-center">{{ calculateTotalPrice + 0 }}</td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 아래 버튼 3개 -->
    <div class="row justify-content-end mt-5">
      <div class="col">
        <button
          type="button"
          id="button2"
          class="btn btn-primary"
          @click="deleteCart"
        >
          선택상품 삭제하기
        </button>
      </div>
      <div class="col-auto mb-5">
        <button
          type="button"
          id="button2"
          class="btn btn-secondary"
          @click="goOrder"
        >
          선택상품 주문하기
        </button>
        <button
          type="button"
          id="button1"
          class="btn btn-secondary"
          @click="goOrder"
        >
          전체상품 주문하기
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import CartService from "@/services/cart/CartService";
export default {
  // TODO: 데이터
  data() {
    return {
      cart: [],
      cartCount: 0, //장바구니 갯수

      // 공통 페이징 속성 정의
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 3, // 화면에 보여질 개수

      // 가격 계산함수
      defaultPrice: 0, //원가격
      discountRate: 0, //할인률

      // 전체선택 함수
      selectAll: false,
    };
  },
  // TODO: 함수
  methods: {
    // 전체선택함수
    selectAllItems() {
      // 전체 선택 체크박스가 선택되면 모든 상품의 selected 값을 true로 설정
      // 선택 해제되면 false로 설정
      // 반복문의 data랑 같다고 생각하기
      this.cart.forEach((data) => {
        data.selected = this.selectAll;
      });
    },

    // TODO: 장바구니 개수 증가 함수
    increaseCount() {
      this.cartCount += 1;
    },
    // TODO: 장바구니 개수 감소 함수
    decreaseCount() {
      if (this.cartCount > 0) {
        this.cartCount -= 1;
      }
    },
    // 계산함수
    calculateTotalPrice() {
      // 데이터베이스에서 정보를 가져와서 가격 계산
      // 아래는 예시 코드
      // axios.get('/api/product/price')
      //     .then(response => {
      //         const productPrice = response.data;
      //         const totalPrice = this.cartCount * (productPrice - (productPrice * this.discountRate));
      //         return totalPrice;
      //     })
      //     .catch(error => {
      //         console.error('Error fetching product price: ', error);
      //     });

      // 임시로 하드코딩한 예시 코드
      let discountPrice = this.defaultPrice * this.discountRate;
      const totalPrice = this.cartCount * (this.defaultPrice - discountPrice);
      return totalPrice;
    },
    // TODO: 전체조회(장바구니) 함수 : 검색어 버튼, 화면이뜰때 자동 실행
    async retrieveCart() {
      try {
        // todo: 공통 장바구니 전체 조회 서비스 함수 실행
        //   todo: 비동기 코딩 : async~await
        let response = await CartService.getAll(
          this.searchTitle,
          this.page - 1,
          this.pageSize
        );
        const { cart, totalItems } = response.data;
        this.cart = cart;
        this.count = totalItems;
        // 로깅
        console.log(response); //웹브라우저 콘솔탭에 백엔드 데이터 표시
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 장바구니 삭제 함수 : delete 버튼 태그
    async deleteCart(cartId) {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await CartService.remove(prodId);
        // 로깅
        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");
        // 삭제후 재조회
        this.retrieveCart();
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 주문페이지 이동 함수
    goOrder() {
      this.$router.push("/order");
    },
    // TODO: 공통 페이징 함수 : select 태그
    pageSizeChange() {
      this.page = 1; // 현재페이지번호 : 1
      this.retrieveCart(); // 재조회
    },
  },
  //   TODO: 화면이 뜰때 자동 실행 함수
  mounted() {
    // TODO: 화면이 뜰때 전체조회 실행
    this.retrieveCart();
  },
};
</script>
<style>
@import "@/assets/css/Cart.css";
@import "@/assets/css/Button.css";
</style>
@/services/cart/CartService
