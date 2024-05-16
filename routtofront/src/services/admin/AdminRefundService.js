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
    getDetail(orderId) {
        return http.get(`/admin/shop/refund/${orderId}`,{
            headers: AuthHeader()
          })
    }

    // orderId로 paymentCode 조회
    getPayCode(orderId) {
        return http.get(`/admin/shop/payment/by-od/${orderId}` ,{
            headers: AuthHeader()
          })
    }

    findAllByOrderStatus(orderStatus) {
        return http.get(`/admin/shop/refund/get-all/order-status/${orderStatus}`,{
            headers: AuthHeader()
          })
    }

    // OrderId를 기준으로 주문상태를 환불완료로 변경하기
    completeRefund(orderId, data) {
        return http.put(`/admin/shop/refund/${orderId}/complete`, data,{
            headers: AuthHeader()
          });
    }

    // paymentCode로 결제 테이블 삭제하기
    remove(paymentCode) {
        return http.delete(`/admin/shop/payment/deletion/${paymentCode}`,{
            headers: AuthHeader()
          });
    }
}

export default new AdminRefundService();