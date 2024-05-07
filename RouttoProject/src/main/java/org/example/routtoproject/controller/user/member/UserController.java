package org.example.routtoproject.controller.user.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.service.member.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/user/member")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;


    // todo : 회원 상세조회 : 1.주문페이지에서 주문자 자동입력 2.회원정보수정

    @GetMapping("/{userId}")
    public ResponseEntity<Object> findById(@PathVariable String userId){
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
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo  회원 정보 수정 함수 : 1. 회원정보수정 페이지에서 사용
    @PutMapping("/update/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable String  userId,
                                             @RequestBody User user){
        try {
             userService.updateUserById(user.getUserName(), user.getBirthday(),user.getPhoneNum(), user.getCallNum(), user.getEmail(), user.getNormalAddress(), user.getDetailAddress(), user.getUserId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo  회원 소프트 삭제 함수 : 1. 회원 탈퇴
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable String userId){
        try {
            log.debug(userId);
            userService.removeById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
