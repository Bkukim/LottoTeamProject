
import http from "@/utils/http-common";

class UserService{
   get(userId){
    return http.get(`/user/member/${userId}`)
   }

}
export default new UserService;
