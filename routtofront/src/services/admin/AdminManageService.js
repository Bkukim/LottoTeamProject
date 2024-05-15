// 관리자 조회/수정 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "@/services/auth/AuthHeader";
import AuthHeaderUpload from "../auth/AuthHeaderUpload";

class AdminManageService {
  getAll(prodName) {
    return http.get(`/admin/shop/prodName?prodName=${prodName}`, {
      headers: AuthHeader(),
    });
  }
  // TODO: 상세조회 함수 : 부서번호(dno)
  // TODO: 조회(select) -> get 방식 -> @GetMapping
  get(prodId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
    return http.get(`/admin/shop/product/modify/${prodId}`, {
      headers: AuthHeader(),
    });
  }
  // TODO: 수정함수 : 상품번호(prodId), 수정할 객체(data)
  update(prodId,data) {
    let formData = new FormData();
    formData.append("prodName", data.prodName);
    formData.append("defaultPrice", data.defaultPrice);
    formData.append("prodCategory", data.prodCategory);
    formData.append("prodImg", data.prodImg);
    formData.append("prodDetailPage", data.prodDetailPage);
    formData.append("discountRate", data.discountRate);
    formData.append("prodStock", data.prodStock);
    formData.append("prodStatus", data.prodStatus);
    formData.append("prodImgUrl", data.prodImgUrl);
    formData.append("prodDetailPageUrl", data.prodDetailPageUrl);
    formData.append("prodImgUuid", data.prodImgUuid);
    formData.append("prodDetailPageUuid", data.prodDetailPageUuid);
    console.log(data.prodStatus);
    return http.put(`/admin/shop/product/modify/${prodId}`, formData, {
      headers: AuthHeaderUpload(),
    });
  }
    
    delete(prodId){
      return http.delete(`/admin/shop/product/deletion/${prodId}`, {
        headers: AuthHeader(),
      })
  }
}

export default new AdminManageService();
