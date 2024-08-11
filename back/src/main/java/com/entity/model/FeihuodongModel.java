package com.entity.model;

import com.entity.FeihuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 活动
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FeihuodongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 非志愿者
     */
    private Integer feizhiyuanId;


    /**
     * 活动名称
     */
    private String feihuodongName;


    /**
     * 活动编号
     */
    private String feihuodongUuidNumber;


    /**
     * 活动照片
     */
    private String feihuodongPhoto;


    /**
     * 活动地点
     */
    private String feihuodongAddress;


    /**
     * 活动类型
     */
    private Integer feihuodongTypes;


    /**
     * 活动人数
     */
    private Integer feihuodongKucunNumber;


    /**
     * 参加活动条件
     */
    private String feihuodongTiaojian;


    /**
     * 活动介绍
     */
    private String feihuodongContent;


    /**
     * 逻辑删除
     */
    private Integer feihuodongDelete;


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
