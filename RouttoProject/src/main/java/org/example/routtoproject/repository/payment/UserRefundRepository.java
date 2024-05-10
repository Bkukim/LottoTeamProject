package org.example.routtoproject.repository.payment;

import org.example.routtoproject.model.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : org.example.routtoproject.repository.payment
 * fileName : UserRefundRepository
 * author : BALLBAT
 * date : 2024-05-08
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-08         BALLBAT          최초 생성
 */
public interface UserRefundRepository extends JpaRepository<Order, Integer> {
}
