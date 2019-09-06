/*     */ package com.jtzh.vo.netGrid;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ 
/*     */ public class NetGridEventDetailVO
/*     */ {
/*     */   private Long eventID;
/*     */   private String eventName;
/*     */   private Integer eventKind;
/*     */   private String eventTypeName;
/*     */   private String eventContent;
/*     */   private Date eventStartDateTime;
/*     */   private Date eventEndDateTime;
/*     */   private Double eventHappenLongitude;
/*     */   private Double eventHappenLatitude;
/*     */   private String eventStatusTypeName;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private String currentResponsiblePersonName;
/*     */   private String currentResponsiblePersonContact;
/*     */   private String netGridName;
/*     */   private String realName;
/*     */   private String dept;
/*     */   private String mobileTel;
/*     */   
/*     */   public Long getEventID()
/*     */   {
/*  30 */     return this.eventID;
/*     */   }
/*     */   
/*     */   public void setEventID(Long eventID) {
/*  34 */     this.eventID = eventID;
/*     */   }
/*     */   
/*     */   public String getEventName() {
/*  38 */     return this.eventName;
/*     */   }
/*     */   
/*     */   public void setEventName(String eventName) {
/*  42 */     this.eventName = eventName;
/*     */   }
/*     */   
/*     */   public Integer getEventKind() {
/*  46 */     return this.eventKind;
/*     */   }
/*     */   
/*     */   public void setEventKind(Integer eventKind) {
/*  50 */     this.eventKind = eventKind;
/*     */   }
/*     */   
/*     */   public String getEventTypeName() {
/*  54 */     return this.eventTypeName;
/*     */   }
/*     */   
/*     */   public void setEventTypeName(String eventTypeName) {
/*  58 */     this.eventTypeName = eventTypeName;
/*     */   }
/*     */   
/*     */   public String getEventContent() {
/*  62 */     return this.eventContent;
/*     */   }
/*     */   
/*     */   public void setEventContent(String eventContent) {
/*  66 */     this.eventContent = eventContent;
/*     */   }
/*     */   
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getEventStartDateTime() {
/*  72 */     return this.eventStartDateTime;
/*     */   }
/*     */   
/*     */   public void setEventStartDateTime(Date eventStartDateTime) {
/*  76 */     this.eventStartDateTime = eventStartDateTime;
/*     */   }
/*     */   
/*     */   public Date getEventEndDateTime() {
/*  80 */     return this.eventEndDateTime;
/*     */   }
/*     */   
/*     */   public void setEventEndDateTime(Date eventEndDateTime) {
/*  84 */     this.eventEndDateTime = eventEndDateTime;
/*     */   }
/*     */   
/*     */   public Double getEventHappenLongitude() {
/*  88 */     return this.eventHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setEventHappenLongitude(Double eventHappenLongitude) {
/*  92 */     this.eventHappenLongitude = eventHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getEventHappenLatitude() {
/*  96 */     return this.eventHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setEventHappenLatitude(Double eventHappenLatitude) {
/* 100 */     this.eventHappenLatitude = eventHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getEventStatusTypeName() {
/* 104 */     return this.eventStatusTypeName;
/*     */   }
/*     */   
/*     */   public void setEventStatusTypeName(String eventStatusTypeName) {
/* 108 */     this.eventStatusTypeName = eventStatusTypeName;
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


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\netGrid\NetGridEventDetailVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */