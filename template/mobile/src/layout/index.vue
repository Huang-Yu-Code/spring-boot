<template>
  <div id="layout">
    <router-view/>
    <van-tabbar placeholder route safe-area-inset-bottom>
      <van-tabbar-item :icon="require('@/assets/home.png')" replace to="/home">首页</van-tabbar-item>
      <van-tabbar-item :icon="require('@/assets/category.png')" replace to="/category">分类</van-tabbar-item>
      <van-tabbar-item :icon="require('@/assets/car.png')" replace to="/car">购物车</van-tabbar-item>
      <van-tabbar-item :icon="require('@/assets/personal.png')" badge="10" replace to="/personal">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
export default {
  name: "index"
}
</script>

<style scoped>

</style>
