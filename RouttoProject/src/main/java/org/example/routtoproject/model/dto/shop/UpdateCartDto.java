package org.example.routtoproject.model.dto.shop;

import lombok.*;
import org.example.routtoproject.model.entity.shop.Cart;

import java.util.List;

/**
 * packageName : org.example.routtoproject.model.dto.shop
 * fileName : UpadateCartDto
 * author : KimDJ
 * date : 2024-05-09
 * description : 수정함수, 배열로 주는 cart 사용 dto
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-09         KimDJ          최초 생성
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartDto {
    private List<Cart> cartAll;
}
