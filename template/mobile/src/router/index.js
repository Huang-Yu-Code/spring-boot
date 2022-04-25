import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layout'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/home',
        component: Layout,
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import('@/views/home')
            },
            {
                path: 'category',
                name: 'Category',
                component: () => import('@/views/category')
            },
            {
                path: 'car',
                name: 'Car',
                component: () => import('@/views/car')
            },
            {
                path: 'personal',
                name: 'Personal',
                component: () => import('@/views/personal')
            },
            {
                path: 'login',
                name: 'Login',
                component: () => import('@/views/login')
            },
        ]
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

router.beforeEach(((to, from, next) => {
    if (whiteList.includes(to.path)) {
        next()
    } else {
        next('/login')
    }
}))

export default router
