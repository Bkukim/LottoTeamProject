// 환불 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";

class RefundService {
        // OrderId를 기준으로 주문상태를 환불요청으로 변경하기
        requestRefund(orderId, data) {
            console.log(orderId);
            return http.put(`/user/shop/refund/${orderId}/request`, data, {
                headers: AuthHeader()
              });
        }
}

export default new RefundService();