<template>
  <div>
    <el-form :inline="true" :model="params" class="demo-form-inline">
      <el-form-item>
        <el-button type="primary" @click="getItems">刷新</el-button>
      </el-form-item>
      <el-form-item label="角色">
        <el-input v-model="params.name" placeholder="角色"></el-input>
      </el-form-item>
      <el-form-item label="标识符">
        <el-input v-model="params.code" placeholder="标识符"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="filterList">过滤</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="success">添加</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="searchList" border style="width: 100%">
      <el-table-column label="序号" type="index" width="100px"></el-table-column>

      <el-table-column v-for="(item) of propertyList" :prop="item.prop" :label="item.label"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="editItem(scope.row)">编辑</el-button>
          <el-dialog title="编辑" :visible.sync="dialogVisible" width="30%">
            <el-form ref="form" :model="item" label-width="80px">
              <el-form-item label="id">
                <el-input v-model="item.id" disabled></el-input>
              </el-form-item>
              <el-form-item label="角色">
                <el-input v-model="item.name"></el-input>
              </el-form-item>
              <el-form-item label="标识符">
                <el-input v-model="item.code"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="editItem">确定</el-button>
                <el-button @click="dialogVisible = false">取消</el-button>
              </el-form-item>
            </el-form>
          </el-dialog>
          <el-button size="mini" type="danger" @click="deleteItem(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>

export default {
  data() {
    return {
      propertyList: [
        {
          prop: 'name',
          label: '角色'
        },
        {
          prop: 'code',
          label: '标识符'
        }
      ],
      params: {
        name: null,
        code: null
      },
      searchList: JSON.parse(localStorage.getItem('tempRoles')),
      list: [],
      dialogVisible: false,
      item: {}
    }
  },
  mounted() {
    this.getItems()
  },
  methods: {
    getItems() {

    },
    filterList() {

    },
    editItem(item) {

    },
    deleteItem(item) {

    }
  }
}
</script>

<style scoped>

</style>
