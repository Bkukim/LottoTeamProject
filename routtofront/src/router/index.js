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
  },// 즐겨찾기
  {
    path: '/wishlist',
    component: () => import('../views/WishList.vue')
  },
  // 결제 페이지
  {
    path: '/payment',
    component: () => import('../views/PaymentView.vue')
  },
  // 주문 완료 페이지
  {
    path: '/completed',
    component: () => import('../views/OrderComView.vue')
  },
  // 주문자 환불 페이지
  {
    path: '/refund-request',
    component: () => import('../views/UserRefundView.vue')
  },
  // 관리자 환불 페이지
  {
    path: '/admin/refund',
    component: () => import('../views/AdminRefundView.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
