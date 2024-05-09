// 장바구니 공통 CRUD 함수
import http from "@/utils/http-common";

class CartService{
    // TODO: 장바구니 저장함수
    create(data) {
        return http.post("/user/order/cart", data);
    }
}
export default new CartService;
