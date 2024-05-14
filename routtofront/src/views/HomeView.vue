<template>
  <!-- 전체 중앙정렬 -->
  <div class="main_all container text-center">
    <!-- 메인배너 (중앙정렬) -->
    <div class="main_banner container text-center">
      <router-link :to="'/product/' + banner[0]?.prodId"
        ><img class="baner_divbox" :src="banner[0]?.bannerImg1Url"
      /></router-link>
    </div>
    <!-- 메인배너 (중앙정렬) -->

    <!-- 메인페이지 상품바로가기 버튼 -->
    <div class="main_best_button container text-right mt-5">
      <div class="row main_best_button_in">
        <div class="col">
          <h3 class="main_best_button_h3 container text-left">product</h3>
        </div>

        <div class="col main_best_button_in">
          <button type="button" class="btn btn-outline-secondary">ALL</button>
        </div>

        <div class="col main_best_button_in">
          <button type="button" class="btn btn-outline-secondary">BEST</button>
        </div>

        <div class="col main_best_button_in">
          <button type="button" class="btn btn-outline-secondary">SKIN</button>
        </div>

        <div class="col main_best_button_in">
          <button type="button" class="btn btn-outline-secondary">BODY</button>
        </div>
      </div>
    </div>
    <!-- 메인페이지 상품바로가기 버튼 끝 -->

    <!-- 메인페이지 상품바로가기 반복문 -->
    <div class="product-wrapper container text-center">
      <div
        class="product2_in image-kim"
        v-for="(data, index) in product"
        :key="index"
      >
        <!-- 홀수 번째인 경우에만 odd 클래스를 추가 -->
        <!-- 상품이미지 -->
        <router-link :to="'/product/' + data.prodId"
          ><img
            class="frame-11"
            :src="data.prodImgUrl"
            style="max-width: 400px; max-height: 400px"
        /></router-link>

        <div class="abcdefghijklm">
          <p>{{ data.prodName }}</p>
        </div>

        <div class="abcdefghijklm2">
          <p>완벽밀착! 자연스럽고 매끄러운 피부</p>
        </div>

        <div class="_24">★ ★ ★ ★ ★</div>

        <div class="abcdef">
          {{ (data.defaultPrice * (100 - data.discountRate)) / 100 + " won" }}
        </div>
        <!-- </div> -->
      </div>
    </div>
    <!-- 메인페이지 상품바로가기 반복문 끝-->
  </div>

  <!-- 두번째 메인 베스트 상품 -->

  <div class="main_best_button container text-center mt-5">
    <div class="row main_best_button_in">
      <div class="col">
        <div class="abcdefgefghijk">{{ banner[1]?.bannerTitle }}</div>
        <img class="div2" :src="banner[1]?.bannerImg1Url" /><!-- 배너 2-1 -->
        <div class="div3">
          {{ banner[1]?.bannerContent }}
        </div>
        <div class="shop-more"><router-link :to="'/product/'+banner[1]?.prodId" >SHOP MORE  &gt;</router-link> </div>
      </div>

      <div class="col"></div>
    </div>
  </div>

  <!-- 전체 중앙정렬 끝 -->
</template>
<script>
import AdminAdBannerService from "@/services/admin/AdminAdBannerService";
import ProductService from "@/services/product/ProductService";

export default {
  data() {
    return {
      // prodImgUrl:["http://localhost:8000/api/normal/shop/product/img/3e89a3876b87444a88965fb0a2f2ba8f", "http://localhost:8000/api/normal/shop/product/img/5b456b748e944e63bdb4591b20c2403b"],
      banner: [],
      product: [],
      searchTitle: "", // 검색어

      // currentSlideIndex: 0,
      // slides: document.querySelectorAll('.slide') ,// 슬라이드 요소들을 선택합니다.

      // 공통 페이징 속성
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 3, // 화면에 보여질 개수

      pageSizes: [3, 6, 9], // 화면에 보여질 개수배열
    };
  },

  methods: {
    async getAllBanner() {
      try {
        let response = await AdminAdBannerService.findAllBannerHome();
        this.banner = response.data;
        console.log("배너 ::: ", response.data);
      } catch (error) {
        console.log(error);
      }
    },
    // TODO: 전체조회 함수    : 검색어 버튼 태그
    async retrieveSimpleProduct() {
      try {
        // TODO: 공통 전체조회 서비스 함수 실행
        // TODO: spring 통신 : 비동기 코딩 : async ~ await
        let response = await ProductService.getAll();
        this.product = response.data; // spring 전달 객체배열
        // 전체페이지개수
        // 로깅(디버깅)
        // console.log(response.data); // 웹브라우저 콘솔탭에 spring 전달 객체배열이 표시됨
      } catch (e) {
        console.log(e); // 웹브라우저 콘솔탭에 에러메세지가 표시됨
      }
    },
    // TODO: 공통 페이징 함수 : select 태그
    pageSizeChange() {
      this.page = 1; // 현재페이지번호 : 1
      this.retrieveSimpleProduct(); // 재조회
    },
  },
  //   TODO: 화면이 뜰때 자동 실행 함수
  mounted() {
    // TODO: 전체 조회 자동 실행
    this.getAllBanner();
    this.retrieveSimpleProduct();
    window.scrollTo(0, 0);
  },
};
</script>
<style>
/* 메인 배너 */
.baner_divbox {
  width: 100%;
  height: 40vw;
}

.main_best_button_h3 {
  color: #999999;
  text-align: left;
  font-family: "NotoSans-DisplayBold", sans-serif;
  font-size: 3vw;
  font-weight: 400;
  margin-left: -100px;
}

/* best 상품 버튼 */
.main_best_button_in {
  margin-left: 3vw;
  margin-bottom: 3.4722vw;
  margin-top: 6vw;
}

.main_best_button_in > button {
  background: #d1ccbd;
  border-radius: 20px;
  padding: 8px 50px 8px 50px;
  display: flex;
  flex-direction: row;
  gap: -50px;
  align-items: center;
  justify-content: center;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  overflow: hidden;

  color: #ffffff;
  font-family: "Inter-Bold", sans-serif;
  font-size: 20px;
  font-weight: 500;
  border: none;
}

.main_best_button_in > button:hover {
  background-color: rgb(56, 37, 13);
  color: rgb(255, 255, 255);
}

/* best 상품 반복문 가로 정렬 */
.product-wrapper {
  display: flex;
  gap: 30px;
}
</style>
