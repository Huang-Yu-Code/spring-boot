import request from '@/utils/request'

export function getUserRoles(params) {
  const {userId} = params
  return request({
    url: '/users/' + userId + '/roles', method: 'get',
  })
}

export function addUserRole(data) {
  const {userId, roleId} = data
  return request({
    url: '/users/' + userId + '/roles/' + roleId, method: 'post',
  })
}

export function deleteUserRole(params) {
  const {userId, roleId} = params
  return request({
    url: '/users/' + userId + '/roles/' + roleId, method: 'delete',
  })
}
