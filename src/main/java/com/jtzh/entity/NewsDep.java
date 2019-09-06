package com.jtzh.entity;

import java.util.Date;

public class NewsDep {
    private Integer id;

    private Integer newsId;

    private Integer depId;

    private String depName;

    private Date createTime;

    private String createId;

    private String delflag;

    private String yhzh;
    private Integer depNeedReceiveNum;
    private Integer depHasReceiveNum;
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

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
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

	public Integer getDepNeedReceiveNum() {
		return depNeedReceiveNum;
	}

	public void setDepNeedReceiveNum(Integer depNeedReceiveNum) {
		this.depNeedReceiveNum = depNeedReceiveNum;
	}

	public Integer getDepHasReceiveNum() {
		return depHasReceiveNum;
	}

	public void setDepHasReceiveNum(Integer depHasReceiveNum) {
		this.depHasReceiveNum = depHasReceiveNum;
	}
    
}