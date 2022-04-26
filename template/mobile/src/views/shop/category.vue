<template>
  <div>
    <van-sticky>
      <van-search v-model="value" placeholder="请输入搜索关键词"/>
    </van-sticky>
    <van-card v-for="item in 10"
              desc="描述信息"
              num="2"
              origin-price="10.00"
              price="2.00"
              tag="热销中"
              thumb="https://img01.yzcdn.cn/vant/ipad.jpeg"
              title="商品标题"/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: '',
      activeKey: 0,
      container: null,
    }
  },
  mounted() {
    this.container = this.$refs.container;
  },
}
</script>

<style scoped>

</style>
