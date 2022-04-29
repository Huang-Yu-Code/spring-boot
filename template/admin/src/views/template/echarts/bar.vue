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
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {},
        series: [
          {
            type: 'bar',
            data: [23, 24, 18, 25, 27, 28, 25]
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
