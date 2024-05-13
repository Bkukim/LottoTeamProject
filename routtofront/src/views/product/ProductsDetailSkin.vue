<template>
  <!-- 전체 중앙정렬 -->
  <div class="main_all container text-left">
    <div class="mb-3">
      <h3 class="mt-1">SKIN</h3>
      <hr />
      <br>
      <br>
    </div>


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
/* best 상품 반복문 가로 정렬 */
.product-wrapper {
  display: flex;
  gap: 30px;
}
</style>
  