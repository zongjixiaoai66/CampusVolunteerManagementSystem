package com.entity.model;

import com.entity.ZhihuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 志愿者活动
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhihuodongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 活动名称
     */
    private String zhihuodongName;


    /**
     * 活动编号
     */
    private String zhihuodongUuidNumber;


    /**
     * 活动照片
     */
    private String zhihuodongPhoto;


    /**
     * 活动地点
     */
    private String zhihuodongAddress;


    /**
     * 活动类型
     */
    private Integer zhihuodongTypes;


    /**
     * 活动人数
     */
    private Integer zhihuodongKucunNumber;


    /**
     * 参加活动条件
     */
    private String zhihuodongTiaojian;


    /**
     * 活动介绍
     */
    private String zhihuodongContent;


    /**
     * 逻辑删除
     */
    private Integer zhihuodongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
