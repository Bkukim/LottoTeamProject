package org.example.routtoproject.model.dto.shop;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : AdBannerDto
 * author : PC
 * date : 2024-05-07
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-07         PC          최초 생성
 */
public interface AdBannerDto {
    String getBannerId();

    int getProdId();

    String getProdName();

    String getBannerTitle();

    String getBannerContent();

    byte[] getBannerImg1();

    byte[] getBannerImg2();

    String getBannerImg1Url();

    String getBannerImg1Uuid();

    String getBannerImg2Url();

    String getBannerImg2Uuid();
}
