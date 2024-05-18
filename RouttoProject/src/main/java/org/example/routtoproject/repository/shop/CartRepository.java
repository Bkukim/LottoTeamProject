package org.example.routtoproject.repository.shop;

import jakarta.transaction.Transactional;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Cart;
import org.example.routtoproject.model.entity.shop.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.shop.product
 * fileName : CartRepository
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
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    //    장바구니 전체 조인 ::검색필요없음
//    TODO: prod이미지

    @Query(value = "SELECT LC.CART_ID AS cartId,\n" +
            "LC.USER_ID AS userId,\n" +
            "LC.CART_PROD_COUNT AS cartProdCount,\n" +
            "LP.PROD_ID AS prodId,\n" +
            "LP.PROD_NAME AS prodName,\n" +
            "LP.PROD_IMG_URL AS prodImgUrl,\n" +
            "LP.DEFAULT_PRICE AS defaultPrice,\n" +
            "LP.DISCOUNT_RATE AS discountRate\n" +
            "FROM LOTTO_CART LC, LOTTO_PRODUCT LP\n" +
            "WHERE LC.PROD_ID = LP.PROD_ID\n" +
            "AND LC.USER_ID = :userId",
            countQuery = "SELECT count(*)\n" +
                    "FROM LOTTO_CART LC, LOTTO_PRODUCT LP\n" +
                    "WHERE LC.PROD_ID = LP.PROD_ID",
            nativeQuery = true)
    Page<ICartDto> selectByTitleContaining(@Param("userId") String userId, Pageable pageable);

    //    todo: user의 cart에서 전체 주문하기로 들어오면 뜨는 주문페이지
    @Query(value = "SELECT LU.USER_ID AS userId,\n" +
            "LC.PROD_ID AS prodId,\n" +
            "Lp.PROD_NAME AS prodName,\n" +
            "LP.PROD_IMG_URL  AS prodImgUrl,\n" +
            "LP.DEFAULT_PRICE * (1-LP.DISCOUNT_RATE/100) AS prodPrice,\n" +
            "LC.CART_PROD_COUNT AS cartProdCount,\n" +
            "LP.DEFAULT_PRICE * (1-LP.DISCOUNT_RATE/100)*LC.CART_PROD_COUNT AS totalPrice\n" +
            "FROM LOTTO_USER LU, LOTTO_CART LC, LOTTO_PRODUCT LP\n" +
            "WHERE LU.USER_ID = LC.USER_ID\n" +
            "AND LC.PROD_ID = LP.PROD_ID\n" +
            "AND LC.USER_ID = :userId"
            , nativeQuery = true)
    List<ICartDto> findByUserIdContaining(@Param("userId") String userId);

    @Query(value = "SELECT CART_ID FROM LOTTO_CART\n" +
            "WHERE PROD_ID = :prodId AND USER_ID = :userId"
            , nativeQuery = true)
    public Integer existsByProdId(@Param("prodId") int prodId, @Param("userId") String userId);


    //    TODO: 카트 프로드 카운트 업데이트 ::수량수정용
    @Transactional
    @Modifying
    @Query(value = "UPDATE lotto_cart \n" +
            "SET cart_prod_count=:cartProdCount \n" +
            "WHERE user_id=:userId \n" +
            "And prod_id=:prodId"
            , nativeQuery = true)
    public void updateCartProdCount(
            @Param("cartProdCount") Integer cartProdCount,
            @Param("userId") String userId,
            @Param("prodId") Integer prodId);

//todo : 해당유저 카트 초기화 함수
    @Transactional //여러가지 수정
    public void deleteByUserId(String userId);
}