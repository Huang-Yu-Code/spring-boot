<template>
  <div>
    <el-descriptions :column="4" border direction="vertical" title="垂直带边框列表">
      <el-descriptions-item label="用户名">kooriookami</el-descriptions-item>
      <el-descriptions-item label="手机号">18100000000</el-descriptions-item>
      <el-descriptions-item :span="2" label="居住地">苏州市</el-descriptions-item>
      <el-descriptions-item label="备注">
        <el-tag size="small">学校</el-tag>
      </el-descriptions-item>
      <el-descriptions-item label="联系地址">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
    </el-descriptions>
    <!--    <el-card class="box-card">-->
    <!--      <el-descriptions :column="3" border class="margin-top" title="个人信息">-->
    <!--        <template slot="extra">-->
    <!--          <el-button v-if="!disabled" size="small" type="danger" @click="updateUserInfo">确认</el-button>-->
    <!--          <el-button size="small" type="primary" @click="onSubmit">{{ buttonMsg }}</el-button>-->
    <!--        </template>-->
    <!--        <el-descriptions-item>-->
    <!--          <template slot="label">-->
    <!--            <i class="el-icon-user"></i>-->
    <!--            账号-->
    <!--          </template>-->
    <!--          <el-input v-model="userInfo.id" disabled></el-input>-->
    <!--        </el-descriptions-item>-->
    <!--        <el-descriptions-item>-->
    <!--          <template slot="label">-->
    <!--            <i class="el-icon-mobile-phone"></i>-->
    <!--            身份证-->
    <!--          </template>-->
    <!--          <el-input v-model="userInfo.idNumbers" :disabled="disabled"></el-input>-->
    <!--        </el-descriptions-item>-->
    <!--        <el-descriptions-item>-->
    <!--          <template slot="label">-->
    <!--            <i class="el-icon-mobile-phone"></i>-->
    <!--            手机-->
    <!--          </template>-->
    <!--          <el-input v-model="userInfo.phoneNumbers" :disabled="disabled"></el-input>-->
    <!--        </el-descriptions-item>-->
    <!--        <el-descriptions-item>-->
    <!--          <template slot="label">-->
    <!--            <i class="el-icon-tickets"></i>-->
    <!--            姓名-->
    <!--          </template>-->
    <!--          <el-input v-model="userInfo.name" :disabled="disabled"></el-input>-->
    <!--        </el-descriptions-item>-->
    <!--      </el-descriptions>-->
    <!--    </el-card>-->
  </div>
</template>

<script>
import {updateUser} from '@/api/user'
import {getUserInfo} from '@/api/auth'

export default {
  beforeMount() {
    getUserInfo().then(data => {
      console.log(data)
      this.user = data
    })
  },
  data() {
    return {
      userInfo: {},
      disabled: true,
      buttonMsg: '修改个人信息',
    }
  },
  computed: {},
  watch: {},
  methods: {
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
