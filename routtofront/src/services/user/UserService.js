
import http from "@/utils/http-common";
import AuthHeader from "../auth/AuthHeader";

class UserService{
   get(userId){
    return http.get(`/user/member/${userId}`,{
      headers: AuthHeader()
    });
   }

   updateUser(data){
      return http.put(`/user/member/update/${data.userId}`,data,{
         headers: AuthHeader()
       });
   }

   deleteUser(userId){
      return http.delete(`/user/member/delete/${userId}`,{
         headers: AuthHeader()
       });
   }
}
export default new UserService;
