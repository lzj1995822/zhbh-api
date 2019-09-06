/*     */ package com.jtzh.vo.dispute;
/*     */ import java.util.List;

import com.jtzh.entity.DisputeEventInvolvedPersons;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DisputeEventAPPUploadVO
/*     */ {
/*     */   private Long disputeEventID;
/*     */   private String eventName;
/*     */   private String eventDate;
/*     */   private String eventPlace;
/*     */   private String evenScaleTypeValue;
/*     */   private String eventTypeValue;
/*     */   private Integer numberofJoinning;
/*     */   private String eventIntroduction;
/*     */   private String solvingByPersonName;
/*     */   private String relatedOrg;
/*     */   private Double longitude;
/*     */   private Double latitude;
/*     */   private String eventStatus;
/*     */   private Long netGridID;
/*     */   private List<DisputeEventInvolvedPersons> involvedPersons;
/*     */   
/*     */   public Long getDisputeEventID()
/*     */   {
/*  28 */     return this.disputeEventID;
/*     */   }
/*     */   
/*     */   public void setDisputeEventID(Long disputeEventID) {
/*  32 */     this.disputeEventID = disputeEventID;
/*     */   }
/*     */   
/*     */   public String getEventName() {
/*  36 */     return this.eventName;
/*     */   }
/*     */   
/*     */   public void setEventName(String eventName) {
/*  40 */     this.eventName = eventName;
/*     */   }
/*     */   
/*     */   public String getEventDate() {
/*  44 */     return this.eventDate;
/*     */   }
/*     */   
/*     */   public void setEventDate(String eventDate) {
/*  48 */     this.eventDate = eventDate;
/*     */   }
/*     */   
/*     */   public String getEventPlace() {
/*  52 */     return this.eventPlace;
/*     */   }
/*     */   
/*     */   public void setEventPlace(String eventPlace) {
/*  56 */     this.eventPlace = eventPlace;
/*     */   }
/*     */   
/*     */   public String getEvenScaleTypeValue() {
/*  60 */     return this.evenScaleTypeValue;
/*     */   }
/*     */   
/*     */   public void setEvenScaleTypeValue(String evenScaleTypeValue) {
/*  64 */     this.evenScaleTypeValue = evenScaleTypeValue;
/*     */   }
/*     */   
/*     */   public String getEventTypeValue() {
/*  68 */     return this.eventTypeValue;
/*     */   }
/*     */   
/*     */   public void setEventTypeValue(String eventTypeValue) {
/*  72 */     this.eventTypeValue = eventTypeValue;
/*     */   }
/*     */   
/*     */   public Integer getNumberofJoinning() {
/*  76 */     return this.numberofJoinning;
/*     */   }
/*     */   
/*     */   public void setNumberofJoinning(Integer numberofJoinning) {
/*  80 */     this.numberofJoinning = numberofJoinning;
/*     */   }
/*     */   
/*     */   public String getEventIntroduction() {
/*  84 */     return this.eventIntroduction;
/*     */   }
/*     */   
/*     */   public void setEventIntroduction(String eventIntroduction) {
/*  88 */     this.eventIntroduction = eventIntroduction;
/*     */   }
/*     */   
/*     */   public String getRelatedOrg() {
/*  92 */     return this.relatedOrg;
/*     */   }
/*     */   
/*     */   public void setRelatedOrg(String relatedOrg) {
/*  96 */     this.relatedOrg = relatedOrg;
/*     */   }
/*     */   
/*     */   public Double getLongitude() {
/* 100 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(Double longitude) {
/* 104 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public Double getLatitude() {
/* 108 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(Double latitude) {
/* 112 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public Long getNetGridID() {
/* 116 */     return this.netGridID;
/*     */   }
/*     */   
/*     */   public void setNetGridID(Long netGridID) {
/* 120 */     this.netGridID = netGridID;
/*     */   }
/*     */   
/*     */   public List<DisputeEventInvolvedPersons> getInvolvedPersons() {
/* 124 */     return this.involvedPersons;
/*     */   }
/*     */   
/*     */   public void setInvolvedPersons(List<DisputeEventInvolvedPersons> involvedPersons) {
/* 128 */     this.involvedPersons = involvedPersons;
/*     */   }
/*     */   
/*     */   public String getSolvingByPersonName() {
/* 132 */     return this.solvingByPersonName;
/*     */   }
/*     */   
/*     */   public void setSolvingByPersonName(String solvingByPersonName) {
/* 136 */     this.solvingByPersonName = solvingByPersonName;
/*     */   }
/*     */   
/*     */   public String getEventStatus() {
/* 140 */     return this.eventStatus;
/*     */   }
/*     */   
/*     */   public void setEventStatus(String eventStatus) {
/* 144 */     this.eventStatus = eventStatus;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\dispute\DisputeEventAPPUploadVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */