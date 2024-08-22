
import App from './App.vue';
import router from './router';
import {createApp} from "vue";
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import {faHeart, faHome, faUsers, faBed, faRestroom,faWifi  } from '@fortawesome/free-solid-svg-icons'
const app = createApp(App);
library.add(faHeart, faHome, faUsers, faBed, faRestroom ,faWifi)
app.use(router);
app.component('font-awesome-icon', FontAwesomeIcon).mount('#app')