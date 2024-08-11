<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='zhiyuanzhe'">
                    <el-form-item class="select" v-if="type!='info'"  label="志愿者" prop="zhiyuanzheId">
                        <el-select v-model="ruleForm.zhiyuanzheId" :disabled="ro.zhiyuanzheId" filterable placeholder="请选择志愿者" @change="zhiyuanzheChange">
                            <el-option
                                    v-for="(item,index) in zhiyuanzheOptions"
                                    v-bind:key="item.id"
                                    :label="item.zhiyuanzheName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zhiyuanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="志愿者姓名" prop="zhiyuanzheName">
                        <el-input v-model="zhiyuanzheForm.zhiyuanzheName"
                                  placeholder="志愿者姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="志愿者姓名" prop="zhiyuanzheName">
                            <el-input v-model="ruleForm.zhiyuanzheName"
                                      placeholder="志愿者姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhiyuanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="志愿者手机号" prop="zhiyuanzhePhone">
                        <el-input v-model="zhiyuanzheForm.zhiyuanzhePhone"
                                  placeholder="志愿者手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="志愿者手机号" prop="zhiyuanzhePhone">
                            <el-input v-model="ruleForm.zhiyuanzhePhone"
                                      placeholder="志愿者手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhiyuanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="志愿者身份证号" prop="zhiyuanzheIdNumber">
                        <el-input v-model="zhiyuanzheForm.zhiyuanzheIdNumber"
                                  placeholder="志愿者身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="志愿者身份证号" prop="zhiyuanzheIdNumber">
                            <el-input v-model="ruleForm.zhiyuanzheIdNumber"
                                      placeholder="志愿者身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='zhiyuanzhe' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zhiyuanzhePhoto" label="志愿者头像" prop="zhiyuanzhePhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (zhiyuanzheForm.zhiyuanzhePhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zhiyuanzhePhoto" label="志愿者头像" prop="zhiyuanzhePhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.zhiyuanzhePhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhiyuanzhe' ">
                    <el-form-item class="input" v-if="type!='info'"  label="志愿者邮箱" prop="zhiyuanzheEmail">
                        <el-input v-model="zhiyuanzheForm.zhiyuanzheEmail"
                                  placeholder="志愿者邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="志愿者邮箱" prop="zhiyuanzheEmail">
                            <el-input v-model="ruleForm.zhiyuanzheEmail"
                                      placeholder="志愿者邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="zhiyuanzheId" name="zhiyuanzheId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="活动名称" prop="zhihuodongName">
                       <el-input v-model="ruleForm.zhihuodongName"
                                 placeholder="活动名称" clearable  :readonly="ro.zhihuodongName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="活动名称" prop="zhihuodongName">
                           <el-input v-model="ruleForm.zhihuodongName"
                                     placeholder="活动名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="活动编号" prop="zhihuodongUuidNumber">
                       <el-input v-model="ruleForm.zhihuodongUuidNumber"
                                 placeholder="活动编号" clearable  :readonly="ro.zhihuodongUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="活动编号" prop="zhihuodongUuidNumber">
                           <el-input v-model="ruleForm.zhihuodongUuidNumber"
                                     placeholder="活动编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zhihuodongPhoto" label="活动照片" prop="zhihuodongPhoto">
                        <file-upload
                            tip="点击上传活动照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.zhihuodongPhoto?$base.url+ruleForm.zhihuodongPhoto:''"
                            @change="zhihuodongPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.zhihuodongPhoto" label="活动照片" prop="zhihuodongPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.zhihuodongPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="活动地点" prop="zhihuodongAddress">
                       <el-input v-model="ruleForm.zhihuodongAddress"
                                 placeholder="活动地点" clearable  :readonly="ro.zhihuodongAddress"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="活动地点" prop="zhihuodongAddress">
                           <el-input v-model="ruleForm.zhihuodongAddress"
                                     placeholder="活动地点" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="活动类型" prop="zhihuodongTypes">
                        <el-select v-model="ruleForm.zhihuodongTypes" :disabled="ro.zhihuodongTypes" placeholder="请选择活动类型">
                            <el-option
                                v-for="(item,index) in zhihuodongTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="活动类型" prop="zhihuodongValue">
                        <el-input v-model="ruleForm.zhihuodongValue"
                            placeholder="活动类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="活动人数" prop="zhihuodongKucunNumber">
                       <el-input v-model="ruleForm.zhihuodongKucunNumber"
                                 placeholder="活动人数" clearable  :readonly="ro.zhihuodongKucunNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="活动人数" prop="zhihuodongKucunNumber">
                           <el-input v-model="ruleForm.zhihuodongKucunNumber"
                                     placeholder="活动人数" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="参加活动条件" prop="zhihuodongTiaojian">
                       <el-input v-model="ruleForm.zhihuodongTiaojian"
                                 placeholder="参加活动条件" clearable  :readonly="ro.zhihuodongTiaojian"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="参加活动条件" prop="zhihuodongTiaojian">
                           <el-input v-model="ruleForm.zhihuodongTiaojian"
                                     placeholder="参加活动条件" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="活动介绍" prop="zhihuodongContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.zhihuodongContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zhihuodongContent" label="活动介绍" prop="zhihuodongContent">
                            <span v-html="ruleForm.zhihuodongContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                zhiyuanzheForm: {},
                ro:{
                    zhiyuanzheId: false,
                    zhihuodongName: false,
                    zhihuodongUuidNumber: false,
                    zhihuodongPhoto: false,
                    zhihuodongAddress: false,
                    zhihuodongTypes: false,
                    zhihuodongKucunNumber: false,
                    zhihuodongTiaojian: false,
                    zhihuodongContent: false,
                    zhihuodongDelete: false,
                    insertTime: false,
                },
                ruleForm: {
                    zhiyuanzheId: '',
                    zhihuodongName: '',
                    zhihuodongUuidNumber: new Date().getTime(),
                    zhihuodongPhoto: '',
                    zhihuodongAddress: '',
                    zhihuodongTypes: '',
                    zhihuodongKucunNumber: '',
                    zhihuodongTiaojian: '',
                    zhihuodongContent: '',
                    zhihuodongDelete: '',
                    insertTime: '',
                },
                zhihuodongTypesOptions : [],
                zhiyuanzheOptions : [],
                rules: {
                   zhiyuanzheId: [
                              { required: true, message: '志愿者不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhihuodongName: [
                              { required: true, message: '活动名称不能为空', trigger: 'blur' },
                          ],
                   zhihuodongUuidNumber: [
                              { required: true, message: '活动编号不能为空', trigger: 'blur' },
                          ],
                   zhihuodongPhoto: [
                              { required: true, message: '活动照片不能为空', trigger: 'blur' },
                          ],
                   zhihuodongAddress: [
                              { required: true, message: '活动地点不能为空', trigger: 'blur' },
                          ],
                   zhihuodongTypes: [
                              { required: true, message: '活动类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhihuodongKucunNumber: [
                              { required: true, message: '活动人数不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhihuodongTiaojian: [
                              { required: true, message: '参加活动条件不能为空', trigger: 'blur' },
                          ],
                   zhihuodongContent: [
                              { required: true, message: '活动介绍不能为空', trigger: 'blur' },
                          ],
                   zhihuodongDelete: [
                              { required: true, message: '逻辑删除不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '录入时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhihuodong_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhihuodongTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `zhiyuanzhe/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zhiyuanzheOptions = data.data.list;
            }
         });

        },
        mounted() {
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
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            zhiyuanzheChange(id){
                this.$http({
                    url: `zhiyuanzhe/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhiyuanzheForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `zhihuodong/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.zhiyuanzheChange(data.data.zhiyuanzheId)
                        _this.ruleForm.zhihuodongContent = _this.ruleForm.zhihuodongContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.zhihuodongContent = this.ruleForm.zhihuodongContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`zhihuodong/${!this.ruleForm.id ? "save" : "update"}`,
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
                                        this.parent.zhihuodongCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
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
                this.parent.zhihuodongCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            zhihuodongPhotoUploadChange(fileUrls){
                this.ruleForm.zhihuodongPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

