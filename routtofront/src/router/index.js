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
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
