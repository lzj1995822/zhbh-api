package com.jtzh.entity;

import java.util.Date;

public class CharacterUserinfo {
    private Integer id;

    private Integer parentid;
    
    private String crolename;

    public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	private Integer versionno;

    private String transactionid;

    private String createby;

    private Date createon;

    private String updateby;

    private Date updateon;

    private String datalevel;

    private Integer isdeleted;

    private Integer ord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrolename() {
        return crolename;
    }

    public void setCrolename(String crolename) {
        this.crolename = crolename;
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
}