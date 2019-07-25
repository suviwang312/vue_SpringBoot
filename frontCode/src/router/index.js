import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Home from '@/components/Home'

Vue.use(Router);

const router =  new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      meta: {
        requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
      },
    },
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
  ]
});

//Vue路由守卫，未登录时跳转到登录界面，已登录跳转到主页
// 对每次访问之前都有先看是否已经登录
router.beforeEach((to,from,next)=>{
  if (to.path.startsWith('/login')){
    window.sessionStorage.removeItem('access-token');
    next();
  } else {
    let token = window.sessionStorage.getItem('access-token');
    if (!token){
      //未登录跳回主页
      next({path:'/login'});
    } else {
      next();
    }
  }
});

export  default router;
