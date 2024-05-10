// vue 의 공유 저장소 : 공유속성, 공유함수 등을 정의
//  => 모든 컴포넌트가 사용가능
import { createStore } from "vuex";

// TODO: 로그인 정보 + 로그인상태 를 정의
// 1) 로컬스토리지에서 user 객체 가져오기
const user = JSON.parse(localStorage.getItem("user"));

export default createStore({
  // state : 공유 속성이나 공유 함수 정의
  state: {
    loggedIn: user ? true : false, // 로그인 여부
    user: user ? user : null, //  로그인 정보 (웹토큰 속성 있음)
    orderAmount: 1,

    selectedOption: '', // 라디오 버튼에서 선택된 옵션
    userId:"",
  },

  // 공유 속성의 값을 조회하는 함수
  getters: {},

  // 공유 속성의 값을 저장하는 함수, java의 setter이다.
  mutations: {
    // todo 로그인 성공함수
    loginSuccess(state, user) {
      state.loggedIn = true;
      state.user = user;
    },

    // todo

    // todo 로그인 실패함수
    loginFailure(state) {
      state.loggedIn = false;
      state.user = null;
    },

    // todo 로그아웃 함수
    logout(state) {
      state.loggedIn = false;
      state.user = null;
    },

    // todo 회원가입 성공함수
    registerSuccess(state) {
      state.loggedIn = false;
    },

    // todo 회원가입 실패함수
    registerFailure(state) {
      state.loggedIn = false;
    },

    // 라디오 버튼 선택 옵션 저장
    setSelectedOption(state, option) {
      state.selectedOption = option;
    },

    // 계좌번호 상태 업데이트
    setAccountNumber(state, accountNumber) {
      state.accountNumber = accountNumber;
    },
  },

  // 비동기 함수들을 정의하는 곳
  actions: {
    // 라디오 버튼 선택 옵션 업데이트 액션
    updateSelectedOption({ commit }, option) {
      commit("setSelectedOption", option);
    },

 
  },
  // 공유 저장소를 여러개 사용할 경우 모듈로 정의해서 분리가능하다. 모듈 정의하는 곳
  modules: {},
});