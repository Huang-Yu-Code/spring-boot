<template>
  <div id="websocket">
    <el-button @click="connect">默认按钮</el-button>
  </div>
</template>

<script>
import SockJS from 'sockjs-client'
import {Stomp} from '@stomp/stompjs'

export default {
  data() {
    return {
      stompClient: null,
    }
  },
  beforeMount() {

  },
  methods: {
    connect() {
      const sock = new SockJS('http://localhost:8080/websocket')
      this.stompClient = Stomp.over(sock)
      this.stompClient.subscribe('/topic/response', () => {

      })

    },
    disconnect() {
      if (this.stompClient !== null) {
        this.stompClient.disconnect();
      }
    },
    sendMessage(message) {

    },
  }
}
</script>

<style scoped>

</style>
