import { createRouter, createWebHistory } from 'vue-router';
import RegisterProperty from '../components/RegisterProperty.vue';
import SignupPage from "@/components/LandlordLogin.vue"; // Ensure this path is correct
import LoginPage from "@/components/LoginPage.vue";

const routes = [
    {
        path: '/register-property',
        name: 'RegisterProperty',
        component: RegisterProperty
    },
    {
        path:'/signupPage',
        name: 'SignupPage',
        component: SignupPage
    },
    {
        path:'/loginPage',
        name: 'LoginPage',
        component: LoginPage
    }
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router;
