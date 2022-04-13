<template>
  <div>
    <h1>欢迎来到{{title}}!</h1>
  </div>
</template>

<script>
import settings  from '@/settings'
export default {
  data(){
    return{
      title: settings.title
    }
  }
}
</script>

<style scoped>

</style>
