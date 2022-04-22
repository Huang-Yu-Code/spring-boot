<template>
  <div>
    <el-card class="box-card">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="原密码" prop="oldPassword">
          <el-input v-model="form.oldPassword" show-password/>
        </el-form-item>
        <el-form-item label="新密码" prop="newPassword">
          <el-input v-model="form.newPassword" show-password/>
        </el-form-item>
        <el-form-item label="确认密码" prop="rePassword">
          <el-input v-model="form.rePassword" show-password/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updatePassword">立即修改</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>

export default {
  props: {},
  data() {
    const validateRePassword = (rule, value, callback) => {
      if (value !== this.form.newPassword) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      form: {
        oldPassword: '',
        newPassword: '',
        rePassword: ''
      },
      rules: {
        oldPassword: [
          {required: true, message: '请输入原密码', trigger: 'blur'},
          {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'}
        ],
        newPassword: [
          {required: true, message: '请输入新密码', trigger: 'blur'},
          {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'}
        ],
        rePassword: [
          {required: true, message: '请确认新密码', trigger: 'blur'},
          {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'},
          {validator: validateRePassword, trigger: 'blur'}
        ]
      }
    }
  },
  computed: {},
  watch: {},
  methods: {
    updatePassword() {
      // TODO
    }
  }
}
</script>

<style scoped>

</style>
