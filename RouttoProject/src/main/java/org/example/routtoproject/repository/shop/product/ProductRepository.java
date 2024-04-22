package org.example.routtoproject.repository.shop.product;

import org.example.routtoproject.model.entity.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.routtoproject.repository.shop.product
 * fileName : ProductRepository
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
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}