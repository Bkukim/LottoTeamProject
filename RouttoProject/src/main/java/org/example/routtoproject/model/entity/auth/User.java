package org.example.routtoproject.model.entity.auth;

import jakarta.persistence.*;
import lombok.*;
import org.example.routtoproject.model.common.BaseTimeEntity2;
import org.example.routtoproject.model.entity.shop.Order;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : org.example.routtoproject.model.entity.auth
 * fileName : User
 * author : PC
 * date : 2024-04-20
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-20         PC          최초 생성
 */@Entity
@Table(name="LOTTO_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "orders") // 순환 참조 방지를 위해 orders를 제외
// soft delete jpa 어노테이션
@Where(clause = "WITHDRAW_YN = 'N'")
@SQLDelete(sql ="UPDATE LOTTO_USER SET WITHDRAW_YN = 'Y', WITHDRAW_TIME=TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE USER_ID = ?")
public class User extends BaseTimeEntity2 {

    @Id
    private String userId;
    private String password;
    private String userName;
    private int birthday;
    private String phoneNum;
    private String callNum;
    private String email;
    private String role;
    private String normalAddress;
    private String detailAddress;
    private String pastPw;
    private String pwUpdateTime;
    private String pwQuestion;
    private String pwAnswer;

    // todo 회원가입시 값 넣을 생성자 : 비밀번호를 인코딩 해줘야해서 생성자를 한개 만들어줘야한다.
    public User(String userId, String password, String userName, int birthday, String phoneNum, String callNum, String email, String role, String normalAddress, String detailAddress, String pwQuestion, String pwAnswer) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
        this.callNum = callNum;
        this.email = email;
        this.role = role;
        this.normalAddress = normalAddress;
        this.detailAddress = detailAddress;
        this.pwQuestion = pwQuestion;
        this.pwAnswer = pwAnswer;
    }

    // User와 Order 사이의 일대다 관계를 설정
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}