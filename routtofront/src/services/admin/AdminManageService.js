// 관리자 조회/수정 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "@/services/auth/AuthHeader";

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
  update(data) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`컨트롤러함수url/${dno}`, 수정할객체)
    return http.put(`/admin/shop/prodModify/${data.prodId}`, data, {
      headers: AuthHeader(),
    });
  }
}

export default new AdminManageService();
