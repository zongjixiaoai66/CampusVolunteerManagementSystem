package com.entity.model;

import com.entity.ZhihuodongYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 志愿者活动报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhihuodongYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String zhihuodongYuyueUuidNumber;


    /**
     * 活动
     */
    private Integer zhihuodongId;


    /**
     * 非志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 报名理由
     */
    private String zhihuodongYuyueText;


    /**
     * 报名状态
     */
    private Integer zhihuodongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String zhihuodongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhihuodongYuyueShenheTime;


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
