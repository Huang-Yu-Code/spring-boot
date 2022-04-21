const getters = {
    device: state => state.app.device,
    token: state => state.auth.token,
    id: state => state.user.id,
    name: state => state.user.name,
    image: state => state.user.image,
    roles: state => state.user.roles,
}
export default getters
