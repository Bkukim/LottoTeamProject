package org.example.routtoproject.controller.admin.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.service.shop.AdminRefundService;
import org.example.routtoproject.service.shop.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * packageName : org.example.routtoproject.controller.admin.shop
 * fileName : AdminRefundController
 * author : BALLBAT
 * date : 2024-05-02
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-02         BALLBAT          최초 생성
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/shop")
public class AdminRefundController {

    private final AdminRefundService adminRefundService;

    // OrderId로 주문 찾기
    @GetMapping("/refund/by-order-id/{orderId}")
    public ResponseEntity<List<Order>> findByOrderId(@PathVariable int orderId) {
        try {
            List<Order> orders = adminRefundService.findByOrderId(orderId);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            log.error("에러", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // OrderTime으로 주문 찾기
    @GetMapping("/refund/by-order-time/{orderTime}")
    public ResponseEntity<List<Order>> findByOrderTime(@PathVariable String orderTime) {
        try {
            List<Order> orders = adminRefundService.findByOrderTime(orderTime);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            log.error("에러", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // OrderStatus로 주문 찾기
    @GetMapping("/refund/by-order-status/{orderStatus}")
    public ResponseEntity<List<Order>> findByOrderStatus(@PathVariable String orderStatus) {
        try {
            List<Order> orders = adminRefundService.findByOrderStatus(orderStatus);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            log.error("에러", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // OrderPrice로 주문 찾기
    @GetMapping("/refund/by-order-price/{orderPrice}")
    public ResponseEntity<List<Order>> findByOrderPrice(@PathVariable int orderPrice) {
        try {
            List<Order> orders = adminRefundService.findByOrderPrice(orderPrice);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            log.error("에러", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 주문의 환불 상태를 '환불 완료'로 변경하는 메소드
//    @PutMapping("/refund/{orderId}/complete")
//    public ResponseEntity<?> completeRefund(@PathVariable int orderId) {
//        boolean result = adminRefundService.completeRefund(orderId);
//
//        if(result) {
//            return ResponseEntity.ok().body("환불이 완료되었습니다.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//  TODO: 상세 조회
    @GetMapping("/refund/{orderId}")
    public ResponseEntity<Object> findById(
            @PathVariable int orderId
    ) {
        try {
            Optional<Order> optionalOrder = adminRefundService.findById(orderId);

            if (optionalOrder.isEmpty() == true) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//  TODO: 수정
    @PutMapping("/refund/{orderId}/complete")
    public ResponseEntity<Object> requestRefund(
            @PathVariable int orderId,
            @RequestBody Order order
    ) {
        try {
            Order order2 = adminRefundService.requestRefund(order); // 수정

            return new ResponseEntity<>(order2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug("error" + e.getMessage());
//          DB 에러 (서버 에러) -> 500 신호 (INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
