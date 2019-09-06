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
/*     */ public class OrgBasicInf
/*     */ {
/*     */   private Long orgID;
/*     */   private String orgName;
/*     */   private String orgTypeValue;
/*     */   private String levelTypeValue;
/*     */   private Long netGridID;
/*     */   private Date orgCreateDate;
/*     */   private String orgContactName;
/*     */   private String orgContactTel;
/*     */   private String orgBriefIntroduction;
/*     */   private String businessGuidanceDepartment;
/*     */   private Integer personNumber;
/*     */   private String mainFunction;
/*     */   
/*     */   public Long getOrgID()
/*     */   {
/*  74 */     return this.orgID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgID(Long orgID)
/*     */   {
/*  83 */     this.orgID = orgID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrgName()
/*     */   {
/*  92 */     return this.orgName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgName(String orgName)
/*     */   {
/* 101 */     this.orgName = orgName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrgTypeValue()
/*     */   {
/* 110 */     return this.orgTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgTypeValue(String orgTypeValue)
/*     */   {
/* 119 */     this.orgTypeValue = orgTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLevelTypeValue()
/*     */   {
/* 128 */     return this.levelTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLevelTypeValue(String levelTypeValue)
/*     */   {
/* 137 */     this.levelTypeValue = levelTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getNetGridID()
/*     */   {
/* 146 */     return this.netGridID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetGridID(Long netGridID)
/*     */   {
/* 155 */     this.netGridID = netGridID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getOrgCreateDate()
/*     */   {
/* 164 */     return this.orgCreateDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgCreateDate(Date orgCreateDate)
/*     */   {
/* 173 */     this.orgCreateDate = orgCreateDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrgContactName()
/*     */   {
/* 182 */     return this.orgContactName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgContactName(String orgContactName)
/*     */   {
/* 191 */     this.orgContactName = orgContactName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrgContactTel()
/*     */   {
/* 200 */     return this.orgContactTel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgContactTel(String orgContactTel)
/*     */   {
/* 209 */     this.orgContactTel = orgContactTel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getOrgBriefIntroduction()
/*     */   {
/* 218 */     return this.orgBriefIntroduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOrgBriefIntroduction(String orgBriefIntroduction)
/*     */   {
/* 227 */     this.orgBriefIntroduction = orgBriefIntroduction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getBusinessGuidanceDepartment()
/*     */   {
/* 236 */     return this.businessGuidanceDepartment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBusinessGuidanceDepartment(String businessGuidanceDepartment)
/*     */   {
/* 245 */     this.businessGuidanceDepartment = businessGuidanceDepartment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getPersonNumber()
/*     */   {
/* 254 */     return this.personNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPersonNumber(Integer personNumber)
/*     */   {
/* 263 */     this.personNumber = personNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMainFunction()
/*     */   {
/* 272 */     return this.mainFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMainFunction(String mainFunction)
/*     */   {
/* 281 */     this.mainFunction = mainFunction;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\OrgBasicInf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */