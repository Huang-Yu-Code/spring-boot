<template>

</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      roles: [],
      form: {
        name: '',
        username: '',
        password: '',
        roles: []
      },
      formInline: {
        user: null
      },
      tableData: JSON.parse(localStorage.getItem('tempUsers'))
    }
  },
  mounted() {
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {
        })
    }

  }
}
</script>

<style scoped>

</style>
