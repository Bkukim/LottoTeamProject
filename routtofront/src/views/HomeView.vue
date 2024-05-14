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
  <div class="col-auto">
      <h3 class="main_best_button_h3 container text-left">PRODUCT</h3>
    </div>
  <div class="row main_best_button_in align-items-center">
    <div class="col-auto">
    </div>

    <div class="col-auto">
      <button type="button" class="btn btn-outline-secondary">ALL</button>
    </div>

    <div class="col-auto">
      <button type="button" class="btn btn-outline-secondary">BEST</button>
    </div>

    <div class="col-auto">
      <button type="button" class="btn btn-outline-secondary">SKIN</button>
    </div>

    <div class="col-auto">
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

    <!-- 두번째 메인 베스트 (베스트 셀러)상품 -->
    <div class="main_best_sellers container text-center mt-5">
      <h3 class="main_h3 container text-right">BEST SELLERS</h3>
      <!-- <p class="main_p"> 가장 사랑 받고 있는 루또의 베스트 제품</p> -->

      <div class="row main_best_button_in1">
        <div class="col img-container-left">
          <img
            class="_2_big"
            :src="banner[1]?.bannerImg2Url"
            style="max-width: 25; max-height: 35vw"
          />
        </div>

        <div class="div2 col container text-right">
          <img
            class="div2_img"
            :src="banner[1]?.bannerImg1Url"
            style="max-width: 21vw; max-height: 21vw"
          /><!-- 배너 2-1 -->
          <div class="abcdefgefghijk">{{ banner[1]?.bannerTitle }}</div>
          <div class="div3">
            {{ banner[1]?.bannerContent }}
          </div>
          <div class="shop-more">
            <br />
            <br />
            <router-link :to="'/product/' + banner[1]?.prodId"
              >SHOP MORE &gt;</router-link
            >
          </div>
        </div>

        <div class="div2 col container text-right">
          <img
            class="div2_img"
            :src="banner[1]?.bannerImg1Url"
            style="max-width: 21vw; max-height: 21vw"
          /><!-- 배너 2-1 -->
          <div class="abcdefgefghijk">{{ banner[1]?.bannerTitle }}</div>
          <div class="div3">
            {{ banner[1]?.bannerContent }}
          </div>
          <div class="shop-more">
            <br />
            <br />
            <router-link :to="'/product/' + banner[1]?.prodId"
              >SHOP MORE &gt;</router-link
            >
          </div>
        </div>
      </div>
    </div>

<!-- 세번째 베스트 셀러 -->
<div class="main_best_sellers2 container">
  <div class="row">
    <!-- 왼쪽 작은 썸네일 세로 3개 -->
    <div class="col-lg-4">
      <div class="div4 container text-center">
        <img
          class="div4_img"
          :src="banner[1]?.bannerImg1Url"
          style="max-width: 400px; max-height: 300px"
        />
        <div class="abcdefgefghijk22">{{ banner[1]?.bannerTitle }}</div>
        <div class="div4_in">{{ banner[1]?.bannerContent }}</div>
        <div class="shop-more">
          <router-link :to="'/product/' + banner[1]?.prodId"
            >SHOP MORE &gt;</router-link
          >
        </div>
      </div>

      <div class="div4 container text-center">
        <img
          class="div4_img"
          :src="banner[1]?.bannerImg1Url"
          style="max-width: 400px; max-height: 300px"
        />
        <div class="abcdefgefghijk22">{{ banner[1]?.bannerTitle }}</div>
        <div class="div4_in">{{ banner[1]?.bannerContent }}</div>
        <div class="shop-more">
          <router-link :to="'/product/' + banner[1]?.prodId"
            >SHOP MORE &gt;</router-link
          >
        </div>
      </div>

      <div class="div4 container text-center">
        <img
          class="div4_img"
          :src="banner[1]?.bannerImg1Url"
          style="max-width: 400px; max-height: 300px"
        />
        <div class="abcdefgefghijk22">{{ banner[1]?.bannerTitle }}</div>
        <div class="div4_in">{{ banner[1]?.bannerContent }}</div>
        <div class="shop-more">
          <router-link :to="'/product/' + banner[1]?.prodId"
            >SHOP MORE &gt;</router-link
          >
        </div>
      </div>

 
    </div>

    <!-- 오른쪽 큰 배너 -->
    <div class="col-lg-8 text-right">
      <div class="img-container" id="sellers3_rt_bn">
        <img
          class="_3"
          :src="banner[1]?.bannerImg2Url"
          style="max-width: 400px; max-height: 700px"
        />
      </div>
    </div>

    <div class="col text-right" id="sellers3_rt_bn2">
      <img class="_3_main_logo" src="../../src/assets/images/ROUTTO_logo_wh.png" />
    </div>
  </div>
</div>
<!-- 세번째 베스트 셀러  끝-->


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
  /* color: #999999;
  text-align: left;
  font-family: "NotoSans-DisplayBold", sans-serif;
  font-size: 3vw;
  font-weight: 400;
  margin-left: -100px; */

  margin: 6.9444vw 0 0 -42.6389vw;
  color: #535353;
  text-align: left;
  font-family: "Inter-Bold", sans-serif;
  font-size: 50px;
  font-weight: 600;
}


/* best 상품 버튼 */

.main_best_button {
  text-align: right; 
  margin: 5vw 0 0 42vw; 

}

.main_best_button_in {
  display: flex;
  flex-wrap: wrap;
  gap: 20px; 
}

.main_best_button_in .col-auto {
  padding: 0; /* 부트스트랩 기본 패딩을 제거하여 간격을 줄임 */
}

.main_best_button_in > .col-auto > button {
  background: #d1ccbd;
  border-radius: 20px;
  padding: 8px 20px; 
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
  overflow: hidden;

  color: #ffffff;
  font-family: "Inter-Bold", sans-serif;
  font-size: 16px; 
  font-weight: 500;
  border: none;
}

.main_best_button_in > .col-auto > button:hover {
  background-color: rgb(56, 37, 13);
  color: rgb(255, 255, 255);
}



.main_best_button_in {
  margin-left: 3vw;
  margin-bottom: 3.4722vw;
  margin-top: 6vw;
  gap: -100px;
  
}

.main_best_button_in > button {
  background: #d1ccbd;
  border-radius: 20px;
  padding: 8px 50px 8px 50px;
  display: flex;
  flex-direction: row;
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




/* ---------------------------------- */
/* 두번째 베스트셀러 */
.div2_img {
  margin: 270px 0 0 0;
}

.img-container {
  width: 100%; 
  /* 부모 div의 넓이를 100%로 설정 */
  max-width: 1200px; 
}
/* ._2 {
  width: 500px;
  height: 800px;
  object-fit: cover;
} */

/* 세번째 베스트셀러 */
.main_h3 {
  margin: 200px 0 0 870px;
  color: #535353;
  text-align: left;
  font-family: "Inter-Bold", sans-serif;
  font-size: 55px;
  font-weight: 700;
  width: 424px;
  height: 79px;
}


/* 세번째 베스트셀러 */
.main_best_sellers2 {
  margin-top: 200px;
}

.div4 {
  margin-bottom: 20px;
}

.div4_img {
  display: block;
  margin: 0 auto;
}

.abcdefgefghijk22, .div4_in, .shop-more {
  text-align: center; 
}

.img-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.div4{
  margin-right: 800px;
}


#sellers3_rt_bn{
  margin: -300px 0 0 180px;
}

#sellers3_rt_bn2{
  margin:-400px 0 0 780px;
  opacity: 50%;
}


</style>