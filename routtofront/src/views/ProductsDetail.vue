<template>
  <div class="container mt-5">
    <h1 class="mt-4">Product</h1>
    <hr />

    <br />
    <br />
    <br />

    <div class="row">
      <!-- 왼쪽 -->
      <div class="col-sm-6">
        <img :src="product.prodImgUrl" alt="prodImgUrl" />

        <!-- 1. 리뷰 평점 -->
        <div class="box mt-5 text-center">
          <h2>리뷰 평점 : {{ product.point }}</h2>
          <h2 id="star">
            ★★★★★
            <!-- 별점 표시를 위한 반복문 -->
            <!-- <template v-for="★ in product.point"> ★ </template> -->
          </h2>
        </div>
        <!-- 2. 리뷰 -->
        <div class="box mt-5 text-center">
          <h2>리뷰 : {{ product.reviewContent }}</h2>
        </div>
      </div>

      <div class="col-sm-1"></div>
      <!-- 오른쪽 -->
      <div class="col-sm-5">
        <!-- 1. 상품 이름 -->
        <div id="name" class="text-center">
          <h2>{{ product.prodName }}</h2>
        </div>

        <!-- 2. 상품 설명 -->
        <!-- <h4 class="mt-3">
          상품 설명 : 피부에 완벽 밀착되는 내추럴 에어핏 피팅으로 자연스럽고
          매끄러운 피부 연출이 가능한 스틱 파운데이션
        </h4> -->

        <!-- 3. 상품 원가 -->
        <div class="mt-4"></div>

        <!-- 4. 상품 최종가 -->
        <div id="price">
          <h4>
            원가 :
            {{ product.defaultPrice }} 원
          </h4>
        </div>
        <br />
        <hr />

        <!-- 위아래로 수량조절 -->
        <td class="col-2">
          <b>수량을 선택하세요</b>
          <br>
          <br>
          <!-- 1) 드롭다운 이름 -->
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
              {{ productCount }}
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
        <hr />
        <br />

        <!-- 6. 총 상품 금액 -->
        <div id="total">
          <h4>
            총 상품 금액 :
            {{
              (product.defaultPrice -
              (product.defaultPrice * product.discountRate) / 100) * productCount
            }} 원
          </h4>
          <div class="mt-3">
            <h5>배송비 : 3000 원</h5>
          </div>
          <hr />
          <div class="mb-3">
            <h5>
              총 주문 금액 :
              {{
                (product.defaultPrice -
                (product.defaultPrice * product.discountRate) / 100) * productCount  +
                3000
              }} 원
            </h5>
          </div>
        </div>

        <!-- 7. 버튼 -->
        <div class="mt-5">
          <button type="button" id="btn2" @click="goCart">장바구니</button>

          <button type="button" id="btn3" @click="goOrder">주문하기</button>

          <button type="button" id="btn4" @click="goOrder">상품문의</button>
        </div>
      </div>
    </div>

    <!-- 상세 페이지 -->
    <div class="mt-5">
      <div id="page">
        <img :src="product.prodDetailPageUrl" />
      </div>
    </div>
    <!-- 상세 페이지 끝 -->
  </div>
</template>

<script>
import ProductService from "@/services/product/ProductService";
import CartService from "@/services/product/CartService";

export default {
  data() {
    return {
      productCount: 1, // 상품 수량
      // image: require("@/assets/images/skincare.jpg"),
      product: {
        // prodId: this.$route.params.prodId,
        // prodName: "",
        // defaultPrice: "",
        // prodCategory: "",
        // prodImg: "",
        // prodImg2: "",
        // prodDetailPage: "",
        // discountRate: "",
        // prodStock: "",
        // saleEnd: "",
        // saleStart: "",
        // prodStatus: "",
        // soldCount:""
        point: 5,
        reviewContent: "만족스럽습니다.",
      },
      message: "", // 장바구니 추가 성공메세지(화면에 출력)
      // cartCount: 0, // 장바구니 개수
    };
  },
  methods: {
        // TODO: 상품 개수 증가 함수
    increaseCount() {
      this.productCount += 1;
    },
    // TODO: 상품 개수 감소 함수
    decreaseCount() {
      if (this.productCount > 1) {
        this.productCount -= 1;
      }
    },

    // TODO: 상품 상세조회 : 상품ID(prodId)
    // 비동기 코딩
    async getProd(prodId) {
      try {
        let response = await ProductService.get(prodId);
        this.product = response.data; // spring 전송 객체 넣기
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 장바구니 담기(저장)
    async saveCart() {
      // 임시 객체
      try {
        let data = {
          prodId: this.product.prodId, // 상품번호
          // cartCount: this.cartCount, // 장바구니 개수
        };
        // TODO: 공통 저장 서비스 함수 실행, async ~ await
        let response = await CartService.create(data);
        // 로깅
        console.log(response.data);
        // 장바구니 담기 성공 메세지 출력
        this.message = "장바구니에 잘 담겼습니다.";
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 장바구니 전체 조회페이지 이동함수
    goCart() {
      this.$router.push("/cart");
      this.$store.state.orderAmount = this.productCount;
    },
    // TODO: 주문하기 이동함수
    goOrder() {
      this.$router.push("/order/" + this.$route.params.prodId);
      this.$store.state.orderAmount = this.productCount;
      // this.$router.push("/order");
    },
  },
  mounted() {
    this.getProd(this.$route.params.prodId); // 상세조회 함수 실행
  },
};
</script>

<style>
.box {
  background-color: white;
  max-width: 100%;
  height: 5vw;
  border: 1px solid #e2e2e2;
  /* padding: 1vw; */
}

#name {
  background-color: white;
  height: 5vw;
  border: 1px solid #e2e2e2;
}

#page {
  background-color: white;
  border: 1px solid #e2e2e2;
  color: black;
  height: 40vw;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

#price {
  background-color: white;
  width: 16vw;
  height: vw;
  border: 1px solid #e2e2e2;
  padding: 0.5vx;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

/* .dropdown {
  position: relative;
} */

#selectOption {
  /* position: absolute; */
  /* display: none; */
  min-width: 100%; /* 드롭다운 메뉴의 최소 너비를 100%로 설정 */
  /* z-index: 1000; */
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

#total {
  background-color: white;
  height: auto;
  border: 1px solid #e2e2e2;
  padding: 0.5vw;
  z-index: 0;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

#btn1 {
  width: 100%;
  height: 3vw;
  background-color: white;
  border-color: #e2e2e2;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

#btn2 {
  width: 9vw;
  height: 4vw;
  margin-right: 1.5vw;
  background-color: white;
  border: 1px solid #e2e2e2;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

#btn3 {
  width: 9vw;
  height: 4vw;
  margin-right: 1.5vw;
  background-color: #342a26;
  color: white;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

#btn4 {
  width: 9vw;
  height: 4vw;
  border: #fff16c;
  background-color: #fff16c;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
  border: 2px solid #fff16c; /* 빨간색 테두리, 두께는 2px */
}
#star {
  color: red;
}
</style>
