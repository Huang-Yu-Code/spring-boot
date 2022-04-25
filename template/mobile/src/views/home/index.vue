<template>
  <div id="home">
    <van-notice-bar left-icon="volume-o" mode="closeable" scrollable text="通知...................."/>
    <van-swipe :autoplay="3000" class="my-swipe" indicator-color="white">
      <van-swipe-item>
        <img alt="" height="100" src="https://img01.yzcdn.cn/vant/apple-1.jpg" width="200"/>
      </van-swipe-item>
      <van-swipe-item>2</van-swipe-item>
      <van-swipe-item>3</van-swipe-item>
      <van-swipe-item>4</van-swipe-item>
    </van-swipe>
    <van-grid :column-num="4" clickable>
      <van-grid-item icon="home-o" text="路由跳转" to="/"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
      <van-grid-item icon="search" text="URL 跳转" url="/vant/mobile.html"/>
    </van-grid>
    <van-tabs v-model="active">
      <van-tab title="标签 1">内容 1</van-tab>
      <van-tab title="标签 2">内容 2</van-tab>
      <van-tab title="标签 3">内容 3</van-tab>
      <van-tab title="标签 4">内容 4</van-tab>
    </van-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      active: 2,
    }
  }
}
</script>

<style scoped>
.my-swipe .van-swipe-item {
  font-size: 20px;
  line-height: 150px;
  text-align: center;
}
</style>
