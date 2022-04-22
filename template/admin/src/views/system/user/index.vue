<template>
  <div>
    <!--查找-->
    <el-collapse>
      <el-collapse-item>
        <template slot="title">
          精准查找
        </template>
        <el-form :inline="true" :model="params" class="demo-form-inline">
          <el-form-item label="账号">
            <el-input v-model="params.username" placeholder="账号" maxlength="16" show-word-limit></el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-select v-model="params.state" placeholder="请选择账号状态">
              <el-option label="正常" value="1"></el-option>
              <el-option label="异常" value="0"></el-option>
            </el-select>
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
      <el-table-column label="账号" prop="username" align="center"></el-table-column>
      <el-table-column label="状态" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.state===1?'success':'danger'"><em
            :class="scope.row.state===1?'el-icon-success':'el-icon-error'"></em>{{
              scope.row.state === 1 ? '正常' : '异常'
            }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" prop="createTime" align="center"></el-table-column>
      <el-table-column label="更新时间" prop="updateTime" align="center"></el-table-column>
      <el-table-column label="操作">
        <template slot="header" slot-scope="scope">
          <el-button type="success" size="small" @click="handleAddButton">添加</el-button>
        </template>
        <template slot-scope="scope">
          <el-button size="mini" type="success" @click="">{{ scope.row.state === 1 ? '冻结' : '解冻' }}</el-button>
          <el-button size="mini" type="warning" @click="">重置密码</el-button>
          <el-button size="mini" type="primary" @click="handleRoleButton(scope.row.id)">授权</el-button>
          <el-button size="mini" type="danger" @click="handleDeleteButton(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--添加面板-->
    <el-dialog title="添加" :visible.sync="addDialog" width="33%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="账号">
          <el-input v-model="form.username" maxlength="18" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAddButtonSubmit">确定</el-button>
          <el-button @click="handleAddButtonCancel">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--授权面板-->
    <el-dialog title="授权" :visible.sync="updateDialog" width="33%">
      <el-tree
        :data="roles"
        :props="{label: 'name'}"
        :default-checked-keys="userRoles"
        ref="tree"
        show-checkbox
        node-key="id"
        @check="handleCheck">
      </el-tree>
    </el-dialog>
  </div>
</template>

<script>

import {getUsers, addUser, updateUser, deleteUser} from '@/api/user'

import {getRoles} from '@/api/role'

import {getUserRoles, addUserRole, deleteUserRole} from '@/api/userRole'

export default {
  data() {
    return {
      params: {},
      tableData: [],
      form: {},
      roles: [],
      userId:null,
      userRoles: [],
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
      this.getRoles()
    },
    getTableData() {
      getUsers(this.params).then(data => {
        this.tableData = data
      })
    },
    getRoles() {
      getRoles({}).then(data => {
        this.roles = data
      })
    },
    getUserRoles(userId) {
      getUserRoles({userId}).then(data => {
        if (!data) this.userRoles=[]
        this.userRoles = data.map(item => {
          return item.roleId
        })
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
      addUser(this.form).then(() => {
        this.$message.success('添加成功')
        this.getTableData()
        this.addDialog = false
      })
    },
    handleAddButtonCancel() {
      this.addDialog = false
    },
    handleRoleButton(userId) {
      this.getUserRoles(userId)
      this.userId=userId
      this.updateDialog = true
    },
    handleDeleteButton(id) {
      deleteUser(id).then(() => {
        this.$message.success('删除成功')
        this.getTableData()
      })
    },
    handleCheck(data,tree){
      console.log(this.$refs.tree.getCurrentKey())
    },

  }
}
</script>

<style scoped>

</style>
