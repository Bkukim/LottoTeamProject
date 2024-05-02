package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.entity.shop.OrderProd;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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

    @Query(value = "SELECT LP.PROD_IMG, LP.PROD_IMG_URL, LP.PROD_IMG_UUID, LP.PROD_NAME, OP.ORDER_AMOUNT, LP.DEFAULT_PRICE * (1-LP.DISCOUNT_RATE/100)*OP.ORDER_AMOUNT + 3000 AS TOTAL_PRICE\n" +
            "FROM LOTTO_PRODUCT LP, LOTTO_ORDER_PROD OP\n" +
            "WHERE LP.PROD_ID = OP.PROD_ID",
            nativeQuery = true)
    List<OrderProductDetailDto> findAllByOrderProdIdContaining(@Param("prodId") String prodId);
}