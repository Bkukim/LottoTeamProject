package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import org.example.routtoproject.repository.shop.OrderDetailRepository;
import org.example.routtoproject.repository.shop.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : OrderService
 * author : hayj6
 * date : 2024-04-23(023)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23(023)         hayj6          최초 생성
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

}
