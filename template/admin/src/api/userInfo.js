import request from '@/utils/request'

export function updateUserInfo(data) {
  return request({
    url: '/upload',
    method: 'put',
    data
  })
}
