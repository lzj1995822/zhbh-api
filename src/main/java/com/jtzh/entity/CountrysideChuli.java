package com.jtzh.entity;

import java.util.Date;

public class CountrysideChuli {
	
	private Integer id;
	private Integer shangbaoid;
	private String chuliren; // 处理人
	private Date chulitime; // 处理时间
	private String chulimiaoshu; // 处理描述
	private String shenheren; // 审核人
	private Date shenhetime; // 审核时间
	private String shenhemiaoshu; // 审核描述
	private String shenheState;
	private String attachmentSource;
	private String createId;
	private Date createTime;
	private String delflag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShangbaoid() {
		return shangbaoid;
	}
	public void setShangbaoid(Integer shangbaoid) {
		this.shangbaoid = shangbaoid;
	}
	public String getChuliren() {
		return chuliren;
	}
	public void setChuliren(String chuliren) {
		this.chuliren = chuliren;
	}
	public Date getChulitime() {
		return chulitime;
	}
	public void setChulitime(Date chulitime) {
		this.chulitime = chulitime;
	}
	public String getChulimiaoshu() {
		return chulimiaoshu;
	}
	public void setChulimiaoshu(String chulimiaoshu) {
		this.chulimiaoshu = chulimiaoshu;
	}
	public String getShenheren() {
		return shenheren;
	}
	public void setShenheren(String shenheren) {
		this.shenheren = shenheren;
	}
	public Date getShenhetime() {
		return shenhetime;
	}
	public void setShenhetime(Date shenhetime) {
		this.shenhetime = shenhetime;
	}
	public String getShenhemiaoshu() {
		return shenhemiaoshu;
	}
	public void setShenhemiaoshu(String shenhemiaoshu) {
		this.shenhemiaoshu = shenhemiaoshu;
	}
	public String getAttachmentSource() {
		return attachmentSource;
	}
	public void setAttachmentSource(String attachmentSource) {
		this.attachmentSource = attachmentSource;
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
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getShenheState() {
		return shenheState;
	}
	public void setShenheState(String shenheState) {
		this.shenheState = shenheState;
	}

}
