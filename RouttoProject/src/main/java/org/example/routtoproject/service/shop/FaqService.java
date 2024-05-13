package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Announcement;
import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.repository.shop.FaqRepository;
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
 * fileName : FaqService
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
@Slf4j
@Service
public class FaqService {
    @Autowired
    FaqRepository faqRepository;

//    전체조회
    public Page<Faq> selectByTitleContaining(
            String title,
            Pageable pageable
    ) {
        Page<Faq> page
                = faqRepository.findAllByTitleContaining(
                title,
                pageable
        );
        return page;
    }
//    상세조회
//    todo : userId전체조회
//    전체조회
public Page<Faq> selectByUserIdContaining(
        String userId,
        Pageable pageable
) {
    Page<Faq> page
            = faqRepository.findAllByUserIdContaining(
            userId,
            pageable
    );
    return page;
}
public Optional<Faq> findById(int faqId) {
//        DB 상세조회 실행
    Optional<Faq> faqOptional
            = faqRepository.findById(faqId); //crud레포짓토리
    return faqOptional;
}
//TODO : userId 상세조회 -> 전체조회로 변경
//public Optional<Faq> findByUserId(String userId) {
//    log.debug("서비스가 실행되었나요?");
//
//    // 사용자 ID에 해당하는 엔티티 검색
//    Optional<Faq> faqOptional = faqRepository.findByUserId(userId);
//    return faqOptional;
//}

// todo: 저장
public Faq save(Faq faq) {
//        JPA 저장 함수 실행 : return 값 : 저장된 객체
    Faq faq1 = faqRepository.save(faq);
    return faq1;
}
// todo: 삭제
    public boolean removeById(int faqId) {
//        JPA 삭제함수 : deleteById(기본키)
//        1) 먼저 기본키가 테이블에 있으면 삭제, true 리턴
//           없으면 false 리턴
//        사용법 : jpa레포지토리.existsById(기본키)
//         => 기본키가 테이블에 있으지 확인. 있으면 true, 없으면 false
        if(faqRepository.existsById(faqId) == true) {
            faqRepository.deleteById(faqId);
            return true;
        } else {
            return false;
        }
    }
}
