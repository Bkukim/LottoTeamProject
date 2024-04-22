package org.example.routtoproject.service.shop;

import lombok.RequiredArgsConstructor;
import org.example.routtoproject.model.entity.shop.Product;
import org.example.routtoproject.repository.shop.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;       // DI

    //    TODO: 상세조회
    public Optional<Product> findById(int prodId) {
        Optional<Product> product = productRepository.findById(prodId);
        return product;
    }
}