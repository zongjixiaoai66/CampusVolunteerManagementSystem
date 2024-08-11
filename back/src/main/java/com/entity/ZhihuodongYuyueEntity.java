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
 * 志愿者活动报名
 *
 * @author 
 * @email
 */
@TableName("zhihuodong_yuyue")
public class ZhihuodongYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhihuodongYuyueEntity() {

	}

	public ZhihuodongYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "zhihuodong_yuyue_uuid_number")

    private String zhihuodongYuyueUuidNumber;


    /**
     * 活动
     */
    @ColumnInfo(comment="活动",type="int(11)")
    @TableField(value = "zhihuodong_id")

    private Integer zhihuodongId;


    /**
     * 非志愿者
     */
    @ColumnInfo(comment="非志愿者",type="int(11)")
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "zhihuodong_yuyue_text")

    private String zhihuodongYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "zhihuodong_yuyue_yesno_types")

    private Integer zhihuodongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "zhihuodong_yuyue_yesno_text")

    private String zhihuodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "zhihuodong_yuyue_shenhe_time")

    private Date zhihuodongYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getZhihuodongYuyueUuidNumber() {
        return zhihuodongYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setZhihuodongYuyueUuidNumber(String zhihuodongYuyueUuidNumber) {
        this.zhihuodongYuyueUuidNumber = zhihuodongYuyueUuidNumber;
    }
    /**
	 * 获取：活动
	 */
    public Integer getZhihuodongId() {
        return zhihuodongId;
    }
    /**
	 * 设置：活动
	 */

    public void setZhihuodongId(Integer zhihuodongId) {
        this.zhihuodongId = zhihuodongId;
    }
    /**
	 * 获取：非志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }
    /**
	 * 设置：非志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getZhihuodongYuyueText() {
        return zhihuodongYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setZhihuodongYuyueText(String zhihuodongYuyueText) {
        this.zhihuodongYuyueText = zhihuodongYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getZhihuodongYuyueYesnoTypes() {
        return zhihuodongYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setZhihuodongYuyueYesnoTypes(Integer zhihuodongYuyueYesnoTypes) {
        this.zhihuodongYuyueYesnoTypes = zhihuodongYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getZhihuodongYuyueYesnoText() {
        return zhihuodongYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setZhihuodongYuyueYesnoText(String zhihuodongYuyueYesnoText) {
        this.zhihuodongYuyueYesnoText = zhihuodongYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getZhihuodongYuyueShenheTime() {
        return zhihuodongYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setZhihuodongYuyueShenheTime(Date zhihuodongYuyueShenheTime) {
        this.zhihuodongYuyueShenheTime = zhihuodongYuyueShenheTime;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ZhihuodongYuyue{" +
            ", id=" + id +
            ", zhihuodongYuyueUuidNumber=" + zhihuodongYuyueUuidNumber +
            ", zhihuodongId=" + zhihuodongId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", zhihuodongYuyueText=" + zhihuodongYuyueText +
            ", zhihuodongYuyueYesnoTypes=" + zhihuodongYuyueYesnoTypes +
            ", zhihuodongYuyueYesnoText=" + zhihuodongYuyueYesnoText +
            ", zhihuodongYuyueShenheTime=" + DateUtil.convertString(zhihuodongYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
