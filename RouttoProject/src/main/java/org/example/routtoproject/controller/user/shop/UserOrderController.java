package org.example.routtoproject.controller.user.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.entity.shop.Order;
//import org.example.routtoproject.service.shop.OrderService;
import org.example.routtoproject.model.entity.shop.Product;
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



    //        TODO: user의 cart -> 전체 주문하기 : 상품 저장 함수
    @GetMapping("/order/product/{userId}")
    public ResponseEntity<Object> create(@PathVariable String userId) {
        try {
            List<ICartDto> iCartDto = orderService.findByUserIdContaining(userId);
            if (iCartDto.isEmpty() == true) {
                log.debug(iCartDto.toString());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(iCartDto, HttpStatus.OK);
            }
        } catch (Exception e) {


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
}
