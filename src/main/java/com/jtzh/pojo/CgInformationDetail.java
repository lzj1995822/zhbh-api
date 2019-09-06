package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.CgInformation;
import com.jtzh.entity.CgSource;

public class CgInformationDetail {
	
	private CgInformation cgInformation;
	private List<CgSource> source;
	
	
	public CgInformation getCgInformation() {
		return cgInformation;
	}
	public void setCgInformation(CgInformation cgInformation) {
		this.cgInformation = cgInformation;
	}
	public List<CgSource> getSource() {
		return source;
	}
	public void setSource(List<CgSource> source) {
		this.source = source;
	}

}
