<template>
  <div>
    <el-row>
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="formInline.user" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="formInline.user" placeholder="类型"></el-input>
        </el-form-item>
        <el-form-item label="仓库">
          <el-input v-model="formInline.user" placeholder="仓库"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="success" size="small">查询</el-button>
          <el-button type="primary" size="small">刷新</el-button>
        </el-form-item>
      </el-form>
      <el-col :span="12">
        <el-table
          :data="tableData1"
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
              prop="warehouse"
              label="仓库">
            </el-table-column>
            <el-table-column
              label="操作">
              <template slot-scope="scope">
                <el-button type="success" size="small">添加</el-button>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="12">
        <el-table
          :data="tableData2"
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
                <el-input v-model="scope.row.numbers" placeholder="请输入数量"></el-input>
              </template>
            </el-table-column>
            <el-table-column
              label="操作">
              <template slot="header" slot-scope="scope">
                <el-button type="success" size="small">立即申请</el-button>
              </template>
              <template slot-scope="scope">
                <el-button type="danger" size="small">删除</el-button>
              </template>
            </el-table-column>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
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
      tableData1: JSON.parse(localStorage.getItem('tempGoods')),
      tableData2: [],
      form: {
        warehouse: '',
        list: [{
          name: '',
          type: '',
          numbers: '',
          remarks: ''
        }],
      },
      formInline: {},
      tableData: [],
    }
  },
  computed: {},
  watch: {},
  methods: {
    addGoods() {
      this.form.list.push(
        {
          name: '',
          type: '',
          numbers: '',
          remarks: ''
        }
      )
    },
    deleteGoods(index) {
      if (this.form.list.length !== 1) {
        this.form.list.splice(index, 1)
      }
    },
    onSubmit() {
      this.$message.success('捐赠成功,请等待仓库管理员审核')
      this.$router.push('/goods/donation-log')
    }
  },
}
</script>

<style scoped>

</style>
