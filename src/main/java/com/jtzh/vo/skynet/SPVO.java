/*     */ package com.jtzh.vo.skynet;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SPVO
/*     */ {
/*     */   private Long spEventID;
/*     */   private String spEventName;
/*     */   private Integer spEventKind;
/*     */   private String spEventTypeName;
/*     */   private String spEventContent;
/*     */   private Date spEventStartDateTime;
/*     */   private Date spEventEndDateTime;
/*     */   private Double spEventHappenLongitude;
/*     */   private Double spEventHappenLatitude;
/*     */   private String spEventStatusTypeName;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private String currentResponsiblePersonName;
/*     */   private String currentResponsiblePersonContact;
/*     */   private String netGridName;
/*     */   private String realName;
/*     */   private String dept;
/*     */   private String mobileTel;
/*     */   
/*     */   public Long getSpEventID()
/*     */   {
/*  29 */     return this.spEventID;
/*     */   }
/*     */   
/*     */   public void setSpEventID(Long spEventID) {
/*  33 */     this.spEventID = spEventID;
/*     */   }
/*     */   
/*     */   public String getSpEventName() {
/*  37 */     return this.spEventName;
/*     */   }
/*     */   
/*     */   public void setSpEventName(String spEventName) {
/*  41 */     this.spEventName = spEventName;
/*     */   }
/*     */   
/*     */   public Integer getSpEventKind() {
/*  45 */     return this.spEventKind;
/*     */   }
/*     */   
/*     */   public void setSpEventKind(Integer spEventKind) {
/*  49 */     this.spEventKind = spEventKind;
/*     */   }
/*     */   
/*     */   public String getSpEventTypeName() {
/*  53 */     return this.spEventTypeName;
/*     */   }
/*     */   
/*     */   public void setSpEventTypeName(String spEventTypeName) {
/*  57 */     this.spEventTypeName = spEventTypeName;
/*     */   }
/*     */   
/*     */   public String getSpEventContent() {
/*  61 */     return this.spEventContent;
/*     */   }
/*     */   
/*     */   public void setSpEventContent(String spEventContent) {
/*  65 */     this.spEventContent = spEventContent;
/*     */   }
/*     */   
/*     */   @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getSpEventStartDateTime() {
/*  71 */     return this.spEventStartDateTime;
/*     */   }
/*     */   
/*     */   public void setSpEventStartDateTime(Date spEventStartDateTime) {
/*  75 */     this.spEventStartDateTime = spEventStartDateTime;
/*     */   }
/*     */   
/*     */   public Date getSpEventEndDateTime() {
/*  79 */     return this.spEventEndDateTime;
/*     */   }
/*     */   
/*     */   public void setSpEventEndDateTime(Date spEventEndDateTime) {
/*  83 */     this.spEventEndDateTime = spEventEndDateTime;
/*     */   }
/*     */   
/*     */   public Double getSpEventHappenLongitude() {
/*  87 */     return this.spEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setSpEventHappenLongitude(Double spEventHappenLongitude) {
/*  91 */     this.spEventHappenLongitude = spEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getSpEventHappenLatitude() {
/*  95 */     return this.spEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setSpEventHappenLatitude(Double spEventHappenLatitude) {
/*  99 */     this.spEventHappenLatitude = spEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getSpEventStatusTypeName() {
/* 103 */     return this.spEventStatusTypeName;
/*     */   }
/*     */   
/*     */   public void setSpEventStatusTypeName(String spEventStatusTypeName) {
/* 107 */     this.spEventStatusTypeName = spEventStatusTypeName;
/*     */   }
/*     */   
/*     */   public String getCurrentRemarks() {
/* 111 */     return this.currentRemarks;
/*     */   }
/*     */   
/*     */   public void setCurrentRemarks(String currentRemarks) {
/* 115 */     this.currentRemarks = currentRemarks;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonCertID() {
/* 119 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID) {
/* 123 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonName() {
/* 127 */     return this.currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonName(String currentResponsiblePersonName) {
/* 131 */     this.currentResponsiblePersonName = currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonContact() {
/* 135 */     return this.currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonContact(String currentResponsiblePersonContact) {
/* 139 */     this.currentResponsiblePersonContact = currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public String getNetGridName() {
/* 143 */     return this.netGridName;
/*     */   }
/*     */   
/*     */   public void setNetGridName(String netGridName) {
/* 147 */     this.netGridName = netGridName;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 151 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 155 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getDept() {
/* 159 */     return this.dept;
/*     */   }
/*     */   
/*     */   public void setDept(String dept) {
/* 163 */     this.dept = dept;
/*     */   }
/*     */   
/*     */   public String getMobileTel() {
/* 167 */     return this.mobileTel;
/*     */   }
/*     */   
/*     */   public void setMobileTel(String mobileTel) {
/* 171 */     this.mobileTel = mobileTel;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\skynet\SPVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */