<template>
  <div id="layout">

  </div>
</template>

<script>
export default {
  props: {},
  data() {
    return {
      activeIndex: '1',
    }
  },
  computed: {},
  watch: {},
  mounted() {
    this.initData()
  },
  methods: {
   initData(){
     console.log('initData')
   }
  },
}
</script>

<style>
.el-container {
  display: flex;
  position: absolute;
  bottom: 0;
  top: 0;
  left: 0;
  right: 0;
  justify-content: center;
}
</style>
