<template>
  <br />
  <br />
  <br />
  <div class="container mt-5">
    <h1 class="mt-4">상품 상세보기</h1>
    <hr />

    <br />
    <br />
    <br />

    <!-- 4. 배송 상품 -->
    <div>
      <h2>배송 상품</h2>
    </div>
    <!-- 기본 정보 테이블 시작-->
    <table class="table">
      <thead>
        <tr>
          <!-- 제목 : 상품정보, 판매가, 수량, 구매가 -->
          <th scope="col">상품이름</th>
          <!-- <th scope="col"></th> -->
          <!-- <th scope="col">상품가격</th> -->
          <th scope="col">수량</th>
          <th scope="col">총 상품가격</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(data, index) in orderProds" :key="index">
          <!-- 1) 배송 상품 -->
          <!-- <td scope="row">
            <img
              :src="product.prodImgUrl"
              style="width: 100px; height: 100px"
            />
          </td> -->
          <td>
            <p style="margin-top: 35px">{{ data.prodName }}</p>
          </td>
          <!-- 2) 상품가격 -->
          <!-- <td>
            <p style="margin-top: 35px">
              {{
                this.product.defaultPrice *
                (1 - this.product.discountRate / 100)
              }}원
            </p>
          </td> -->
          <!-- 3) 수량 -->
          <td style="text-align: left">
            <p style="margin-top: 35px">{{ data.orderAmount }}개</p>
          </td>
          <!-- 4) 총 상품가격 -->
          <td style="text-align: left">
            <p style="margin-top: 35px">{{ data.totalPrice }}원</p>
          </td>
        </tr>
      </tbody>
    </table>

    <br />
    <br />
    <br />
  </div>
</template>

<script>
import OrderService from "@/services/product/OrderService";

export default {
  data() {
    return {
      orderProds: [],
    };
  },
  methods: {
    async retrieveOrderProduct(orderId) {
      // alert(orderId)
      // todo: orderId로 조회하기 : 주문상세테이블
      try {
        let response = await OrderService.getOrderId(orderId); 
        console.log(response.data);
        this.orderProds = response.data; // 백엔드에서 배열이 들어옴(response에는 헤더_파일 형식, 바디_데이터 정보가 다 있다. 우리가 궁금한건 바디부분이라서 .data)
      } catch (error) {
        console.error("에러 발생 : ", error);
      }
    },
  },
  mounted() {
    this.retrieveOrderProduct(this.$route.params.orderId);  // 화면이 처음 뜰 때 orderId로 조회
  },
};
</script>

<style>
ul {
  list-style-type: none; /* 리스트 스타일을 없앰 */
}
</style>
