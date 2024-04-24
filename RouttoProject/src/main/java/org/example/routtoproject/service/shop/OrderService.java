package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.repository.shop.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : OrderService
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
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

//    TODO: 저장 함수
    public Order save(Order order){
        Order order1 = orderRepository.save(order);
        return order1;
    }
}
