// NoticeListService.js
// 목적 : 부서 CRUD 공통 함수들 정의
import http from "@/utils/http-common"; // spring 통신 정의 파일
import AuthHeader from "../auth/AuthHeader";

import AuthHeaderUpload from "../auth/AuthHeaderUpload";
class NoticeListService {
  // 속성(x), 생성자(x), 공통함수
  // TODO: 전체 조회
  getAll(title, page, size) {
    // TODO: 조회(select) : get 방식 -> @GetMapping
    // TODO: 사용법 : http.get("스프링_컨트롤러함수_url")
    // 예) axios_기본주소 + 추가 url
    // => http://localhost:8000/api + /basic/dept?dname=SALES&page=0&size=3
    // => http://localhost:8000/api/basic/dept?dname=SALES&page=0&size=3
    // 여기는 컨트롤러주소
    return http.get(
      `/normal/member/notice?title=${title}&page=${page}&size=${size}`
    );
  }

  // TODO: 검색용 전체조회 함수
  getAllSearch(title, page, size) {
    // 예) axios_기본주소 + 추가 url
    // => http://localhost:8000/api + /basic/dept?dname=SALES&page=0&size=3
    // => http://localhost:8000/api/basic/dept?dname=SALES&page=0&size=3
    // 여기는 컨트롤러주소
    return http.get(
      `/normal/member/notice-search?title=${title}&page=${page}&size=${size}`
    );
  }

  // // TODO: 추가(insert) 함수 -> post 방식 -> @PostMapping
  // create(data) {
  //     // TODO: 사용법 : http.post("컨트롤러함수url", 생성할객체)
  //     return http.post("/shop/notice", data);
  // }
  // TODO: 저장함수
  create(announcement, announcementImg) {
    let formData = new FormData();
    formData.append("title", announcement.title);
    formData.append("content", announcement.content); //문자열
    formData.append("announcementImg", announcementImg); //이미지
    formData.append("announcementImgUrl", announcement.announcementImgUrl); //이미지
    formData.append("announcementImgUuid", announcement.announcementImgUuid); //이미지
    console.log("announcementImg", announcementImg);

    return http.post("/admin/notice/save", formData, {
      headers: AuthHeaderUpload(),
    });
  }

  // TODO: 상세조회 함수1 : 공지사항 :announcementId
  // TODO: 조회(select) -> get 방식 -> @GetMapping
  getNotice(announcementId) {
    // TODO: 사용법 : http.get(`/컨트롤러함수url/${부서번호}`)
    return http.get(`/normal/member/notice/${announcementId}`);
  }

  // TODO: 수정함수 : announcementId, 수정할객체(notice)
  update(announcement, announcementImg) {
    // TODO: 수정(update) -> put 방식 -> @PutMapping
    // TODO: 사용법 : http.put(`/컨트롤러함수url/${dno}`, 수정할객체)
    let formData = new FormData();
    formData.append("title", announcement.title);
    formData.append("content", announcement.content); //문자열
    formData.append("announcementImg", announcementImg); //이미지
    formData.append("announcementImgUrl", announcement.announcementImgUrl); //이미지
    formData.append("announcementImgUuid", announcement.announcementImgUuid); //이미지
    // TODO: 이미지만 콘솔 로그로 확인 => File {이미지명}
    console.log("announcementImg", announcementImg);

    return http.put(
      `/admin/notice/update/${announcement.announcementId}`,
      formData,

      {
        headers: AuthHeaderUpload(),
      }
    );
  }

  // TODO: 삭제함수 : announcementId
  // TODO: 삭제(delete) -> delete 방식 -> @DeleteMapping
  // TODO: 사용법 : http.delete(`/컨트롤러함수url/${dno}`)
  delete(announcementId) {
    return http.delete(`/admin/notice/deletion/${announcementId}`, {
      headers: AuthHeader(),
    });
  }
}

// 내보내기 : 다른 js 에서 사용하기 위해
// 사용법 : 자바 같음 : 객체.함수명()
export default new NoticeListService();
