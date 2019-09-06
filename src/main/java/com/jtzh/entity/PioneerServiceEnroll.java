package com.jtzh.entity;

import java.util.Date;

public class PioneerServiceEnroll {
    private Long id;

    private Long hdid;

    private Long zyzid;

    private String zyzzh;

    private Date createTime;

    private String delflag;

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

    public Long getZyzid() {
        return zyzid;
    }

    public void setZyzid(Long zyzid) {
        this.zyzid = zyzid;
    }

    public String getZyzzh() {
        return zyzzh;
    }

    public void setZyzzh(String zyzzh) {
        this.zyzzh = zyzzh;
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