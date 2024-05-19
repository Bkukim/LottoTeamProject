package org.example.routtoproject.controller.user.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Qna;
import org.example.routtoproject.model.entity.shop.Review;
import org.example.routtoproject.service.shop.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.controller.user.shop
 * fileName : UserReviewController
 * author : hayj6
 * date : 2024-05-10(010)
 * description :    todo: user만 리뷰 작성 가능
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-10(010)         hayj6          최초 생성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user/shop")
public class UserReviewWriteController {
    private final ReviewService reviewService;    // DI

    //    todo: UserId 리뷰 내글보기 전체조회 만들기
    @GetMapping("/userId/review")
    public ResponseEntity<Object> findUserId(
            @RequestParam(defaultValue = "") String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            페이징 객체 생성
            Pageable pageable = PageRequest.of(page, size);

//            전체 조회 서비스 실행
            Page<Review> review
                    = reviewService.findReviewsByUserIdContaining(userId, pageable);

//            공통 페이징 객체 생성 : 자료구조 맵 사용
            Map<String, Object> response = new HashMap<>();
            response.put("reviewList", review.getContent());       // faq 배열
            response.put("currentPage", review.getNumber());       // 현재페이지번호
            response.put("totalItems", review.getTotalElements()); // 총건수(개수)
            response.put("totalPages", review.getTotalPages());    // 총페이지수

            if (review.isEmpty() == false) {
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

    //    todo: 리뷰 작성 내용 저장함수
    @PostMapping("/review/save")
    public ResponseEntity<Object> createReview(@RequestParam(defaultValue = "") String userId,
                                               @RequestParam(defaultValue = "0") Integer prodId,
                                               @RequestParam(defaultValue = "0") Integer point,
                                               @RequestParam(defaultValue = "") String reviewContent,
                                               @RequestParam MultipartFile reviewImage,

                                               @RequestParam (defaultValue = "")String reviewImgUrl,
                                               @RequestParam (defaultValue = "")String reviewImgUuid
    ) {
        try {
            reviewService.save(
                    userId,
                    prodId,
                    point,
                    reviewContent,
                    reviewImage,
                    reviewImgUrl,
                    reviewImgUuid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug("이미지 추가" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
