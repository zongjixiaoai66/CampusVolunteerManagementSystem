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
 * 非志愿者
 *
 * @author 
 * @email
 */
@TableName("feizhiyuan")
public class FeizhiyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FeizhiyuanEntity() {

	}

	public FeizhiyuanEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 非志愿者姓名
     */
    @ColumnInfo(comment="非志愿者姓名",type="varchar(200)")
    @TableField(value = "feizhiyuan_name")

    private String feizhiyuanName;


    /**
     * 非志愿者手机号
     */
    @ColumnInfo(comment="非志愿者手机号",type="varchar(200)")
    @TableField(value = "feizhiyuan_phone")

    private String feizhiyuanPhone;


    /**
     * 非志愿者身份证号
     */
    @ColumnInfo(comment="非志愿者身份证号",type="varchar(200)")
    @TableField(value = "feizhiyuan_id_number")

    private String feizhiyuanIdNumber;


    /**
     * 非志愿者头像
     */
    @ColumnInfo(comment="非志愿者头像",type="varchar(200)")
    @TableField(value = "feizhiyuan_photo")

    private String feizhiyuanPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 非志愿者邮箱
     */
    @ColumnInfo(comment="非志愿者邮箱",type="varchar(200)")
    @TableField(value = "feizhiyuan_email")

    private String feizhiyuanEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：非志愿者姓名
	 */
    public String getFeizhiyuanName() {
        return feizhiyuanName;
    }
    /**
	 * 设置：非志愿者姓名
	 */

    public void setFeizhiyuanName(String feizhiyuanName) {
        this.feizhiyuanName = feizhiyuanName;
    }
    /**
	 * 获取：非志愿者手机号
	 */
    public String getFeizhiyuanPhone() {
        return feizhiyuanPhone;
    }
    /**
	 * 设置：非志愿者手机号
	 */

    public void setFeizhiyuanPhone(String feizhiyuanPhone) {
        this.feizhiyuanPhone = feizhiyuanPhone;
    }
    /**
	 * 获取：非志愿者身份证号
	 */
    public String getFeizhiyuanIdNumber() {
        return feizhiyuanIdNumber;
    }
    /**
	 * 设置：非志愿者身份证号
	 */

    public void setFeizhiyuanIdNumber(String feizhiyuanIdNumber) {
        this.feizhiyuanIdNumber = feizhiyuanIdNumber;
    }
    /**
	 * 获取：非志愿者头像
	 */
    public String getFeizhiyuanPhoto() {
        return feizhiyuanPhoto;
    }
    /**
	 * 设置：非志愿者头像
	 */

    public void setFeizhiyuanPhoto(String feizhiyuanPhoto) {
        this.feizhiyuanPhoto = feizhiyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：非志愿者邮箱
	 */
    public String getFeizhiyuanEmail() {
        return feizhiyuanEmail;
    }
    /**
	 * 设置：非志愿者邮箱
	 */

    public void setFeizhiyuanEmail(String feizhiyuanEmail) {
        this.feizhiyuanEmail = feizhiyuanEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Feizhiyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", feizhiyuanName=" + feizhiyuanName +
            ", feizhiyuanPhone=" + feizhiyuanPhone +
            ", feizhiyuanIdNumber=" + feizhiyuanIdNumber +
            ", feizhiyuanPhoto=" + feizhiyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", feizhiyuanEmail=" + feizhiyuanEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
