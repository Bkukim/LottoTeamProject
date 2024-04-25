// noticeQna/FaqListService.js
// 목적 : 부서 CRUD 공통 함수들 정의
import http from "@/utils/http-common"; // spring 통신 정의 파일

class FaqListService {
    // 속성(x), 생성자(x), 공통함수
    // TODO: 전체 조회
    getAll(userId, faqId, page, size) {
        // TODO: 조회(select) : get 방식 -> @GetMapping
        // TODO: 사용법 : http.get("스프링_컨트롤러함수_url")
        // 예) axios_기본주소 + 추가 url 
            // => http://localhost:8000/api + /basic/dept?dname=SALES&page=0&size=3
            // => http://localhost:8000/api/basic/dept?dname=SALES&page=0&size=3
        return http.get(`/shop/faq/${userId}/${faqId}?page=${page}&size=${size}`);
    }
    // TODO: 추가(insert) 함수 -> post 방식 -> @PostMapping
     create(faq, fileImg){
        let formData= new FormData();
        formData.append("userId", faq.userId);
        formData.append("faqId", faq.faqId);
        formData.append("faqTitle", faq.faqTitle);
        formData.append("faqType", faq.faqType);
        formData.append("faqContent", faq.faqContent);
        formData.append("faqPassword", faq.faqPassword);
        formData.append("fileImg", fileImg);
        return http.post("/faq/uploadImg", formData, {
            headers: {
                "Content-Type" : "multipart/form-data",
            },
        })
    }

    // TODO: 상세조회 함수1 : 내가쓴글 확인하기? : 회원번호 userId
    // TODO: 조회(select) -> get 방식 -> @GetMapping
    getUserId(userId) {
        // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
        return http.get(`/shop/faq/${userId}`);
    }

    // TODO: 상세조회 함수2 : 쓴 글 조회 후 수정할때 상세조회용
    // TODO: 조회(select) -> get 방식 -> @GetMapping
    getFaqId(faqId) {
        // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
        return http.get(`/shop/faq/${faqId}`);
    }

    // TODO: 수정함수 : qnaId, 수정할객체(data)
    update(qnaId, data) {
        // TODO: 수정(update) -> put 방식 -> @PutMapping
        // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
        return http.put(`/shop/faq/${qnaId}`, data);
    }

    // TODO: 삭제함수 : 부서번호(dno)
    // TODO: 삭제(delete) -> delete 방식 -> @DeleteMapping
    // TODO: 사용법 : http.delete(`/컨트롤러함수url/${dno}`)
    delete(qnaId) {
        return http.delete(`/shop/faq/deletion/${qnaId}`);
    }

}

// 내보내기 : 다른 js 에서 사용하기 위해
// 사용법 : 자바 같음 : 객체.함수명()
export default new FaqListService();
