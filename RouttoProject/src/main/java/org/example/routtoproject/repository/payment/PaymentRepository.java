package org.example.routtoproject.repository.payment;

import org.example.routtoproject.model.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
