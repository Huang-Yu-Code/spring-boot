<template>
  <div>
    <el-carousel :interval="3000" type="card">
      <el-carousel-item v-for="src in srcList" :key="src">
        <el-image :src="src" :preview-src-list="srcList"></el-image>
      </el-carousel-item>
    </el-carousel>
    <div id="echarts" style="width:100%;height:376px;">

    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  props: {},
  data() {
    return {
      srcList: [
        'https://pakutaso.cdn.rabify.me/shared/img/thumb/RD2020322047.jpg.webp?d=350',
        'https://pakutaso.cdn.rabify.me/shared/img/thumb/098RED20404.jpg.webp?d=350',
        'https://pakutaso.cdn.rabify.me/shared/img/thumb/ameman81421005.jpg.webp?d=350',
        'https://pakutaso.cdn.rabify.me/shared/img/thumb/RS503DF027.jpg.webp?d=350',
      ]
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
    this.initData()
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
    initData() {
      const myChart = echarts.init(document.getElementById('echarts'));
      myChart.setOption({
        title: {
          text: 'ECharts 入门示例'
        },
        tooltip: {},
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [
          {
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
          }
        ]
      });
    }
  },
}
</script>

<style scoped>

</style>
