package org.example.routtoproject.controller.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.entity.shop.Order;
//import org.example.routtoproject.service.shop.OrderService;
import org.example.routtoproject.service.shop.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/api/shop")
public class OrderController {

    private final OrderService orderService;    // DI


//        TODO: 주문 저장 함수
    @PostMapping("/order")
    public ResponseEntity<Object> create(@RequestBody OrderDto orderDto) {
        log.debug("여기는 컨트롤러 1 ::: " + String.valueOf(orderDto));
        try {
            if (orderDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                Order order1 = orderService.saveOrder(orderDto);
                log.debug("여기는 컨트롤러 2 ::: " + String.valueOf(orderDto));
                return new ResponseEntity<>(order1, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
