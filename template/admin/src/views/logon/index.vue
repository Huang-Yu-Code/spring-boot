<template>
  <div id="logon">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>社会人员注册</span>
        <el-button style="float: right; padding: 3px 0" type="danger" @click="$router.push('/login')">返回登录</el-button>
      </div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="form.userInfo.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input v-model="form.userInfo.idNumbers" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="手机">
          <el-input v-model="form.userInfo.phoneNumbers" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="insertUser">注册</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { insertUser } from '@/api/user'
import { getRoles } from '@/api/role'

export default {
  props: {},
  data() {
    return {
      form: {
        userInfo: {},
        roles: []
      }
    }
  },
  computed: {},
  watch: {},
  mounted() {
    this.initData()
  },
  methods: {
    initData() {
      this.getRoles()
    },
    getRoles() {
      getRoles({ code: 'user' }).then(data => {
        console.log(data)
        this.form.roles = data
      })
    },
    insertUser() {
      insertUser(this.form).then(() => {
        this.$message.success('注册成功')
        this.$router.push('/login')
      })
    }
  }
}
</script>

<style scoped>
#logon {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  bottom: 0;
  top: 0;
  left: 0;
  right: 0;
  background-color: #2d3a4b;
}

.box-card {
  width: 480px;
}
</style>
