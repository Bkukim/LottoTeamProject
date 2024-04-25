package org.example.routtoproject.model.entity.auth;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * packageName : org.example.routtoproject.model.entity.auth
 * fileName : FindPw
 * author : PC
 * date : 2024-04-24
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-24         PC          최초 생성
 */
@Entity
@Table(name="LOTTO_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// soft delete jpa 어노테이션
@Where(clause = "WITHDRAW_YN = 'N'")
@SQLDelete(sql ="UPDATE LOTTO_USER SET WITHDRAW_YN = 'Y', WITHDRAW_TIME=TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE USER_ID = ?")
public class FindPw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User userId;
    current_pw;
    past_pw;
    pw_question;
    pw_answer;
    pw_update_time;


}
