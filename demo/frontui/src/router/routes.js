import LoginPage from '@/views/LoginPage.vue'
import PaidPage from "@/views/RecordManagement/PaidPage.vue";
import EarnPage from "@/views/RecordManagement/EarnPage.vue";
import IndexPage from "@/views/IndexPage.vue";

const routes = [
    {
        name: 'LoginPage',
        path: '/',
        component: LoginPage
    },
    {
        name: '/IndexPage',
        path: '/IndexPage',
        redirect: '/IndexPage/PaidPage',
        component: IndexPage,
        children: [
            {path: '/IndexPage/PaidPage', name: 'PaidPage', component: PaidPage},
            {path: '/IndexPage/EarnPage', name: 'EarnPage', component: EarnPage}
        ]
    }
];
export default routes
