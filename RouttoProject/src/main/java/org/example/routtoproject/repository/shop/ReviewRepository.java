package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.dto.member.AnnouncementAllDto;
import org.example.routtoproject.model.dto.shop.IReviewDto;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.model.entity.shop.Qna;
import org.example.routtoproject.model.entity.shop.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

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

    //
    @Query(value = "SELECT USER_ID AS userId, POINT AS point, REVIEW_CONTENT AS reviewContent, REVIEW_IMG_URL AS reviewImgUrl FROM LOTTO_REVIEW\n" +
            "WHERE  PROD_ID = :prodId"
            , countQuery = "SELECT count(*)FROM LOTTO_REVIEW\n" +
            "WHERE  PROD_ID = :prodId"
            , nativeQuery = true)
    Page<IReviewDto> findByProdId(@Param("prodId") int prodId,
                                  Pageable pageable
    );

//    리뷰 작성 시 이미지 뜨게 하는 다운로드 함수
    Optional<Review> findByReviewImgUuid(String uuid);

//    페이징
    @Query(value = "SELECT * FROM LOTTO_REVIEW"
            ,countQuery = "SELECT count (*) FROM LOTTO_REVIEW"
            ,nativeQuery = true)
    Page<Review> findReviewByTitleContaining(Pageable pageable);

}
