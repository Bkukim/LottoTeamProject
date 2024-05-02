package org.example.routtoproject.model.dto.shop;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : OrderProductDetailDto
 * author : hayj6
 * date : 2024-05-02(002)
 * description :    todo: 관리자 주문확인페이지 -> 상세보기 클릭 시 상품 상세보기 화면
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-02(002)         hayj6          최초 생성
 */
public interface OrderProductDetailDto {
    Integer getProdId();
    Integer getOrderId();
    String getProdName();
    Integer getOrderAmount();
    Integer orderPrice(); // 최종 상품 가격

}
