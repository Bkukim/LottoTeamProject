package org.example.routtoproject.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.routtoproject.model.entity.auth.CustomOAuth2User;
import org.example.routtoproject.security.jwt.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * packageName : org.example.routtoproject.handler
 * fileName : OAuth2SuccessHandler
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
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtils jwtUtils;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication) throws IOException, ServletException {
        String token = jwtUtils.generateJwtToken(authentication);

        response.sendRedirect("http://localhost:8000/auth/oauth-response/" + token + "/3600");
    }
}
