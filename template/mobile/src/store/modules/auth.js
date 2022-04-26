import {getToken, removeToken, setToken} from '@/utils/auth'
import {login, logout} from '@/api/auth'

const getDefaultState = () => {
  return {
    token: getToken(),
    image: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
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


  logout({commit}) {
    return new Promise((resolve, reject) => {
      logout().then(() => {
        removeToken()
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

