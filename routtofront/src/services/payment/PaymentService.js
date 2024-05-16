// 결제 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";

class PaymentService {
    getOrder(orderId) {
        return http.get(`/normal/user/order/${orderId}`, {
            headers: AuthHeader(),
          })
    }
    create(data) {
        return http.post("/user/shop/payment/success", data, {
            headers: AuthHeader(),
          });
    }
}

export default new PaymentService();