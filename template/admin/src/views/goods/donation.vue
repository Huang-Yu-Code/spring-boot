<template>
  <div>
    <el-card class="box-card">
      <el-select v-model="form.warehouseId" placeholder="请选择仓库">
        <el-option
          v-for="item in warehouses"
          :key="item.id"
          :label="item.name"
          :value="item.id">
        </el-option>
      </el-select>
      <el-form ref="form" :model="form" label-width="80px" v-for="(item,index) in form.goods">
        <el-form-item label="名称">
          <el-input v-model="item.name"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="item.type"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input-number v-model="item.numbers" :min="1" :max="100" label="描述文字"></el-input-number>
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
import { getWarehouses } from '@/api/warehouse'
import { insertDonation } from '@/api/donation'

export default {
  props: {},
  mounted() {
    this.initData()
  },
  data() {
    return {
      warehouses: [],
      form: {
        warehouseId: '',
        goods: [{
          name: '',
          type: '',
          numbers: '',
        }]
      },
    }
  },
  computed: {},
  watch: {},
  methods: {
    initData() {
      this.getWarehouses()
    },
    getWarehouses() {
      getWarehouses().then(data => {
        this.warehouses = data
      })
    },
    addGoods() {
      this.form.goods.push(
        {
          name: '',
          type: '',
          numbers: '',
        }
      )
    },
    deleteGoods(index) {
      if (this.form.goods.length !== 1) {
        this.form.goods.splice(index, 1)
      }
    },
    onSubmit() {
      insertDonation(this.form).then(()=>{
        this.$message.success("捐赠成功,请等待仓库管理审核")
        this.$router.push('/goods/donation-log')
      })
    }
  }
}
</script>

<style scoped>
.box-card {
  width: 30%;
  margin-left: 30%;
}
</style>
