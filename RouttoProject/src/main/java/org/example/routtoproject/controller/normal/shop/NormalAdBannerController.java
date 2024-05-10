package org.example.routtoproject.controller.normal.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.AdBannerDto;
import org.example.routtoproject.model.entity.shop.AdBanner;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.AdBannerService;
import org.example.routtoproject.service.shop.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : org.example.routtoproject.controller.normal.shop
 * fileName : NormalAdBannerController
 * author : PC
 * date : 2024-05-08
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-08         PC          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/normal/shop")
@RequiredArgsConstructor
public class NormalAdBannerController {
    private final AdBannerService adBannerService;

    // todo 배너 전체조회
    @GetMapping("/banner")
    public ResponseEntity<Object> findAllBanner(){
        try {
            List<AdBannerDto> banners = adBannerService.findAllBanner();
            log.debug(" 여기는 컨트롤러 배너 배열 = " + banners);
            return new ResponseEntity<>(banners, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 파일 다운로드 조회 함수
    @GetMapping("/banner/img1/{uuid}")
    public ResponseEntity<byte[]> findImg(@PathVariable String uuid) {
        AdBanner adBanner = adBannerService.findByBannerImg1Uuid(uuid).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + adBanner.getBannerId() + "\"")
                .body(adBanner.getBannerImg1());
    }

    @GetMapping("/banner/img2/{uuid}")
    public ResponseEntity<byte[]> findImg2(@PathVariable String uuid) {
        AdBanner adBanner = adBannerService.findByBannerImg2Uuid(uuid).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + adBanner.getBannerId() + "\"")
                .body(adBanner.getBannerImg2());
    }

}
