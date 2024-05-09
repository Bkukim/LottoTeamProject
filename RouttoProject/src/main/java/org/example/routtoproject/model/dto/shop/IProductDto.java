package org.example.routtoproject.model.dto.shop;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : IProductDto
 * author : hayj6
 * date : 2024-05-01(001)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-01(001)         hayj6          최초 생성
 */
public interface IProductDto {
    Integer getProdId();
    String getProdName();
    String getDefaultPrice();
    String getDiscountRate();
    String getProdPrice();
    String getProdImgUrl();
}
