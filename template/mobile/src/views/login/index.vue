<template>
  <div id="login">
    <van-nav-bar title="用户登录"/>
    <van-form @submit="onSubmit">
      <van-field
          v-model="username"
          :rules="[{ required: true, message: '请填写用户名' }]"
          label="用户名"
          name="用户名"
          placeholder="用户名"/>
      <van-field
          v-model="password"
          :rules="[{ required: true, message: '请填写密码' }]"
          label="密码"
          name="密码"
          placeholder="密码"
          type="password"/>
      <div style="margin: 16px;">
        <van-button block native-type="submit" round type="info">登录</van-button>
      </div>
      <div style="margin: 16px;">
        <van-button block round type="primary" @click="$router.push('/logon')">前往注册</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import {setToken} from '@/utils/auth'

export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    onSubmit(values) {
      setToken("!23")
      this.$router.push('/')
    },
  },
}
</script>

<style scoped>

</style>
