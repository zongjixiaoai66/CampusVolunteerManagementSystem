
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
 * 志愿者活动报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhihuodongYuyue")
public class ZhihuodongYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ZhihuodongYuyueController.class);

    private static final String TABLE_NAME = "zhihuodongYuyue";

    @Autowired
    private ZhihuodongYuyueService zhihuodongYuyueService;


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
    private FeizhiyuanService feizhiyuanService;//非志愿者
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private ZhihuodongService zhihuodongService;//志愿者活动
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
        PageUtils page = zhihuodongYuyueService.queryPage(params);

        //字典表数据转换
        List<ZhihuodongYuyueView> list =(List<ZhihuodongYuyueView>)page.getList();
        for(ZhihuodongYuyueView c:list){
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
        ZhihuodongYuyueEntity zhihuodongYuyue = zhihuodongYuyueService.selectById(id);
        if(zhihuodongYuyue !=null){
            //entity转view
            ZhihuodongYuyueView view = new ZhihuodongYuyueView();
            BeanUtils.copyProperties( zhihuodongYuyue , view );//把实体数据重构到view中
            //级联表 志愿者活动
            //级联表
            ZhihuodongEntity zhihuodong = zhihuodongService.selectById(zhihuodongYuyue.getZhihuodongId());
            if(zhihuodong != null){
            BeanUtils.copyProperties( zhihuodong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhihuodongId(zhihuodong.getId());
            }
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(zhihuodongYuyue.getZhiyuanzheId());
            if(zhiyuanzhe != null){
            BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhiyuanzheId(zhiyuanzhe.getId());
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
    public R save(@RequestBody ZhihuodongYuyueEntity zhihuodongYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhihuodongYuyue:{}",this.getClass().getName(),zhihuodongYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("志愿者".equals(role))
            zhihuodongYuyue.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhihuodongYuyueEntity> queryWrapper = new EntityWrapper<ZhihuodongYuyueEntity>()
            .eq("zhihuodong_id", zhihuodongYuyue.getZhihuodongId())
            .eq("zhiyuanzhe_id", zhihuodongYuyue.getZhiyuanzheId())
            .in("zhihuodong_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhihuodongYuyueEntity zhihuodongYuyueEntity = zhihuodongYuyueService.selectOne(queryWrapper);
        if(zhihuodongYuyueEntity==null){
            zhihuodongYuyue.setZhihuodongYuyueYesnoTypes(1);
            zhihuodongYuyue.setInsertTime(new Date());
            zhihuodongYuyue.setCreateTime(new Date());
            zhihuodongYuyueService.insert(zhihuodongYuyue);
            return R.ok();
        }else {
            if(zhihuodongYuyueEntity.getZhihuodongYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(zhihuodongYuyueEntity.getZhihuodongYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhihuodongYuyueEntity zhihuodongYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhihuodongYuyue:{}",this.getClass().getName(),zhihuodongYuyue.toString());
        ZhihuodongYuyueEntity oldZhihuodongYuyueEntity = zhihuodongYuyueService.selectById(zhihuodongYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("志愿者".equals(role))
//            zhihuodongYuyue.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            zhihuodongYuyueService.updateById(zhihuodongYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ZhihuodongYuyueEntity zhihuodongYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,zhihuodongYuyueEntity:{}",this.getClass().getName(),zhihuodongYuyueEntity.toString());

        ZhihuodongYuyueEntity oldZhihuodongYuyue = zhihuodongYuyueService.selectById(zhihuodongYuyueEntity.getId());//查询原先数据

//        if(zhihuodongYuyueEntity.getZhihuodongYuyueYesnoTypes() == 2){//通过
//            zhihuodongYuyueEntity.setZhihuodongYuyueTypes();
//        }else if(zhihuodongYuyueEntity.getZhihuodongYuyueYesnoTypes() == 3){//拒绝
//            zhihuodongYuyueEntity.setZhihuodongYuyueTypes();
//        }
        zhihuodongYuyueEntity.setZhihuodongYuyueShenheTime(new Date());//审核时间
        zhihuodongYuyueService.updateById(zhihuodongYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhihuodongYuyueEntity> oldZhihuodongYuyueList =zhihuodongYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhihuodongYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZhihuodongYuyueEntity> zhihuodongYuyueList = new ArrayList<>();//上传的东西
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
                            ZhihuodongYuyueEntity zhihuodongYuyueEntity = new ZhihuodongYuyueEntity();
//                            zhihuodongYuyueEntity.setZhihuodongYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            zhihuodongYuyueEntity.setZhihuodongId(Integer.valueOf(data.get(0)));   //活动 要改的
//                            zhihuodongYuyueEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //非志愿者 要改的
//                            zhihuodongYuyueEntity.setZhihuodongYuyueText(data.get(0));                    //报名理由 要改的
//                            zhihuodongYuyueEntity.setZhihuodongYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            zhihuodongYuyueEntity.setZhihuodongYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            zhihuodongYuyueEntity.setZhihuodongYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            zhihuodongYuyueEntity.setInsertTime(date);//时间
//                            zhihuodongYuyueEntity.setCreateTime(date);//时间
                            zhihuodongYuyueList.add(zhihuodongYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("zhihuodongYuyueUuidNumber")){
                                    List<String> zhihuodongYuyueUuidNumber = seachFields.get("zhihuodongYuyueUuidNumber");
                                    zhihuodongYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhihuodongYuyueUuidNumber = new ArrayList<>();
                                    zhihuodongYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhihuodongYuyueUuidNumber",zhihuodongYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<ZhihuodongYuyueEntity> zhihuodongYuyueEntities_zhihuodongYuyueUuidNumber = zhihuodongYuyueService.selectList(new EntityWrapper<ZhihuodongYuyueEntity>().in("zhihuodong_yuyue_uuid_number", seachFields.get("zhihuodongYuyueUuidNumber")));
                        if(zhihuodongYuyueEntities_zhihuodongYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhihuodongYuyueEntity s:zhihuodongYuyueEntities_zhihuodongYuyueUuidNumber){
                                repeatFields.add(s.getZhihuodongYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhihuodongYuyueService.insertBatch(zhihuodongYuyueList);
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
        PageUtils page = zhihuodongYuyueService.queryPage(params);

        //字典表数据转换
        List<ZhihuodongYuyueView> list =(List<ZhihuodongYuyueView>)page.getList();
        for(ZhihuodongYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhihuodongYuyueEntity zhihuodongYuyue = zhihuodongYuyueService.selectById(id);
            if(zhihuodongYuyue !=null){


                //entity转view
                ZhihuodongYuyueView view = new ZhihuodongYuyueView();
                BeanUtils.copyProperties( zhihuodongYuyue , view );//把实体数据重构到view中

                //级联表
                    ZhihuodongEntity zhihuodong = zhihuodongService.selectById(zhihuodongYuyue.getZhihuodongId());
                if(zhihuodong != null){
                    BeanUtils.copyProperties( zhihuodong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhihuodongId(zhihuodong.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(zhihuodongYuyue.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
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
    public R add(@RequestBody ZhihuodongYuyueEntity zhihuodongYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhihuodongYuyue:{}",this.getClass().getName(),zhihuodongYuyue.toString());
        Wrapper<ZhihuodongYuyueEntity> queryWrapper = new EntityWrapper<ZhihuodongYuyueEntity>()
            .eq("zhihuodong_yuyue_uuid_number", zhihuodongYuyue.getZhihuodongYuyueUuidNumber())
            .eq("zhihuodong_id", zhihuodongYuyue.getZhihuodongId())
            .eq("zhiyuanzhe_id", zhihuodongYuyue.getZhiyuanzheId())
            .eq("zhihuodong_yuyue_text", zhihuodongYuyue.getZhihuodongYuyueText())
            .in("zhihuodong_yuyue_yesno_types", new Integer[]{1,2})
            .eq("zhihuodong_yuyue_yesno_text", zhihuodongYuyue.getZhihuodongYuyueYesnoText())
//            .notIn("zhihuodong_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhihuodongYuyueEntity zhihuodongYuyueEntity = zhihuodongYuyueService.selectOne(queryWrapper);
        if(zhihuodongYuyueEntity==null){
            zhihuodongYuyue.setZhihuodongYuyueYesnoTypes(1);
            zhihuodongYuyue.setInsertTime(new Date());
            zhihuodongYuyue.setCreateTime(new Date());
        zhihuodongYuyueService.insert(zhihuodongYuyue);

            return R.ok();
        }else {
            if(zhihuodongYuyueEntity.getZhihuodongYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(zhihuodongYuyueEntity.getZhihuodongYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

