package org.example.routtoproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.auth.CustomOAuth2User;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.repository.member.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * packageName : org.example.routtoproject.service
 * fileName : OAuth2UserServiceImp
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
@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2UserServiceImp extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException{
        OAuth2User oAuth2User = super.loadUser(request); // 부모의 loaduser함수에 request를 보내면 결과를 보여주는 함수
        String oauthClientName = request.getClientRegistration().getClientName(); // 클라이언트 이름 ex)네이버 카카오
//        try {
//            log.debug(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes())); //받은 결과 출력
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        User user = null;
        String userId = null;


        // 클라이언트 이름에 따른 처리
        if (oauthClientName.equals("kakao")) {
            userId = "kakao" + oAuth2User.getAttributes().get("id"); // 카카오에서 id 가져오는 방법

        }
        if (oauthClientName.equals("naver")) {
            Map<String , String > responseMap = (Map<String, String>) oAuth2User.getAttributes().get("response"); // 가져온 정보  map에 담기
            userId = "naver_" + responseMap.get("id").substring(0,14); // 가져온 정보에서 id 가져오기
            String email = responseMap.get("email"); // email 가져오기
        }
        userRepository.save(user);
        return new CustomOAuth2User(userId);
    }
}
