<!-- InquiryPassword.vue 
    패스워드 가져오는 페이지 :: 어려워서 빼는게 좋다구 하심 추후구현
-->
<template>
  <div class="container mt-5 mb-5 min-vh-100">
    <div class="row ">
      <div class="col-md-6 mx-auto text-center">
        <form>
          <div class="row justify-content-center">
            <div class="col-auto text-center">
              <label for="password" class="visually-hidden">비밀번호:</label>
              <input
                type="password"
                id="password"
                class="form-control"
                placeholder="비밀번호"
                v-model="password"
              />
            </div>
            <div class="col-auto">
              <button class="btn btn-primary">
                비밀번호 확인
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
    data() {
        return {
            password: {}, //패스워드 가져올 객체
        }
    },
    methods: {
        // 상세조회 비밀번호 함수
        getPass(){

        },

        goUpdate(){
            this.$router.push("/inquiry-update");
        }
    },
};
</script>
<style></style>
