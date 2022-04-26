<template>
  <div id="home">
    <van-nav-bar fixed placeholder safe-area-inset-top title="商城"/>
    <van-notice-bar left-icon="volume-o" mode="closeable" scrollable text="商城通知：商城整改升级中...敬请期待！"/>
    <van-swipe :autoplay="3000" class="my-swipe" indicator-color="white">
      <van-swipe-item>
        <img alt="" height="100" src="https://img01.yzcdn.cn/vant/apple-1.jpg" width="200"/>
      </van-swipe-item>
      <van-swipe-item>2</van-swipe-item>
      <van-swipe-item>3</van-swipe-item>
      <van-swipe-item>4</van-swipe-item>
    </van-swipe>
    <van-tabs v-model="active">
      <van-tab title="推荐">
        <van-card
            v-for="item in 10"
            tag="推荐"
            price="2.00"
            desc="描述信息"
            title="商品标题"
            thumb="https://img01.yzcdn.cn/vant/ipad.jpeg"/>
      </van-tab>
      <van-tab title="新品">
        <van-card
            tag="新品"
            price="2.00"
            desc="描述信息"
            title="商品标题"
            thumb="https://img01.yzcdn.cn/vant/ipad.jpeg"/>
      </van-tab>
      <van-tab title="热销">
        <van-card
            tag="热销"
            price="2.00"
            desc="描述信息"
            title="商品标题"
            thumb="https://img01.yzcdn.cn/vant/ipad.jpeg"/>
      </van-tab>
      <van-tab title="特惠">
        <van-card
            tag="特惠"
            price="2.00"
            desc="描述信息"
            title="商品标题"
            thumb="https://img01.yzcdn.cn/vant/ipad.jpeg"
            origin-price="10.00"/>
      </van-tab>
    </van-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      active: 0,
    }
  }
}
</script>

<style scoped>

</style>
