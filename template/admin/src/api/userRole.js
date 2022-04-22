import request from '@/utils/request'

const url = '/user-role'

export function getUserRoles(params) {
  return request({
    url, method: 'get', params: params
  })
}

export function addUserRole(data) {
  return request({
    url, method: 'post', data
  })
}

export function deleteUserRole(params) {
  return request({
    url: url, method: 'delete', params: {params}
  })
}
