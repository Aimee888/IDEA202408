<!--/src/views/home.vue-->
<template><h1>Home Page</h1>
  <p> {{ pageData }} </p></template>
<script>
export default {
  data () {
    return {
      // 数据绑定对象
      pageData: 'Welcome to home page'
    }
  }
}

</script>
