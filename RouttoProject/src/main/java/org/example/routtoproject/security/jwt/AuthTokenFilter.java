package org.example.routtoproject.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * packageName : org.example.simpledms.security.jwt
 * fileName : AuthTokenFilter
 * author : GGG
 * date : 2024-04-16
 * description : 게시판 조회시 자동 웹토큰 인증을 위한 클래스
 * 요약 :
 * 1) 상속 : OncePerRequestFilter 클래스
 * => 위의 클래스 상속받아 직접 인증필터 제작할 수 있음
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-16         GGG          최초 생성
 */
@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private  JwtUtils jwtUtils; // 웹토큰  DI

    @Autowired
    private  UserDetailsServiceImpl userDetailsService; // DB 인증 DI

    //    개발자 필요한 인증 로직을 추가하면 spring security 가 이함수를 실행해서 자동 인증을 진행함
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
//            1) 프론트에서 보내준 웹토큰을 받아서 문자열로 변환
            String jwt = parseJwt(request);

//            2) 웹토큰(jwt) 이 있고, 유효하면 인증을 진행함
            if(jwt != null && jwtUtils.validateJwtToken(jwt)) {
//            3) DB 인증 : 유저ID 로 조회해서 있으면 우리 회원(인증됨)
//               => 웹토큰 : 헤더.내용(유저ID).서명
                String userId = jwtUtils.getUserNameFromJwtToken(jwt);

//             3-1) DB 인증(조회) : UserDetails(인증된객체) == MemberDto(인증된객체) == User(인증된객체)
                UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

//             3-2) 스프링 시큐리티에서 인증 결과 처리 => 인증되었다고 직접 설정 ( authenticated : false -> true )
//                UsernamePasswordAuthenticationToken 생성자 함수에 아래처럼 (매개변수 3) 실행하면 강제 인증 성공
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());

//              4) 인증에 관련된 추가 정보가 있으면 추가 설정 : 생략
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

//              5) 인증된 객체는 필통(홀더) 에 관리 : SecurityContextHolder 클래스
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        } catch (Exception e) {
            log.debug("인증을 정의할 수 없습니다. : " + e);
        }

//      (참고) 필터  : 스프링시큐리티 인증 클래스들
//          필터체인 : 스프링시큐리티 인증 클래스들을 연결해서 연쇄적으로 인증할때 사용
//      스프링시큐리티 자동 인증기능에 연결하는 함수
        filterChain.doFilter(request, response);
    }

    //    프론트에서 보내준 헤더에 있는 웹토큰을 꺼내는 함수
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
//            웹토큰 : 7자리부터 시작해서 끝까지 문자열 잘라냄
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

}
