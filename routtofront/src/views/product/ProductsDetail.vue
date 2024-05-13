<template>
  <!-- Bootstrap CSS 파일 포함 -->
  <link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    rel="stylesheet"
  />

  <div class="container mt-5">
    <h1 class="mt-4">Product</h1>
    <hr />

    <br />
    <br />
    <br />

    <div class="row">
      <!-- 왼쪽 -->
      <div class="col-sm-6">
        <img
          :src="product.prodImgUrl"
          alt="prodImgUrl"
          style="max-width: 700px; max-height: 1200px"
        />
      </div>

      <div class="col-sm-1"></div>
      <!-- 오른쪽 -->
      <div class="col-sm-5">
        <!-- 1. 상품 이름 -->
        <div id="name" class="text-left">
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
            <span id="price_1">판매가격 </span>
            {{ Math.ceil(product.defaultPrice).toLocaleString()
            }}<span> 원</span>
          </h4>
        </div>
        <hr />

        <!-- 위아래로 수량조절 -->
        <td class="col-2 text-center">
          <h5 id="quantity_jy1">{{ product.prodName }}</h5>
          <b class="quantity_jy2">수량을 선택하세요.</b>
          <br />
          <br />
          <!-- <br /> -->
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

          <br />
          <br />
        </td>
        <hr />
        <br />

        <!-- 6. 총 상품 금액 -->
        <div id="total">
          <h4>
            <span class="won_1">총 상품 금액 </span>
            <span class="won_2 text-right">
              {{
                Math.ceil(
                  (product.defaultPrice -
                    (product.defaultPrice * product.discountRate) / 100) *
                    productCount
                ).toLocaleString()
              }}원
            </span>
          </h4>

          <hr />

          <div>
            <div>
              <h5 class="shipping">배송비 : 3,000 원</h5>
            </div>
            <h4>
              <br />
              <br />
              <span class="won_1_2">총 주문 금액 </span>
              <span class="won_2">
                {{
                  Math.ceil(
                    (product.defaultPrice -
                      (product.defaultPrice * product.discountRate) / 100) *
                      productCount +
                      3000
                  ).toLocaleString()
                }}원
              </span>
            </h4>
            <hr />
          </div>
        </div>

        <!-- ------------------------------- 찜뽕 -->
        <!-- ------------------------------- 장바구니-->
        <!-- ------------------------------- 주문하기-->
        <!-- ------------------------------- 상품문의-->
        <!-- ------------------------------- 버    튼-->
        <div class="container text-center">
          <div class="shop_button row container text-center">
            <!-- 즐겨찾기 하트 버튼 -->
            <button type="button" id="btn1" @click="addToFavorites"></button>
          </div>

          <div class="shop_button row container text-center">
            <button type="button" id="btn2" @click="saveCart">장바구니</button>
          </div>

          <div class="shop_button row container text-center">
            <button type="button" id="btn3" @click="goOrder">주문하기</button>
          </div>

          <div class="shop_button row container text-center">
            <button type="button" id="btn4" @click="goCheck">Q&A</button>
          </div>
        </div>
        <!-- ------------------------------- 버 튼 끝-->
      </div>
    </div>

    <!-- 상세 페이지 -->
    <div class="mt-5">
      <div class="mysave container text-center">
        <div class="row">
          <div
            id="mysave"
            class="col"
            @click="scrollToSection('detail')"
            button
            type="button"
          >
            상품상세
          </div>

          <div
            id="mysave"
            class="col no-border1"
            @click="scrollToReviewSection"
            button
            type="button"
          >
            상품후기
          </div>
          <div
            id="mysave"
            class="col no-border1"
            @click="scrollToInquirySection"
            button
            type="button"
          >
            상품문의
          </div>
        </div>
      </div>

      <div id="page" style="height: auto;">
        <div>
        <!-- <img
          :src="product.prodDetailPageUrl"
          style="max-width: 400px; max-height: 600px"
        /> -->
        <img
          :src="product.prodDetailPageUrl"
        />
        </div>
       
      </div>

      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <!-- 2. 리뷰 -->
      <div class="mt-5" ref="reviewSection">
        <h3>상품 후기</h3>
        <br>
        <br>
        <!-- 5. 테이블 시작-->
        <!-- <table class="table table-bordered" style="border: 1px solid #342a26"> -->
        <table class="table " :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
          <!-- 테이블 제목 행 -->
          <thead>
            <tr class="text-center">
              <th scope="col">아이디</th>
              <th scope="col">별점</th>
              <th scope="col">내용</th>
              <th scope="col">사진</th>
            </tr>
          </thead>
          <tbody>
            <!-- 1행 -->
            <tr
              class="text-center"
              v-for="(data, index) in reviews"
              :key="index"
            >
              <!-- 아이디 -->
              <td>
                <div>
                  <p>{{ data.userId }}</p>
                </div>
              </td>
              <!-- 별점 -->
              <td>
                <div>
                  <p>{{ data.point }}</p>
                </div>
              </td>
              <!-- 내용-->
              <td>
                <div>
                  <p>{{ data.reviewContent }}</p>
                </div>
              </td>
              <!-- 리뷰 사진 -->
              <td>
                <img
                  :src="data.reviewImgUrl"
                  style="width: 150px; height: 100px"
                />
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 페이징 -->
      <!-- {/* paging 시작 */} -->
      <div class="row justify-content-center mt-4">
        <div class="col-auto">
          <b-pagination
            class="col-12 mb-3"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveReview"
          ></b-pagination>
        </div>
      </div>

      <!-- 리뷰 작성 버튼 -->
      <button
        type="button"
        class="btn"
        data-bs-toggle="modal"
        data-bs-target="#exampleModal"
        data-bs-whatever="@mdo"
        id="reviewWrite"
        style="float: right"
      >
        리뷰 작성
      </button>
      <!-- 리뷰 작성 모달 -->
      <div
        class="modal fade"
        id="exampleModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 작성</h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="mb-3">
                  <label for="message-text" class="col-form-label">내용</label>
                  <textarea
                    class="form-control"
                    id="message-text"
                    v-model="review.reviewContent"
                  ></textarea>
                </div>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label"
                    >별점</label
                  >
                  <input
                    type="number"
                    min="1"
                    max="5"
                    class="form-control"
                    id="recipient-name"
                    v-model="review.point"
                  />
                </div>
                <div class="mb-3">
                  <label for="message-text" class="col-form-label">사진</label>
                  <div class="file-upload-form mb-3">
                    <!-- TODO: file01 추가 -->
                    <input
                      type="file"
                      @change="previewReviewImage"
                      accept="image/*"
                      ref="file01"
                      style="color: black"
                    />
                  </div>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                닫기
              </button>
              <button
                type="button"
                class="btn"
                id="addReview-btn"
                @click="saveReview"
              >
                저장
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 상세 페이지 끝 -->
  </div>

  <!-- 상품문의 내려가는 부분 -->
  <div class="container" ref="inquirySection">
    <div class="mt-5">
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <h3>상품문의</h3>
      <!-- <router-link
        class="top_notice router-link-exact-active fs-5"
        to="/shop/notice"
        >공지사항</router-link
      >
      |
      <router-link class="top_notice2 text-decoration-none" to="/shop/faqList"
        >FAQ</router-link
      > -->
    </div>
    <div class="mt-5 text-center">
      <!-- 서치 -->
      <div class="row justify-content-end">
        <form class="d-flex mt-3 col-5" role="search">
          <input
            class="form-control me-2"
            type="search"
            placeholder="검색"
            aria-label="Search"
          />
          <button class="btn btn-outline-success" type="submit">검색</button>
        </form>
      </div>

      <!-- 테이블 시작 -->
      <table class="table mt-5">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
          </tr>
        </thead>
        <tbody>
          <!-- 반복문 시작할 행 -->

          <tr
            v-for="(data, index) in notice"
            :key="index"
            @click="goNoticeCheck"
          >
            <th scope="col">
              <router-link
                :to="'/shop/notice-check/' + data.announcementId"
                class="router-link-exact-active cencle"
              >
                {{ data.announcementId }}</router-link
              >
            </th>

            <th scope="col">
              <router-link
                :to="'/shop/notice-check/' + data.announcementId"
                class="router-link-exact-active cencle"
              >
                {{ data.title }}
              </router-link>
            </th>
            <th scope="col">ADMIN</th>
          </tr>
        </tbody>
      </table>

      <!-- 페이징 -->
      <!-- {/* paging 시작 */} -->
      <div class="row justify-content-center mt-4">
        <div class="col-auto">
          <b-pagination
            class="col-12 mb-3"
            v-model="page"
            :total-rows="count"
            :per-page="pageSize"
            @click="retrieveNotice"
          ></b-pagination>
        </div>
      </div>

      <!-- 관리자 등록 버튼 :: 공지사항 글등록으로 이동-->
      <div class="row justify-content-end">
        <button type="button" id="button1" class="mt-5 btn">
          <router-link to="/shop/admin-notice" class="router-link-exact-active"
            >공지사항 등록</router-link
          >
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import ProductService from "@/services/product/ProductService";
import CartService from "@/services/product/CartService";
import ReviewService from "@/services/product/ReviewService";

