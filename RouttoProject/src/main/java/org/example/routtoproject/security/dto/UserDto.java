package org.example.routtoproject.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * packageName : org.example.loginexam.security.dto
 * fileName : MemberDto
 * author : GGG
 * date : 2024-03-27
 * description : TODO: 검증된 유저 클래스 정의
 * 요약 :
 *      TODO
 *          1) 스프링에서 제공한 유저 클래스 : User, UserDetails 2중에 1개 상속
 *          2) 검증된 유저 객체에는 권한이 있음 : 권한 넣기
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-27         GGG          최초 생성
 */
@Setter
@Getter
@ToString
public class UserDto extends User {

// 개발자 추가 속성(필드) : email
    private String userId; // 로그인 ID == username

//    생성자 : 자동생성 : alt + insert(cmd + n)

    public UserDto(String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
        this.userId = userId;
    }
}
