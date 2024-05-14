package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : OrderRepository
 * author : hayj6
 * date : 2024-04-23(023)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23(023)         hayj6          최초 생성
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    //    todo 관리자 : 주문일과 주문상태로 조회하는 SELECT 쿼리문
    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_TIME LIKE '%'|| :orderTime ||'%' AND ORDER_STATUS LIKE '%'|| :orderStatus ||'%'"
            , countQuery = "SELECT count(*) FROM LOTTO_ORDER\n" +
            "WHERE ORDER_TIME LIKE '%'|| :orderTime ||'%' AND ORDER_STATUS LIKE '%'|| :orderStatus ||'%'"

            , nativeQuery = true
    )
    Page<Order> findAllByOrderIdContaining(@Param("orderTime") String orderTime, @Param("orderStatus") String orderStatus,
                                           Pageable pageable);

    // todo 마이페이지에서 현재 주문 상태 보여주는 함수
    @Query(value = "SELECT *\n" +
            "FROM LOTTO_ORDER\n" +
            "WHERE USER_ID = :userId\n" +
           "AND TO_DATE(ORDER_TIME, 'YYYY-MM-DD HH24:MI:SS')>= SYSDATE - INTERVAL '3' MONTH"
    ,nativeQuery = true)
    List<Order> findAllByUserId(@Param("userId") String userId);

//  TODO: 주문 완료 페이지 조회 쿼리문
//@Query(value = "SELECT LO.ORDER_ID, LOP.ORDER_PROD_ID, LP.PROD_ID \n" +
//        "FROM LOTTO_ORDER LO\n" +
//        "JOIN LOTTO_ORDER_PROD LOP ON LO.ORDER_ID = LOP.ORDER_ID\n" +
//        "JOIN LOTTO_PRODUCT LP ON LOP.PROD_ID = LP.PROD_ID\n" +
//        "WHERE LO.ORDER_ID = :orderId\n" +
//        "AND LOP.ORDER_PROD_ID = :orderProdId\n" +
//        "AND LP.PROD_ID = :prodId")
//OrderInfoDto findLottoData(@Param("orderId") int orderId, @Param("orderProdId") int orderProdId, @Param("prodId") int prodId);
    @Query(value = "SELECT * FROM LOTTO_ORDER\n" +
            "WHERE ORDER_ID = :orderId", nativeQuery = true)
    List<Order> findByOrderId(@Param("orderId") Integer orderId);

//  TODO: orderId로 user_phoneNum 조회 쿼리문
//    @Query(value = "SELECT US.PHONE_NUM\n" +
//            "FROM LOTTO_ORDER OD, LOTTO_USER US\n" +
//            "WHERE OD.USER_ID = US.USER_ID\n" +
//            "AND OD.ORDER_ID = :orderId", nativeQuery = true)
//    Optional<Object[]> findPhoneNum(@Param("orderId") int orderId);
@Query("SELECT o.user.phoneNum FROM Order o WHERE o.orderId = :orderId")
String findPhoneNum(@Param("orderId") Integer orderId);
}

