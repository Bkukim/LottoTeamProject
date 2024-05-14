package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Qna;
import org.example.routtoproject.model.entity.shop.Review;
import org.example.routtoproject.repository.shop.QnaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : QNAService
 * author : hayj6
 * date : 2024-05-13(013)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-13(013)         hayj6          최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class QnaService {
    private final QnaRepository qnaRepository;

    //    todo: 상품문의 전체 조회 + 페이징
    public Page<Qna> findByProdId(int prodId,
            Pageable pageable
    ) {
        Page<Qna> page
                = qnaRepository.findByProdId(prodId,
                pageable
        );
        return page;
    }

    // todo: 상품문의 작성글 저장 함수
    public Qna save(Qna qna) {
//        JPA 저장 함수 실행 : return 값 : 저장된 객체
        Qna qna1 = qnaRepository.save(qna);
        return qna1;
    }

    //    TODO: 문의글 상세조회
    public Optional<Qna> findById(int qnaId) {
        Optional<Qna> qna = qnaRepository.findById(qnaId);
        return qna;
    }
}
