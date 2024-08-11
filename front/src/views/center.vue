<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='feizhiyuan'"  label='非志愿者姓名' prop="feizhiyuanName">
               <el-input v-model="ruleForm.feizhiyuanName"  placeholder='非志愿者姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='feizhiyuan'"  label='非志愿者手机号' prop="feizhiyuanPhone">
               <el-input v-model="ruleForm.feizhiyuanPhone"  placeholder='非志愿者手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='feizhiyuan'"  label='非志愿者身份证号' prop="feizhiyuanIdNumber">
               <el-input v-model="ruleForm.feizhiyuanIdNumber"  placeholder='非志愿者身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='feizhiyuan'" label='非志愿者头像' prop="feizhiyuanPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.feizhiyuanPhoto?$base.url+ruleForm.feizhiyuanPhoto:''"
                         @change="feizhiyuanPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='feizhiyuan'"  label='非志愿者邮箱' prop="feizhiyuanEmail">
               <el-input v-model="ruleForm.feizhiyuanEmail"  placeholder='非志愿者邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者姓名' prop="zhiyuanzheName">
               <el-input v-model="ruleForm.zhiyuanzheName"  placeholder='志愿者姓名' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者手机号' prop="zhiyuanzhePhone">
               <el-input v-model="ruleForm.zhiyuanzhePhone"  placeholder='志愿者手机号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者身份证号' prop="zhiyuanzheIdNumber">
               <el-input v-model="ruleForm.zhiyuanzheIdNumber"  placeholder='志愿者身份证号' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-col :span="12">
             <el-form-item v-if="flag=='zhiyuanzhe'" label='志愿者头像' prop="zhiyuanzhePhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.zhiyuanzhePhoto?$base.url+ruleForm.zhiyuanzhePhoto:''"
                         @change="zhiyuanzhePhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='zhiyuanzhe'"  label='志愿者邮箱' prop="zhiyuanzheEmail">
               <el-input v-model="ruleForm.zhiyuanzheEmail"  placeholder='志愿者邮箱' clearable></el-input>
           </el-form-item>
         </el-col>

         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='zhiyuanzhe'
|| flag=='feizhiyuan')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
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
        // sexTypesOptions : [],
// 注册表 志愿者
    // 注册的类型字段 志愿者
        // 性别
        sexTypesOptions : [],
// 注册表 非志愿者
    // 注册的类型字段 非志愿者
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 志愿者
// 注册表 非志愿者
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 志愿者 的级联表
// 注册表 非志愿者 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    feizhiyuanPhotoUploadChange(fileUrls) {
        this.ruleForm.feizhiyuanPhoto = fileUrls;
    },
    zhiyuanzhePhotoUploadChange(fileUrls) {
        this.ruleForm.zhiyuanzhePhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.feizhiyuanName)&& 'feizhiyuan'==this.flag){
                             this.$message.error('非志愿者姓名不能为空');
                             return
                         }

                             if( 'feizhiyuan' ==this.flag && this.ruleForm.feizhiyuanPhone&&(!isMobile(this.ruleForm.feizhiyuanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.feizhiyuanIdNumber)&& 'feizhiyuan'==this.flag){
                             this.$message.error('非志愿者身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.feizhiyuanPhoto)&& 'feizhiyuan'==this.flag){
                             this.$message.error('非志愿者头像不能为空');
                             return
                         }

                             if( 'feizhiyuan' ==this.flag && this.ruleForm.feizhiyuanEmail&&(!isEmail(this.ruleForm.feizhiyuanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.zhiyuanzheName)&& 'zhiyuanzhe'==this.flag){
                             this.$message.error('志愿者姓名不能为空');
                             return
                         }

                             if( 'zhiyuanzhe' ==this.flag && this.ruleForm.zhiyuanzhePhone&&(!isMobile(this.ruleForm.zhiyuanzhePhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.zhiyuanzheIdNumber)&& 'zhiyuanzhe'==this.flag){
                             this.$message.error('志愿者身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.zhiyuanzhePhoto)&& 'zhiyuanzhe'==this.flag){
                             this.$message.error('志愿者头像不能为空');
                             return
                         }

                             if( 'zhiyuanzhe' ==this.flag && this.ruleForm.zhiyuanzheEmail&&(!isEmail(this.ruleForm.zhiyuanzheEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='zhiyuanzhe'
|| this.flag=='feizhiyuan')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
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
</style>