export default {
  data() {
    return {
      // 리뷰 테이블에 불러오는 배열
      reviews: [], // reviewImgUrl도 들어있지 않나

      // 리뷰 작성 저장하는 객체
      review: {
        point: 1, // 별점
        reviewContent: "", // 리뷰 내용
        reviewImage: undefined, // 리뷰 사진 등록, 파일은 "" 초기화하면 안됨(문자열이므로)
      },

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
        // point: 5,
        // reviewContent: "만족스럽습니다.",
      },
      message: "", // 장바구니 추가 성공메세지(화면에 출력)
      // cartCount: 0, // 장바구니 개수

      // 공통 속성(현재페이지, 전체데이터개수,1페이지당개수)
      page: 1, // 현재페이지번호
      count: 0, // 전체데이터개수
      pageSize: 3, // 1페이지당개수(select태그)
    };
  },
  methods: {
    // 리뷰 전체조회 함수 : 화면이뜰때 자동 실행
    async retrieveReview() {
      try {
        // 공통 장바구니 전체 조회 서비스 함수 실행
        let response = await ReviewService.getAll(this.page - 1, this.pageSize);
        console.log(response.data);
        const { reviews, totalItems } = response.data;
        this.reviews = reviews; // 리뷰 배열(벡엔드 전송)
        this.count = totalItems; // 전체페이지수(벡엔드 전송)
        // 로깅
        // console.log("결과출력", response.data); // 웹브라우저 콘솔탭에 벡엔드 데이터 표시
      } catch (e) {
        console.log(e); // 웹브라우저 콘솔탭에 에러 표시
      }
    },

    // 상품문의 글 작성 페이지로 넘어가는 함수
    goCheck() {
      this.$router.push("/products/check");
    },
    // 리뷰 작성 저장
    async saveReview() {
      try {
        // 임시 객체
        let data = {
          //   reviewId;       // 리뷰 ID
          //   userId;          // 회원 ID
          //   prodId;         // 상품 ID
          //   point;          // 별점
          //   reviewContent;   // 리뷰 내용
          //   reviewImage;     // 리뷰 사진
          //   reviewImgUrl;      // 리뷰 이미지 url
          //   reviewImgUuid;     // 리뷰 이미지 uuid
          userId: this.$store.state.user?.userId,
          prodId: this.$route.params.prodId,
          point: this.review.point,
          reviewContent: this.review.reviewContent,
          reviewImage: this.review.reviewImage,
          reviewImgUrl: this.review.reviewImgUrl,
        };
        // TODO: 공통 저장 서비스 함수 실행
        // TODO: async ~ await
        let response = await ReviewService.createReview(data);
        console.log(response.data);
        alert("리뷰가 성공적으로 등록되었습니다.");
      } catch (e) {
        console.log(e);
      }
    },

    // 리뷰 이미지 추가
    previewReviewImage: function () {
      this.review.reviewImage = this.$refs.file01.files[0]; // 첨부파일은 여러개 선택할수있어서 배열로 되어있다 우리는 처음선택한게 0번
    },

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
          cartProdCount: this.productCount, // 장바구니 개수
          userId: this.$store.state.user.userId, // userId
        };
        // console.log("확인", data);
        // TODO: 공통 저장 서비스 함수 실행, async ~ await
        let response = await CartService.create(data);
        if (response.data == true) {
          // alert(response.data)
          alert("장바구니에 이미 상품이 존재합니다.");
          this.$router.push("/order/cart");
          return; // 장바구니에 상품 추가하지 않고 함수 종료
        } else {
          // 로깅
          console.log(response.data);
          // 장바구니 담기 성공 메세지 출력
          alert("장바구니에 상품이 담겼습니다.");
          this.$router.push("/order/cart");
        }
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 주문하기 이동함수
    goOrder() {
      this.$router.push("/order/" + this.$route.params.prodId);
      this.$store.state.orderAmount = this.productCount;
    },

    // 스크롤 함수
    scrollToReviewSection() {
      // 리뷰 섹션의 ID를 사용하여 해당 섹션의 위치를 계산
      const reviewSection = this.$refs.reviewSection;
      if (reviewSection) {
        // smooth한 스크롤 효과로 해당 섹션으로 이동
        reviewSection.scrollIntoView({ behavior: "smooth", block: "start" });
      }
    },

    scrollToInquirySection() {
      // 상품문의 섹션의 ID를 사용하여 해당 섹션의 위치를 계산
      const inquirySection = this.$refs.inquirySection;
      if (inquirySection) {
        // smooth한 스크롤 효과로 해당 섹션으로 이동
        inquirySection.scrollIntoView({ behavior: "smooth", block: "start" });
      }
    },
  },
  mounted() {
    // 화면 뜰때 상단이 뜨게 해주는 함수
    window.scrollTo(0, 0);
    this.getProd(this.$route.params.prodId); // 상세조회 함수 실행

    this.retrieveReview();

  },
};
</script>

