const getters = {
    device: state => state.app.device,
    token: state => state.auth.token,
    id: state => state.auth.id,
    username: state => state.auth.username,
    info: state => state.auth.info,
}
export default getters
