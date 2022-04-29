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
        xAxis: {
          data: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
        },
        yAxis: {},
        series: [
          {
            type: 'scatter',
            data: [220, 182, 191, 234, 290, 330, 310]
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
