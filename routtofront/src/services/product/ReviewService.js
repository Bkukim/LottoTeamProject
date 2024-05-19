import http from "@/utils/http-common"; // spring 통신 정의 파일
import AuthHeaderUpload from "@/services/auth/AuthHeaderUpload";
import AuthHeader from "../auth/AuthHeader";

class ReviewService {
  // TODO: 리뷰 전체 조회
  getReviewByprodId(prodId, page, size) {
    return http.get(`/normal/shop/review?prodId=${prodId}&page=${page}&size=${size}`);
  }

  // TODO: 리뷰 상세 조회
  getReview(reviewId) {
    return http.get(`/normal/shop/review/${reviewId}`,
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
    return http.post("/user/shop/review/save", formData, 
    {
      headers: AuthHeaderUpload()
    });
  }

    // userId로 전체조회 내글찾기
    getAllReviewUserId(userId, page, size) {
      // TODO: 조회(select) : get 방식 -> @GetMapping
      // TODO: 사용법 : http.get("스프링_컨트롤러함수_url")
      return http.get(
        `/user/shop/userId/review?userId=${userId}&page=${page}&size=${size}`,
        {
          headers: AuthHeader(),
        }
      );
    }
}

export default new ReviewService();