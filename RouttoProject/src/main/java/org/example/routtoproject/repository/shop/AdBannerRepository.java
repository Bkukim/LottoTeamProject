package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.dto.shop.AdBannerDto;
import org.example.routtoproject.model.entity.shop.AdBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : AdBannerRepository
 * author : PC
 * date : 2024-05-07
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-07         PC          최초 생성
 */
@Repository
public interface AdBannerRepository extends JpaRepository<AdBanner, String>{


    // todo 이미지 조회를 위한 상세 조회 함수
    @Query(value = "SELECT * FROM LOTTO_AD_BANNER WHERE BANNER_IMG1_UUID = :bannerImg1Uuid", nativeQuery = true)
    Optional<AdBanner> findByBannerImg1Uuid(String bannerImg1Uuid);

    @Query(value = "SELECT AB.BANNER_ID AS bannerId,\n" +
            "PR.PROD_ID AS prodId,\n" +
            "PR.PROD_NAME AS prodName,\n" +
            "AB.BANNER_TITLE AS bannerTitle,\n" +
            "AB.BANNER_CONTENT AS bannerContent,\n" +
            "AB.BANNER_IMG1_URL AS bannerImg1Url,\n" +
            "AB.BANNER_IMG2_URL AS bannerImg2Url,\n" +
            "AB.BANNER_IMG1_UUID AS bannerImg1Uuid,\n" +
            "AB.BANNER_IMG2_UUID AS bannerImg2Uuid\n" +
            "FROM LOTTO_AD_BANNER AB, LOTTO_PRODUCT PR\n" +
            "WHERE AB.PROD_ID = PR.PROD_ID\n" +
            "ORDER BY AB.BANNER_ID"
    ,nativeQuery = true)
    public List<AdBannerDto> findAllBanner();

    @Query(value = "SELECT AB.BANNER_ID AS bannerId,\n" +
            "PR.PROD_ID AS prodId,\n" +
            "PR.PROD_NAME AS prodName,\n" +
            "AB.BANNER_TITLE AS bannerTitle,\n" +
            "AB.BANNER_CONTENT AS bannerContent,\n" +
            "AB.BANNER_IMG1 AS bannerImg1,\n" +
            "AB.BANNER_IMG2 AS bannerImg2,\n" +
            "AB.BANNER_IMG1_URL AS bannerImg1Url,\n" +
            "AB.BANNER_IMG2_URL AS bannerImg2Url,\n" +
            "AB.BANNER_IMG1_UUID AS bannerImg1Uuid,\n" +
            "AB.BANNER_IMG2_UUID AS bannerImg2Uuid\n" +
            "FROM LOTTO_AD_BANNER AB, LOTTO_PRODUCT PR\n" +
            "WHERE AB.PROD_ID = PR.PROD_ID AND AB.BANNER_ID = :bannerId"
    ,nativeQuery = true)
    public Optional<AdBannerDto> findBannerByBannerId(@Param("bannerId") String bannerId);


//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE LOTTO_AD_BANNER \n" +
//            "SET PROD_ID = :prodId\n" +
//            ",BANNER_TITLE = :bannerTitle\n" +
//            ",BANNER_CONTENT = :bannerContent\n" +
//            ",BANNER_IMG1 = :bannerImg1\n" +
//            ",BANNER_IMG1_URL = :bannerImg1Url\n" +
//            ",BANNER_IMG1_UUID = :bannerImg1Uuid\n" +
//            ",UPDATE_TIME=TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')\n"+
//            "WHERE BANNER_ID = :bannerId ", nativeQuery = true)
//    public void updateOneBanner(@Param("bannerId") String bannerId,
//                                @Param("prodId") int prodId,
//                                @Param("bannerTitle") String bannerTitle,
//                                @Param("bannerContent") String bannerContent,
//                                @Param("bannerImg1") byte[] bannerImg1,
//                                @Param("bannerImg1Url") String bannerImg1Url,
//                                @Param("bannerImg1Uuid") String bannerImg1Uuid
//                                );
//
}
