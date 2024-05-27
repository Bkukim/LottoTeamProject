package org.example.routtoproject.service.member.social;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.auth.UserRes;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.repository.member.UserRepository;
import org.example.routtoproject.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.service.member
 * fileName : KakaoUserService
 * author : PC
 * date : 2024-05-24
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-24         PC          최초 생성
 */
@Service
@Slf4j
public class KakaoUserService implements SocialLoginService {

    // 속성에 입력한 카카오톡
    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Value("${kakao.client-secret}")
    private String clientSecret;

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // 의존성 주입

    private JwtUtils jwtUtils;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String getAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        log.debug(code);
        // todo 1) 엑세스 토큰 가져오기
        String url = "https://kauth.kakao.com/oauth/token";
        log.debug("여기까진 성공2");
        // 바디생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);
        params.add("client_secret", clientSecret);
        params.add("scope", "account_email");

        log.debug("여기까진 성공2.5");
        // 헤더 생성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 요청 생성 : 바디와 헤더를
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);


        // 토큰 꺼내 사용하기
        Map<String, Object> responseBody = response.getBody();
        if (responseBody == null || !responseBody.containsKey("access_token")) {
            throw new RuntimeException("Failed to retrieve access token");
        }
        String accessToken = (String) responseBody.get("access_token");
        log.debug("토큰 ::: " + accessToken);
        return accessToken;
    }

    @Override
    public UserRes getUserInfo(String accessToken) {
        // todo 2) 사용자 정보를 가져오기.
        RestTemplate restTemplate = new RestTemplate();
        String userInfoUrl = "https://kapi.kakao.com/v2/user/me";

        // 헤더 생성
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization", "Bearer " + accessToken);
        log.debug("두번째헤더 :::" + headers2);
        // 요청 생성 : 헤더
        HttpEntity<String> entity = new HttpEntity<>(headers2);
        ResponseEntity<Map> userInfoResponse = restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, Map.class);
        log.debug("여기까진 성공 3");

        // 받은 정보 사용하기
        Map<String, Object> userInfo = userInfoResponse.getBody();
        if (userInfo == null) {
            throw new RuntimeException("Failed to retrieve user info");
        }

        // 사용자 정보를 바탕으로 JWT 토큰 생성
        String userId = ((Map<String, Object>) userInfo.get("kakao_account")).get("email").toString();


        // 유저가 없다면 회원가입
        if (!userRepository.existsById(userId)) {
            // 사용자 저장
            User user = new User(
                    userId, passwordEncoder.encode("asdfasdgawstgfasdfa"), "ROLE_USER"
            );
            userRepository.save(user);
        }

        // 프론트로 userRes 객체 보내기
        String jwt = jwtUtils.generateJwtTokenForKakao(userId);
        UserRes userRes = new UserRes(
                jwt,                // 웹토큰
                userId,
                "ROLE_USER");

        return userRes;
    }

}