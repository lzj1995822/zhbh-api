package com.jtzh.entity;

import java.util.Date;

public class NoticeLaw {
	
	// 法律法规
		private Integer id; // id
		private String title; // 标题
		private String enclosure; // 附件
		private String yhzh;
		private String createId;
		private Date createTime; // 创建时间
		private String isdeleted; // 删除标识
		private String content;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getEnclosure() {
			return enclosure;
		}
		public void setEnclosure(String enclosure) {
			this.enclosure = enclosure;
		}
		public String getYhzh() {
			return yhzh;
		}
		public void setYhzh(String yhzh) {
			this.yhzh = yhzh;
		}
		public String getCreateId() {
			return createId;
		}
		public void setCreateId(String createId) {
			this.createId = createId;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getIsdeleted() {
			return isdeleted;
		}
		public void setIsdeleted(String isdeleted) {
			this.isdeleted = isdeleted;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}

		
}
