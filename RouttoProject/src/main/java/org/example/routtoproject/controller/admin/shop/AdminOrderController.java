package org.example.routtoproject.controller.admin.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/api/admin/shop")
public class AdminOrderController {

    private final OrderService orderService;    // DI

    //    TODO: 전체조회 함수
//    조회(select) -> get 방식 -> @GetMapping
    @GetMapping("/order")
    public ResponseEntity<Object> findAll(@RequestParam(defaultValue = "") String orderTime, @RequestParam(defaultValue = "") String orderStatus, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        try {
            log.debug(orderTime + "sdfasdtgasrtgasretasrtgsdertgsdrfgsdrftgszd");
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);
            log.debug(orderTime);

//            전체 조회 서비스 실행
            Page<Order> orders = orderService.findAll(orderTime, orderStatus, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("orders", orders.getContent());    // simpleProduct 배열
            response.put("currentPage", orders.getNumber());       // 현재페이지번호
            response.put("totalItems", orders.getTotalElements()); // 총건수(개수)
            response.put("totalPages", orders.getTotalPages());    // 총페이지수

            if (orders.isEmpty() == false) {
//                조회 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    todo: 상품 상세조회 함수 : 관리자 주문확인 페이지에서 상세보기 클릭 시 나옴
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Object> findOrderProductAll(@PathVariable Integer orderId) {
        try {
//            전체 조회 서비스 실행
            List<OrderProductDetailDto> orderProdDetail = orderService.findOrderProdDetail(orderId);
            if (orderProdDetail.isEmpty() == false) {
//                조회 성공
                return new ResponseEntity<>(orderProdDetail, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug("error" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //   todo: 주문상태 변경(저장) 함수 : 드롭다운에서 선택 시 바뀌도록
    @PutMapping("/order/update/{orderId}")
    public ResponseEntity<Object> update(   // 데이터를 넣어서 프론트로 보냄. 품질향상에 좋은 클래스
              @PathVariable int orderId
             ,@RequestBody Order order
    ) {
        try {
            Order order1 = orderService.save(order);                // DB 서비스 저장 함수 실행
            return new ResponseEntity<>(order1, HttpStatus.OK);  // 성공했으니까 OK 보내기(안보내도 상관없음)
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);   // 500 에러 전송
        }
    }
}
