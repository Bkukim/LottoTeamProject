package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Cart
 * author : hayj6
 * date : 2024-04-22(022)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-22(022)         hayj6          최초 생성
 */
@Entity
@Table(name = "LOTTO_CART")
@SequenceGenerator(
        name = "SQ_LOTTO_CART_GENERATOR"
        , sequenceName = "SQ_LOTTO_CART"
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
public class Cart extends BaseTimeEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE
        , generator = "SQ_LOTTO_CART_GENERATOR"
)
    private Integer cartId;
    private Integer userId;
    private Integer prodId;
    private Integer cartProdCount;
    private String insertTime;
}
