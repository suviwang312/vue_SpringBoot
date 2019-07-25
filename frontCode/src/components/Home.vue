<template>
  <div>

    <el-row :gutter="20">
      <el-col :span="12"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="4" :offset="8"><div class="grid-content bg-purple" style=" box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)"><p style="font-family: 'Helvetica Neue';font-size: 1.8rem ;margin-top: auto"><i class="el-icon-edit"></i>用户列表信息</p></div></el-col>

      <!--搜索部分，包含input框输入内容，查询按钮，新增按钮-->
      <el-col :span="8" :offset="3" class="toolbar" style="padding-bottom :0;">
        <el-form :isline="true" :model="filters">
          <el-form-item style="width: 60%;float: left;margin-right: 10px">
            <el-input v-model="filters.cUsername" placeholder="根据姓名查询"></el-input>
          </el-form-item>
          <el-form-item style="width: 10%;float: left;margin-right: 30px">
            <el-button type="primary" v-on:click="getUsers">查询</el-button>
          </el-form-item>
          <el-form-item style="width: 10%;float: left">
            <el-button type="success" v-on:click="addUser">新增</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>




    <!--table表单，展示用户信息还有对用户进行相关操作-->
    <!--slice((currentPage-1)*pagesize,currentPage*pagesize)分页操作-->
    <el-col :span="18" :offset="3" class="toolbar" style="padding-bottom :0;">
      <el-table :data="userList.slice((currentPage-1)*pagesize,currentPage*pagesize)" border style="width: 100%;margin-bottom: 50px" >
        <el-table-column fixed prop="cId" label="ID" width="200"></el-table-column>
        <el-table-column prop="cUsername" label="姓名" width="220"></el-table-column>
        <el-table-column prop="cPwd" label="密码" width="220"></el-table-column>

        <el-table-column fixed="right" label="操作" width="440">
          <template v-slot="scope">
            <el-button @click="handleClick(scope.row)" type="primary" size="small" style="float: left">查看</el-button>
            <el-button type="success" size="small" @click="handleEdit(scope.row)" style="float: left">编辑</el-button>
            <!--<el-button type="text" size="small" @click="dialogFormVisible = true">编辑</el-button>-->
            <el-button type="info" size="small" @click="deleteUser(scope.row)" style="float: left">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
    <!--:page-sizes="[5, 10, 20, 40]" //这是下拉框可以选择的，每选择一行，要展示多少内容-->
    <!--:page-size="pagesize"         //显示当前行的条数-->
    <!--layout="total, sizes, prev, pager, next, jumper"-->
    <!--:total="userList.length">    //这是显示总共有多少数据，-->

    <!--//这是下拉框可以选择的，每选择一行，要展示多少内容-->
    <!--//显示当前行的条数-->
    <!--//这是显示总共有多少数据，-->
    <el-col :span="6" :offset="12" class="toolbar" style="padding-bottom :0;">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20, 40]"
        :page-size="pagesize"
        background
        layout="total, sizes, prev, pager, next, jumper"
        :total="userList.length">
      </el-pagination>
    </el-col>

    <!--增加用户的模态框-->
    <el-dialog title="新增用户" :visible.sync="dialogVisible"
               :close-on-click-modal="false">
      <el-form :model="addFormData" :rules="rules2" ref="addFormData" class="demo-rulesForm">

        <el-form-item label="姓名" :label-width="formLabelWidth" prop="cUsername">
          <el-input v-model="addFormData.cUsername" autocomplete="off" style="width: 48%">{{addFormData.cUsern}}
          </el-input>
        </el-form-item>

        <el-form-item label="密码" :label-width="formLabelWidth" prop="cPwd">
          <el-input v-model="addFormData.cPwd" autocomplete="off" style="width: 48%">{{addFormData.cPwd}}</el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click.native="addSubmit">确 定</el-button>
      </div>
    </el-dialog>


    <!--查看用户的模态框-->
    <el-dialog title="查看用户" :visible.sync="dialogVisible2"
               :close-on-click-modal="false">
      <el-form :model="addFormData" :rules="rules2" ref="addFormData" class="demo-rulesForm">

        <el-form-item label="姓名" :label-width="formLabelWidth" prop="cUsername" style="font-size: 1.5rem">
          <span v-model="addFormData.cUsername" autocomplete="off" style="width: 48%;font-size: 1.5rem">{{addFormData.cUsername}}</span>
        </el-form-item>

        <el-form-item label="密码" :label-width="formLabelWidth" prop="cPwd" style="font-size: 1.5rem">
          <span v-model="addFormData.cPwd" autocomplete="off"
                style="width: 48%;font-size: 1.5rem">{{addFormData.cPwd}}</span>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="dialogVisible2 = false">取 消</el-button>
        <el-button type="primary" @click.native="dialogVisible2 = false">确 定</el-button>
      </div>
    </el-dialog>


    <!--修改用户的模态框-->
    <el-dialog title="更改用户" :visible.sync="editUserDig"
               :close-on-click-modal="false">
      <el-form :model="editUserDate" :rules="rules2" ref="editUserDate" class="demo-rulesForm">

        <el-form-item label="姓名" :label-width="formLabelWidth" prop="cUsername">
          <el-input v-model="editUserDate.cUsername" autocomplete="off" style="width: 48%">{{editUserDate.cUsern}}
          </el-input>
        </el-form-item>

        <el-form-item label="密码" :label-width="formLabelWidth" prop="cPwd">
          <el-input v-model="editUserDate.cPwd" autocomplete="off" style="width: 48%">{{editUserDate.cPwd}}</el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="editUserDig = false">取 消</el-button>
        <el-button type="primary" @click.native="editSubmitBtn">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  //导入api和axios
  import {userList} from "@/api/api";
  import axios from 'axios'
  import qs from 'qs'
  //axios参数包
  export default {
    name: 'Home',
    props: {},
    data() {
      return {
        userList: [],
        currentPage: 1, //初始页
        pagesize: 10,    //    每页的数据

        dialogVisible: false,
        dialogVisible2: false,
        dialogVisible_del: false,
        editUserDig: false,
        addFormData: {
          cId: '',
          cUsername: '',
          cPwd: ''
        },
        editUserDate: {
          cUsername: "",
          cPwd: ""
        },
        formLabelWidth: '120px',
        value1: '',

        rules2: {
          cUsername: [
            {required: true, message: '用户名不为空', trigger: 'blur'},
            {min: 2, max: 8, message: '长度在 2 到 8 个字符', trigger: 'blur'}
          ],
          cPwd: [
            {required: true, message: '密码不为空', trigger: 'blur'},
            {min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur'}
          ],
        },
        filters: {
          cUsername: ''
        }
      }
    },
    // computed: {
    //
    // },

    mounted: function () {
      this.load();
    },
    methods: {
      load() {
        let param = {cUsername: this.filters.cUsername};
        axios.get('/user/getUserList', qs.stringify(param))
          .then((result) => {
            console.log(result.length)
            var list = result.data.rows;
            this.userList = list;
            console.log(list);

          })
      },

      //分页
      handleSizeChange: function (size) {
        this.pagesize = size;
        console.log(this.pagesize)  //每页下拉显示数据
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage;
        console.log(this.currentPage)  //点击第几页
      },

      //根据用户名查找用户
      getUsers() {
        // this.load();

        var vm = this;
        axios.get('/user/getUserList?cUsername=' + this.filters.cUsername)
          .then(res => {
              //this.tableData=res.data
              console.log(res);

              var list1 = res.data.rows;
              this.userList = list1;

              // 将数据的长度赋值给totalCount

            }
          );
        this.searchName = ''
      },
      //增加新用户
      addUser() {
        //
        this.addFormData = {
          cId: '',
          cUsername: '',
          cPwd: ''
        };
        this.dialogVisible = true;
      },
      //查看用户的相关信息，并弹出模态块展现用户信息
      handleClick(userData) {
        this.addFormData = Object.assign({}, userData);

        this.dialogVisible2 = true;
      },
      //编辑用户信息，并弹出模态块
      modifyUser(userData) {
        this.addFormData = Object.assign({}, userData);

        this.dialogVisible = true;

      },
      //删除用户
      deleteUser(userData) {

        var params = {cId: userData.cId};
        this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {

          axios.post("/user/delete", qs.stringify(params))
            .then((result) => {
              console.log(result);
              if (result.data.code == 200) {
                this.$message({
                  type: 'success',
                  message: '操作成功'

                });
                this.load();
              } else {
                console.log(result);
                this.$message({
                  type: 'info',
                  message: '操作失败'
                });
              }
            });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });

        //this.dialogVisible_del=true;
      },
      addSubmit() {
        this.$refs.addFormData.validate((valid) => {
          if (valid) {
            let param = Object.assign({}, this.addFormData);
            axios.post("/user/insertUser", qs.stringify(param))
              .then((result) => {
                console.log(result);
                if (result.data.code === 200) {
                  console.log(result.data.code);
                  this.$message({
                    type: 'success',
                    message: '操作成功'

                  });
                  this.load();
                } else {
                  this.$message({
                    type: 'info',
                    message: '操作失败'
                  });
                }
                this.dialogVisible = false;
                this.dialogVisible2 = false;
              })
          }
        })
      },

      //打开修改用户模态框
      // modifyUser(userData) {
      // this.addFormData = Object.assign({}, userData);

  // this.dialogVisible = true;

  // },
      handleEdit(userData) {
        this.editUserDate = Object.assign({}, userData);
        this.editUserDig = true;
      },
      //提交修改用户信息
      editSubmitBtn() {

        this.$refs.editUserDate.validate(valid => {
          if (valid) {
            let params = Object.assign({}, this.editUserDate);

            axios
              .post("user/updateUser", qs.stringify(params))
              .then(res => {
                console.log(res);
                if (res.data.code === 200) {
                  console.log(res.data);
                  // this.getDate();
                  this.$message({
                    showClose: true,
                    message: `提示：${res.data.msg}`,
                    type: "success"
                  });

                } else {
                  this.$message({
                    showClose: true,
                    message:`提示：${res.data.msg}`,
                    type: "error"
                  });
                }
                this.editUserDig = false;
              })
          } else {
            this.$message({
              type: "error",
              message: `提示: 您填写的信息有误`
            });
          }
        });
      }
    },


  }
</script>

<style scoped>

</style>
