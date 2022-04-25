<template>
  <div>
    <van-nav-bar
        fixed
        left-arrow
        left-text="首页"
        placeholder
        safe-area-inset-top
        title="404,你的页面走丢了"
        @click-left="this.handleGoHome"/>
  </div>
</template>

<script>
export default {
  computed: {
    message() {
      return 'The webmaster said that you can not enter this page...'
    }
  },
  methods: {
    handleGoHome() {
      this.$router.push('/home')
    }
  }
}
</script>

<style scoped>

</style>
