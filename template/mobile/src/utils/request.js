import axios from 'axios'
import {Message, MessageBox} from 'element-ui'

const request = axios.create({
    baseURL: 'http://localhost:8080/api',
    timeout: 5000
})

request.interceptors.request.use(
    config => {
        return config
    },
    error => {
        Message({
            message: 'error',
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)

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
                MessageBox.confirm('您已注销登录, 是否重新登录', '注销确认', {
                    confirmButtonText: '重新登录',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    store.dispatch('auth/resetToken').then(() => {
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
        console.log('err' + error.message)
        Message({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)

export default request
