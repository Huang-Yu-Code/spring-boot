<template>
  <div id="personal">
    <!--展示面板-->
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>个人信息</span>
        <el-button style="float: right; padding: 3px 0" type="primary" @click="handleUpdateButton">更新信息</el-button>
      </div>
      <el-avatar :size="150"
                 :src="userInfo.image|| 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'"></el-avatar>
      <el-descriptions :column="1">
        <el-descriptions-item label="姓名">
          {{ userInfo.name }}
        </el-descriptions-item>
        <el-descriptions-item label="身份证">
          {{ userInfo.idNumbers }}
        </el-descriptions-item>
        <el-descriptions-item label="手机号">
          {{ userInfo.phoneNumbers }}
        </el-descriptions-item>
        <el-descriptions-item label="邮箱">
          {{ userInfo.email }}
        </el-descriptions-item>
        <el-descriptions-item label="注册时间">
          {{ userInfo.createTime }}
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
    <!--更新面板-->
    <el-dialog
      :visible.sync="updateDialog"
      title="更新信息"
      width="33%">
      <el-form ref="form" :model="data" label-width="80px">
        <el-form-item label="头像">
          <el-upload
            ref="upload"
            :action="action"
            :auto-upload="false"
            :before-upload="handleBeforeUpload"
            :data="data"
            :drag="false"
            :file-list="fileList"
            :headers="headers"
            :multiple="false"
            :name="name"
            :on-change="handleOnChange"
            :on-error="handleOnError"
            :on-progress="handleOnProgress"
            :on-success="handleOnSuccess"
            :show-file-list="false"
            accept="image/*"
            class="avatar-uploader"
            list-type="picture"
            with-credentials>
            <el-avatar :size="150" :src="data.image"></el-avatar>
          </el-upload>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="data.name"></el-input>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input v-model="data.idNumbers"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="data.phoneNumbers"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="data.email"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="updateDialog = false">取 消</el-button>
    <el-button type="primary" @click="updateUserInfo">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>

import {getUserInfo} from '@/api/auth'

export default {
  data() {
    return {
      userInfo: {},
      updateDialog: false,
      action: 'http://localhost:8080/api/upload',
      headers: {},
      data: {},
      name: 'file',
      fileList: []
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
    handleUpload() {
    },
    handleUpdateButton() {
      this.data = {...this.userInfo}
      this.updateDialog = true
    },
    updateUserInfo() {
      console.log(this.$refs.upload)
      this.$refs.upload.submit();
    },
    handleBeforeUpload(file) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },
    handleOnChange(file, fileList) {
      this.data.image = URL.createObjectURL(file.raw)
    },
    handleOnProgress(event, file, fileList) {
      console.log(event, file, fileList)
    },
    handleOnSuccess(response, file, fileList) {
      this.updateDialog = false
      this.$refs.upload.clearFiles()
      this.data = {}
      this.$message.success('上传成功');
      this.getUserInfo()
    },
    handleOnError(err, file, fileList) {
      console.log(err, file, fileList)
    }
  }
}
</script>

<style scoped>

</style>
