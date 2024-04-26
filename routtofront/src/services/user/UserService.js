
import http from "@/utils/http-common";

class UserService{
   get(userId){
    return http.get(`/member/order/${userId}`)
   }

   // id 찾기 함수
   findId(role,userName,phoneNum){
      return http.get(`/member/findId/${role}/${userName}/${phoneNum}`);
   }

   // pw새로 만들기 위해서 사용자 확인함수
   getForPw(role, userId, pwQuestion, pwAnswer){
      return http.get(`/member/getForPw/${role}/${userId}/${pwQuestion}/${pwAnswer}`)
   }

   // 새로운 비밀번호 변경함수
   updatePw(newPw){
      return http.put("/member/new-pw",newPw);
   }
}
export default new UserService;
