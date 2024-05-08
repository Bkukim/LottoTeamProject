package org.example.routtoproject.controller.normal.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.AdBanner;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.AdBannerService;
import org.example.routtoproject.service.shop.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //    TODO: 파일 다운로드 조회 함수
    @GetMapping("/banner/img1/{uuid}")
    public ResponseEntity<byte[]> findImg(@PathVariable String uuid) {
        AdBanner adBanner = adBannerService.findByBannerImg1Uuid(uuid).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + adBanner.getBannerId() + "\"")
                .body(adBanner.getBannerImg1());
    }

}
