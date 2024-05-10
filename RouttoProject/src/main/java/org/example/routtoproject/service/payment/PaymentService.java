package org.example.routtoproject.service.payment;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.PaymentDto;
import org.example.routtoproject.model.entity.payment.Payment;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.repository.payment.PaymentRepository;
import org.example.routtoproject.service.shop.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.payment
 * fileName : PaymentService
 * author : BALLBAT
 * date : 2024-04-28
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-28         BALLBAT          최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {
    ModelMapper modelMapper = new ModelMapper();

    private final PaymentRepository paymentRepository; // DI
    private final OrderService orderService; // DI

//  저장 함수
    @Transactional
    public Payment save (PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);

//        1) 저장
        Payment payment2 = paymentRepository.save(payment);

//      주문 객체 상세 조회
        Optional<Order> optionalOrder = orderService.findById(payment.getOrderId());
        Order order = optionalOrder.get();
        order.setOrderStatus("결제완료"); // 주문 상태 값 수정

//      주문테이블 수정 : 주문 상태 값 변경
        orderService.update(order);

        return payment2;
    }
//
//  삭제함수
    public boolean removeByPaymentCode(Integer paymentCode) {
        if (paymentRepository.existsById(paymentCode)) {
            Optional<Payment> optionalPayment = paymentRepository.findById(paymentCode);

            paymentRepository.deleteById(paymentCode); // DB 삭제 진행

//          주문 객체 상세 조회
            Optional<Order> optionalOrder = orderService.findById(optionalPayment.get().getOrderId());
            Order order = optionalOrder.get();
            order.setOrderStatus("결제취소"); // 주문 상태 값 수정

            return true;
        }
        return false;
    }
//
//  상세조회
    public Optional<Payment> findById(Integer paymentCode) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentCode);

        return optionalPayment;
    }
}
