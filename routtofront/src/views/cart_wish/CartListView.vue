<!-- CartList.vue -->
<template>
  <div class="container mt-5 mb-5">
    <h5 class="text-center main_text">장바구니</h5>
    <!-- 상품리스트 테이블 -->

    <table class="table mt-5 text-center row-auto">
      <thead>
        <tr>
          <th class="text-center col-1">번호</th>
          <th class="text-center col-1">상품</th>

          <th class="text-center">상품명</th>
          <th class="text-center">수량</th>
          <th class="text-center">가격</th>
          <th class="text-center">선택</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr v-for="(data, index) in cart" :key="index" class="mb-3">
          <!-- 상품ID -->
          <td class="text-center">
            {{ index + 1 }}
          </td>

          <!-- 상품IMG -->
          <td class="text-center">
            <img :src="data.prodImgUrl" class="cartImg" />
          </td>

          <!-- 상품명 -->
          <td class="text-left">
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
                @click="decreaseCount(index)"
              >
                -
              </button>
              <!-- 장바구니 개수 표시 : 버튼제목 -->
              <button type="button" class="btn btn-outline-dark">
                {{ data.cartProdCount }}
              </button>
              <!-- 장바구니 개수 증가 버튼 -->
              <button
                type="button"
                class="btn btn-outline-secondary opacity-100"
                @click="increaseCount(index)"
              >
                +
              </button>
            </div>
          </td>
          <!-- 총가격 -->
          <td class="text-center">
            <i style="text-decoration: line-through">{{ data.defaultPrice }}</i>
            <br />
            {{ formatCurrency( data.defaultPrice - data.defaultPrice * (data.discountRate * 0.01))
             
            }}
          </td>
          <!-- 구매하기 ::버튼 -->
          <td class="text-center">
            <div class="row mb-1">
              <div class="col">
                <button
                  id="button_bg1"
                  class="btn btn-primary btn-block"
                  @click="
                    updateProdCount(
                      data.cartProdCount,
                      data.userId,
                      data.prodId
                    )
                  "
                >
                  수량확정
                </button>
              </div>
            </div>
            <div class="row mb-1">
              <div class="col">
                <button
                  id="button_bg1"
                  class="btn btn-primary btn-block"
                  @click="goOrderProd"
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
                  @click="deleteCart(data.cartId)"
                >
                  삭제하기
                </button>
              </div>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
    <!-- 페이징 삭제 -->
    <!-- <div class="row justify-content-center">
      <div class="col-auto">
        <b-pagination
          class="mb-3"
          v-model="page"
          :total-rows="count"
          :per-page="pageSize"
          @click="retrieveCart"
        ></b-pagination>
      </div>
    </div> -->

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
        <tr v-if="cart">
          <!-- 총 금액 -->
          <td class="text-center">{{ getCartTotal().totalPrice }}</td>
          <!-- "-" 표시 -->
          <td class="text-center small_td">-</td>
          <!-- 할인 금액 -->
          <td class="text-center">{{ getCartTotal().discountedPrice }}</td>
          <!-- "+" 표시 -->
          <td class="text-center small_td">+</td>
          <!-- 배송비 -->
          <td class="text-center">{{ getCartTotal().deliveryFee }}</td>
          <!-- 최종 총 금액 -->
          <td class="text-center">
            {{formatCurrency(
              getCartTotal().totalPrice -
              getCartTotal().discountedPrice +
              getCartTotal().deliveryFee)
            }}
          </td>
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
          @click="deleteAllCart(cart)"
        >
          전체상품 삭제하기
          
        </button>
      </div>
      <div class="col-auto mb-5">
        <!-- <button
          type="button"
          id="button2"
          class="btn btn-secondary"
          @click="goOrder"
        >
          선택상품 주문하기
          시간관걔상 뺌
        </button> -->
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
      cart: [], //장바구니에 담긴 프로덕트 들

      // 공통 페이징 속성 정의
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 100, // 화면에 보여질 개수

      total: 0,
    };
  },
  // TODO: 함수
  methods: {
    // TODO: 장바구니 개수 증가 함수
    increaseCount(index) {
      this.cart[index].cartProdCount += 1;
      // this.updateProdCount(this.cart[index].cartProdCount,this.cart[index].userId,this.cart[index].prodId);
    },
    // TODO: 장바구니 개수 감소 함수
    decreaseCount(index) {
      if (this.cart[index].cartProdCount > 0) {
        this.cart[index].cartProdCount -= 1;
        // this.updateProdCount(this.cart[index].cartProdCount,this.cart[index].userId,this.cart[index].prodId);
        // 수량을 감소시킨 후에는 수정 함수 호출
      }

      // TODO:챗지피티 사용
      // 배열 내에서 prodId와 일치하는 상품의 인덱스를 찾기
      // const productIndex = this.cart.findIndex(
      //   (item) => item.prodId === this.cart.prodId
      // );

      // // 해당 상품이 존재하는 경우
      // if (productIndex !== -1) {
      //   // 상품의 수량을 감소시킴
      //   if (this.cart[productIndex].cartProdCount > 0) {
      //     this.cart[productIndex].cartProdCount -= 1;

      //     // 수량을 감소시킨 후에는 수정 함수 호출
      //     this.updateProdCount(productIndex);
      //   }
      // } else {
      //   // 해당 상품이 장바구니에 없는 경우 처리할 내용 추가
      //   console.log("수량오류났음~")
      // }
    },
    // TODO: NEW 계산하기 함수
    getCartTotal() {
      let totalPrice = 0;
      let discountedPrice = 0;
      let deliveryFee = 0;

      for (let item of this.cart) {
        totalPrice += item.defaultPrice * item.cartProdCount;
        discountedPrice +=
          item.defaultPrice * (item.discountRate * 0.01) * item.cartProdCount;
      }

      this.total = totalPrice - discountedPrice; // 최종 가격 계산
      deliveryFee = this.getDeliveryFee(this.total); // 배송비 계산
      return {
        totalPrice: totalPrice,
        discountedPrice: discountedPrice,
        deliveryFee: deliveryFee,
      };
    },
    // 회계형식
    formatCurrency(price) {
      return new Intl.NumberFormat('ko-KR', {
        style: 'currency',
        currency: 'KRW',
        currencyDisplay: 'narrowSymbol' 
      }).format(price);
    }
  
    // 배송비 - 안쓰는데 나중에 필요할까봐 그냥 같이 3천원으로 놔둠
   , getDeliveryFee(totalPrice) {
      if (totalPrice >= 50000) {
        return 3000; // 5만원 이상 주문일 때 배송비 0
      } else {
        return 3000; // 5만원 미만 주문일 때 배송비 3000원
      }
    },
    // TODO: 전체조회(장바구니) 함수 : 검색어 버튼, 화면이뜰때 자동 실행
    async retrieveCart() {
      console.log("실행이 됐는지확인");

      try {
        // todo: 공통 장바구니 전체 조회 서비스 함수 실행
        //   todo: 비동기 코딩 : async~await
        console.log(this.page);
        console.log(this.$store.state.user.userId);
        console.log(this.pageSize);
        let response = await CartService.getAll(
          this.$store.state.user.userId,
          this.page - 1,
          this.pageSize
        );
        const { cart, totalItems } = response.data;
        this.cart = cart;
        this.count = totalItems;
        // alert(this.cart[1].cartProdCount);
        console.log("asdfasdfasdf", cart[0]);
        // 로깅
        console.log("카트조회", response.data); //웹브라우저 콘솔탭에 백엔드 데이터 표시
      } catch (e) {
        console.log(e);
      }
    },

    // TODO: 장바구니 삭제 함수 : delete 버튼 태그
    async deleteCart(cartId) {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await CartService.remove(cartId);
        // 로깅
        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");

        // this.cartProdCount = this.cartProdCount - 1; // 단일 삭제니까 -1

        // 삭제후 재조회
        this.retrieveCart();
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 장바구니 전체 삭제 함수 : delete 버튼 태그 ::전체상품
    async deleteAllCart(cart) {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await CartService.removeAll(cart);
        // 로깅
        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");

        // this.cartProdCount = 0; //카트카운트 초기화 해주기

        // 삭제후 재조회
        this.retrieveCart();
      } catch (e) {
        console.log(e);
      }
    },

    //count수정요청함수
    async updateProdCount(cartProdCount, userId, prodId) {
      try {
        // TODO: 공통 수정함수 : DeptService.update()
        // TODO: 비동기 코딩 : async ~ await

        let response = await CartService.updateProdCount(
          cartProdCount,
          userId,
          prodId
        );
        console.log(response.data);

        // 로깅
        console.log(response.data);
        // 화면에 성공메세지 출력 : message
        this.message = "수정이 성공했습니다.";
      } catch (e) {
        console.log(e);
      }
    },

    // TODO: 전체 수정 함수 ::배열사용실패
    // async updateProdCountAll() {
    //   try {
    //     let response;
    //     for (let item of this.cart) {
    //       response = await CartService.updateProdCountAll(item);
    //       console.log(response.data);
    //     }
    //     // 로깅
    //     console.log(response.data);
    //     // 화면에 성공메세지 출력 : message
    //     this.message = "수정이 성공했습니다.";
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },

    goOrder() {
      this.$router.push("/order");
    },
    goOrderProd() {
      // '/shop/notice-check/' + data.announcementId
      this.$router.push('/order'+this.cart.prodId);
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
