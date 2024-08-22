
import  {createRouter,createWebHistory} from 'vue-router';
import HomePage from './views/HomePage.vue';
import PropertyDetails from './views/PropertyDetails.vue';
import Contact from './views/ContactPage.vue';
import PropertyInfoPage from "@/views/PropertyInfoPage.vue";


const routes = [
    { path: '/', component: HomePage },
    { path: '/property/:id', component: PropertyDetails },
    { path: '/contact', component: Contact },
    { path: '/propertyInfo', component: PropertyInfoPage },


];

const router = createRouter({    history: createWebHistory(),
    routes,

});

export default router;
