// OrderComService.js
// 주문 완료 페이지 공통 함수
import http from "@/utils/http-common";

class OrderComService {
    orderInform(order) {
        let data = {
            orderid: order.orderId,
            orderamount: order.orderAmount
        };
        return http.post("/order/completed", data);
    }
}

export default new OrderComService();