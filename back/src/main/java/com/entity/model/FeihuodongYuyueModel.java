package com.entity.model;

import com.entity.FeihuodongYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FeihuodongYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String feihuodongYuyueUuidNumber;


    /**
     * 活动
     */
    private Integer feihuodongId;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 报名理由
     */
    private String feihuodongYuyueText;


    /**
     * 报名状态
     */
    private Integer feihuodongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String feihuodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date feihuodongYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
