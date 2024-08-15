// import {createRouter, createWebHistory} from 'vue-router'
import {createRouter, createWebHashHistory} from 'vue-router'
import routes from './routes'    // 导入 router 目录下的 router.js

// const router = createRouter({
//     history: createWebHistory(process.env.BASE_URL),
//     routes
// })
const router = createRouter({
    history: createWebHashHistory(),
    routes
})
export default router
