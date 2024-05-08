package org.example.routtoproject.repository.admin;

import org.example.routtoproject.model.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : org.example.routtoproject.repository.admin
 * fileName : AdminRefundRepository
 * author : BALLBAT
 * date : 2024-05-02
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-02         BALLBAT          최초 생성
 */
@Repository
public interface AdminRefundRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_ID = :orderId"
            , nativeQuery = true)
    List<Order> findByOrderId(@Param("orderId") int orderId);

    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_TIME LIKE '%' || :orderTime || '%'"
            , nativeQuery = true)
    List<Order> findByOrderTime(@Param("orderTime") String orderTime);

    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_STATUS LIKE '%' || :orderStatus || '%'"
            , nativeQuery = true)
    List<Order> findByOrderStatus(@Param("orderStatus") String orderStatus);

    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_PRICE = :orderPrice"
            , nativeQuery = true)
    List<Order> findByOrderPrice(@Param("orderPrice") int orderPrice);
}

