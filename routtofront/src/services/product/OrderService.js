// 주문 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "@/services/auth/AuthHeader";

class OrderService {
  // TODO: 주문 저장 함수
  saveOrder(data) {
    return http.post("/user/shop/order", data,
    {
      headers: AuthHeader()
    });
  }
  getOrderId(orderId){
    return http.get(`/admin/shop/order/${orderId}`,
    {
      headers: AuthHeader()
    });
  }
}

export default new OrderService();
