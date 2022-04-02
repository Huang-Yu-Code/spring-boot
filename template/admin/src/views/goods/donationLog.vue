<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="序号" type="index" width="50px"></el-table-column>
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="审核状态" prop="state"></el-table-column>
      <el-table-column label="时间" prop="time"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-popover
            placement="top"
            trigger="click">
            <el-table :data="scope.row.goods">
              <el-table-column property="name" label="名称"></el-table-column>
              <el-table-column property="type" label="类型"></el-table-column>
              <el-table-column property="numbers" label="数量"></el-table-column>
              <el-table-column property="warehouse" label="仓库"></el-table-column>
            </el-table>
            <el-button type="success" size="small" slot="reference">详情</el-button>
          </el-popover>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  props: {},
  beforeCreate() {
  },
  created() {
  },
  beforeMount() {
  },
  mounted() {
  },
  beforeUpdate() {
  },
  updated() {
  },
  beforeDestroy() {
  },
  destroyed() {
  },
  data() {
    return {
      tableData: [
        {
          id: 1,
          name: '系统管理员',
          state: '审核通过',
          goods: [
            {
              id:1,
              name: '口罩',
              type: '防护用品',
              numbers: 100,
              warehouse: '1号仓库'
            }
          ],
          time: '2022-03-28 00:00:00'
        },
      ]
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {
        })
    }

  }
}
</script>

<style scoped>

</style>
