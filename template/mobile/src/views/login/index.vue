<template>
  <van-form @submit="onSubmit">
    <van-field
        v-model="username"
        :rules="[{ required: true, message: '请填写用户名' }]"
        label="用户名"
        name="用户名"
        placeholder="用户名"
    />
    <van-field
        v-model="password"
        :rules="[{ required: true, message: '请填写密码' }]"
        label="密码"
        name="密码"
        placeholder="密码"
        type="password"
    />
    <div style="margin: 16px;">
      <van-button block native-type="submit" round type="info">提交</van-button>
    </div>
  </van-form>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    onSubmit(values) {
      console.log('submit', values);
    },
  },
}
</script>

<style scoped>

</style>
