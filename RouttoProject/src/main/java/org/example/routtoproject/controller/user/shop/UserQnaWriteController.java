package org.example.routtoproject.controller.user.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Qna;
import org.example.routtoproject.service.shop.QnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class UserQnaWriteController {

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
}
