<template>
  <div>
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
    <el-dialog :visible.sync="roleDialog" title="授权" width="33%" @closed="handleClose">
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

import {addUserRole, deleteUserRole, getUserRoles} from '@/api/userRole'

export default {
  data() {
    return {
      tableData: [],
      form: {},
      roles: [],
      userId: null,
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
      getUsers().then(data => {
        this.tableData = data
      })
    },
    getRoles() {
      getRoles({}).then(data => {
        this.roles = data
      })
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
      getUserRoles({userId: item.id}).then(data => {
        this.$refs.tree.setCheckedKeys(data.map(role => {
          return role.id
        }), false)
      })
      this.roleDialog = true
    },
    handleClose(){
      this.$refs.tree.setCheckedKeys([],false)
    },
    handleCheck(data) {
      const node = this.$refs.tree.getNode(data)
      if (node.checked) {
        addUserRole({userId: this.userId, roleId: data.id}).then(() => {
          this.$message.success('授权成功')
        }).catch(() => {
          node.setChecked(false)
        })
      } else {
        deleteUserRole({userId: this.userId, roleId: data.id}).then(() => {
          this.$message.success('撤销授权')
        }).catch(() => {
          node.setChecked(true)
        })
      }
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
