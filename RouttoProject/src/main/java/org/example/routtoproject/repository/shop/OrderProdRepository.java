package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.OrderProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
public interface OrderProdRepository extends JpaRepository<OrderProd, Integer>{
//    SELECT LP.PROD_ID, LP.PROD_NAME
//    FROM LOTTO_PRODUCT LP, LOTTO_ORDER_PROD OP
//    WHERE LP.PROD_ID = OP.PROD_ID
//    @Query(value = "", countQuery = "", nativeQuery = true)
//    List<>
}