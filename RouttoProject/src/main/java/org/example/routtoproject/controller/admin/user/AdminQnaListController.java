package org.example.routtoproject.controller.admin.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Qna;
import org.example.routtoproject.service.shop.QnaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.controller.admin.user
 * fileName : AdminQnaListController
 * author : hayj6
 * date : 2024-05-15(015)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-15(015)         hayj6          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminQnaListController {

    private final QnaService qnaService;

    //todo: 관리자가 QnA 전체조회
    @GetMapping("/qna")
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<Qna> qna = qnaService.findAllQna(pageable);


//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("qnaList", qna.getContent());       // qna 배열
            response.put("currentPage", qna.getNumber());       // 현재페이지번호
            response.put("totalItems", qna.getTotalElements()); // 총건수(개수)
            response.put("totalPages", qna.getTotalPages());    // 총페이지수

            if (qna.isEmpty() == false) {
//                조회 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 관리자 답변 수정 함수 : 수정 버튼 클릭시 실행될 함수
    @PutMapping("/qna/update/{qnaId}")
    public ResponseEntity<Object> updateAnswer(
            @PathVariable int qnaId,
            @RequestBody Qna qna
    ) {
        log.debug("컨트롤러 디버그 ::");
        try {
            Qna qna1 = qnaService.save(qna);  // 수정
            return new ResponseEntity<>(qna1, HttpStatus.OK);
        } catch (Exception e) {
//            DB 에러 (서버 에러) -> 500 신호(INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
