<template>
  <div id="layout">
    <el-container>
      <el-header>
        <el-row :gutter="20">
          <el-col :span="8">
            <el-link :underline="false" icon="el-icon-platform-eleme" type="primary" href="/" style="font-size: 30px;color: black">Vue2.x-web模板</el-link>
          </el-col>
          <el-col :span="2">
            <el-link :underline="false" href="/">首页</el-link>
          </el-col>
          <el-col :span="2">
            <el-link :underline="false" href="#1" disabled>导航1</el-link>
          </el-col>
          <el-col :span="2">
            <el-link :underline="false" href="#2">导航2</el-link>
          </el-col>
          <el-col :span="2">
            <el-link :underline="false" href="#3">导航3</el-link>
          </el-col>
          <el-col :span="2">
            <el-link :underline="false" href="#4">导航4</el-link>
          </el-col>
          <el-col :span="2">
            <el-link :underline="false" href="#5">导航5</el-link>
          </el-col>
          <el-col :span="2" :offset="2">
            <el-link :underline="false" icon="el-icon-user-solid" type="danger" href="/login">登录|注册</el-link>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <el-breadcrumb separator="">
          <el-breadcrumb-item>当前位置:</el-breadcrumb-item>
          <el-breadcrumb-item><b>{{ $route.meta.title }}</b></el-breadcrumb-item>
        </el-breadcrumb>
        <el-divider></el-divider>
        <router-view/>
      </el-main>
      <el-footer>
        <div class="icons">
          <a href="https://github.com/baomidou" title="GitHub" target="_blank" class="iconfont icon-github"></a>
          <a href="https://gitee.com/baomidou" title="Gitee" target="_blank" class="iconfont icon-gitee"></a>
          <a href="mailto:koyangslash@gmail.com" title="发邮件" target="_blank" class="iconfont icon-youjian"></a>
        </div>
        Theme by
        <a href="https://github.com/xugaoyi/vuepress-theme-vdoing" target="_blank" title="本站主题">Vdoing</a>
        | Copyright © 2016-2022
        <span>
            <a href="https://baomidou.com" target="_blank" style="font-weight:bold">Team Baomidou</a> | Sponsored by
            <a href="https://www.jetbrains.com" target="_blank" style="font-weight:bold">JetBrains</a> |
            <a href="https://beian.miit.gov.cn/" target="_blank">备案号</a>
          </span>
      </el-footer>
    </el-container>
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
  beforeCreate() {
  },
  created() {
  },
  beforeMount() {
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
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
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

.el-header {
  background-color: #B3C0D1;
  color: #333;
  text-align: left;
  line-height: 60px;
}

.el-main {
  color: #333;
  text-align: center;
}

.el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}
</style>
