<!-- CartList.vue -->
<template>
  <div class="container">
    <h5 class="text-center mt-5">장바구니</h5>
    <!-- 상품리스트 테이블 -->

    <table class="col-13 mt-5">
      <thead>
        <tr>
          <th class="text-center">선택</th>
          <th class="text-center">상품</th>
          <th class="text-center">상품명</th>
          <th class="text-center">수량</th>
          <th class="text-center">가격</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr>
          <!-- 체크박스 -->
          <td class="check_td text-center"><input type="checkbox" /></td>
          <!-- 상품이미지 -->
          <td class="text-center">
            <img src="https://via.placeholder.com/100" />
          </td>
          <td class="text-center">10,000원</td>
          <td class="text-center">2</td>
          <td class="text-center">20,000원</td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 총액 테이블 -->
    <table class="col-13 mt-5">
      <thead>
        <tr>
          <th class="text-center">금액</th>
          <th class="text-center">-</th>
          <th class="text-center">할인금액</th>
          <th class="text-center">+</th>
          <th class="text-center">배송비</th>
          <th class="text-center">총금액</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr>
          <td class="text-center">0원</td>
          <td class="text-center small_td"></td>
          <td class="text-center">0원</td>
          <td class="text-center small_td"></td>
          <td class="text-center">0원</td>
          <td class="text-center">0원</td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <hr />
    <!-- 아래 버튼 3개 -->
    <div class="row">
        <div class="col">
            <button type="button" class="btn btn-primary float-left">왼쪽 버튼</button>
        </div>
        <div class="col">
            <button type="button" class="btn btn-secondary float-right">오른쪽 버튼 1</button>
            <button type="button" class="btn btn-secondary float-right">오른쪽 버튼 2</button>
        </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style>
@import "@/assets/css/Cart.css";
@import "@/assets/css/Button.css";
</style>
