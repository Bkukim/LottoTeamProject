package org.example.routtoproject.repository.member;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.member
 * fileName : UserRepository
 * author : PC
 * date : 2024-04-23"
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23         PC          최초 생성
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "   select * from lotto_user\n" +
            "   where user_Id = :userId"
            , nativeQuery = true)
    public User findByUserId(@Param("userId") String userId);

    /**
     * 아이디 찾기를 위해 아래 변수를 받아서 일치하는 user반환
     *
     * @param role
     * @param userName
     * @param phoneNum
     * @return User
     */
    @Query(value = "select * from lotto_user where role = :role and USER_NAME = :userName and PHONE_NUM = :phoneNum"
            , nativeQuery = true)
    public User findId(@Param("role") String role, @Param("userName") String userName, @Param("phoneNum") String phoneNum);


    /**
     * 비밀번호 찾기 위한 회원 조회
     * @param role
     * @param userId
     * @param pwQuestion
     * @param pwAnswer
     * @return
     */
    @Query(value = "select * from lotto_user where role = :role and USER_ID= :userId and PW_QUESTION = :pwQuestion and PW_ANSWER = :pwAnswer"
            , nativeQuery = true)
    public User getForPw(@Param("role") String role, @Param("userId") String userId, @Param("pwQuestion") String pwQuestion, @Param("pwAnswer") String pwAnswer);



    @Transactional
    @Modifying // 업데이트문을 쿼리문으로 작성할때는 두개의 어노테이션을 추가해줘야한다.
    @Query(value = "UPDATE LOTTO_USER SET PASSWORD = :newPw WHERE USER_ID = :userId "
            ,nativeQuery = true)
    public void updatePw(@Param("newPw") String newPw, @Param("userId") String userId);
}
