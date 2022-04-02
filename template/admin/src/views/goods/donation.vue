<template>
  <div>
    <el-card class="box-card">
      <el-select v-model="form.warehouse" placeholder="请选择仓库">
        <el-option label="1号仓库" value="shanghai"></el-option>
      </el-select>
      <el-form ref="form" :model="form" label-width="80px" v-for="(item,index) in form.list">
        <el-form-item label="名称">
          <el-input v-model="item.name"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="item.type"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="item.numbers"  :min="1" :max="100" label="描述文字"></el-input-number>
        </el-form-item>
        <el-form-item label="备注">
          <el-input v-model="item.remarks"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="addGoods">继续添加</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="danger" @click="deleteGoods(index)">删除</el-button>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="onSubmit">立即捐赠</el-button>
    </el-card>
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
      form: {
        warehouse: '',
        list: [{
          name: '',
          type: '',
          numbers: '',
          remarks: ''
        }],
      },
      formInline:{},
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
.box-card {
  width: 30%;
  margin-left: 30%;
}
</style>
