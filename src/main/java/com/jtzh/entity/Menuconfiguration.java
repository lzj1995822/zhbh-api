package com.jtzh.entity;

import java.util.Date;

public class Menuconfiguration {
    private Integer id;

    private String mccaption;

    private String mcparenttitle;

    private String mclink;

    private String mcmenutype;

    private Integer mcsequence;

    private String mcdisplayname;

    private String mcpicture;

    private Integer versionno;

    private String transactionid;

    private String createby;

    private Date createon;

    private String updateby;

    private Date updateon;

    private String datalevel;

    private Integer isdeleted;

    private Integer ord;
    
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMccaption() {
        return mccaption;
    }

    public void setMccaption(String mccaption) {
        this.mccaption = mccaption;
    }

    public String getMcparenttitle() {
        return mcparenttitle;
    }

    public void setMcparenttitle(String mcparenttitle) {
        this.mcparenttitle = mcparenttitle;
    }

    public String getMclink() {
        return mclink;
    }

    public void setMclink(String mclink) {
        this.mclink = mclink;
    }

    public String getMcmenutype() {
        return mcmenutype;
    }

    public void setMcmenutype(String mcmenutype) {
        this.mcmenutype = mcmenutype;
    }

    public Integer getMcsequence() {
        return mcsequence;
    }

    public void setMcsequence(Integer mcsequence) {
        this.mcsequence = mcsequence;
    }

    public String getMcdisplayname() {
        return mcdisplayname;
    }

    public void setMcdisplayname(String mcdisplayname) {
        this.mcdisplayname = mcdisplayname;
    }

    public String getMcpicture() {
        return mcpicture;
    }

    public void setMcpicture(String mcpicture) {
        this.mcpicture = mcpicture;
    }

    public Integer getVersionno() {
        return versionno;
    }

    public void setVersionno(Integer versionno) {
        this.versionno = versionno;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdateon() {
        return updateon;
    }

    public void setUpdateon(Date updateon) {
        this.updateon = updateon;
    }

    public String getDatalevel() {
        return datalevel;
    }

    public void setDatalevel(String datalevel) {
        this.datalevel = datalevel;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
    
}