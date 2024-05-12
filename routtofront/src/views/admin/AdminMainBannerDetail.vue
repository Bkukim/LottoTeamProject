// 관리자 환불 페이지
<template>
  <AdminHeaderCom />
  <br />

  <!-- 배너 2 -->
  <h2>메인 배너</h2>
  <!-- 상품 번호 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 60px;
    "
  >
    <label><b>상품 번호</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="상품 번호을 입력하세요"
        style="height: 35px; margin-right: 10px"
        class="input-box"
        v-model="banner.prodId"
      />
      
      <button
        class="text-light btn-sm mt-4 log-form searchBtn mb-4"
        @click="getProduct"
      >
        검색
      </button>
    </label>
  </div>
  <!-- 상품 번호 끝 -->
  
  <!-- 상품명 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 60px;
    "
  >
    <label><b>상품명</b></label
    ><label style="display: flex; align-items: center; height: 100%">
    {{ banner.prodName }}
    </label>
  </div>
  <!-- 상품명 끝 -->

  <!-- 이미지 추가 시작 -->
  <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      height: auto;
    "
  >
    <label class="mt-3"><b>배너 이미지 변경</b> </label>
    <hr />
    <div>
      <div id="img-add">
        <label class="mt-3 mb-3"></label>
        <br />

        <div class="text-center">
          <div class="file-upload-form mb-3">
            <!-- TODO: file01 추가 -->
            <input
              type="file"
              @change="previewBannerImg1"
              accept="image/*"
              ref="file01"
              style="color: black"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 이미지 추가 끝 -->
  <div class="container text-center mt-5 mb-5">
    <div class="row">
      <div class="col"></div>

      <div class="col">
        <button
          class="btn text-light btn-sm mt-4 log-form"
          id="update-banner-btn"
          @click="updateBanner"
        >
          저장
        </button>
        <button class="btn text-light btn-sm mt-4 log-form" id="update-banner-btn">
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";
import AdminAdBannerService from "@/services/admin/AdminAdBannerService";
import ProductService from "@/services/product/ProductService";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
     product:{},
      banner: {
        // bannerId();
        // prodId();
        // prodName
        // bannerTitle();
        // bannerContent();
        // bannerImg1();
        // bannerImg2();
        // bannerImg1Url();
        // bannerImg1Uuid();
        // bannerImg2Url();
        // bannerImg2Uuid();
      },
      // TODO: 수정 , 파일은 "" 초기화하면 안됨(문자열이므로)
    };
  },
  methods: {
    previewBannerImg1: function () {
      this.banner.bannerImg1 = this.$refs.file01.files[0];
    },

    // 상품 상세조회
    async getProduct(){
      try {
        let response = await ProductService.get(this.banner.prodId);
        console.log(response.data);
        this.product =response.data;
        this.banner.prodName = response.data.prodName;
        this.banner.prodId = response.data.prodId;
      } catch (error) {
        console.log(error);
      }
    },

    // 베너 상세조회 (현재 관련 상품 조회 위해)
    async getBanner(){
      try {
        let response = await AdminAdBannerService.findBanner("메인 배너")
        console.log(response.data);
        this.banner=response.data;
      } catch (error) {
        console.log(error);
      }
    },

    // 배너 저장 합수
    async updateBanner() {
      try {
        // 임시 객체
        let data = {
          bannerId: "메인 배너",
          prodId: this.banner.prodId,
          bannerTitle: "",
          bannerContent: "",
          bannerImg1: this.banner.bannerImg1,
          bannerImg2: this.banner.bannerImg1,
        };
        let response = await AdminAdBannerService.updateBanner(data);
        
        this.$router.push("/admin/banner-list");
        // 로깅
        console.log(response.data);
        
      } catch (e) {
        console.log(e);
      }
    },
  },
  mounted() {
    this.getBanner();
    window.scrollTo(0, 0);
  },
};
</script>

<style>
.searchBtn {
  background-color: #342a26;
  color: white;
}

#update-banner-btn {
  width: 9.5313vw;
  height: 45px;
  background-color: #342a26;
  margin: 20px;
}

.input-box {
  height: 35px;
  margin-right: 10px;
  border: 1px solid #ccc;
  padding: 0 10px;
  color: black;
}

</style>
