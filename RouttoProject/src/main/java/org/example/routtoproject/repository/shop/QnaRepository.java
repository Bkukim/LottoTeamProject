package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Qna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : QNARepository
 * author : hayj6
 * date : 2024-05-13(013)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-13(013)         hayj6          최초 생성
 */
@Repository
public interface QnaRepository extends JpaRepository<Qna, Integer> {
    @Query(value = "SELECT * FROM LOTTO_QNA\n" +
            "WHERE QNA_TITLE LIKE '%'|| :title ||'%'"
            ,countQuery = "SELECT count (*) FROM LOTTO_QNA\n" +
            "WHERE QNA_TITLE LIKE '%'|| :title ||'%'"
            ,nativeQuery = true)
    Page<Qna> findQnaByTitleContaining(@Param("title") String title,
                                       Pageable pageable
    );
}
