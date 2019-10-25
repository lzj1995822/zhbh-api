package com.jtzh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RealTimeLocation
{
    private Long ID;
    private Long userID;
    private Double lon;
    private Double lat;
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date moment;

    public Long getID()
    {
        return this.ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public Long getUserID()
    {
        return this.userID;
    }

    public void setUserID(Long userID)
    {
        this.userID = userID;
    }

    public Double getLon()
    {
        return this.lon;
    }

    public void setLon(Double lon)
    {
        this.lon = lon;
    }

    public Double getLat()
    {
        return this.lat;
    }

    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Date getMoment()
    {
        return this.moment;
    }

    public void setMoment(Date moment)
    {
        this.moment = moment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
