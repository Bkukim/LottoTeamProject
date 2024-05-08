package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.entity.shop.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
//    장바구니 전체 조인 ::검색필요없음 :: 삭제됐늕 묻는 컬럼 필요없나?
    @Query(value = "SELECT LC.CART_ID AS cartId,\n" +
            "LC.USER_ID             AS userId,\n" +
            "LC.CART_PROD_COUNT     AS cartProdCount,\n" +
            "LP.PROD_ID             AS prodId,\n" +
            "LP.PROD_NAME           AS prodName,\n" +
            "LP.DEFAULT_PRICE       AS defaultPrice,\n" +
            "LP.DISCOUNT_RATE       AS discountRate\n" +
            "FROM LOTTO_CART LC, LOTTO_PRODUCT LP\n" +
            "WHERE LC.PROD_ID = LP.PROD_ID",
    countQuery = "SELECT count(*)\n" +
            "FROM LOTTO_CART LC, LOTTO_PRODUCT LP\n" +
            "WHERE LC.PROD_ID = LP.PROD_ID",
    nativeQuery = true)
    Page<ICartDto> selectByTitleContaining(@Param("title") String title, Pageable pageable);

    @Query(value = "SELECT CART_ID FROM LOTTO_CART\n" +
            "WHERE PROD_ID = :prodId"
            , nativeQuery = true)
    public Integer existsByProdId(@Param("prodId") int prodId);
}