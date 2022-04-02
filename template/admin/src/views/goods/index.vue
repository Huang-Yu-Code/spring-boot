<template>
  <div>
    <div>
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="formInline.user" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="formInline.type" placeholder="类型"></el-input>
        </el-form-item>
        <el-form-item label="仓库">
          <el-input v-model="formInline.warehouse" placeholder="仓库"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="success">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary">刷新</el-button>
        </el-form-item>
      </el-form>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column label="序号" type="index" width="100px"></el-table-column>
        <el-table-column label="名称" prop="name"></el-table-column>
        <el-table-column label="类型" prop="type"></el-table-column>
        <el-table-column label="数量" prop="numbers"></el-table-column>
        <el-table-column label="仓库" prop="warehouse"></el-table-column>
      </el-table>
    </div>
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
    this.tableData = localStorage.getItem()
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
      formInline:{},
      tableData: JSON.parse(localStorage.getItem('tempGoods')),
    }
  },
  computed: {},
  watch: {},
  methods: {},
}
</script>

<style scoped>

</style>
