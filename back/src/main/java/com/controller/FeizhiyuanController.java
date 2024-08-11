
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 非志愿者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/feizhiyuan")
public class FeizhiyuanController {
    private static final Logger logger = LoggerFactory.getLogger(FeizhiyuanController.class);

    private static final String TABLE_NAME = "feizhiyuan";

    @Autowired
    private FeizhiyuanService feizhiyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FeihuodongService feihuodongService;//活动
    @Autowired
    private FeihuodongYuyueService feihuodongYuyueService;//活动报名
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private ZhihuodongService zhihuodongService;//志愿者活动
    @Autowired
    private ZhihuodongYuyueService zhihuodongYuyueService;//志愿者活动报名
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;//志愿者
    @Autowired
    private ZhiyuanzheLiuyanService zhiyuanzheLiuyanService;//志愿者留言
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("志愿者".equals(role))
            params.put("zhiyuanzheId",request.getSession().getAttribute("userId"));
        else if("非志愿者".equals(role))
            params.put("feizhiyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = feizhiyuanService.queryPage(params);

        //字典表数据转换
        List<FeizhiyuanView> list =(List<FeizhiyuanView>)page.getList();
        for(FeizhiyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(id);
        if(feizhiyuan !=null){
            //entity转view
            FeizhiyuanView view = new FeizhiyuanView();
            BeanUtils.copyProperties( feizhiyuan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FeizhiyuanEntity feizhiyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,feizhiyuan:{}",this.getClass().getName(),feizhiyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FeizhiyuanEntity> queryWrapper = new EntityWrapper<FeizhiyuanEntity>()
            .eq("username", feizhiyuan.getUsername())
            .or()
            .eq("feizhiyuan_phone", feizhiyuan.getFeizhiyuanPhone())
            .or()
            .eq("feizhiyuan_id_number", feizhiyuan.getFeizhiyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeizhiyuanEntity feizhiyuanEntity = feizhiyuanService.selectOne(queryWrapper);
        if(feizhiyuanEntity==null){
            feizhiyuan.setCreateTime(new Date());
            feizhiyuan.setPassword("123456");
            feizhiyuanService.insert(feizhiyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者非志愿者手机号或者非志愿者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FeizhiyuanEntity feizhiyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,feizhiyuan:{}",this.getClass().getName(),feizhiyuan.toString());
        FeizhiyuanEntity oldFeizhiyuanEntity = feizhiyuanService.selectById(feizhiyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(feizhiyuan.getFeizhiyuanPhoto()) || "null".equals(feizhiyuan.getFeizhiyuanPhoto())){
                feizhiyuan.setFeizhiyuanPhoto(null);
        }

            feizhiyuanService.updateById(feizhiyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FeizhiyuanEntity> oldFeizhiyuanList =feizhiyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        feizhiyuanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer zhiyuanzheId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FeizhiyuanEntity> feizhiyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FeizhiyuanEntity feizhiyuanEntity = new FeizhiyuanEntity();
//                            feizhiyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //feizhiyuanEntity.setPassword("123456");//密码
//                            feizhiyuanEntity.setFeizhiyuanName(data.get(0));                    //非志愿者姓名 要改的
//                            feizhiyuanEntity.setFeizhiyuanPhone(data.get(0));                    //非志愿者手机号 要改的
//                            feizhiyuanEntity.setFeizhiyuanIdNumber(data.get(0));                    //非志愿者身份证号 要改的
//                            feizhiyuanEntity.setFeizhiyuanPhoto("");//详情和图片
//                            feizhiyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            feizhiyuanEntity.setFeizhiyuanEmail(data.get(0));                    //非志愿者邮箱 要改的
//                            feizhiyuanEntity.setCreateTime(date);//时间
                            feizhiyuanList.add(feizhiyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //非志愿者手机号
                                if(seachFields.containsKey("feizhiyuanPhone")){
                                    List<String> feizhiyuanPhone = seachFields.get("feizhiyuanPhone");
                                    feizhiyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> feizhiyuanPhone = new ArrayList<>();
                                    feizhiyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("feizhiyuanPhone",feizhiyuanPhone);
                                }
                                //非志愿者身份证号
                                if(seachFields.containsKey("feizhiyuanIdNumber")){
                                    List<String> feizhiyuanIdNumber = seachFields.get("feizhiyuanIdNumber");
                                    feizhiyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> feizhiyuanIdNumber = new ArrayList<>();
                                    feizhiyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("feizhiyuanIdNumber",feizhiyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<FeizhiyuanEntity> feizhiyuanEntities_username = feizhiyuanService.selectList(new EntityWrapper<FeizhiyuanEntity>().in("username", seachFields.get("username")));
                        if(feizhiyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FeizhiyuanEntity s:feizhiyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //非志愿者手机号
                        List<FeizhiyuanEntity> feizhiyuanEntities_feizhiyuanPhone = feizhiyuanService.selectList(new EntityWrapper<FeizhiyuanEntity>().in("feizhiyuan_phone", seachFields.get("feizhiyuanPhone")));
                        if(feizhiyuanEntities_feizhiyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FeizhiyuanEntity s:feizhiyuanEntities_feizhiyuanPhone){
                                repeatFields.add(s.getFeizhiyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [非志愿者手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //非志愿者身份证号
                        List<FeizhiyuanEntity> feizhiyuanEntities_feizhiyuanIdNumber = feizhiyuanService.selectList(new EntityWrapper<FeizhiyuanEntity>().in("feizhiyuan_id_number", seachFields.get("feizhiyuanIdNumber")));
                        if(feizhiyuanEntities_feizhiyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FeizhiyuanEntity s:feizhiyuanEntities_feizhiyuanIdNumber){
                                repeatFields.add(s.getFeizhiyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [非志愿者身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        feizhiyuanService.insertBatch(feizhiyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectOne(new EntityWrapper<FeizhiyuanEntity>().eq("username", username));
        if(feizhiyuan==null || !feizhiyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(feizhiyuan.getId(),username, "feizhiyuan", "非志愿者");
        R r = R.ok();
        r.put("token", token);
        r.put("role","非志愿者");
        r.put("username",feizhiyuan.getFeizhiyuanName());
        r.put("tableName","feizhiyuan");
        r.put("userId",feizhiyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody FeizhiyuanEntity feizhiyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<FeizhiyuanEntity> queryWrapper = new EntityWrapper<FeizhiyuanEntity>()
            .eq("username", feizhiyuan.getUsername())
            .or()
            .eq("feizhiyuan_phone", feizhiyuan.getFeizhiyuanPhone())
            .or()
            .eq("feizhiyuan_id_number", feizhiyuan.getFeizhiyuanIdNumber())
            ;
        FeizhiyuanEntity feizhiyuanEntity = feizhiyuanService.selectOne(queryWrapper);
        if(feizhiyuanEntity != null)
            return R.error("账户或者非志愿者手机号或者非志愿者身份证号已经被使用");
        feizhiyuan.setCreateTime(new Date());
        feizhiyuanService.insert(feizhiyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(id);
        feizhiyuan.setPassword("123456");
        feizhiyuanService.updateById(feizhiyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(feizhiyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(feizhiyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        feizhiyuan.setPassword(newPassword);
		feizhiyuanService.updateById(feizhiyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectOne(new EntityWrapper<FeizhiyuanEntity>().eq("username", username));
        if(feizhiyuan!=null){
            feizhiyuan.setPassword("123456");
            feizhiyuanService.updateById(feizhiyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrFeizhiyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(id);
        if(feizhiyuan !=null){
            //entity转view
            FeizhiyuanView view = new FeizhiyuanView();
            BeanUtils.copyProperties( feizhiyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = feizhiyuanService.queryPage(params);

        //字典表数据转换
        List<FeizhiyuanView> list =(List<FeizhiyuanView>)page.getList();
        for(FeizhiyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(id);
            if(feizhiyuan !=null){


                //entity转view
                FeizhiyuanView view = new FeizhiyuanView();
                BeanUtils.copyProperties( feizhiyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FeizhiyuanEntity feizhiyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,feizhiyuan:{}",this.getClass().getName(),feizhiyuan.toString());
        Wrapper<FeizhiyuanEntity> queryWrapper = new EntityWrapper<FeizhiyuanEntity>()
            .eq("username", feizhiyuan.getUsername())
            .or()
            .eq("feizhiyuan_phone", feizhiyuan.getFeizhiyuanPhone())
            .or()
            .eq("feizhiyuan_id_number", feizhiyuan.getFeizhiyuanIdNumber())
//            .notIn("feizhiyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeizhiyuanEntity feizhiyuanEntity = feizhiyuanService.selectOne(queryWrapper);
        if(feizhiyuanEntity==null){
            feizhiyuan.setCreateTime(new Date());
            feizhiyuan.setPassword("123456");
        feizhiyuanService.insert(feizhiyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者非志愿者手机号或者非志愿者身份证号已经被使用");
        }
    }

}

