package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Integer prodId;       // 기본키, 시퀀스, 상품id
    private String prodName;      // 상품 이름
    private Integer defaultPrice; // 원가
    private String prodCategory;  // 카테고리
    private byte[] prodImg;       // 상품 이미지
    private byte[] prodDetailPage; // 상품 상세 페이지
    private Integer discountRate; // 할인율
    private Integer prodStock;    // 재고
    private String prodStatus;    // 상품 판매 상태
    private Integer soldCount;    // 상품 판매 횟수
    private String prodImgUrl;     // 상품 이미지 url
    private String prodDetailPageUrl; // 상품 상세 이미지 url
    private String prodImgUuid;       // 상품 이미지 uuid
    private String prodDetailPageUuid; // 상품 상세 이미지 uuid


    public Product(String prodName, Integer defaultPrice, String prodCategory, byte[] prodImg, byte[] prodDetailPage, Integer discountRate, Integer prodStock, String prodImgUrl, String prodDetailPageUrl, String prodImgUuid, String prodDetailPageUuid) {
        this.prodName = prodName;
        this.defaultPrice = defaultPrice;
        this.prodCategory = prodCategory;
        this.prodImg = prodImg;
        this.prodDetailPage = prodDetailPage;
        this.discountRate = discountRate;
        this.prodStock = prodStock;
        this.prodImgUrl = prodImgUrl;
        this.prodDetailPageUrl = prodDetailPageUrl;
        this.prodImgUuid = prodImgUuid;
        this.prodDetailPageUuid = prodDetailPageUuid;
    }


}
