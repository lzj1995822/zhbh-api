/*     */ package com.jtzh.entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ 
/*     */ public class SocietySecurityEvent
/*     */ {
/*     */   private Long ssEventID;
/*     */   private String ssEventName;
/*     */   private Integer ssEventKind;
/*     */   private String ssEventTypeValue;
/*     */   private String ssEventContent;
/*     */   private Date ssEventStartDateTime;
/*     */   private Date ssEventEndDateTime;
/*     */   private Double ssEventHappenLongitude;
/*     */   private Double ssEventHappenLatitude;
/*     */   private String ssEventStatusTypeValue;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private String currentResponsiblePersonName;
/*     */   private String currentResponsiblePersonContact;
/*     */   private Long netGridID;
/*     */   
/*     */   public Long getSsEventID()
/*     */   {
/*  27 */     return this.ssEventID;
/*     */   }
/*     */   
/*     */   public void setSsEventID(Long ssEventID) {
/*  31 */     this.ssEventID = ssEventID;
/*     */   }
/*     */   
/*     */   public String getSsEventName() {
/*  35 */     return this.ssEventName;
/*     */   }
/*     */   
/*     */   public void setSsEventName(String ssEventName) {
/*  39 */     this.ssEventName = ssEventName;
/*     */   }
/*     */   
/*     */   public Integer getSsEventKind() {
/*  43 */     return this.ssEventKind;
/*     */   }
/*     */   
/*     */   public void setSsEventKind(Integer ssEventKind) {
/*  47 */     this.ssEventKind = ssEventKind;
/*     */   }
/*     */   
/*     */   public String getSsEventTypeValue() {
/*  51 */     return this.ssEventTypeValue;
/*     */   }
/*     */   
/*     */   public void setSsEventTypeValue(String ssEventTypeValue) {
/*  55 */     this.ssEventTypeValue = ssEventTypeValue;
/*     */   }
/*     */   
/*     */   public String getSsEventContent() {
/*  59 */     return this.ssEventContent;
/*     */   }
/*     */   
/*     */   public void setSsEventContent(String ssEventContent) {
/*  63 */     this.ssEventContent = ssEventContent;
/*     */   }
/*     */   
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getSsEventStartDateTime() {
/*  69 */     return this.ssEventStartDateTime;
/*     */   }
/*     */   
/*     */   public void setSsEventStartDateTime(Date ssEventStartDateTime) {
/*  73 */     this.ssEventStartDateTime = ssEventStartDateTime;
/*     */   }
/*     */   
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getSsEventEndDateTime() {
/*  78 */     return this.ssEventEndDateTime;
/*     */   }
/*     */   
/*     */   public void setSsEventEndDateTime(Date ssEventEndDateTime) {
/*  82 */     this.ssEventEndDateTime = ssEventEndDateTime;
/*     */   }
/*     */   
/*     */   public Double getSsEventHappenLongitude() {
/*  86 */     return this.ssEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setSsEventHappenLongitude(Double ssEventHappenLongitude) {
/*  90 */     this.ssEventHappenLongitude = ssEventHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getSsEventHappenLatitude() {
/*  94 */     return this.ssEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setSsEventHappenLatitude(Double ssEventHappenLatitude) {
/*  98 */     this.ssEventHappenLatitude = ssEventHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getSsEventStatusTypeValue() {
/* 102 */     return this.ssEventStatusTypeValue;
/*     */   }
/*     */   
/*     */   public void setSsEventStatusTypeValue(String ssEventStatusTypeValue) {
/* 106 */     this.ssEventStatusTypeValue = ssEventStatusTypeValue;
/*     */   }
/*     */   
/*     */   public String getCurrentRemarks() {
/* 110 */     return this.currentRemarks;
/*     */   }
/*     */   
/*     */   public void setCurrentRemarks(String currentRemarks) {
/* 114 */     this.currentRemarks = currentRemarks;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonCertID() {
/* 118 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID) {
/* 122 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonName() {
/* 126 */     return this.currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonName(String currentResponsiblePersonName) {
/* 130 */     this.currentResponsiblePersonName = currentResponsiblePersonName;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonContact() {
/* 134 */     return this.currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonContact(String currentResponsiblePersonContact) {
/* 138 */     this.currentResponsiblePersonContact = currentResponsiblePersonContact;
/*     */   }
/*     */   
/*     */   public Long getNetGridID() {
/* 142 */     return this.netGridID;
/*     */   }
/*     */   
/*     */   public void setNetGridID(Long netGridID) {
/* 146 */     this.netGridID = netGridID;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\SocietySecurityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */