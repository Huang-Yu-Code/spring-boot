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
          type: 'category',
          data: ['A', 'B', 'C']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [120, 200, 150],
            type: 'line'
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
