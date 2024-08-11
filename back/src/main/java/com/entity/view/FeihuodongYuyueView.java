package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FeihuodongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 活动报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("feihuodong_yuyue")
public class FeihuodongYuyueView extends FeihuodongYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String feihuodongYuyueYesnoValue;

	//级联表 活动
					 
		/**
		* 活动 的 非志愿者
		*/
		@ColumnInfo(comment="非志愿者",type="int(11)")
		private Integer feihuodongFeizhiyuanId;
		/**
		* 活动名称
		*/

		@ColumnInfo(comment="活动名称",type="varchar(200)")
		private String feihuodongName;
		/**
		* 活动编号
		*/

		@ColumnInfo(comment="活动编号",type="varchar(200)")
		private String feihuodongUuidNumber;
		/**
		* 活动照片
		*/

		@ColumnInfo(comment="活动照片",type="varchar(200)")
		private String feihuodongPhoto;
		/**
		* 活动地点
		*/

		@ColumnInfo(comment="活动地点",type="varchar(200)")
		private String feihuodongAddress;
		/**
		* 活动类型
		*/
		@ColumnInfo(comment="活动类型",type="int(11)")
		private Integer feihuodongTypes;
			/**
			* 活动类型的值
			*/
			@ColumnInfo(comment="活动类型的字典表值",type="varchar(200)")
			private String feihuodongValue;
		/**
		* 活动人数
		*/

		@ColumnInfo(comment="活动人数",type="int(11)")
		private Integer feihuodongKucunNumber;
		/**
		* 参加活动条件
		*/

		@ColumnInfo(comment="参加活动条件",type="varchar(200)")
		private String feihuodongTiaojian;
		/**
		* 活动介绍
		*/

		@ColumnInfo(comment="活动介绍",type="longtext")
		private String feihuodongContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer feihuodongDelete;
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



	public FeihuodongYuyueView() {

	}

	public FeihuodongYuyueView(FeihuodongYuyueEntity feihuodongYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, feihuodongYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getFeihuodongYuyueYesnoValue() {
		return feihuodongYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setFeihuodongYuyueYesnoValue(String feihuodongYuyueYesnoValue) {
		this.feihuodongYuyueYesnoValue = feihuodongYuyueYesnoValue;
	}


	//级联表的get和set 活动
		/**
		* 获取：活动 的 非志愿者
		*/
		public Integer getFeihuodongFeizhiyuanId() {
			return feihuodongFeizhiyuanId;
		}
		/**
		* 设置：活动 的 非志愿者
		*/
		public void setFeihuodongFeizhiyuanId(Integer feihuodongFeizhiyuanId) {
			this.feihuodongFeizhiyuanId = feihuodongFeizhiyuanId;
		}

		/**
		* 获取： 活动名称
		*/
		public String getFeihuodongName() {
			return feihuodongName;
		}
		/**
		* 设置： 活动名称
		*/
		public void setFeihuodongName(String feihuodongName) {
			this.feihuodongName = feihuodongName;
		}

		/**
		* 获取： 活动编号
		*/
		public String getFeihuodongUuidNumber() {
			return feihuodongUuidNumber;
		}
		/**
		* 设置： 活动编号
		*/
		public void setFeihuodongUuidNumber(String feihuodongUuidNumber) {
			this.feihuodongUuidNumber = feihuodongUuidNumber;
		}

		/**
		* 获取： 活动照片
		*/
		public String getFeihuodongPhoto() {
			return feihuodongPhoto;
		}
		/**
		* 设置： 活动照片
		*/
		public void setFeihuodongPhoto(String feihuodongPhoto) {
			this.feihuodongPhoto = feihuodongPhoto;
		}

		/**
		* 获取： 活动地点
		*/
		public String getFeihuodongAddress() {
			return feihuodongAddress;
		}
		/**
		* 设置： 活动地点
		*/
		public void setFeihuodongAddress(String feihuodongAddress) {
			this.feihuodongAddress = feihuodongAddress;
		}
		/**
		* 获取： 活动类型
		*/
		public Integer getFeihuodongTypes() {
			return feihuodongTypes;
		}
		/**
		* 设置： 活动类型
		*/
		public void setFeihuodongTypes(Integer feihuodongTypes) {
			this.feihuodongTypes = feihuodongTypes;
		}


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

		/**
		* 获取： 活动人数
		*/
		public Integer getFeihuodongKucunNumber() {
			return feihuodongKucunNumber;
		}
		/**
		* 设置： 活动人数
		*/
		public void setFeihuodongKucunNumber(Integer feihuodongKucunNumber) {
			this.feihuodongKucunNumber = feihuodongKucunNumber;
		}

		/**
		* 获取： 参加活动条件
		*/
		public String getFeihuodongTiaojian() {
			return feihuodongTiaojian;
		}
		/**
		* 设置： 参加活动条件
		*/
		public void setFeihuodongTiaojian(String feihuodongTiaojian) {
			this.feihuodongTiaojian = feihuodongTiaojian;
		}

		/**
		* 获取： 活动介绍
		*/
		public String getFeihuodongContent() {
			return feihuodongContent;
		}
		/**
		* 设置： 活动介绍
		*/
		public void setFeihuodongContent(String feihuodongContent) {
			this.feihuodongContent = feihuodongContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFeihuodongDelete() {
			return feihuodongDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFeihuodongDelete(Integer feihuodongDelete) {
			this.feihuodongDelete = feihuodongDelete;
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


	@Override
	public String toString() {
		return "FeihuodongYuyueView{" +
			", feihuodongYuyueYesnoValue=" + feihuodongYuyueYesnoValue +
			", feihuodongName=" + feihuodongName +
			", feihuodongUuidNumber=" + feihuodongUuidNumber +
			", feihuodongPhoto=" + feihuodongPhoto +
			", feihuodongAddress=" + feihuodongAddress +
			", feihuodongKucunNumber=" + feihuodongKucunNumber +
			", feihuodongTiaojian=" + feihuodongTiaojian +
			", feihuodongContent=" + feihuodongContent +
			", feihuodongDelete=" + feihuodongDelete +
			", zhiyuanzheName=" + zhiyuanzheName +
			", zhiyuanzhePhone=" + zhiyuanzhePhone +
			", zhiyuanzheIdNumber=" + zhiyuanzheIdNumber +
			", zhiyuanzhePhoto=" + zhiyuanzhePhoto +
			", zhiyuanzheEmail=" + zhiyuanzheEmail +
			"} " + super.toString();
	}
}
