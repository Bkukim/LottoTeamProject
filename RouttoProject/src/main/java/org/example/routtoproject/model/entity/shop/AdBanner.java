package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
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
    @Column(name = "BANNER_IMG1_URL")
    private String bannerImg1Url;
    @Column(name = "BANNER_IMG1_UUID")
    private String bannerImg1Uuid;
    private byte[] bannerImg2;
    @Column(name = "BANNER_IMG2_URL")
    private String bannerImg2Url;
    @Column(name = "BANNER_IMG2_UUID")
    private String bannerImg2Uuid;


}
