
import http from "@/utils/http-common";

class UserService{
   get(userId){
    return http.get(`/member/order/${userId}`)
   }
   findId(role,userName,phoneNum){
      return http.get(`/member/findId/${role}/${userName}/${phoneNum}`);
   }
}
export default new UserService;
