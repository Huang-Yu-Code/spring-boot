import axios from 'axios'
import {Message} from 'element-ui'
import store from '@/store'
import {getToken} from '@/utils/auth'

const request = axios.create({
  baseURL: 'http://localhost:8080/api',
  withCredentials: true,
  timeout: 5000
})

request.interceptors.request.use(
  config => {
    config.headers['Authorization'] = getToken()
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
    const {data} = response.data
    return data
  },
  error => {
    let message;
    if (error.response) {
      const {status} = error.response
      if (status === 401) {
        store.dispatch('auth/resetToken').then(() => {
          location.reload()
        })
      }
      message = error.response.data.message
    } else {
      message = '网络错误,请检查网络连接'
    }
    Message({
      message: message,
      type: 'error',
      duration: 3 * 1000
    })
    return Promise.reject(error)
  }
)

export default request
