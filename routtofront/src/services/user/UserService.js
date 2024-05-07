
import http from "@/utils/http-common";

class UserService{
   get(userId){
    return http.get(`/user/member/${userId}`)
   }

   updateUser(data){
      return http.put(`/user/member/update/${data.userId}`,data);
   }

   deleteUser(userId){
      return http.delete(`/user/member/delete/${userId}`);
   }
}
export default new UserService;
