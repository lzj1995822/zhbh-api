package com.jtzh.entity;

import java.util.Date;

public class NewsInf {
    private Integer id;

    private String title;

    private Date createTime;

    private String createId;

    private String releaseDep;

    private String content;

    private String enclosure;

    private Integer readNum;

    private String delflag;

    private String yhzh;

    private String state;
    private Integer needReceiveNum;
    private Integer hasReceiveNum;
    private Integer depNum;
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getReleaseDep() {
        return releaseDep;
    }

    public void setReleaseDep(String releaseDep) {
        this.releaseDep = releaseDep;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

	public Integer getNeedReceiveNum() {
		return needReceiveNum;
	}

	public void setNeedReceiveNum(Integer needReceiveNum) {
		this.needReceiveNum = needReceiveNum;
	}

	public Integer getHasReceiveNum() {
		return hasReceiveNum;
	}

	public void setHasReceiveNum(Integer hasReceiveNum) {
		this.hasReceiveNum = hasReceiveNum;
	}

	public Integer getDepNum() {
		return depNum;
	}

	public void setDepNum(Integer depNum) {
		this.depNum = depNum;
	}


    public String getUserName() {
        return userName;
    }

    public void UserName(String userName) {
        this.userName = userName;
    }

}