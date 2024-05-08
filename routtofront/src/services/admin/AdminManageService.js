// 관리자 조회/수정 공통 CRUD 함수
import http from "@/utils/http-common";

class AdminManageService {
  getAll(prodName) {
    return http.get(`/admin/shop/prodName?prodName=${prodName}`);
  }
}

export default new AdminManageService();