// 주문 공통 CRUD 함수
import http from "@/utils/http-common";

import AuthHeader from "@/services/auth/AuthHeader";

class OrderService {
  // TODO: 주문 저장 함수
  saveOrder(data) {
    return http.post("/user/shop/order", data, { // return 이 결과값
      headers: AuthHeader(),
    });
  }

  getOrderId(orderId) {
    return http.get(`/admin/shop/order/${orderId}`, {
      headers: AuthHeader(),
    });
  }
  // TODO: 결제를 위한 주문 정보 가져오기 함수
  goPayment(orderId) {
    return http.get(`/user/shop/order/${orderId}`, {
      headers: AuthHeader(),
    })
  }
  // TODO: 주문 확인 페이지에서의 상세 조회
  getOrderInfo(orderId) {
    return http.get(`/user/shop/order/completed/${orderId}`,{
      headers: AuthHeader()
    });
  }
  // TODO: orderID로 user.phoneNum 받아오기
  getOrderPhone(orderId) {
    return http.get(`/user/shop/order/phone/${orderId}`,{
      headers: AuthHeader()
    })
  }
  // TODO: orderId로 orderProdId 조회
  getOrderProduct(orderId) {
    return http.get(`/user/shop/order/orderProds/ids/${orderId}`,{
      headers: AuthHeader()
    })
  }
  // TODO: orderProdId를 이용해 product 정보 조회
  getProductInfo(orderProdId) {
    return http.get(`/user/shop/order-products/${orderProdId}`,{
      headers: AuthHeader()
    })
  }

  // TODO: OrderId를 기준으로 주문상태를 결제완료로 변경하기
  change(orderId, data) {
    return http.put(`/admin/shop/order/${orderId}/pay-complete`, data, {
      headers: AuthHeader(),
    });
  }

  // TODO: 여기 붙혀넣기 (지영-상세조회-마이페이지)
  getOrder(userId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)

    return http.get(`/user/shop/order-all/${userId}`, {
      headers: AuthHeader(),
    });


  }

  // TODO: user의 cart에서 전체주문 -> 주문페이지
  get(userId) {
    return http.get(`/user/shop/order/product/${userId}`, {
      headers: AuthHeader(),
    });
  }
}

export default new OrderService();
