<!-- CartList.vue -->
<template>
  <div class="container mt-5 mb-5">
    <h5 class="text-center mt-5">장바구니</h5>
    <!-- 상품리스트 테이블 -->

    <table class="table mt-5 text-center ">
      <thead>
        <tr>
          <th class="text-center">선택</th>
          <th class="text-center">상품</th>
          <th class="text-center">상품명</th>
          <th class="text-center">수량</th>
          <th class="text-center">가격</th>
          <th class="text-center"></th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr class="">
          <!-- 체크박스 -->
          <td class="check_td text-center"><input type="checkbox" /></td>
          <!-- 상품이미지 -->
          <td class="text-center">
            <img src="https://via.placeholder.com/100" />
          </td>
          <td class="text-center">10,000원</td>
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
          <td class="text-center">20,000원</td>
          <!-- 구매하기 -->
          <td class="text-center"></td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 총액 테이블 -->
    <table class="table col-13 mt-5">
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
        <!-- 반복문시작할 tr -->
        <tr>
          <td class="text-center">0원</td>
          <td class="text-center small_td"></td>
          <td class="text-center">0원</td>
          <td class="text-center small_td"></td>
          <td class="text-center">0원</td>
          <td class="text-center">0원</td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 아래 버튼 3개 -->
    <div class="row justify-content-end mt-5">
      <div class="col">
        <button type="button" id="button2" class="btn btn-primary">
          선택상품 삭제하기
        </button>
      </div>
      <div class="col-auto mb-5">
        <button type="button" id="button2" class="btn btn-secondary">
          선택상품 주문하기
        </button>
        <button type="button" id="button1" class="btn btn-secondary">
          전체상품 주문하기
        </button>
      </div>
    </div>

    
  </div>
</template>
<script>
export default {
  data() {
    return {
      cartCount: 0 //장바구니 갯수
    }
  },
  methods: {
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
  },
};
</script>
<style>
@import "@/assets/css/Cart.css";
@import "@/assets/css/Button.css";
</style>
