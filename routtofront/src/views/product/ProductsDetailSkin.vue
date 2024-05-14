<template>
  <!-- 전체 중앙정렬 -->
  <div class="main_all container text-left">
    <div class="mb-3">
      <h3 class="mt-1">{{ category }}</h3>
      <hr />
      <br />
      <br />
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

      category: "",

      // 공통 페이징 속성
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 5, // 화면에 보여질 개수
    };
  },

  methods: {
    chooseCategory(category) {
      if (category == 1) {
        this.category = "SKIN";
      } else if (category == 2) {
        this.category = "HAIR";
      } else if (category == 3) {
        this.category = "MAKE UP";
      } else if (category == 4) {
        this.category = "BODY";
      } else if (category == 0) {
        this.category = "BEST";
      }
    },

    async getAllBanner() {
      try {
        let response = await AdminAdBannerService;
        console.log("배너 ::: ", response.data);
      } catch (error) {
        console.log(error);
      }
    },
    // TODO: 전체조회 함수    : 검색어 버튼 태그
    async retrieveProductByCategory(category) {
      try {
        let prodCategory = "";
        if (category == 1) {
          prodCategory = "스킨케어";
        } else if (category == 2) {
          prodCategory = "헤어";
        } else if (category == 3) {
          prodCategory = "메이크업";
        } else if (category == 4) {
          prodCategory = "바디";
        } else if (category == 0) {
          let response = await ProductService.getBestProduct();
          console.log(response.data);
          this.product = response.data.product;
          this.count = response.data.totalItems; // spring 전달 객체배열
          return;
        }

        let response = await ProductService.getProductByCategory(
          prodCategory,
          this.page - 1,
          this.pageSize
        );
        console.log(response.data);
        this.product = response.data.product; // spring 전달 객체배열
        this.count = response.data.totalItems; // spring 전달 객체배열
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
    this.chooseCategory(this.$route.params.prodCategory);
    this.getAllBanner();
    this.retrieveProductByCategory(this.$route.params.prodCategory);
    window.scrollTo(0, 0);
  },
  watch: {
    $route(to, form) {
      if (to.path !== form.path) {
        this.retrieveProductByCategory(this.$route.params.prodCategory);
        this.chooseCategory(this.$route.params.prodCategory);
      }
    },
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
