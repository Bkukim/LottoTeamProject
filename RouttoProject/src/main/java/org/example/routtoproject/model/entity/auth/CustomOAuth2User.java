package org.example.routtoproject.model.entity.auth;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.model.entity.auth
 * fileName : CustomOAuth2User
 * author : PC
 * date : 2024-05-23
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-23         PC          최초 생성
 */
@NoArgsConstructor
@AllArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    private String userId;

    @Override
    public Map<String, Object> getAttributes() {
        return null; // 굳이 작업 안함
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // 굳이 작업 안함
    }

    @Override
    public String getName() {
        return this.userId; // 생성자로 받아올 id 반환
    }
}
