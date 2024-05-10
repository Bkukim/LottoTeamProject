package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Review
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
@Entity
@Table(name = "LOTTO_REVIEW")
@SequenceGenerator(
        name = "SQ_LOTTO_REVIEW_GENERATOR"
        , sequenceName = "SQ_LOTTO_REVIEW"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Review extends BaseTimeEntity {
//    review_id	number
//    user_id	varchar2(255 byte)
//    prod_id	number
//    point	number
//    review_content	varchar2(1000 byte)
//    review_image	blob
//    insert_time	date
//    update_time	date
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_REVIEW_GENERATOR"
    )
    private Integer reviewId;       // 리뷰 ID
    private String userId;          // 회원 ID
    private Integer prodId;         // 상품 ID
    private Integer point;          // 별점
    private String reviewContent;   // 리뷰 내용
    private byte[] reviewImage;     // 리뷰 사진
    private String reviewImgUrl;      // 리뷰 이미지 url
    private String reviewImgUuid;     // 리뷰 이미지 uuid

    // TODO 리뷰 등록시 상품들의 정보를 저장하기위한 생성자

    public Review(String userId, Integer prodId, Integer point, String reviewContent, byte[] reviewImage, String reviewImgUrl, String reviewImgUuid) {
        this.userId = userId;
        this.prodId = prodId;
        this.point = point;
        this.reviewContent = reviewContent;
        this.reviewImage = reviewImage;
        this.reviewImgUrl = reviewImgUrl;
        this.reviewImgUuid = reviewImgUuid;
    }
}
