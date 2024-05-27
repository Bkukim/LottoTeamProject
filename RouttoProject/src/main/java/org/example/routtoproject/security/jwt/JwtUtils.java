package org.example.routtoproject.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.security.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * packageName : org.example.simpledms.security.jwt
 * fileName : JwtUtils
 * author : GGG
 * date : 2024-04-15
 * description :
 * 요약 :
 * 1) 검증된(인증된) 유저객체 = MemberDto
 * => MemberDto + 추가속성들 <= authentication(id, 패스워드, ip, 인증여부등) 객체
 * => 로그인ID 속성 : principal, 패스워드 속성 : credential
 * 2) 검증된(인증된) 유저객체 보관하는 클래스(필통, 홀더) : SecurityContextHolder
 * 3) 검증(인증)을 실제 담당하는 관리 클래스 : AuthenticationManagerBuilder
 * 4) 로그인ID / 패스워드 인증을 위한 클래스 : UsernamePasswordAuthenticationToken
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-15         GGG          최초 생성
 */
@Slf4j
@Component
public class JwtUtils {

    //    비밀키 : application.properties 정의
    @Value("${simpleDms.app.jwtSecret}")
    private String jwtSecret;

    //    만료시간(밀리초) : application.properties 정의
    @Value("${simpleDms.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    //    함수 정의
//    1) JWT(웹토큰) 생성 함수
    public String generateJwtToken(Authentication authentication) {

        UserDto userDto = (UserDto) authentication.getPrincipal();

        //    Json Web Token 구조 : 헤더(header).내용(payload).서명(signature)
//    헤더 : 토큰타입, 알고리즘
//    내용 : 데이터(subject(주체(로그인ID))), 토큰발급시간(issuedAt, 생략), 만료기간(expiration), 토큰수령자(생략)
//    서명 : Jwts.builder().signWith(암호화알고리즘, 비밀키값)
//    생성 : Jwts.builder().compact()
        return Jwts.builder()
//                1) 헤더 생략
//                2) 주제 = 이메일 넣기
                .setSubject((userDto.getUserId()))
//                3) 토큰발급시간 : 현재시간
                .setIssuedAt(new Date())
//                4) 만료일자 적용 : 현재시간(new Date()).getTime()) + 10분
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                5) 디지털서명 : 암호화 적용(HS512 사용 , 비밀키 넣기)
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // 암호화 적용 서명
                .compact(); // 토큰 생성
    }
    public String generateJwtTokenForKakao(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // 암호화 적용 서명
                .compact(); // 토큰 생성
    }

    //    2) JWT(웹토큰) 에서 유저ID(이메일) 꺼내기 함수
    public String getUserNameFromJwtToken(String token) {
//    웹토큰의 비밀키 + 토큰명을 적용해 body(내용) 안의 subject(유저ID(이메일))에 접근해서 꺼냄
        return Jwts.parser()
                .setSigningKey(jwtSecret)         // 비밀키 넣기
                .parseClaimsJws(token)            // 웹토큰이름
                .getBody()                        // 내용(Body)에 접근
                .getSubject();                    // 주제(유저ID(이메일))
    }

    //    3) JWT(웹토큰) 이 유효한지 검증하는 함수
    public boolean validateJwtToken(String authToken) {
        try {
//      setSigningKey(jwtSecret) : 비밀키를 넣어 웹토큰 디코딩하기(해석)
//      parseClaimsJws(웹토큰이름) 함수 : 웹토큰을 분리하여 유효성 점검하는 함수
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("디지털서명이 훼손되었습니다.: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("웹토큰 유효하지 않습니다.: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("웹토큰 만료되었습니다. : {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("웹토큰을 지원하지 않습니다.: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("웹토큰 내용이 비었습니다. : {}", e.getMessage());
        }

        return false;
    }
}
