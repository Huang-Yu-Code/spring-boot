<template>
  <div>
    <!--查找-->
    <el-collapse>
      <el-collapse-item>
        <template slot="title">
          精准查找
        </template>
        <el-form :inline="true" :model="params" class="demo-form-inline">
          <el-form-item label="角色">
            <el-input v-model="params.name" placeholder="角色" maxlength="16" show-word-limit></el-input>
          </el-form-item>
          <el-form-item label="标识符">
            <el-input v-model="params.code" placeholder="标识符" maxlength="16" show-word-limit></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" size="small" @click="handleSearchButton">查找</el-button>
          </el-form-item>
        </el-form>
      </el-collapse-item>
    </el-collapse>
    <!--表格-->
    <el-table :data="tableData" stripe border size="small" highlight-current-row style="width: 100%">
      <el-table-column label="序号" type="index" width="50" align="center"></el-table-column>
      <el-table-column label="角色" prop="name" align="center"></el-table-column>
      <el-table-column label="标识符" align="center">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.code }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" prop="createTime" align="center"></el-table-column>
      <el-table-column label="更新时间" prop="updateTime" align="center"></el-table-column>
      <el-table-column label="操作">
        <template slot="header" slot-scope="scope">
          <el-button type="success" size="small" @click="handleAddButton">添加</el-button>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleUpdateButton(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDeleteButton(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--添加面板-->
    <el-dialog title="添加" :visible.sync="addDialog" width="33%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="角色">
          <el-input v-model="form.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="标识符">
          <el-input v-model="form.code" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAddButtonSubmit">确定</el-button>
          <el-button @click="handleAddButtonCancel">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--编辑面板-->
    <el-dialog title="编辑" :visible.sync="updateDialog" width="33%">
      <el-form ref="form" :model="item" label-width="80px">
        <el-form-item label="角色">
          <el-input v-model="item.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="标识符">
          <el-input v-model="item.code" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleUpdateButtonSubmit">确定</el-button>
          <el-button @click="handleUpdateButtonCancel">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>

import {getRoles, addRole, updateRole, deleteRole} from '@/api/role'

export default {
  data() {
    return {
      params: {},
      tableData: [],
      item: {},
      form: {},
      addDialog: false,
      updateDialog: false,
    }
  },
  computed: {},
  watch: {},
  mounted() {
    this.initialization()
  },
  methods: {
    initialization() {
      this.getTableData()
    },
    getTableData() {
      getRoles(this.params).then(data => {
        this.tableData = data
      })
    },
    handleSearchButton() {
      this.getTableData();
    },
    handleAddButton() {
      this.addDialog = true
      this.form = {}
    },
    handleAddButtonSubmit() {
      addRole(this.form).then(() => {
        this.$message.success('添加成功')
        this.getTableData()
        this.addDialog = false
      })
    },
    handleAddButtonCancel() {
      this.addDialog = false
    },
    handleUpdateButton(item) {
      this.updateDialog = true
      this.item = {...item}
    },
    handleUpdateButtonSubmit() {
      updateRole(this.item).then(() => {
        this.$message.success('修改成功')
        this.getTableData()
        this.updateDialog = false
      })
    },
    handleUpdateButtonCancel() {
      this.updateDialog = false
    },
    handleDeleteButton(id) {
      deleteRole(id).then(() => {
        this.$message.success('删除成功')
        this.getTableData()
      })
    },
  }
}
</script>

<style scoped>

</style>
