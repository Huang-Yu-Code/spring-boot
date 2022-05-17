import Vue from 'vue'
import VueRouter from 'vue-router'
import Websocket from '../views/websocket'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Websocket',
    component: Websocket
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
