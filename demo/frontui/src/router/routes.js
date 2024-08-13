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
        redirect: '/HomePage',
        component: JumpPage,
        children: [
            {path: '/HomePage', name: 'HomePage', component: HomePage},
            {path: '/AboutPage', name: 'AboutPage', component: AboutPage}
        ]
    }
];
export default routes
