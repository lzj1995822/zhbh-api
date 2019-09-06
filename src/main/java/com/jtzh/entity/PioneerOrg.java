package com.jtzh.entity;

import java.util.Date;

public class PioneerOrg {
    private Integer id;

    private String orgNumber;

    private String partyCommittee;

    private String orgName;

    private String orgLevel;

    private String orgNature;

    private String branchSecretary;

    private Date createTime;

    private String delflag;

    private String yhzh;

    private Integer superiorId;

    private String leaderSex;

    private String leaderPhone;

	private String createId;

	private String lat;

	private String lon;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getPartyCommittee() {
        return partyCommittee;
    }

    public void setPartyCommittee(String partyCommittee) {
        this.partyCommittee = partyCommittee;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgNature() {
        return orgNature;
    }

    public void setOrgNature(String orgNature) {
        this.orgNature = orgNature;
    }

    public String getBranchSecretary() {
        return branchSecretary;
    }

    public void setBranchSecretary(String branchSecretary) {
        this.branchSecretary = branchSecretary;
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

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    public String getLeaderSex() {
        return leaderSex;
    }

    public void setLeaderSex(String leaderSex) {
        this.leaderSex = leaderSex;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}