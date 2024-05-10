package org.example.routtoproject.model.dto.shop;

import lombok.*;

import java.util.Date;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : PaymentDto
 * author : BALLBAT
 * date : 2024-04-30
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-30         BALLBAT          최초 생성
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Integer paymentCode;
    private Integer orderId;
    private String paymentType;
    private Integer totalPrice;
    private String payPg;
    private String approveTime;
    private String payTime;
}
