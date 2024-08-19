<template>
  <div class="layout">
    <el-container class="container">
      <el-aside class="aside">
        <div class="head">
          <div>
            <svg-icon icon-class="heart_icon" style="fill: red" />
            <span>憨梅小屋</span>
            <svg-icon icon-class="heart_icon" style="fill: red" />
          </div>
        </div>
        <div class="line" />
        <el-menu
            text-color="#337ab7"
            active-text-color="white"
            :router="true"
            :unique-opened="true"
            :default-openeds="state.defaultOpen"
            :default-active='state.currentPath'
        >
          <el-sub-menu index="1">
            <template #title>
              <span>统计模块</span>
            </template>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <span>记账模块</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/IndexPage/PaidPage">支出管理</el-menu-item>
              <el-menu-item index="/IndexPage/EarnPage">收入管理</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-container class="content">
        <HeaderPage />
        <div class="main">
          <router-view />
        </div>
        <FooterPage />
      </el-container>
    </el-container>
  </div>
</template>

<script setup>
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import HeaderPage from "@/views/HeaderPage.vue"
import FooterPage from "@/views/FooterPage.vue"

const noMenu = ['/LoginPage']
const router = useRouter()
const state = reactive({
  showMenu: true,
  defaultOpen: [],
  currentPath: '/IndexPage/PaidPage',
})

router.afterEach((to) => {
  state.showMenu = !noMenu.includes(to.path)
})

router.beforeEach((to) => {
  state.currentPath = to.path
  // document.title = to.name
})
</script>

<style scoped>
.layout {
  min-height: 100vh;
  background-color: #ffffff;
}
.container {
  height: 100vh;
}
.aside {
  width: 220px!important;
}
.head {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  background: linear-gradient(-280deg,#006dcc 0%,#ffffff 100%);
}
.head > div {
  display: flex;
  align-items: center;
}

.head img {
  width: 50px;
  height: 50px;
  margin-right: 10px;
}
.head span {
  font-size: 20px;
  color: black;
}
.line {
  border-top: 1px solid hsla(0,0%,100%,.05);
  border-bottom: 1px solid rgba(0,0,0,.2);
}
.content {
  display: flex;
  flex-direction: column;
  max-height: 100vh;
  overflow: hidden;
  background-color: #f0f0f0;
}
.main {
  height: calc(100vh - 100px);
  overflow: auto;
  padding: 10px;
}
</style>

<style>
body {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.el-menu {
  border-right: none!important;
}
.el-submenu {
  border-top: 1px solid hsla(0, 0%, 100%, .05);
  border-bottom: 1px solid rgba(0, 0, 0, .2);
}
.el-submenu__title {
  font-size: 16px;
}
.el-menu-item.is-active {
  background-color: #87CEFA;
  span {
    color: white;
  }
}

.el-submenu [class^="el-icon-"] {
  vertical-align: -1px!important;
}
a {
  color: #409eff;
  text-decoration: none;
}
.el-pagination {
  text-align: center;
  margin-top: 20px;
}
.el-popper__arrow {
  display: none;
}
</style>
