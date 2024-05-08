import http from "@/utils/http-common";

class AdminRefundService {
    // OrderId로 주문 찾기
    findByOrderId(orderId) {
        console.log(orderId);
        return http.get(`/admin/shop/refund/by-order-id/${orderId}`);
    }

    // OrderTime으로 주문 찾기
    findByOrderTime(orderTime) {
        return http.get(`/admin/shop/refund/by-order-time/${orderTime}`);
    }

    // OrderStatus로 주문 찾기
    findByOrderStatus(orderStatus) {
        return http.get(`/admin/shop/refund/by-order-status/${orderStatus}`);
    }

    // OrderPrice로 주문 찾기
    findByOrderPrice(orderPrice) {
        return http.get(`/admin/shop/refund/by-order-price/${orderPrice}`);
    }

    // OrderId를 기준으로 주문상태를 환불완료로 변경하기
    completeRefund(orderId) {
        console.log("주문번호", orderId);
        return http.put(`/admin/shop/refund/${orderId}/complete`);
    }
}

export default new AdminRefundService();