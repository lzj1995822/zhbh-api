package com.jtzh.entity;

import java.util.Date;

public class PioneerSjxmHb {
    private Long id;

    private Long sjxmId;

    private String hbr;

    private String zw;

    private String xmssjzqk;

    private Date createTime;

    private String delflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSjxmId() {
        return sjxmId;
    }

    public void setSjxmId(Long sjxmId) {
        this.sjxmId = sjxmId;
    }

    public String getHbr() {
        return hbr;
    }

    public void setHbr(String hbr) {
        this.hbr = hbr;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getXmssjzqk() {
        return xmssjzqk;
    }

    public void setXmssjzqk(String xmssjzqk) {
        this.xmssjzqk = xmssjzqk;
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