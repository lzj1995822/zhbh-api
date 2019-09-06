package com.jtzh.entity;

import java.util.Date;

public class GovmgtOrgStructure {
    private Integer id;

    private String userName;

    private String phoneNumber;

    private String userLevel;

    private String userPosition;

    private String depName;

    private String delflag;

    private Date createTime;

    private Integer superiorId;

    private String superiorUserName;

    private String superiorDepName;

    private String userSex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    public String getSuperiorUserName() {
        return superiorUserName;
    }

    public void setSuperiorUserName(String superiorUserName) {
        this.superiorUserName = superiorUserName;
    }

    public String getSuperiorDepName() {
        return superiorDepName;
    }

    public void setSuperiorDepName(String superiorDepName) {
        this.superiorDepName = superiorDepName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}