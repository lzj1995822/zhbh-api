package com.jtzh.entity;

import java.util.Date;

public class NoticeInf {
	
	// 通知公告
		private Integer id; // id
		private String title; // 标题
		private String content; // 内容
		private String yhzh;
		private String createId;
		private Date createTime; // 创建时间
		private String isdeleted; // 删除标识
		
		private String enclosure;

		private int readNum;
		private int dzNum;
		
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
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
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
		public String getEnclosure() {
			return enclosure;
		}
		public void setEnclosure(String enclosure) {
			this.enclosure = enclosure;
		}


	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public int getDzNum() {
		return dzNum;
	}

	public void setDzNum(int dzNum) {
		this.dzNum = dzNum;
	}
}
