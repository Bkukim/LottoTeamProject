package org.example.routtoproject.model.dto.member;

import lombok.*;

/**
 * packageName : org.example.routtoproject.model.dto.member
 * fileName : findId
 * author : PC
 * date : 2024-04-23
 * description :
 * 요약 : todo 아이디 찾기시 전달받을 권한, 이름, 전화번호 프론트에서 받아올 dto
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23         PC          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FindId {

    private String role;
    private String userName;
    private String phoneNum;
}
