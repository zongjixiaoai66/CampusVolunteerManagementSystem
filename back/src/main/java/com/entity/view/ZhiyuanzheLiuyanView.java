package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhiyuanzheLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 志愿者留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhiyuanzhe_liuyan")
public class ZhiyuanzheLiuyanView extends ZhiyuanzheLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

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
	//级联表 志愿者
		/**
		* 志愿者姓名
		*/

		@ColumnInfo(comment="志愿者姓名",type="varchar(200)")
		private String zhiyuanzheName;
		/**
		* 志愿者手机号
		*/

		@ColumnInfo(comment="志愿者手机号",type="varchar(200)")
		private String zhiyuanzhePhone;
		/**
		* 志愿者身份证号
		*/

		@ColumnInfo(comment="志愿者身份证号",type="varchar(200)")
		private String zhiyuanzheIdNumber;
		/**
		* 志愿者头像
		*/

		@ColumnInfo(comment="志愿者头像",type="varchar(200)")
		private String zhiyuanzhePhoto;
		/**
		* 志愿者邮箱
		*/

		@ColumnInfo(comment="志愿者邮箱",type="varchar(200)")
		private String zhiyuanzheEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ZhiyuanzheLiuyanView() {

	}

	public ZhiyuanzheLiuyanView(ZhiyuanzheLiuyanEntity zhiyuanzheLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhiyuanzheLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	//级联表的get和set 志愿者

		/**
		* 获取： 志愿者姓名
		*/
		public String getZhiyuanzheName() {
			return zhiyuanzheName;
		}
		/**
		* 设置： 志愿者姓名
		*/
		public void setZhiyuanzheName(String zhiyuanzheName) {
			this.zhiyuanzheName = zhiyuanzheName;
		}

		/**
		* 获取： 志愿者手机号
		*/
		public String getZhiyuanzhePhone() {
			return zhiyuanzhePhone;
		}
		/**
		* 设置： 志愿者手机号
		*/
		public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
			this.zhiyuanzhePhone = zhiyuanzhePhone;
		}

		/**
		* 获取： 志愿者身份证号
		*/
		public String getZhiyuanzheIdNumber() {
			return zhiyuanzheIdNumber;
		}
		/**
		* 设置： 志愿者身份证号
		*/
		public void setZhiyuanzheIdNumber(String zhiyuanzheIdNumber) {
			this.zhiyuanzheIdNumber = zhiyuanzheIdNumber;
		}

		/**
		* 获取： 志愿者头像
		*/
		public String getZhiyuanzhePhoto() {
			return zhiyuanzhePhoto;
		}
		/**
		* 设置： 志愿者头像
		*/
		public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
			this.zhiyuanzhePhoto = zhiyuanzhePhoto;
		}

		/**
		* 获取： 志愿者邮箱
		*/
		public String getZhiyuanzheEmail() {
			return zhiyuanzheEmail;
		}
		/**
		* 设置： 志愿者邮箱
		*/
		public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
			this.zhiyuanzheEmail = zhiyuanzheEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ZhiyuanzheLiuyanView{" +
			", feizhiyuanName=" + feizhiyuanName +
			", feizhiyuanPhone=" + feizhiyuanPhone +
			", feizhiyuanIdNumber=" + feizhiyuanIdNumber +
			", feizhiyuanPhoto=" + feizhiyuanPhoto +
			", feizhiyuanEmail=" + feizhiyuanEmail +
			", zhiyuanzheName=" + zhiyuanzheName +
			", zhiyuanzhePhone=" + zhiyuanzhePhone +
			", zhiyuanzheIdNumber=" + zhiyuanzheIdNumber +
			", zhiyuanzhePhoto=" + zhiyuanzhePhoto +
			", zhiyuanzheEmail=" + zhiyuanzheEmail +
			"} " + super.toString();
	}
}
