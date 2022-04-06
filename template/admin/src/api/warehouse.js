import request from '@/utils/request'

const url = '/warehouse'

export function getWarehouses(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function insertWarehouse(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function updateWarehouse(data) {
  return request({
    url,
    method: 'put',
    data
  })
}

export function deleteWarehouse(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
