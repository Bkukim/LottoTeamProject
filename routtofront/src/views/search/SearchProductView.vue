<template>

  <div class="container text-center">
    <div>
      <h3 class="search_title mt-5">Routto Search</h3>

      <div class="container text-center">
        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
        <div class="row">
          <div class="col-md-4">
            <h5>SEARCH</h5>
            <P>키워드를 입력하여 원하시는 상품을 찾아보세요.</P>
            <div class="search_input">
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
 <!-- 메인페이지 상품바로가기 반복문 -->
    <div class="product-wrapper container text-center">
      <div
        class="product2_in image-kim"
        v-for="(data, index) in products"
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
          <div class="col-md-8">
            <div class="row" v-for="(data, index) in products" :key="index">
              <div class="col-md-4 mr-4">
                <div class="serch_box"><img :src="data.prodImgUrl"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  <script>
  import ProductService from '@/services/product/ProductService';
export default {
  data() {
    return {
      products:[],
      searchProduct:"",

      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 3, // 화면에 보여질 개수
    }
  },methods: {
    retrieveProduct(){
      try {
        let response = ProductService.getSearchProductAll(this.searchProduct,this.page-1,this.pageSize)
        console.log(response.data);
        this.products = response.data.products;
        this.count = response.data.totalItems;
      } catch (error) {
        console.log(error);
      }
    }
  },
  mounted() {
    this.retrieveProduct();
    window.scrollTo(0, 0);
  },
};
</script>
  <style>
.container {

min-height: 1000px;
height: auto;
  /* margin-top: 250px; */
}
.search {
  position: absolute;
  top: -40.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 13vw;
}
h3 {
  /* margin-top: 10px; */
  margin-bottom: 80px;
}
h5{
  position: absolute;
  top: 50.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 16vw;
}
p{
  position: absolute;
  top: 54.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 16vw;
}
.search_input {
  width: 250px;
  position: absolute;
  top: 60.7202%; /* 헤더 높이에 따른 위치 조정 */
  left: 16vw;
}


.serch_box {
  background-color: #342a26;
  width: 300px;
  height: 500px;
  color: #ffffff;
}

.col-md-4 {
  margin-right: 50px;
}

.row {
  --bs-gutter-x: 1.5rem;
  --bs-gutter-y: 0;
  display: flex;
  flex-wrap: nowrap;
  margin-top: calc(-1 * var(--bs-gutter-y));
  margin-right: calc(-0.5 * var(--bs-gutter-x));
  margin-left: calc(-0.5 * var(--bs-gutter-x));
  align-items: center;
  justify-content: space-around;
}
</style>
  