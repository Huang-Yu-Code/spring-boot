const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.auth.token,
  id: state => state.auth.id,
  username: state => state.auth.username,
  name: state => state.user.name,
  roles: state => state.user.roles,
  image: state => state.user.image,
  permission_routes: state => state.permission.routes
}
export default getters
