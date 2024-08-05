import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import axios from 'axios'
// 统一导入el-icon图标
import * as ElIconModules from '@element-plus/icons-vue'
import router  from "./router/index"

const app = createApp(App)

app.config.productionTip = false
app.config.globalProperties.$axios = axios

for (let iconName in ElIconModules) {
    app.component(iconName, ElIconModules[iconName])
}

app.use(router)
app.use(ElementPlus)
app.mount('#app')
