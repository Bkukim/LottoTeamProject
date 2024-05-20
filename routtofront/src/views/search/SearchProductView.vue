<template>
  <div class="container text-center">
    <div>
      <h3 class="search_title mt-5 container text-center">Routto Search</h3>

      <div class="container text-center">
        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
        <div class="container text-center">
          <div cclass="container text-center">
            <!-- <h5>SEARCH</h5> -->
            <P class="mt-5 mb-5 container text-center"
              >키워드를 입력하여 원하시는 상품을 찾아보세요.</P
            >
            <div class="search_input mt-5 mb-5 container text-center">
              <input
                type="text"
                class="form-control"
                id="prodName"
                placeholder="prodName"
                name="prodName"
                v-model="searchProduct"
              />

              <div @click="retrieveProduct">
                <img class="search" src="@/assets/images/search.png" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 메인페이지 상품바로가기 반복문 -->
    <div class="product-wrapper">
      <div class="product2_in" v-for="(data, index) in products" :key="index">
        <!-- 상품이미지 -->
        <router-link :to="'/product/' + data.prodId">
          <img
            class="frame-11"
            :src="data.prodImgUrl"
            style="max-width: 400px; max-height: 400px"
          />
        </router-link>
        <!-- 상품 명 -->
        <div class="product-name">
          <p>{{ data.prodName }}</p>
        </div>
        <!-- 상품 가격 -->
        <div class="product-price">
          {{ (data.defaultPrice * (100 - data.discountRate)) / 100 + " won" }}
        </div>
      </div>
    </div>
    <!-- 메인페이지 상품바로가기 반복문 끝-->
  </div>
</template>

<script>
import ProductService from "@/services/product/ProductService";
export default {
  data() {
    return {
      products: [],
      searchProduct: "",
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 12, // 화면에 보여질 개수
    };
  },
  methods: {
    async retrieveProduct() {
      try {
        let response = await ProductService.getSearchProductAll(
          this.searchProduct,
          this.page - 1,
          this.pageSize
        );
        console.log(response.data);
        this.products = response.data.products;
        this.count = response.data.totalItems;
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    this.retrieveProduct();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
.container {
  height: auto;
}
.search {
  cursor: pointer;
}
h3 {
  margin-bottom: 20px;
}
.search_input {
  width: 250px;
  margin: 0 auto;
  position: relative;
}
.search_input img {
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
  cursor: pointer;
}
.product-wrapper {
  display: flex;
  flex-wrap: wrap;
  gap: 50px;
  justify-content: center;
  margin-top: 80px;
}
.product2_in {
  flex: 0 1 calc(33.33% - 50px);
  box-sizing: border-box;
  margin-bottom: 30px;
}
.product-name,
.product-price {
  margin-top: 10px;
}

.product-name > p {
  color: #535353;
  font-family: "Inter-Light", sans-serif;
  font-size: 17px;
  font-weight: 700;
  letter-spacing: -1.5px;
}

.product-price {
  color: #535353;
  font-family: "Inter-Light", sans-serif;
  font-size: 17px;
  font-weight: 300;
  letter-spacing: -1.5px;
}
</style>
