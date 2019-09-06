package com.jtzh.entity;

import java.util.Date;

public class RoadProtectionRecord {
    private Long id;

    private String recordNumber;

    private String recordNature;

    private String establishTime;

    private String crimePeople;

    private String escapePeople;

    private String recordDescription;

    private String attachmentSource;

    private Long roadId;

    private String recordType;

    private String delflag;

    private Date createTime;

    private String createId;

    private String yhzh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getRecordNature() {
        return recordNature;
    }

    public void setRecordNature(String recordNature) {
        this.recordNature = recordNature;
    }

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime;
    }

    public String getCrimePeople() {
        return crimePeople;
    }

    public void setCrimePeople(String crimePeople) {
        this.crimePeople = crimePeople;
    }

    public String getEscapePeople() {
        return escapePeople;
    }

    public void setEscapePeople(String escapePeople) {
        this.escapePeople = escapePeople;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }

    public String getAttachmentSource() {
        return attachmentSource;
    }

    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource;
    }

    public Long getRoadId() {
        return roadId;
    }

    public void setRoadId(Long roadId) {
        this.roadId = roadId;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }
}