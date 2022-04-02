<template>
  <div>
    <el-card class="box-card">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="原密码">
          <el-input v-model="form.oldPassword"></el-input>
        </el-form-item>
        <el-form-item label="新密码">
          <el-input v-model="form.newPassword"></el-input>
        </el-form-item>
        <el-form-item label="确认密码">
          <el-input v-model="form.rePassword"></el-input>
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
  data() {
    return {
      form: {
        oldPassword: '',
        newPassword: '',
        rePassword: '',
      }
    }
  },
  computed: {},
  watch: {},
  methods: {
    updatePassword() {
      this.form = {};
      this.$message.success('修改成功');
    }
  },
}
</script>

<style scoped>

</style>
