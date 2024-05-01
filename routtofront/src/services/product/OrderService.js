// 주문 공통 CRUD 함수
import http from "@/utils/http-common";

class OrderService {
  // TODO: 주문 저장 함수
  saveOrder(data) {
    return http.post("/user/shop/order", data);
  }
}

export default new OrderService();
