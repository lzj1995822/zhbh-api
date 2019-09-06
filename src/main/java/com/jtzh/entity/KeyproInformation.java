package com.jtzh.entity;

import java.util.Date;

public class KeyproInformation {
	private String id;

    private String informationCompanyName;

    private String informationSiteLeader;

    private String informationPhoneNumber;

    private String informationType;

    private Date createTime;

    private String delflag;

    private String createName;

	private String sourceId;

	private String yhzh;

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getInformationCompanyName() {
        return informationCompanyName;
    }

    public void setInformationCompanyName(String informationCompanyName) {
        this.informationCompanyName = informationCompanyName;
    }

    public String getInformationSiteLeader() {
        return informationSiteLeader;
    }

    public void setInformationSiteLeader(String informationSiteLeader) {
        this.informationSiteLeader = informationSiteLeader;
    }

    public String getInformationPhoneNumber() {
        return informationPhoneNumber;
    }

    public void setInformationPhoneNumber(String informationPhoneNumber) {
        this.informationPhoneNumber = informationPhoneNumber;
    }

    public String getInformationType() {
        return informationType;
    }

    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}