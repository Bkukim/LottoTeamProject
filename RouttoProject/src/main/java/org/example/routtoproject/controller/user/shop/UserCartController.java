package org.example.routtoproject.controller.user.shop;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.CartProdCountDto;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Cart;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/api/user/order")
public class UserCartController {
    @Autowired
    CartService cartService;

    //        TODO: user의 cart -> 전체 주문하기 : 상품 저장 함수
    @GetMapping("/cart/product/{userId}")
    public ResponseEntity<Object> create(@PathVariable String userId) {
        try {
            List<ICartDto> iCartDto = cartService.findByUserIdContaining(userId);
            if (iCartDto.isEmpty() == true) {
                log.debug(iCartDto.toString());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(iCartDto, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //todo: 전체조회
    //    TODO: 전체조회 함수(조인) + like 검색
//    조회(select) -> get 방식 -> @GetMapping
    @GetMapping("/cart")
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "") String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<ICartDto> iCartDtoPage
                    = cartService
                    .selectByTitleContaining(userId, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("cartList", iCartDtoPage.getContent());       // simpleCart 배열
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

    // 이미지 가져오기 함수, 상세조회
//    @GetMapping("/cart/prodimg{uuid}")
//    public ResponseEntity<byte[]> findImg(@PathVariable String prodImgUrl) {
//        Product product = cartService.findImgByUuid(prodImgUrl).get();
//
//        return ResponseEntity.ok()
////           Todo : attachment: => attachment;
//                .header(HttpHeaders.CONTENT_DISPOSITION, "product; filename=\"" + product.getProdImgUrl() + "\"")
//                .body(product.getProdImgUrl());
//    }


    //        TODO: 장바구니에 상품 저장 함수
    @PostMapping("/cart")
    public ResponseEntity<Object> create(@RequestBody Cart cart) {
        try {
            log.debug("error" + cart.getProdId().toString());
            if (cartService.existById(cart.getProdId())) {
                // 이미 장바구니에 상품이 존재하는 경우
                log.debug("adfadsfjal;dsk");
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                // 장바구니에 상품이 존재하지 않는 경우, 새로운 상품 저장
                Cart cart1 = cartService.save(cart);
                return new ResponseEntity<>(cart1, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 예외 발생 시 서버 오류 응답
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //   TODO: 수량확정 함수
//   TODO: put (update) 시 정확하기 기본키, 수정될객체를 전송해 줄것, 아니면 스프링 시큐리티에서 권한에러 발생함
    @PutMapping("/cart/update-prodcount/{cartProdCount}/{userId}/{prodId}")
    public ResponseEntity<Object> updateProdCount(
            @PathVariable Integer cartProdCount,
            @PathVariable String userId,
            @PathVariable Integer prodId,
            @RequestBody Cart cart
    ) {
        try {
            cartService.updateProdCount(cartProdCount, userId, prodId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
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

            if (success == true) {
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

    //    TODO: 전체삭제 함수
    @DeleteMapping("/cart/deletion-all/{userId}")
    public ResponseEntity<Object> deleteAllCarts(
            @PathVariable String userId
    ) {
        try {
            // 카트 전체 초기화 서비스 호출
            cartService.deleteByUserId(userId);
            return new ResponseEntity<>(HttpStatus.OK); // 성공적으로 삭제됨
        } catch (Exception e) {
            // 서버(DB) 에러
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}



