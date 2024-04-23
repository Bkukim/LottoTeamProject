package org.example.routtoproject.repository.member;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

    @Query(value = "SELECT USER_ID FROM LOTTO_USER\n" +
            "WHERE ROLE =  :dname AND USER_NAME = :userName AND PHONE_NUM = :phoneNum")
    public User findByRoleAndUserNameAndPhoneNum(@Param("role") String role, @Param("userName") String userName, @Param("phoneNum") String phoneNum);
}
