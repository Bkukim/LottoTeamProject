package org.example.routtoproject.controller.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.service.shop.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
