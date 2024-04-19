import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'bootstrap/dist/js/bootstrap.bundle'
import 'bootstrap/dist/css/bootstrap.min.css'
// TODO: bootstartp vue3 import
import BootstrapVue3 from "bootstrap-vue-3";
// TODO: bootstartp vue3 css import
import "bootstrap-vue-3/dist/bootstrap-vue-3.css";
createApp(App).use(BootstrapVue3).use(store).use(router).mount('#app')