<style>
/* @font-face {
  font-family: "Pretendard-Regular";
  src: url("https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff")
    format("woff");
  font-weight: 400;
  font-style: normal;
} */

#mysave {
  border: 1px solid #cccccc;
  height: 70px;
  padding: 25px;
  margin-top: 60px;
  letter-spacing: -1.5px;
  font-size: 13px;
}

#mysave:hover {
  /* background-color: #342a26; */
  /* color: #ffffff; */
  border-top: 10px solid #342a26;
  /* border-left: none;
  border-right: none;
  border-bottom: none; */
}

hr {
  opacity: 0.2;
}

h1 {
  font-family: "Lora", serif;
  font-optical-sizing: auto;
  font-style: normal;
  font-weight: bold;
  font-size: 30px;
}

.box {
  background-color: white;
  max-width: 100%;
  height: 50vw;
  border: 1px solid #e2e2e2;
  /* padding: 1vw; */
}

#name {
  background-color: white;
  height: 5vw;
  font-weight: 200;
  letter-spacing: -1.8px;
  /* border: 1px solid #e2e2e2; */
}

#page {
  background-color: white;
  border: 1px solid #e2e2e2;
  color: black;
  height: 100vw;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
  text-align: center;
}

#price {
  width: 16vw;
  padding: 0.5vx;
  /* border-radius: 5px;  */
  /* border: 1px solid #e2e2e2; */
  /* background-color: white; */
}

