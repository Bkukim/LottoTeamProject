package org.example.routtoproject.service.payment;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.repository.payment.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * packageName : org.example.routtoproject.service.payment
 * fileName : PaymentService
 * author : BALLBAT
 * date : 2024-04-28
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-28         BALLBAT          최초 생성
 */
@Slf4j
@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

//  정보 저장
    ModelMapper modelMapper = new ModelMapper();

}
