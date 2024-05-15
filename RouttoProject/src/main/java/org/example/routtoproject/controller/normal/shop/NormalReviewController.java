package org.example.routtoproject.controller.normal.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.IReviewDto;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Review;
import org.example.routtoproject.service.shop.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.controller.normal.shop
 * fileName : NormalReviewController
 * author : hayj6
 * date : 2024-05-10(010)
 * description :    todo: 모든 사람들 리뷰 확인 가능
 * }
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
@RequestMapping("/api/normal/shop")
public class NormalReviewController {
    private final ReviewService reviewService;    // DI

    //    TODO: 전체 조회 함수 + 페이징
    @GetMapping("/review")
    public ResponseEntity<Object> findAll(
            @RequestParam(defaultValue = "0") int prodId,
            @RequestParam(defaultValue = "0") int page,      // 현재페이지
            @RequestParam(defaultValue = "3") int size       // 페이지 갯수
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);

            Page<IReviewDto> pageList = reviewService.findByProdId(prodId, pageable);

//            vue로 json 데이터로 전송 : jsp (model : Map(키, 값))
            Map<String, Object> response = new HashMap<>();       // vue는 model이 없기 때문에 직접 Map 구조로 만들어서 보내기

            response.put("reviews", pageList.getContent());          // 리뷰 배열
            response.put("currentPage", pageList.getNumber());    // 현재페이지 번호(필요없음)
            response.put("totalItems", pageList.getTotalPages()); // 전체데이터개수
            response.put("totalPages", pageList.getTotalPages()); // 전체페이지수(필요없음)
            if (pageList.isEmpty() == true) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 데이터가 없으면 response를 보낼필요가 없음
            } else {
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    //    todo: 상세조회 만들기(안씀)
//    @GetMapping("/review/{reviewId}")
//    public ResponseEntity<Object> findById(
//            @PathVariable int reviewId
//    ) {
//        try {
////            상세조회 서비스 실행
//            Optional<Review> reviewOptional
//                    = reviewService.findById(reviewId);
//
//            if (reviewOptional.isEmpty() == true) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            } else {
//                return new ResponseEntity<>(reviewOptional.get(), HttpStatus.OK);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    //    TODO: 리뷰 이미지 파일 다운로드 함수
    @GetMapping("/review/img/{uuid}")
    public ResponseEntity<byte[]> findReviewImg(@PathVariable String uuid) {
        Review review = reviewService.findReviewImgByUuid(uuid).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + review.getReviewId() + "\"")
                .body(review.getReviewImage());
    }

}

