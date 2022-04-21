import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layout'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Layout,
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/views/home'),
        meta: {title: '首页'}
      },
      {
        path: '/logon',
        name: 'Logon',
        component: () => import('@/views/logon'),
        meta: {title: '注册'}
      },
      {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login'),
        meta: {title: '登录'}
      },
    ],
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

const whiteList = ['/', '/logon', '/login']

router.beforeEach(((to, from, next) => {
  if (whiteList.indexOf(to.path) === -1) {
    next(`/login?redirect=${to.path}`)

  } else {
    next()
  }
}))

export default router
