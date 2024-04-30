package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.repository.shop.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * packageName : org.example.routtoproject.service.shop
 * fileName : ProductService
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
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;       // DI

    // todo 전체조회
    public List<Product> findAll(){
        List<Product> product = productRepository.findAll();
        return product;
    }

    // todo : page 전체조회
    public Page<Product> findAllByProdNameContaining(
            String prodName,
            Pageable pageable
    ) {
        Page<Product> page
                = productRepository.findAllByProdNameContaining(
                prodName,
                pageable
        );
        return page;
    }

    //    TODO: 상세조회
    public Optional<Product> findById(int prodId) {
        Optional<Product> product = productRepository.findById(prodId);
        return product;
    }


    // 상품 저장함수
    public Product save(String prodName,
                        int defaultPrice,
                        String prodCategory,
                        MultipartFile prodImg,
                        MultipartFile prodDetailPage,
                        int discountRate,
                        int prodStock,
                        String prodImgUrl,// 파일 업로드 클래스로, 이 형태로 파일이 이동되므로 이 형태로 파일을  받아야한다는 거을 정해주는 것.
                        String prodDetailPageUrl// 파일 업로드 클래스로, 이 형태로 파일이 이동되므로 이 형태로 파일을  받아야한다는 거을 정해주는 것.
    ) { // 파일을 만들때는 예외처리가 필요하다. 그리고 매개변수를 객체로 받으면 복잡할 수 있어서 변수로 받는다.
        Product product2 = null;
        try {
//            TODO: null 아님 -> "" 고침
            if (prodImgUrl.equals("") && prodDetailPageUrl.equals("")) {
                // todo : 기본키가 없을때 : insert
                //      1-1) uuid 생성하기
                String prodImgUuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T
                String prodDetailPageUuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법
                // xxxx-xxxx-xxxx-xx...이런 형태로 만들어진다. 근데 "-"가 보기 좋지 않으니 없애보자. replace 함수 이용

                // todo  1-2) 다운로드 url 생성 -> 자바함수를 이용 ※여기서 다운로드란 jsp이 spring에서 이미지를 다운받아 가져오는 것.
                String prodImgDownload = ServletUriComponentsBuilder
                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                        .path("/api/normal/shop/product/img/") // 추가 경로 넣기 : /advanced/fileDb
                        .path(prodImgUuid) // uuid를 url 제일 마지막에 넣어주기
                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.
                String prodDetailPageDownload = ServletUriComponentsBuilder
                        .fromCurrentContextPath()// 스프링 서버 기본 주소 : localhost:8000
                        .path("/api/normal/shop/product/page/") // 추가 경로 넣기 : /advanced/fileDb
                        .path(prodDetailPageUuid) // uuid를 url 제일 마지막에 넣어주기
                        .toUriString(); // 위의 url을 하나로 합쳐주는 함수 http://localhost:8000/advanced/fileDb/xxxx 가 된다.

                // todo  1-3) 생성자에 만든 url넣어주기
                Product product = new Product(prodName,
                        defaultPrice,
                        prodCategory,
                        prodImg.getBytes(), // 파일 데이터
                        prodDetailPage.getBytes(), // 파일 데이터
                        discountRate,
                        prodStock,
                        prodImgDownload,
                        prodDetailPageDownload,
                        prodImgUuid,
                        prodDetailPageUuid); // 우리가 만든 url
                product2 = productRepository.save(product);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());

        }
        return product2;
    }

    public Optional<Product> findImgByUuid(String uuid){
        Optional<Product> product = productRepository.findByProdImgUuid(uuid);
        return product;
    }
    public Optional<Product> findPageByUuid(String uuid){
        Optional<Product> product = productRepository.findByProdDetailPageUuid(uuid);
        return product;
    }
}