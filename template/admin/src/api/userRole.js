import request from '@/utils/request'

const url = '/user-role'

export function getUserRoles(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function addUserRole(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function deleteUserRole(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
