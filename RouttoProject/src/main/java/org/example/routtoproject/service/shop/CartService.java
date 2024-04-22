package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import org.example.routtoproject.model.entity.shop.Cart;
import org.example.routtoproject.repository.shop.product.CartRepository;
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
}
