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
//  클라이언트(웹 브라우저)에서 사용자에게 전달 필요한 정보들
//  클라이언트 : 서버와 상호작용하고 서비스 이용, 사용자의 요청을 받아 서버에 전달하고, 서버로부터 받은 응답을 사용자에게 보여준다.
private Integer orderId;
    private String userId;
    private String orderName;
    private Integer orderPrice;
    private Integer shoppingFee;
    private Integer zipCode;
    private String orderAddress;
    private String orderDetailAddress;
    private String orderRequest;
    private String receiver;
    private List<OrderProd> orderProds;
}
