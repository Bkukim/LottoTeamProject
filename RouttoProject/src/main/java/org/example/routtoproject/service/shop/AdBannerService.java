package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.AdBannerDto;
import org.example.routtoproject.model.entity.shop.AdBanner;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.repository.shop.AdBannerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : AdBannerService
 * author : PC
 * date : 2024-05-07
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-07         PC          최초 생성
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AdBannerService {
    private final AdBannerRepository adBannerRepository;

    public List<AdBannerDto> findAllBanner() {
        List<AdBannerDto> adBanners = adBannerRepository.findAllBanner();
        return adBanners;
    }

    // todo 배너 상세조회 함수
    public Optional<AdBannerDto> findBannerByBannerId(String bannerId) {
        Optional<AdBannerDto> adBanner = adBannerRepository.findBannerByBannerId(bannerId);
        return adBanner;
    }

    // todo 배너 수정 함수(배너 이미지가 1개일때)
//    public void updateBanner(String bannerId,
//                                 int prodId,
//                                 String bannerTitle,
//                                 String bannerContent,
//                                 MultipartFile bannerImg1
//
//    ){
//        try {
//
//                // todo     1-1) uuid 생성하기
//                String bannerImg1Uuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T
//
//
//                // todo  1-2) 다운로드 url 생성 -> 자바함수를 이용 ※여기서 다운로드란 jsp이 spring에서 이미지를 다운받아 가져오는 것.
//                String bannerImg1Url = ServletUriComponentsBuilder
//                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
//                        .path("/api/normal/shop/banner/img1/") // 추가 경로 넣기 : /advanced/fileDb
//                        .path(bannerImg1Uuid) // uuid를 url 제일 마지막에 넣어주기
//                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.
//
//                // todo  1-3) 생성자에 만든 url넣어주기
//               adBannerRepository.updateOneBanner(bannerId,
//                       prodId,
//                       bannerTitle,
//                       bannerContent,
//                       bannerImg1.getBytes(),
//                       bannerImg1Url,
//                       bannerImg1Uuid);
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//
//        }
//
//    }

    // todo 배너 수정 함수 (배너 이미지가 2개 일때)
    public void updateBanner(String bannerId,
                             int prodId,
                             String bannerTitle,
                             String bannerContent,
                             MultipartFile bannerImg1,
                             MultipartFile bannerImg2

    ) {
        try {
            if (bannerImg2 == null) {
                // todo     1-1) uuid 생성하기
                String bannerImg1Uuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T


                // todo  1-2) 다운로드 url 생성 -> 자바함수를 이용 ※여기서 다운로드란 jsp이 spring에서 이미지를 다운받아 가져오는 것.
                String bannerImg1Url = ServletUriComponentsBuilder
                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                        .path("/api/normal/shop/banner/img1/") // 추가 경로 넣기 : /advanced/fileDb
                        .path(bannerImg1Uuid) // uuid를 url 제일 마지막에 넣어주기
                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.

                // todo  1-3) 생성자에 만든 url넣어주기
                AdBanner adBanner = new AdBanner(bannerId,
                        prodId,
                        bannerTitle,
                        bannerContent,
                        bannerImg1.getBytes(),
                        bannerImg1Url,
                        bannerImg1Uuid,
                        null,
                        null,
                        null);

                adBannerRepository.save(adBanner);
            }else {
                // todo     1-1) uuid 생성하기
                String bannerImg1Uuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T
                String bannerImg2Uuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T


                // todo  1-2) 다운로드 url 생성 -> 자바함수를 이용 ※여기서 다운로드란 jsp이 spring에서 이미지를 다운받아 가져오는 것.
                String bannerImg1Url = ServletUriComponentsBuilder
                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                        .path("/api/normal/shop/banner/img1/") // 추가 경로 넣기 : /advanced/fileDb
                        .path(bannerImg1Uuid) // uuid를 url 제일 마지막에 넣어주기
                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.
                 String bannerImg2Url = ServletUriComponentsBuilder
                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                        .path("/api/normal/shop/banner/img2/") // 추가 경로 넣기 : /advanced/fileDb
                        .path(bannerImg2Uuid) // uuid를 url 제일 마지막에 넣어주기
                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.

                // todo  1-3) 생성자에 만든 url넣어주기
                AdBanner adBanner = new AdBanner(bannerId,
                        prodId,
                        bannerTitle,
                        bannerContent,
                        bannerImg1.getBytes(),
                        bannerImg1Url,
                        bannerImg1Uuid,
                        bannerImg2.getBytes(),
                        bannerImg2Url,
                        bannerImg2Uuid);

                adBannerRepository.save(adBanner);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());

        }

    }

    // todo 이미지 불러오기 위한 상세조회
    public Optional<AdBanner> findByBannerImg1Uuid(String uuid){
        Optional<AdBanner> adBanner = adBannerRepository.findByBannerImg1Uuid(uuid);
        return adBanner;
    }
}
