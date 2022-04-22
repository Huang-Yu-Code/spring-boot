import request from '@/utils/request'

const url = '/role'

export function getRoles(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function addRole(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function updateRole(data) {
  return request({
    url,
    method: 'put',
    data
  })
}

export function deleteRole(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
