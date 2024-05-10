package org.example.routtoproject.controller.user.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Review;
import org.example.routtoproject.service.shop.ReviewService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
