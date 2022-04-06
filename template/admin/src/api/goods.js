import request from '@/utils/request'

const url = '/goods'

export function getGoods(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function insertGoods(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function updateGoods(data) {
  return request({
    url,
    method: 'put',
    data
  })
}

export function deleteGoods(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
