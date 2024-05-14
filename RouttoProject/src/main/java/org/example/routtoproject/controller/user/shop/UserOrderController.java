package org.example.routtoproject.controller.user.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.model.entity.payment.Payment;
import org.example.routtoproject.model.entity.shop.Order;
//import org.example.routtoproject.service.shop.OrderService;
import org.example.routtoproject.model.entity.shop.OrderProd;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.member.UserService;
import org.example.routtoproject.service.payment.PaymentService;
import org.example.routtoproject.service.shop.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.controller.shop
 * fileName : OrderController
 * author : hayj6
 * date : 2024-04-24(024)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-24(024)         hayj6          최초 생성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user/shop")
public class UserOrderController {

    private final OrderService orderService;    // DI
    private final PaymentService paymentService; // DI
    private final UserService userService; // DI


    //        TODO: 주문 저장 함수
    @PostMapping("/order")
    public ResponseEntity<Object> create(@RequestBody OrderDto orderDto) {
        try {
            log.debug("11111");
            if (orderDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                Order order1 = orderService.saveOrder(orderDto);
                return new ResponseEntity<>(order1, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    //  TODO: 상세조회 : DTO 전송(부모+자식)
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Object> findById(@PathVariable int orderId) {
        try {
//          상세 조회 실행
            Optional<Order> optionalOrder = orderService.findById(orderId);

            if (optionalOrder.isEmpty() == false) {
//              성공
                return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
            } else {
//              데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//          서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//   TODO: 주문 확인 페이지에서의 상세 조회
    @GetMapping("/order/completed/{orderId}")
    public ResponseEntity<Object> findAll(@PathVariable int orderId) {
        try {
            Optional<Order> optionalOrder = paymentService.findAll(orderId);

            if (optionalOrder.isEmpty() == false) {
//              성공
                return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//  TODO: 주문 상품 상세 조회
    @GetMapping("/order/prod/{orderProdId}")
    public ResponseEntity<Object> findOpi(@PathVariable int orderProdId) {
        try {
            Optional<OrderProd> optionalOrderProd = orderService.findOpi(orderProdId);

            if (optionalOrderProd.isEmpty() == false) {
                return new ResponseEntity<>(optionalOrderProd.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo 마이페이지에서 현재 주문 상태 보여주는 함수
    @GetMapping("/order-all/{userId}")
    public ResponseEntity<Object> findAllByUserId(@PathVariable String userId){
        try {
            log.debug("여긴 컨트롤러 1");
            List<Order> orders = orderService.findAllByUserId(userId);
            log.debug("여긴 컨트롤러 2");
            if (orders != null) {
                return new ResponseEntity<>(orders, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
