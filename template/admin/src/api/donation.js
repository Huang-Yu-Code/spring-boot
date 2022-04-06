import request from '@/utils/request'

const url = '/donation'

export function getDonations(params) {
  return request({
    url,
    method: 'get',
    params: params
  })
}

export function insertDonation(data) {
  return request({
    url,
    method: 'post',
    data
  })
}

export function updateDonation(data) {
  return request({
    url,
    method: 'put',
    data
  })
}

export function deleteDonation(id) {
  return request({
    url: url + '/' + id,
    method: 'delete'
  })
}
