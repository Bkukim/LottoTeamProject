package org.example.routtoproject.controller.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.service.member.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
