package com.jtzh.entity;

import java.util.Date;

public class CountrysideProblem {
	
	private Integer id;
	private String isdeleted; // 状态
	private String title; // 标题
	private String content; // 内容
	private String attachmentSource;
	private String type; // 类型
	private String address; // 地址
	private String shangbaoren; // 上报人
	private Date shangbaotime; // 上报时间
	private String lianren; // 立案人
	private Date liantime; // 立案时间
	private String paifaren; // 派发人
	private Date paifatime; // 派发时间
	private Date endtime; // 结束时间
	private String x;
	private String y;
	private String yhzh;
	private String createId;
	private Date createTime;
	private String delflag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
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
	public String getAttachmentSource() {
		return attachmentSource;
	}
	public void setAttachmentSource(String attachmentSource) {
		this.attachmentSource = attachmentSource;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShangbaoren() {
		return shangbaoren;
	}
	public void setShangbaoren(String shangbaoren) {
		this.shangbaoren = shangbaoren;
	}
	public Date getShangbaotime() {
		return shangbaotime;
	}
	public void setShangbaotime(Date shangbaotime) {
		this.shangbaotime = shangbaotime;
	}
	public String getLianren() {
		return lianren;
	}
	public void setLianren(String lianren) {
		this.lianren = lianren;
	}
	public Date getLiantime() {
		return liantime;
	}
	public void setLiantime(Date liantime) {
		this.liantime = liantime;
	}
	public String getPaifaren() {
		return paifaren;
	}
	public void setPaifaren(String paifaren) {
		this.paifaren = paifaren;
	}
	public Date getPaifatime() {
		return paifatime;
	}
	public void setPaifatime(Date paifatime) {
		this.paifatime = paifatime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
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
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
}
