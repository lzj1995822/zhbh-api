/*     */ package com.jtzh.entity;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.util.Date;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DisputeEvent
/*     */ {
/*     */   private Long disputeEventID;
/*     */   private String eventName;
/*     */   private Date eventDate;
/*     */   private String eventPlace;
/*     */   private String evenScaleTypeValue;
/*     */   private String eventTypeValue;
/*     */   private Integer numberofJoinning;
/*     */   private String eventIntroduction;
/*     */   private String relatedOrg;
/*     */   private String majorPersonCertTypeCode;
/*     */   private String majorPersonCertID;
/*     */   private String majorPersonName;
/*     */   private String majorPersonSex;
/*     */   private String majorPersonEthnicity;
/*     */   private String majorPersonEducation;
/*     */   private String majorPersonType;
/*     */   private String majorPersonDetailAddress;
/*     */   private Date solvingDeadline;
/*     */   private String solvingMethodType;
/*     */   private String solvingManagment;
/*     */   private String solvingByPersonName;
/*     */   private String solvingByPersonContact;
/*     */   private Integer isSuccessInSolving;
/*     */   private String solvingIntroduction;
/*     */   private Date evaluationDate;
/*     */   private String evaluationSuggestion;
/*     */   private Double longitude;
/*     */   private Double latitude;
/*     */   private String eventStatus;
/*     */   private Integer eventCheckStatus;
/*     */   private Long netGridID;
/*     */   
/*     */   public Long getDisputeEventID()
/*     */   {
/* 200 */     return this.disputeEventID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDisputeEventID(Long disputeEventID)
/*     */   {
/* 210 */     this.disputeEventID = disputeEventID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEventName()
/*     */   {
/* 220 */     return this.eventName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventName(String eventName)
/*     */   {
/* 230 */     this.eventName = eventName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
/*     */   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
/*     */   public Date getEventDate()
/*     */   {
/* 242 */     return this.eventDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventDate(Date eventDate)
/*     */   {
/* 252 */     this.eventDate = eventDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEventPlace()
/*     */   {
/* 262 */     return this.eventPlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventPlace(String eventPlace)
/*     */   {
/* 272 */     this.eventPlace = eventPlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEvenScaleTypeValue()
/*     */   {
/* 282 */     return this.evenScaleTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEvenScaleTypeValue(String evenScaleTypeValue)
/*     */   {
/* 292 */     this.evenScaleTypeValue = evenScaleTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEventTypeValue()
/*     */   {
/* 302 */     return this.eventTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventTypeValue(String eventTypeValue)
/*     */   {
/* 312 */     this.eventTypeValue = eventTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getNumberofJoinning()
/*     */   {
/* 322 */     return this.numberofJoinning;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNumberofJoinning(Integer numberofJoinning)
/*     */   {
/* 332 */     this.numberofJoinning = numberofJoinning;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEventIntroduction()
/*     */   {
/* 342 */     return this.eventIntroduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventIntroduction(String eventIntroduction)
/*     */   {
/* 352 */     this.eventIntroduction = eventIntroduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRelatedOrg()
/*     */   {
/* 362 */     return this.relatedOrg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRelatedOrg(String relatedOrg)
/*     */   {
/* 372 */     this.relatedOrg = relatedOrg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonCertTypeCode()
/*     */   {
/* 382 */     return this.majorPersonCertTypeCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonCertTypeCode(String majorPersonCertTypeCode)
/*     */   {
/* 392 */     this.majorPersonCertTypeCode = majorPersonCertTypeCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonCertID()
/*     */   {
/* 402 */     return this.majorPersonCertID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonCertID(String majorPersonCertID)
/*     */   {
/* 412 */     this.majorPersonCertID = majorPersonCertID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonName()
/*     */   {
/* 422 */     return this.majorPersonName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonName(String majorPersonName)
/*     */   {
/* 432 */     this.majorPersonName = majorPersonName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonSex()
/*     */   {
/* 442 */     return this.majorPersonSex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonSex(String majorPersonSex)
/*     */   {
/* 452 */     this.majorPersonSex = majorPersonSex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonEthnicity()
/*     */   {
/* 462 */     return this.majorPersonEthnicity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonEthnicity(String majorPersonEthnicity)
/*     */   {
/* 472 */     this.majorPersonEthnicity = majorPersonEthnicity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonEducation()
/*     */   {
/* 482 */     return this.majorPersonEducation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonEducation(String majorPersonEducation)
/*     */   {
/* 492 */     this.majorPersonEducation = majorPersonEducation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonType()
/*     */   {
/* 502 */     return this.majorPersonType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonType(String majorPersonType)
/*     */   {
/* 512 */     this.majorPersonType = majorPersonType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMajorPersonDetailAddress()
/*     */   {
/* 522 */     return this.majorPersonDetailAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMajorPersonDetailAddress(String majorPersonDetailAddress)
/*     */   {
/* 532 */     this.majorPersonDetailAddress = majorPersonDetailAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getSolvingDeadline()
/*     */   {
/* 542 */     return this.solvingDeadline;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingDeadline(Date solvingDeadline)
/*     */   {
/* 552 */     this.solvingDeadline = solvingDeadline;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSolvingMethodType()
/*     */   {
/* 562 */     return this.solvingMethodType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingMethodType(String solvingMethodType)
/*     */   {
/* 572 */     this.solvingMethodType = solvingMethodType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSolvingManagment()
/*     */   {
/* 582 */     return this.solvingManagment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingManagment(String solvingManagment)
/*     */   {
/* 592 */     this.solvingManagment = solvingManagment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSolvingByPersonName()
/*     */   {
/* 602 */     return this.solvingByPersonName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingByPersonName(String solvingByPersonName)
/*     */   {
/* 612 */     this.solvingByPersonName = solvingByPersonName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSolvingByPersonContact()
/*     */   {
/* 622 */     return this.solvingByPersonContact;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingByPersonContact(String solvingByPersonContact)
/*     */   {
/* 632 */     this.solvingByPersonContact = solvingByPersonContact;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getIsSuccessInSolving()
/*     */   {
/* 642 */     return this.isSuccessInSolving;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsSuccessInSolving(Integer isSuccessInSolving)
/*     */   {
/* 652 */     this.isSuccessInSolving = isSuccessInSolving;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSolvingIntroduction()
/*     */   {
/* 662 */     return this.solvingIntroduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingIntroduction(String solvingIntroduction)
/*     */   {
/* 672 */     this.solvingIntroduction = solvingIntroduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getEvaluationDate()
/*     */   {
/* 682 */     return this.evaluationDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEvaluationDate(Date evaluationDate)
/*     */   {
/* 692 */     this.evaluationDate = evaluationDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEvaluationSuggestion()
/*     */   {
/* 702 */     return this.evaluationSuggestion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEvaluationSuggestion(String evaluationSuggestion)
/*     */   {
/* 712 */     this.evaluationSuggestion = evaluationSuggestion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getLongitude()
/*     */   {
/* 722 */     return this.longitude;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLongitude(Double longitude)
/*     */   {
/* 732 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Double getLatitude()
/*     */   {
/* 742 */     return this.latitude;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLatitude(Double latitude)
/*     */   {
/* 752 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEventStatus()
/*     */   {
/* 762 */     return this.eventStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventStatus(String eventStatus)
/*     */   {
/* 772 */     this.eventStatus = eventStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getEventCheckStatus()
/*     */   {
/* 782 */     return this.eventCheckStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventCheckStatus(Integer eventCheckStatus)
/*     */   {
/* 792 */     this.eventCheckStatus = eventCheckStatus;
/*     */   }
/*     */   
/*     */   public Long getNetGridID() {
/* 796 */     return this.netGridID;
/*     */   }
/*     */   
/*     */   public void setNetGridID(Long netGridID) {
/* 800 */     this.netGridID = netGridID;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\DisputeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */