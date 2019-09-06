/*     */ package com.jtzh.entity;
/*     */ 
/*     */ import java.util.Date;
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
/*     */ public class DisputeEventDealing
/*     */ {
/*     */   private Long eventDealingID;
/*     */   private Long eventID;
/*     */   private Long dealingUserID;
/*     */   private Date dealingTime;
/*     */   private String solvingMethodType;
/*     */   private Integer isSuccessInSolving;
/*     */   private String dealingInf;
/*     */   private String remark;
/*     */   
/*     */   public Long getEventDealingID()
/*     */   {
/*  87 */     return this.eventDealingID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventDealingID(Long eventDealingID)
/*     */   {
/*  99 */     this.eventDealingID = eventDealingID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getEventID()
/*     */   {
/* 111 */     return this.eventID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEventID(Long eventID)
/*     */   {
/* 123 */     this.eventID = eventID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getDealingUserID()
/*     */   {
/* 135 */     return this.dealingUserID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDealingUserID(Long dealingUserID)
/*     */   {
/* 147 */     this.dealingUserID = dealingUserID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getDealingTime()
/*     */   {
/* 159 */     return this.dealingTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDealingTime(Date dealingTime)
/*     */   {
/* 171 */     this.dealingTime = dealingTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSolvingMethodType()
/*     */   {
/* 183 */     return this.solvingMethodType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSolvingMethodType(String solvingMethodType)
/*     */   {
/* 195 */     this.solvingMethodType = solvingMethodType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getIsSuccessInSolving()
/*     */   {
/* 207 */     return this.isSuccessInSolving;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsSuccessInSolving(Integer isSuccessInSolving)
/*     */   {
/* 219 */     this.isSuccessInSolving = isSuccessInSolving;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDealingInf()
/*     */   {
/* 231 */     return this.dealingInf;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDealingInf(String dealingInf)
/*     */   {
/* 243 */     this.dealingInf = dealingInf;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 255 */     return this.remark;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 267 */     this.remark = remark;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\DisputeEventDealing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */