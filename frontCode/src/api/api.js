import axios from 'axios'
import qs from 'qs'//axios参数包
axios.defaults.baseURL="http://localhost:8888";
export const requestLogin=params=>{//箭头函数，此时params为参数
  return axios.post('/user/login',qs.stringify(params))//获取参数
    .then(res=>res.data)

 };
// // Vue.prototype.$http=axios
//
// export const requestLogin = params =>{
//   return axios.post('/user/login',qs.stringify(params))
//     .then(res => res.data)
//
// }
