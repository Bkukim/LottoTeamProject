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

 Integer getCartId(); // 기본키  시퀀스 장바구니 번호
 String getUserId(); //회원번호
 Integer getCartProdCount(); // 각 상품의 갯수

 Integer getProdId();       // 상품번호
 String getProdName();      // 상품 이름
 Integer getDefaultPrice(); // 원가
 Integer getDiscountRate(); // 할인율
 String getProdImgUrl(); // 상품 이미지 Url
 Integer getProdPrice(); // 할인율 적용한 상품 가격
 Integer getTotalPrice(); // 배송비 포함한 총 가격


}
