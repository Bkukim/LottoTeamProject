package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.dto.shop.IProdNameDto;
import org.example.routtoproject.model.dto.shop.IProductDto;
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


    // todo 상품 홈페이지에서 사진만 띄울건데 너무 많은 정보가 보여져서 필요한 것만 담기 위해 만드는 함수

    @Query(value = "SELECT PROD_ID AS prodId,\n" +
            "PROD_NAME AS prodName,\n" +
            "DEFAULT_PRICE AS defaultPrice,\n" +
            "DISCOUNT_RATE AS discountRate,\n" +
            "DEFAULT_PRICE*(100-DISCOUNT_RATE)/100 AS prodPrice,\n" +
            "PROD_IMG_URL AS prodImgUrl\n" +
            "FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "AND PROD_CATEGORY = :prodCategory\n" +
            "ORDER BY SOLD_COUNT"
            ,countQuery = "SELECT count(*) FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "AND PROD_CATEGORY = :prodCategory\n" +
            "ORDER BY SOLD_COUNT"
              ,nativeQuery = true)
    Page<IProductDto> findAllByProdCategory(@Param("prodCategory") String prodCategory, Pageable pageable);

// todo 판매량 별로 조회 함수
    @Query(value = "SELECT PROD_ID AS prodId,\n" +
            "PROD_NAME AS prodName,\n" +
            "DEFAULT_PRICE AS defaultPrice,\n" +
            "DISCOUNT_RATE AS discountRate,\n" +
            "DEFAULT_PRICE*(100-DISCOUNT_RATE)/100 AS prodPrice,\n" +
            "PROD_IMG_URL AS prodImgUrl\n" +
            "FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "ORDER BY SOLD_COUNT"
            ,countQuery = "SELECT count(*) FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "ORDER BY SOLD_COUNT"
             ,nativeQuery = true)
    Page<IProductDto> findAllBySoldCount(Pageable pageable);


   //    todo: 상품명으로 조회하는 SELECT 쿼리문
    @Query(value = "SELECT PROD_ID AS prodId,\n" +
            "PROD_NAME AS prodName,\n" +
            "DEFAULT_PRICE AS defaultPrice,\n" +
            "DISCOUNT_RATE AS discountRate,\n" +
            "DEFAULT_PRICE*(100-DISCOUNT_RATE)/100 AS prodPrice,\n" +
            "PROD_IMG_URL AS prodImgUrl\n" +
            "FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "AND PROD_NAME LIKE '%' ||:prodName ||'%'\n" +
            "ORDER BY SOLD_COUNT"
            ,countQuery = "SELECT count(*) FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "AND PROD_NAME LIKE '%' ||:prodName ||'%'\n" +
            "ORDER BY SOLD_COUNT"
            ,nativeQuery = true)
    Page<IProductDto> findAllByProdNameContaining(@Param("prodName") String prodName,
                                           Pageable pageable
    );

    //    todo: 많이 팔린 순으로 조회하는 SELECT 쿼리문
    @Query(value = "SELECT PROD_ID AS prodId,\n" +
            "PROD_NAME AS prodName,\n" +
            "DEFAULT_PRICE AS defaultPrice,\n" +
            "DISCOUNT_RATE AS discountRate,\n" +
            "DEFAULT_PRICE*(100-DISCOUNT_RATE)/100 AS prodPrice,\n" +
            "PROD_IMG_URL AS prodImgUrl\n" +
            "FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_STOCK <> 0 AND PROD_STATUS = '판매중'\n" +
            "ORDER BY SOLD_COUNT FETCH FIRST 4 ROWS ONLY"

            ,nativeQuery = true)
    List<IProductDto> findAllImg();

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


    @Query(value = "SELECT * FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_IMG_UUID = :prodImgUuid"
            ,nativeQuery = true)
    Optional<Product> findByProdImgUuid(String prodImgUuid);

    @Query(value = "SELECT * FROM LOTTO_PRODUCT\n" +
            "WHERE PROD_DETAIL_PAGE_UUID = :prodDetailPageUuid"
            ,nativeQuery = true)
    Optional<Product> findByProdDetailPageUuid(String prodDetailPageUuid);

}