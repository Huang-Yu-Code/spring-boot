<template>
  <div>
    <!--过滤|添加-->
    <el-form :inline="true" :model="params" class="demo-form-inline">
      <el-form-item label="角色">
        <el-input v-model="params.name" placeholder="角色" maxlength="16" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="标识符">
        <el-input v-model="params.code" placeholder="标识符" maxlength="16" show-word-limit></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="flushList">刷新|查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="insertDialog=true">添加</el-button>
      </el-form-item>
    </el-form>

    <!--添加面板-->
    <el-dialog title="添加" :visible.sync="insertDialog" width="30%">
      <el-form ref="form" :model="insertForm" label-width="80px">
        <el-form-item label="角色">
          <el-input v-model="insertForm.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="标识符">
          <el-input v-model="insertForm.code" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="insertRole">确定</el-button>
          <el-button @click="insertDialog = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--表格-->
    <el-table :data="tableList" border style="width: 100%">
      <el-table-column label="序号" type="index" width="100px"></el-table-column>
      <el-table-column label="角色" prop="name"></el-table-column>
      <el-table-column label="标识符" prop="code"></el-table-column>
      <el-table-column label="创建时间" prop="createTime"></el-table-column>
      <el-table-column label="更新时间" prop="updateTime"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="editItem(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteRole(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--编辑面板-->
    <el-dialog title="编辑" :visible.sync="updateDialog" width="30%">
      <el-form ref="form" :model="updateForm" label-width="80px">
        <el-form-item label="角色">
          <el-input v-model="updateForm.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="标识符">
          <el-input v-model="updateForm.code" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateRole">确定</el-button>
          <el-button @click="updateDialog = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>

import { getRoles, deleteRole, insertRole, updateRole } from '@/api/role'

export default {
  data() {
    return {
      params: {},
      tableList: [],
      insertForm: {
        name: '',
        code: ''
      },
      insertDialog: false,
      updateForm: {},
      updateDialog: false
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
    flushList() {
      this.getRoles()
      this.$message.success("数据已刷新")
    },
    getRoles() {
      getRoles(this.params).then(data => {
        this.tableList = data
      })
    },
    insertRole() {
      insertRole(this.insertForm).then(() => {
        this.$message.success("添加成功")
        this.insertDialog = false
        this.getRoles()
        this.insertForm={
          name: '',
          code: ''
        }
      })
    },
    editItem(item) {
      this.updateDialog = true
      this.updateForm = item
    },
    updateRole() {
      updateRole(this.updateForm).then(() => {
        this.$message.success('修改成功')
        this.updateDialog = false
      })
    },
    deleteRole(id) {
      deleteRole(id).then(() => {
        this.$message.success('删除成功')
        this.getRoles()
      })
    }
  }
}
</script>

<style scoped>

</style>
