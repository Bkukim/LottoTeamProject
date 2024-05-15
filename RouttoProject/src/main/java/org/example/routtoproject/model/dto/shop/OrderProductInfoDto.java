package org.example.routtoproject.model.dto.shop;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : OrderProductInfoDto
 * author : BALLBAT
 * date : 2024-05-14
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-14         BALLBAT          최초 생성
 */
public interface OrderProductInfoDto {
    Integer getOrderAmount();
    String getProdName();
    Integer getDefaultPrice();
    String getProdImgUrl();
}
