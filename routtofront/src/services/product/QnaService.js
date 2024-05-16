import http from "@/utils/http-common"; // spring 통신 정의 파일
import AuthHeader from "../auth/AuthHeader";

class QnaService {
  // 속성(x), 생성자(x), 공통함수
  // TODO: 전체 조회
  getAllQna(prodId, page, size) {
    return http.get(
      `/normal/shop/qna?prodId=${prodId}&page=${page}&size=${size}`,
    );

  }

    // TODO: 관리자가 QnA 전체 조회
    getAllAdminQna(page, size) {
      return http.get(
        `/admin/qna?page=${page}&size=${size}`,{
          headers: AuthHeader(),
        }
      );
    }

  // TODO: 저장함수
  create(data) {
    console.log(data);
    // TODO: 사용법 : http.post("컨트롤러함수url", 생성할객체)
    return http.post("/user/shop/qna/save", data, {
      headers: AuthHeader(),
    });
  }

  // TODO: 상세조회 함수 : 쓴 글 조회 후 수정할때 상세조회용
  // TODO: 조회(select) -> get 방식 -> @GetMapping
  getQnaId(qnaId) {
    return http.get(`/normal/shop/qna/${qnaId}`);
  }

  // TODO: 수정함수 : qnaId,
  update(qnaId, data) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
    return http.put(`/user/shop/qna/update/${qnaId}`, data, {
      headers: AuthHeader(),
    });
  }

    // TODO: 관리자 :: 답변으로 수정함수 : qnaId,
    updateAdminAnswer(qnaId, data) {
      return http.put(`/admin/qna/update/${qnaId}`, data,
      {
        headers: AuthHeader()
      }
      );
    }

  // TODO: 삭제함수 : 부서번호(dno)
  // TODO: 삭제(delete) -> delete 방식 -> @DeleteMapping
  // TODO: 사용법 : http.delete(`/컨트롤러함수url/${dno}`)
  delete(qnaId) {
    console.log(qnaId);
    return http.delete(`/user/shop/qna/deletion/${qnaId}`, {
      headers: AuthHeader(),
    });
  }

  // userId로 전체조회 내글찾기
  getAllUserId(writerId, page, size) {
    // TODO: 조회(select) : get 방식 -> @GetMapping
    // TODO: 사용법 : http.get("스프링_컨트롤러함수_url")
    return http.get(
      `/user/shop/userId/qna?writerId=${writerId}&page=${page}&size=${size}`,
      {
        headers: AuthHeader(),
      }
    );
  }
}

export default new QnaService();
