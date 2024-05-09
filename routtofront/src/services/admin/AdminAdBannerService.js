// 주문 공통 CRUD 함수
import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";

class AdminAdBannerService {
  findAllBanner(){
    return http.get("/admin/shop/banner",
    {
      headers: AuthHeader()
    });
  }

  findBabber(bannerId){
    return http.get(`/admin/shop/banner/${bannerId}`,
    {
      headers: AuthHeader()
    });
  }

  updateBanner(data){
    let formData = new FormData();
    formData.append("prodId", data.prodId);
    formData.append("bannerTitle", data.bannerTitle);
    formData.append("bannerContent", data.bannerContent);
    formData.append("bannerImg1", data.bannerImg1);
    formData.append("bannerImg2", data.bannerImg2);
   
    return http.put(`/admin/shop/banner/update/${data.bannerId}`, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    },
    {
      headers: AuthHeader()
    });
  }

  // updateTwoBanner(data){
  //   let formData = new FormData();
  //   formData.append("prodId", data.prodId);
  //   formData.append("bannerTitle", data.bannerTitle);
  //   formData.append("bannerContent", data.bannerContent);
  //   formData.append("bannerImg1", data.bannerImg1);
  //   formData.append("bannerImg1", data.bannerImg2);
  //   return http.put(`/admin/shop/banner/update/two/${data.bannerId}`, formData, {
  //     headers: {
  //       "Content-Type": "multipart/form-data",
  //     },
  //   });
  // }

}

export default new AdminAdBannerService();