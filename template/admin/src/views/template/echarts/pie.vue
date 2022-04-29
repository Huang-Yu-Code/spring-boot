<template>
  <div>
    <div :id="id" style="width:100%;height:400px;"></div>
  </div>
</template>

<script>

import * as echarts from 'echarts'

export default {
  data() {
    return {
      id: 'main',
      options: {
        series: [
          {
            type: 'pie',
            data: [
              {
                value: 335,
                name: '直接访问'
              },
              {
                value: 234,
                name: '联盟广告'
              },
              {
                value: 1548,
                name: '搜索引擎'
              }
            ]
          }
        ]
      }
    }
  },
  mounted() {
    echarts.init(document.getElementById(this.id)).setOption(this.options)
  },
  methods: {}
}
</script>

<style scoped>

</style>
