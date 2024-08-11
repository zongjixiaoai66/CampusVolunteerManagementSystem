package com.dao;

import com.entity.FeihuodongYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FeihuodongYuyueView;

/**
 * 活动报名 Dao 接口
 *
 * @author 
 */
public interface FeihuodongYuyueDao extends BaseMapper<FeihuodongYuyueEntity> {

   List<FeihuodongYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
