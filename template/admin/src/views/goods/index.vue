<template>
  <div>
    <!--过滤|添加-->
    <el-form :inline="true" :model="params" class="demo-form-inline">
      <el-form-item label="名称">
        <el-input v-model="params.name" placeholder="名称" maxlength="16" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="类型">
        <el-input v-model="params.type" placeholder="类型" maxlength="16" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="仓库">
        <el-select v-model="params.warehouseId" placeholder="请选择">
          <el-option
            v-for="item in warehouses"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="flushList">刷新</el-button>
      </el-form-item>
    </el-form>
    <!--表格-->
    <el-table :data="list" border style="width: 100%">
      <el-table-column label="序号" type="index" width="100px"></el-table-column>
      <el-table-column label="名称" prop="name"></el-table-column>
      <el-table-column label="类型" prop="type"></el-table-column>
      <el-table-column label="数量" prop="numbers"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getGoods } from '@/api/goods'
import { getWarehouses } from '@/api/warehouse'

export default {
  data() {
    return {
      list: [],
      warehouses: [],
      params: {
        name: '',
        type: '',
        warehouseId: '',
        state: 1
      },
    }
  },
  computed: {},
  watch: {},
  mounted() {
    this.initData()
  },
  methods: {
    initData() {
      this.getWarehouses()
      this.getGoods()
    },
    flushList() {
      this.getWarehouses()
      this.getGoods()
      this.$message.success('数据已刷新')
    },
    getGoods() {
      getGoods(this.params).then(data => {
        this.list = data
      })
    },
    getWarehouses() {
      getWarehouses().then(data => {
        this.warehouses = data
      })
    },
  }
}
</script>

<style scoped>

</style>
