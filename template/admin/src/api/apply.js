import request from '@/utils/request'

const url = '/apply'

export function getApplies(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function insertApply(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function updateApply(data) {
  return request({
    url,
    method: 'put',
    data
  })
}

export function deleteApply(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
