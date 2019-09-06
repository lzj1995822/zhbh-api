/*     */ package com.jtzh.entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SkynetPatrolEvent
/*     */ {
/*     */   private Long spEventID;
/*     */   private String spEventName;
/*     */   private Integer spEventKind;
/*     */   private String spEventTypeValue;
/*     */   private String spEventContent;
/*     */   private Date spEventStartDateTime;
/*     */   private Date spEventEndDateTime;
/*     */   private Double spEventHappenLongitude;
/*     */   private Double spEventHappenLatitude;
/*     */   private String spEventStatusTypeValue;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private String currentResponsiblePersonName;
/*     */   private String currentResponsiblePersonContact;
/*     */   private Long netGridID;
/*     */   
/*     */   public Long getSpEventID()
/*     */   {
/*  26 */     return this.spEventID;
/*     */   }
/*     */   
/*     */   public void setSpEventID(Long spEventID) {
/*  30 */     this.spEventID = spEventID;
/*     */   }
/*     */   
/*     */   public String getSpEventName() {
/*  34 */     return this.spEventName;
/*     */   }
/*     */   
/*     */   public void setSpEventName(String spEventName) {
/*  38 */     this.spEventName = spEventName;
/*     */   }
/*     */   
/*     */   public Integer getSpEventKind() {
/*  42 */     return this.spEventKind;
/*     */   }
/*     */   
/*     */   public void setSpEventKind(Integer spEventKind) {
/*  46 */     this.spEventKind = spEventKind;
/*     */   }
/*     */   
/*     */   public String getSpEventTypeValue() {
/*  50 */     return this.spEventTypeValue;
/*     */   }
/*     */   
/*     */   public void setSpEventTypeValue(String spEventTypeValue) {
/*  54 */     this.spEventTypeValue = spEventTypeValue;
/*     */   }
/*     */   
/*     */   public String getSpEventContent() {
/*  58 */     return this.spEventContent;
/*     */   }
/*     */   
/*     */   public void setSpEventContent(String spEventContent) {
/*  62 */     this.spEventContent = spEventContent;
/*     */   }
/*     */   
/*     */   @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getSpEventStartDateTime() {
/*  68 */     return this.spEventStartDateTime;
/*     */   }
/*     */   
/*     */   public void setSpEventStartDateTime(Date spEventStartDateTime) {
/*  72 */     this.spEventStartDateTime = spEventStartDateTime;
/*     */   }
/*     */   
/*     */   public Date getSpEventEndDateTime() {
/*  76 */     return this.spEventEndDateTime;
/*     */   }
/*     */   
/*     */   public void setSpEventEndDateTime(Date spEventEndDateTime) {
/*  80 */     this.spEventEndDateTime = spEventEndDateTime;
/*     */   }
/*     */   
/*     */   public Double getSpEventHappenLongitude() {
/*  84 */     return this.spEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setSpEventHappenLongitude(Double spEventHappenLongitude) {
/*  88 */     this.spEventHappenLongitude = spEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getSpEventHappenLatitude() {
/*  92 */     return this.spEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setSpEventHappenLatitude(Double spEventHappenLatitude) {
/*  96 */     this.spEventHappenLatitude = spEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getSpEventStatusTypeValue() {
/* 100 */     return this.spEventStatusTypeValue;
/*     */   }
/*     */   
/*     */   public void setSpEventStatusTypeValue(String spEventStatusTypeValue) {
/* 104 */     this.spEventStatusTypeValue = spEventStatusTypeValue;
/*     */   }
/*     */   
/*     */   public String getCurrentRemarks() {
/* 108 */     return this.currentRemarks;
/*     */   }
/*     */   
/*     */   public void setCurrentRemarks(String currentRemarks) {
/* 112 */     this.currentRemarks = currentRemarks;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonCertID() {
/* 116 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID) {
/* 120 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonName() {
/* 124 */     return this.currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonName(String currentResponsiblePersonName) {
/* 128 */     this.currentResponsiblePersonName = currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonContact() {
/* 132 */     return this.currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonContact(String currentResponsiblePersonContact) {
/* 136 */     this.currentResponsiblePersonContact = currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public Long getNetGridID() {
/* 140 */     return this.netGridID;
/*     */   }
/*     */   
/*     */   public void setNetGridID(Long netGridID) {
/* 144 */     this.netGridID = netGridID;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\SkynetPatrolEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */