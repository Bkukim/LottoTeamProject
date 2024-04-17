import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  
  {
    path: '/',
    component: () => import('../views/HomeView.vue')
  },
  {
    path: '/member/login',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/member/join',
    component: () => import('../views/JoinView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
