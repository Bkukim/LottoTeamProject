package org.example.routtoproject.controller.user.member;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.service.shop.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.controller.normal.user
 * fileName : NormalFaqController
 * author : KimDJ
 * date : 2024-05-01
 * description :
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-01         KimDJ          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/user/member")
public class UserFaqController {
    @Autowired
    FaqService faqService; //di

//    todo: UserId 내글보기 전체조회 만들기
    @GetMapping("/userid/faq")
    public ResponseEntity<Object> findUserId(
            @RequestParam(defaultValue = "") String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            log.debug("userID"+userId);
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<Faq> faq
                    = faqService
                    .selectByUserIdContaining(userId, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("faqList", faq.getContent());       // faq 배열
            response.put("currentPage", faq.getNumber());       // 현재페이지번호
            response.put("totalItems", faq.getTotalElements()); // 총건수(개수)
            response.put("totalPages", faq.getTotalPages());    // 총페이지수

            if (faq.isEmpty() == false) {
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

    //    todo: 저장함수
    @PostMapping("/faq/save")
    public ResponseEntity<Object> createFaq(
            @RequestBody Faq faq
    ) {
        try {
//            DB 서비스 저장 함수 실행
            Faq faq1 = faqService.save(faq);
//            성공(OK) 메세지 + 저장된객체
            return new ResponseEntity<>(faq1, HttpStatus.OK);
        } catch (Exception e) {
//            500 전송
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 수정 함수 : 수정 버튼 클릭시 실행될 함수
//       수정(update) -> put 방식 -> @PutMapping
    @PutMapping("/faq/update/{faqId}")
    public ResponseEntity<Object> update(
            @PathVariable int faqId,
            @RequestBody Faq faq
    ) {
        try {
//            수정함수 잘되다가 0513 404에러남
            log.debug("오류나용 컨트롤 들어오니?");
            Faq faq1 = faqService.save(faq);  // 수정
            return new ResponseEntity<>(faq1, HttpStatus.OK);
        } catch (Exception e) {
//            DB 에러 (서버 에러) -> 500 신호(INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 삭제 함수
    @DeleteMapping("/faq/deletion/{faqId}")
    public ResponseEntity<Object> delete(
            @PathVariable int faqId
    ) {
        try {
//            DB 서비스 삭제 함수 실행
            boolean success = faqService.removeById(faqId);

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

}
