package com.dao;

import com.entity.FeihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FeihuodongView;

/**
 * 活动 Dao 接口
 *
 * @author 
 */
public interface FeihuodongDao extends BaseMapper<FeihuodongEntity> {

   List<FeihuodongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
