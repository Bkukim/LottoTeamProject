package org.example.routtoproject.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.member.FindId;
import org.example.routtoproject.model.dto.member.NewPw;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.service.member.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.controller.member
 * fileName : UserController
 * author : PC
 * date : 2024-04-23
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23         PC          최초 생성
 */
@RestController
@Slf4j
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;


    @GetMapping("/order/{userId}")
    public ResponseEntity<Object> findById(@PathVariable String userId){
        log.debug("asdf");
        try{
            User user = userService.findById(userId).get();
//            User user = userService.findById(userId);
//            if (user.isEmpty() == false) {
                return new ResponseEntity<>(user, HttpStatus.OK);
//            }
//            else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
        } catch (Exception e){
            log.debug("에러 : " + e.getMessage());
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
            if (userService.existById(newPw.getUserId())) {
                userService.updatePw(newPw.getNewPw(), newPw.getUserId());
                result=true;
                return new  ResponseEntity<>(result,HttpStatus.OK);
            }else {

                return new ResponseEntity<>(result,HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
