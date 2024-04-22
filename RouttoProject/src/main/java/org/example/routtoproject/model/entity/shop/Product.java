package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Product
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
@Table(name = "LOTTO_PRODUCT")
@SequenceGenerator(
        name = "SQ_LOTTO_PRODUCT_GENERATOR"
        , sequenceName = "SQ_LOTTO_PRODUCT"
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
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_PRODUCT_GENERATOR"
    )
    private Integer prodId;     // 기본키, 시퀀스, 상품id
    private String prodName;
    private Integer defaultPrice;
    private String prodCategory;
    private byte[] prodImg;
    private byte[] prodDetailPage;
    private Integer discountRate;
    private Integer prodStock;
    private String prodStatus;
    private Integer soldCount;
}
