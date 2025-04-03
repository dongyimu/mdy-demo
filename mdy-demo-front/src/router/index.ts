import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/homeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'homeView',
      component: HomeView,
      meta: {
        title: '首页'
      }
    },
    {
      path: '/record',
      name: 'record',
      component: () => import('../views/record.vue'),
      meta: {
        title: '记录页面'
      }
    },
  ],
})

// 全局前置守卫
router.beforeEach((to, from, next) => {
  // 设置页面标题
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

export default router
