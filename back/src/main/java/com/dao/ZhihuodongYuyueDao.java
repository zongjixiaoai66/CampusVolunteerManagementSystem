package com.dao;

import com.entity.ZhihuodongYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuodongYuyueView;

/**
 * 志愿者活动报名 Dao 接口
 *
 * @author 
 */
public interface ZhihuodongYuyueDao extends BaseMapper<ZhihuodongYuyueEntity> {

   List<ZhihuodongYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
