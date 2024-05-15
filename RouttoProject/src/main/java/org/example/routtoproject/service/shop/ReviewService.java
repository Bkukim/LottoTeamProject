package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.member.AnnouncementAllDto;
import org.example.routtoproject.model.dto.shop.IReviewDto;
import org.example.routtoproject.model.dto.shop.OrderProductDetailDto;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Review;
import org.example.routtoproject.repository.shop.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : ReviewService
 * author : hayj6
 * date : 2024-05-10(010)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-10(010)         hayj6          최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;



//    todo: review 전체 조회 + 페이징

public Page<Review> findAll(Pageable pageable) {
    Page<Review> page = reviewRepository.findReviewByTitleContaining(pageable);

    return page;
}



//    todo: review 상세 조회
public Optional<Review> findById(Integer reviewId) {
    Optional<Review> review = reviewRepository.findById(reviewId);
    return review;
}

//    todo: user -> review 저장 함수
    public Review save(String userId,
                       int prodId,
                       int point,
                       String reviewContent,
                       MultipartFile reviewImage,
                       String reviewImgUrl, // 파일 업로드 클래스로, 이 형태로 파일이 이동되므로 이 형태로 파일을  받아야한다는 거을 정해주는 것.
                       String reviewImgUuid // 파일 업로드 클래스로, 이 형태로 파일이 이동되므로 이 형태로 파일을  받아야한다는 거을 정해주는 것.
    ) { // 파일을 만들때는 예외처리가 필요하다. 그리고 매개변수를 객체로 받으면 복잡할 수 있어서 변수로 받는다.
        Review review2 = null;
        try{
//            null 아님 -> "" 고침
            if (reviewImgUrl.equals("")) {
                // todo : 기본키가 없을때 : insert
                //      1-1) uuid 생성하기
                reviewImgUuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T
                // xxxx-xxxx-xxxx-xx...이런 형태로 만들어진다. 근데 "-"가 보기 좋지 않으니 없애보자. replace 함수 이용

                // todo  1-2) 다운로드 url 생성 -> 자바함수를 이용 ※여기서 다운로드란 jsp이 spring에서 이미지를 다운받아 가져오는 것.
                String reviewImgDownload = ServletUriComponentsBuilder
                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                        .path("/api/normal/shop/review/img/") // 추가 경로 넣기 : /advanced/fileDb
                        .path(reviewImgUuid) // uuid를 url 제일 마지막에 넣어주기
                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.

                // todo  1-3) 생성자에 만든 url넣어주기
                Review review = new Review(userId,
                        prodId,
                        point,
                        reviewContent,
                        reviewImage.getBytes(), // 파일 데이터
                        reviewImgDownload,
                        reviewImgUuid); // 우리가 만든 url
                review2 = reviewRepository.save(review);
            }
        } catch (Exception e){
            log.debug(e.getMessage());
        }
        return review2;
    }

    // todo 리뷰 이미지 불러오기
    public Optional<Review> findReviewImgByUuid(String uuid){
        Optional<Review> review = reviewRepository.findByReviewImgUuid(uuid);
        return review;
    }
}