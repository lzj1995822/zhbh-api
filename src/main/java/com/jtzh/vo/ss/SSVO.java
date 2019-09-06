/*     */ package com.jtzh.vo.ss;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class SSVO
/*     */ {
/*     */   private Long ssEventID;
/*     */   private String ssEventName;
/*     */   private Integer ssEventKind;
/*     */   private String ssEventTypeName;
/*     */   private String ssEventContent;
/*     */   private Date ssEventStartDateTime;
/*     */   private Date ssEventEndDateTime;
/*     */   private Double ssEventHappenLongitude;
/*     */   private Double ssEventHappenLatitude;
/*     */   private String ssEventStatusTypeName;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private String currentResponsiblePersonName;
/*     */   private String currentResponsiblePersonContact;
/*     */   private String netGridName;
/*     */   private String realName;
/*     */   private String dept;
/*     */   private String mobileTel;
/*     */   
/*     */   public Long getSsEventID()
/*     */   {
/*  30 */     return this.ssEventID;
/*     */   }
/*     */   
/*     */   public void setSsEventID(Long ssEventID) {
/*  34 */     this.ssEventID = ssEventID;
/*     */   }
/*     */   
/*     */   public String getSsEventName() {
/*  38 */     return this.ssEventName;
/*     */   }
/*     */   
/*     */   public void setSsEventName(String ssEventName) {
/*  42 */     this.ssEventName = ssEventName;
/*     */   }
/*     */   
/*     */   public Integer getSsEventKind() {
/*  46 */     return this.ssEventKind;
/*     */   }
/*     */   
/*     */   public void setSsEventKind(Integer ssEventKind) {
/*  50 */     this.ssEventKind = ssEventKind;
/*     */   }
/*     */   
/*     */   public String getSsEventTypeName() {
/*  54 */     return this.ssEventTypeName;
/*     */   }
/*     */   
/*     */   public void setSsEventTypeName(String ssEventTypeName) {
/*  58 */     this.ssEventTypeName = ssEventTypeName;
/*     */   }
/*     */   
/*     */   public String getSsEventContent() {
/*  62 */     return this.ssEventContent;
/*     */   }
/*     */   
/*     */   public void setSsEventContent(String ssEventContent) {
/*  66 */     this.ssEventContent = ssEventContent;
/*     */   }
/*     */   
/*     */   public Date getSsEventStartDateTime() {
/*  70 */     return this.ssEventStartDateTime;
/*     */   }
/*     */   
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public void setSsEventStartDateTime(Date ssEventStartDateTime) {
/*  75 */     this.ssEventStartDateTime = ssEventStartDateTime;
/*     */   }
/*     */   
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getSsEventEndDateTime() {
/*  80 */     return this.ssEventEndDateTime;
/*     */   }
/*     */   
/*     */   public void setSsEventEndDateTime(Date ssEventEndDateTime) {
/*  84 */     this.ssEventEndDateTime = ssEventEndDateTime;
/*     */   }
/*     */   
/*     */   public Double getSsEventHappenLongitude() {
/*  88 */     return this.ssEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setSsEventHappenLongitude(Double ssEventHappenLongitude) {
/*  92 */     this.ssEventHappenLongitude = ssEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getSsEventHappenLatitude() {
/*  96 */     return this.ssEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setSsEventHappenLatitude(Double ssEventHappenLatitude) {
/* 100 */     this.ssEventHappenLatitude = ssEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getSsEventStatusTypeName() {
/* 104 */     return this.ssEventStatusTypeName;
/*     */   }
/*     */   
/*     */   public void setSsEventStatusTypeName(String ssEventStatusTypeName) {
/* 108 */     this.ssEventStatusTypeName = ssEventStatusTypeName;
/*     */   }
/*     */   
/*     */   public String getCurrentRemarks() {
/* 112 */     return this.currentRemarks;
/*     */   }
/*     */   
/*     */   public void setCurrentRemarks(String currentRemarks) {
/* 116 */     this.currentRemarks = currentRemarks;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonCertID() {
/* 120 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID) {
/* 124 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonName() {
/* 128 */     return this.currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonName(String currentResponsiblePersonName) {
/* 132 */     this.currentResponsiblePersonName = currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonContact() {
/* 136 */     return this.currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonContact(String currentResponsiblePersonContact) {
/* 140 */     this.currentResponsiblePersonContact = currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public String getNetGridName() {
/* 144 */     return this.netGridName;
/*     */   }
/*     */   
/*     */   public void setNetGridName(String netGridName) {
/* 148 */     this.netGridName = netGridName;
/*     */   }
/*     */   
/*     */   public String getRealName() {
/* 152 */     return this.realName;
/*     */   }
/*     */   
/*     */   public void setRealName(String realName) {
/* 156 */     this.realName = realName;
/*     */   }
/*     */   
/*     */   public String getDept() {
/* 160 */     return this.dept;
/*     */   }
/*     */   
/*     */   public void setDept(String dept) {
/* 164 */     this.dept = dept;
/*     */   }
/*     */   
/*     */   public String getMobileTel() {
/* 168 */     return this.mobileTel;
/*     */   }
/*     */   
/*     */   public void setMobileTel(String mobileTel) {
/* 172 */     this.mobileTel = mobileTel;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\ss\SSVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */