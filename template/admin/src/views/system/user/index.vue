<template>
  <div>
    <!--过滤-->
    <el-form :inline="true" :model="params" class="demo-form-inline">
      <el-form-item label="账号">
        <el-input v-model="params.username" placeholder="账号" maxlength="18" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="params.userInfo.name" placeholder="姓名" maxlength="16" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="角色">
        <el-select v-model="params.role.id">
          <el-option v-for="role in roles" :label="role.name" :value="role.id"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="flushList">查询|刷新</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="insertDialog=true">添加</el-button>
      </el-form-item>
    </el-form>
    <!--添加面板-->
    <el-dialog title="添加" :visible.sync="insertDialog" width="40%">
      <el-form ref="form" :model="insertForm" label-width="80px">
        <el-form-item label="角色">
          <el-checkbox v-for="role in roles" v-model="role.checked" :label="role.name"
                       @change="insertForm.roles = roles.filter(item=> item.checked)"
          >
          </el-checkbox>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="insertForm.userInfo.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="insertForm.userInfo.idNumbers" maxlength="18" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="insertForm.userInfo.phoneNumbers" maxlength="11" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="insertUser">确定</el-button>
          <el-button @click="insertDialog = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--表格-->
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column label="序号" type="index" width="50"></el-table-column>
      <el-table-column label="账号" prop="username"></el-table-column>
      <el-table-column label="角色">
        <template slot-scope="scope">
          <el-tag v-for="role in scope.row.roles">{{ role.name }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="状态">
        <template slot-scope="scope">
          <el-tooltip :content="scope.row.state===1?'启用':'未启用'" placement="top">
            <el-switch
              v-model="scope.row.state"
              @change="updateState(scope.row)"
              active-color="#13ce66"
              inactive-color="#ff4949"
              :active-value="1"
              :inactive-value="0">
            </el-switch>
          </el-tooltip>
        </template>
      </el-table-column>
      <el-table-column label="姓名" prop="userInfo.name"></el-table-column>
      <el-table-column label="身份证" prop="userInfo.idNumbers"></el-table-column>
      <el-table-column label="手机" prop="userInfo.phoneNumbers"></el-table-column>
      <el-table-column label="创建时间" prop="createTime"></el-table-column>
      <el-table-column label="更新时间" prop="updateTime"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="small" @click="editItem(scope.row)">编辑</el-button>
          <el-button type="danger" size="small" @click="deleteUser(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--编辑面板-->
    <el-dialog title="编辑" :visible.sync="updateDialog" width="40%">
      <el-form ref="form" :model="updateForm" label-width="80px">
        <el-form-item label="角色">
          <el-checkbox v-for="role in roles" v-model="role.checked" :label="role.name"
                       @change="handleCheckBoxChange"
          >
          </el-checkbox>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="updateForm.userInfo.name" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="updateForm.userInfo.idNumbers" maxlength="18" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="updateForm.userInfo.phoneNumbers" maxlength="11" show-word-limit></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateUser">确定</el-button>
          <el-button @click="updateDialog=false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { getRoles } from '@/api/role'
import { deleteUser, getUsers, insertUser, updateUser } from '@/api/user'

export default {
  data() {
    return {
      params: {
        username: '',
        userInfo: {
          name: ''
        },
        role: {
          id: ''
        }
      },
      roles: [],
      tableData: [],
      insertForm: {
        userInfo: {
          name: '',
          idNumbers: '',
          phoneNumbers: ''
        },
        roles: []
      },
      insertDialog: false,
      updateForm: {
        id: null,
        username: '',
        userInfo: {
          name: '',
          idNumbers: '',
          phoneNumbers: ''
        },
        roles: []
      },
      updateDialog: false
    }
  },
  computed: {
    isChecked(role) {
      return
    }
  },
  mounted() {
    this.initData()
  },
  methods: {
    initData() {
      this.getRoles()
      this.getUsers()
    },
    flushList() {
      this.getUsers()
      this.$message.success('数据已刷新')
    },
    getUsers() {
      getUsers(this.params).then(data => {
        this.tableData = data
      })
    },
    getRoles() {
      getRoles(this.params.role).then(data => {
        this.roles = data
      })
    },
    insertUser() {
      insertUser(this.insertForm).then(() => {
        this.$message.success('添加成功')
        this.insertDialog = false
        this.getUsers()
      })
    },
    editItem(item) {

      this.updateDialog = true
      this.updateForm = item
    },
    updateUser() {
      updateUser(this.updateForm).then(() => {
        this.$message.success('修改成功')
        this.updateDialog = false
      })
    },
    deleteUser(id) {
      deleteUser(id).then(() => {
        this.$message.success('删除成功')
        this.getUsers()
      })
    },
    updateState(item){
      updateUser(item).then(()=>{
        this.getUsers()
      })
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {
        })
    },
    handleCheckBoxChange() {
      this.insertForm.roles = this.roles.filter(item => {
        return item.checked
      })
    }
  }
}
</script>

<style scoped>

</style>
