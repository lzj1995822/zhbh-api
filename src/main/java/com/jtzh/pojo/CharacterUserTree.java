package com.jtzh.pojo;

import java.util.List;

public class CharacterUserTree {
	private Integer id;
	private String cRoleName;
	private String dataLevel;
	private List<CharacterUserTree> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getcRoleName() {
		return cRoleName;
	}
	public void setcRoleName(String cRoleName) {
		this.cRoleName = cRoleName;
	}
	public String getDataLevel() {
		return dataLevel;
	}
	public void setDataLevel(String dataLevel) {
		this.dataLevel = dataLevel;
	}
	public List<CharacterUserTree> getChildren() {
		return children;
	}
	public void setChildren(List<CharacterUserTree> children) {
		this.children = children;
	}
	
}
