package org.example.routtoproject.model.dto.member;

import lombok.*;

/**
 * packageName : org.example.routtoproject.model.dto.member
 * fileName : NewPw
 * author : PC
 * date : 2024-04-25
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-25         PC          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewPw {
    private String userId;
    private String newPw;
}
