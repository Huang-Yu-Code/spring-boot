const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.auth.token,
  id: state => state.auth.id,
  username: state => state.auth.username,
  info: state => state.auth.info,
  roles: state => state.auth.roles,
  permission_routes: state => state.permission.routes
}
export default getters
