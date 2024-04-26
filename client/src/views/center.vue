<template>
  <div>
    <el-form
	  :style='{"border":"1px solid #ddd","padding":"30px","boxShadow":"0 0px 0px #ddd","borderRadius":"5px","background":"#ffffff"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='client'"  label="账号" prop="account">
          <el-input v-model="ruleForm.account" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='client'"  label="姓名" prop="name">
          <el-input v-model="ruleForm.name"               placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='client'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='client'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in clientGenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='client'"  label="身份证" prop="idCard">
          <el-input v-model="ruleForm.idCard"               placeholder="身份证" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='client'"  label="手机" prop="phone">
          <el-input v-model="ruleForm.phone"               placeholder="手机" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='client'" label="头像" prop="avatar">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.avatar?ruleForm.avatar:''"
          @change="clientAvatarUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='ordinaryadministrator'"  label="管理账号" prop="ordinaryAdminAccount">
          <el-input v-model="ruleForm.ordinaryAdminAccount" readonly              placeholder="管理账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='ordinaryadministrator'"  label="管理姓名" prop="ordinaryAdminName">
          <el-input v-model="ruleForm.ordinaryAdminName"               placeholder="管理姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='ordinaryadministrator'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in ordinaryAdminGenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='ordinaryadministrator'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='ordinaryadministrator'"  label="联系电话" prop="phone">
          <el-input v-model="ruleForm.phone"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='ordinaryadministrator'" label="头像" prop="avatar">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.avatar?ruleForm.avatar:''"
          @change="ordinaryAdminAvatarUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='superadministrator'" label="用户名" prop="superAdminAccount">
			<el-input v-model="ruleForm.superAdminAccount" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#337ab7","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      clientGenderOptions: [],
      ordinaryAdminGenderOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.clientGenderOptions = "男,女".split(',')
    this.ordinaryAdminGenderOptions = "男,女".split(',')
  },
  methods: {
    clientAvatarUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    ordinaryAdminAvatarUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.account)&& 'client'==this.flag){
        this.$message.error('账号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'client'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.name)&& 'client'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }
      if( 'client' ==this.flag && this.ruleForm.age&&(!isIntNumer(this.ruleForm.age))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if((!this.ruleForm.idCard)&& 'client'==this.flag){
        this.$message.error('身份证不能为空');
        return
      }
      if( 'client' ==this.flag && this.ruleForm.idCard&&(!checkIdCard(this.ruleForm.idCard))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
      if( 'client' ==this.flag && this.ruleForm.phone&&(!isMobile(this.ruleForm.phone))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
        if(this.ruleForm.avatar!=null) {
                this.ruleForm.avatar = this.ruleForm.avatar.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.ordinaryAdminAccount)&& 'ordinaryadministrator'==this.flag){
        this.$message.error('管理账号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'ordinaryadministrator'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.ordinaryAdminName)&& 'ordinaryadministrator'==this.flag){
        this.$message.error('管理姓名不能为空');
        return
      }
      if((!this.ruleForm.age)&& 'ordinaryadministrator'==this.flag){
        this.$message.error('年龄不能为空');
        return
      }
      if((!this.ruleForm.phone)&& 'ordinaryadministrator'==this.flag){
        this.$message.error('联系电话不能为空');
        return
      }
      if( 'ordinaryadministrator' ==this.flag && this.ruleForm.phone&&(!isMobile(this.ruleForm.phone))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
        if(this.ruleForm.avatar!=null) {
                this.ruleForm.avatar = this.ruleForm.avatar.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('superadministrator'==this.flag && this.ruleForm.superAdminAccount.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 80px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #5479bb;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #5479bb;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #5479bb;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px dashed #5479bb;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #5479bb;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px dashed #5479bb;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #5479bb;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #5479bb;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: auto;
	  	}
</style>
