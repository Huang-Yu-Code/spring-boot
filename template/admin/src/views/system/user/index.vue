<template>
  <div>
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="formInline.user" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="角色">
        <el-select v-model="formInline.region" placeholder="角色">
          <el-option label="社会人员" value="shanghai"></el-option>
          <el-option label="仓库管理员" value="beijing"></el-option>
          <el-option label="医护人员" value="beijing3"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="账号">
        <el-input v-model="formInline.user" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="success">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">刷新</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="danger">添加</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column label="序号" type="index"></el-table-column>
      <el-table-column label="账号" prop="username"></el-table-column>
      <el-table-column label="角色">
        <template slot-scope="scope">
          {{scope.row.roles}}
        </template>
      </el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="身份证" prop="idNumbers"></el-table-column>
      <el-table-column label="手机" prop="phoneNumbers"></el-table-column>
      <el-table-column label="性别" prop="sex"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="info" size="small">编辑</el-button>
          <el-button type="danger" size="small" v-if="scope.row.username!=='admin'">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      roles: [],
      form: {
        name: '',
        username: '',
        password: '',
        roles: []
      },
      formInline: {
        user: null
      },
      tableData: JSON.parse(localStorage.getItem('tempUsers'))
    }
  },
  mounted() {
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {
        })
    }

  }
}
</script>

<style scoped>

</style>
