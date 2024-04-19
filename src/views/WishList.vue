<!-- CartList.vue -->
<template>
  <div class="container mt-5 mb-5">
    <h5 class="text-center mt-5">즐겨찾기</h5>
    <!-- 상품리스트 테이블 -->

    <table class="table col-13 mt-5">
      <thead>
        <tr class="align-middle">
          <th class="text-center"> </th>
          <th class="text-center">선택</th>
          <th class="text-center">상품</th>
          <th class="text-center">상품명</th>
          <th class="text-center">수량</th>
          <th class="text-center">가격</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr class="align-middle">
          <!-- 체크박스 -->
          <td class="check_td text-center">
            <a  href="https://ifh.cc/v-9YsRFr" target="_blank"
              ><img class="img_star" src="https://ifh.cc/g/9YsRFr.png" border="0"
            /></a>
          </td>
          <td class="check_td text-center"><input type="checkbox" /></td>
          <!-- 상품이미지 -->
          <td class="text-center">
            <img src="https://via.placeholder.com/100" />
          </td>
          <td class="text-center">헤어토닉</td>
          <td class="text-center">2</td>
          <td class="text-center">20,000원</td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 아래 버튼 3개 -->
    <div class="row justify-content-end mt-5">
      <div class="col">
        <button type="button" id="button2" class="btn btn-primary">
          선택상품 삭제하기
        </button>
      </div>
      <div class="col-auto mb-5">
        <button type="button" id="button2" class="btn btn-secondary">
          선택상품 주문하기
        </button>
        <button type="button" id="button1" class="btn btn-secondary">
          전체상품 주문하기
        </button>
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
