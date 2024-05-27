package org.example.routtoproject.service.member.social;

import org.example.routtoproject.model.dto.auth.UserRes;

/**
 * packageName : org.example.routtoproject.service.member.social
 * fileName : NaverUserService
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
public class NaverUserService implements SocialLoginService{
    @Override
    public String getAccessToken(String code) {
        return null;
    }

    @Override
    public UserRes getUserInfo(String accessToken) {
        return null;
    }
}
