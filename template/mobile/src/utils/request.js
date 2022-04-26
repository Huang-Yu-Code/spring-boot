import axios from 'axios'
import store from '@/store'
import {getToken} from '@/utils/auth'
import {Toast} from 'vant'

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
      Toast.fail(message);
      if (code===401){
        Toast.fail(message);
        store.dispatch('user/resetToken').then(() => {
          location.reload()
        })
      }
      return Promise.reject(new Error(message))
    } else {
      return data
    }
  },
  error => {
    Toast.fail('网络错误,请检查网络连接');
    return Promise.reject(error)
  }
)

export default request
