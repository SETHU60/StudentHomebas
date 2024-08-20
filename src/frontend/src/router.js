// // src/router/index.js
// import { createRouter, createWebHistory } from 'vue-router';
// import AdminDashboard from '@/components/AdminDashboard.vue';
// import StudentList from '@/components/StudentList.vue'; // Import the existing component
//
// const routes = [
//     { path: '/', component: AdminDashboard },
//     { path: '/students', component: StudentList }, // Add this route
//     // Add other routes here
// ];
//
// const router = createRouter({
//     history: createWebHistory(),
//     routes,
// });
//
// export default router;

import { createRouter, createWebHistory } from 'vue-router';
import RegisterProperty from '@/components/RegisterProperty.vue';
import AdminDashboard from "@/components/AdminDashboard.vue";
import StudentList from "@/components/StudentList.vue";
import LandlordList from "@/components/LandlordList.vue";
import Communication from "@/components/Communication.vue";
// Import other components here

const routes = [
    {
        path: '/register-property',
        name: 'RegisterProperty',
        component: RegisterProperty
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
        name: 'CommunicationManagement',
        component: Communication,
    }

    // Define other routes here
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router;