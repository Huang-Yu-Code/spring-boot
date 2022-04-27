import request from '@/utils/request'

export function updateUserInfo(file, data) {
  return request({
    url: '/upload',
    method: 'put',
    data: {file, ...data}
  })
}
