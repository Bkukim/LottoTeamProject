
import http from "@/utils/http-common";

class UserService{
   get(userId){
    return http.get(`/member/order/${userId}`)
   }
}
export default new UserService;
