package org.example.routtoproject.controller.admin.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.AdBannerDto;
import org.example.routtoproject.model.entity.shop.AdBanner;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.AdBannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * packageName : org.example.routtoproject.controller.admin
 * fileName : AdBannerController
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
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/shop")
public class AdBannerController {

    private final AdBannerService adBannerService;

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

    // todo 배너 상세 조회 함수
    @GetMapping("/banner/{bannerId}")
    public ResponseEntity<Object> findBanner(@PathVariable String  bannerId){
        try {
            AdBannerDto banner = adBannerService.findBannerByBannerId(bannerId).get();
            return new ResponseEntity<>(banner, HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // todo 배너 수정 함수
    @PutMapping("/banner/update/{bannerId}")
    public ResponseEntity<Object> updateBanner(@PathVariable String bannerId,
                                               @RequestParam (defaultValue = "0") String prodId,
                                               @RequestParam (defaultValue = "") String bannerTitle,
                                               @RequestParam (defaultValue = "") String bannerContent,
                                               @RequestParam MultipartFile bannerImg1,
                                               @RequestParam MultipartFile bannerImg2
                                               ){
        try {
             adBannerService.updateBanner(
                    bannerId,
                    Integer.parseInt(prodId), // TODO: 정수로 변경
                    bannerTitle,
                    bannerContent,
                    bannerImg1,
                    bannerImg2
             );
            return new ResponseEntity<>( HttpStatus.OK);
        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    // todo 배너 수정 함수
//    @PutMapping("/banner/update/two/{bannerId}")
//    public ResponseEntity<Object> updateTwoBanner(@PathVariable String bannerId,
//                                               @RequestParam (defaultValue = "0") String prodId,
//                                               @RequestParam (defaultValue = "") String bannerTitle,
//                                               @RequestParam (defaultValue = "") String bannerContent,
//                                               @RequestParam MultipartFile bannerImg1
//                                               ){
//        try {
//             adBannerService.updateTwoBanner(
//                    bannerId,
//                    Integer.parseInt(prodId), // TODO: 정수로 변경
//                    bannerTitle,
//                    bannerContent,
//                    bannerImg1);
//            return new ResponseEntity<>( HttpStatus.OK);
//        }catch (Exception e){
//            log.debug(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
