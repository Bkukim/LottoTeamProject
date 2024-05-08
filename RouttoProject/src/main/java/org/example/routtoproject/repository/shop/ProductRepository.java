package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.dto.shop.IProdNameDto;
import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.shop.product
 * fileName : ProductRepository
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
public interface ProductRepository extends JpaRepository<Product, Integer> {


    Optional<Product> findByProdImgUuid(String prodImgUuid);
    Optional<Product> findByProdDetailPageUuid(String prodDetailPageUuid);

    @Query(value = "SELECT * FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_NAME LIKE '%' || :prodName || '%'"
            ,countQuery = "SELECT count(*) FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_NAME LIKE '%' || :prodName || '%'"
            ,nativeQuery = true
    )
    Page<Product> findAllByProdNameContaining(@Param("prodName") String prodName,
                                           Pageable pageable
    );


    //    todo: 상품명으로 조회하는 SELECT 쿼리문
    @Query(value = "SELECT PROD_ID AS prodId\n" +
            ", PROD_NAME AS prodName\n" +
            ", PROD_STATUS AS prodStatus\n" +
            ", PROD_CATEGORY AS prodCategory\n" +
            ", CEIL(DEFAULT_PRICE - (DEFAULT_PRICE * DISCOUNT_RATE) / 100) AS prodPrice\n" +
            ", PROD_STOCK AS prodStock\n" +
            "FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_NAME LIKE '%'|| :prodName ||'%'\n" +
            "ORDER BY PROD_ID"
            , nativeQuery = true
    )
    List<IProdNameDto> findByProdName(@Param("prodName") String prodName);

}