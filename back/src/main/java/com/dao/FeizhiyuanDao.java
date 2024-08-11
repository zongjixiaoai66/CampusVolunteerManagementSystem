package com.dao;

import com.entity.FeizhiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FeizhiyuanView;

/**
 * 非志愿者 Dao 接口
 *
 * @author 
 */
public interface FeizhiyuanDao extends BaseMapper<FeizhiyuanEntity> {

   List<FeizhiyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
