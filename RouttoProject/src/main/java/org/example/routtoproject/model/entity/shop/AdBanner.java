package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : AdBanner
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
@Entity
@Table(name = "LOTTO_AD_BANNER")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class AdBanner extends BaseTimeEntity {

    @Id
    private String bannerId;
    private int prodId;
    private String bannerTitle;
    private String  bannerContent;
    private byte[] bannerImg1;
    private String bannerImg1Url;
    private String bannerImg1Uuid;
    private byte[] bannerImg2;
    private String bannerImg2Url;
    private String bannerImg2Uuid;
    private String insertTime;
    private String updateTime;

    public AdBanner(String bannerId, int prodId, String bannerTitle, String bannerContent, byte[] bannerImg1, String bannerImg1Url, String bannerImg1Uuid, byte[] bannerImg2, String bannerImg2Url, String bannerImg2Uuid) {
        this.bannerId = bannerId;
        this.prodId = prodId;
        this.bannerTitle = bannerTitle;
        this.bannerContent = bannerContent;
        this.bannerImg1 = bannerImg1;
        this.bannerImg1Url = bannerImg1Url;
        this.bannerImg1Uuid = bannerImg1Uuid;
        this.bannerImg2 = bannerImg2;
        this.bannerImg2Url = bannerImg2Url;
        this.bannerImg2Uuid = bannerImg2Uuid;
    }
}
