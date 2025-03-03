import { createApp } from 'vue'
import Antd, {notification} from 'ant-design-vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'ant-design-vue/dist/reset.css'
import * as Icons from '@ant-design/icons-vue'
import axios from 'axios'
import './assets/js/enums'

const app = createApp(App)
app.use(Antd).use(store).use(router).mount('#app')

// 全局使用图标
const icons = Icons
for (const icon in icons) {
    app.component(icon, icons[icon])
}

/**
 * axios拦截器
 */
axios.interceptors.request.use((config) => {
    console.log('请求参数：', config);
    const _token = store.state.member.token;
    if (_token) {
        config.headers.token = _token;
        console.log('request headers增加token', _token);
    }
    return config;
}, error => {
    return Promise.reject(error);
})
axios.interceptors.response.use((response) => {
    console.log('返回结果：', response.data);
    return response;
}, error => {
    console.log('返回错误：', error);
    const response = error.response;
    const status = response.status;
    if (status === 401) {
        // 判断状态码是401，跳转到登陆页面
        console.log("未登录或超时登录，跳转到登录页");
        store.commit("setMember", {});
        notification.error({ description: "未登录或登录超时" });
        router.push('/login');
    }
    return Promise.reject(error);
})
axios.defaults.baseURL = process.env.VUE_APP_SERVER;
console.log('environment:', process.env.NODE_ENV);
console.log('server:', process.env.VUE_APP_SERVER);