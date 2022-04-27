<template>
  <div>
    <el-form ref="form" :model="data" label-width="80px">
      <el-form-item label="表单参数1">
        <el-input v-model="data.key1"></el-input>
      </el-form-item>
      <el-form-item label="表单参数2">
        <el-input v-model="data.key2"></el-input>
      </el-form-item>
      <el-form-item label="表单参数3">
        <el-input v-model="data.key3"></el-input>
      </el-form-item>
    </el-form>
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
      <img v-if="image" :src="image" alt="头像" class="avatar">
      <em v-else class="el-icon-plus avatar-uploader-icon"></em>
    </el-upload>
    <el-button type="success" @click="submitUpload">上传到服务器</el-button>
  </div>
</template>

<script>

export default {
  data() {
    return {
      image: false,
      action: 'http://localhost:8080/api/upload',
      headers: {},
      data: {},
      name: 'file',
      fileList: []
    }
  },
  methods: {
    handleBeforeUpload(file) {
      console.log(file.type)
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
      this.image = URL.createObjectURL(file.raw)
      console.log(fileList)
    },
    submitUpload() {
      console.log('click')
      this.$refs.upload.submit();
    },
    handleOnProgress(event, file, fileList) {
      console.log(event, file, fileList)
    },
    handleOnSuccess(response, file, fileList) {
      console.log(response, file, fileList)
      this.$refs.upload.clearFiles()
      this.image = false
      this.data = {}
      this.$message.success('上传成功');
    },
    handleOnError(err, file, fileList) {
      console.log(err, file, fileList)
    }
  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
