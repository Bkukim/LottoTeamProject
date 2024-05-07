package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.entity.shop.Cart;
import org.example.routtoproject.repository.shop.CartRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Cart save(Cart cart){
        Cart cart1 = cartRepository.save(cart);
        return cart1;
    }
//    전체조회 함수
public Page<ICartDto> selectByTitleContaining(
        String title,
        Pageable pageable
){
    Page<ICartDto> page
            = cartRepository.selectByTitleContaining(
            title,
            pageable
    );

    return page;
}

    // todo: 삭제
    public boolean removeById(int cartId) {
//        JPA 삭제함수 : deleteById(기본키)
//        1) 먼저 기본키가 테이블에 있으면 삭제, true 리턴
//           없으면 false 리턴

//        사용법 : jpa레포지토리.existsById(기본키)
//         => 기본키가 테이블에 있으지 확인. 있으면 true, 없으면 false
        if(cartRepository.existsById(cartId) == true) {
            cartRepository.deleteById(cartId);
            return true;
        } else {
            return false;
        }
    }


}
