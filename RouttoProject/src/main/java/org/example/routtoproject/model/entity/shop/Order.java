package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

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
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Order extends BaseTimeEntity {
//    order_id	number
//    user_id	varchar2(255 byte)
//    order_name	varchar2(255 byte)
//    order_price	number
//    shopping_fee	number
//    zip_code	number
//    order_address	varchar2(255 byte)
//    order_detail_address	varchar2(255 byte)
//    order_time	date
//    order_request	varchar2(1000 byte)
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
    private Date orderTime;
    private String orderRequest;
    private String receiver;
}