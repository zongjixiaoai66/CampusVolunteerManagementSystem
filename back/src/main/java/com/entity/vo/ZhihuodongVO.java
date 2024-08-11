package com.entity.vo;

import com.entity.ZhihuodongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 志愿者活动
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhihuodong")
public class ZhihuodongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 志愿者
     */

    @TableField(value = "zhiyuanzhe_id")
    private Integer zhiyuanzheId;


    /**
     * 活动名称
     */

    @TableField(value = "zhihuodong_name")
    private String zhihuodongName;


    /**
     * 活动编号
     */

    @TableField(value = "zhihuodong_uuid_number")
    private String zhihuodongUuidNumber;


    /**
     * 活动照片
     */

    @TableField(value = "zhihuodong_photo")
    private String zhihuodongPhoto;


    /**
     * 活动地点
     */

    @TableField(value = "zhihuodong_address")
    private String zhihuodongAddress;


    /**
     * 活动类型
     */

    @TableField(value = "zhihuodong_types")
    private Integer zhihuodongTypes;


    /**
     * 活动人数
     */

    @TableField(value = "zhihuodong_kucun_number")
    private Integer zhihuodongKucunNumber;


    /**
     * 参加活动条件
     */

    @TableField(value = "zhihuodong_tiaojian")
    private String zhihuodongTiaojian;


    /**
     * 活动介绍
     */

    @TableField(value = "zhihuodong_content")
    private String zhihuodongContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zhihuodong_delete")
    private Integer zhihuodongDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：活动名称
	 */
    public String getZhihuodongName() {
        return zhihuodongName;
    }


    /**
	 * 获取：活动名称
	 */

    public void setZhihuodongName(String zhihuodongName) {
        this.zhihuodongName = zhihuodongName;
    }
    /**
	 * 设置：活动编号
	 */
    public String getZhihuodongUuidNumber() {
        return zhihuodongUuidNumber;
    }


    /**
	 * 获取：活动编号
	 */

    public void setZhihuodongUuidNumber(String zhihuodongUuidNumber) {
        this.zhihuodongUuidNumber = zhihuodongUuidNumber;
    }
    /**
	 * 设置：活动照片
	 */
    public String getZhihuodongPhoto() {
        return zhihuodongPhoto;
    }


    /**
	 * 获取：活动照片
	 */

    public void setZhihuodongPhoto(String zhihuodongPhoto) {
        this.zhihuodongPhoto = zhihuodongPhoto;
    }
    /**
	 * 设置：活动地点
	 */
    public String getZhihuodongAddress() {
        return zhihuodongAddress;
    }


    /**
	 * 获取：活动地点
	 */

    public void setZhihuodongAddress(String zhihuodongAddress) {
        this.zhihuodongAddress = zhihuodongAddress;
    }
    /**
	 * 设置：活动类型
	 */
    public Integer getZhihuodongTypes() {
        return zhihuodongTypes;
    }


    /**
	 * 获取：活动类型
	 */

    public void setZhihuodongTypes(Integer zhihuodongTypes) {
        this.zhihuodongTypes = zhihuodongTypes;
    }
    /**
	 * 设置：活动人数
	 */
    public Integer getZhihuodongKucunNumber() {
        return zhihuodongKucunNumber;
    }


    /**
	 * 获取：活动人数
	 */

    public void setZhihuodongKucunNumber(Integer zhihuodongKucunNumber) {
        this.zhihuodongKucunNumber = zhihuodongKucunNumber;
    }
    /**
	 * 设置：参加活动条件
	 */
    public String getZhihuodongTiaojian() {
        return zhihuodongTiaojian;
    }


    /**
	 * 获取：参加活动条件
	 */

    public void setZhihuodongTiaojian(String zhihuodongTiaojian) {
        this.zhihuodongTiaojian = zhihuodongTiaojian;
    }
    /**
	 * 设置：活动介绍
	 */
    public String getZhihuodongContent() {
        return zhihuodongContent;
    }


    /**
	 * 获取：活动介绍
	 */

    public void setZhihuodongContent(String zhihuodongContent) {
        this.zhihuodongContent = zhihuodongContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZhihuodongDelete() {
        return zhihuodongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZhihuodongDelete(Integer zhihuodongDelete) {
        this.zhihuodongDelete = zhihuodongDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
