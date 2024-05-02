package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : NoticeRepository
 * author : KimDJ
 * date : 2024-04-29
 * description :
 * 요약 :
 *
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-29         KimDJ          최초 생성
 */
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    Optional<Announcement> findByAnnouncementImgUuid(String announcementImgUrl);
    @Query(value = "SELECT * FROM LOTTO_ANNOUNCEMENT\n" +
            "WHERE TITLE LIKE '%'|| :title ||'%'"
            , countQuery = "SELECT count(*) FROM LOTTO_ANNOUNCEMENT\n" +
            "WHERE TITLE LIKE '%'|| :title ||'%'"
            , nativeQuery = true)
    Page<Announcement> findAllByTitleContaining(@Param("title") String title,
                                                Pageable pageable
    );
}
