package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : QNA
 * author : hayj6
 * date : 2024-05-13(013)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-13(013)         hayj6          최초 생성
 */
@Entity
@Table(name = "LOTTO_QNA")
@SequenceGenerator(
        name = "SQ_LOTTO_QNA_GENERATOR"
        , sequenceName = "SQ_LOTTO_QNA"
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
public class Qna extends BaseTimeEntity {
//    qna_id	number
//    prod_id	number
//    qna_title	varchar2(255 byte)
//    qna_content	varchar2(1000 byte)
//    writer_id	varchar2(255 byte)
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE
        , generator = "SQ_LOTTO_QNA_GENERATOR"
)
    private Integer qnaId;
    private Integer prodId;
    private String qnaTitle;
    private String qnaContent;
    private String writerId;
}
