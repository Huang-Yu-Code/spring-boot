<template>
  <div>
    <div>
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="名称">
          <el-input v-model="formInline.user" placeholder="名称"></el-input>
        </el-form-item>
        <el-form-item label="仓库地址">
          <el-input v-model="formInline.address" placeholder="仓库地址"></el-input>
        </el-form-item>
        <el-form-item label="仓库管理员">
          <el-input v-model="formInline.manager" placeholder="仓库管理员"></el-input>
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
        <el-table-column label="仓库地址" prop="address"></el-table-column>
        <el-table-column label="管理员" prop="manager"></el-table-column>
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
      tableData: [
        {
          id:1,
          name:'1号仓库',
          address:'中国',
          manager:'系统管理员',
        }
      ],
    }
  },
  computed: {},
  watch: {},
  methods: {},
}
</script>

<style scoped>

</style>
