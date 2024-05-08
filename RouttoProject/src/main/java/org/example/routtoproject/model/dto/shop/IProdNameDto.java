package org.example.routtoproject.model.dto.shop;

import jakarta.persistence.criteria.CriteriaBuilder;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : IProdNameDto
 * author : hayj6
 * date : 2024-05-07(007)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-07(007)         hayj6          최초 생성
 */
public interface IProdNameDto {
//    SELECT PROD_ID AS prodId
//, PROD_NAME AS prodName
//, PROD_STATUS AS prodStatus
//, PROD_CATEGORY AS prodCategory
//, PROD_STOCK AS prodStock
//    FROM LOTTO_PRODUCT
//    WHERE PROD_NAME LIKE '%%'
//    todo: Product.java에는 이미지도 있음. 로딩하려면 시간 많이 걸려서 Dto만듬
    Integer getProdId();
    String getProdName();
    String getProdStatus();
    String getProdCategory();
    Integer getDefaultPrice();
    Integer getDiscountRate();
    Integer getProdPrice();
    Integer getProdStock();
}
