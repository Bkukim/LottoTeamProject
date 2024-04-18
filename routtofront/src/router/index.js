import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  
  {
    path: '/',
    component: () => import('../views/HomeView.vue')
  },
  // 공지사항  shop/notice
  {
    path: '/notice',
    component: () => import('../views/NoticeView.vue')
  },
  // 공지사항 관리자 //adimn-notice
  {
    path: '/adimn-notice',
    component: () => import('../views/AdimnNotice.vue')
  },
  
  // 고객센터  shop//faqList
  {
    path: '/faqList',
    component: () => import('../views/FaqListView.vue')
  },// 고객센터 문의글  
  {
    path: '/inquiry',
    component: () => import('../views/InquiryView.vue')
  },
  // 장바구니
  {
    path: '/cart',
    component: () => import('../views/CartList.vue')
  },
  // 즐겨찾기
  {
    path: '/wishlist',
    component: () => import('../views/WishList.vue')
  },
  // 로그인 페이지
  {
    path: '/member/login',
    component: () => import('../views/LoginView.vue')
  },
  // 회원가입 페이지
  {
    path: '/member/join',
    component: () => import('../views/JoinView.vue')
  },
  // 아이디 찾기 페이지
  {
    path: '/member/find-id',
    component: () => import('../views/FindId.vue')
  },
  // 비밀번호 찾기 페이지
  {
    path: '/member/find-pwd',
    component: () => import('../views/FindPwd.vue')
  },
  // 결제 페이지
  {
    path: '/order/payment',
    component: () => import('../views/PaymentView.vue')
  },
  // 주문 완료 페이지
  {
    path: '/order/completed',
    component: () => import('../views/OrderComView.vue')
  },
  // 주문자 환불 페이지
  {
    path: '/order/refund-request',
    component: () => import('../views/UserRefundView.vue')
  },
  // 관리자 환불 페이지
  {
    path: '/shop/admin/refund',
    component: () => import('../views/AdminRefundView.vue')
  },
  // 관리자 홈 페이지
  {
    path: '/shop/admin',
    component: () => import('../views/admin/AdminHome')
  },
  {
    path: '/member/userModify',
    component: () => import('../views/userModify.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
