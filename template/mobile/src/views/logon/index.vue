<template>
  <div id="logon">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <el-button type="text" style="float: right; padding: 3px 0" @click="$router.push({name:'Login'})">已有账号?立即登录</el-button>
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
          <el-button type="primary" size="small" @click="logon">注册</el-button>
          <el-button type="danger" size="small" @click="reset">重置</el-button>
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
    logon(){

    },
    reset(){

    }
  },
}
</script>

<style scoped>
#logon {
  display: flex;
  align-items: center;
  justify-content: center;
}

.box-card {
  width: 400px;

}
</style>