package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.repository.shop.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

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
@Slf4j
@Service
@RequiredArgsConstructor
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

//todo: 저장/수정함수 만들기
//     1) 기본키가(부서번호) 없으면 저장(insert)
//     2) 기본키가(부서번호) 있으면 수정(update)
public Announcement save(
        int announcementId,
        String title,
        String content,
        MultipartFile announcementImg,
        String announcementImgUrl,
        String announcementImgUuid
       ) { // 파일을 만들때는 예외처리가 필요하다. 그리고 매개변수를 객체로 받으면 복잡할 수 있어서 변수로 받는다.
    Announcement announcement1 = null; //나중에 사용할거라 null
    try {
//            TODO: null 아님 -> "" 고침
        if (announcementImgUuid.equals("")) {
            // todo : 기본키가 없을때 : insert
            //      1-1) uuid 생성하기
            announcementImgUuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T
            // xxxx-xxxx-xxxx-xx...이런 형태로 만들어진다. 근데 "-"가 보기 좋지 않으니 없애보자. replace 함수 이용

            // todo  1-2) 다운로드 url 생성 -> 자바함수를 이용 ※여기서 다운로드란 jsp이 spring에서 이미지를 다운받아 가져오는 것.
            announcementImgUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                    .path("/api/normal/member/notice/save") // 추가 경로 넣기 : /advanced/fileDb
                    .path(announcementImgUuid) // uuid를 url 제일 마지막에 넣어주기
                    .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.

            // todo  1-3) 생성자에 만든 url넣어주기
            Announcement announcement = new Announcement(

                    title,
                    content,
                    announcementImg.getBytes(),
                    announcementImgUrl,
                    announcementImgUuid);
            announcement1 = announcementRepository.save(announcement);
        }else {
            // todo  1-3) 생성자에 만든 url넣어주기
            Announcement announcement = new Announcement(
                    announcementId,
                    title,
                    content,
                    announcementImg.getBytes(),
                    announcementImgUrl,
                    announcementImgUuid);
            Announcement announcement2 = announcementRepository.save(announcement);
            return announcement2;
        }
    } catch (Exception e) {
        log.debug(e.getMessage());

    }
    return announcement1;
}


//    todo : 상세조회
public Optional<Announcement> findById(int announcementId) {
//        DB 상세조회 실행
    Optional<Announcement> optionalAnnouncement
            = announcementRepository.findById(announcementId);
    return optionalAnnouncement;
}

//   todo: 이미지 불러오는 함수
public Optional<Announcement> findImgByUuid(String uuid){
    Optional<Announcement> announcement = announcementRepository.findByAnnouncementImgUuid(uuid);
    return announcement;
}
// 삭제함수
    public boolean removeById(int announcementId) {
//        JPA 삭제함수 : deleteById(기본키)
//        1) 먼저 기본키가 테이블에 있으면 삭제, true 리턴
//           없으면 false 리턴

//        사용법 : jpa레포지토리.existsById(기본키)
//         => 기본키가 테이블에 있으지 확인. 있으면 true, 없으면 false
        if(announcementRepository.existsById(announcementId) == true) {
            announcementRepository.deleteById(announcementId);
            return true;
        } else {
            return false;
        }
    }

}

