package org.example.routtoproject.controller.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.auth.NewUser;
import org.example.routtoproject.model.dto.auth.UserReq;
import org.example.routtoproject.model.dto.auth.UserRes;
import org.example.routtoproject.model.dto.member.FindId;
import org.example.routtoproject.model.dto.member.NewPw;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.security.jwt.JwtUtils;
import org.example.routtoproject.service.member.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * packageName : org.example.routtoproject.controller
 * fileName : UserController
 * author : PC
 * date : 2024-04-20
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-20         PC          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    @PostMapping("/login")
    public ResponseEntity<Object> login(
            @RequestBody UserReq userReq
    ) {
        try {
//            1) 직접 인증 시작
//            1) id/패스워드로 인증 => 인증된 객체(리턴)
            Authentication authentication /*todo 여기서 어떻게 인증을 해주지 데이터베이스와 연결이 돼있나? 혹시 doFilterInternal 로?*/
                    = authenticationManagerBuilder.getObject().authenticate(
                    new UsernamePasswordAuthenticationToken(userReq.getUserId(), userReq.getPassword())
            );

//            2) 인증된 객체 => 홀더(필통)에 관리 => 인증 완료
            SecurityContextHolder.getContext().setAuthentication(authentication);

//            3) 웹토큰 발행(생성) => 프론트 전송
//               => authentication => memberDto => email 로 웹토큰 생성
            String jwt = jwtUtils.generateJwtToken(authentication);

//            4) 권한 정보 : ROLE_USER, ROLE_ADMIN
//              => Set -> List => new ArrayList(Set객체) : 변경됨
//              => authentication.getAuthorities() : 권한 배열 집합(set)
            String codeName = new ArrayList(authentication.getAuthorities()).get(0).toString();

//             5) DTO : jwt(웹토큰), 이메일, 권한명 => 프론트에 전송
            UserRes userRes = new UserRes(
                    jwt,                // 웹토큰
                    userReq.getUserId(), // 이메일
                    codeName
            );
            return new ResponseEntity<>(userRes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    회원 가입 함수(insert)
    @PostMapping("/register")
    public ResponseEntity<Object> createUser(
            @RequestBody NewUser newUser
    ) {
        try {
//            1) 이메일이 DB 있는지 확인 : 있으면 우리 회원 => 바로 리턴
            log.debug(String.valueOf(newUser));
            if(userService.existsById(newUser.getUserId()) == true) {
                return new ResponseEntity<>("이미 회원입니다.", HttpStatus.BAD_REQUEST);
            }

//            2) 새로운 사용자 생성
            User user = new User(
                    newUser.getUserId(),                            // 로그인 ID
                    passwordEncoder.encode(newUser.getPassword()), // 암호화 적용
                    newUser.getUserName(),                             // 이름
                    newUser.getBirthday(),                          // 권한
                    newUser.getPhoneNum(),
                    newUser.getCallNum(),
                    newUser.getEmail(),
                    newUser.getRole(),
                    newUser.getNormalAddress(),
                    newUser.getDetailAddress(),
                    newUser.getPwQuestion(),
                    newUser.getPwAnswer()
            );
            log.debug(String.valueOf(user));
//            3) 저장
            userService.save(user);

//            4) 프론트 전송
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
//            log.debug("에러 : " + e); // 디버깅
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo id 찾기함수
    @GetMapping("/findId/{role}/{userName}/{phoneNum}")
    public ResponseEntity<Object> findId(@PathVariable String role,
                                         @PathVariable String userName,
                                         @PathVariable String phoneNum){
        try {
            User user = userService.findId(role, userName, phoneNum);
            FindId findId = new FindId("존재하지 않는 회원입니다.");
            log.debug("asdfa" + user);
            if (user == null) {
                return new ResponseEntity<>(findId, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo 비밀번호 찾기위해 회원확인함수 - 확인후 일치하면 true를 내보낸다.
    @GetMapping("/getForPw/{role}/{userId}/{pwQuestion}/{pwAnswer}")
    public ResponseEntity<Object> getForPw(@PathVariable String role,
                                           @PathVariable String userId,
                                           @PathVariable String pwQuestion,
                                           @PathVariable String pwAnswer){
        try {
            User user = userService.getForPw(role, userId, pwQuestion, pwAnswer);
            if (user != null) {

                return new ResponseEntity<>(true, HttpStatus.OK);
            }else {

                return new ResponseEntity<>(false,HttpStatus.OK);
            }
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // todo 새로운 비밀번호 업데이트
    @PutMapping("/new-pw")
    public ResponseEntity<Object> updatePw(@RequestBody NewPw newPw){
        boolean result = false;
        try {
            if (userService.existsById(newPw.getUserId())) {
                userService.updatePw(passwordEncoder.encode(newPw.getNewPw()), newPw.getUserId());
                result=true;
                return new  ResponseEntity<>(result,HttpStatus.OK);
            }else {

                return new ResponseEntity<>(result,HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo id 존재 여부 확인
    @GetMapping("/exist-id/{userId}")
    public ResponseEntity<Object> existUserById(@PathVariable String userId){
        try {
            boolean result = userService.existsById(userId);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
