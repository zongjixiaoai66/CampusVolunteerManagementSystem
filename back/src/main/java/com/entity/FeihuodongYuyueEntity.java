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
 * 活动报名
 *
 * @author 
 * @email
 */
@TableName("feihuodong_yuyue")
public class FeihuodongYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FeihuodongYuyueEntity() {

	}

	public FeihuodongYuyueEntity(T t) {
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
    @TableField(value = "feihuodong_yuyue_uuid_number")

    private String feihuodongYuyueUuidNumber;


    /**
     * 活动
     */
    @ColumnInfo(comment="活动",type="int(11)")
    @TableField(value = "feihuodong_id")

    private Integer feihuodongId;


    /**
     * 志愿者
     */
    @ColumnInfo(comment="志愿者",type="int(11)")
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "feihuodong_yuyue_text")

    private String feihuodongYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "feihuodong_yuyue_yesno_types")

    private Integer feihuodongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "feihuodong_yuyue_yesno_text")

    private String feihuodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "feihuodong_yuyue_shenhe_time")

    private Date feihuodongYuyueShenheTime;


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
    public String getFeihuodongYuyueUuidNumber() {
        return feihuodongYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setFeihuodongYuyueUuidNumber(String feihuodongYuyueUuidNumber) {
        this.feihuodongYuyueUuidNumber = feihuodongYuyueUuidNumber;
    }
    /**
	 * 获取：活动
	 */
    public Integer getFeihuodongId() {
        return feihuodongId;
    }
    /**
	 * 设置：活动
	 */

    public void setFeihuodongId(Integer feihuodongId) {
        this.feihuodongId = feihuodongId;
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
	 * 获取：报名理由
	 */
    public String getFeihuodongYuyueText() {
        return feihuodongYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setFeihuodongYuyueText(String feihuodongYuyueText) {
        this.feihuodongYuyueText = feihuodongYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getFeihuodongYuyueYesnoTypes() {
        return feihuodongYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setFeihuodongYuyueYesnoTypes(Integer feihuodongYuyueYesnoTypes) {
        this.feihuodongYuyueYesnoTypes = feihuodongYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getFeihuodongYuyueYesnoText() {
        return feihuodongYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setFeihuodongYuyueYesnoText(String feihuodongYuyueYesnoText) {
        this.feihuodongYuyueYesnoText = feihuodongYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFeihuodongYuyueShenheTime() {
        return feihuodongYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setFeihuodongYuyueShenheTime(Date feihuodongYuyueShenheTime) {
        this.feihuodongYuyueShenheTime = feihuodongYuyueShenheTime;
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
        return "FeihuodongYuyue{" +
            ", id=" + id +
            ", feihuodongYuyueUuidNumber=" + feihuodongYuyueUuidNumber +
            ", feihuodongId=" + feihuodongId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", feihuodongYuyueText=" + feihuodongYuyueText +
            ", feihuodongYuyueYesnoTypes=" + feihuodongYuyueYesnoTypes +
            ", feihuodongYuyueYesnoText=" + feihuodongYuyueYesnoText +
            ", feihuodongYuyueShenheTime=" + DateUtil.convertString(feihuodongYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
