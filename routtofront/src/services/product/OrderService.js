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

  // get(orderId,) {
  //   return http.get(`/user/shop/order/${orderId}`)
  // }

  getOrderId(orderId){

    return http.get(`/admin/shop/order/${orderId}`,
    {
      headers: AuthHeader()
    });
  }
   // user의 cart에서 전체주문 -> 주문페이지
   get(userId){
    return http.get(`/user/shop/order/product/${userId}`,
    {
      headers: AuthHeader()
    });

  }
}

export default new OrderService();
