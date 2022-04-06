<template>
  <div>
    <!--过滤|添加-->
    <el-form :inline="true" :model="params" class="demo-form-inline">
      <el-form-item label="名称">
        <el-input v-model="params.name" placeholder="名称" maxlength="16" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="params.address" placeholder="地址" maxlength="255" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="管理员">
        <el-select v-model="params.userId" placeholder="请选择">
          <el-option
            v-for="item in users"
            :key="item.id"
            :label="item.userInfo.name"
            :value="item.id">
          </el-option>
        </el-select>
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
        <el-form-item label="名称">
          <el-input v-model="insertForm.name" placeholder="名称" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="insertForm.address" placeholder="地址" maxlength="255" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="管理员">
          <el-select v-model="insertForm.userId" placeholder="请选择">
            <el-option
              v-for="item in users"
              :key="item.id"
              :label="item.userInfo.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="insertWarehouse">确定</el-button>
          <el-button @click="insertDialog = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--表格-->
    <el-table :data="tableList" border style="width: 100%">
      <el-table-column label="序号" type="index" width="100px"></el-table-column>
      <el-table-column label="名称" prop="name"></el-table-column>
      <el-table-column label="管理员" prop="userInfo.name"></el-table-column>
      <el-table-column label="地址" prop="address"></el-table-column>
      <el-table-column label="状态" prop="state"></el-table-column>
      <el-table-column label="创建时间" prop="createTime"></el-table-column>
      <el-table-column label="更新时间" prop="updateTime"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="editItem(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteWarehouse(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--编辑面板-->
    <el-dialog title="编辑" :visible.sync="updateDialog" width="30%">
      <el-form ref="form" :model="updateForm" label-width="80px">
        <el-form-item label="名称">
          <el-input v-model="updateForm.name" placeholder="名称" maxlength="16" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="updateForm.address" placeholder="地址" maxlength="255" show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="管理员">
          <el-select v-model="updateForm.userId" placeholder="请选择">
            <el-option
              v-for="item in users"
              :key="item.id"
              :label="item.userInfo.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateWarehouse">确定</el-button>
          <el-button @click="updateDialog = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { getUsers } from '@/api/user'
import { getWarehouses, insertWarehouse, updateWarehouse, deleteWarehouse } from '@/api/warehouse'

export default {
  data() {
    return {
      users: [],
      params: {
        name: '',
        userId: '',
        address: '',
        state: ''
      },
      tableList: [],
      insertForm: {
        name: '',
        userId: '',
        address: ''
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
      this.getUsers()
      this.getWarehouses()
    },
    flushList() {
      this.getWarehouses()
      this.getUsers()
      this.$message.success('数据已刷新')
    },
    getUsers() {
      getUsers().then(data => {
        this.users = data
      })
    },
    getWarehouses() {
      getWarehouses(this.params).then(data => {
        this.tableList = data
      })
    },
    insertWarehouse() {
      insertWarehouse(this.insertForm).then(() => {
        this.$message.success('添加成功')
        this.insertDialog = false
        this.getWarehouses()
        this.insertForm = {
          name: '',
          code: ''
        }
      })
    },
    editItem(item) {
      this.updateDialog = true
      this.updateForm = item
    },
    updateWarehouse() {
      updateWarehouse(this.updateForm).then(() => {
        this.$message.success('修改成功')
        this.updateDialog = false
        this.getWarehouses()
      })
    },
    deleteWarehouse(id) {
      deleteWarehouse(id).then(() => {
        this.$message.success('删除成功')
        this.getWarehouses()
      })
    }
  }
}
</script>

<style scoped>

</style>
