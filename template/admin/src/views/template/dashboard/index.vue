<template>
  <div>
    <el-row>
      <el-col v-for="item in elements" :span="12">
        <div :id="item" style="width:100%;height:400px;"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  data() {
    return {
      elements: [
        'day',
        'week',
        "month",
        'year',
        'line'
      ],
      options: [
        {
          title: {
            text: '日访问量'
          },
          tooltip: {},
          legend: {
            data: ['访问人数']
          },
          xAxis: {
            name: '时间',
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
          },
          yAxis: {
            name: '访问人数',
            type: 'value'
          },
          series: [
            {
              name: '访问人数',
              type: 'bar',
              data: [5, 20, 36, 10, 10, 20, 30]
            }
          ]
        },
        {
          title: {
            text: '周访问量'
          },
          tooltip: {},
          legend: {
            data: ['访问人数']
          },
          xAxis: {
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
          },
          yAxis: {},
          series: [
            {
              name: '访问人数',
              type: 'bar',
              data: [5, 20, 36, 10, 10, 20, 30]
            }
          ]
        },
        {
          title: {
            text: '月访问量'
          },
          tooltip: {},
          legend: {
            data: ['访问人数']
          },
          xAxis: {
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
          },
          yAxis: {},
          series: [
            {
              name: '访问人数',
              type: 'bar',
              data: [5, 20, 36, 10, 10, 20, 30]
            }
          ]
        },
        {
          title: {
            text: '年访问量'
          },
          tooltip: {},
          legend: {
            data: ['访问人数']
          },
          xAxis: {
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
          },
          yAxis: {},
          series: [
            {
              name: '访问人数',
              type: 'bar',
              data: [5, 20, 36, 10, 10, 20, 30]
            }
          ]
        },
        {
          title: {
            text: '访问人数趋势'
          },
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
      ],
    }
  },
  mounted() {
    this.initialization()
  },
  methods: {
    initialization() {
      this.elements.forEach((item, index) => {
        echarts.init(document.getElementById(item)).setOption(this.options[index])
      })
    }
  }
}
</script>

<style scoped>

</style>
