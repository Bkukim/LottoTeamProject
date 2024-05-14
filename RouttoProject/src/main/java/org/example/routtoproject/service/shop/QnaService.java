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
    public Page<Qna> selectByTitleContaining(
            Pageable pageable
    ) {
        Page<Qna> page
                = qnaRepository.findQnaByTitleContaining(
                pageable
        );
        return page;
    }

    //   todo: 상품문의 작성글 저장 함수
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

    //    todo : userId가 작성한 글 전체조회
    public Page<Qna> selectByWriterIdContaining(String writerId, Pageable pageable)
    {
        Page<Qna> page
                = qnaRepository.findAllByWriterIdContaining(writerId, pageable);
        return page;
    }

    //    todo: 문의글 삭제
    public boolean removeById(int qnaId) {
//        JPA 삭제함수 : deleteById(기본키)
//        1) 먼저 기본키가 테이블에 있으면 삭제, true 리턴
//           없으면 false 리턴
//        사용법 : jpa레포지토리.existsById(기본키)
//         => 기본키가 테이블에 있으지 확인. 있으면 true, 없으면 false
        if(qnaRepository.existsById(qnaId) == true) {
            qnaRepository.deleteById(qnaId);
            return true;
        } else {
            return false;
        }
    }
}
