// 결제 공통 CRUD 함수
import http from "@/utils/http-common";

class PaymentService {
    getPaymentDetails(orderId) {
        return http.get(`/order/completed/${orderId}`);
    }
}

export default new PaymentService();