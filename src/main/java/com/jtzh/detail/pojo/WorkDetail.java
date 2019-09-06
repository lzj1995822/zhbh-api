package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.GovmgtSource;
import com.jtzh.entity.GovmgtWork;

public class WorkDetail {
	private GovmgtWork work;
	private List<GovmgtSource> source;

	public GovmgtWork getWork() {
		return work;
	}

	public void setWork(GovmgtWork work) {
		this.work = work;
	}

	public List<GovmgtSource> getSource() {
		return source;
	}

	public void setSource(List<GovmgtSource> source) {
		this.source = source;
	}

}
