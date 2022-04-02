import {getInfo, getRole} from '@/api/user'
import {getToken} from '@/utils/auth'

const getDefaultState = () => {
  return {
    id: '',
    name: '',
    image: '',
    roles: []
  }
}

const state = getDefaultState()

const mutations = {
  SET_ID: (state, id) => {
    state.id = id
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_IMAGE: (state, image) => {
    state.image = image
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  }
}

const actions = {
  getInfo({commit}) {
    return new Promise((resolve, reject) => {
      getInfo(getToken())
        .then(data => {
          if (!data) {
            reject('认证失败, 请重新登录!')
          }
          let {id, name, image} = data
          commit('SET_ID', id)
          commit('SET_NAME', name)
          commit('SET_IMAGE', image)
          resolve(data)
        })
        .catch(error => {
          reject(error)
        })
    })
  },

  getRole({commit}) {
    return new Promise((resolve, reject) => {
      getRole(getToken())
        .then(data => {
          const roles = data
          if (!roles || roles.length <= 0) {
            reject('当前用户角色未授予角色!')
          }
          commit('SET_ROLES', roles)
          resolve(data)
        })
        .catch(error => {
          reject(error)
        })
    })
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

