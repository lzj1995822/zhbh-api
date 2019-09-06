package com.jtzh.entity;

import java.util.Date;

public class KeyproInfoDelivery {
	private String id;

    private String infoTitle;

    private String infoDes;

    private String infoPicType;

    private String attachmentSource;

    private Date createTime;

    private Date updateTime;

    private String delflag;

    private String createName;

    private String createId;

    private String yhzh;

	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoDes() {
        return infoDes;
    }

    public void setInfoDes(String infoDes) {
        this.infoDes = infoDes;
    }

    public String getInfoPicType() {
        return infoPicType;
    }

    public void setInfoPicType(String infoPicType) {
        this.infoPicType = infoPicType;
    }

    public String getAttachmentSource() {
        return attachmentSource;
    }

    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }
}