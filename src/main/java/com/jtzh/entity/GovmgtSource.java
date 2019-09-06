package com.jtzh.entity;

import java.util.Date;

public class GovmgtSource {
	private String id;

    private String attachmentSource;

	private String sourceId;

    private String fileType;

    private String fileName;

    private String fileUrl;

	private Date createTime;

    private String delflag;

	private String yhzh;

	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}

	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getAttachmentSource() {
        return attachmentSource;
    }

    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource;
    }

	public String getSourceId() {
        return sourceId;
    }

	public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
}