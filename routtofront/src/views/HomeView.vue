<template>
  <div class="main_all">
    <!-- 전체 중앙정렬 -->
    <div class="frame-22">
      <!-- 메인배너 -->
      <img class="baner_divbox" src="@/assets/images/main_banner.jpg" />
      <!-- src="@/assets/images/main_banner.jpg -->

      <!-- product -->
      <div class="product">
        <!--  product 메뉴 버튼-->
        <div class="menu_bt">
          <div class="frame-18">
            <div class="all">ALL</div>
          </div>
          <div class="frame-19">
            <div class="skin">BEST</div>
          </div>
          <div class="frame-20">
            <div class="body">SKIN</div>
          </div>
          <div class="frame-21">
            <div class="make-up">BODY</div>
          </div>
        </div>
      </div>

      <!-- best product2 상품 -->

      <!-- product2_all 전체박스 -->
      <div class="product2_all">
        <!-- product 왼쪽 문구 -->
        <div class="product2">product</div>
        <div class="product2_in" v-for="(data, index) in product"
        :key="index">
          <div class="div10" >
            <div class="_23"></div>
            <div class="_24">★ ★ ★ ★ ★</div>
            <div class="abcdefghijklm">
              <p>{{data.prodName}}</p>
            </div>
            <div class="abcdefghijklm2">
              <p>완벽밀착! 자연스럽고 매끄러운 피부</p>
            </div>
            <div class="abcdef">{{data.defaultPrice*(100-data.discountRate)/100 + " won"}}</div>
            <!-- 상품이미지 -->
            <img
              class="frame-11"
              :src="data.prodImgUrl"
            />
            <!-- <div class="frame-11"></div> -->
          </div>
          <!-- <div class="div10">
            <div class="_25"></div>
            <div class="_26">★ ★ ★ ★ ★</div>
            <div class="abcdefghijklm3">루또 체인지 립밤 2종</div>
            <div class="abcdefghijklm4">보습과 생기 컬러 립밤</div>
            <div class="abcdef2">11,900 won</div> -->
            <!-- 상품이미지 -->
            <!-- <img
              class="frame-112"
              src="../../src/assets/images/02_main_image410_pc.jpg"
            /> -->
            <!-- <div class="frame-112"></div> -->
          <!-- </div>
          <div class="div10">
            <div class="_27"></div>
            <div class="_28">★ ★ ★ ★ ★</div>
            <div class="abcdefghijklm5">페이스 라인 스틱</div>
            <div class="abcdefghijklm6">얼굴을 또렷하고 슬림하게</div>
            <div class="abcdef3">15,900 won</div> -->
            <!-- 상품이미지 -->
            <!-- <img
              class="frame-113"
              src="../../src/assets/images/02_main_image1_pc_v2.png"
            /> -->
            <!-- <div class="frame-113"></div> -->
          <!-- </div>
          <div class="div10">
            <div class="_29"></div>
            <div class="_210">★ ★ ★ ★ ★</div>
            <div class="abcdefghijklm7">멜로우 클레이 포마드</div>
            <div class="abcdefghijklm8">자연스러운 헤어 포마드</div>
            <div class="abcdef4">16,900 won</div> -->
            <!-- 상품이미지 -->
            <!-- <img
              class="frame-114"
              src="../../src/assets/images/02_main_image411_pc.jpg"
            /> -->
            <!-- <div class="frame-114"></div> -->
          <!-- </div> -->
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
          <div class="abcdefg">shop</div>
          <div class="abcdefgefghijk5">퍼펙트 옴므 쿠션</div>
          <div class="abcdefg2">shop</div>
        </div>
      </div>

      <img class="_2" src="../../src/assets/images/main_s3_slide_dex_pc.jpg" />
      <img class="_3" src="../../src/assets/images/ROUTTO_logo_wh.png" />

      <div class="best-menu-2">
        <div class="_22">
          <img class="div2" src="../../src/assets/images/prd_image_01_v2.png" />
          <div class="abcdefgefghijk">Texture Curl Cream</div>
          <div class="div3">
            쉽고 빠른 스타일링, 모발 케어 성분은 물론 향기까지 완벽한 프리미엄
            퍼퓸 컬크림
          </div>
          <div class="shop-more">SHOP MORE &gt;</div>
        </div>
        <div class="_22">
          <img class="div4" src="../../src/assets/images/prd_image_02.png" />
          <div class="abcdefgefghijk2">All In One! Essence</div>
          <div class="div5">
            진정 / 보습장벽 / 모공 / 피지케어까지 한번에 남성 피부 맞춤 올인원
            솔루션
          </div>
          <div class="shop-more2">SHOP MORE &gt;</div>
        </div>
        <div class="_22">
          <img class="div6" src="../../src/assets/images/prd_image_03.png" />
          <div class="abcdefgefghijk3">Style! Setting Fixer</div>
          <div class="div7">
            자연스러운 헤어 고정, 탈모완화기능성은 물론 향기까지 완벽한 프리미엄
            퍼퓸 픽서
          </div>
          <div class="shop-more3">SHOP MORE &gt;</div>
        </div>
      </div>

      <!-- 전체 중앙정렬 -->
    </div>
  </div>
</template>
<script>
import ProductService from '@/services/product/ProductService';

export default {
  data() {
    return {
      product: [],
      searchTitle: "", // 검색어

      // 공통 페이징 속성
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 3, // 화면에 보여질 개수

      pageSizes: [3, 6, 9], // 화면에 보여질 개수배열
    };
  },
  methods: {
    // TODO: 전체조회 함수    : 검색어 버튼 태그
    async retrieveSimpleProduct() {
      try {
        // TODO: 공통 전체조회 서비스 함수 실행
        // TODO: spring 통신 : 비동기 코딩 : async ~ await
        let response = await ProductService.getAll(
                                                    );
        this.product = response.data; // spring 전달 객체배열
           // 전체페이지개수
        // 로깅(디버깅)
        console.log(response.data);         // 웹브라우저 콘솔탭에 spring 전달 객체배열이 표시됨
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
    this.retrieveSimpleProduct();
  },
};
</script>
<style>
@import "@/assets/css/main.css";
</style>
