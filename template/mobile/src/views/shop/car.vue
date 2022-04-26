<template>
<div id="car">
  <van-nav-bar fixed placeholder safe-area-inset-top title="购物车"/>
  <van-card
      v-for="item in 10"
      num="2"
      tag="标签"
      price="2.00"
      desc="描述信息"
      title="商品标题"
      thumb="https://img01.yzcdn.cn/vant/ipad.jpeg"
      origin-price="10.00"/>
</div>
</template>

<script>
export default {}
</script>

<style scoped>

</style>
