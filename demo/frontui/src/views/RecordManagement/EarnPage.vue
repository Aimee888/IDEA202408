<!--/src/views/home.vue-->
<template>
  <h1>About Page</h1>
  <p> {{ pageData }} </p></template>
<script>
export default {
  data () {
    return {
      // 数据绑定对象
      pageData: 'Welcome to About page'
    }
  }
}

</script>
