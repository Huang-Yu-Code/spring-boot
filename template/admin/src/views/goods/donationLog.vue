<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="序号" type="index" width="50px"></el-table-column>
      <el-table-column label="姓名" prop="userInfo.name"></el-table-column>
      <el-table-column label="手机" prop="userInfo.phoneNumbers"></el-table-column>
      <el-table-column label="审核状态" prop="state">
        <template slot-scope="scope">
          <el-switch
            disabled
            v-model="scope.row.state===1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="捐赠时间" prop="createTime"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-popover
            placement="top"
            trigger="click">
            <el-table :data="scope.row.goods">
              <el-table-column property="name" label="名称"></el-table-column>
              <el-table-column property="type" label="类型"></el-table-column>
              <el-table-column property="numbers" label="数量"></el-table-column>
            </el-table>
            <el-button type="success" size="small" slot="reference">详情</el-button>
          </el-popover>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getDonations } from '@/api/donation'

export default {
  props: {},
  mounted() {
    this.initData()
  },
  data() {
    return {
      tableData: []
    }
  },
  methods: {
    initData() {
      this.getDonations()
    },
    getDonations() {
      getDonations().then(data => {
        this.tableData = data
      })
    },
  }
}
</script>

<style scoped>

</style>
