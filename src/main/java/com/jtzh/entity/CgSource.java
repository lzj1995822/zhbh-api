package com.jtzh.entity;

import java.util.Date;

public class CgSource {
	
	private Integer id;
	private String attachmentSource;
	private Integer sourceId;
	private String fileUrl;
	private String type;
	private Date createTime;
	private String delflag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAttachmentSource() {
		return attachmentSource;
	}
	public void setAttachmentSource(String attachmentSource) {
		this.attachmentSource = attachmentSource;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
