import request from '@/utils/request'

export function getUserInfo(token) {
  return request({
    url: '/user/info/' + token,
    method: 'get',
  })
}

export function getUserRole(token) {
  return request({
    url: '/user/role/' + token,
    method: 'get',
  })
}

export function updateUserInfo(data) {
  return request({
    url: '/user/info',
    method: 'put',
    data
  })
}

export function updatePassword(data) {
  return request({
    url: '/user/password',
    method: 'put',
    data
  })
}

export function updateState(data) {
  return request({
    url: '/user/sate',
    method: 'put',
    data
  })
}
