
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
 * 志愿者留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiyuanzheLiuyan")
public class ZhiyuanzheLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiyuanzheLiuyanController.class);

    private static final String TABLE_NAME = "zhiyuanzheLiuyan";

    @Autowired
    private ZhiyuanzheLiuyanService zhiyuanzheLiuyanService;


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
    private ZhihuodongYuyueService zhihuodongYuyueService;//志愿者活动报名
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;//志愿者
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
        PageUtils page = zhiyuanzheLiuyanService.queryPage(params);

        //字典表数据转换
        List<ZhiyuanzheLiuyanView> list =(List<ZhiyuanzheLiuyanView>)page.getList();
        for(ZhiyuanzheLiuyanView c:list){
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
        ZhiyuanzheLiuyanEntity zhiyuanzheLiuyan = zhiyuanzheLiuyanService.selectById(id);
        if(zhiyuanzheLiuyan !=null){
            //entity转view
            ZhiyuanzheLiuyanView view = new ZhiyuanzheLiuyanView();
            BeanUtils.copyProperties( zhiyuanzheLiuyan , view );//把实体数据重构到view中
            //级联表 非志愿者
            //级联表
            FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(zhiyuanzheLiuyan.getFeizhiyuanId());
            if(feizhiyuan != null){
            BeanUtils.copyProperties( feizhiyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhiyuanzheId"
, "feizhiyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFeizhiyuanId(feizhiyuan.getId());
            }
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(zhiyuanzheLiuyan.getZhiyuanzheId());
            if(zhiyuanzhe != null){
            BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhiyuanzheId"
, "feizhiyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody ZhiyuanzheLiuyanEntity zhiyuanzheLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiyuanzheLiuyan:{}",this.getClass().getName(),zhiyuanzheLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("志愿者".equals(role))
            zhiyuanzheLiuyan.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("非志愿者".equals(role))
            zhiyuanzheLiuyan.setFeizhiyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        zhiyuanzheLiuyan.setCreateTime(new Date());
        zhiyuanzheLiuyan.setInsertTime(new Date());
        zhiyuanzheLiuyanService.insert(zhiyuanzheLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuanzheLiuyanEntity zhiyuanzheLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhiyuanzheLiuyan:{}",this.getClass().getName(),zhiyuanzheLiuyan.toString());
        ZhiyuanzheLiuyanEntity oldZhiyuanzheLiuyanEntity = zhiyuanzheLiuyanService.selectById(zhiyuanzheLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("志愿者".equals(role))
//            zhiyuanzheLiuyan.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("非志愿者".equals(role))
//            zhiyuanzheLiuyan.setFeizhiyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        zhiyuanzheLiuyan.setUpdateTime(new Date());

            zhiyuanzheLiuyanService.updateById(zhiyuanzheLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhiyuanzheLiuyanEntity> oldZhiyuanzheLiuyanList =zhiyuanzheLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhiyuanzheLiuyanService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZhiyuanzheLiuyanEntity> zhiyuanzheLiuyanList = new ArrayList<>();//上传的东西
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
                            ZhiyuanzheLiuyanEntity zhiyuanzheLiuyanEntity = new ZhiyuanzheLiuyanEntity();
//                            zhiyuanzheLiuyanEntity.setFeizhiyuanId(Integer.valueOf(data.get(0)));   //非志愿者 要改的
//                            zhiyuanzheLiuyanEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            zhiyuanzheLiuyanEntity.setZhiyuanzheLiuyanText(data.get(0));                    //留言内容 要改的
//                            zhiyuanzheLiuyanEntity.setInsertTime(date);//时间
//                            zhiyuanzheLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            zhiyuanzheLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            zhiyuanzheLiuyanEntity.setCreateTime(date);//时间
                            zhiyuanzheLiuyanList.add(zhiyuanzheLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhiyuanzheLiuyanService.insertBatch(zhiyuanzheLiuyanList);
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
        PageUtils page = zhiyuanzheLiuyanService.queryPage(params);

        //字典表数据转换
        List<ZhiyuanzheLiuyanView> list =(List<ZhiyuanzheLiuyanView>)page.getList();
        for(ZhiyuanzheLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhiyuanzheLiuyanEntity zhiyuanzheLiuyan = zhiyuanzheLiuyanService.selectById(id);
            if(zhiyuanzheLiuyan !=null){


                //entity转view
                ZhiyuanzheLiuyanView view = new ZhiyuanzheLiuyanView();
                BeanUtils.copyProperties( zhiyuanzheLiuyan , view );//把实体数据重构到view中

                //级联表
                    FeizhiyuanEntity feizhiyuan = feizhiyuanService.selectById(zhiyuanzheLiuyan.getFeizhiyuanId());
                if(feizhiyuan != null){
                    BeanUtils.copyProperties( feizhiyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFeizhiyuanId(feizhiyuan.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(zhiyuanzheLiuyan.getZhiyuanzheId());
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
    public R add(@RequestBody ZhiyuanzheLiuyanEntity zhiyuanzheLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhiyuanzheLiuyan:{}",this.getClass().getName(),zhiyuanzheLiuyan.toString());
        zhiyuanzheLiuyan.setCreateTime(new Date());
        zhiyuanzheLiuyan.setInsertTime(new Date());
        zhiyuanzheLiuyanService.insert(zhiyuanzheLiuyan);

            return R.ok();
        }

}

