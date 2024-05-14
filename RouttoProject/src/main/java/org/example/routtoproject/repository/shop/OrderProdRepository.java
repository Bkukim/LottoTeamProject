package org.example.routtoproject.repository.shop;

import jakarta.transaction.Transactional;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.entity.shop.OrderProd;
import org.springframework.data.domain.Pageable;
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


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LOTTO_ORDER_PROD\n" +
            "WHERE ORDER_ID = :orderId"
    ,nativeQuery = true)
    void deleteOrderProdId(@Param("orderId") Integer orderId);
}