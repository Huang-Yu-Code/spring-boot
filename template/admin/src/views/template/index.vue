<template>
  <div>
    <el-tree
      ref="tree"
      :data="roles"
      :props="{label:'name'}"
      check-on-click-node
      empty-text="暂无数据"
      node-key="id"
      show-checkbox
      @check="handleCheck">
    </el-tree>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userRoles: [],
      roles: [{id: 1, name: '选项1'}, {id: 2, name: '选项2'}],
    };
  },
  mounted() {
    this.$refs.tree.setCheckedKeys(this.userRoles, false)
  },
  methods: {
    handleCheck(data) {
      let checked = this.$refs.tree.getNode(data).checked
      let roleId = data.id
      if (checked) {
        console.log('add')
      } else {
        console.log('del')
      }
    },
  }
}
</script>

<style scoped>

</style>
