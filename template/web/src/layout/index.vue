<template>
  <el-container>
    <el-header>Header</el-header>
    <el-main>
      <router-view/>
    </el-main>
    <el-footer>Footer</el-footer>
  </el-container>
</template>

<script>
export default {
  props: {},
  data() {
    return {}
  },
  computed: {},
  watch: {},
  beforeCreate() {
  },
  created() {
  },
  beforeMount() {
  },
  mounted() {
    this.initialization()
  },
  beforeUpdate() {
  },
  updated() {
  },
  beforeDestroy() {
  },
  destroyed() {
  },
  methods: {
    initialization() {
      console.log('初始化')
    },
  },
}
</script>

<style scoped>

.el-header, .el-footer {
  background-color: #B3C0D1;
  text-align: center;
  line-height: 60px;
}

.el-main {
  background-color: #E9EEF3;
  display: flex;
  flex-direction: column;
  height: 100%;
}
</style>
