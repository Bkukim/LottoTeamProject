package org.example.routtoproject.service.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.auth.User;
import org.example.routtoproject.repository.member.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.member
 * fileName : UserService
 * author : hayj6
 * date : 2024-04-23(023)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23(023)         hayj6          최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    TODO: userID 상세 조회
    public Optional<User> findById(String userId){
        log.debug("서비스");
        Optional<User> user = userRepository.findById(userId);
        log.debug(user.get().toString());
        return user;
    }

//    //    TODO: userID 상세 조회
//    public User findById(String userId){
//        log.debug("서비스");
//        User user = userRepository.findByUserId(userId);
//        return user;
//    }
}