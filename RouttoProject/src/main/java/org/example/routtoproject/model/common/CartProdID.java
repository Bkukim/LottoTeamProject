package org.example.routtoproject.model.common;

import lombok.*;

import java.io.Serializable;

/**
 * packageName : org.example.routtoproject.model.common
 * fileName : CartProdID
 * author : KimDJ
 * date : 2024-04-29
 * description : 복합키 정의 클래스
 * 요약 : 카트+상품 ID (아래 선생님 설명)
 *       TODO: 복합키 정의 : 컬럼 2개이상을 묶어서 기본키로 사용하는 것
 *           기본키는 유일성을 보장해야하므로 복합키 또한 유일성을 보장해야함
 *         예) 주문상세 : 주문번호 + 상품번호 => 유일성 보장
 *                         1       샤프(2)   => 2개 컬럼 합치면 유일성 보장됨(복합키)
 *                         1       연필(3)
 *                         2       샤프(2)
 *                         2       지우개(4)
 *            ~> DB 사용법 : primary key(컬럼명, 컬럼명2)
 *          2) 자바에서 복합키 사용법 :
 *             2-1) 복합키로 사용할 클래스의 속성(필드)들에 @Id 붙임
 *             2-2) 그 속성명(필드)으로 복합키 정의 클래스를 만듬
 *             2-3) 복합키를 사용하는 클래스 위에 @IdClass(복합키 정의 클래스.class) 추가
 *               => 사용법 : @IdClass(복합키클래스.class)
 *                          public class 클래스명{
 *                              @Id
 *                              private 자료형 복합키속성1;
 *                              @Id
 *                              private 자료형 복합키속성2;
 *                          }
 *               => 복합키 클래스 정의 사용법 : 롬북 6개 어노테이션 사용
 *                  public class 복합키클래스 implements Serializable {
 *                              private 자료형 복합키속성1;
 *                              private 자료형 복합키속성2;
 *                          }
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         KimDJ          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CartProdID implements Serializable {
    private Integer cartID;
    private Integer prodID;
}
