<template>
  <div id="login">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <el-button type="text" style="float: right; padding: 3px 0;color: red" @click="$router.push({name:'Logon'})">
          注册账号
        </el-button>
      </div>
      <el-form ref="form" :model="form">
        <el-form-item>
          <el-input v-model="form.username">
            <template slot="prepend"><em slot="prefix" class="el-icon-user-solid">账号:</em></template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="form.password" show-password>
            <template slot="prepend"><em slot="prefix" class="el-icon-info">密码:</em></template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" @click="login">登录</el-button>
          <el-button type="warning" size="small">忘记密码</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>

export default {
  props: {},
  data() {
    return {
      form: {
        username: 'admin',
        password: '123456',
      },
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
    login() {
      this.$store.dispatch('auth/login', this.form).then(() => {
        this.$message.success('登录成功')
        this.$router.push({path: this.redirect || '/'})
      })
    }
  },
}
</script>

<style scoped>
#login {
  display: flex;
  justify-content: center;
}

.box-card {
  width: 400px;
}

</style>