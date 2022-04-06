<template>
  <div>
    <el-card class="box-card">
      <el-descriptions class="margin-top" title="个人信息" :column="3" border>
        <template slot="extra">
          <el-button type="danger" size="small" @click="updateUserInfo" v-if="!disabled">确认</el-button>
          <el-button type="primary" size="small" @click="onSubmit">{{ buttonMsg }}</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            账号
          </template>
          <el-input v-model="user.username" disabled=""></el-input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            身份证
          </template>
          <el-input v-model="user.userInfo.idNumbers" :disabled="disabled"></el-input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机
          </template>
          <el-input v-model="user.userInfo.phoneNumbers" :disabled="disabled"></el-input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            姓名
          </template>
          <el-input v-model="user.userInfo.name" :disabled="disabled"></el-input>
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            角色
          </template>
          <el-tag size="small" v-for="role in user.roles">{{ role.name }}</el-tag>
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>
</template>

<script>
import { updateUser } from '@/api/user'

export default {
  props: {},
  beforeCreate() {
  },
  created() {
    this.$store.dispatch('auth/getUser').then(data => {
      this.user = data
    })
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
  data() {
    return {
      user: {
        id: '',
        username: '',
        createTime: '',
        userInfo: {
          name: '',
          image: '',
          idNumbers: '',
          phoneNumbers: ''
        },
        roles: []
      },
      disabled:true,
      buttonMsg: '修改个人信息',
    }
  },
  computed: {},
  watch: {},
  methods: {
    onSubmit(){
      if (!this.disabled){
        this.buttonMsg = '修改个人信息'
      }
      else {
        this.buttonMsg = '取消'
      }
      this.disabled=!this.disabled
    },
    updateUserInfo() {
      updateUser(this.user).then(() => {
        this.disabled=true
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
