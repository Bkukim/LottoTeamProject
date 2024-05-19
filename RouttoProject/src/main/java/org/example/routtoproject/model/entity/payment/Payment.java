package org.example.routtoproject.model.entity.payment;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate; 

import java.util.Date;

/**
 * packageName : org.example.routtoproject.model.entity.payment
 * fileName : Payment
 * author : BALLBAT
 * date : 2024-04-27
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-27         BALLBAT          최초 생성
 */
@Entity
@Table(name = "LOTTO_PAYMENT")
@SequenceGenerator(
        name = "SQ_LOTTO_PAYMENT_GENERATOR"
        , sequenceName = "SQ_LOTTO_PAYMENT"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_PAYMENT_GENERATOR"
    )
    private Integer paymentCode;
    private Integer orderId;
    private String paymentType;
    private Integer totalPrice;
    private String payPg;
    private String approveTime;
    private String payTime;
}
