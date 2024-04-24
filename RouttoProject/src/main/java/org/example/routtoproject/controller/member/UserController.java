package org.example.routtoproject.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.member.FindId;
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


    @GetMapping("/findId/{role}/{userName}/{phoneNum}")
    public ResponseEntity<Object> findId(@PathVariable String role,
                                         @PathVariable String userName,
                                         @PathVariable String phoneNum){
        try {
            User user = userService.findId(role, userName, phoneNum);
            if (user == null) {
                return new ResponseEntity<>("존재하지 않는 회원입니다.", HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
