package com.jtzh.pojo;

import java.util.List;

public class TreeParam {
	private String name;
	private String id;
	private String departName;
	private String photo;
	private List<TreeParam> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public List<TreeParam> getChildren() {
		return children;
	}

	public void setChildren(List<TreeParam> children) {
		this.children = children;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDepartName() {
		return departName;
	}

}
