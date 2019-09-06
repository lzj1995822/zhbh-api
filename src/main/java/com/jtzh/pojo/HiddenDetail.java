package com.jtzh.pojo;

import java.util.List;

import com.jtzh.entity.HiddenDanger;
import com.jtzh.entity.SecuritySource;

public class HiddenDetail {
	
	private HiddenDanger hiddenDanger;
	private List<SecuritySource> source;

	public HiddenDanger getHiddenDanger() {
		return hiddenDanger;
	}
	public void setHiddenDanger(HiddenDanger hiddenDanger) {
		this.hiddenDanger = hiddenDanger;
	}
	public List<SecuritySource> getSource() {
		return source;
	}
	public void setSource(List<SecuritySource> source) {
		this.source = source;
	}

}
