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
  export default {
    methods: {
      closePopup() {
        this.$emit('close');
      },
      confirmAction() {
        this.$router.push('/order/refund-success');
      }
    }
  }
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