<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"border":"1px solid #ddd","padding":"30px","boxShadow":"0 0px 0px #ddd","borderRadius":"5px","background":"#ffffff"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="80px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="订单编号" prop="orderNumber">
					<el-input v-model="ruleForm.orderNumber" placeholder="订单编号" clearable  :readonly="ro.orderNumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="订单编号" prop="orderNumber">
					<el-input v-model="ruleForm.orderNumber" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="车牌号" prop="carNumber">
					<el-input v-model="ruleForm.carNumber" placeholder="车牌号" clearable  :readonly="ro.carNumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车牌号" prop="carNumber">
					<el-input v-model="ruleForm.carNumber" placeholder="车牌号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="车辆品牌" prop="carBrand">
					<el-input v-model="ruleForm.carBrand" placeholder="车辆品牌" clearable  :readonly="ro.carBrand"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车辆品牌" prop="carBrand">
					<el-input v-model="ruleForm.carBrand" placeholder="车辆品牌" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="价格" prop="price">
					<el-input v-model="ruleForm.price" placeholder="价格" clearable  :readonly="ro.price"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="价格" prop="price">
					<el-input v-model="ruleForm.price" placeholder="价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="租期" prop="leaseTerm">
					<el-input v-model="ruleForm.leaseTerm" placeholder="租期" clearable  :readonly="ro.leaseTerm"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="租期" prop="leaseTerm">
					<el-input v-model="ruleForm.leaseTerm" placeholder="租期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="总价" prop="totalPrice">
					<el-input v-model="totalPrice" placeholder="总价" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.totalPrice" label="总价" prop="totalPrice">
					<el-input v-model="ruleForm.totalPrice" placeholder="总价" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="取消日期" prop="cancelDate">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.cancelDate"
						type="date"
						:readonly="ro.cancelDate"
						placeholder="取消日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.cancelDate" label="取消日期" prop="cancelDate">
					<el-input v-model="ruleForm.cancelDate" placeholder="取消日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="账号" prop="clientAccount">
					<el-input v-model="ruleForm.clientAccount" placeholder="账号" clearable  :readonly="ro.clientAccount"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="账号" prop="clientAccount">
					<el-input v-model="ruleForm.clientAccount" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="姓名" prop="clientName">
					<el-input v-model="ruleForm.clientName" placeholder="姓名" clearable  :readonly="ro.clientName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="姓名" prop="clientName">
					<el-input v-model="ruleForm.clientName" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机" prop="phone">
					<el-input v-model="ruleForm.phone" placeholder="手机" clearable  :readonly="ro.phone"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机" prop="phone">
					<el-input v-model="ruleForm.phone" placeholder="手机" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="身份证" prop="idCard">
					<el-input v-model="ruleForm.idCard" placeholder="身份证" clearable  :readonly="ro.idCard"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="身份证" prop="idCard">
					<el-input v-model="ruleForm.idCard" placeholder="身份证" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="管理账号" prop="administratorAccount">
					<el-input v-model="ruleForm.administratorAccount" placeholder="管理账号" clearable  :readonly="ro.administratorAccount"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="管理账号" prop="administratorAccount">
					<el-input v-model="ruleForm.administratorAccount" placeholder="管理账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="管理姓名" prop="administratorName">
					<el-input v-model="ruleForm.administratorName" placeholder="管理姓名" clearable  :readonly="ro.administratorName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="管理姓名" prop="administratorName">
					<el-input v-model="ruleForm.administratorName" placeholder="管理姓名" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="取消原因" prop="cancelReason">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="取消原因"
					  v-model="ruleForm.cancelReason" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.cancelReason" label="取消原因" prop="cancelReason">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.cancelReason}}</span>
				</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#337ab7","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#1b5a90","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#1b5a90","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
        orderNumber : false,
        carNumber : false,
        carBrand : false,
        price : false,
        leaseTerm : false,
        totalPrice : false,
        cancelDate : false,
        cancelReason : false,
        clientAccount : false,
        clientName : false,
        phone : false,
        idCard : false,
        administratorAccount : false,
        administratorName : false,
				crossUserId : false,
				crossRefId : false,
				isReviewed : false,
				reviewReply : false,
				isPay : false,
			},
			
			
			ruleForm: {
        orderNumber: '',
        carNumber: '',
        carBrand: '',
        price: '',
        leaseTerm: '',
        totalPrice: '',
        cancelDate: '',
        cancelReason: '',
        clientAccount: '',
        clientName: '',
        phone: '',
        idCard: '',
        administratorAccount: '',
        administratorName: '',
        crossUserId: '',
        crossRefId: '',
        reviewReply: '',
			},
		
			
			rules: {
        orderNumber: [
				],
        carNumber: [
				],
        carBrand: [
				],
        price: [
					{ validator: validateNumber, trigger: 'blur' },
				],
        leaseTerm: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
        totalPrice: [
					{ validator: validateNumber, trigger: 'blur' },
				],
        cancelDate: [
				],
        cancelReason: [
				],
        clientAccount: [
				],
        clientName: [
				],
        phone: [
					{ validator: validateMobile, trigger: 'blur' },
				],
        idCard: [
				],
        administratorAccount: [
				],
        administratorName: [
				],
        crossUserId: [
				],
        crossRefId: [
				],
        isReviewed: [
				],
        reviewReply: [
				],
        isPay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {


    totalPrice:{
			get: function () {
				return 1*this.ruleForm.price*this.ruleForm.leaseTerm
			}
		},

	},
	created() {
		this.ruleForm.cancelDate = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='orderNumber'){
							this.ruleForm.orderNumber = obj[o];
							this.ro.orderNumber = true;
							continue;
						}
						if(o=='carNumber'){
							this.ruleForm.carNumber = obj[o];
							this.ro.carNumber = true;
							continue;
						}
						if(o=='carBrand'){
							this.ruleForm.carBrand = obj[o];
							this.ro.carBrand = true;
							continue;
						}
						if(o=='qicheleibie'){
							this.ruleForm.qicheleibie = obj[o];
							this.ro.qicheleibie = true;
							continue;
						}
						if(o=='price'){
							this.ruleForm.price = obj[o];
							this.ro.price = true;
							continue;
						}
						if(o=='leaseTerm'){
							this.ruleForm.leaseTerm = obj[o];
							this.ro.leaseTerm = true;
							continue;
						}
						if(o=='totalPrice'){
							this.ruleForm.totalPrice = obj[o];
							this.ro.totalPrice = true;
							continue;
						}
						if(o=='cancelDate'){
							this.ruleForm.cancelDate = obj[o];
							this.ro.cancelDate = true;
							continue;
						}
						if(o=='cancelReason'){
							this.ruleForm.cancelReason = obj[o];
							this.ro.cancelReason = true;
							continue;
						}
						if(o=='clientAccount'){
							this.ruleForm.clientAccount = obj[o];
							this.ro.clientAccount = true;
							continue;
						}
						if(o=='clientName'){
							this.ruleForm.clientName = obj[o];
							this.ro.clientName = true;
							continue;
						}
						if(o=='phone'){
							this.ruleForm.phone = obj[o];
							this.ro.phone = true;
							continue;
						}
						if(o=='idCard'){
							this.ruleForm.idCard = obj[o];
							this.ro.idCard = true;
							continue;
						}
						if(o=='administratorAccount'){
							this.ruleForm.administratorAccount = obj[o];
							this.ro.administratorAccount = true;
							continue;
						}
						if(o=='administratorName'){
							this.ruleForm.administratorName = obj[o];
							this.ro.administratorName = true;
							continue;
						}
						if(o=='crossUserId'){
							this.ruleForm.crossUserId = obj[o];
							this.ro.crossUserId = true;
							continue;
						}
						if(o=='crossRefId'){
							this.ruleForm.crossRefId = obj[o];
							this.ro.crossRefId = true;
							continue;
						}
				}
				




















			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.clientAccount!=''&&json.clientAccount) || json.clientAccount==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.clientAccount = json.clientAccount
						this.ro.clientAccount = true;
					}
					if(((json.clientName!=''&&json.clientName) || json.clientName==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.clientName = json.clientName
						this.ro.clientName = true;
					}
					if(((json.phone!=''&&json.phone) || json.phone==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.phone = json.phone
						this.ro.phone = true;
					}
					if(((json.idCard!=''&&json.idCard) || json.idCard==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.idCard = json.idCard
						this.ro.idCard = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `quxiaodingdan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.totalPrice = this.totalPrice









































var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossUserId;
       var crossRefId;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                         crossUserId=this.$storage.get('userid');
                         crossRefId=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossRefId && crossUserId) {
			 this.ruleForm.crossUserId = crossUserId;
			 this.ruleForm.crossRefId = crossRefId;
			let params = { 
				page: 1, 
				limit: 10,
        crossUserId:this.ruleForm.crossUserId,
        crossRefId:this.ruleForm.crossRefId,
			} 
			this.$http({ 
				url: "quxiaodingdan/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `quxiaodingdan/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.quxiaodingdanCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `quxiaodingdan/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.quxiaodingdanCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.quxiaodingdanCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
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
	
	.add-update-preview /deep/ .upload .upload-img {
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
