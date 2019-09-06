package com.jtzh.pojo;

import java.util.List;

public class MenuTree {
	private Integer id;
	private Integer pid;
	private String mCCaption;
	private String mCLink;
	private String dataLevel;
	private String hasPermission;
	private List<MenuTree> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getmCCaption() {
		return mCCaption;
	}
	public void setmCCaption(String mCCaption) {
		this.mCCaption = mCCaption;
	}
	public String getmCLink() {
		return mCLink;
	}
	public void setmCLink(String mCLink) {
		this.mCLink = mCLink;
	}
	public String getDataLevel() {
		return dataLevel;
	}
	public void setDataLevel(String dataLevel) {
		this.dataLevel = dataLevel;
	}
	public String getHasPermission() {
		return hasPermission;
	}
	public void setHasPermission(String hasPermission) {
		this.hasPermission = hasPermission;
	}
	public List<MenuTree> getChildren() {
		return children;
	}
	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}
	
}