#price_1 {
  color: #999999;
  font-size: 16px;
  letter-spacing: -1.8px;
  margin-right: 40px;
}

h4 {
  font-size: 20px;
  font-weight: 500;
}

/* 두번째 상품명(수량선택 위) */
#quantity_jy1 {
  font-size: 15px;
  font-weight: lighter;
  margin: 20px 0 0 0;
  color: #999999;
}

.quantity_jy {
  font-size: 15px;
  font-weight: bold;
  margin: 20px 0 20px 0;
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

/* 총 상품금액/ 총 주문 금액 */
#total {
  background-color: white;
  height: auto;
  /* border: 1px solid #e2e2e2; */
  padding: 0.5vw;
  z-index: 0;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

.shipping {
  font-size: 15px;
  letter-spacing: -1px;
  margin-top: 53px;
  color: #727272;
  font-weight: 600;
}

.won_1 {
  font-size: 1vw;
  letter-spacing: -1.7px;
  margin: 0 300px 100px 0;
  font-weight: 500;
}

#btn2 :hover {
  width: 9vw;
  height: 4vw;
  margin-right: 1.5vw;
  background-color: rgb(240, 92, 92);
  border: 1px solid #e2e2e2;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}
.won_1_2 {
  font-size: 1vw;
  letter-spacing: -1.7px;
  margin: 0 300px 100px 0;
  font-weight: bold;
}

.won_2 {
  font-size: 23px;
  letter-spacing: -1.5px;
  font-weight: bold;
  color: #252525;
}

#star {
  color: red;
}

