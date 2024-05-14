package org.example.routtoproject.controller.user.shop;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.controller.user.shop
 * fileName : UserQNAWriteController
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
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user/shop")
public class UserQnaController {

    private final QnaService qnaservice;


    //    todo: 문의글 저장함수
    @PostMapping("/qna/save")
    public ResponseEntity<Object> createQna(
            @RequestBody Qna qna
    ) {
        try {
//            DB 서비스 저장 함수 실행
            Qna qna1 = qnaservice.save(qna);
            log.debug("디버그"+qna1.toString());
//            성공(OK) 메세지 + 저장된객체
            return new ResponseEntity<>(qna1, HttpStatus.OK);
        } catch (Exception e) {
//            500 전송
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 수정 함수 : 수정 버튼 클릭시 실행될 함수
//       수정(update) -> put 방식 -> @PutMapping
    @PutMapping("/qna/update/{qnaId}")
    public ResponseEntity<Object> update(
            @PathVariable int qnaId,
            @RequestBody Qna qna
    ) {
        try {
            Qna qna1 = qnaservice.save(qna);  // 수정
            return new ResponseEntity<>(qna1, HttpStatus.OK);
        } catch (Exception e) {
//            DB 에러 (서버 에러) -> 500 신호(INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 문의글 삭제 함수
    @DeleteMapping("/qna/deletion/{qnaId}")
    public ResponseEntity<Object> delete(
            @PathVariable int qnaId
    ) {
        try {
//            DB 서비스 삭제 함수 실행
            boolean success = qnaservice.removeById(qnaId);

            if (success == true) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                // 삭제 실행 : 0건 삭제(삭제할 데이터 없음)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버(DB) 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    todo: UserId 내글보기 전체조회 만들기
    @GetMapping("/userId/qna")
    public ResponseEntity<Object> findUserId(
            @RequestParam(defaultValue = "") String writerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<Qna> qna
                    = qnaservice
                    .selectByWriterIdContaining(writerId, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("qnaList", qna.getContent());       // faq 배열
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
}
