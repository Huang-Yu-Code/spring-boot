import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { getUser, login, logout } from '@/api/auth'
import item from '@/layout/components/Sidebar/Item'

const getDefaultState = () => {
  return {
    token: getToken(),
    id: '',
    username: '',
    info: {},
    roles: []
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
  SET_ID: (state, id) => {
    state.id = id
  },
  SET_USERNAME: (state, username) => {
    state.username = username
  },
  SET_USERINFO: (state, info) => {
    state.info = info
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  }
}

const actions = {
  login({ commit }, userInfo) {
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password }).then(data => {
        commit('SET_TOKEN', data)
        setToken(data)
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  getUser({ commit }) {
    return new Promise((resolve, reject) => {
      getUser(state.token).then(data => {
        if (!data) {
          reject('认证失败, 请重新登录!')
        }
        const { id, username, userInfo, roles } = data
        if (!roles || roles.length <= 0) {
          reject('当前用户角色未授予角色!')
        }
        commit('SET_ID', id)
        commit('SET_USERNAME', username)
        commit('SET_USERINFO', userInfo)
        commit('SET_ROLES', roles.map(item => {
          return item.code
        }))
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken()
        resetRouter()
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  resetToken({ commit }) {
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

