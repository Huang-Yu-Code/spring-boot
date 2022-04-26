<template>
  <div id="home">
    <van-notice-bar left-icon="volume-o" mode="closeable" scrollable text="APP通知:应用将在2020-4-27号升级版本..."/>
    <van-swipe :autoplay="3000" class="my-swipe" indicator-color="white">
      <van-swipe-item>
        <img alt="" height="100" src="https://img01.yzcdn.cn/vant/apple-1.jpg" width="200"/>
      </van-swipe-item>
      <van-swipe-item>2</van-swipe-item>
      <van-swipe-item>3</van-swipe-item>
      <van-swipe-item>4</van-swipe-item>
    </van-swipe>
    <van-grid :column-num="4" clickable>
      <van-grid-item :icon="require('@/assets/shop.png')" text="商城" to="/shop"/>
      <van-grid-item :icon="require('@/assets/text.png')" text="文章" to="/text"/>
      <van-grid-item :icon="require('@/assets/music.png')" text="音乐" to="/music"/>
      <van-grid-item :icon="require('@/assets/video.png')" text="电影" to="/video"/>
      <van-grid-item :icon="require('@/assets/live.png')" text="直播" to="/live"/>
      <van-grid-item :icon="require('@/assets/wechat.png')" text="仿微信" to="/music"/>
      <van-grid-item :icon="require('@/assets/vip.png')" text="会员" to="/vip"/>

      <van-grid-item icon="home-o" text="毕业设计" to="/"/>
      <van-grid-item icon="home-o" text="毕业设计" to="/"/>
    </van-grid>
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

</style>
