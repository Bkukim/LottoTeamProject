<template>
  <div></div>
</template>
<script>
import AuthService from "@/services/auth/AuthService";

export default {
  data() {
    return {
      user: {},
    };
  },
  methods: {
    async kakaoLogin(code) {
      let response = await AuthService.socialLogin(code);
      let user = response.data;
      localStorage.setItem("user", JSON.stringify(user));
      this.$store.commit("loginSuccess", user);
      this.$router.push("/");
    },
  },
  // mounted() {
  //   let url = new URL(window.location.href);
  //   console.log(url);
  //   const urlParams = url.searchParams;                // uri 정보 가져오기
  //   const accessToken = urlParams.get("accessToken");
  //   const id = urlParams.get("id");
  //   const role = urlParams.get("role");
  //   this.user = {
  //     accessToken: accessToken,
  //     userid: id,
  //     role: role,
  //   };
  //   console.log("social user", this.user);

  //   localStorage.setItem("user", JSON.stringify(this.user));
  //   this.$store.commit('loginSuccess', this.user);
  //   this.$router.push("/");
  // },
  mounted() {
    let code = this.$route.query.code;
    console.log(code);
    this.kakaoLogin(code);
  },
};
</script>
