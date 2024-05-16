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

    //  TODO: 저장/수정
    public Order update(Order order) {
//        TODO: 상세조회
        Optional<Order> optionalOrder = adminRefundRepository.findById(order.getOrderId());
        Order order2 = optionalOrder.get();

        order2.setOrderStatus(order.getOrderStatus()); // 환불 수정

//        TODO: 저장
        Order order3 = adminRefundRepository.save(order2);

        return order3;
    }
}
