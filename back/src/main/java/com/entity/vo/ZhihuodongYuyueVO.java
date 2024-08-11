package com.entity.vo;

import com.entity.ZhihuodongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 志愿者活动报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhihuodong_yuyue")
public class ZhihuodongYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "zhihuodong_yuyue_uuid_number")
    private String zhihuodongYuyueUuidNumber;


    /**
     * 活动
     */

    @TableField(value = "zhihuodong_id")
    private Integer zhihuodongId;


    /**
     * 非志愿者
     */

    @TableField(value = "zhiyuanzhe_id")
    private Integer zhiyuanzheId;


    /**
     * 报名理由
     */

    @TableField(value = "zhihuodong_yuyue_text")
    private String zhihuodongYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "zhihuodong_yuyue_yesno_types")
    private Integer zhihuodongYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "zhihuodong_yuyue_yesno_text")
    private String zhihuodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhihuodong_yuyue_shenhe_time")
    private Date zhihuodongYuyueShenheTime;


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
    public String getZhihuodongYuyueUuidNumber() {
        return zhihuodongYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setZhihuodongYuyueUuidNumber(String zhihuodongYuyueUuidNumber) {
        this.zhihuodongYuyueUuidNumber = zhihuodongYuyueUuidNumber;
    }
    /**
	 * 设置：活动
	 */
    public Integer getZhihuodongId() {
        return zhihuodongId;
    }


    /**
	 * 获取：活动
	 */

    public void setZhihuodongId(Integer zhihuodongId) {
        this.zhihuodongId = zhihuodongId;
    }
    /**
	 * 设置：非志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 获取：非志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getZhihuodongYuyueText() {
        return zhihuodongYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setZhihuodongYuyueText(String zhihuodongYuyueText) {
        this.zhihuodongYuyueText = zhihuodongYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getZhihuodongYuyueYesnoTypes() {
        return zhihuodongYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setZhihuodongYuyueYesnoTypes(Integer zhihuodongYuyueYesnoTypes) {
        this.zhihuodongYuyueYesnoTypes = zhihuodongYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getZhihuodongYuyueYesnoText() {
        return zhihuodongYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setZhihuodongYuyueYesnoText(String zhihuodongYuyueYesnoText) {
        this.zhihuodongYuyueYesnoText = zhihuodongYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getZhihuodongYuyueShenheTime() {
        return zhihuodongYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setZhihuodongYuyueShenheTime(Date zhihuodongYuyueShenheTime) {
        this.zhihuodongYuyueShenheTime = zhihuodongYuyueShenheTime;
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
