package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Faq
 * author : KimDJ
 * date : 2024-04-29
 * description :
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         KimDJ          최초 생성
 */
@Entity
@Table(name = "LOTTO_FAQ")
@SequenceGenerator(
        name = "SQ_LOTTO_FAQ_GENERATOR"
        , sequenceName = "SQ_LOTTO_FAQ"
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
public class Faq extends BaseTimeEntity {
//    faq_id	number
//    user_id	varchar2(255 byte)
//    faq_title	varchar2(255 byte)
//    faq_content	varchar2(1000 byte)
//    faq_type	varchar2(255 byte)
//    insert_time	date
//    update_time	date

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_FAQ_GENERATOR"
    )
    private Integer faqId;
    private String userId;
    private String faqTitle;
    private String faqContent;
    private String faqType;
}
