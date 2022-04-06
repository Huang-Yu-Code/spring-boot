<template>
  <div>
    <el-row>
      <el-form :inline="true" :model="params" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="params.name" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="params.type" placeholder="类型"></el-input>
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
          <el-button type="success" size="small" @click="getGoods">查询</el-button>
        </el-form-item>
      </el-form>
      <el-col :span="12">
        <el-table
          :data="tableData"
          style="width: 100%">
          <el-table-column label="库存防疫物品">
            <el-table-column
              prop="name"
              label="名称">
            </el-table-column>
            <el-table-column
              prop="type"
              label="类型">
            </el-table-column>
            <el-table-column
              prop="numbers"
              label="数量">
            </el-table-column>
            <el-table-column
              label="操作">
              <template slot-scope="scope">
                <el-button type="success" size="small" @click="addGoods(scope.row)">添加</el-button>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="12">
        <el-table
          :data="form.goods"
          style="width: 100%">
          <el-table-column label="申请防疫物品">
            <el-table-column
              prop="name"
              label="名称">
            </el-table-column>
            <el-table-column
              prop="type"
              label="类型">
            </el-table-column>
            <el-table-column
              label="数量">
              <template slot-scope="scope">
                <el-input-number v-model="scope.row.numbers" :min="1" :max="scope.row.numbers" label="描述文字"></el-input-number>
              </template>
            </el-table-column>
            <el-table-column
              label="操作">
              <template slot="header" slot-scope="scope">
                <el-button type="success" size="small" @click="insertApply">立即申请</el-button>
              </template>
              <template slot-scope="scope">
                <el-button type="danger" size="small" @click="deleteGoods(scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getWarehouses } from '@/api/warehouse'
import { getGoods } from '@/api/goods'
import { insertApply } from '@/api/apply'

export default {
  props: {},
  data() {
    return {
      params: {},
      warehouses: [],
      tableData: [],
      form: {
        warehouseId:'',
        goods:[]
      },
    }
  },
  computed: {},
  watch: {},
  methods: {
    initData() {
      this.getWarehouses()
      this.getGoods()
    },
    getWarehouses() {
      getWarehouses().then(data => {
        this.warehouses = data
        this.form.warehouseId=data[0].id
        this.params.warehouseId=this.warehouses[0].id
      })
    },
    getGoods() {
      getGoods(this.params).then(data => {
        this.tableData = data
      })
    },
    addGoods(item) {
      this.form.goods.push(item)
      this.tableData.splice(this.tableData.indexOf(item),1)
    },
    deleteGoods(item) {
      this.form.goods.splice(item.index, 1)
      this.tableData.push(item)
    },
    insertApply() {
      insertApply(this.form).then(()=>{
        this.$message.success('申请成功,请等待仓库管理员审核')
        this.$router.push('/goods/apply-log')
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
