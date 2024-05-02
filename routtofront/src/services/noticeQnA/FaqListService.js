// noticeQna/FaqListService.js
// 목적 : 부서 CRUD 공통 함수들 정의
import http from "@/utils/http-common"; // spring 통신 정의 파일

class FaqListService {
  // 속성(x), 생성자(x), 공통함수
  // TODO: 전체 조회
  getAll(title, page, size) {
    // TODO: 조회(select) : get 방식 -> @GetMapping
    // TODO: 사용법 : http.get("스프링_컨트롤러함수_url")
    return http.get(`/normal/member/faq?title=${title}&page=${page}&size=${size}`);  
  }
  // TODO: 저장, 이미지는 포기하라...
  create(data) {
    // TODO: 사용법 : http.post("컨트롤러함수url", 생성할객체)
    return http.post("/normal/member/faq/save", data);
}

  // TODO: 상세조회 함수1 : 내가쓴글 확인하기? : 회원번호 userId
  // TODO: 조회(select) -> get 방식 -> @GetMapping
  getUserId(userId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
    return http.get(`/normal/member/faq/${userId}`);
  }

  // TODO: 상세조회 함수2 : 쓴 글 조회 후 수정할때 상세조회용
  // TODO: 조회(select) -> get 방식 -> @GetMapping
  getFaqId(faqId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
    return http.get(`/normal/member/faq/${faqId}`);
  }


  // TODO: 수정함수 : qnaId, 
  update(faqId, data) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
    return http.put(`/normal/member/faq/update/${faqId}`, data);
  }

  // TODO: 삭제함수 : 부서번호(dno)
  // TODO: 삭제(delete) -> delete 방식 -> @DeleteMapping
  // TODO: 사용법 : http.delete(`/컨트롤러함수url/${dno}`)
  delete(faqId) {
    return http.delete(`/normal/member/faq/${faqId}`);
  }

  
  // 상세조회 비밀번호 함수
  // getPass(faqId, password) {
  //   // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
  //   return http.get(`/shop/faq/${faqId}?password=${password}`);
  // }


  
}

// 내보내기 : 다른 js 에서 사용하기 위해
// 사용법 : 자바 같음 : 객체.함수명()
export default new FaqListService();
