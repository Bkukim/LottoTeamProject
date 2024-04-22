// 장바구니 공통 CRUD 함수
import http from "@/utils/http-common";

class CartService{
    // TODO: 상품 전체 조회
    // getAll(pname, page, size){
    //     return http.get(`/shop/cart?pname=${pname}&page=${page}&size=${size}`);
    // }
    // TODO: 장바구니 저장함수
    create(data) {
        return http.post("/shop/product/cart", data);
    }
}

export default new CartService;