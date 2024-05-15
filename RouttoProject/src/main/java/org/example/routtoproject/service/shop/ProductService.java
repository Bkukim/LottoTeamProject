package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.routtoproject.model.dto.shop.IProdNameDto;
import org.example.routtoproject.model.dto.shop.IProductDto;
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

    // todo 카테고리에 따른 상품 조회
    public Page<IProductDto> findAllByProdCategory(String prodCategory, Pageable pageable){
        Page<IProductDto> products = productRepository.findAllByProdCategory(prodCategory, pageable);
        return products;
    }
    // todo 판매량에 따른 상품 조회
    public Page<IProductDto> findAllBySoldCount( Pageable pageable){
        Page<IProductDto> products = productRepository.findAllBySoldCount( pageable);
        return products;
    }

    // todo 전체조회
    public Page<IProductDto> findAllByProdName(String prodName, Pageable pageable){
        Page<IProductDto> product = productRepository.findAllByProdNameContaining(prodName, pageable);
        return product;
    }


    // todo 전체조회
    public List<IProductDto> findAllImg(){
        List<IProductDto> product = productRepository.findAllImg();
        return product;
    }




    //    TODO: 상세조회
    public Optional<Product> findById(int prodId) {
        Optional<Product> product = productRepository.findById(prodId);
        return product;
    }


    // 상품 저장함수
    public Product saveProduct(int prodId,
                        String prodName,
                        int defaultPrice,
                        String prodCategory,
                        MultipartFile prodImg,
                        MultipartFile prodDetailPage,
                        int discountRate,
                        int prodStock,
                        String prodStatus,
                        String prodImgUrl,// 파일 업로드 클래스로, 이 형태로 파일이 이동되므로 이 형태로 파일을  받아야한다는 거을 정해주는 것.
                        String prodDetailPageUrl,// 파일 업로드 클래스로, 이 형태로 파일이 이동되므로 이 형태로 파일을  받아야한다는 거을 정해주는 것.
                        String prodImgUuid,
                        String prodDetailPageUuid

    ) { // 파일을 만들때는 예외처리가 필요하다. 그리고 매개변수를 객체로 받으면 복잡할 수 있어서 변수로 받는다.
        Product product2 = null;
        try {
//            TODO: null 아님 -> "" 고침
            if (prodId == 0) {
                // todo : 기본키가 없을때 : insert
                //      1-1) uuid 생성하기
                 prodImgUuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법T
                 prodDetailPageUuid = UUID.randomUUID().toString().replace("-", ""); // uuid 만드는 방법
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

           }else {
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
                Product product = new Product(
                        prodId,
                        prodName,
                        defaultPrice,
                        prodCategory,
                        prodImg.getBytes(), // 파일 데이터
                        prodDetailPage.getBytes(), // 파일 데이터
                        discountRate,
                        prodStock,
                        prodStatus,
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

//    todo: 상품페이지 이미지
    public Optional<Product> findImgByUuid(String uuid){
        Optional<Product> product = productRepository.findByProdImgUuid(uuid);
        return product;
    }
//    todo: 상품페이지 상세이미지
    public Optional<Product> findPageByUuid(String uuid){
        Optional<Product> product = productRepository.findByProdDetailPageUuid(uuid);
        return product;
    }

//    TODO: 관리자 조회/수정 페이지 : 전체 조회 + 상품 이름으로 검색
    public List<IProdNameDto> findByProdName(String prodName) {
        List<IProdNameDto> product = productRepository.findByProdName(prodName);
        return product;
    }

    //    todo: 관리자 조회/수정 상세 페이지 : 저장/수정 : 1) 기본키가 없으면 저장(insert)
//              2) 기본키가 있으면 수정(update)
//              => JPA에는 내부적으로 if문이 있음 : 알아서 실행됨
    public Product save(Product product) {
//        JPA의 저장함수 save : dept 객체안에 기본키가 있는지, 없는지 -> insert, update
        Product product1 = productRepository.save(product);
        return product1;
    }

//      todo: 관리자 조회/수정 페이지 -> 삭제 버튼
public boolean removeById(int prodId) {
//        JPA 삭제 함수 : deleteById(기본키)
//        1) 먼저 기본키가 테이블에 있으면 삭제, true로 리턴
//        2) 없으면 false 리턴
//        TODO: 사용법 : jpa레포지토리.existById(기본키)
//                     => 기본키가 테이블에 있는지 확인 -> 있으면 true, 없으면 false
    if (productRepository.existsById(prodId) == true) {
        productRepository.deleteById(prodId);
        return true;
    } else {
        return false;
    }
}

}