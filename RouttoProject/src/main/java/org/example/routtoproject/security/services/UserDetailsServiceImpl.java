package org.example.routtoproject.security.services;

import lombok.RequiredArgsConstructor;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.repository.member.UserRepository;
import org.example.routtoproject.security.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * packageName : org.example.loginexam.security.services
 * fileName : UserDetailsServiceImpl
 * author : GGG
 * date : 2024-03-27
 * description : TODO: DB 에 사용자 있는지 확인하는 클래스(함수)
 * 요약 :
 *      TODO:
 *          1) 스프링에서 제공한 함수명으로 작성 : 인터페이스 상속(함수명 있음)
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-27         GGG          최초 생성
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
//    DB Member 레포지토리 DI

    private final UserRepository userRepository;


//    함수 재정의 : 자동 기능 : alt + insert
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        TODO: 1) 유저 DB 인증 : 상세조회
//          js 화살표 함수 : function(x){return x+1;} : (x) => x + 1;
//          java 람다식   : interface x(함수())       : (x) -> x + 1;
//         사용법 : 자료형 변수 = 옵셔널객체.orElseThrow(new 예외처리클래스("에러메세지"));
//            => 옵셔널객체의 결과가 null 이면 에러메세지 출력, 아니면 변수에 저장됨
        User user
                = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("ID 없음:" + userId));

//        TODO: 2) 검증객체에 정보 넣기
//               2-1) 권한을 생성해서 넣기 : GrantedAuthority(스프링시큐리티 권한클래스)
//                 => codeName : 권한명 (ROLE_ADMIN, ROLE_USER)
//                 => 사용법 : GrantedAuthority 변수 = new SimpleGrantedAuthority(권한명);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

//        TODO:  2-2) 권한 배열에(List, Set 등) 넣기 : Set 에 넣기
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(authority);    // Set 배열에 권한 넣기

//        생성자 : (email, password, 권한배열)
        return new UserDto(user.getUserId(),
                            user.getPassword(),
                            authorities
                );
    }
}
