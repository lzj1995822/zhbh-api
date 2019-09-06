package com.jtzh.entity;

import java.util.Date;

public class GovmgtWork {
	private String id;

    private String workType;

    private String workContent;
    
    private String workEnclosure;

    private String attachmentSource;

    private String workTitle;

    private Date createTime;

    private String createName;

    private String delflag;

	private String workNumber;

	private String workState;

	private String depName;

	private String workPolicyType;

	private String yhzh;

	private String createId;
	
	

	public String getWorkEnclosure() {
		return workEnclosure;
	}

	public void setWorkEnclosure(String workEnclosure) {
		this.workEnclosure = workEnclosure;
	}

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getWorkPolicyType() {
		return workPolicyType;
	}

	public void setWorkPolicyType(String workPolicyType) {
		this.workPolicyType = workPolicyType;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getAttachmentSource() {
        return attachmentSource;
    }

    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

}