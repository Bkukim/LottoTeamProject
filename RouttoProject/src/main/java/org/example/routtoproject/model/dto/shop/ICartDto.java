package org.example.routtoproject.model.dto.shop;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : ICartDto
 * author : KimDJ
 * date : 2024-04-29
 * description :
 * 요약 : 복합키
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         KimDJ          최초 생성
 */
public interface ICartDto {

    Integer getCartId(); // 기본키  시퀀스 장바구니 번호

    String getUserId(); //회원번호

    Integer getCartProdCount();

    String getProdImgUrl();

    Integer getProdId();       // 상품번호

    String getProdName();      // 상품 이름

    Integer getDefaultPrice(); // 원가

    Integer getDiscountRate(); // 할인율

}
