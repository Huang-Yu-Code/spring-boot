const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.auth.token,
  roles: state => state.auth.roles,
  image: state => state.auth.image,
  permission_routes: state => state.permission.routes
}
export default getters
