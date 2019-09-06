package com.jtzh.detail.pojo;

import java.util.List;

import com.jtzh.entity.KeyproInformation;
import com.jtzh.entity.KeyproPro;
import com.jtzh.entity.KeyproSource;

public class KeyproBuildDetail {
	private KeyproPro pro;
	private KeyproInformation designInfo;
	private KeyproInformation surveyInfo;
	private KeyproInformation buildInfo;
	private KeyproInformation constructionInfo;
	private KeyproInformation supervisorInfo;
	private List<KeyproSource> source;

	public KeyproPro getPro() {
		return pro;
	}

	public void setPro(KeyproPro pro) {
		this.pro = pro;
	}

	public KeyproInformation getDesignInfo() {
		return designInfo;
	}

	public void setDesignInfo(KeyproInformation designInfo) {
		this.designInfo = designInfo;
	}

	public KeyproInformation getSurveyInfo() {
		return surveyInfo;
	}

	public void setSurveyInfo(KeyproInformation surveyInfo) {
		this.surveyInfo = surveyInfo;
	}

	public KeyproInformation getBuildInfo() {
		return buildInfo;
	}

	public void setBuildInfo(KeyproInformation buildInfo) {
		this.buildInfo = buildInfo;
	}

	public KeyproInformation getConstructionInfo() {
		return constructionInfo;
	}

	public void setConstructionInfo(KeyproInformation constructionInfo) {
		this.constructionInfo = constructionInfo;
	}

	public KeyproInformation getSupervisorInfo() {
		return supervisorInfo;
	}

	public void setSupervisorInfo(KeyproInformation supervisorInfo) {
		this.supervisorInfo = supervisorInfo;
	}

	public List<KeyproSource> getSource() {
		return source;
	}

	public void setSource(List<KeyproSource> source) {
		this.source = source;
	}

}
