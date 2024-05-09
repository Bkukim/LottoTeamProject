<template>
  <AdminHeaderCom />
  <div class="container">
    <h2 class="mb-5">배너 관리</h2>
    <!-- 5. 테이블 시작-->
    <table class="table table-bordered" style="border: 1px solid #342a26">
      <!-- 테이블 제목 행 -->
      <thead>
        <tr class="text-center">
          <th scope="col">배너번호</th>
          <th scope="col">상품이름</th>
          <th scope="col">배너 타이틀</th>
          <th scope="col">배너 이미지1</th>
          <th scope="col">배너 이미지2</th>
          <th scope="col">수정</th>
        </tr>
      </thead>
      <tbody>
        <tr class="text-center" v-for="(data, index) in banner" :key="index">
          <td :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
            <div class="mt-2">{{ data.bannerId }}</div>
          </td>

          <td :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
            <div class="mt-2">{{ data.prodName }}</div>
          </td>

          <td :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
            <div class="mt-2">{{ data.bannerTitle }}</div>
          </td>

          <td :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
            <div class="mt-2"><img :src="data.bannerImg1Url" style="max-width: 250px; max-height: 150px;"></div>
          </td>
          <td :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
            <div class="mt-2" v-if="data.bannerId == '배너 2'"><img :src="data.bannerImg2Url" style="max-width: 250px; max-height: 150px;"></div>
            <div class="mt-2" v-else>이미지 없음</div>
          </td>
          <td :style="{ 'vertical-align': 'middle', 'text-align': 'center' }">
            <div>
              <button
                type="button"
                class="text-light saveBtn btn-sm mt-1"
                style="margin-left: 5px"
                @click="goToUpdateBanner(data.bannerId,data.prodId)"
              >
                수정
              </button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import AdminAdBannerService from "@/services/admin/AdminAdBannerService";
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
      banner: [
        // bannerId();
        // prodId();
        // bannerTitle();
        // bannerContent();
        // bannerImg1Url();
        // bannerImg1Uuid();
        // bannerImg2Url();
        // bannerImg2Uuid();
      ],
    };
  },
  methods: {
    async getAllBanner() {
      try {
        let response = await AdminAdBannerService.findAllBannerAdmin();
        this.banner = response.data;
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    },
    goToUpdateBanner(bannerId){
      if (bannerId == "메인 배너") {
        this.$router.push("/admin/main-banner");
      } else {
        this.$router.push("/admin/banner/" + bannerId);
      }
    }
   
  },
  mounted() {
    this.getAllBanner();
  },
};
</script>
<style>
.saveBtn {
  background-color: #342a26;
  color: white;
  font-size: 15px;
  width: 70px;
  height: 35px;
}</style>
