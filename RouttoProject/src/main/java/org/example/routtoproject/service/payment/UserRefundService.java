package org.example.routtoproject.service.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.repository.admin.AdminRefundRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.payment
 * fileName : UserRefundService
 * author : BALLBAT
 * date : 2024-05-08
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-08         BALLBAT          최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserRefundService {
    private final AdminRefundRepository adminRefundRepository;

    public Order save(Order order) {
        Order order2 = adminRefundRepository.save(order);

        return order2;
    }

//     주문 상태를 변경하는 메소드
    public boolean requestRefund(int orderId) {
        Optional<Order> orderOptional = adminRefundRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setOrderStatus("환불요청"); // ORDER_STATUS 컬럼의 값을 '환불요청'으로 변경
            adminRefundRepository.save(order); // 변경된 상태를 데이터베이스에 저장
            return true;
        } else {
            return false;
        }
    }
}
