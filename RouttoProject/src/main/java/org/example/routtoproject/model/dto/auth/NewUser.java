package org.example.routtoproject.model.dto.auth;

import lombok.*;

/**
 * packageName : org.example.simpledms.model.dto
 * fileName : NewUser
 * author : GGG
 * date : 2024-04-16
 * description : TODO 회원가입 용 DTO, passwordEncoder 를 해주기위해 만들었다.
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-16         GGG          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {
    private String userId;
    private String password;
    private String userName;
    private int birthday;
    private String phoneNum;
    private String callNum;
    private String email;
    private String role;
    private String normalAddress;
    private String detailAddress;
    private String pwQuestion;
    private String pwAnswer;
}
