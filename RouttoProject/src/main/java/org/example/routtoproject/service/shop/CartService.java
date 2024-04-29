package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
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


}
