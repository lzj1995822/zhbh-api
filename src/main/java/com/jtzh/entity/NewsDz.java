package com.jtzh.entity;

import java.util.Date;

public class NewsDz {
    private Long id;

    private String bt;

    private String fj;

    private String nr;

    private String fm;

    private Date createTime;

    private Integer readNum;

    private Integer dzNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public String getFj() {
        return fj;
    }

    public void setFj(String fj) {
        this.fj = fj;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getDzNum() {
        return dzNum;
    }

    public void setDzNum(Integer dzNum) {
        this.dzNum = dzNum;
    }
}