package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Cart;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.repository.shop.CartRepository;
import org.example.routtoproject.repository.shop.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : CartService
 * author : hayj6
 * date : 2024-04-22(022)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-22(022)         hayj6          최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    //    저장 함수
    public Cart save(Cart cart) {
        Cart cart1 = cartRepository.save(cart);
        return cart1;
    }

    //
//   todo: 이미지 불러오는 함수


    //    todo: 전체 수정함수
    public void updateAll(
    ) {

    }

    //todo: 단일 수정함수
    public void updateProdCount(
            Integer cartProdCount,
            String userId,
            Integer prodId

    ) {
        cartRepository.updateCartProdCount(cartProdCount, userId, prodId);
    }

    //    전체조회 함수
    public Page<ICartDto> selectByTitleContaining(
            String userId,
            Pageable pageable
    ) {
        Page<ICartDto> page
                = cartRepository.selectByTitleContaining(
                userId,
                pageable
        );
        log.debug("service확인");

        return page;
    }


    // todo: 삭제
    public boolean removeById(int cartId) {
//        JPA 삭제함수 : deleteById(기본키)
//        1) 먼저 기본키가 테이블에 있으면 삭제, true 리턴
//           없으면 false 리턴

//        사용법 : jpa레포지토리.existsById(기본키)
//         => 기본키가 테이블에 있으지 확인. 있으면 true, 없으면 false
        if (cartRepository.existsById(cartId) == true) {
            cartRepository.deleteById(cartId);
            return true;
        } else {
            return false;
        }
    }

    // todo: id가 존재하는지 확인
    public boolean existById(int prodId) {
        if (cartRepository.existsByProdId(prodId) != null) {
            return true;    // 상품이 이미 존재하면
        } else {
            return false;   // 상품이 없으면
        }
    }

}
