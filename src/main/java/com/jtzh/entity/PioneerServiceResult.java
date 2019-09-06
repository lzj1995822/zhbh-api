package com.jtzh.entity;

import java.util.Date;

public class PioneerServiceResult {
    private Long id;

    private Long hdid;

    private String hdmc;

    private String zyzwth;

    private String fwdxpj;

    private Date createTime;

    private String delflag;

    private String nr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHdid() {
        return hdid;
    }

    public void setHdid(Long hdid) {
        this.hdid = hdid;
    }

    public String getHdmc() {
        return hdmc;
    }

    public void setHdmc(String hdmc) {
        this.hdmc = hdmc;
    }

    public String getZyzwth() {
        return zyzwth;
    }

    public void setZyzwth(String zyzwth) {
        this.zyzwth = zyzwth;
    }

    public String getFwdxpj() {
        return fwdxpj;
    }

    public void setFwdxpj(String fwdxpj) {
        this.fwdxpj = fwdxpj;
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

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }
}