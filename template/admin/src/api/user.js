import request from '@/utils/request'

const url = '/users'

export function getUsers(params) {
  return request({
    url, method: 'get', params
  })
}

export function addUser(data) {
  return request({
    url, method: 'post', data
  })
}

export function updateUser(data) {
  return request({
    url, method: 'put', data
  })
}

export function deleteUser(id) {
  return request({
    url: url + '/' + id, method: 'delete'
  })
}
