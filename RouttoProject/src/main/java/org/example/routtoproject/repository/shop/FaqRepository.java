package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Faq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : FaqRepository
 * author : KimDJ
 * date : 2024-05-01
 * description :
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-01         KimDJ          최초 생성
 */
@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer> {
@Query(value = "SELECT * FROM LOTTO_FAQ\n" +
        "WHERE FAQ_TITLE LIKE '%'|| :title ||'%'"
        ,countQuery = "SELECT count (*) FROM LOTTO_FAQ\n" +
        "WHERE FAQ_TITLE LIKE '%'|| :title ||'%'"
        ,nativeQuery = true)
    Page<Faq> findAllByTitleContaining(@Param("title") String title,
                                       Pageable pageable
);

@Query(value = "SELECT * FROM LOTTO_FAQ\n" +
        "WHERE USER_ID LIKE '%'||:userId||'%'"
        ,countQuery = "SELECT count (*) FROM LOTTO_FAQ\n" +
        "WHERE USER_ID LIKE '%'|| :userId ||'%'"
        ,nativeQuery = true)
    Page<Faq> findAllByUserIdContaining(@Param("userId") String userID,
                                       Pageable pageable
);

}
