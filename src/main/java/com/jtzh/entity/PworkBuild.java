package com.jtzh.entity;

import java.util.Date;

public class PworkBuild {
	private String id;

    private String pworkTitle;

    private String delflag;

    private String enclosure;

    private Date createTime;

    private String pworkType;

	private String pworkOrigin;

	private String pworkNumber;

	private String yhzh;
	private String createId;
	private String pworkContent;

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getPworkNumber() {
		return pworkNumber;
	}

	public void setPworkNumber(String pworkNumber) {
		this.pworkNumber = pworkNumber;
	}

	public String getPworkOrigin() {
		return pworkOrigin;
	}

	public void setPworkOrigin(String pworkOrigin) {
		this.pworkOrigin = pworkOrigin;
	}

	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getPworkTitle() {
        return pworkTitle;
    }

    public void setPworkTitle(String pworkTitle) {
        this.pworkTitle = pworkTitle;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPworkType() {
        return pworkType;
    }

    public void setPworkType(String pworkType) {
        this.pworkType = pworkType;
    }

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getPworkContent() {
		return pworkContent;
	}

	public void setPworkContent(String pworkContent) {
		this.pworkContent = pworkContent;
	}

}