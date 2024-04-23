// 관리자 환불 페이지
<template>
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
          product.defaultPrice -
          (product.defaultPrice * product.discountRate) / 100
        }}원
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
      />개
    </label>
  </div>
  <!-- 재고 배너 끝 -->

  <!-- 옵션 배너 시작 -->
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
    <label><b>옵션 입력</b></label
    ><label style="display: flex; align-items: center; height: 100%">
      <input
        type="text"
        placeholder="옵션을 입력하세요"
        style="height: 35px; margin-right: 10px"
      />
    </label>
  </div>
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
    <label><b>사진 추가</b> </label>

    <div>
      <div id="img-add">
        <label class="mt-3 mb-3">이미지를 추가해주세요</label>
        <br />
        <div class="text-center">
          <!-- <input
            type="file"
            id="upload-image"
            hidden
            @change="getFileName($event.target.files)"
          />
          <label for="upload-image">
            <img
              src="@/assets/img/upload-file_icon-icons.com_56026.png"
              style="width: 50px; height: 50px"
              class="mb-3"
            />
          </label> -->
          <div class="file-upload-form mb-3">
            <input type="file" @change="previewProdImage" accept="image/*" />
          </div>
          <div class="image-preview mb-3" v-if="prodImage.length > 0">
            <img class="preview" :src="prodImage" @change="selectProdImage" />
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 이미지 추가 배너 끝 -->

  <!-- 상세페이지 추가 배너 시작 -->
  <div class="container mt-4" style="border: 1px solid black; height: auto">
    <label><b>상세 페이지</b> </label>
    <hr />
    <div class="container">
      <div class="row">
        <!-- 사이드 공간 -->
        <div class="col"></div>
        <!-- 분홍색 상자 -->
        <div class="col-10" id="detailFile">
          <!-- 첨부파일 -->
          <div id="file">
            <input type="file" ref="fileInput" style="display: none" />
          </div>
          <div class="text-center">
            <!-- <input
            type="file"
            id="upload-image"
            hidden
            @change="getFileName($event.target.files)"
          />
          <label for="upload-image">
            <img
              src="@/assets/img/upload-file_icon-icons.com_56026.png"
              style="width: 50px; height: 50px"
              class="mb-3"
            />
          </label> -->
            <div class="file-upload-form mb-3">
              <input
                type="file"
                @change="previewProdDetailPage"
                accept="image/*"
              />
            </div>
            <div class="image-preview mb-3" v-if="prodDetailPage.length > 0">
              <img class="preview" :src="prodDetailPage" />
            </div>
          </div>
          <!-- <dvi class="container text-center">
            <button
              class="btn text-light btn-sm mt-4 log-form"
              id="addFile-btn"
            >
              파일추가
            </button>
          </dvi> -->
        </div>
        <!-- 사이드 공간 -->
        <div class="col"></div>
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
          @click="saveSimpleCart"
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
import ProductService from "@/services/product/ProductService.js";
export default {
  data() {
    return {
      product: {
        prodName: "",
        defaultPrice: 0,
        prodCategory: "",
        discountRate: 0,
        prodStock: 0,
        prodImgUrl: "",
        prodDetailPageUrl: "",
      },
      prodImage: "",
      prodDetailPage: "",
    };
  },
  methods: {
    // async getFileName(files) {
    //   this.fileName = files[0];
    //   await this.base64(this.fileName);
    // },
    // base64(file) {
    //   // 비동기적으로 동작하기 위하여 promise를 return 해준다.
    //   return new Promise((resolve) => {
    //     // 업로드된 파일을 읽기 위한 FileReader() 객체 생성
    //     let a = new FileReader();
    //     // 읽기 동작이 성공적으로 완료됐을 때 발생
    //     a.onload = (e) => {
    //       resolve(e.target.result);
    //       // 썸네일을 보여주고자 하는 <img>에 id값을 가져와 src에 결과값을 넣어준다.
    //       const previewImage = document.getElementById("preview");
    //       previewImage.src = e.target.result;
    //     };
    //     // file 데이터를 base64로 인코딩한 문자열. 이 문자열을 브라우저가 인식하여 원래 데이터로 만들어준다.
    //     a.readAsDataURL(file);
    //   });
    // },

    /* 상품이미지 preview 함수 */
    previewProdImage: function (event) {
      // Reference to the DOM input element
      var input = event.target;
      // Ensure that you have a file before attempting to read it
      if (input.files && input.files[0]) {
        // create a new FileReader to read this image and convert to base64 format
        var reader = new FileReader();
        // Define a callback function to run, when FileReader finishes its job
        reader.onload = (e) => {
          // Note: arrow function used here, so that "this.imageData" refers to the imageData of Vue component
          // Read image as base64 and set to imageData
          this.prodImage = e.target.result;
        };
        // Start the reader job - read file as a data url (base64 format)
        reader.readAsDataURL(input.files[0]);
        this.selectImage;
        console.log(this.product.prodImg);
      }
    },

    /* 상세페이지 preview함수 */
    previewProdDetailPage: function (event) {
      // Reference to the DOM input element
      var input = event.target;
      // Ensure that you have a file before attempting to read it
      if (input.files && input.files[0]) {
        // create a new FileReader to read this image and convert to base64 format
        var reader = new FileReader();
        // Define a callback function to run, when FileReader finishes its job
        reader.onload = (e) => {
          // Note: arrow function used here, so that "this.imageData" refers to the imageData of Vue component
          // Read image as base64 and set to imageData
          this.prodDetailPage = e.target.result;
        };
        // Start the reader job - read file as a data url (base64 format)
        reader.readAsDataURL(input.files[0]);
        this.selectImage;
        console.log(this.product.prodImg);
      }
    },
    selectProdImage() {
      //1) 파일 선택 상자에서 첫 번째로 선택한 이미지를 변수에 저장해야한다.
      // ref="file"로 해놧으므로 file로 접근해야한다.
      this.product.prodImg = this.$refs.file.files[0]; // 배열의 특징을 가지므로 file0을 해주어야한다. 아니면 배열에서 몇번째를 가져오는 지를 모름
    },
    selectProdDetailPage() {
      //1) 파일 선택 상자에서 첫 번째로 선택한 이미지를 변수에 저장해야한다.
      // ref="file"로 해놧으므로 file로 접근해야한다.
      this.product.prodDetailPage = this.$refs.file.files[0]; // 배열의 특징을 가지므로 file0을 해주어야한다. 아니면 배열에서 몇번째를 가져오는 지를 모름
    },
    async saveSimpleCart() {
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
        };

        // TODO: 공통 저장 서비스 함수 실행
        // TODO: async ~ await
        let response = await ProductService.create(data);
        // 로깅
        console.log(response.data);
        // 장바구니 담기 성공 메세지 출력
        this.$router.push("/shop/admin/order");
      } catch (e) {
        console.log(e);
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
  width: 58vw;
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
</style>
