<template>
  <div>
    <el-tree
      ref="tree"
      :data="roles"
      :props="props"
      node-key="id"
      show-checkbox
      @check="handleCheck">
    </el-tree>
  </div>
</template>

<script>
import {getRoles} from '@/api/role'

export default {
  data() {
    return {
      roles: [],
      hasRoles: [],
      props: {
        label: 'name',
      },
    }
  },
  computed: {},

  mounted() {
    this.initialization()
  },
  methods: {
    initialization() {
      this.getRoles()
    },
    getRoles() {
      getRoles().then(data => {
        this.roles = data
      })
    },
    handleCheck(data) {
      console.log(this.$refs.tree.getNode(data).checked)
    }
  }
}
</script>

<style scoped>

</style>
