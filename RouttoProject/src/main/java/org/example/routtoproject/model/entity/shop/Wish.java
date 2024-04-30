package org.example.routtoproject.model.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * packageName : org.example.routtoproject.model.entity.shop
 * fileName : Wisth
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
@Table(name = "LOTTO_WISH")
@SequenceGenerator(
        name = "SQ_LOTTO_WISH_GENERATOR"
        , sequenceName = "SQ_LOTTO_WISH"
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
public class Wish {
//    favorite_id	number
//    user_id	varchar2(255 byte)
//    prod_id	number
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_LOTTO_WISH_GENERATOR"
    )
    private Integer favoriteId;
    private String userId;
    private Integer prodId;
}
