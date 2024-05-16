// noticeQna/FaqListService.js
// 목적 : 부서 CRUD 공통 함수들 정의
import http from "@/utils/http-common"; // spring 통신 정의 파일
import AuthHeader from "../auth/AuthHeader";


class FaqListService {
  // 속성(x), 생성자(x), 공통함수
  // TODO: 전체 조회
  getAll(title, page, size) {
    return http.get(`/user/member/faq?title=${title}&page=${page}&size=${size}`,
    {
      headers: AuthHeader()
    }
    );  
  }
  
  // 유저아이디로 전체조회 내글찾기
  getAllUserId(userId, page, size) {
    return http.get(`/user/member/userid/faq?userId=${userId}&page=${page}&size=${size}`,
    {
      headers: AuthHeader()
    }
    );  
  }

  
  // TODO: 저장, 이미지는 포기하라...
  create(data) {
    console.log(data);
    return http.post("/user/member/faq/save", data,
    {
      headers: AuthHeader()
    }
    );
} 
  getFaqId(faqId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
    return http.get(`/user/member/faq/${faqId}`,
    {
      headers: AuthHeader()
    }
    );
  }


  // TODO: 수정함수 : qnaId, 
  update(faqId, data) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
    return http.put(`/user/member/faq/update/${faqId}`, data,
    {
      headers: AuthHeader()
    }
    );
  }
  
  // TODO: 관리자 :: 답변으로 수정함수 : qnaId, 
  updateAnswer(faqId, data) {
    return http.put(`/admin/faq/updateanswer/${faqId}`, data,
    {
      headers: AuthHeader()
    }
    );
  }

  delete(faqId) {
    console.log(faqId)
    return http.delete(`/user/member/faq/deletion/${faqId}`,
    {
      headers: AuthHeader()
    }
    );
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
