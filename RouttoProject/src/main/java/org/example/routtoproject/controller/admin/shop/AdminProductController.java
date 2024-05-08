package org.example.routtoproject.controller.admin.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.IProdNameDto;
import org.example.routtoproject.model.entity.shop.Order;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName : org.example.routtoproject.controller.admin.shop
 * fileName : AdminProductService
 * author : PC
 * date : 2024-05-06
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-06         PC          최초 생성
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/shop")
public class AdminProductController {

    private final ProductService productService;        // DI

    @PostMapping("/product")
    public ResponseEntity<Object> createProduct(@RequestParam(defaultValue = "") String prodName,
                                                @RequestParam(defaultValue = "0") String defaultPrice,
                                                @RequestParam(defaultValue = "") String prodCategory,
                                                @RequestParam MultipartFile prodImg,
                                                @RequestParam MultipartFile prodDetailPage,

                                                @RequestParam(defaultValue = "0") String discountRate,
                                                @RequestParam(defaultValue = "0") String prodStock,


                                                @RequestParam (defaultValue = "")String prodImgUrl,
                                                @RequestParam (defaultValue = "")String prodDetailPageUrl,
                                                @RequestParam (defaultValue = "")String prodDetailPageUuid,
                                                @RequestParam (defaultValue = "")String prodImgUuid
    ){

        try {
//
//                log.debug("확인용" + prodImg);
//                log.debug("확인용" + prodDetailPage);
            Product product1 = productService.save(
                    prodName,
                    Integer.parseInt(defaultPrice), // TODO: 정수로 변경
                    prodCategory,
                    prodImg,
                    prodDetailPage,
                    Integer.parseInt(discountRate), // TODO: 정수로 변경
                    Integer.parseInt(prodStock),    // TODO: 정수로 변경
                    prodImgUrl,
                    prodDetailPageUrl,
                    prodDetailPageUuid,
                    prodImgUuid);
            return new ResponseEntity<>(/*product1,*/ HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    TODO: 관리자 조회/수정 페이지 : 전체 조회 함수 + 검색
    @GetMapping("/prodName")
    public ResponseEntity<Object> findByProdName(
            @RequestParam(defaultValue = "") String prodName
    ) {
        try {
            List<IProdNameDto> products = productService.findByProdName(prodName);
            if (products.isEmpty() == true) {
//                log.debug("1");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 데이터가 없으면 response를 보낼필요가 없음
            } else {
//                log.debug("2");
//                log.debug("2" + products);
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
