package org.example.routtoproject.security.services.auth;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.repository.member.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Map;
/**
 * fileName : CustomOAuth2UserService
 * author : kangtaegyung
 * date : 2022/12/16
 * description :
 *  알고리즘
 *      1) OAuth2UserService : 유저정보 있는 클래스
 *      2) OAuth2 로그인 진행시 키가 되는 필드값(PK 와 같음)
 *      3) 소셜 기본정보 DB 저장, 유저가 있으면 무시
 *      4) 소셜유저 생성 및 내보내기
 */
@Slf4j
@Service
public class SocialLoginServiceCustom implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    @Autowired
    private UserRepository userRepository;
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User>  socialLoginService = new DefaultOAuth2UserService();        // 1)
        OAuth2User socialLogin = socialLoginService.loadUser(userRequest);
        Map<String, Object> socialUser = socialLogin.getAttributes();
        String googleKey = userRequest.getClientRegistration().getProviderDetails()                                   // 2)
                .getUserInfoEndpoint().getUserNameAttributeName();
        saveSocialIdOrSkip(socialUser);                                                                               // 3)
        return new DefaultOAuth2User(                                                                                  // 4)
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                socialUser,
                googleKey);
    }
    //    소셜 기본정보 DB 저장 : DB 에 없으면 저장, 있으면 무시하는 함수
    private void saveSocialIdOrSkip(Map<String, Object> socialUser) {
        try {
            if(userRepository.existsById((String) socialUser.get("id")) == false) {
                userRepository.save(getDefaultUser(socialUser));
            }
        } catch (Exception e) {
            log.debug("saveOrUpdate 에러" ,e.getMessage());
        }
    }
    //  소셜유저를 기본정보로 생성하는 함수
    private User getDefaultUser(Map<String, Object> socialUser) {
        return new User( (String) socialUser.get("id"),
                "asdfadfgbqergsdfgbsdfgwsedrhsdfgsadfgsdfgasdfgasewrvsdf",
                "ROLE_USER"
        );
    }
}
