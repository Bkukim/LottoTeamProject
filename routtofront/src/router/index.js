import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('../views/HomeView.vue')
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
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
