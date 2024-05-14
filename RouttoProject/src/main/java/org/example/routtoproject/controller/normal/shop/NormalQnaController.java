package org.example.routtoproject.controller.normal.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Qna;
import org.example.routtoproject.model.entity.shop.Review;
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
import java.util.Optional;

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
@RequestMapping("/api/normal/shop")
public class NormalQnaController {

    private final QnaService qnaservice;

    //todo: 전체조회
    @GetMapping("/qna")
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<Qna> qna
                    = qnaservice
                    .selectByTitleContaining(pageable);

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

    //    todo: 상세조회
    @GetMapping("/qna/{qnaId}")
    public ResponseEntity<Object> findById(
            @PathVariable int qnaId
    ) {
        try {
//            상세조회 서비스 실행
            Optional<Qna> optionalQna
                    = qnaservice.findById(qnaId);

            if (optionalQna.isEmpty() == true) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(optionalQna.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
