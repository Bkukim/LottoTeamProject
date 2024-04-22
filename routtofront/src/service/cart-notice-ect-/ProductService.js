// axios Crud 공통함수
// 상품 공통함수
import http from "@/utils/http-common";
class ProductService{
    // todo : 전체 조회
    getAll(title, page, size){
        // 제목검색 위해서 title 받음
        // 조회 select -> get -> @GetMapping
        return http.get(`/shop/product?title=${title}&page${page}&size${size}`);
    }
    // todo : 상품 상세 조회 : 기본키(상품번호(spno))
    // 조회(select)->get 방식 -> @GetMapping
    get(spno){
        return http.get(`/shop/product/${spno}`);
    }
}

// 객체생성
export default new ProductService();