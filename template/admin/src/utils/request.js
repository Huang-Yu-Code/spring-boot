import axios from 'axios'
import {MessageBox, Message} from 'element-ui'
import store from '@/store'
import {getToken} from '@/utils/auth'

const request = axios.create({
  baseURL: 'http://localhost:8080/api',
  withCredentials: true,
  timeout: 5000
})

request.interceptors.request.use(
  config => {
    if (store.getters.token) {
      config.headers['Authorization'] = getToken()
    }
    return config
  },
  error => {
    console.log(error)
    return Promise.reject(error)
  }
)

// response interceptor
request.interceptors.response.use(
  response => {
    const {code, message, data} = response.data
    if (code !== 200) {
      Message({
        message,
        type: 'error',
        duration: 5 * 1000
      })
      if (code===401){
        MessageBox.confirm('You have been logged out, you can cancel to stay on this page, or log in again', 'Confirm logout', {
          confirmButtonText: '重新登录',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          store.dispatch('user/resetToken').then(() => {
            location.reload()
          })
        })
      }
      return Promise.reject(new Error(message))
    } else {
      return data
    }
  },
  error => {
    Message({
      message: '网络错误,请检查网络连接',
      type: 'error',
      duration: 3 * 1000
    })
    console.log(error.message)
    return Promise.reject(error)
  }
)

export default request
