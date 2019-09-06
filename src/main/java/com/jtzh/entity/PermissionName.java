package com.jtzh.entity;
/**
 * 权限对应的角色、用户、菜单的中文名称类
 * @author JTZH
 *
 */
public class PermissionName {

	private Integer pid;
	private String mccaption;
	private String croleName;
	private String uiloginName;
	

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getMccaption() {
		return mccaption;
	}
	public void setMccaption(String mccaption) {
		this.mccaption = mccaption;
	}
	public String getCroleName() {
		return croleName;
	}
	public void setCroleName(String croleName) {
		this.croleName = croleName;
	}
	public String getUiloginName() {
		return uiloginName;
	}
	public void setUiloginName(String uiloginName) {
		this.uiloginName = uiloginName;
	}
	 
	
}
