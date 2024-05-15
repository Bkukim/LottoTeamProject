// ProductService.js
// 목적 : 부서 CRUD 공통 함수들 정의
import http from "@/utils/http-common"; // spring 통신 정의 파일

class ProductService {
  // TODO: 상세조회 함수 : 상품번호(prodId)
  // TODO: 조회(select) -> get 방식 -> @GetMapping
  get(prodId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${상품번호}`)
    // 상품 상세 조회
    return http.get(`/normal/shop/product/${prodId}`);
  }

  // TODO: 조회(select) -> get 방식 -> @GetMapping
  getAll() {
    return http.get("/normal/shop/product/all");
  }

  getProductByCategory(prodCategory,page,size){
    return http.get(`/normal/shop/product/category?prodCategory=${prodCategory}&page=${page}&size=${size}`)
  }

  getBestProduct(){
    return http.get("/normal/shop/product/best")
  }

  getSearchProductAll(prodName,page,size){
    return http.get(`/normal/shop/product/search?prodName=${prodName}&page=${page}&size=${size}`)
  }
}

export default new ProductService();
