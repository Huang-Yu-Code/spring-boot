import request from '@/utils/request'

export function uploadFile(data) {
    return request({
        url: '/minio',
        method: 'post',
        data
    })
}

export function deleteFile(id) {
    return request({
        url: '/minio/' + id,
        method: 'delete',
        params: {id}
    })
}