// 상품 상세 조회 수정 페이지
<template>
  <AdminHeaderCom />
  <div class="container">
    <h2 class="mb-3">{{  }}</h2>
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
    
    <!-- 판매상태 배너 시작 -->
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
      <label><b>판매 상태</b></label
      ><label style="display: flex; align-items: center; height: 100%">
        
              <select
                class="form-select"
                aria-label="Default select example"
                id="prodStatus"
                v-model="product.prodStatus"
              >
                
                <option value="판매중">판매중</option>
                <option value="품절">품절</option>
                <!-- <option value="5">구매확정</option> -->
              </select>
         
      </label>
    </div>
    <!-- 판매상태 배너 끝 -->

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
    <!-- 상세페이지 추가 배너 끝 -->

    <div class="container text-center mt-5 mb-5">
      <div class="row">
        <div class="col"></div>

        <div class="col">
          <button
            class="btn text-light btn-sm mt-4 log-form"
            id="addFile-btn"
            @click="updateProduct"
          >
            수정
          </button>
          <button
            class="btn text-light btn-sm mt-4 log-form"
            id="addFile-btn"
            @click="deleteProduct"
          >
            취소
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AdminHeaderCom from "@/components/common/AdminHeaderCom.vue";
import AdminManageService from "@/services/admin/AdminManageService";

export default {
  components: {
    AdminHeaderCom,
  },
  data() {
    return {
      // product: null, // product 초기값
      product: {},
      // TODO: 수정 , 파일은 "" 초기화하면 안됨(문자열이므로)
      prodImage: undefined,
      prodDetailPage: undefined,
    };
  },
  methods: {
    // TODO: 상세조회 요청하는 함수 : 화면 뜰 때
    // TODO: 비동기 코딩 : async ~ await
    async getProduct(prodId) {
      try {
        // TODO: 상세조회 공통함수 실행 : DeptService.get()
        let response = await AdminManageService.get(prodId);
        this.product = response.data; // 전체조회에서는 배열이었으나, 여기서는 객체 한개다. spring 결과를 바인딩 속성변수 product 에 저장
        // 로깅
        console.log(response.data);
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 수정요청 함수
    async updateProduct() {
      try {
        let data = {
          prodName: this.product.prodName,
          defaultPrice: this.product.defaultPrice,
          prodCategory: this.product.prodCategory,
          prodImg: this.product.prodImage,
          prodDetailPage: this.product.prodDetailPage,
          prodImgUrl: this.product.prodImgUrl,
          prodDetailPageUrl: this.product.prodDetailPageUrl,
          discountRate: this.product.discountRate,
          prodStock: this.product.prodStock,
          prodStatus:this.product.prodStatus,
          prodImgUuid: this.product.prodImgUuid,
          prodDetailPageUuid: this.product.prodDetailPageUuid
        };
        console.log(data.prodStatus);
        // TODO: 공통 수정함수
        // TODO: 비동기 코딩 : async ~ await
        let response = await AdminManageService.update(this.product.prodId,data); // 수정버튼을 누른다는것은, 이미 상세조회가 끝난이후며 dno에 값이 다 들어와있음.
        console.log(response.data); // 로깅
        alert("수정이 완료되었습니다."); // 화면에 성공메세지 출력 : message 바인딩 변수
        this.$router.push("/shop/admin/manage");
      } catch (e) {
        console.log(e);
      }
    },
    // TODO: 삭제요청 함수 : 비동기 코딩 : async ~ await
    async deleteProduct() {
      try {
        if (confirm("수정을 취소하시겠습니까?")) {
          console.log("수정이 취소되었습니다.");
          this.$router.push("/shop/admin/manage");
        }
      } catch (e) {
        console.log(e);
      }
    },
    previewProdImage: function () {
      this.product.prodImage = this.$refs.file01.files[0];
    },

    previewProdDetailPage: function () {
      this.product.prodDetailPage = this.$refs.file02.files[0];
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
  // TODO: 화면이 뜰 때 자동으로 실행되는 함수
  mounted() {
    // this.message = ""; // 변수 초기화
    // TODO: 변수명 확인 : router/index.js 에서 url 정의한곳에서 확인(/dept/:dno)
    this.getProduct(this.$route.params.prodId); // 상세조회 함수 실행
    window.scrollTo(0, 0);
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
