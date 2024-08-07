package org.example.routtoproject.controller.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.dto.shop.PaymentDto;
import org.example.routtoproject.model.entity.payment.Payment;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.service.payment.PaymentService;
import org.example.routtoproject.service.shop.AdminRefundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : org.example.routtoproject.controller.payment
 * fileName : PaymentController
 * author : BALLBAT
 * date : 2024-04-29
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         BALLBAT          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/user/shop")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    //    저장 함수
    @PostMapping("/payment/success")
    public ResponseEntity<Object> create(@RequestBody PaymentDto paymentDto) {

        try {
            log.debug("매개변수 " + paymentDto);
            Payment payment = paymentService.save(paymentDto); // db 저장
            log.debug("2");
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } catch (Exception e) {
            log.debug("결제 " + e.getMessage());
//            DB 에러가 났을경우 : INTERNAL_SERVER_ERROR 프론트엔드로 전송
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
