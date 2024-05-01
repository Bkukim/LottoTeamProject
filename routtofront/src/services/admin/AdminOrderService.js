// 주문 공통 CRUD 함수
import http from "@/utils/http-common";

class AdminOrderService {
  getAll(orderId, page, size) {
    return http.get(`/admin/shop/order?orderId=${orderId}&page=${page}&size=${size}`);
  }

}

export default new AdminOrderService();
