package org.example.routtoproject.controller.normal.user;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.service.shop.AnnouncementService;
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
 * fileName : NomalAnnouncementController
 * author : KimDJ
 * date : 2024-04-29
 * description :
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         KimDJ          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/normal/member")
public class NormalAnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    //    TODO: 전체조회 함수(조인) + like 검색
//    조회(select) -> get 방식 -> @GetMapping
    @GetMapping("/notice")
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<Announcement> announcements
                    = announcementService
                    .selectByTitleContaining(title, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("notice", announcements.getContent());       // simpleCart 배열
            response.put("currentPage", announcements.getNumber());       // 현재페이지번호
            response.put("totalItems", announcements.getTotalElements()); // 총건수(개수)
            response.put("totalPages", announcements.getTotalPages());    // 총페이지수

            if (announcements.isEmpty() == false) {
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

    //    todo: 상세조회 만들기
//    조회(select) -> get 방식 -> @GetMapping
    @GetMapping("/notice/{announcementId}")
    public ResponseEntity<Object> findById(
            @PathVariable int announcementId
    ) {
        try {
//            상세조회 서비스 실행
            Optional<Announcement> optionalSimpleOrder
                    = announcementService.findById(announcementId);

            if (optionalSimpleOrder.isEmpty() == true) {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
//                조회 성공
                return new ResponseEntity<>(optionalSimpleOrder.get(), HttpStatus.OK);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
