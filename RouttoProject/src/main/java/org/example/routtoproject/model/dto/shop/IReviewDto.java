package org.example.routtoproject.model.dto.shop;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : IReviewDto
 * author : PC
 * date : 2024-05-14
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-14         PC          최초 생성
 */
public interface IReviewDto {
    Integer getReviewId();
    String getUserId();
    Integer getPoint();
    Integer getProdId();
    String getReviewContent();
    String getReviewImgUrl();
    String getReviewImgUuid();
}
