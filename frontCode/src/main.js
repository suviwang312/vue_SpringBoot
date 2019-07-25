// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'// (根据版本路径不同会有差异，按照自己版本路径)
Vue.use(ElementUI);

import axios from 'axios'
Vue.prototype.$http=axios;


Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  meta: {
    needLogin: true //需要加校检判断的路由
  },

});
