package com.jtzh.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkshopAdm {
	
	private Integer id;
	private String name;
	private String people;
	private String phone;
	private String yhzh;
	private String createId;
	private Date createTime;
	private String isdeleted;
	private String houseNumber;
	private String address;
	private String admX;
	private String admY;
	private String adminDivisionBelong;
	private String contactPersonName;
	private String contactPersonPhone;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date buildTime;
	private String landArea;
	private String buildArea;
	private String type;
	private String structure;
	private String productContent;
	private String sitePicture;
	private Integer countrysideId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmX() {
		return admX;
	}
	public void setAdmX(String admX) {
		this.admX = admX;
	}
	public String getAdmY() {
		return admY;
	}
	public void setAdmY(String admY) {
		this.admY = admY;
	}
	public String getAdminDivisionBelong() {
		return adminDivisionBelong;
	}
	public void setAdminDivisionBelong(String adminDivisionBelong) {
		this.adminDivisionBelong = adminDivisionBelong;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getContactPersonPhone() {
		return contactPersonPhone;
	}
	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getLandArea() {
		return landArea;
	}
	public void setLandArea(String landArea) {
		this.landArea = landArea;
	}
	public String getBuildArea() {
		return buildArea;
	}
	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getSitePicture() {
		return sitePicture;
	}
	public void setSitePicture(String sitePicture) {
		this.sitePicture = sitePicture;
	}
	public Integer getCountrysideId() {
		return countrysideId;
	}
	public void setCountrysideId(Integer countrysideId) {
		this.countrysideId = countrysideId;
	}
}
