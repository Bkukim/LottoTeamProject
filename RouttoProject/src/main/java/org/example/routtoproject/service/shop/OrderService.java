package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.ICartDto;
import org.example.routtoproject.model.dto.shop.OrderDto;
import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.OrderProd;
import org.example.routtoproject.repository.shop.OrderProdRepository;
import org.example.routtoproject.repository.shop.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : OrderService
 * author : hayj6
 * date : 2024-04-24(024)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-24(024)         hayj6          최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;          // DI
    private final OrderProdRepository orderProdRepository;  // DI


    ModelMapper modelMapper = new ModelMapper();

    //    TODO: 주문/결제 페이지에서 주문 정보 입력시 DB에 저장하는 함수
    @Transactional
    public Order saveOrder(OrderDto orderDto) {
//        TODO: 1) insert 할 때는 DTO -> Entity 로 변환해서 insert
//              (1) 직접 변환로직 코딩하기 : 숙련자 추천
//              (2) 자동 변환 패키지 : 초보자 추천 (ModelMapper 패키지 : 성능 저하)
//      simpleOrderRepository.save();  // save 함수의 매개변수에는 entity 를 넣어야하는데 Dto를 쓸수없으니 entity로 변환해야함
        log.debug("여기는 service 1 ::: ");

//        TODO: 1) DTO -> Entity로 변환
//         사용법 : modelMapper.map(DTO 클래스, 엔티티명.class);
        Order order = modelMapper.map(orderDto, Order.class);
        log.debug("여기는 service 2 ::: " + order.getOrderAddress());

//        TODO: 2) 부모테이블 저장(부모저장 후 자식저장)
        Order order2 = orderRepository.save(order);
        log.debug("여기는 service 3 ::: " + order2);

//        TODO: 3) 자식테이블도 저장(배열이라서 반복문 돌리기) : 주문상세 테이블(반복문)
//                 DB 트랜잭션(transaction, 거래) :
//                  (1) CUD 작업에 대해 여러개가 있을 경우 중간에 에러가 발생하면 모두 롤백함
//                  (2) 위의 있는 기능을 사용하려면 : @Transaction 함수위에 붙임
        for (int i = 0; i < orderDto.getOrderProds().size(); i++) {
//            자식테이블 insert : 기본키(부모쪽 insert 할 때 시퀀스로 생성되어 있음)
//            생성된 주문번호 -> 주문상세객체에 저장
            OrderProd tmpOrderProd = orderDto.getOrderProds().get(i);
            tmpOrderProd.setOrderId(order2.getOrderId());
//            DB 저장
            log.debug("여기는 service 4 ::: " + tmpOrderProd);
            orderProdRepository.save(tmpOrderProd);
        }
        return order2;    // 저장된 주문 객체
    }

    //   todo: 전체조회 : 관리자 주문확인 페이지에서 사용
    public Page<Order> findAll(String orderTime, String orderStatus, Pageable pageable) {
        Page<Order> page = orderRepository.findAllByOrderIdContaining(orderTime, orderStatus, pageable);
        return page;
    }



    //    todo: 관리자 주문확인 페이지 : 상세보기 클릭 시 나오는 상품 정보
    public List<OrderProductDetailDto> findOrderProdDetail(Integer orderId) {







        List<OrderProductDetailDto> order = orderProdRepository.findAllByorderProdIdContaining(orderId);
        return order;
    }

    //    todo: 관리자 주문확인 페이지 : 주문상태 변경(수정) 함수
    public Order save(Order order) {
        Order order2 = orderRepository.save(order);
        return order2;
    }



//  결제 요청을 위한 함수


    //    todo: user의 장바구니 -> 전체 주문하기  : 상품 정보
    public List<ICartDto> findByUserIdContaining(String userId) {

        List<ICartDto> order = orderProdRepository.findByUserIdContaining(userId);
        return order;
    }


    //  결제 함수


    @Transactional
    //    저장함수
    public Order insert(OrderDto orderDto) {

//     1) DTO -> Model 변환
        Order order = modelMapper.map(orderDto, Order.class);

        Order order2 = orderRepository.save(order); // 부모 테이블 저장

//      자식 테이블 저장
        for (int i = 0; i < orderDto.getOrderProds().size(); i++) {
            orderDto.getOrderProds().get(i).setOrderId(order2.getOrderId()); // 기본키는 부모쪽 값을 넣기
            orderProdRepository.save(orderDto.getOrderProds().get(i));
        }

        return order2;
    }

    //    수정함수 : 카프카에서 사용
    public void update(Order order) {
        orderRepository.save(order);
    }

    //    상세조회
    public Optional<Order> findById(int orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        return optionalOrder;
    }


}
