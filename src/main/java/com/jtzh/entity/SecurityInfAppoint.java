package com.jtzh.entity;

import java.util.Date;

public class SecurityInfAppoint {
    private Integer id;

    private Integer newsId;

    private Integer securityCommitteeId;

    private Integer countrysideId;

    private String countrysideName;

    private Date createTime;

    private String createId;

    private String delflag;

    private String yhzh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getSecurityCommitteeId() {
        return securityCommitteeId;
    }

    public void setSecurityCommitteeId(Integer securityCommitteeId) {
        this.securityCommitteeId = securityCommitteeId;
    }

    public Integer getCountrysideId() {
        return countrysideId;
    }

    public void setCountrysideId(Integer countrysideId) {
        this.countrysideId = countrysideId;
    }

    public String getCountrysideName() {
        return countrysideName;
    }

    public void setCountrysideName(String countrysideName) {
        this.countrysideName = countrysideName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
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
}