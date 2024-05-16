<template>
  <div class="container refund-div">
    <div class="container text-center">
      <label>취소사유를 선택해주세요</label>
    </div>
  <div class="container col-md-8 inner">
    <div class="radio-option">
      <input type="radio" id="option1" class="radiobtn" name="radio" 
             value="상품이 마음에 들지 않음 (단순 변심)" 
             v-model="selectedOption" @change="updateSelectedOption" />
      <label for="option1" class="lab">상품이 마음에 들지 않음 (단순 변심)</label>
    </div>
    <div class="divider"></div>
    <div class="radio-option">
      <input type="radio" id="option2" class="radiobtn" name="radio" 
             value="다른 상품 추가 후 재주문 예정" 
             v-model="selectedOption" @change="updateSelectedOption" />
      <label for="option2" class="lab">다른 상품 추가 후 재주문 예정</label>
    </div>
  </div>
    <!-- 버튼 태그 시작 -->
    <div class="buttonss">
      <button class="btns prev" @click="goToMyPage">{{ "< 이전단계" }}</button>
      <button class="btns next" @click="goToRefundInfo">{{ "다음단계 >" }}</button>
    </div>
    <!-- 버튼 태그 끝 -->
  </div>
</template>

<script>
import { ref } from 'vue';
import { useStore } from 'vuex';
import { useRouter, useRoute } from 'vue-router';

export default {
  setup() {
    const store = useStore();
    const router = useRouter(); 
    const route = useRoute(); 
    const selectedOption = ref('');

    const orderId = ref(route.params.orderId);
    const updateSelectedOption = () => {
      store.commit('setSelectedOption', selectedOption.value);
    };

    const goToRefundInfo = () => {
      router.push({ name: 'refund-info', params: { orderId: orderId.value } });
    };

    return {
      selectedOption,
      updateSelectedOption,
      goToRefundInfo,
    };
  },
  data() {
    return {
    }
  },
  methods: {
    goToMyPage() {
      this.$router.push('/member/mypage');
    },
  },
  mounted() {
  },
};
</script>

<style scoped>
.refund-div {
  width: 800px;
  height: 600px;
  border: 1px solid black;
  border-radius: 10px;
  background-color: whitesmoke;
  margin-top: 50px;
  margin-bottom: 50px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.text-center {
    margin-top: -20px;
  text-align: center;
  font-weight: bold;
  font-size: 20px;
  width: 100%;
}

.radio-option {
  margin-left: 20px;
  padding: 10px 0;
}

.divider {
  height: 1px;
  background-color: #ccc; 
  width: 100%;
  margin: 0 auto;
}

.lab {
    margin-left: 10px;
    font-size: 18px;
}

.radiobtn {
  transform: scale(1.5); 
  margin: 10px;
}

.buttonss {
  display: flex;
  justify-content: space-between;
  margin-top: 30px;
  width: 100%;
  max-width: 600px; 
  margin-left: auto;
  margin-right: auto; 
}

.btns {
  flex-grow: 1;
  padding: 10px 20px; 
  font-size: 16px;
  margin: 0 10px; 
  cursor: pointer; 
  border: 1px solid #ccc; 
  transition: background-color 0.3s ease; 
}

.prev {
  background-color: #ffffff;
  color: #000000;
}

.next {
  background-color: #342a26;
  color: #ffffff;
}

.prev:hover {
  background-color: #e6e6e6;
}

.next:hover {
  background-color: #8a7465;
}

.inner {
  border: 1px solid black;
  border-radius: 10px;
  background-color: white;
  margin-top: 25px;
  width: 75%;
}

@media (max-width: 992px) {
  .refund-div,
  .inner {
    width: 100%;
    margin-top: 20px;
    margin-bottom: 20px;
  }
}

@media (max-width: 768px) {
  .refund-div,
  .inner {
    width: 100%;
    margin-top: 10px;
    margin-bottom: 10px;
  }
}
</style>