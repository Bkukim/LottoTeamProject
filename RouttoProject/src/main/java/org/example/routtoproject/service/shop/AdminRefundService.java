package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.repository.admin.AdminRefundRepository;
import org.example.routtoproject.repository.shop.OrderProdRepository;
import org.example.routtoproject.repository.shop.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : AdminRefundService
 * author : BALLBAT
 * date : 2024-05-04
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-04         BALLBAT          최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminRefundService {

    private final AdminRefundRepository adminRefundRepository;

//  주문 번호로 조회하기
    public List<Order> findByOrderId(int orderId) {
        return adminRefundRepository.findByOrderId(orderId);
    }

//  주문 일시로 조회하기
    public List<Order> findByOrderTime(String orderTime) {
        return adminRefundRepository.findByOrderTime(orderTime);
    }

//  주문 상태로 조회하기
    public List<Order> findByOrderStatus(String orderStatus) {
        return adminRefundRepository.findByOrderStatus(orderStatus);
    }

//  주문 가격으로 조회하기
    public List<Order> findByOrderPrice(int orderPrice) {
        return adminRefundRepository.findByOrderPrice(orderPrice);
    }

    // 주문 상태를 변경하는 메소드
//    public boolean completeRefund(int orderId) {
//        Optional<Order> orderOptional = adminRefundRepository.findById(orderId);
//
//        if (orderOptional.isPresent()) {
//            Order order = orderOptional.get();
//            order.setOrderStatus("환불완료"); // ORDER_STATUS 컬럼의 값을 '환불 완료'로 변경
//            adminRefundRepository.save(order); // 변경된 상태를 데이터베이스에 저장
//            return true;
//        } else {
//            return false;
//        }
//    }

//  TODO: 상세조회 함수
    public Optional<Order> findById(int orderId) {
        Optional<Order> optionalOrder = adminRefundRepository.findById(orderId);
        return optionalOrder;
    }

//  TODO: 저장/수정
    public Order requestRefund(Order order) {
//        TODO: 상세조회
        Optional<Order> optionalOrder = adminRefundRepository.findById(order.getOrderId());
        Order order2 = optionalOrder.get();

        order2.setOrderStatus(order.getOrderStatus()); // 환불 수정

//        TODO: 저장
        Order order3 = adminRefundRepository.save(order2);

        return order3;
    }
}
