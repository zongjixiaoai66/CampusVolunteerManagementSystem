package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhihuodongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 志愿者活动报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhihuodong_yuyue")
public class ZhihuodongYuyueView extends ZhihuodongYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String zhihuodongYuyueYesnoValue;

	//级联表 志愿者活动
					 
		/**
		* 志愿者活动 的 志愿者
		*/
		@ColumnInfo(comment="志愿者",type="int(11)")
		private Integer zhihuodongZhiyuanzheId;
		/**
		* 活动名称
		*/

		@ColumnInfo(comment="活动名称",type="varchar(200)")
		private String zhihuodongName;
		/**
		* 活动编号
		*/

		@ColumnInfo(comment="活动编号",type="varchar(200)")
		private String zhihuodongUuidNumber;
		/**
		* 活动照片
		*/

		@ColumnInfo(comment="活动照片",type="varchar(200)")
		private String zhihuodongPhoto;
		/**
		* 活动地点
		*/

		@ColumnInfo(comment="活动地点",type="varchar(200)")
		private String zhihuodongAddress;
		/**
		* 活动类型
		*/
		@ColumnInfo(comment="活动类型",type="int(11)")
		private Integer zhihuodongTypes;
			/**
			* 活动类型的值
			*/
			@ColumnInfo(comment="活动类型的字典表值",type="varchar(200)")
			private String zhihuodongValue;
		/**
		* 活动人数
		*/

		@ColumnInfo(comment="活动人数",type="int(11)")
		private Integer zhihuodongKucunNumber;
		/**
		* 参加活动条件
		*/

		@ColumnInfo(comment="参加活动条件",type="varchar(200)")
		private String zhihuodongTiaojian;
		/**
		* 活动介绍
		*/

		@ColumnInfo(comment="活动介绍",type="longtext")
		private String zhihuodongContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zhihuodongDelete;
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



	public ZhihuodongYuyueView() {

	}

	public ZhihuodongYuyueView(ZhihuodongYuyueEntity zhihuodongYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, zhihuodongYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getZhihuodongYuyueYesnoValue() {
		return zhihuodongYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setZhihuodongYuyueYesnoValue(String zhihuodongYuyueYesnoValue) {
		this.zhihuodongYuyueYesnoValue = zhihuodongYuyueYesnoValue;
	}


	//级联表的get和set 志愿者活动
		/**
		* 获取：志愿者活动 的 志愿者
		*/
		public Integer getZhihuodongZhiyuanzheId() {
			return zhihuodongZhiyuanzheId;
		}
		/**
		* 设置：志愿者活动 的 志愿者
		*/
		public void setZhihuodongZhiyuanzheId(Integer zhihuodongZhiyuanzheId) {
			this.zhihuodongZhiyuanzheId = zhihuodongZhiyuanzheId;
		}

		/**
		* 获取： 活动名称
		*/
		public String getZhihuodongName() {
			return zhihuodongName;
		}
		/**
		* 设置： 活动名称
		*/
		public void setZhihuodongName(String zhihuodongName) {
			this.zhihuodongName = zhihuodongName;
		}

		/**
		* 获取： 活动编号
		*/
		public String getZhihuodongUuidNumber() {
			return zhihuodongUuidNumber;
		}
		/**
		* 设置： 活动编号
		*/
		public void setZhihuodongUuidNumber(String zhihuodongUuidNumber) {
			this.zhihuodongUuidNumber = zhihuodongUuidNumber;
		}

		/**
		* 获取： 活动照片
		*/
		public String getZhihuodongPhoto() {
			return zhihuodongPhoto;
		}
		/**
		* 设置： 活动照片
		*/
		public void setZhihuodongPhoto(String zhihuodongPhoto) {
			this.zhihuodongPhoto = zhihuodongPhoto;
		}

		/**
		* 获取： 活动地点
		*/
		public String getZhihuodongAddress() {
			return zhihuodongAddress;
		}
		/**
		* 设置： 活动地点
		*/
		public void setZhihuodongAddress(String zhihuodongAddress) {
			this.zhihuodongAddress = zhihuodongAddress;
		}
		/**
		* 获取： 活动类型
		*/
		public Integer getZhihuodongTypes() {
			return zhihuodongTypes;
		}
		/**
		* 设置： 活动类型
		*/
		public void setZhihuodongTypes(Integer zhihuodongTypes) {
			this.zhihuodongTypes = zhihuodongTypes;
		}


			/**
			* 获取： 活动类型的值
			*/
			public String getZhihuodongValue() {
				return zhihuodongValue;
			}
			/**
			* 设置： 活动类型的值
			*/
			public void setZhihuodongValue(String zhihuodongValue) {
				this.zhihuodongValue = zhihuodongValue;
			}

		/**
		* 获取： 活动人数
		*/
		public Integer getZhihuodongKucunNumber() {
			return zhihuodongKucunNumber;
		}
		/**
		* 设置： 活动人数
		*/
		public void setZhihuodongKucunNumber(Integer zhihuodongKucunNumber) {
			this.zhihuodongKucunNumber = zhihuodongKucunNumber;
		}

		/**
		* 获取： 参加活动条件
		*/
		public String getZhihuodongTiaojian() {
			return zhihuodongTiaojian;
		}
		/**
		* 设置： 参加活动条件
		*/
		public void setZhihuodongTiaojian(String zhihuodongTiaojian) {
			this.zhihuodongTiaojian = zhihuodongTiaojian;
		}

		/**
		* 获取： 活动介绍
		*/
		public String getZhihuodongContent() {
			return zhihuodongContent;
		}
		/**
		* 设置： 活动介绍
		*/
		public void setZhihuodongContent(String zhihuodongContent) {
			this.zhihuodongContent = zhihuodongContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZhihuodongDelete() {
			return zhihuodongDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZhihuodongDelete(Integer zhihuodongDelete) {
			this.zhihuodongDelete = zhihuodongDelete;
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
		return "ZhihuodongYuyueView{" +
			", zhihuodongYuyueYesnoValue=" + zhihuodongYuyueYesnoValue +
			", zhihuodongName=" + zhihuodongName +
			", zhihuodongUuidNumber=" + zhihuodongUuidNumber +
			", zhihuodongPhoto=" + zhihuodongPhoto +
			", zhihuodongAddress=" + zhihuodongAddress +
			", zhihuodongKucunNumber=" + zhihuodongKucunNumber +
			", zhihuodongTiaojian=" + zhihuodongTiaojian +
			", zhihuodongContent=" + zhihuodongContent +
			", zhihuodongDelete=" + zhihuodongDelete +
			", zhiyuanzheName=" + zhiyuanzheName +
			", zhiyuanzhePhone=" + zhiyuanzhePhone +
			", zhiyuanzheIdNumber=" + zhiyuanzheIdNumber +
			", zhiyuanzhePhoto=" + zhiyuanzhePhoto +
			", zhiyuanzheEmail=" + zhiyuanzheEmail +
			"} " + super.toString();
	}
}
