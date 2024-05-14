package org.example.routtoproject.repository.shop;

import jakarta.transaction.Transactional;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.dto.shop.OrderProductInfoDto;
import org.example.routtoproject.model.entity.shop.OrderProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : OrderProdRepository
 * author : hayj6
 * date : 2024-04-25(025)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-25(025)         hayj6          최초 생성
 */
@Repository
public interface OrderProdRepository extends JpaRepository<OrderProd, Integer> {

    //    todo: 상품의 상품id = 주문상품의 상품id 인 상품의 정보들을 불러와서 상세페이지에 띄우기
//          예) 상품id가 95번인 상품-상품상세 테이블 조인
    @Query(value = "SELECT LP.PROD_NAME AS prodName" +
            ", OP.ORDER_AMOUNT AS orderAmount" +
            ", LP.PROD_IMG_URL AS prodImgUrl" +
            ", LP.DEFAULT_PRICE * (1-LP.DISCOUNT_RATE/100)*OP.ORDER_AMOUNT + 3000 AS totalPrice\n" +
            "            FROM LOTTO_PRODUCT LP, LOTTO_ORDER_PROD OP\n" +
            "            WHERE LP.PROD_ID = OP.PROD_ID\n" +
            "            AND OP.ORDER_ID = :orderId",
            nativeQuery = true)
    List<OrderProductDetailDto> findAllByorderProdIdContaining(@Param("orderId") Integer orderId);

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

//  TODO: 주문 정보 삭제 : 자식 테이블의 orderProdId 삭제를 위한 쿼리
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LOTTO_ORDER_PROD\n" +
            "WHERE ORDER_ID = :orderId"
    ,nativeQuery = true)
    void deleteOrderProdId(@Param("orderId") Integer orderId);

//  TODO: orderId 로 주문 상품 정보 조회 쿼리
@Query(value = "SELECT OP.ORDER_PROD_ID FROM LOTTO_ORDER OD, LOTTO_ORDER_PROD OP WHERE OD.ORDER_ID = OP.ORDER_ID AND OD.ORDER_ID = :orderId", nativeQuery = true)
List<Integer> findOrderProdIdsByOrderIdNative(int orderId);

//  TODO: 주문 상품 정보 조회 쿼리
@Query(value = "SELECT OP.ORDER_AMOUNT AS orderAmount," +
        " PR.PROD_NAME AS prodName," +
        "PR.DEFAULT_PRICE AS defaultPrice," +
        " PR.PROD_IMG_URL AS prodImgUrl " +
        "FROM LOTTO_ORDER_PROD OP, LOTTO_PRODUCT PR " +
        "WHERE OP.PROD_ID = PR.PROD_ID AND OP.ORDER_PROD_ID = :orderProdId", nativeQuery = true)
List<OrderProductInfoDto> findOrderProductDetails(@Param("orderProdId") int orderProdId);
}