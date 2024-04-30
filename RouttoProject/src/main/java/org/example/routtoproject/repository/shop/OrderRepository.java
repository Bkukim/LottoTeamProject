package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : OrderRepository
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
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_ID LIKE '%' || :orderId || '%'"
            ,countQuery = "SELECT count(*) FROM LOTTO_ORDER\n" +
            "WHERE ORDER_ID LIKE '%' || :orderId || '%'"
            ,nativeQuery = true
    )
    Page<Order> findAllByOrderIdContaining(@Param("orderId") int orderId,
                                              Pageable pageable
    );

}
