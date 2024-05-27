package org.example.routtoproject.security.services.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * fileName : OAuth2SuccessHandler
 * author : kangtaegyung
 * date : 2022/12/16
 * description : 소셜 로그인 성공 후 처리할 클래스
 *    알고리즘
 *      1) 인증된 객체를 홀더에 저장
 *      2) 인증된 유저 정보를 oAuth2User(소셜로그인 클래스) 에 저장, 소셜로그인은 oAuth2User 사용
 *      3) 권한 정보 가져오기
 *      4) 토큰 발행
 *      5) 리다이렉션 페이지로 이동 : 여기서 구글 인가코드를 받을 수 있음
 *
 *   참고) 함수
 *      - UriComponentsBuilder.fromUriString("기본url")
 *                           .queryParam("키", 값)    // 쿼리스트링 변수명, 값
 */
@Slf4j
@Component
public class SocialLoginSuccess extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    JwtUtils jwtUtils;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authentication);                        // 1)
        OAuth2User socialLogin = (OAuth2User)authentication.getPrincipal();                          // 2)
        Map<String, Object> socialUser = socialLogin.getAttributes();
        List<GrantedAuthority> authorities = new ArrayList(authentication.getAuthorities());
        String role = authorities.get(0).toString();                                             // 3) 권한
        String jwt = jwtUtils.generateJwtToken(authentication);                     // 4)
        String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:8080/auth-redirect")  // 5)
                .queryParam("accessToken", jwt)
                .queryParam("id", socialUser.get("id"))
                .queryParam("role", role)
                .build().toUriString();
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
