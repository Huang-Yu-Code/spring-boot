import axios from 'axios'
import {Message} from 'element-ui'

const service = axios.create({
    baseURL: 'http://localhost:8080/api',
    timeout: 5000
})

service.interceptors.request.use(
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

service.interceptors.response.use(
    response => {
        return response
    },
    error => {
        console.log(error)
        Message({
            message: 'error',
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)

export default service