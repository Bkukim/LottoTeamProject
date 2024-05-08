// 결제 공통 CRUD 함수
import http from "@/utils/http-common";

class PaymentService {
    create(data) {
        return http.post("/normal/shop/payment", data);
    }
    
    remove(paymentCode) {
        return http.delete(`/normal/shop/payment/deletion/${paymentCode}`);
    }
}

export default new PaymentService();