import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layout/shop'
import Dashboard from '@/views/dashboard'
import {getToken} from '@/utils/auth'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'dashboard',
        component: Dashboard
    },
    {
        path: '/shop',
        name: 'Shop',
        redirect: '/shop/index',
        component: Layout,
        children: [
            {
                path: 'index',
                component: () => import('@/views/shop')
            },
            {
                path: 'category',
                component: () => import('@/views/shop/category')
            },
            {
                path: 'car',
                component: () => import('@/views/shop/car')
            },
            {
                path: 'personal',
                component: () => import('@/views/shop/personal')
            },
        ]
    },
    {
        path: '/music',
        name: 'Music',
        component: Layout,
        children: [
            {
                path: 'index',
                component: () => import('@/views/music')
            },
            {
                path: 'category',
                component: () => import('@/views/music')
            },
            {
                path: 'car',
                component: () => import('@/views/music')
            },
            {
                path: 'personal',
                component: () => import('@/views/music')
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login')
    },
    {
        path: '/logon',
        name: 'Logon',
        component: () => import('@/views/logon')
    },
    {
        path: '*',
        name: '404',
        component: () => import('@/views/404')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

const whiteList = ['/', '/home', '/category', '/login', '/404']

const isAuthenticated = getToken()
router.beforeEach((to, from, next) => {
    if (isAuthenticated) {
        next()
    } else {
        if (to.path==='/login'|| to.path==='/logon'){
            next()
        }
        else {
            next({name:'Login'})
        }
    }
})

export default router
