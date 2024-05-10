import http from "@/utils/http-common"; // spring 통신 정의 파일
import AuthHeader from "../auth/AuthHeader";

class ReviewService {
  // TODO: 리뷰 전체 조회
  getAll(page, size) {
    return http.get(`/normal/shop/review?page=${page}&size=${size}`);
  }

  // TODO: 리뷰 상세 조회
  getReview(reviewId) {
    return http.get(`/normal/shop/review/${reviewId}`,
    {
      headers: AuthHeader()
    }
    );
  }

  // TODO: 리뷰 저장함수, 전체 객체 전송
  createReview(data) {
    console.log("이미지 추가", data);
    // TODO: formData 는 무조건 문자열로 전송됨 -> 벡엔드에서 문자열로 받고 정수로 형변환하면 됨
    let formData = new FormData();
    formData.append("userId", data.userId);
    formData.append("prodId", data.prodId);
    formData.append("point", data.point);
    formData.append("reviewContent", data.reviewContent);
    formData.append("reviewImage", data.reviewImage);
    return http.post("/user/shop/review/save", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    },
    {
      headers: AuthHeader()
    });
  }
}

export default new ReviewService();