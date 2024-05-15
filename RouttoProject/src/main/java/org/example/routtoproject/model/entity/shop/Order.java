package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.example.routtoproject.model.entity.auth.User;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.*;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Order
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
@Entity
@Table(name = "LOTTO_ORDER")
@SequenceGenerator(
        name = "SQ_LOTTO_ORDER_GENERATOR"
        , sequenceName = "SQ_LOTTO_ORDER"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString(exclude = "user") // 순환 참조 방지를 위해 user를 제외
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_ORDER_GENERATOR"
    )
    private Integer orderId;
    private String userId;
    private String orderName;
    private Integer orderPrice;
    private Integer shoppingFee;
    private Integer zipCode;
    private String orderAddress;
    private String orderDetailAddress;
    private String orderTime;
    private String orderRequest;
    private String receiver;
    private String paymentType;
    private String orderStatus;
    private String orderChangeTime;
    private String orderChangeReason;

    // Order에서 User로의 다대일 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private User user;
}