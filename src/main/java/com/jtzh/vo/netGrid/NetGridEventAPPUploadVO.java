/*     */ package com.jtzh.vo.netGrid;
/*     */ import java.util.List;

import com.jtzh.entity.NetGridEventInvolvedPersons;
/*     */ 
/*     */ 
/*     */ public class NetGridEventAPPUploadVO
/*     */ {
/*     */   private String eventName;
/*     */   private Integer eventKind;
/*     */   private String eventTypeValue;
/*     */   private String eventContent;
/*     */   private String eventStartDateTime;
/*     */   private Double eventHappenLongitude;
/*     */   private Double eventHappenLatitude;
/*     */   private String eventStatusTypeValue;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private Long netGridID;
/*     */   private List<NetGridEventInvolvedPersons> involvedPersons;
/*     */   
/*     */   public String getEventName()
/*     */   {
/*  24 */     return this.eventName;
/*     */   }
/*     */   
/*     */   public void setEventName(String eventName) {
/*  28 */     this.eventName = eventName;
/*     */   }
/*     */   
/*     */   public Integer getEventKind() {
/*  32 */     return this.eventKind;
/*     */   }
/*     */   
/*     */   public void setEventKind(Integer eventKind) {
/*  36 */     this.eventKind = eventKind;
/*     */   }
/*     */   
/*     */   public String getEventTypeValue() {
/*  40 */     return this.eventTypeValue;
/*     */   }
/*     */   
/*     */   public void setEventTypeValue(String eventTypeValue) {
/*  44 */     this.eventTypeValue = eventTypeValue;
/*     */   }
/*     */   
/*     */   public String getEventContent() {
/*  48 */     return this.eventContent;
/*     */   }
/*     */   
/*     */   public void setEventContent(String eventContent) {
/*  52 */     this.eventContent = eventContent;
/*     */   }
/*     */   
/*     */   public String getEventStartDateTime() {
/*  56 */     return this.eventStartDateTime;
/*     */   }
/*     */   
/*     */   public void setEventStartDateTime(String eventStartDateTime) {
/*  60 */     this.eventStartDateTime = eventStartDateTime;
/*     */   }
/*     */   
/*     */   public Double getEventHappenLongitude() {
/*  64 */     return this.eventHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setEventHappenLongitude(Double eventHappenLongitude) {
/*  68 */     this.eventHappenLongitude = eventHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getEventHappenLatitude() {
/*  72 */     return this.eventHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setEventHappenLatitude(Double eventHappenLatitude) {
/*  76 */     this.eventHappenLatitude = eventHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getEventStatusTypeValue() {
/*  80 */     return this.eventStatusTypeValue;
/*     */   }
/*     */   
/*     */   public void setEventStatusTypeValue(String eventStatusTypeValue) {
/*  84 */     this.eventStatusTypeValue = eventStatusTypeValue;
/*     */   }
/*     */   
/*     */   public String getCurrentRemarks() {
/*  88 */     return this.currentRemarks;
/*     */   }
/*     */   
/*     */   public void setCurrentRemarks(String currentRemarks) {
/*  92 */     this.currentRemarks = currentRemarks;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonCertID() {
/*  96 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID) {
/* 100 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public Long getNetGridID() {
/* 104 */     return this.netGridID;
/*     */   }
/*     */   
/*     */   public void setNetGridID(Long netGridID) {
/* 108 */     this.netGridID = netGridID;
/*     */   }
/*     */   
/*     */   public List<NetGridEventInvolvedPersons> getInvolvedPersons() {
/* 112 */     return this.involvedPersons;
/*     */   }
/*     */   
/*     */   public void setInvolvedPersons(List<NetGridEventInvolvedPersons> involvedPersons) {
/* 116 */     this.involvedPersons = involvedPersons;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\netGrid\NetGridEventAPPUploadVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */