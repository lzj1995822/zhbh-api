package com.jtzh.entity;

import java.util.Date;

public class KeyproDep {
    private Integer id;

    private String depName;

    private String depLeader;

    private String phoneNumber;

    private String depAddress;

    private String workContent;

    private Date createTime;

    private String delflag;

	private String yhzh;

	private String createId;
	
	private String depLinkman;
	
	private String linkmanPhone;
	
	private String depX;
	
	private String depY;

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepLeader() {
        return depLeader;
    }

    public void setDepLeader(String depLeader) {
        this.depLeader = depLeader;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepAddress() {
        return depAddress;
    }

    public void setDepAddress(String depAddress) {
        this.depAddress = depAddress;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
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

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getDepLinkman() {
		return depLinkman;
	}

	public void setDepLinkman(String depLinkman) {
		this.depLinkman = depLinkman;
	}

	public String getLinkmanPhone() {
		return linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	public String getDepX() {
		return depX;
	}

	public void setDepX(String depX) {
		this.depX = depX;
	}

	public String getDepY() {
		return depY;
	}

	public void setDepY(String depY) {
		this.depY = depY;
	}
	
	

}