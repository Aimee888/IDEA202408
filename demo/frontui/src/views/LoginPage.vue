/* eslint-disable */
<template>
  <div class="login_container">
    <div class="login_box">
      <div class="wai">
        <!-- 头像区域 -->
        <div class="avatar_box">
          <img src="../assets/logo.png" alt="" />
        </div>
        <!-- 登录表单区域 -->
        <el-form
            ref="loginFormRef"
            :model="loginForm"
            :rules="loginFormRules"
            label-width="0px"
            class="login_form"
        >
          <!--        用户名-->
          <el-form-item prop="username">
            <label class="form-label">用户名</label>
            <el-input
                v-model="loginForm.username"
                prefix-icon="User"
            ></el-input>
          </el-form-item>
          <!--        密码-->
          <el-form-item prop="password">
            <label class="form-label">密码</label>
            <el-input
                v-model="loginForm.password"
                prefix-icon="Key"
                type="password"
            ></el-input>
          </el-form-item>
          <!--        按钮区域-->
          <el-form-item class="btns">
            <el-button type="primary" @click="Login">登录</el-button>
            <el-button type="info" @click="resetLoginForm">重置</el-button>
          </el-form-item>
          <div style="display:flex; justify-content:flex-start">{{loginForm.message}}</div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.login_container {
  background-color: darkcyan;
  height: 100%;
}

.login_box {
  width: 350px;
  height: 300px;
  background-color: white;
  border-radius: 15px;
  /*容器内居中*/
  position: absolute;
  left: 40%;
  top: 50%;
  transform: translate(-50%, -50%);

  .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    /*边框阴影*/
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;

    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #993d3d;
    }
  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }

  .btns {
    display: flex;
    justify-content: flex-end;
  }
  .wai {
    background-image: url("../assets/images/background.jpg");
    width: 577px;
    height: 300px;
    border-radius: 15px;
  }
}
</style>

<script>
import qs from 'qs'
import Global from '@/components/GlobalIp.vue'

export default {
  name: 'LoginPage',
  data () {
    return {
      // 数据绑定对象
      loginForm: {
        username: 'hanhan',
        password: '0525',
        message: ''
      },
      loginFormRules: {
        // 验证用户
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {
            min: 3,
            max: 10,
            message: '长度在3到10个字符',
            trigger: 'blur'
          }
        ],
        password: [
          {required: true, message: '请输入登录密码', trigger: 'blur'},
          {
            min: 3,
            max: 15,
            message: '长度在3到15个字符',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    Login () {
      /* http://localhost:8081/api/login */
      this.$axios
          .post(Global.bg_java + '/api/login', qs.stringify(this.loginForm))
          .then(successResponse => {
            console.log(successResponse.data)
            if (successResponse.data.code !== 200) {
              this.loginForm.message = successResponse.data.message
            } else {
              console.log('登录成功')
              this.$router.push({path: '/JumpPage'})
            }
          })
          .catch(failResponse => {
            console.log('12345566')
            console.log(failResponse)
          })
    },
    // // 重置登录表单
    resetLoginForm () {
      this.$refs.loginFormRef.resetFields()
    }
  }
}
</script>
