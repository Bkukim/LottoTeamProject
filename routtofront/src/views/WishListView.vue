<!-- CartList.vue -->
<template>
  <div class="container mt-5 mb-5">
    <h5 class="text-center mt-5">즐겨찾기</h5>
    <!-- 상품리스트 테이블 -->

    <table class="table col-13 mt-5">
      <thead>
        <tr class="align-middle">
          <th class="text-center">
            <input
              type="checkbox"
              v-model="selectAll"
              @change="selectAllItems"
            />
          </th>
          <th class="text-center">이미지</th>
          <th class="text-center">상품정보</th>
          <th class="text-center">금액</th>
          <th class="text-center">선택</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr class="align-middle">
          <!-- 체크박스 -->
          <td class="check_td text-center"><input type="checkbox" /></td>
          <!-- 상품이미지 -->
          <td class="text-center col-2">
            <img src="https://via.placeholder.com/100" />
          </td>
          <!-- 상품정보 -->
          <td class="text-center">헤어토닉</td>
          <!-- 금액 -->
          <td class="text-center">20,000원</td>
          <!-- 선택 :: 버튼 -->
          <td class="text-center">
            <div class="row mb-1">
              <div class="col">
                <button id="button_bg1" class="btn btn-primary btn-block">
                  장바구니
                </button>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <button id="button_bg2" class="btn btn-secondary btn-block">
                  삭제하기
                </button>
              </div>
            </div>
          </td>
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
          선택 장바구니담기
        </button>
        <button type="button" id="button1" class="btn btn-secondary">
          전체 장바구니담기
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import CartService from "@/service/cart-notice-ect-/CartService";

export default {
  // TODO: 바인딩 속성
  data() {
    return {
      favorite: null, //상품객체
      message: "", // 장바구니 완료 성공메세지
      cartCount: 0, //장바구니 개수
    };
  },
  // TODO: 함수정의
  methods: {
    // TODO: 장바구니 담기(저장)
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
    async saveCart() {
      try {
        let data = {
          spno: this.Product.spno, //상품번호
          cartCount: this.cartCount, //장바구니 개수
        };
        // todo: 공통 저장 서비스 함수
        // todo: async ~await
        let response = await CartService.create(data);
        // login
        console.log(response.data);
        // 성공메세지 출력
        this.message = "장바구니에 담겼습니다";
      } catch (e) {
        console.log(e);
      }
      // 임시객체
    },
  },
  // TODO: 화면이뜰때 자동 실행
  mounted() {
    this.retrieveCart();
  },
};
</script>
<style>
@import "@/assets/css/Cart.css";
@import "@/assets/css/Button.css";
</style>
