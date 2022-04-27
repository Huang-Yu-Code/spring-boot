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
            <el-input v-model="params.username" maxlength="16" placeholder="账号" show-word-limit></el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-select v-model="params.state" placeholder="请选择账号状态">
              <el-option label="正常" value="1"></el-option>
              <el-option label="异常" value="0"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button size="small" type="primary" @click="handleSearchButton">查找</el-button>
          </el-form-item>
        </el-form>
      </el-collapse-item>
    </el-collapse>
    <!--表格-->
    <el-table :data="tableData" border highlight-current-row size="small" stripe style="width: 100%">
      <el-table-column align="center" label="序号" type="index" width="50"></el-table-column>
      <el-table-column align="center" label="账号" prop="username"></el-table-column>
      <el-table-column align="center" label="状态">
        <template slot-scope="scope">
          <el-tag :type="scope.row.state===1?'success':'danger'"><em
            :class="scope.row.state===1?'el-icon-success':'el-icon-error'"></em>{{
              scope.row.state === 1 ? '正常' : '异常'
            }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" label="创建时间" prop="createTime"></el-table-column>
      <el-table-column align="center" label="更新时间" prop="updateTime"></el-table-column>
      <el-table-column label="操作">
        <template slot="header" slot-scope="scope">
          <el-button size="small" type="success" @click="handleAddButton">添加</el-button>
        </template>
        <template slot-scope="scope">
          <el-button :type="scope.row.state === 1 ? 'info' : 'success'" size="mini"
                     @click="handleStateButton(scope.row)">{{
              scope.row.state === 1 ? '冻结' : '解冻'
            }}
          </el-button>
          <el-button size="mini" type="warning" @click="handleResetPasswordButton(scope.row)">重置密码</el-button>
          <el-button size="mini" type="primary" @click="handleRoleButton(scope.row)">授权</el-button>
          <el-button size="mini" type="danger" @click="handleDeleteButton(scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--添加面板-->
    <el-dialog :visible.sync="addDialog" title="添加" width="33%">
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
    <el-dialog :visible.sync="roleDialog" title="授权" width="33%">
      <el-tree
        ref="tree"
        :data="roles"
        :props="props"
        node-key="id"
        show-checkbox
        @check="handleCheck">
      </el-tree>
    </el-dialog>
  </div>
</template>

<script>

import {addUser, deleteUser, getUsers, updateUser} from '@/api/user'

import {getRoles} from '@/api/role'

import {addUserRole, getUserRoles} from '@/api/userRole'

export default {
  data() {
    return {
      params: {},
      tableData: [],
      form: {},
      roles: [],
      userId: null,
      userRoles: [],
      props: {
        label: 'name',
      },
      addDialog: false,
      roleDialog: false,
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
    getUserRoles() {
      getUserRoles({userId: this.userId}).then(data => {
        this.userRoles = data
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
    handleStateButton(item) {
      const id = item.id
      const state = item.state === 1 ? 0 : 1
      updateUser({id, state}).then(() => {
        this.$message.success('状态已更新')
        this.getTableData()
      })
    },
    handleResetPasswordButton(item) {
      updateUser({id: item.id, password: '123456'}).then(() => {
        this.$message.success('密码重置为:123456')
      })
    },
    handleRoleButton(item) {
      this.userId = item.id
      this.getUserRoles()
      this.roleDialog = true
    },
    handleCheck(data) {
      addUserRole({userId: this.userId, roleId: data.id}).then(() => {
        this.$message.success('授权成功')
      }).catch(() => {
        this.$refs.tree.getNode(data).setChecked(false)
      })
    },
    handleDeleteButton(item) {
      deleteUser(item.id).then(() => {
        this.$message.success('删除成功')
        this.getTableData()
      })
    },
  }
}
</script>

<style scoped>

</style>
