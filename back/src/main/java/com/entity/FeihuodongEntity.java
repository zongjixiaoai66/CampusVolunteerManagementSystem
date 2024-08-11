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
 * 活动
 *
 * @author 
 * @email
 */
@TableName("feihuodong")
public class FeihuodongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FeihuodongEntity() {

	}

	public FeihuodongEntity(T t) {
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
     * 非志愿者
     */
    @ColumnInfo(comment="非志愿者",type="int(11)")
    @TableField(value = "feizhiyuan_id")

    private Integer feizhiyuanId;


    /**
     * 活动名称
     */
    @ColumnInfo(comment="活动名称",type="varchar(200)")
    @TableField(value = "feihuodong_name")

    private String feihuodongName;


    /**
     * 活动编号
     */
    @ColumnInfo(comment="活动编号",type="varchar(200)")
    @TableField(value = "feihuodong_uuid_number")

    private String feihuodongUuidNumber;


    /**
     * 活动照片
     */
    @ColumnInfo(comment="活动照片",type="varchar(200)")
    @TableField(value = "feihuodong_photo")

    private String feihuodongPhoto;


    /**
     * 活动地点
     */
    @ColumnInfo(comment="活动地点",type="varchar(200)")
    @TableField(value = "feihuodong_address")

    private String feihuodongAddress;


    /**
     * 活动类型
     */
    @ColumnInfo(comment="活动类型",type="int(11)")
    @TableField(value = "feihuodong_types")

    private Integer feihuodongTypes;


    /**
     * 活动人数
     */
    @ColumnInfo(comment="活动人数",type="int(11)")
    @TableField(value = "feihuodong_kucun_number")

    private Integer feihuodongKucunNumber;


    /**
     * 参加活动条件
     */
    @ColumnInfo(comment="参加活动条件",type="varchar(200)")
    @TableField(value = "feihuodong_tiaojian")

    private String feihuodongTiaojian;


    /**
     * 活动介绍
     */
    @ColumnInfo(comment="活动介绍",type="longtext")
    @TableField(value = "feihuodong_content")

    private String feihuodongContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "feihuodong_delete")

    private Integer feihuodongDelete;


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
	 * 获取：非志愿者
	 */
    public Integer getFeizhiyuanId() {
        return feizhiyuanId;
    }
    /**
	 * 设置：非志愿者
	 */

    public void setFeizhiyuanId(Integer feizhiyuanId) {
        this.feizhiyuanId = feizhiyuanId;
    }
    /**
	 * 获取：活动名称
	 */
    public String getFeihuodongName() {
        return feihuodongName;
    }
    /**
	 * 设置：活动名称
	 */

    public void setFeihuodongName(String feihuodongName) {
        this.feihuodongName = feihuodongName;
    }
    /**
	 * 获取：活动编号
	 */
    public String getFeihuodongUuidNumber() {
        return feihuodongUuidNumber;
    }
    /**
	 * 设置：活动编号
	 */

    public void setFeihuodongUuidNumber(String feihuodongUuidNumber) {
        this.feihuodongUuidNumber = feihuodongUuidNumber;
    }
    /**
	 * 获取：活动照片
	 */
    public String getFeihuodongPhoto() {
        return feihuodongPhoto;
    }
    /**
	 * 设置：活动照片
	 */

    public void setFeihuodongPhoto(String feihuodongPhoto) {
        this.feihuodongPhoto = feihuodongPhoto;
    }
    /**
	 * 获取：活动地点
	 */
    public String getFeihuodongAddress() {
        return feihuodongAddress;
    }
    /**
	 * 设置：活动地点
	 */

    public void setFeihuodongAddress(String feihuodongAddress) {
        this.feihuodongAddress = feihuodongAddress;
    }
    /**
	 * 获取：活动类型
	 */
    public Integer getFeihuodongTypes() {
        return feihuodongTypes;
    }
    /**
	 * 设置：活动类型
	 */

    public void setFeihuodongTypes(Integer feihuodongTypes) {
        this.feihuodongTypes = feihuodongTypes;
    }
    /**
	 * 获取：活动人数
	 */
    public Integer getFeihuodongKucunNumber() {
        return feihuodongKucunNumber;
    }
    /**
	 * 设置：活动人数
	 */

    public void setFeihuodongKucunNumber(Integer feihuodongKucunNumber) {
        this.feihuodongKucunNumber = feihuodongKucunNumber;
    }
    /**
	 * 获取：参加活动条件
	 */
    public String getFeihuodongTiaojian() {
        return feihuodongTiaojian;
    }
    /**
	 * 设置：参加活动条件
	 */

    public void setFeihuodongTiaojian(String feihuodongTiaojian) {
        this.feihuodongTiaojian = feihuodongTiaojian;
    }
    /**
	 * 获取：活动介绍
	 */
    public String getFeihuodongContent() {
        return feihuodongContent;
    }
    /**
	 * 设置：活动介绍
	 */

    public void setFeihuodongContent(String feihuodongContent) {
        this.feihuodongContent = feihuodongContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFeihuodongDelete() {
        return feihuodongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFeihuodongDelete(Integer feihuodongDelete) {
        this.feihuodongDelete = feihuodongDelete;
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
        return "Feihuodong{" +
            ", id=" + id +
            ", feizhiyuanId=" + feizhiyuanId +
            ", feihuodongName=" + feihuodongName +
            ", feihuodongUuidNumber=" + feihuodongUuidNumber +
            ", feihuodongPhoto=" + feihuodongPhoto +
            ", feihuodongAddress=" + feihuodongAddress +
            ", feihuodongTypes=" + feihuodongTypes +
            ", feihuodongKucunNumber=" + feihuodongKucunNumber +
            ", feihuodongTiaojian=" + feihuodongTiaojian +
            ", feihuodongContent=" + feihuodongContent +
            ", feihuodongDelete=" + feihuodongDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
