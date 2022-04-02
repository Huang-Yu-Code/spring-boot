import request from '@/utils/request'

export function getInfo(token) {
  return request({
    url: '/user/info/' + token,
    method: 'get',
  })
}

export function getRole(token) {
  return request({
    url: '/user/role/' + token,
    method: 'get',
  })
}
