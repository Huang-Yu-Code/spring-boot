<template>
  <div id="layout">
    <router-view/>
    <van-tabbar placeholder route safe-area-inset-bottom>
      <van-tabbar-item :icon="require('@/assets/shop/home.png')" replace to="/shop/index">微信</van-tabbar-item>
      <van-tabbar-item :icon="require('@/assets/shop/category.png')" replace to="/shop/category">通讯录</van-tabbar-item>
      <van-tabbar-item :icon="require('@/assets/shop/car.png')" badge="10" replace to="/shop/car">发现</van-tabbar-item>
      <van-tabbar-item :icon="require('@/assets/shop/personal.png')" badge="10" replace to="/shop/personal">我</van-tabbar-item>
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
