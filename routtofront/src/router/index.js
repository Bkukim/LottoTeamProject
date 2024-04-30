import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("../views/HomeView.vue"),
  },
  // 공지사항 shop/notice
  {
    path: "/notice",
    component: () => import("../views/notice/NoticeView.vue"),
  },
  // 공지사항 관리자 //adimn-notice
  {
    path: "/adimn-notice",
    component: () => import("../views/admin/AdminNotice.vue"),
  },

  // 고객센터  shop//faqList
  {
    path: "/faqList",
    component: () => import("../views/faq/FaqListView.vue"),
  },
  // 고객센터 문의글
  {
    path: "/inquiry",
    component: () => import("../views/faq/InquiryView.vue"),
  },
  
// 고객센터 문의글 작성한거 확인하기
{
  path: "/inquiry-check",
  component: () => import("../views/faq/InquiryCheck.vue"),
},
  // 장바구니
  {
    path: "/cart",
    component: () => import("../views/cart_wish/CartListView.vue"),
  },
  // 즐겨찾기
  {
    path: "/wishlist",
    component: () => import("../views/cart_wish/WishListView.vue"),
  },
  // 로그인 페이지
  {
    path: "/member/login",
    component: () => import("../views/auth/LoginView.vue"),
  },
  // 회원가입 페이지
  {
    path: "/member/join",
    component: () => import("../views/auth/JoinView.vue"),
  },
  // 회원가입 환영 페이지
  {
    path: "/member/join/welcome",
    component: () => import("../views/auth/WelcomeView.vue"),
  },
  // 아이디 찾기 페이지
  {
    path: "/member/find-id",
    component: () => import("../views/find/FindId.vue"),
  },
  // 비밀번호 찾기 페이지
  {
    path: "/member/find-pwd",
    component: () => import("../views/find/FindPwd.vue"),
  },
  // 결제 페이지
  {
    path: "/order/payment",
    component: () => import("../views/payment/PaymentView.vue"),
  },
  // 주문 완료 페이지
  {
    path: "/order/completed",
    component: () => import("../views/order/OrderComView.vue"),
  },
  // 주문자 환불 페이지
  {
    path: "/order/refund-request",
    component: () => import("../views/user_refund/UserRefundView.vue"),
  },
  // 관리자 환불 페이지
  {
    path: "/shop/admin/refund",
    component: () => import("../views/admin/AdminRefundView.vue"),
  },
  // 관리자 홈 페이지
  {
    path: "/shop/admin",
    component: () => import("../views/admin/AdminHome.vue"),
  },
  // 관리자 조회/수정 페이지
  {
    path: "/shop/admin/manage",
    component: () => import("../views/admin/AdminManage.vue"),
  },
  // 관리자 상품 등록 페이지
  {
    path: "/shop/admin/add-product",
    component: () => import("../views/admin/AdminAddProd.vue"),
  },
  // 회원정보 수정
  {
    path: "/member/userModify",
    component: () => import("../views/UserModifyView.vue"),
  },
  // 상품 페이지
  {
    path: "/product/:prodId",
    component: () => import("../views/ProductsDetail.vue"),
  },
  // 주문 페이지
  {
    path: "/order/:prodId",
    component: () => import("../views/order/OrderView.vue"),
  },
  // 관리자 주문 확인 페이지
  {
    path: "/shop/admin/order",
    component: () => import("../views/admin/AdminOrder.vue"),
  },
    // 주문자 환불 정보 확인 페이지
    {
      path: "/order/refund-info",
      name: 'refund-info',
      component: () => import("../views/user_refund/UserRefundInfoView.vue"),
    },
    // 주문자 환불 완료 페이지
    {
      path: "/order/refund-success",
      component: () => import("../views/user_refund/UserRefundSuccessView.vue")
    }, 
   // 결제 위젯 컴포넌트
    {
      path: "/order/tosspay",
      component: () => import('../views/payment/CheckoutView.vue')
    },
    // 결제 성공 페이지
    {
      path: '/order/success',
      component: () => import('../views/payment/SuccessView.vue')
    },
    // 결제 실패 페이지
    {
      path: '/order/fail',
      component: () => import('../views/payment/FailView.vue')
    },
    // 마이 페이지
    {
      path: "/member/mypage",
      component: () => import('../views/MypageView.vue')
    },
    // // 사용자 주문확인페이지
    // {
    //   path:"/ordercheck",
    //   component: () => import("../views/OrderCheckView.vue"),
    // },
    // 비밀번호 재설정 페이지
    {
      path: "/member/new-pw",
      component: () => import('../views/auth/NewPwdView.vue')
    },
      // 공지사항 작성글 상세조회 shop/notice-check
  {
    path: "/notice-check",
    component: () => import("../views/notice/NoticeCheck.vue"),
  }, 
  // SearchProduchView
  {
    path: "/member/searchproduct",
    component: () => import("../views/search/SearchProductView.vue"),
  },

  
  
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;