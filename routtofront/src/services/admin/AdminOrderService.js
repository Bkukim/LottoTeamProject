// 주문 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "@/services/auth/AuthHeader";

class AdminOrderService {
  // 주문일, 주문상태로 검색하여 주문확인
  getAll(orderTime, orderStatus, page, size) {
    return http.get(
      `/admin/shop/order?orderTime=${orderTime}&orderStatus=${orderStatus}&page=${page}&size=${size}`,
      {
        headers: AuthHeader(),
      }
    );
  }

  // 주문 확인 페이지 : 상세보기
  update(data) {
    console.log(data);
    return http.put(`/admin/shop/order/update/${data.orderId}`, data, {
      headers: AuthHeader(),
    });
  }

  // 주문 정보 삭제 함수
  delete(orderId) {
    return http.delete(`/admin/shop/order/deletion/${orderId}`)
  }
}

export default new AdminOrderService();
