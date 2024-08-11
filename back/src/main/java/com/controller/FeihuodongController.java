
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
 * 活动
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/feihuodong")
public class FeihuodongController {
    private static final Logger logger = LoggerFactory.getLogger(FeihuodongController.class);

    private static final String TABLE_NAME = "feihuodong";

    @Autowired
    private FeihuodongService feihuodongService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FeihuodongYuyueService feihuodongYuyueService;//活动报名
    @Autowired
    private FeizhiyuanService feizhiyuanService;//非志愿者
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
        params.put("feihuodongDeleteStart",1);params.put("feihuodongDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = feihuodongService.queryPage(params);

        //字典表数据转换
        List<FeihuodongView> list =(List<FeihuodongView>)page.getList();
        for(FeihuodongView c:list){
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
        FeihuodongEntity feihuodong = feihuodongService.selectById(id);
        if(feihuodong !=null){
            //entity转view
            FeihuodongView view = new FeihuodongView();
            BeanUtils.copyProperties( feihuodong , view );//把实体数据重构到view中
            //级联表 非志愿者
            //级联表
            FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(feihuodong.getFeizhiyuanId());
            if(feizhiyuan != null){
            BeanUtils.copyProperties( feizhiyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "feizhiyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFeizhiyuanId(feizhiyuan.getId());
            }
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
    public R save(@RequestBody FeihuodongEntity feihuodong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,feihuodong:{}",this.getClass().getName(),feihuodong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("非志愿者".equals(role))
            feihuodong.setFeizhiyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FeihuodongEntity> queryWrapper = new EntityWrapper<FeihuodongEntity>()
            .eq("feizhiyuan_id", feihuodong.getFeizhiyuanId())
            .eq("feihuodong_name", feihuodong.getFeihuodongName())
            .eq("feihuodong_address", feihuodong.getFeihuodongAddress())
            .eq("feihuodong_types", feihuodong.getFeihuodongTypes())
            .eq("feihuodong_kucun_number", feihuodong.getFeihuodongKucunNumber())
            .eq("feihuodong_tiaojian", feihuodong.getFeihuodongTiaojian())
            .eq("feihuodong_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeihuodongEntity feihuodongEntity = feihuodongService.selectOne(queryWrapper);
        if(feihuodongEntity==null){
            feihuodong.setFeihuodongDelete(1);
            feihuodong.setInsertTime(new Date());
            feihuodong.setCreateTime(new Date());
            feihuodongService.insert(feihuodong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FeihuodongEntity feihuodong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,feihuodong:{}",this.getClass().getName(),feihuodong.toString());
        FeihuodongEntity oldFeihuodongEntity = feihuodongService.selectById(feihuodong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("非志愿者".equals(role))
//            feihuodong.setFeizhiyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(feihuodong.getFeihuodongPhoto()) || "null".equals(feihuodong.getFeihuodongPhoto())){
                feihuodong.setFeihuodongPhoto(null);
        }

            feihuodongService.updateById(feihuodong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FeihuodongEntity> oldFeihuodongList =feihuodongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FeihuodongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FeihuodongEntity feihuodongEntity = new FeihuodongEntity();
            feihuodongEntity.setId(id);
            feihuodongEntity.setFeihuodongDelete(2);
            list.add(feihuodongEntity);
        }
        if(list != null && list.size() >0){
            feihuodongService.updateBatchById(list);
        }

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
            List<FeihuodongEntity> feihuodongList = new ArrayList<>();//上传的东西
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
                            FeihuodongEntity feihuodongEntity = new FeihuodongEntity();
//                            feihuodongEntity.setFeizhiyuanId(Integer.valueOf(data.get(0)));   //非志愿者 要改的
//                            feihuodongEntity.setFeihuodongName(data.get(0));                    //活动名称 要改的
//                            feihuodongEntity.setFeihuodongUuidNumber(data.get(0));                    //活动编号 要改的
//                            feihuodongEntity.setFeihuodongPhoto("");//详情和图片
//                            feihuodongEntity.setFeihuodongAddress(data.get(0));                    //活动地点 要改的
//                            feihuodongEntity.setFeihuodongTypes(Integer.valueOf(data.get(0)));   //活动类型 要改的
//                            feihuodongEntity.setFeihuodongKucunNumber(Integer.valueOf(data.get(0)));   //活动人数 要改的
//                            feihuodongEntity.setFeihuodongTiaojian(data.get(0));                    //参加活动条件 要改的
//                            feihuodongEntity.setFeihuodongContent("");//详情和图片
//                            feihuodongEntity.setFeihuodongDelete(1);//逻辑删除字段
//                            feihuodongEntity.setInsertTime(date);//时间
//                            feihuodongEntity.setCreateTime(date);//时间
                            feihuodongList.add(feihuodongEntity);


                            //把要查询是否重复的字段放入map中
                                //活动编号
                                if(seachFields.containsKey("feihuodongUuidNumber")){
                                    List<String> feihuodongUuidNumber = seachFields.get("feihuodongUuidNumber");
                                    feihuodongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> feihuodongUuidNumber = new ArrayList<>();
                                    feihuodongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("feihuodongUuidNumber",feihuodongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //活动编号
                        List<FeihuodongEntity> feihuodongEntities_feihuodongUuidNumber = feihuodongService.selectList(new EntityWrapper<FeihuodongEntity>().in("feihuodong_uuid_number", seachFields.get("feihuodongUuidNumber")).eq("feihuodong_delete", 1));
                        if(feihuodongEntities_feihuodongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FeihuodongEntity s:feihuodongEntities_feihuodongUuidNumber){
                                repeatFields.add(s.getFeihuodongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [活动编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        feihuodongService.insertBatch(feihuodongList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = feihuodongService.queryPage(params);

        //字典表数据转换
        List<FeihuodongView> list =(List<FeihuodongView>)page.getList();
        for(FeihuodongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeihuodongEntity feihuodong = feihuodongService.selectById(id);
            if(feihuodong !=null){


                //entity转view
                FeihuodongView view = new FeihuodongView();
                BeanUtils.copyProperties( feihuodong , view );//把实体数据重构到view中

                //级联表
                    FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(feihuodong.getFeizhiyuanId());
                if(feizhiyuan != null){
                    BeanUtils.copyProperties( feizhiyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFeizhiyuanId(feizhiyuan.getId());
                }
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
    public R add(@RequestBody FeihuodongEntity feihuodong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,feihuodong:{}",this.getClass().getName(),feihuodong.toString());
        Wrapper<FeihuodongEntity> queryWrapper = new EntityWrapper<FeihuodongEntity>()
            .eq("feizhiyuan_id", feihuodong.getFeizhiyuanId())
            .eq("feihuodong_name", feihuodong.getFeihuodongName())
            .eq("feihuodong_uuid_number", feihuodong.getFeihuodongUuidNumber())
            .eq("feihuodong_address", feihuodong.getFeihuodongAddress())
            .eq("feihuodong_types", feihuodong.getFeihuodongTypes())
            .eq("feihuodong_kucun_number", feihuodong.getFeihuodongKucunNumber())
            .eq("feihuodong_tiaojian", feihuodong.getFeihuodongTiaojian())
            .eq("feihuodong_delete", feihuodong.getFeihuodongDelete())
//            .notIn("feihuodong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeihuodongEntity feihuodongEntity = feihuodongService.selectOne(queryWrapper);
        if(feihuodongEntity==null){
            feihuodong.setFeihuodongDelete(1);
            feihuodong.setInsertTime(new Date());
            feihuodong.setCreateTime(new Date());
        feihuodongService.insert(feihuodong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

