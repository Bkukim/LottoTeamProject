import http from "@/utils/http-common"; // spring 통신 정의 파일
import AuthHeader from "../auth/AuthHeader";

class QnaService {
  // 속성(x), 생성자(x), 공통함수
  // TODO: 전체 조회
  getAll(page, size) {
    // TODO: 조회(select) : get 방식 -> @GetMapping
    // TODO: 사용법 : http.get("스프링_컨트롤러함수_url")
    return http.get(
      `/normal/shop/qna?page=${page}&size=${size}`,
      {
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

  //   // TODO: 수정함수 : qnaId,
  //   update(faqId, data) {
  //     // TODO: 수정(update) -> put 방식 -> @PutMapping
  //     // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
  //     return http.put(`/user/member/faq/update/${faqId}`, data,
  //     {
  //       headers: AuthHeader()
  //     }
  //     );
  //   }

  //   // TODO: 관리자 :: 답변으로 수정함수 : qnaId,
  //   updateAnswer(faqId, data) {
  //     // TODO: 수정(update) -> put 방식 -> @PutMapping
  //     // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
  //     return http.put(`/admin/faq/updateanswer/${faqId}`, data,
  //     {
  //       headers: AuthHeader()
  //     }
  //     );
  //   }

  //   // TODO: 삭제함수 : 부서번호(dno)
  //   // TODO: 삭제(delete) -> delete 방식 -> @DeleteMapping
  //   // TODO: 사용법 : http.delete(`/컨트롤러함수url/${dno}`)
  //   delete(faqId) {
  //     console.log(faqId)
  //     return http.delete(`/user/member/faq/deletion/${faqId}`,
  //     {
  //       headers: AuthHeader()
  //     }
  //     );
  //   }
}

export default new QnaService();
