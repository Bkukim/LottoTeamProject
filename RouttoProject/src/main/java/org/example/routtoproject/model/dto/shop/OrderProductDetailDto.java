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
//    Integer getProdId();
//    Integer getOrderId();
//    String getProdImg();        // 상품 이미지
    String getProdName();       // 상품 이름
    Integer getOrderAmount();   // 상품 수량
    Integer getTotalPrice();       // 최종 상품 가격

}
