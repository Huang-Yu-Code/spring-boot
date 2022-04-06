import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/logon',
    component: () => import('@/views/logon/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: {title: '首页', icon: 'dashboard'}
    }]
  },
]

export const asyncRoutes = [

  // personal
  {
    path: '/personal',
    component: Layout,
    redirect: '/personal/index',
    name: 'Personal',
    meta: {
      title: '个人中心',
      icon: 'nested',
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/personal/index'),
        meta: {title: '个人信息', icon: 'table'}
      },
      {
        path: 'password',
        component: () => import('@/views/personal/password'),
        meta: {title: '修改密码', icon: 'table'}
      }
    ]
  },

  // goods
  {
    path: '/goods',
    component: Layout,
    name: 'Goods',
    meta: {
      title: '防疫物品',
      icon: 'el-icon-s-help'
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/goods/index'),
        meta: {title: '物品详情'}
      },
      {
        path: 'donation',
        component: () => import('@/views/goods/donation'),
        meta: {title: '物品捐赠'}
      },
      {
        path: 'donation-log',
        component: () => import('@/views/goods/donationLog'),
        meta: {title: '物品捐赠记录'}
      },
      {
        path: 'apply',
        component: () => import('@/views/goods/apply'),
        meta: {title: '物品申请', roles: ['admin', 'doctor']}
      },
      {
        path: 'apply-log',
        component: () => import('@/views/goods/applyLog'),
        meta: {title: '物品申请记录'}
      },
    ]
  },

  //warehouse
  {
    path: '/warehouse',
    component: Layout,
    name: 'Warehouse',
    meta: {
      title: '仓库',
      icon: 'el-icon-s-help',
    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/warehouse/index'),
        meta: {title: '仓库详情'}
      },
      {
        path: 'donation',
        component: () => import('@/views/warehouse/donation'),
        meta: {title: '捐赠审核', roles: ['admin', 'warehouse']}
      },
      {
        path: 'apply',
        component: () => import('@/views/warehouse/apply'),
        meta: {title: '申请审核', roles: ['admin', 'warehouse']}
      },
    ]
  },

  // system
  {
    path: '/system',
    component: Layout,
    redirect: '/system/role',
    name: 'System',
    meta: {
      roles: ['admin'],
      title: '系统管理',
      icon: 'el-icon-s-help'
    },
    children: [
      {
        path: 'role',
        component: () => import('@/views/system/role'),
        meta: {title: '角色管理'}
      },
      {
        path: 'user',
        component: () => import('@/views/system/user'),
        meta: {title: '用户管理'}
      },
      {
        path: 'warehouse',
        component: () => import('@/views/system/warehouse'),
        meta: {title: '仓库管理'}
      },
    ]
  },

  // 404 page must be placed at the end !!!
  {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
  mode: 'history',
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
