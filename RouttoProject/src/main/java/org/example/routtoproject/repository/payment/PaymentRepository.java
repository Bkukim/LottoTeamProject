package org.example.routtoproject.repository.payment;

import org.example.routtoproject.model.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.routtoproject.repository.payment
 * fileName : PaymentRepository
 * author : BALLBAT
 * date : 2024-04-28
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-28         BALLBAT          최초 생성
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query(value = "SELECT PA.PAYMENT_CODE " +
            "FROM LOTTO_ORDER OD, LOTTO_PAYMENT PA " +
            "WHERE OD.ORDER_ID = PA.ORDER_ID " +
            "AND OD.ORDER_ID = :orderId", nativeQuery = true)
    int findPaymentCodeByOrderId(int orderId);
}
