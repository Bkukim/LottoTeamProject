package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : ReviewRepository
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
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {


//    리뷰 작성 시 이미지 뜨게 하는 다운로드 함수
    Optional<Review> findByReviewImgUuid(String reviewImgUuid);


}
