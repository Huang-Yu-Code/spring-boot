<template>
  <div>
    <el-descriptions border class="margin-top" title="个人信息">
      <template slot="extra">
        <el-button size="small" type="primary">操作</el-button>
      </template>
      <el-descriptions-item label="头像">
        <el-avatar :src="userInfo.image" shape="square" size="large"></el-avatar>
      </el-descriptions-item>
      <el-descriptions-item label="姓名">{{ userInfo.name }}</el-descriptions-item>
      <el-descriptions-item label="身份证">{{ userInfo.idNumbers }}</el-descriptions-item>
      <el-descriptions-item label="手机号">{{ userInfo.phoneNumbers }}</el-descriptions-item>
    </el-descriptions>

  </div>
</template>

<script>


import {getUserInfo} from '@/api/userInfo'

export default {
  data() {
    return {
      userInfo: {},
    }
  },
  computed: {},
  watch: {},
  mounted() {
    this.initialization()
  },
  methods: {
    initialization() {
      this.getUserInfo()
    },
    getUserInfo() {
      getUserInfo().then(data => {
        this.userInfo = data
      })
    },
    onSubmit() {
      if (!this.disabled) {
        this.buttonMsg = '修改个人信息'
      } else {
        this.buttonMsg = '取消'
      }
      this.disabled = !this.disabled
    },
    updateUserInfo() {
      updateUser(this.user).then(() => {
        this.disabled = true
      })
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch()
    }
  }
}
</script>

<style scoped>
.box-card {
  width: 60%;
}
</style>
