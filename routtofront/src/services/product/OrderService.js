// 주문 공통 CRUD 함수
import http from "@/utils/http-common";
// import AuthHeader from "../auth/AuthHeader";

class OrderService {
  // TODO: 주문 저장 함수
  saveOrder(data) {
    return http.post("/user/shop/order", data);
  }

  get(orderId,) {
    return http.get(`/user/shop/order/${orderId}`)
  }

  getOrderId(orderId){
    return http.get(`/admin/shop/order/${orderId}`,);
  }
}

export default new OrderService();
