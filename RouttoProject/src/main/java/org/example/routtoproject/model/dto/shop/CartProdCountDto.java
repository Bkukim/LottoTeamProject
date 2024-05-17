package org.example.routtoproject.model.dto.shop;

import lombok.*;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : CartProdCountDto
 * author : PC
 * date : 2024-05-17
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-17         PC          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartProdCountDto {
    int cartProdCount;
    int prodId;
}
