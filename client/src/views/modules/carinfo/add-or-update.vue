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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="车牌号" prop="carNumber">
					<el-input v-model="ruleForm.carNumber" placeholder="车牌号" clearable  :readonly="ro.carNumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车牌号" prop="carNumber">
					<el-input v-model="ruleForm.carNumber" placeholder="车牌号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="车辆型号" prop="carModel">
					<el-input v-model="ruleForm.carModel" placeholder="车辆型号" clearable  :readonly="ro.carModel"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车辆型号" prop="carModel">
					<el-input v-model="ruleForm.carModel" placeholder="车辆型号" readonly></el-input>
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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="颜色" prop="color">
					<el-input v-model="ruleForm.color" placeholder="颜色" clearable  :readonly="ro.color"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="颜色" prop="color">
					<el-input v-model="ruleForm.color" placeholder="颜色" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="状态" prop="status">
					<el-select :disabled="ro.status" v-model="ruleForm.status" placeholder="请选择状态" >
						<el-option
							v-for="(item,index) in statusOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="状态" prop="status">
					<el-input v-model="ruleForm.status"
						placeholder="状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="换挡方式" prop="transmissionType">
					<el-select :disabled="ro.transmissionType" v-model="ruleForm.transmissionType" placeholder="请选择换挡方式" >
						<el-option
							v-for="(item,index) in transmissionTypeOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="换挡方式" prop="transmissionType">
					<el-input v-model="ruleForm.transmissionType"
						placeholder="换挡方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.carImage" label="车辆照片" prop="carImage">
					<file-upload
						tip="点击上传车辆照片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.carImage?ruleForm.carImage:''"
						@change="carImageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.carImage" label="车辆照片" prop="carImage">
					<img v-if="ruleForm.carImage.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.carImage.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.carImage.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="座位数" prop="seatNumber">
					<el-input v-model="ruleForm.seatNumber" placeholder="座位数" clearable  :readonly="ro.seatNumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="座位数" prop="seatNumber">
					<el-input v-model="ruleForm.seatNumber" placeholder="座位数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车排量" prop="displacement">
					<el-input v-model="ruleForm.displacement" placeholder="汽车排量" clearable  :readonly="ro.displacement"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车排量" prop="displacement">
					<el-input v-model="ruleForm.displacement" placeholder="汽车排量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车价格" prop="carPrice">
					<el-input v-model="ruleForm.carPrice" placeholder="汽车价格" clearable  :readonly="ro.carPrice"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车价格" prop="carPrice">
					<el-input v-model="ruleForm.carPrice" placeholder="汽车价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="出厂年份" prop="productionYear">
					<el-input v-model="ruleForm.productionYear" placeholder="出厂年份" clearable  :readonly="ro.productionYear"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="出厂年份" prop="productionYear">
					<el-input v-model="ruleForm.productionYear" placeholder="出厂年份" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="登记日期" prop="registrationDate">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.registrationDate"
						type="date"
						:readonly="ro.registrationDate"
						placeholder="登记日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.registrationDate" label="登记日期" prop="registrationDate">
					<el-input v-model="ruleForm.registrationDate" placeholder="登记日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="管理账号" prop="ordinaryAdminAccount">
					<el-input v-model="ruleForm.ordinaryAdminAccount" placeholder="管理账号" clearable  :readonly="ro.ordinaryAdminAccount"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="管理账号" prop="ordinaryAdminAccount">
					<el-input v-model="ruleForm.ordinaryAdminAccount" placeholder="管理账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="管理姓名" prop="ordinaryAdminName">
					<el-input v-model="ruleForm.ordinaryAdminName" placeholder="管理姓名" clearable  :readonly="ro.ordinaryAdminName"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="管理姓名" prop="ordinaryAdminName">
					<el-input v-model="ruleForm.ordinaryAdminName" placeholder="管理姓名" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="汽车简介" prop="carDescription">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.carDescription"
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.carDescription" label="汽车简介" prop="carDescription">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.carDescription"></span>
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
        carNumber : false,
        carModel : false,
        carBrand : false,
        price : false,
        color : false,
        status : false,
        transmissionType : false,
        carImage : false,
        seatNumber : false,
        displacement : false,
        carPrice : false,
        productionYear : false,
        registrationDate : false,
        carDescription : false,
        ordinaryAdminAccount : false,
        ordinaryAdminName : false,
				clickTime : false,
				clickNum : false,
			},
			
			
			ruleForm: {
        carNumber: '',
        carModel: '',
        carBrand: '',
        price: '',
        color: '',
        status: '未出租',
        transmissionType: '',
        carImage: '',
        seatNumber: '',
        displacement: '',
        carPrice: '',
        productionYear: '',
        registrationDate: '',
        carDescription: '',
        ordinaryAdminAccount: '',
        ordinaryAdminName: '',
        clickTime: '',
			},

      statusOptions: [],
      transmissionTypeOptions: [],
			
			rules: {
        carNumber: [
					{ required: true, message: '车牌号不能为空', trigger: 'blur' },
				],
        carModel: [
				],
        carBrand: [
					{ required: true, message: '车辆品牌不能为空', trigger: 'blur' },
				],
        price: [
					{ validator: validateNumber, trigger: 'blur' },
				],
        color: [
				],
        status: [
				],
        transmissionType: [
				],
        carImage: [
				],
        seatNumber: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
        displacement: [
				],
        carPrice: [
					{ validator: validateNumber, trigger: 'blur' },
				],
        productionYear: [
				],
        registrationDate: [
				],
        carDescription: [
				],
        ordinaryAdminAccount: [
				],
        ordinaryAdminName: [
				],
        clickTime: [
				],
        clickNum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
		this.ruleForm.registrationDate = this.getCurDate()
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
						if(o=='carNumber'){
							this.ruleForm.carNumber = obj[o];
							this.ro.carNumber = true;
							continue;
						}
						if(o=='carModel'){
							this.ruleForm.carModel = obj[o];
							this.ro.carModel = true;
							continue;
						}
						if(o=='qicheleibie'){
							this.ruleForm.qicheleibie = obj[o];
							this.ro.qicheleibie = true;
							continue;
						}
						if(o=='carBrand'){
							this.ruleForm.carBrand = obj[o];
							this.ro.carBrand = true;
							continue;
						}
						if(o=='price'){
							this.ruleForm.price = obj[o];
							this.ro.price = true;
							continue;
						}
						if(o=='color'){
							this.ruleForm.color = obj[o];
							this.ro.color = true;
							continue;
						}
						if(o=='status'){
							this.ruleForm.status = obj[o];
							this.ro.status = true;
							continue;
						}
						if(o=='transmissionType'){
							this.ruleForm.transmissionType = obj[o];
							this.ro.transmissionType = true;
							continue;
						}
						if(o=='carImage'){
							this.ruleForm.carImage = obj[o];
							this.ro.carImage = true;
							continue;
						}
						if(o=='seatNumber'){
							this.ruleForm.seatNumber = obj[o];
							this.ro.seatNumber = true;
							continue;
						}
						if(o=='displacement'){
							this.ruleForm.displacement = obj[o];
							this.ro.displacement = true;
							continue;
						}
						if(o=='carPrice'){
							this.ruleForm.carPrice = obj[o];
							this.ro.carPrice = true;
							continue;
						}
						if(o=='productionYear'){
							this.ruleForm.productionYear = obj[o];
							this.ro.productionYear = true;
							continue;
						}
						if(o=='registrationDate'){
							this.ruleForm.registrationDate = obj[o];
							this.ro.registrationDate = true;
							continue;
						}
						if(o=='carDescription'){
							this.ruleForm.carDescription = obj[o];
							this.ro.carDescription = true;
							continue;
						}
						if(o=='ordinaryAdminAccount'){
							this.ruleForm.ordinaryAdminAccount = obj[o];
							this.ro.ordinaryAdminAccount = true;
							continue;
						}
						if(o=='ordinaryAdminName'){
							this.ruleForm.ordinaryAdminName = obj[o];
							this.ro.ordinaryAdminName = true;
							continue;
						}
						if(o=='clickTime'){
							this.ruleForm.clickTime = obj[o];
							this.ro.clickTime = true;
							continue;
						}
						if(o=='clickNum'){
							this.ruleForm.clickNum = obj[o];
							this.ro.clickNum = true;
							continue;
						}
				}
				this.ruleForm.status='未出租'
			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.ordinaryAdminAccount!=''&&json.ordinaryAdminAccount) || json.ordinaryAdminAccount==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.ordinaryAdminAccount = json.ordinaryAdminAccount
						this.ro.ordinaryAdminAccount = true;
					}
					if(((json.ordinaryAdminName!=''&&json.ordinaryAdminName) || json.ordinaryAdminName==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.ordinaryAdminName = json.ordinaryAdminName
						this.ro.ordinaryAdminName = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.statusOptions = "已出租,未出租".split(',')
            this.transmissionTypeOptions = "手动挡,自动挡".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `carinfo/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.carDescription = this.ruleForm.carDescription.replace(reg,'../../../springboot1ma2x/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.carImage!=null) {
		this.ruleForm.carImage = this.ruleForm.carImage.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
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
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "carinfo/page",
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
					   url: `carinfo/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.carinfoCrossAddOrUpdateFlag = false;
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
			   url: `carinfo/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.carinfoCrossAddOrUpdateFlag = false;
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
      this.parent.carinfoCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    carImageUploadChange(fileUrls) {
	    this.ruleForm.carImage = fileUrls;
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
