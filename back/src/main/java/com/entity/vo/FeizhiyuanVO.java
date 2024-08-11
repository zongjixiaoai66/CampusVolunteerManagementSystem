package com.entity.vo;

import com.entity.FeizhiyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 非志愿者
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feizhiyuan")
public class FeizhiyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 非志愿者姓名
     */

    @TableField(value = "feizhiyuan_name")
    private String feizhiyuanName;


    /**
     * 非志愿者手机号
     */

    @TableField(value = "feizhiyuan_phone")
    private String feizhiyuanPhone;


    /**
     * 非志愿者身份证号
     */

    @TableField(value = "feizhiyuan_id_number")
    private String feizhiyuanIdNumber;


    /**
     * 非志愿者头像
     */

    @TableField(value = "feizhiyuan_photo")
    private String feizhiyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 非志愿者邮箱
     */

    @TableField(value = "feizhiyuan_email")
    private String feizhiyuanEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：非志愿者姓名
	 */
    public String getFeizhiyuanName() {
        return feizhiyuanName;
    }


    /**
	 * 获取：非志愿者姓名
	 */

    public void setFeizhiyuanName(String feizhiyuanName) {
        this.feizhiyuanName = feizhiyuanName;
    }
    /**
	 * 设置：非志愿者手机号
	 */
    public String getFeizhiyuanPhone() {
        return feizhiyuanPhone;
    }


    /**
	 * 获取：非志愿者手机号
	 */

    public void setFeizhiyuanPhone(String feizhiyuanPhone) {
        this.feizhiyuanPhone = feizhiyuanPhone;
    }
    /**
	 * 设置：非志愿者身份证号
	 */
    public String getFeizhiyuanIdNumber() {
        return feizhiyuanIdNumber;
    }


    /**
	 * 获取：非志愿者身份证号
	 */

    public void setFeizhiyuanIdNumber(String feizhiyuanIdNumber) {
        this.feizhiyuanIdNumber = feizhiyuanIdNumber;
    }
    /**
	 * 设置：非志愿者头像
	 */
    public String getFeizhiyuanPhoto() {
        return feizhiyuanPhoto;
    }


    /**
	 * 获取：非志愿者头像
	 */

    public void setFeizhiyuanPhoto(String feizhiyuanPhoto) {
        this.feizhiyuanPhoto = feizhiyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：非志愿者邮箱
	 */
    public String getFeizhiyuanEmail() {
        return feizhiyuanEmail;
    }


    /**
	 * 获取：非志愿者邮箱
	 */

    public void setFeizhiyuanEmail(String feizhiyuanEmail) {
        this.feizhiyuanEmail = feizhiyuanEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
