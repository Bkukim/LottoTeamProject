<template>
  <div class="main_all">
    <!-- 전체 중앙정렬 -->
    <div class="frame-22">
      <!-- 메인배너 -->
      <img class="baner_divbox" :src="banner[0]?.bannerImg1Url" />
      <!-- src="@/assets/images/main_banner.jpg -->

      <!-- product -->
      <div class="product">
        <!--  product 메뉴 버튼-->
        <div class="menu_bt">
          <router-link to="/product/example" class="frame-18">ALL</router-link>
          <router-link to="/" class="frame-19">BEST</router-link>
          <router-link to="/" class="frame-20">SKIN</router-link>
          <router-link to="/" class="frame-21">BODY</router-link>
        </div>
      </div>

      <!-- best product2 상품 -->

      <!-- product2_all 전체박스 -->
      <div class="product2_all product-kim">
        <!-- product 왼쪽 문구 -->
        <div class="product2">product</div>

        <div class="product2_in image-kim" v-for="(data, index) in product" :key="index">
          <!-- 홀수 번째인 경우에만 odd 클래스를 추가 -->
          <div class="div10" :class="{ odd: index % 2 !== 0 }">
            <!-- 상품이미지 -->
            <img class="frame-11" :src="data.prodImgUrl" />

            <div class="abcdefghijklm">
              <p>{{ data.prodName }}</p>
            </div>

            <div class="abcdefghijklm2">
              <p>완벽밀착! 자연스럽고 매끄러운 피부</p>
            </div>

            <div class="_24">★ ★ ★ ★ ★</div>

            <div class="abcdef">
              {{
                (data.defaultPrice * (100 - data.discountRate)) / 100 + " won"
              }}
            </div>
          </div>
        </div>
      </div>

      <!-- best-sellers -->
      <div class="best-menu">
        <img class="_1" src="../../src/assets/images/best_visual_02_pc.jpg" />
        <div class="best-menu_in">
          <img
            class="div8"
            src="../../src/assets/images/best_visual_01_pc.jpg"
          />
          <img class="div9" src="../../src/assets/images/best_seller_04.png" />
          <div class="best-menu2">BEST SELLERS</div>
          <div class="abcdefgefgefdfdfsfdadffddfsd">
            가장 사랑 받고 있는 루또의 베스트 제품
          </div>
          <div class="abcdefgefghijk4">
            <p>내추럴 커버 파운데이션</p>
          </div>
          <div class="abcdefg">shop></div>
          <div class="abcdefgefghijk5">퍼펙트 옴므 쿠션</div>
          <div class="abcdefg2">shop></div>
        </div>
      </div>
      
        <img class="_2" :src="banner[1]?.bannerImg2Url" />
      
      <img class="_3" src="../../src/assets/images/ROUTTO_logo_wh.png" />

      <div class="best-menu-2">
        <div class="_22">
          <img class="div2" :src="banner[1]?.bannerImg1Url" /><!-- 배너 2-1 -->
          <div class="abcdefgefghijk">{{banner[1]?.bannerTitle}}</div>
          <div class="div3">
            {{ banner[1]?.bannerContent }}
          </div>
          <div class="shop-more"><router-link :to="'/product/'+banner[1]?.prodId" >SHOP MORE  &gt;</router-link> </div>
        </div>
        <div class="_22">
          <img
            class="div4"
            :src="banner[2]?.bannerImg1Url"
          /><!-- 배너 3 -->
          <div class="abcdefgefghijk2">{{banner[2]?.bannerTitle}}</div>
          <div class="div5">
            {{ banner[2]?.bannerContent }}
          </div>
          <div class="shop-more2"><router-link :to="'/product/'+banner[2]?.prodId" >SHOP MORE  &gt;</router-link></div>
        </div>
        <div class="_22">
          <img
            class="div6"
            :src="banner[3]?.bannerImg1Url"
          /><!-- 배너 4 -->
          <div class="abcdefgefghijk3">{{banner[3]?.bannerTitle}}</div>
          <div class="div7">
            {{ banner[3]?.bannerContent }}
          </div>
          <div class="shop-more3"><router-link :to="'/product/'+banner[3]?.prodId" >SHOP MORE  &gt;</router-link></div>
        </div>
      </div>

      <!-- 전체 중앙정렬 -->
    </div>
  </div>
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
        console.log("배너 ::: " , response.data);
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
@import "@/assets/css/main.css";
.product-kim{
  display: flex;
  }
  /* .image-kim{ */
  /* margin-right: 10px; 이미지 간격 조절 */
/* } */

.image-kim {
  display: flex;
  flex-wrap: wrap; /* 요소가 화면 크기를 넘어갈 때 줄 바꿈 */
}

.image-container {
  flex: 0 0 25%; /* 4개의 이미지를 한 줄에 표시하도록 설정 */
  margin-right: 10px; /* 이미지 간격 조절 */
}

.image-container img {
  width: 100%; /* 이미지가 부모 요소에 맞게 표시되도록 설정 */
}

.odd {
  background-color: lightgray; /* 홀수 번째 요소에 배경색 적용 (테스트용) */
}

.div10 {
  flex: 0 0 50%; /* 한 줄에 4개의 이미지를 표시하기 위한 설정 */
  margin-right: 10px; /* 이미지 사이의 간격 설정 */
}

.frame-11 {
  width: 100%; /* 이미지의 너비 100%로 설정하여 부모 요소에 맞추어 표시 */
  height: auto; /* 이미지의 높이를 자동으로 조정하여 비율 유지 */
}

.product2_in {
  display: flex;
  flex-wrap: wrap; /* Flexbox에서 요소가 넘칠 때 줄바꿈 설정 */
}
</style>
