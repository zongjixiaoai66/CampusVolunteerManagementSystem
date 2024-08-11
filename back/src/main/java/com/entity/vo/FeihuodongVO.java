package com.entity.vo;

import com.entity.FeihuodongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 活动
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feihuodong")
public class FeihuodongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 非志愿者
     */

    @TableField(value = "feizhiyuan_id")
    private Integer feizhiyuanId;


    /**
     * 活动名称
     */

    @TableField(value = "feihuodong_name")
    private String feihuodongName;


    /**
     * 活动编号
     */

    @TableField(value = "feihuodong_uuid_number")
    private String feihuodongUuidNumber;


    /**
     * 活动照片
     */

    @TableField(value = "feihuodong_photo")
    private String feihuodongPhoto;


    /**
     * 活动地点
     */

    @TableField(value = "feihuodong_address")
    private String feihuodongAddress;


    /**
     * 活动类型
     */

    @TableField(value = "feihuodong_types")
    private Integer feihuodongTypes;


    /**
     * 活动人数
     */

    @TableField(value = "feihuodong_kucun_number")
    private Integer feihuodongKucunNumber;


    /**
     * 参加活动条件
     */

    @TableField(value = "feihuodong_tiaojian")
    private String feihuodongTiaojian;


    /**
     * 活动介绍
     */

    @TableField(value = "feihuodong_content")
    private String feihuodongContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "feihuodong_delete")
    private Integer feihuodongDelete;


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
	 * 设置：非志愿者
	 */
    public Integer getFeizhiyuanId() {
        return feizhiyuanId;
    }


    /**
	 * 获取：非志愿者
	 */

    public void setFeizhiyuanId(Integer feizhiyuanId) {
        this.feizhiyuanId = feizhiyuanId;
    }
    /**
	 * 设置：活动名称
	 */
    public String getFeihuodongName() {
        return feihuodongName;
    }


    /**
	 * 获取：活动名称
	 */

    public void setFeihuodongName(String feihuodongName) {
        this.feihuodongName = feihuodongName;
    }
    /**
	 * 设置：活动编号
	 */
    public String getFeihuodongUuidNumber() {
        return feihuodongUuidNumber;
    }


    /**
	 * 获取：活动编号
	 */

    public void setFeihuodongUuidNumber(String feihuodongUuidNumber) {
        this.feihuodongUuidNumber = feihuodongUuidNumber;
    }
    /**
	 * 设置：活动照片
	 */
    public String getFeihuodongPhoto() {
        return feihuodongPhoto;
    }


    /**
	 * 获取：活动照片
	 */

    public void setFeihuodongPhoto(String feihuodongPhoto) {
        this.feihuodongPhoto = feihuodongPhoto;
    }
    /**
	 * 设置：活动地点
	 */
    public String getFeihuodongAddress() {
        return feihuodongAddress;
    }


    /**
	 * 获取：活动地点
	 */

    public void setFeihuodongAddress(String feihuodongAddress) {
        this.feihuodongAddress = feihuodongAddress;
    }
    /**
	 * 设置：活动类型
	 */
    public Integer getFeihuodongTypes() {
        return feihuodongTypes;
    }


    /**
	 * 获取：活动类型
	 */

    public void setFeihuodongTypes(Integer feihuodongTypes) {
        this.feihuodongTypes = feihuodongTypes;
    }
    /**
	 * 设置：活动人数
	 */
    public Integer getFeihuodongKucunNumber() {
        return feihuodongKucunNumber;
    }


    /**
	 * 获取：活动人数
	 */

    public void setFeihuodongKucunNumber(Integer feihuodongKucunNumber) {
        this.feihuodongKucunNumber = feihuodongKucunNumber;
    }
    /**
	 * 设置：参加活动条件
	 */
    public String getFeihuodongTiaojian() {
        return feihuodongTiaojian;
    }


    /**
	 * 获取：参加活动条件
	 */

    public void setFeihuodongTiaojian(String feihuodongTiaojian) {
        this.feihuodongTiaojian = feihuodongTiaojian;
    }
    /**
	 * 设置：活动介绍
	 */
    public String getFeihuodongContent() {
        return feihuodongContent;
    }


    /**
	 * 获取：活动介绍
	 */

    public void setFeihuodongContent(String feihuodongContent) {
        this.feihuodongContent = feihuodongContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFeihuodongDelete() {
        return feihuodongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFeihuodongDelete(Integer feihuodongDelete) {
        this.feihuodongDelete = feihuodongDelete;
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
