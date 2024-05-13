// 결제 공통 CRUD 함수
import http from "@/utils/http-common";

class PaymentService {
    getOrder(orderId) {
        return http.get(`/normal/shop/order/${orderId}`)
    }
    create(data) {
        return http.post("/normal/shop/payment/success", data);
    }
    
    remove(paymentCode) {
        return http.delete(`/normal/shop/payment/deletion/${paymentCode}`);
    }
    // getPaymentInfo(paymentCode) {
    //     return http.get(`/user/shop/order/${paymentCode}`)
    // }
}

export default new PaymentService();