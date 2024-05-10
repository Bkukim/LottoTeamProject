package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : OrderDetail
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
@Table(name = "LOTTO_ORDER_PROD")
@SequenceGenerator(
        name = "SQ_LOTTO_ORDER_PROD_GENERATOR"
        , sequenceName = "SQ_LOTTO_ORDER_PROD"
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
public class OrderProd {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_ORDER_PROD_GENERATOR"
    )
    private Integer orderProdId;
    private int prodId;
    private int orderId;
    private int orderAmount;
}
