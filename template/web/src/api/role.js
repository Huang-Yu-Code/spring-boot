import request from '@/utils/request'

export function getRoleList(params) {
  return request({
    url: '/role',
    method: 'get',
    params: params
  })
}

export function insertRole(data) {
  return request({
    url: '/role',
    method: 'post',
    data
  })
}

export function updateRole(data) {
  return request({
    url: '/role',
    method: 'put',
    data
  })
}

export function deleteRole(id) {
  return request({
    url: '/role/' + id,
    method: 'delete',
  })
}
