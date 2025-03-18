<template>
  <el-tree :data="menus" :props="defaultProps" :expand-on-click-node="false" show-checkbox node-key="catId">
    <span class="custom-tree-node" slot-scope="{ node, data }">
      <span>{{ node.label }}</span>
      <span>
        <el-button v-if="node.level <= 2" type="text" size="mini" @click="() => append(data)">
          Append
        </el-button>
        <el-button v-if="node.childNodes.length === 0" type="text" size="mini" @click="() => remove(node, data)">
          Delete
        </el-button>
      </span>
    </span>
  </el-tree>
</template>

<script>
export default {
  data() {
    return {
      menus: [],
      defaultProps: {
        children: 'children',
        label: 'name'
      }
    }
  },
  methods: {
    // 获取数据列表
    getMenus() {
      this.$http({
        url: this.$http.adornUrl('/product/category/list/tree'),
        method: 'get'
      }).then(({ data }) => {
        console.log('成功获取了数据', data.data)
        this.menus = data.data
      })
    },
    handleNodeClick(data) {
      console.log(data)
    },
    append(data) {
      console.log("append", data)
    },

    remove(node, data) {
      var ids = [data.catId]
      this.$http({
        url: this.$http.adornUrl('product/category/delete'),
        method: 'post',
        data: this.$http.adornData(data, false)
      }).then(({ data }) => { 
        console.log("删除成功",node,data)
      });
    }
  },
  created() {
    this.getMenus()
  }
}
</script>
