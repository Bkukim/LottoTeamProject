package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Notice
 * author : KimDJ
 * date : 2024-04-29
 * description : 공지사항 모델파일
 * 요약 : ANNOUNCEMENT ==Notice 
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         KimDJ          최초 생성
 */
@Entity
@Table(name = "LOTTO_ANNOUNCEMENT")
@SequenceGenerator(
        name = "SQ_LOTTO_ANNOUNCEMENT_GENERATOR"
        , sequenceName = "SQ_LOTTO_ANNOUNCEMENT"
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
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_ANNOUNCEMENT_GENERATOR"
    )
    public Integer announcementId; //기본키
    public String title;
    public String content;
    public byte[] announcementImg; //이미지
    public String announcementImgUrl;
    public String announcementImgUuid;

}
