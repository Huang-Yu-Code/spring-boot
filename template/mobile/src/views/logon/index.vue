<template>
  <div id="logon">
    <van-nav-bar title="用户注册"/>
    <van-form @submit="onSubmit">
      <van-field
          v-model="username"
          name="用户名"
          label="用户名"
          placeholder="用户名"
          :rules="[{ required: true, message: '请填写用户名' }]"/>
      <van-field
          v-model="password"
          type="password"
          name="密码"
          label="密码"
          placeholder="密码"
          :rules="[{ required: true, message: '请填写密码' }]"/>
      <van-field
          v-model="password"
          type="password"
          name="密码"
          label="密码"
          placeholder="密码"
          :rules="[{ required: true, message: '请填写密码' }]"/>
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">注册</van-button>
      </div>
      <div style="margin: 16px;">
        <van-button round block type="danger" @click="$router.push('/login')">返回登录</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
export default {
  props: {},
  data() {
    return {
      username: '',
      password: '',
    }
  },
  computed: {},
  watch: {},
  beforeCreate() {
  },
  created() {
  },
  beforeMount() {
  },
  mounted() {
    this.initialization()
  },
  beforeUpdate() {
  },
  updated() {
  },
  beforeDestroy() {
  },
  destroyed() {
  },
  methods: {
    initialization() {
      console.log('初始化')
    },
    onSubmit(values) {
      console.log('submit', values);
    },
  },
}
</script>

<style scoped>

</style>
