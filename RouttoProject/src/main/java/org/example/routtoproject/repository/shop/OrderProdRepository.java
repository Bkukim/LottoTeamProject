package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.OrderProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : OrderDetailRepository
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
@Repository
public interface OrderProdRepository extends JpaRepository<OrderProd, Integer> {
}
