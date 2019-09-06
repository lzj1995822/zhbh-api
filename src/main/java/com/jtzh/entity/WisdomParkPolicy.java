package com.jtzh.entity;

import java.util.Date;

public class WisdomParkPolicy {
    private Integer id;

    private String policyName;

    private Date policyReleaseTime;

    private String policyReleaseDep;

    private String policyIntro;

    private String policyEnclosure;

    private String isDeleted;

    private Date createTime;

    private String createId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Date getPolicyReleaseTime() {
        return policyReleaseTime;
    }

    public void setPolicyReleaseTime(Date policyReleaseTime) {
        this.policyReleaseTime = policyReleaseTime;
    }

    public String getPolicyReleaseDep() {
        return policyReleaseDep;
    }

    public void setPolicyReleaseDep(String policyReleaseDep) {
        this.policyReleaseDep = policyReleaseDep;
    }

    public String getPolicyIntro() {
        return policyIntro;
    }

    public void setPolicyIntro(String policyIntro) {
        this.policyIntro = policyIntro;
    }

    public String getPolicyEnclosure() {
        return policyEnclosure;
    }

    public void setPolicyEnclosure(String policyEnclosure) {
        this.policyEnclosure = policyEnclosure;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
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
}