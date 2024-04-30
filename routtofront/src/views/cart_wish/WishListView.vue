<!-- CartList.vue -->
<template>
  <div class="container mt-5 mb-5">
    <h5 class="text-center mt-5">즐겨찾기</h5>
    <!-- 상품리스트 테이블 -->

    <table class="table col-13 mt-5">
      <thead>
        <tr class="align-middle">
          <th class="text-center">
            <input
              type="checkbox"
              v-model="selectAll"
              @change="selectAllItems"
            />
          </th>
          <th class="text-center">이미지</th>
          <th class="text-center">상품정보</th>
          <th class="text-center">금액</th>
          <th class="text-center">선택</th>
        </tr>
      </thead>
      <tbody>
        <!-- 반복문시작할 tr -->
        <tr
        v-for="(data, index) in favorite" :key="index"
         class="align-middle"
        >
          <!-- 체크박스 -->
          <td class="check_td text-center"><input type="checkbox" /></td>
          <!-- 상품이미지 -->
          <td class="text-center col-2">
            {{data.prodImg}}
          </td>
          <!-- 상품정보 -->
          <td class="text-center">
            {{data.prodName}}
          </td>
          <!-- 금액 -->
          <td class="text-center">
            {{ data.defaultPrice }}
          </td>
          <!-- 선택 :: 버튼 -->
          <td class="text-center">
            <div class="row mb-1">
              <div class="col">
                <button id="button_bg1" class="btn btn-primary btn-block" @click="saveWishList">
                  장바구니
                </button>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <button id="button_bg2" class="btn btn-secondary btn-block" @click="deleteWish">
                  삭제하기
                </button>
              </div>
            </div>
          </td>
        </tr>
        <!-- 다른 상품들도 이와 같은 형식으로 추가할 수 있습니다 -->
      </tbody>
    </table>
    <!-- 아래 버튼 4개 -->
    <div class="row justify-content-end mt-5">
      <div class="col">
        <button type="button" id="button2" class="btn btn-primary" @click="deleteSelectedItems">
          선택상품 삭제하기
        </button>
      </div>
      <div class="col-auto">
        <button type="button" id="button2" class="btn btn-secondary">
          선택 장바구니담기
        </button>
        <button type="button" id="button1" class="btn btn-secondary">
          전체 장바구니담기
        </button>
      </div>
      <div class="clearfix"></div>
      <div class="col-auto mb-5">
        <button type="button" id="button1" class="btn btn-secondary"
        @click="goCart">
          장바구니 바로가기
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import wishService from "@/services/cart/WishService"
import CartService from '@/services/cart/CartService';

export default {
  // TODO: 바인딩 속성
  data() {
    return {
      favorite: [], //상품객체
      message: "", // 장바구니 완료 성공메세지

      wishCount: 0, //장바구니 갯수

      // 공통 페이징 속성 정의
      page: 1, // 현재페이지번호
      count: 0, // 전체 데이터개수
      pageSize: 3, // 화면에 보여질 개수

      // 전체선택 함수
      selectAll: false,
      // 선택함수 객체배열 함수를 다른 페이지로 넘길수 있는지
    };
  },
  // TODO: 함수정의
  methods: {
    // 전체선택
    // 전체선택함수
    selectAllItems() {
      // 전체 선택 체크박스가 선택되면 모든 상품의 selected 값을 true로 설정
      // 선택 해제되면 false로 설정
      // 반복문의 data랑 같다고 생각하기
      this.favorite.forEach((data) => {
        data.selected = this.selectAll;
      });
    },

    // TODO: 장바구니 조회
    async retrieveWishList() {
      try {
        // todo: 공통 장바구니 전체 조회 서비스 함수 실행
        //   todo: 비동기 코딩 : async~await
        let response = await wishService.getAll(
          this.searchTitle,
          this.page - 1,
          this.pageSize
        );
        const { favorite, totalItems } = response.data;
        this.favorite = favorite;
        this.count = totalItems;
        // 로깅
        console.log(response); //웹브라우저 콘솔탭에 백엔드 데이터 표시
      } catch (e) {
        console.log(e);
      }
    },
    // 장바구니 담기 함수
    async saveWishList() {
      try {
        let data = {
          prodId: this.favorite.prodId, //상품번호
          wishCount: this.wishList, //위시 카운트
        };
        // todo: 공통 저장 서비스 함수
        // todo: async ~await
        let response = await CartService.create(data);
        // login
        console.log(response.data);
        // 성공메세지 출력
        this.message = "장바구니에 담겼습니다";
      } catch (e) {
        console.log(e);
      }
      // 임시객체
    },
    // 장바구니 삭제 함수
      // TODO: 장바구니 삭제 함수 : delete 버튼 태그
    //   async deleteWish(favoriteId) {
    //   try {
    //     // todo: 공통 장바구니 삭제 서비스 함수 실행
    //     let response = await wishService.remove(favoriteId);
    //     // 로깅
    //     console.log(response.data);
    //     // alert 대화상자
    //     alert("정상적으로 삭제되었습니다.");
    //     // 삭제후 재조회
    //     this.retrieveWishList();
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
        // 위시 삭제 함수
      // TODO: 단일 위시 삭제 함수 
      // : delete 버튼 태그, 기본키로 삭제
      async deleteWish(favoriteId) {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await wishService.remove(favoriteId);

        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");
        this.wishCount=this.wishCount-1; // 단일이니까 -1
        // 삭제후 재조회
        this.retrieveWishList();
      } catch (e) {
        console.log(e);
      }
    },// 위시 전체 삭제 함수
      // TODO: 단일 위시 삭제 함수 
      // :  전체가 들어있는 객체 삭제 ==맞나?
      async deleteAllWish(favorite) {
      try {
        // todo: 공통 장바구니 삭제 서비스 함수 실행
        let response = await wishService.remove(favorite);
        // 로깅
        console.log(response.data);
        // alert 대화상자
        alert("정상적으로 삭제되었습니다.");
        this.wishCount=0; // 전체니까 초기화
        // 삭제후 재조회
        this.retrieveWishList();
      } catch (e) {
        console.log(e);
      }
    },
    goCart() {
      this.$router.push("/cart");
    },
  },
  // TODO: 화면이뜰때 자동 실행
  mounted() {
    this.retrieveWishList();
  },
};
</script>
<style>
@import "@/assets/css/Cart.css";
@import "@/assets/css/Button.css";
</style>
<!-- @/services/cart/CartService -->
