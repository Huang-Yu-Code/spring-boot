<template>
  <div>
    <div>
      <el-form :inline="true" :model="params" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="params.name" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item label="仓库地址">
          <el-input v-model="params.address" placeholder="仓库地址"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getWarehouses">查询|刷新</el-button>
        </el-form-item>
      </el-form>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column label="序号" type="index" width="100px"></el-table-column>
        <el-table-column label="名称" prop="name"></el-table-column>
        <el-table-column label="仓库地址" prop="address"></el-table-column>
        <el-table-column label="管理员" prop="userInfo.name"></el-table-column>
        <el-table-column label="联系方式" prop="userInfo.phoneNumbers"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { getWarehouses } from '@/api/warehouse'

export default {
  props: {},
  data() {
    return {
      params:{},
      tableData: [],
    }
  },
  computed: {},
  watch: {},
  methods: {
    initData(){
      this.getWarehouses()
    },
    getWarehouses(){
      getWarehouses(this.params).then(data=>{
        this.tableData = data
      })
    }
  },
  mounted() {
    this.initData()
  },
}
</script>

<style scoped>

</style>
