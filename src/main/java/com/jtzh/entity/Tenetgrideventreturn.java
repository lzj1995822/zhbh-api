package com.jtzh.entity;

import java.util.Date;

public class Tenetgrideventreturn {
    private Long id;

    private Long eventid;

    private String returnreason;

    private Date returntime;

    private String returndep;

    private String type;

    private String delflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public String getReturnreason() {
        return returnreason;
    }

    public void setReturnreason(String returnreason) {
        this.returnreason = returnreason;
    }

    public Date getReturntime() {
        return returntime;
    }

    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    public String getReturndep() {
        return returndep;
    }

    public void setReturndep(String returndep) {
        this.returndep = returndep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}