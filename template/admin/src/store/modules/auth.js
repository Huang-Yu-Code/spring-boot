import {getToken, removeToken, setToken} from '@/utils/auth'
import {resetRouter} from '@/router'
import {getUserRoles, login, logout} from '@/api/auth'
import {image} from '@/settings'

const getDefaultState = () => {
  return {
    token: getToken(),
    roles: [],
    image: image,
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  },
  SET_IMAGE: (state, image) => {
    state.image = image
  }
}

const actions = {
  login({commit}, form) {
    const {username, password} = form
    return new Promise((resolve, reject) => {
      login({username: username.trim(), password: password}).then(token => {
        commit('SET_TOKEN', token)
        setToken(token)
        resolve(token)
      }).catch(error => {
        reject(error)
      })
    })
  },

  getUserRoles({commit}) {
    return new Promise((resolve, reject) => {
      getUserRoles().then(roles => {
        if (!roles) {
          reject('认证失败, 请重新登录!')
        }
        if (!roles || roles.length <= 0) {
          reject('当前用户角色未授予角色!')
        }
        commit('SET_ROLES', roles.map(item => {
          return item.code
        }))
        resolve(roles)
      }).catch(error => {
        reject(error)
      })
    })
  },

  logout({commit}) {
    return new Promise((resolve, reject) => {
      logout().then(() => {
        removeToken()
        resetRouter()
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  resetToken({commit}) {
    return new Promise(resolve => {
      removeToken()
      commit('RESET_STATE')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

