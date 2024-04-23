// ProductService.js
// 목적 : 부서 CRUD 공통 함수들 정의
import http from "@/utils/http-common"; // spring 통신 정의 파일

class ProductService{
    // TODO: 상세조회 함수 : 부서번호(dno)
    // TODO: 조회(select) -> get 방식 -> @GetMapping
    get(prodId) {
        // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
        return http.get(`/shop/product/${prodId}`);
    }
    create(data){
        let formData = new FormData();
        formData.append("prodName", data.prodName);
        formData.append("defaultPrice", data.defaultPrice);
        formData.append("prodCategory", data.prodCategory);
        formData.append("prodCategory", data.prodCategory);
        formData.append("prodImg", data.prodImg);
        formData.append("prodDetailPage", data.prodDetailPage);
        formData.append("discountRate", data.discountRate);
        formData.append("prodStock", data.prodStock);
        formData.append("soldCount", data.soldCount);
        formData.append("prodImgUrl", data.prodImgUrl);
        formData.append("prodDetailPageUrl", data.prodDetailPageUrl);
        return http.post("/shop/product", formData, {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          });
    }
}
export default new ProductService();
