import request from '@/utils/request'

export function updateUserInfo(data) {
  return request({
    url: '/user-infos',
    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
    method: 'put',
    data
  })
}
