package org.example.routtoproject.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.example.routtoproject.security.jwt.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * packageName : org.example.simpledms.config
 * fileName : WebSecurityConfig
 * author : GGG
 * date : 2024-04-15
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-15         GGG          최초 생성
 */
@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
    //    1) DB 인증을 하는 클래스    :
//    2) TODO: 패스워드 암호화 함수     : 필수 정의
//        @Bean : IOC (스프링이 객체를 생성해주는 것), 함수의 리턴객체를 생성함
//         => (참고) 용어 : 스프링 생성한 객체 == 빈(Bean==콩)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    TODO: 3) JWT(웹토큰) 객체(자동인증을 위한 필터) 정의
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(); // 개발자가 작성한 웹토큰 인증필터 생성자 함수
    }

    //    4) TODO: 공통 jsp, img, css, js 등 : 인증 안받는 것들은 무시하도록 설정
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
//      사용법 : (web) -> web.ignoring().requestMatchers("경로", "경로2"...)
        return (web) -> web.ignoring().requestMatchers(
                "/img/**",
                "/css/**",
                "/js/**"
        );
    }

    //    TODO: 스프링 시큐리티 규칙 정의 함수(***) : JWT(웹토큰) 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors(Customizer.withDefaults()); // cors 사용
        http.csrf((csrf) -> csrf.disable());   // csrf 해킹 보안 비활성화(쿠키/세션 사용않함)
//        쿠키/세션 안함(비활성화) -> 로컬스토리지/웹토큰
        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin(req -> req.disable()); // form 태그 action 을 이용한 로그인 사용않함 -> axios 통신함

        http.authorizeHttpRequests(req -> req // todo 여기서 부터 controller의 url을 제한함으로 db와의 접근을 제한한다.


//                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()


//
//                .requestMatchers("/api/auth/**").permitAll()       // 로그인 및 회원가입 함수
//                .requestMatchers("/api/user/**").hasRole("USER")       // user관련 모든 함수
//                .requestMatchers("/api/admin/**").hasRole("ADMIN")       // 관리자의 모든 함수
//                .requestMatchers("/api/normal/**").permitAll()       // 관리자의 모든 함수

                .anyRequest()
                .permitAll());
//                .authenticated());






//        TODO: 웹토큰 클래스를 스프링시큐리티 설정에 끼워넣기 : 모든 조회(CRUD)에서 아래 인증을 실행함
//         웹토큰 인증필터를 UsernamePasswordAuthenticationFilter(id/암호 인증필터) 앞에 끼워넣기
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
