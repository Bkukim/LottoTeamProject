// 주문 공통 CRUD 함수
import http from "@/utils/http-common";

class AdminOrderService {
  getAll(orderTime, orderStatus, page, size) {
    return http.get(`/admin/shop/order?orderTime=${orderTime}&orderStatus=${orderStatus}&page=${page}&size=${size}`);
  }

}

export default new AdminOrderService();
