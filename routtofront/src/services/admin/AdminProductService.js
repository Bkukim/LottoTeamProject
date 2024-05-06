// 주문 공통 CRUD 함수
import http from "@/utils/http-common";

class AdminProductService {
 

  createProduct(data) {
    // TODO: formData 는 무조건 문자열로 전송됨 -> 벡엔드에서 문자열로 받고 정수로 형변환하면 됨

    console.log(data);
    let formData = new FormData();
    formData.append("prodName", data.prodName);
    formData.append("defaultPrice", data.defaultPrice);
    formData.append("prodCategory", data.prodCategory);
    formData.append("prodImg", data.prodImg);
    formData.append("prodDetailPage", data.prodDetailPage);
    formData.append("discountRate", data.discountRate);
    formData.append("prodStock", data.prodStock);
    formData.append("prodImgUrl", data.prodImgUrl);
    formData.append("prodDetailPageUrl", data.prodDetailPageUrl);
    return http.post("/admin/shop/product", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
  }
}

export default new AdminProductService();
