<template>
  <div class="popup">
    <div class="popup-content">
      <p>취소 신청하시겠습니까?</p>
    </div>
    <div class="popup-buttons">
      <button class="cancel-button" @click="closePopup">취소</button>
      <button class="confirm-button" @click="confirmAction">확인</button>
    </div>
  </div>
</template>

<script>
import RefundService from "@/services/payment/RefundService";

export default {
  data() {
    return {
      order: null,
      message: "",
    };
  },
  methods: {
    // async getOrder(orderId) {
    //   try {
    //     let response = await OrderService.getOrderId(orderId);
    //     this.order = response.data;

    //     console.log(response.data);
    //   } catch (e) {
    //     console.log(e);
    //   }
    // },
    closePopup() {
      this.$emit("close");
    },
    async confirmAction() {
      try {
        let data = {
          orderId: this.order.orderId,
          userId: this.order.userId,
          orderStatus: "환불요청",
        };
        let response = await RefundService.requestRefund(
          this.order.orderId,
          data
        );

        console.log(response.data);

        this.message = "환불 요청이 완료되었습니다.";
      } catch (e) {
        console.log(e);
      }
      this.$router.push("/order/refund-success");
    },
  },
  mounted() {
    this.message = ""; // 변수 초기화
    // TODO: 뷰 사용법 : 주소(router 주소)에서 변수 가져오기 방법
    // TODO: 사용법 : this.$route.params.변수명
    this.getOrder(this.$route.params.orderId); // 상세 조회 함수 실행
  },
};
</script>

<style>
.popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  padding: 20px;
  border: 1px solid #ccc;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  z-index: 1000;
  width: 300px;
}

.popup-content {
  text-align: center;
  font-size: 16px;
  color: #333;
}

.popup-buttons {
  margin-top: 20px;
  display: flex;
  justify-content: space-around;
}

button {
  border: none;
  padding: 8px 30px;
  cursor: pointer;
  border-radius: 5px;
  transition: background-color 0.3s;
}

.cancel-button {
  background-color: #ccc;
  color: white;
}

.confirm-button {
  background-color: #342a26;
  color: white;
}
</style>
