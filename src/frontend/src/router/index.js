import { createRouter, createWebHistory } from 'vue-router';
import RegisterProperty from '../components/RegisterProperty.vue';
// Import other components here

const routes = [
    {
        path: '/register-property',
        name: 'RegisterProperty',
        component: RegisterProperty
    },

    // Define other routes here
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router;