package org.example.routtoproject.controller.user.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.service.payment.UserRefundService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : org.example.routtoproject.controller.user.shop
 * fileName : UserRefundController
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
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user/shop")
public class UserRefundController {
    private final UserRefundService userRefundService;

    //  TODO: 수정
    @PutMapping("/refund/{orderId}/request")
    public ResponseEntity<Object> requestRefund(
            @PathVariable int orderId,
            @RequestBody Order order
    ) {
        try {
            Order order2 = userRefundService.update(order); // 수정

            return new ResponseEntity<>(order2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug("error" + e.getMessage());
//          DB 에러 (서버 에러) -> 500 신호 (INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
