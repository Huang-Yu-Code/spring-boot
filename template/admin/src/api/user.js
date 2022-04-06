import request from '@/utils/request'

const url = '/user'

export function getUsers(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function insertUser(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function updateUser(data) {
  return request({
    url,
    method: 'put',
    data
  })
}

export function updatePassword(data) {
  return request({
    url: url + '/password',
    method: 'put',
    data
  })
}

export function deleteUser(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
