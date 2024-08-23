import { createRouter, createWebHistory } from 'vue-router';
import RegisterProperty from '@/components/RegisterProperty.vue';
import AdminDashboard from "@/components/AdminDashboard.vue";
import StudentList from "@/components/StudentList.vue";
import LandlordList from "@/components/LandlordList.vue";
import Communication from "@/components/Communication.vue";
import AdminLayout from "@/components/AdminLayout.vue";

import HomePage from "@/views/HomePage.vue";
import PropertyInfoPage from "@/views/PropertyInfoPage.vue";
import LoginPage from "@/components/LoginPage.vue";

const routes = [
     { path: '/loginPage', name: 'LoginPage', component: LoginPage },
    { path: '/', name: 'HomePage', component: HomePage },
    { path: '/propertyInfo', name: 'PropertyInfoPage', component: PropertyInfoPage },

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
