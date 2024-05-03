package org.example.routtoproject.model.dto.auth;

import lombok.*;

/**
 * packageName : org.example.simpledms.model.dto
 * fileName : UserReq
 * author : GGG
 * date : 2024-04-15
 * description : 프론트에서 전달한 정보를 받을 DTO 객체
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-15         GGG          최초 생성
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {
    private String userId;    // ID
    private String role; // 권한
    private String password;  // 암호
}
