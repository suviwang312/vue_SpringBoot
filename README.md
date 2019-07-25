# vue_SpringBoot
使用vue和ElementUI搭建前台，SpringBoot搭建后台，完成基本数据的增删改查

## 前台
- 在main.js引入elementUI组件
```
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'/
```
- 在main.js引入axios实现跨域
```
import axios from 'axios'
Vue.prototype.$http=axios;
```

- axios要实现和SpringBoot交互
新建api文件夹 创建api.js
```
import axios from 'axios'
import qs from 'qs'//axios参数包
axios.defaults.baseURL="http://localhost:8888";
export const requestLogin=params=>{//箭头函数，此时params为参数
return axios.post('/user/login',qs.stringify(params))//获取参数
    .then(res=>res.data)
 };
```
- Vue路由守卫，未登录时跳转到登录界面，已登录跳转到主页
在路由配置中添加守卫 router-index.js
```
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
```
### Login.vue
- form表单绑定 :model="account"
给用户的用户名和密码添加属性
```
prop="username"
<el-form-item label="用户名" prop="username">

```
- 登录时判断是否登录，登录跳转，并保存在sessionStorage中

  sessionStorage.setItem('access-token',data.token);
```
 requestLogin(params).then(data=>{
        console.log(data);
         let vm = this;
         if(data.code === 200){
          sessionStorage.setItem('access-token',data.token);
          // localStorage.setItem("token", this.account.username);
          vm.$router.push({path:'/home'});

          }else{
           this.$message({
           message:data.msg,
           ype:'error',

           })
     }
```

### Home.vue
主页面
- 导包
```
//导入api和axios
  import {userList} from "@/api/api";
  import axios from 'axios'
  import qs from 'qs'
```
- 页眉 设置搜索用户和新增用户
- form表单展示用户列表
- 对用户的操作有查询，编辑，删除。其中查询和编辑设置模态框
- 方法对应的功能：
```
1.getUsers——查询
2.addUser——新增——addSubmit-新增中的确认按钮
3.handleClick——查看用户的相关信息，并弹出模态块展现用户信息
4.deleteUser——删除用户
5.handleEdit——修改用户——editSubmitBtn修改中的确认按钮
```

- 搜索表单绑定 :model="filters"
- 展示用户列表的表单绑定数据:data="userList"
- 分页操作 el-pagination
- 模态框 :visible.sync="dialogVisible"
- 新增的模态框绑定:model="addFormData"

- 查看用户的模态框绑定:visible.sync="dialogVisible2"
- 查看表单的绑定:model="addFormData"

- 修改用户的模态框 :visible.sync="editUserDig"
- 修改用户的表单绑定 :model="editUserDate"

<hr>

## 后台
- SpringBoot和mybatis，Maven搭建
- src文件夹下application.yml配置 连接数据库
```

mybatis:
    config-location: classpath:mybatis/mybatis.cfg.xml
    mapper-locations: classpath:mybatis/mapper/*.xml
    type-aliases-package: com.neu.vo
server:
    port: 8888
spring:
    application:
        name:sm
    datasource:
        driver-class-name: com.mysql.jdbc.Driver
        password:
        url: jdbc:mysql://127.0.0.1:3306/empdb?characterEncoding=utf8&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        username: root
logging:
  level:
    com.neu.dao : debug
```

- 对数据库操作

src文件夹->resources->mybatis->mapper->UserDAO.xml

- 测试 （可用PostMan对接口进行测试）

src/test/java中UserControllerTest.java对接口进行测试

- com.neu.vo->UserVO 实体bean
- com.neu.service -> UserService接口，UserServiceImpl接口的实现   ....业务逻辑层
- com.neu.controller->UserController 控制层
- com.neu下的APP.java进行测试该服务是否启动



