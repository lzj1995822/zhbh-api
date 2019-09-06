package com.jtzh.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PioneerVolunteerServiceE {
    private Long id;

    private String hdmc;

    private String hdsj;

    private String hddz;

    private String fwdx;
    private String bmkssj;
    private String bmjssj;

    private String fwlb;

    private String zyzbz;

    private String hdgs;
    private Date createTime;

    private String delflag;
    
    private String sfjs;
    
    

    public String getSfjs() {
		return sfjs;
	}

	public void setSfjs(String sfjs) {
		this.sfjs = sfjs;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHdmc() {
        return hdmc;
    }

    public void setHdmc(String hdmc) {
        this.hdmc = hdmc;
    }

    public String getHdsj() {
        return hdsj;
    }

    public void setHdsj(String hdsj) {
        this.hdsj = hdsj;
    }

    public String getHddz() {
        return hddz;
    }

    public void setHddz(String hddz) {
        this.hddz = hddz;
    }

    public String getFwdx() {
        return fwdx;
    }

    public void setFwdx(String fwdx) {
        this.fwdx = fwdx;
    }



    public String getFwlb() {
        return fwlb;
    }

    public void setFwlb(String fwlb) {
        this.fwlb = fwlb;
    }

    public String getZyzbz() {
        return zyzbz;
    }

    public void setZyzbz(String zyzbz) {
        this.zyzbz = zyzbz;
    }

    public String getHdgs() {
        return hdgs;
    }

    public void setHdgs(String hdgs) {
        this.hdgs = hdgs;
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

    public String getBmkssj() {
        return bmkssj;
    }

    public void setBmkssj(String bmkssj) {
        this.bmkssj = bmkssj;
    }

    public String getBmjssj() {
        return bmjssj;
    }

    public void setBmjssj(String bmjssj) {
        this.bmjssj = bmjssj;
    }
}