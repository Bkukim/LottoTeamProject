package org.example.routtoproject.controller.normal.user;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.entity.shop.Cart;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.service.shop.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.controller.normal.user
 * fileName : NormarlCartController
 * author : KimDJ
 * date : 2024-05-02
 * description :
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-02         KimDJ          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/normal/order")
public class NormalCartController {
    @Autowired
    CartService cartService;

    //todo: 전체조회
    //    TODO: 전체조회 함수(조인) + like 검색
//    조회(select) -> get 방식 -> @GetMapping
    @GetMapping("/cart")
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<ICartDto> iCartDtoPage
                    = cartService
                    .selectByTitleContaining(title, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("cart", iCartDtoPage.getContent());       // simpleCart 배열
            response.put("currentPage", iCartDtoPage.getNumber());       // 현재페이지번호
            response.put("totalItems", iCartDtoPage.getTotalElements()); // 총건수(개수)
            response.put("totalPages", iCartDtoPage.getTotalPages());    // 총페이지수

            if (iCartDtoPage.isEmpty() == false) {
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


    //        TODO: 장바구니에 상품 저장 함수
    @PostMapping("/cart")
    public ResponseEntity<Object> create(@RequestBody Cart cart) {
        try {
            Cart cart1 = cartService.save(cart);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //    TODO: 삭제 함수
    @DeleteMapping("/cart/deletion/{cartId}")
    public ResponseEntity<Object> delete(
            @PathVariable int cartId
    ) {
        try {
//            DB 서비스 삭제 함수 실행
            boolean success = cartService.removeById(cartId);

            if(success == true) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // 삭제 실행 : 0건 삭제(삭제할 데이터 없음)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
//            서버(DB) 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

