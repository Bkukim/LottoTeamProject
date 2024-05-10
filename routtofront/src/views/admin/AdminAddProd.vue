// 관리자 환불 페이지
<template>
  <AdminHeaderCom />
  <div class="container">
    <h2 class="mb-3">상품 등록</h2>
    <!-- 카테코리 선택 배너 -->
    <div
      class="container mt-5"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 50px;
      "
    >
      <label><b>카테고리</b></label
      ><label style="display: flex; align-items: center; height: 100%">
        <select
          class=""
          aria-label="Default select example"
          v-model="product.prodCategory"
        >
          <option selected value="스킨케어">스킨케어</option>
          <option value="메이크업">메이크업</option>
          <option value="바디">바디</option>
          <option value="헤어">헤어</option>
        </select>
      </label>
    </div>
    <!-- 카테코리 배너 끝 -->

    <!-- 상품명 배너 시작 -->
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
        <input
          type="text"
          placeholder="상품명을 입력하세요"
          style="height: 35px; margin-right: 10px"
          v-model="product.prodName"
          class="input-box"
        />
      </label>
    </div>
    <!-- 상품명 배너 끝 -->

    <!-- 판매가 배너 시작 -->
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
      <label><b>판매가</b></label
      ><label style="display: flex; align-items: center; height: 100%">
        <input
          type="text"
          placeholder="판매가를 입력하세요"
          style="height: 35px; margin-right: 10px"
          v-model="product.defaultPrice"
          class="input-box"
          @input="checkInput"
        />원
      </label>
    </div>
    <!-- 판매가 배너 끝 -->

    <!-- 할인율 배너 시작 -->
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
      <label><b>할인율</b></label
      ><label style="display: flex; align-items: center; height: 100%">
        <input
          type="text"
          placeholder="할인율을 입력하세요"
          style="height: 35px; margin-right: 10px"
          v-model="product.discountRate"
          class="input-box"
          @input="checkInput"
        />%
      </label>
    </div>
    <!-- 할인율 배너 끝 -->

    <!-- 할인가 배너 시작 -->
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
      <label><b>할인율 적용가</b></label
      ><label style="display: flex; align-items: center; height: 100%">
        <p v-if="product.defaultPrice">
          {{
            Math.round(
              product.defaultPrice -
                (product.defaultPrice * product.discountRate) / 100
            )
          }}
          원
        </p>
      </label>
    </div>
    <!-- 할인가 배너 끝 -->

    <!-- 재고 배너 시작 -->
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
      <label><b>재고 수량</b></label
      ><label style="display: flex; align-items: center; height: 100%">
        <input
          type="text"
          placeholder="재고 수량을 입력하세요"
          style="height: 35px; margin-right: 10px"
          v-model="product.prodStock"
          class="input-box"
          @input="checkInput"
        />개
      </label>
    </div>
    <!-- 재고 배너 끝 -->

    <!-- 옵션 배너 시작 -->
    <!-- <div
    class="container mt-4"
    style="
      border: 1px solid black;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 60px;
    "
  >
    <label><b>옵션 입력</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="옵션을 입력하세요"
        style="height: 35px; margin-right: 10px"
        class="input-box"
      />
    </label>
  </div> -->
    <!-- 옵션 배너 끝 -->

    <!-- 이미지 추가 배너 시작 -->
    <div
      class="container mt-4"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        height: auto;
      "
    >
      <label class="mt-3"><b>상품 이미지 추가</b> </label>
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
                @change="previewProdImage"
                accept="image/*"
                ref="file01"
                style="color: black"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 이미지 추가 배너 끝 -->

    <!-- 상세페이지 추가 배너 시작 -->
    <div
      class="container mt-4"
      style="
        border: 1px solid black;
        display: flex;
        justify-content: space-between;
        height: auto;
      "
    >
      <label class="mt-3"><b>상품 상세 페이지 추가</b> </label>
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
                @change="previewProdDetailPage"
                accept="image/*"
                ref="file02"
                style="color: black"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 상세페이지 추가 배너 끝 -->

  <div class="container text-center mt-5 mb-5">
    <div class="row">
      <div class="col"></div>

      <div class="col">
        <button
          class="btn text-light btn-sm mt-4 log-form"
          id="addFile-btn"
          @click="saveProduct"
        >
          저장
        </button>
        <button class="btn text-light btn-sm mt-4 log-form" id="addFile-btn">
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";
import AdminProductService from "@/services/admin/AdminProductService";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
      product: {
        prodName: "",
        defaultPrice: undefined,
        prodCategory: "",
        discountRate: undefined,
        prodStock: undefined,
        prodImgUrl: "",
        prodDetailPageUrl: "",
      },
      // TODO: 수정 , 파일은 "" 초기화하면 안됨(문자열이므로)
      prodImage: undefined,
      prodDetailPage: undefined,
    };
  },
  methods: {
    previewProdImage: function () {
      this.prodImage = this.$refs.file01.files[0];
    },

    previewProdDetailPage: function () {
      this.prodDetailPage = this.$refs.file02.files[0];
    },

    async saveProduct() {
      try {
        // 임시 객체
        let data = {
          prodName: this.product.prodName,
          defaultPrice: this.product.defaultPrice,
          prodCategory: this.product.prodCategory,
          prodImg: this.prodImage,
          prodDetailPage: this.prodDetailPage,
          prodImgUrl: this.product.prodImgUrl,
          prodDetailPageUrl: this.product.prodDetailPageUrl,
          discountRate: this.product.discountRate,
          prodStock: this.product.prodStock,
          prodImgUuid: "",
          prodDetailPageUuid: "",
        };
       
        // TODO: 공통 저장 서비스 함수 실행
        // TODO: async ~ await
        let response = await AdminProductService.createProduct(data);
        // 로깅
        console.log(response.data);
        // 장바구니 담기 성공 메세지 출력
        this.$router.push("/shop/admin/manage");
      } catch (e) {
        alert("빈칸없이 입력해주세요");
      }
    },
    checkInput(event) {
      const inputValue = event.target.value;
      // 입력값이 숫자가 아닌 경우에만 알림 표시
      if (!/^\d+$/.test(inputValue) && inputValue !== "") {
        alert("숫자만 입력하세요!");
        // 입력값에서 숫자가 아닌 문자 제거
        event.target.value = inputValue.replace(/[^\d]/g, "");
      }
    },
  },
};
</script>

<style>
.searchBtn {
  background-color: #342a26;
  color: white;
}

.chbox {
  margin-left: 20px;
}
#img-btn {
  border: 1px solid black;
  width: 100px;
  height: 100px;
  font-size: 50px;
  margin-bottom: 40px;
}
#img-add {
  margin-right: 50px;
}
#detailFile {
  height: auto;
  background-color: #f3eae8;
  margin: 2.6042vw;
}
#file {
  margin: 20px;
  min-height: 10vw;
}
#addFile-btn {
  width: 9.5313vw;
  height: 45px;
  background-color: #342a26;
  margin: 20px;
}
#save-btn {
  width: 9.5313vw;
  height: 45px;
  background-color: #342a26;
  margin: 20px;
}
#cancel-btn {
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
.input-box:focus {
  outline: none;
  border-color: #342a26;
}
</style>
