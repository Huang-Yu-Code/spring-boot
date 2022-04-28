import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

export function getUserRoles() {
  return request({
    url: '/user-roles',
    method: 'get',
  })
}

export function resetPassword(data) {
  return request({
    url: '/password',
    method: 'post',
    data
  })
}

export function getUserInfo() {
  return request({
    url: '/user-info',
    method: 'get',
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}
