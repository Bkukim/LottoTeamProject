package org.example.routtoproject.controller.admin.user;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.service.shop.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : org.example.routtoproject.controller.admin.user
 * fileName : AdminFaqAnswer
 * author : KimDJ
 * date : 2024-05-10
 * description : 답변저장 댓글
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-10         KimDJ          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminFaqAnswerController {
    @Autowired
    FaqService faqService;

    //    TODO: 수정 함수 : 수정 버튼 클릭시 실행될 함수
//       수정(update) -> put 방식 -> @PutMapping
    @PutMapping("/faq/updateanswer/{faqId}")
    public ResponseEntity<Object> updateAnswer(
            @PathVariable int faqId,
            @RequestBody Faq faq
    ) {
        log.debug("컨트롤러 진입은 했니?");
        try {
            Faq faq1 = faqService.save(faq);  // 수정
            return new ResponseEntity<>(faq1, HttpStatus.OK);
        } catch (Exception e) {
//            DB 에러 (서버 에러) -> 500 신호(INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
