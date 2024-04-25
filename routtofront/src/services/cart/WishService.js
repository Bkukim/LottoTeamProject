// WishService.js
// 장바구니 공통 CRUD 함수
import http from "@/utils/http-common";

class WishService {
  // todo: 상품 전체 조회
  // 전체 조회
  getAll(title, page, size) {
    // todo: 장바구니 전체조회
    return http.get(`/shop/cart?title=${title}&page${page}&size${size}`);
  }
  //   todo : 장바구니 저장함수
  create(data) {
    return http.post("/shop/cart", data);
  }
  // todo: 장바구니 삭제함수 : 상품 번호(prodId)
  remove(favoriteId){ //favoriteId number
    return http.delete(`/shop/cart/deletion/${favoriteId}`);
  }
  // todo: 주문하기 함수
  
}

export default new WishService();
