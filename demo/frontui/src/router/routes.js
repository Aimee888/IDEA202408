import LoginPage from '@/views/LoginPage.vue'
import HomePage from "@/views/HomePage.vue";
import AboutPage from "@/views/AboutPage.vue";
import JumpPage from "@/views/JumpPage.vue";

const routes = [
    {
        name: 'LoginPage',
        path: '/',
        component: LoginPage
    },
    {
        name: '/JumpPage',
        path: '/JumpPage',
        redirect: '/JumpPage/HomePage',
        component: JumpPage,
        children: [
            {path: '/JumpPage/HomePage', name: 'HomePage', component: HomePage},
            {path: '/JumpPage/AboutPage', name: 'AboutPage', component: AboutPage}
        ]
    }
];
export default routes
