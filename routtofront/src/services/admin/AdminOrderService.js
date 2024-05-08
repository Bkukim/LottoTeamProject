// 주문 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "@/services/auth/AuthHeader";

class AdminOrderService {
  getAll(orderTime, orderStatus, page, size) {
    return http.get(`/admin/shop/order?orderTime=${orderTime}&orderStatus=${orderStatus}&page=${page}&size=${size}`,
    {
      headers: AuthHeader()
    });
  }

  update(data){
    console.log(data);
    return http.put(`/admin/shop/order/update/${data.orderId}`, data,
    {
      headers: AuthHeader()
    });
}

}

export default new AdminOrderService();
