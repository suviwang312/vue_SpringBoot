<template>
  <div>
    <div>
      <img src="../assets/logo.png" style="margin-left: -49px">
    </div>

    <el-col :span="9" :offset="5">
    <el-form :model="account" label-width="100px" class="demo-ruleForm loginContainer"
    label-position="left"  :rules="rules" ref="AccountForm">
      <h3 style="margin-left: 20%">登录</h3>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="account.username"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pwd" >
        <el-input v-model="account.pwd" auto-complete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-checkbox label="记住密码" v-model="checked" style="float: right"></el-checkbox>
      </el-form-item>
      <el-form-item size="large" >
        <el-button type="primary" @click.native.prevent="handleLogin" style="width: 100%;">登录</el-button>
      </el-form-item>
    </el-form>
    </el-col>
  </div>
</template>

<script>
  import  {requestLogin} from "@/api/api";

  export default {
        name: 'Login',
        props: {},
        components: {},
        data() {
            return {
              account:{
                username:'admin',
                pwd:'admin',
              },
              checked:true,
              rules: {
                username: [
                  { required: true, message: '请输入用户名', trigger: 'blur' },
                  { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                ],
                pwd: [
                  { required: true, message: '请输入密码', trigger: 'blur' },
                  { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                ],
              }
            }
        },
        computed: {

        },
        watch: {

        },

        methods: {

          //对用户身份进行验证，成功跳转到home.vue
          handleLogin:function(){
            this.$refs.AccountForm.validate((valid) => {
              // alert("hello")
                if(valid){//校验成功//validate校验成功
                  let params ={
                    cUsername:this.account.username,
                    cPwd:this.account.pwd
                  };
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
                        type:'error',

                      })
                    }
                  });
                }else{//校验失败
                  return false;
                }
              }
            );
          }
        },
    }
</script>

<style scoped>
  body{
    background-color: #dfe9fb;
  }
  .loginContainer{
    width: 350px;
    margin-left: 35%;
  }
</style>
