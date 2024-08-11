package com.dao;

import com.entity.ZhihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuodongView;

/**
 * 志愿者活动 Dao 接口
 *
 * @author 
 */
public interface ZhihuodongDao extends BaseMapper<ZhihuodongEntity> {

   List<ZhihuodongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
