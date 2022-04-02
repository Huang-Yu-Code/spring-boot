<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>个人信息</span>
      </div>
      <div class="text item">
        <el-avatar :src="userInfo.image"></el-avatar>
      </div>
      <div class="text item">
        {{'姓名：'+userInfo.name}}
      </div>
      <div class="text item">
        {{'身份证号：'+userInfo.idNumbers}}
      </div>
      <div class="text item">
        {{'手机号：'+userInfo.phoneNumbers  }}
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  props: {},
  beforeCreate() {
  },
  created() {
  },
  beforeMount() {
    const data = this.$store.dispatch('user/getInfo')
    console.log(data)
    this.userInfo = data
  },
  mounted() {
  },
  beforeUpdate() {
  },
  updated() {
  },
  beforeDestroy() {
  },
  destroyed() {
  },
  data() {
    return {
      userInfo: {}
    }
  },
  computed: {},
  watch: {},
  methods: {},
}
</script>

<style scoped>

</style>