#addReview-btn {
  width: 3.8vw;
  height: 43px;
  background-color: #342a26;
  margin: 20px;
  color: white;
}

#reviewWrite {
  background-color: #342a26;
  color: white;
}
/* 장바구니 버튼 */
.shop_button {
  /* border: 1px solid #cccccc; */
  padding: auto;
}

.shop_button {
  margin-bottom: 15px;
  letter-spacing: -1.7px;
}

.shop_button > #btn1 {
  width: 100%;
  height: 3vw;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  font-size: 20px;
}

#btn1:hover {
  color: #ff0000;
  font-size: 35px;
  /* border: 1px solid #cccccc; */
}

/* #btn1:hover::after {
  content: "♥"; 
}
#btn1:hover::before {
  content: none 
} */

#btn1::before {
  content: attr(data-original-text); /* 원래 텍스트를 보여주는 가상 요소 */
}

#btn1:hover::before {
  content: none; /* 호버 시 원래 텍스트를 숨김 */
}

#btn1::after {
  content: "♡"; /* 기본 텍스트 설정 */
}

#btn1:hover::after {
  content: "♥"; /* 호버 시 새로운 텍스트로 변경 */
}
#btn2 :hover {
  width: 9vw;
  height: 4vw;
  margin-right: 1.5vw;
  background-color: rgb(240, 92, 92);
  border: 1px solid #e2e2e2;
  color: black;
  border-radius: 5px; /* 모서리 둥글게 : 5px로 설정 */
}

.shop_button > #btn2 {
  width: 100%;
  height: 3vw;
  background-color: #ffffff;
  border: 1px solid #cccccc;
  letter-spacing: -1px;
}

#btn2:hover {
  background-color: #5e0000d2;
  color: #ffffff;
  border: none;
}

.shop_button > #btn3 {
  width: 100%;
  height: 3vw;
  background-color: #342a26;
  border: none;
  color: #ffffff;
  letter-spacing: -1px;
}

#btn3:hover {
  background-color: #5e0000d2;
  color: #ffffff;
  border: none;
}

.shop_button > #btn4 {
  width: 100%;
  height: 3vw;
  background-color: #342a2635;
  border: none;
  letter-spacing: -1px;
  color: #ffffff;
}

#btn4:hover {
  background-color: #5e0000d2;
  color: #ffffff;
  border: none;
}

#addReview-btn {
  width: 3.8vw;
  height: 43px;
  background-color: #342a26;
  margin: 20px;
  color: white;
}

#reviewWrite {
  background-color: #342a26;
  color: white;
}
</style>
