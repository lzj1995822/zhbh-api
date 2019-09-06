/*     */ package com.jtzh.vo.trafficAccident;
/*     */ import java.util.List;

import com.jtzh.entity.TrafficAccidentInvolvedPersons;
/*     */ 
/*     */ public class TrafficAccidentAPPUploadVO
/*     */ {
/*     */   private Long trafficAccidentID;
/*     */   private String trafficAccidentName;
/*     */   private String trafficAccidentKind;
/*     */   private String trafficAccidentTypeValue;
/*     */   private String trafficAccidentContent;
/*     */   private String trafficAccidentStartDateTime;
/*     */   private Double trafficAccidentHappenLongitude;
/*     */   private Double trafficAccidentHappenLatitude;
/*     */   private String currentRemarks;
/*     */   private String currentResponsiblePersonCertID;
/*     */   private Long netGridID;
/*     */   private List<TrafficAccidentInvolvedPersons> involvedPersons;
/*     */   
/*     */   public Long getTrafficAccidentID()
/*     */   {
/*  23 */     return this.trafficAccidentID;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentID(Long trafficAccidentID) {
/*  27 */     this.trafficAccidentID = trafficAccidentID;
/*     */   }
/*     */   
/*     */   public String getTrafficAccidentName() {
/*  31 */     return this.trafficAccidentName;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentName(String trafficAccidentName) {
/*  35 */     this.trafficAccidentName = trafficAccidentName;
/*     */   }
/*     */   
/*     */   public String getTrafficAccidentKind() {
/*  39 */     return this.trafficAccidentKind;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentKind(String trafficAccidentKind) {
/*  43 */     this.trafficAccidentKind = trafficAccidentKind;
/*     */   }
/*     */   
/*     */   public String getTrafficAccidentTypeValue() {
/*  47 */     return this.trafficAccidentTypeValue;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentTypeValue(String trafficAccidentTypeValue) {
/*  51 */     this.trafficAccidentTypeValue = trafficAccidentTypeValue;
/*     */   }
/*     */   
/*     */   public String getTrafficAccidentContent() {
/*  55 */     return this.trafficAccidentContent;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentContent(String trafficAccidentContent) {
/*  59 */     this.trafficAccidentContent = trafficAccidentContent;
/*     */   }
/*     */   
/*     */   public String getTrafficAccidentStartDateTime() {
/*  63 */     return this.trafficAccidentStartDateTime;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentStartDateTime(String trafficAccidentStartDateTime) {
/*  67 */     this.trafficAccidentStartDateTime = trafficAccidentStartDateTime;
/*     */   }
/*     */   
/*     */   public Double getTrafficAccidentHappenLongitude() {
/*  71 */     return this.trafficAccidentHappenLongitude;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentHappenLongitude(Double trafficAccidentHappenLongitude) {
/*  75 */     this.trafficAccidentHappenLongitude = trafficAccidentHappenLongitude;
/*     */   }
/*     */   
/*     */   public Double getTrafficAccidentHappenLatitude() {
/*  79 */     return this.trafficAccidentHappenLatitude;
/*     */   }
/*     */   
/*     */   public void setTrafficAccidentHappenLatitude(Double trafficAccidentHappenLatitude) {
/*  83 */     this.trafficAccidentHappenLatitude = trafficAccidentHappenLatitude;
/*     */   }
/*     */   
/*     */   public String getCurrentRemarks() {
/*  87 */     return this.currentRemarks;
/*     */   }
/*     */   
/*     */   public void setCurrentRemarks(String currentRemarks) {
/*  91 */     this.currentRemarks = currentRemarks;
/*     */   }
/*     */   
/*     */   public Long getNetGridID() {
/*  95 */     return this.netGridID;
/*     */   }
/*     */   
/*     */   public void setNetGridID(Long netGridID) {
/*  99 */     this.netGridID = netGridID;
/*     */   }
/*     */   
/*     */   public List<TrafficAccidentInvolvedPersons> getInvolvedPersons() {
/* 103 */     return this.involvedPersons;
/*     */   }
/*     */   
/*     */   public void setInvolvedPersons(List<TrafficAccidentInvolvedPersons> involvedPersons) {
/* 107 */     this.involvedPersons = involvedPersons;
/*     */   }
/*     */   
/*     */   public String getCurrentResponsiblePersonCertID() {
/* 111 */     return this.currentResponsiblePersonCertID;
/*     */   }
/*     */   
/*     */   public void setCurrentResponsiblePersonCertID(String currentResponsiblePersonCertID) {
/* 115 */     this.currentResponsiblePersonCertID = currentResponsiblePersonCertID;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\trafficAccident\TrafficAccidentAPPUploadVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */