package org.example.routtoproject.controller.admin.user;

import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : org.example.routtoproject.controller.normal.user
 * fileName : NomalAnnouncementController
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
@RestController
@RequestMapping("/api/admin")
public class AdminAnnouncementController {
    @Autowired
    AnnouncementService announcementService;


//    todo: 저장/ 수정함수만들기
//    TODO: 저장함수
//    저장(insert) -> post 방식 -> @PostMapping
@PostMapping("/notice/save")
public ResponseEntity<Object> createAnnouncement(
        @RequestParam(defaultValue = "") String title,
        @RequestParam(defaultValue = "") String content,
        @RequestParam MultipartFile announcementImg
        ,
        @RequestParam(defaultValue = "") String announcementImgUrl,
        @RequestParam(defaultValue = "") String announcementImgUuid
){
    try {
//
//                log.debug("확인용" + prodImg);
//                log.debug("확인용" + prodDetailPage);
        Announcement announcement1 = announcementService.save(
                title,
                content,
                announcementImg,
                announcementImgUrl,
                announcementImgUuid);
        return new ResponseEntity<>(announcement1, HttpStatus.OK);


    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    //    todo: 수정함수
//    수정(update) ->put 방식 ->@PutMapping
    @PutMapping("/notice/update")
    public ResponseEntity<Object> updateAnnouncement(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String content,
            @RequestParam MultipartFile announcementImg,
            @RequestParam(defaultValue = "") String announcementImgUrl,
            @RequestParam(defaultValue = "") String announcementImgUuid
    ){
        try{
//            DB 수정 서비스 함수 실행
            announcementService.save(title, content, announcementImg, announcementImgUrl,announcementImgUuid );
            return new ResponseEntity<>("업로드 수정 성공", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("서버에러",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
