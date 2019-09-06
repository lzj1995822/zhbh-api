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
/*     */ public class ServedPersonExtendFloatingPopulation
/*     */ {
/*     */   private Long extendFloatingPersonID;
/*     */   private String certifID;
/*     */   private String folatingReasonTypeValue;
/*     */   private String temporaryResidenceTypeValue;
/*     */   private String temporaryResidencyeReasonTypeValue;
/*     */   private String certificateTypeValue;
/*     */   private String identificationNumber;
/*     */   private Date registerDate;
/*     */   private Date dueDate;
/*     */   private String houseTypeValue;
/*     */   private Boolean isFocusPerson;
/*     */   private Boolean isSettled;
/*     */   private Integer unSettledReason;
/*     */   private Date unSettledDate;
/*     */   
/*     */   public Long getExtendFloatingPersonID()
/*     */   {
/* 141 */     return this.extendFloatingPersonID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setExtendFloatingPersonID(Long extendFloatingPersonID)
/*     */   {
/* 153 */     this.extendFloatingPersonID = extendFloatingPersonID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCertifID()
/*     */   {
/* 165 */     return this.certifID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCertifID(String certifID)
/*     */   {
/* 177 */     this.certifID = certifID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFolatingReasonTypeValue()
/*     */   {
/* 189 */     return this.folatingReasonTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFolatingReasonTypeValue(String folatingReasonTypeValue)
/*     */   {
/* 201 */     this.folatingReasonTypeValue = folatingReasonTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTemporaryResidenceTypeValue()
/*     */   {
/* 213 */     return this.temporaryResidenceTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTemporaryResidenceTypeValue(String temporaryResidenceTypeValue)
/*     */   {
/* 225 */     this.temporaryResidenceTypeValue = temporaryResidenceTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTemporaryResidencyeReasonTypeValue()
/*     */   {
/* 237 */     return this.temporaryResidencyeReasonTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTemporaryResidencyeReasonTypeValue(String temporaryResidencyeReasonTypeValue)
/*     */   {
/* 249 */     this.temporaryResidencyeReasonTypeValue = temporaryResidencyeReasonTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCertificateTypeValue()
/*     */   {
/* 261 */     return this.certificateTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCertificateTypeValue(String certificateTypeValue)
/*     */   {
/* 273 */     this.certificateTypeValue = certificateTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getIdentificationNumber()
/*     */   {
/* 285 */     return this.identificationNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIdentificationNumber(String identificationNumber)
/*     */   {
/* 297 */     this.identificationNumber = identificationNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getRegisterDate()
/*     */   {
/* 309 */     return this.registerDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRegisterDate(Date registerDate)
/*     */   {
/* 321 */     this.registerDate = registerDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getDueDate()
/*     */   {
/* 333 */     return this.dueDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDueDate(Date dueDate)
/*     */   {
/* 345 */     this.dueDate = dueDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getHouseTypeValue()
/*     */   {
/* 357 */     return this.houseTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHouseTypeValue(String houseTypeValue)
/*     */   {
/* 369 */     this.houseTypeValue = houseTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Boolean getIsFocusPerson()
/*     */   {
/* 381 */     return this.isFocusPerson;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsFocusPerson(Boolean isFocusPerson)
/*     */   {
/* 393 */     this.isFocusPerson = isFocusPerson;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Boolean getIsSettled()
/*     */   {
/* 405 */     return this.isSettled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsSettled(Boolean isSettled)
/*     */   {
/* 417 */     this.isSettled = isSettled;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getUnSettledReason()
/*     */   {
/* 429 */     return this.unSettledReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUnSettledReason(Integer unSettledReason)
/*     */   {
/* 441 */     this.unSettledReason = unSettledReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getUnSettledDate()
/*     */   {
/* 453 */     return this.unSettledDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUnSettledDate(Date unSettledDate)
/*     */   {
/* 465 */     this.unSettledDate = unSettledDate;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\ServedPersonExtendFloatingPopulation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */