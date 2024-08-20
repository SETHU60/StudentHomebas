<template>
  <div id="app">
    <Layout>
      <router-view></router-view>
    </Layout>
  </div>
</template>

<script >
import Layout from "@/components/AdminLayout.vue";

export default {
  name: 'App',
  components: {
    Layout
  }
}
</script>