// 주문 공통 CRUD 함수
import http from "@/utils/http-common";

import AuthHeader from "@/services/auth/AuthHeader";


class OrderService {
  // TODO: 주문 저장 함수
  saveOrder(data) {
    return http.post("/user/shop/order", data, {
      headers: AuthHeader(),
    });
  }

  getOrderId(orderId) {
    return http.get(`/admin/shop/order/${orderId}`, {
      headers: AuthHeader(),
    });
  }

  // TODO: 여기 붙혀넣기 (지영-상세조회-마이페이지)
  getOrder(userId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
    return http.get(`/user/shop/mypage-order/${userId}`);

  }
 

  
   // TODO: user의 cart에서 전체주문 -> 주문페이지
   get(userId){
    return http.get(`/user/shop/order/product/${userId}`,
    {
      headers: AuthHeader()
    });
  }


 
}

export default new OrderService();
