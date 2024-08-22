import { createRouter, createWebHistory } from 'vue-router';
import RegisterProperty from '@/components/RegisterProperty.vue';
import AdminDashboard from "@/components/AdminDashboard.vue";
import StudentList from "@/components/StudentList.vue";
import LandlordList from "@/components/LandlordList.vue";
import Communication from "@/components/Communication.vue";
import AdminLayout from "@/components/AdminLayout.vue";
import LoginPage from "@/components/LoginPage.vue";

const routes = [
    { path: '/', name: 'LoginPage', component: LoginPage },
    {
        path: '/register-property',
        name: 'RegisterProperty',
        component: RegisterProperty
    },
    {
        path: '/admin-layout',
        name: 'AdminLayout',
        component: AdminLayout,
        children: [
            {
                path: '',
                name: 'AdminDashboard',
                component: AdminDashboard
            },
            {
                path: '/admin-dashboard',
                name: 'AdminDashboard',
                component: AdminDashboard
            },
            {
                path: '/students',
                name: 'StudentList',
                component: StudentList,
            },
            {
                path: '/landlords',
                name: 'LandlordList',
                component: LandlordList,
            },
            {
                path: '/communication',
                name: 'Communication',
                component: Communication,
            }
        ]
    }
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router;
