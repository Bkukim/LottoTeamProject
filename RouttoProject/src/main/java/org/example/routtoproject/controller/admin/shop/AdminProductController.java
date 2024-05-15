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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

            Product product1 = productService.saveProduct(
                    0,
                    prodName,
                    Integer.parseInt(defaultPrice), // TODO: 정수로 변경
                    prodCategory,
                    prodImg,
                    prodDetailPage,
                    Integer.parseInt(discountRate), // TODO: 정수로 변경
                    Integer.parseInt(prodStock),    // TODO: 정수로 변경
                    "",
                    prodImgUrl,
                    prodDetailPageUrl,
                    prodDetailPageUuid,
                    prodImgUuid);
            return new ResponseEntity<>(/*product1,*/ HttpStatus.OK);


        } catch (Exception e) {
            log.debug(e.getMessage());
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

//      TODO: 상세 조회 : 관리자 조회/수정 페이지 -> 상세 페이지에서 상세조회한 값 불러오기
@GetMapping("/product/modify/{prodId}")
public ResponseEntity<Object> findById(
        @PathVariable int prodId
) {
    try {
        Optional<Product> optionalProduct = productService.findById(prodId);
        if (optionalProduct.isEmpty() == true) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(optionalProduct.get()
                    , HttpStatus.OK);
        }
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    //    TODO: 수정 함수 : 수정 페이지 열기 함수       (x) : vue 제작
    @PutMapping("/product/modify/{prodId}")
    public ResponseEntity<Object> updateProduct(@PathVariable int prodId,
                                                @RequestParam(defaultValue = "") String prodName,
                                                @RequestParam(defaultValue = "0") String defaultPrice,
                                                @RequestParam(defaultValue = "") String prodCategory,
                                                @RequestParam MultipartFile prodImg,
                                                @RequestParam MultipartFile prodDetailPage,

                                                @RequestParam(defaultValue = "0") String discountRate,
                                                @RequestParam(defaultValue = "0") String prodStock,
                                                @RequestParam(defaultValue = "") String prodStatus,


                                                @RequestParam (defaultValue = "")String prodImgUrl,
                                                @RequestParam (defaultValue = "")String prodDetailPageUrl,
                                                @RequestParam (defaultValue = "")String prodDetailPageUuid,
                                                @RequestParam (defaultValue = "")String prodImgUuid){
      try {
        log.debug("된다.1");
        log.debug("상태" + prodStock);
        log.debug("상태" + prodStatus);
        Product product1 = productService.saveProduct(
                prodId,
                prodName,
                Integer.parseInt(defaultPrice), // TODO: 정수로 변경
                prodCategory,
                prodImg,
                prodDetailPage,
                Integer.parseInt(discountRate), // TODO: 정수로 변경
                Integer.parseInt(prodStock),    // TODO: 정수로 변경
                prodStatus,                prodImgUrl,
                prodDetailPageUrl,
                prodDetailPageUuid,
                prodImgUuid);
        return new ResponseEntity<>(/*product1,*/ HttpStatus.OK);


    } catch (Exception e) {
          log.debug(e.getMessage());
          log.debug("된다.2");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    //    TODO: 삭제 함수
    @DeleteMapping("/product/deletion/{prodId}")
    public ResponseEntity<Object> delete(
            @PathVariable int prodId
    ) {
        try {
//            DB 서비스 삭제 함수 실행
            boolean success = productService.removeById(prodId);
//            success 여부에 따라 신호 다르게 보내기
            if(success == true){
                return new ResponseEntity<>(HttpStatus.OK); // 삭제하고나면 데이터가 없어서 프론트에 보내줄 데이터가 없음으로 그냥 OK 만 보내기
            } else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 서버에러가 아님, 삭제를 실행했으나 삭제가 0건 됨(삭제할 데이터가 없어서)
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 500 에러 전송
        }
    }
}
