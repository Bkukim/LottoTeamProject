package org.example.routtoproject.model.dto.shop;

import lombok.*;
import org.example.routtoproject.model.entity.shop.OrderProd;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : OrderDto
 * author : hayj6
 * date : 2024-04-25(025)
 * description : TODO: 주문 페이지에서 필요한 정보를 포함하는 Dto
 * TODO: 주문 페이지에서 클라이언트로부터 받은 주문 항목의 정보를 담음
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-25(025)         hayj6          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer orderId;
    private String userId;
    private String orderName;
    private Integer orderPrice; // 최종 상품 가격
    private Integer shoppingFee; // 배송비
    private Integer zipCode;
    private String orderAddress;
    private String orderDetailAddress;
    private String orderTime;
    private String orderRequest;
    private String receiver;
    private String orderStatus;
    private String orderChangeTime;
    private String orderChangeReason;
    private List<OrderProd> orderProds;
}
