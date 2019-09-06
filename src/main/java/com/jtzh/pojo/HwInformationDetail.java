package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.HwInformation;
import com.jtzh.entity.HwSource;

public class HwInformationDetail {
	
	private HwInformation hwInformation;
	private List<HwSource> source;
	
	public HwInformation getHwInformation() {
		return hwInformation;
	}
	public void setHwInformation(HwInformation hwInformation) {
		this.hwInformation = hwInformation;
	}
	public List<HwSource> getSource() {
		return source;
	}
	public void setSource(List<HwSource> source) {
		this.source = source;
	}

}
