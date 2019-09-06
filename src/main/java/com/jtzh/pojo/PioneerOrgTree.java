package com.jtzh.pojo;

import java.util.List;

public class PioneerOrgTree {
	private String name;
	private String id;
	private String departName;
	private String orgLevel;
	private List<PioneerOrgTree> children;

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

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	public List<PioneerOrgTree> getChildren() {
		return children;
	}

	public void setChildren(List<PioneerOrgTree> children) {
		this.children = children;
	}

}
