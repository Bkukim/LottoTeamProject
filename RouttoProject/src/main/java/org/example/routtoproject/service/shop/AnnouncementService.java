package org.example.routtoproject.service.shop;

import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.repository.shop.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : NoticeService
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
@Service
public class AnnouncementService {
    @Autowired
    AnnouncementRepository announcementRepository;

    //    TODO: 전체 조회 함수
    public Page<Announcement> selectByTitleContaining(
            String title,
            Pageable pageable
    ) {
        Page<Announcement> page
                = announcementRepository.findAllByTitleContaining(
                title,
                pageable
        );
        return page;
    }

    //    TODO: 저장(수정)함수 ->
    public Announcement save(Announcement announcement) {
//        DB 저장 함수 실행
        Announcement announcement1 = announcementRepository.save(announcement);
        return announcement1;
    }

//    todo : 상세조회
public Optional<Announcement> findById(int announcementId) {
//        DB 상세조회 실행
    Optional<Announcement> optionalAnnouncement
            = announcementRepository.findById(announcementId);
    return optionalAnnouncement;
}

// todo: 삭제함수
}
