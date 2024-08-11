package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FeihuodongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 活动
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("feihuodong")
public class FeihuodongView extends FeihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 活动类型的值
	*/
	@ColumnInfo(comment="活动类型的字典表值",type="varchar(200)")
	private String feihuodongValue;

	//级联表 非志愿者
		/**
		* 非志愿者姓名
		*/

		@ColumnInfo(comment="非志愿者姓名",type="varchar(200)")
		private String feizhiyuanName;
		/**
		* 非志愿者手机号
		*/

		@ColumnInfo(comment="非志愿者手机号",type="varchar(200)")
		private String feizhiyuanPhone;
		/**
		* 非志愿者身份证号
		*/

		@ColumnInfo(comment="非志愿者身份证号",type="varchar(200)")
		private String feizhiyuanIdNumber;
		/**
		* 非志愿者头像
		*/

		@ColumnInfo(comment="非志愿者头像",type="varchar(200)")
		private String feizhiyuanPhoto;
		/**
		* 非志愿者邮箱
		*/

		@ColumnInfo(comment="非志愿者邮箱",type="varchar(200)")
		private String feizhiyuanEmail;



	public FeihuodongView() {

	}

	public FeihuodongView(FeihuodongEntity feihuodongEntity) {
		try {
			BeanUtils.copyProperties(this, feihuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 活动类型的值
	*/
	public String getFeihuodongValue() {
		return feihuodongValue;
	}
	/**
	* 设置： 活动类型的值
	*/
	public void setFeihuodongValue(String feihuodongValue) {
		this.feihuodongValue = feihuodongValue;
	}


	//级联表的get和set 非志愿者

		/**
		* 获取： 非志愿者姓名
		*/
		public String getFeizhiyuanName() {
			return feizhiyuanName;
		}
		/**
		* 设置： 非志愿者姓名
		*/
		public void setFeizhiyuanName(String feizhiyuanName) {
			this.feizhiyuanName = feizhiyuanName;
		}

		/**
		* 获取： 非志愿者手机号
		*/
		public String getFeizhiyuanPhone() {
			return feizhiyuanPhone;
		}
		/**
		* 设置： 非志愿者手机号
		*/
		public void setFeizhiyuanPhone(String feizhiyuanPhone) {
			this.feizhiyuanPhone = feizhiyuanPhone;
		}

		/**
		* 获取： 非志愿者身份证号
		*/
		public String getFeizhiyuanIdNumber() {
			return feizhiyuanIdNumber;
		}
		/**
		* 设置： 非志愿者身份证号
		*/
		public void setFeizhiyuanIdNumber(String feizhiyuanIdNumber) {
			this.feizhiyuanIdNumber = feizhiyuanIdNumber;
		}

		/**
		* 获取： 非志愿者头像
		*/
		public String getFeizhiyuanPhoto() {
			return feizhiyuanPhoto;
		}
		/**
		* 设置： 非志愿者头像
		*/
		public void setFeizhiyuanPhoto(String feizhiyuanPhoto) {
			this.feizhiyuanPhoto = feizhiyuanPhoto;
		}

		/**
		* 获取： 非志愿者邮箱
		*/
		public String getFeizhiyuanEmail() {
			return feizhiyuanEmail;
		}
		/**
		* 设置： 非志愿者邮箱
		*/
		public void setFeizhiyuanEmail(String feizhiyuanEmail) {
			this.feizhiyuanEmail = feizhiyuanEmail;
		}


	@Override
	public String toString() {
		return "FeihuodongView{" +
			", feihuodongValue=" + feihuodongValue +
			", feizhiyuanName=" + feizhiyuanName +
			", feizhiyuanPhone=" + feizhiyuanPhone +
			", feizhiyuanIdNumber=" + feizhiyuanIdNumber +
			", feizhiyuanPhoto=" + feizhiyuanPhoto +
			", feizhiyuanEmail=" + feizhiyuanEmail +
			"} " + super.toString();
	}
}
