const api = {
    baseUrl: 'http://localhost:5500/sso',
    logonUrl: '/logon',
    loginUrl: '/login',
    logoutUrl: '/logout',
    request: function (method, url, data, success) {
        const xhr = new XMLHttpRequest();
        xhr.open(method, this.baseUrl + url, true);
        xhr.setRequestHeader("Accept", "application/json; charset=UTF-8");
        xhr.setRequestHeader("Content-Type", "application/json")
        xhr.responseType = "json";
        xhr.send(JSON.stringify(data));
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                success(xhr.response);
            } else {

            }
        }
    },
}

function logon() {
    const success = function (response) {
        console.log(response);
    };
    api.request("POST", api.logonUrl, {}, success)
}

function login() {
    const data = {
        username: '123456',
        password: '123456',
        captcha: '0000',
        remember: true,
    };
    const success = function (response) {
        console.log(response);
    };
    api.request("POST", api.loginUrl, data, success)
}

function logout() {
    const success = function (response) {
        console.log(response);
    };
    api.request("POST", api.logoutUrl, {}, success)
}