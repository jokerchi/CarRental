<template>
  <div>

    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221029/e35b6d97fed04bd2a3e7b21cbb5114db.jpg) no-repeat","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"20px","boxShadow":"0 1px 3px rgba(64, 158, 255, .8)","margin":"0","borderRadius":"16px 32px","background":"url(http://codegen.caihongy.cn/20221029/ea2be95667c4485286b36febaa97a64e.png) no-repeat center top,url(http://codegen.caihongy.cn/20221029/238e5e194bc348e9b292b2ffaed4c06d.png) no-repeat center bottom,linear-gradient(180deg, rgba(204,204,204,1) 0%, rgba(246,246,246,1) 15%, rgba(255,255,255,1) 51%, rgba(246,246,246,1) 85%, rgba(204,204,204,1) 100%)","width":"800px","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
        <div v-if="true" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)","fontWeight":"bold"}'>USER / REGISTER</div>
        <div v-if="true" :style='{"margin":"0 0 24px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)","fontWeight":"bold"}'>汽车租赁管理系统注册</div>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="account">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>账号：</div>
          <el-input v-model="registerForm.account"  placeholder="请输入账号" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="password">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
          <el-input v-model="registerForm.password" type="password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="password">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
          <el-input v-model="registerForm.password2" type="password" placeholder="请再次输入密码" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="name">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>姓名：</div>
          <el-input v-model="registerForm.name"  placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="age">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>年龄：</div>
          <el-input v-model="registerForm.age"  placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="gender">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>性别：</div>
          <el-select v-model="registerForm.gender" placeholder="请选择性别" >
            <el-option
                v-for="(item,index) in clientGenderOptions"
                :key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="idCard">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>身份证：</div>
          <el-input v-model="registerForm.idCard"  placeholder="请输入身份证" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="phone">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>手机：</div>
          <el-input v-model="registerForm.phone"  placeholder="请输入手机" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='client'" prop="avatar">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>头像：</div>
          <file-upload
              tip="点击上传头像"
              action="file/upload"
              :limit="1"
              :multiple="true"
              :fileUrls="registerForm.avatar?registerForm.avatar:''"
              @change="clientAvatarUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="ordinaryAdminAccount">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>管理账号：</div>
          <el-input v-model="registerForm.ordinaryAdminAccount"  placeholder="请输入管理账号" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="password">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
          <el-input v-model="registerForm.password" type="password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="password">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
          <el-input v-model="registerForm.password2" type="password" placeholder="请再次输入密码" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="ordinaryAdminName">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>管理姓名：</div>
          <el-input v-model="registerForm.ordinaryAdminName"  placeholder="请输入管理姓名" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="gender">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>性别：</div>
          <el-select v-model="registerForm.gender" placeholder="请选择性别" >
            <el-option
                v-for="(item,index) in ordinaryAdminGenderOptions"
                :key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="age">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>年龄：</div>
          <el-input v-model="registerForm.age"  placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="phone">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系电话：</div>
          <el-input v-model="registerForm.phone"  placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item :style='{"width":"80%","padding":"0","margin":"0px auto 24px","height":"auto"}' v-if="tableName=='ordinaryadministrator'" prop="avatar">
          <div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>头像：</div>
          <file-upload
              tip="点击上传头像"
              action="file/upload"
              :limit="1"
              :multiple="true"
              :fileUrls="registerForm.avatar?registerForm.avatar:''"
              @change="ordinaryAdminAvatarUploadChange"
          ></file-upload>
        </el-form-item>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","boxShadow":"1px 2px 3px #52a1db","margin":"12px 16px 5px 290px","color":"#fff","display":"inline-block","outline":"none","borderRadius":"30%","background":"radial-gradient(circle, rgba(128,184,246,1) 0%, rgba(36,153,251,1) 100%)","width":"auto","fontSize":"16px","height":"40px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
        <el-button :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0 24px","boxShadow":"1px 2px 3px #ccc","margin":"12px auto 5px","color":"#999","display":"inline-block","outline":"none","borderRadius":"30%","background":"#fff","width":"auto","fontSize":"16px","height":"40px"}' @click="resetForm('registerForm')">重置</el-button>
        <router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#278bd5","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  //数据集合
  data() {
    return {
      pageFlag : '',
      tableName: '',
      registerForm: {
        gender: '',
      },
      rules: {},
      clientGenderOptions: [],
      ordinaryAdminGenderOptions: [],
    }
  },
  mounted() {
  },
  created() {
    this.pageFlag = this.$route.query.pageFlag;
    this.tableName = this.$route.query.role;
    if ('client' == this.tableName) {
      this.rules.account = [{ required: true, message: '请输入账号', trigger: 'blur' }];
    }
    if ('client' == this.tableName) {
      this.rules.password = [{ required: true, message: '请输入密码', trigger: 'blur' }];
    }
    if ('client' == this.tableName) {
      this.rules.name = [{ required: true, message: '请输入姓名', trigger: 'blur' }];
    }
    if ('client' == this.tableName) {
      this.rules.age = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
    }
    this.clientGenderOptions = "男,女".split(',');
    if ('client' == this.tableName) {
      this.rules.idCard = [{ required: true, validator: this.$validate.isIdCardNotNull, trigger: 'blur' }];
    }
    if ('client' == this.tableName) {
      this.rules.phone = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
    }
    if ('ordinaryadministrator' == this.tableName) {
      this.rules.ordinaryAdminAccount = [{ required: true, message: '请输入管理账号', trigger: 'blur' }];
    }
    if ('ordinaryadministrator' == this.tableName) {
      this.rules.password = [{ required: true, message: '请输入密码', trigger: 'blur' }];
    }
    if ('ordinaryadministrator' == this.tableName) {
      this.rules.ordinaryAdminName = [{ required: true, message: '请输入管理姓名', trigger: 'blur' }];
    }
    this.ordinaryAdminGenderOptions = "男,女".split(',');
    if ('ordinaryadministrator' == this.tableName) {
      this.rules.age = [{ required: true, message: '请输入年龄', trigger: 'blur' }];
    }
    if ('ordinaryadministrator' == this.tableName) {
      this.rules.phone = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
    }
  },
  //方法集合
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 下二随
    clientAvatarUploadChange(fileUrls) {
      this.registerForm.avatar = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
    },
    ordinaryAdminAvatarUploadChange(fileUrls) {
      this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
    },

    // 多级联动参数


    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          var url=this.tableName+"/register";
          if(`client` == this.tableName && this.registerForm.password!=this.registerForm.password2) {
            this.$message.error(`两次密码输入不一致`);
            return
          }
          if(`ordinaryadministrator` == this.tableName && this.registerForm.password!=this.registerForm.password2) {
            this.$message.error(`两次密码输入不一致`);
            return
          }
          this.$http.post(url, this.registerForm).then(res => {
            if (res.data.code === 0) {
              this.$message({
                message: '注册成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.$router.push('/login');
                }
              });
            } else {
              this.$message.error(res.data.msg);
            }
          });
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.container {
  position: relative;
  background: url(http://codegen.caihongy.cn/20221029/e35b6d97fed04bd2a3e7b21cbb5114db.jpg) no-repeat;

  .el-date-editor.el-input {
    width: 100%;
  }

  .rgs-form .el-input /deep/ .el-input__inner {
    border: 1px solid #999;
    border-radius: 8px;
    padding: 0 10px;
    box-shadow: 1px 2px 4px #ccc;
    outline: none;
    color: #999;
    background: -webkit-linear-gradient(top,#fff,#eee);
    width: 100%;
    font-size: 14px;
    height: 40px;
  }

  .rgs-form .el-select /deep/ .el-input__inner {
    border: 1px solid #999;
    border-radius: 8px;
    padding: 0 10px;
    box-shadow: 1px 2px 4px #ccc;
    outline: none;
    color: #999;
    background: -webkit-linear-gradient(top,#fff,#eee);
    width: 288px;
    font-size: 14px;
    height: 40px;
  }

  .rgs-form .el-date-editor /deep/ .el-input__inner {
    border: 1px solid #999;
    border-radius: 8px;
    padding: 0 10px 0 30px;
    box-shadow: 1px 2px 4px #ccc;
    outline: none;
    color: #999;
    background: -webkit-linear-gradient(top,#fff,#eee);
    width: 288px;
    font-size: 14px;
    height: 40px;
  }

  .rgs-form .el-date-editor /deep/ .el-input__inner {
    border: 1px solid #999;
    border-radius: 8px;
    padding: 0 10px 0 30px;
    box-shadow: 1px 2px 4px #ccc;
    outline: none;
    color: #999;
    background: -webkit-linear-gradient(top,#fff,#eee);
    width: 288px;
    font-size: 14px;
    height: 40px;
  }

  .rgs-form /deep/ .el-upload--picture-card {
    background: transparent;
    border: 0;
    border-radius: 0;
    width: auto;
    height: auto;
    line-height: initial;
    vertical-align: middle;
  }

  .rgs-form /deep/ .upload .upload-img {
    border: 1px dashed #999;
    cursor: pointer;
    border-radius: 8px;
    color: #999;
    width: 160px;
    font-size: 32px;
    line-height: 120px;
    text-align: center;
    height: 120px;
  }

  .rgs-form /deep/ .el-upload-list .el-upload-list__item {
    border: 1px dashed #999;
    cursor: pointer;
    border-radius: 8px;
    color: #999;
    width: 160px;
    font-size: 32px;
    line-height: 120px;
    text-align: center;
    height: 120px;
  }

  .rgs-form /deep/ .el-upload .el-icon-plus {
    border: 1px dashed #999;
    cursor: pointer;
    border-radius: 8px;
    color: #999;
    width: 160px;
    font-size: 32px;
    line-height: 120px;
    text-align: center;
    height: 120px;
  }
}
</style>
