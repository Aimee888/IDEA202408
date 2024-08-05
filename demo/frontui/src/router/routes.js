import LoginPage from '@/views/LoginPage.vue'
import JumpTest from '@/views/JumpTest.vue'

const routes = [
    {
        name: 'LoginPage',
        path: '/',
        component: LoginPage
    },
    {
        name: 'JumpTest',
        path: '/JumpTest',
        component: JumpTest
    }
];
export default routes
