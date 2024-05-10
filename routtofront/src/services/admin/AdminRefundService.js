import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";

class AdminRefundService {
    // OrderId로 주문 찾기
    findByOrderId(orderId) {
        console.log(orderId);
        return http.get(`/admin/shop/refund/by-order-id/${orderId}`,{
            headers: AuthHeader()
          });
    }

    // OrderTime으로 주문 찾기
    findByOrderTime(orderTime) {
        return http.get(`/admin/shop/refund/by-order-time/${orderTime}`,{
            headers: AuthHeader()
          });
    }

    // OrderStatus로 주문 찾기
    findByOrderStatus(orderStatus) {
        return http.get(`/admin/shop/refund/by-order-status/${orderStatus}`,{
            headers: AuthHeader()
          });
    }

    // OrderPrice로 주문 찾기
    findByOrderPrice(orderPrice) {
        return http.get(`/admin/shop/refund/by-order-price/${orderPrice}`,{
            headers: AuthHeader()
          });
    }

    // OrderId로 상세조회
    get(orderId) {
        return http.get(`/admin/shop/refund/${orderId}`,{
            headers: AuthHeader()
          })
    }

    // OrderId를 기준으로 주문상태를 환불완료로 변경하기
    completeRefund(orderId, data) {
        return http.put(`/admin/shop/refund/${orderId}/complete`, data,{
            headers: AuthHeader()
          });
    }
}

export default new AdminRefundService();