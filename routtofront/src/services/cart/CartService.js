// CartService.js
// 장바구니 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";


class CartService {
  // todo: 상품 전체 조회
  // 전체 조회
  getAll(title, page, size) {
    // todo: 장바구니 전체조회
    return http.get(`/user/order/cart?title=${title}&page=${page}&size=${size}`, 
    {
      headers: AuthHeader()
    }
    );
    

  }
  //   todo : 장바구니 저장함수
  create(data) {
    return http.post("/user/order/cart", data,
    {
      headers: AuthHeader()
    });
  }
  // todo: product  저장함수, 전체 객체 전송
  // todo: header == 권한저장
  createPro(data) {
    return http.post("/user/order/", data,
    {
      headers: AuthHeader()
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
  remove(cartId){ //simple cart number
    return http.delete(`/user/order/cart/deletion/${cartId}`,
    {
      headers: AuthHeader()
    });
  } 
  // 전체 삭제 0508기준 제대로 안됐음
  removeAll(cart){ //simple cart number
    return http.delete("/user/order/cart/deletion", cart,
    {
      headers: AuthHeader()
    });
  }
  // todo: 주문하기 함수
  
}

export default new CartService();
