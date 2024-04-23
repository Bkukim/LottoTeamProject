package org.example.routtoproject.controller.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**
 * packageName : org.example.routtoproject.controller.shop
 * fileName : ProductController
 * author : hayj6
 * date : 2024-04-22(022)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-22(022)         hayj6          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;        // DI

    //       TODO: 상세 조회 함수
    @GetMapping("/product/{prodId}")
    public ResponseEntity<Object> findById(@PathVariable int prodId){
        try{
            Optional<Product> product = productService.findById(prodId);
            if (product.isEmpty() == false) {
                return new ResponseEntity<>(product.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Object> createProduct(@RequestParam(defaultValue = "") String prodName,
                                                @RequestParam (defaultValue = "0") String defaultPrice,
                                                @RequestParam (defaultValue = "")String prodCategory,
                                                @RequestParam MultipartFile prodImg,
                                                @RequestParam MultipartFile prodDetailPage,
                                                @RequestParam (defaultValue = "0")String discountRate,
                                                @RequestParam (defaultValue = "0")String prodStock,
                                                @RequestParam (defaultValue = "")String prodImgUrl,
                                                @RequestParam (defaultValue = "")String prodDetailPageUrl
                                                ){
        try {


                Product product1 = productService.save(
                        prodName,
                        Integer.parseInt(defaultPrice), // TODO: 정수로 변경
                        prodCategory,
                        prodImg,
                        prodDetailPage,
                        Integer.parseInt(discountRate), // TODO: 정수로 변경
                        Integer.parseInt(prodStock),    // TODO: 정수로 변경
                        prodImgUrl,
                        prodDetailPageUrl);
                return new ResponseEntity<>(product1, HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
