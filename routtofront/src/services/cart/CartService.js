// CartService.js
// 장바구니 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";

class CartService {
  // todo: 상품 전체 조회
  // 전체 조회
  getAll(userId, page, size) {
    // todo: 장바구니 전체조회
    return http.get(
      `/user/order/cart?userId=${userId}&page=${page}&size=${size}`,
      {
        headers: AuthHeader(),
      }
    );
  }
  //   todo : 장바구니 저장함수
  create(data) {
    return http.post("/user/order/cart", data, {
      headers: AuthHeader(),
    });
  }
  // todo: product  저장함수, 전체 객체 전송
  // todo: header == 권한저장
  createPro(data) {
    return http.post("/user/order/", data, {
      headers: AuthHeader(),
    });
  }
  // todo: 단일 객체 전송
  // createPro(data) {
  //   return http.post("/user/order/", data,
  //   {
  //     headers: AuthHeader()
  //   });
  // }
  // todo: 장바구니 삭제함수 : 카트번호 cartId -> 삭제시 기본키로 삭제해야함
  remove(cartId) {
    //simple cart number
    return http.delete(`/user/order/cart/deletion/${cartId}`, {
      headers: AuthHeader(),
    });
  }
  // 전체 삭제 0508기준 제대로 안됐음
  removeAll(data) {
    //simple cart number
    return http.delete("/user/order/cart/deletion-all", data, {
      headers: AuthHeader(),
    });
  }
  // todo: prodCOunt 수정
  // TODO: 수정함수 : qnaId,
  updateProdCountAll(data) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
    return http.put("/user/order/cart/update-prodcount/", data, {
      headers: AuthHeader(),
    });
  }
  // todo: prodCOunt 수정 단일 수정용으로 복붙
  // TODO: 수정함수 : qnaId,
  updateProdCount(cartProdCount, userId, prodId) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
    return http.put(
      `/user/order/cart/update-prodcount/${cartProdCount}/${userId}/${prodId}`,
      {
        headers: AuthHeader(),
      }
    );
  }
  // TODO: 장바구니 저장함수
  saveProductToCart(data) {
    return http.post("/user/order/cart", data, {
      headers: AuthHeader(),
    });
  }
  // TODO: user의 cart에서 전체주문 -> 주문페이지
  getCartAll(userId) {
    return http.get(`/user/order/cart/product/${userId}`, {
      headers: AuthHeader(),
    });
  }
}

export default new CartService();
