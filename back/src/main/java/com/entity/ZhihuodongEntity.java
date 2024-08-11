package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 志愿者活动
 *
 * @author 
 * @email
 */
@TableName("zhihuodong")
public class ZhihuodongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhihuodongEntity() {

	}

	public ZhihuodongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 志愿者
     */
    @ColumnInfo(comment="志愿者",type="int(11)")
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 活动名称
     */
    @ColumnInfo(comment="活动名称",type="varchar(200)")
    @TableField(value = "zhihuodong_name")

    private String zhihuodongName;


    /**
     * 活动编号
     */
    @ColumnInfo(comment="活动编号",type="varchar(200)")
    @TableField(value = "zhihuodong_uuid_number")

    private String zhihuodongUuidNumber;


    /**
     * 活动照片
     */
    @ColumnInfo(comment="活动照片",type="varchar(200)")
    @TableField(value = "zhihuodong_photo")

    private String zhihuodongPhoto;


    /**
     * 活动地点
     */
    @ColumnInfo(comment="活动地点",type="varchar(200)")
    @TableField(value = "zhihuodong_address")

    private String zhihuodongAddress;


    /**
     * 活动类型
     */
    @ColumnInfo(comment="活动类型",type="int(11)")
    @TableField(value = "zhihuodong_types")

    private Integer zhihuodongTypes;


    /**
     * 活动人数
     */
    @ColumnInfo(comment="活动人数",type="int(11)")
    @TableField(value = "zhihuodong_kucun_number")

    private Integer zhihuodongKucunNumber;


    /**
     * 参加活动条件
     */
    @ColumnInfo(comment="参加活动条件",type="varchar(200)")
    @TableField(value = "zhihuodong_tiaojian")

    private String zhihuodongTiaojian;


    /**
     * 活动介绍
     */
    @ColumnInfo(comment="活动介绍",type="longtext")
    @TableField(value = "zhihuodong_content")

    private String zhihuodongContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zhihuodong_delete")

    private Integer zhihuodongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }
    /**
	 * 设置：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：活动名称
	 */
    public String getZhihuodongName() {
        return zhihuodongName;
    }
    /**
	 * 设置：活动名称
	 */

    public void setZhihuodongName(String zhihuodongName) {
        this.zhihuodongName = zhihuodongName;
    }
    /**
	 * 获取：活动编号
	 */
    public String getZhihuodongUuidNumber() {
        return zhihuodongUuidNumber;
    }
    /**
	 * 设置：活动编号
	 */

    public void setZhihuodongUuidNumber(String zhihuodongUuidNumber) {
        this.zhihuodongUuidNumber = zhihuodongUuidNumber;
    }
    /**
	 * 获取：活动照片
	 */
    public String getZhihuodongPhoto() {
        return zhihuodongPhoto;
    }
    /**
	 * 设置：活动照片
	 */

    public void setZhihuodongPhoto(String zhihuodongPhoto) {
        this.zhihuodongPhoto = zhihuodongPhoto;
    }
    /**
	 * 获取：活动地点
	 */
    public String getZhihuodongAddress() {
        return zhihuodongAddress;
    }
    /**
	 * 设置：活动地点
	 */

    public void setZhihuodongAddress(String zhihuodongAddress) {
        this.zhihuodongAddress = zhihuodongAddress;
    }
    /**
	 * 获取：活动类型
	 */
    public Integer getZhihuodongTypes() {
        return zhihuodongTypes;
    }
    /**
	 * 设置：活动类型
	 */

    public void setZhihuodongTypes(Integer zhihuodongTypes) {
        this.zhihuodongTypes = zhihuodongTypes;
    }
    /**
	 * 获取：活动人数
	 */
    public Integer getZhihuodongKucunNumber() {
        return zhihuodongKucunNumber;
    }
    /**
	 * 设置：活动人数
	 */

    public void setZhihuodongKucunNumber(Integer zhihuodongKucunNumber) {
        this.zhihuodongKucunNumber = zhihuodongKucunNumber;
    }
    /**
	 * 获取：参加活动条件
	 */
    public String getZhihuodongTiaojian() {
        return zhihuodongTiaojian;
    }
    /**
	 * 设置：参加活动条件
	 */

    public void setZhihuodongTiaojian(String zhihuodongTiaojian) {
        this.zhihuodongTiaojian = zhihuodongTiaojian;
    }
    /**
	 * 获取：活动介绍
	 */
    public String getZhihuodongContent() {
        return zhihuodongContent;
    }
    /**
	 * 设置：活动介绍
	 */

    public void setZhihuodongContent(String zhihuodongContent) {
        this.zhihuodongContent = zhihuodongContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZhihuodongDelete() {
        return zhihuodongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZhihuodongDelete(Integer zhihuodongDelete) {
        this.zhihuodongDelete = zhihuodongDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zhihuodong{" +
            ", id=" + id +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", zhihuodongName=" + zhihuodongName +
            ", zhihuodongUuidNumber=" + zhihuodongUuidNumber +
            ", zhihuodongPhoto=" + zhihuodongPhoto +
            ", zhihuodongAddress=" + zhihuodongAddress +
            ", zhihuodongTypes=" + zhihuodongTypes +
            ", zhihuodongKucunNumber=" + zhihuodongKucunNumber +
            ", zhihuodongTiaojian=" + zhihuodongTiaojian +
            ", zhihuodongContent=" + zhihuodongContent +
            ", zhihuodongDelete=" + zhihuodongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
