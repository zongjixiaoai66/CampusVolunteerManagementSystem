package com.entity.vo;

import com.entity.FeihuodongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 活动报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feihuodong_yuyue")
public class FeihuodongYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "feihuodong_yuyue_uuid_number")
    private String feihuodongYuyueUuidNumber;


    /**
     * 活动
     */

    @TableField(value = "feihuodong_id")
    private Integer feihuodongId;


    /**
     * 志愿者
     */

    @TableField(value = "zhiyuanzhe_id")
    private Integer zhiyuanzheId;


    /**
     * 报名理由
     */

    @TableField(value = "feihuodong_yuyue_text")
    private String feihuodongYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "feihuodong_yuyue_yesno_types")
    private Integer feihuodongYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "feihuodong_yuyue_yesno_text")
    private String feihuodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "feihuodong_yuyue_shenhe_time")
    private Date feihuodongYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getFeihuodongYuyueUuidNumber() {
        return feihuodongYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setFeihuodongYuyueUuidNumber(String feihuodongYuyueUuidNumber) {
        this.feihuodongYuyueUuidNumber = feihuodongYuyueUuidNumber;
    }
    /**
	 * 设置：活动
	 */
    public Integer getFeihuodongId() {
        return feihuodongId;
    }


    /**
	 * 获取：活动
	 */

    public void setFeihuodongId(Integer feihuodongId) {
        this.feihuodongId = feihuodongId;
    }
    /**
	 * 设置：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 获取：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getFeihuodongYuyueText() {
        return feihuodongYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setFeihuodongYuyueText(String feihuodongYuyueText) {
        this.feihuodongYuyueText = feihuodongYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getFeihuodongYuyueYesnoTypes() {
        return feihuodongYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setFeihuodongYuyueYesnoTypes(Integer feihuodongYuyueYesnoTypes) {
        this.feihuodongYuyueYesnoTypes = feihuodongYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getFeihuodongYuyueYesnoText() {
        return feihuodongYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setFeihuodongYuyueYesnoText(String feihuodongYuyueYesnoText) {
        this.feihuodongYuyueYesnoText = feihuodongYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFeihuodongYuyueShenheTime() {
        return feihuodongYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setFeihuodongYuyueShenheTime(Date feihuodongYuyueShenheTime) {
        this.feihuodongYuyueShenheTime = feihuodongYuyueShenheTime;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
