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
/*     */ public class ServedPersonBasic
/*     */ {
/*     */   private Long servedPersonID;
/*     */   private String servedPersonTypeValue;
/*     */   private Long netGridID;
/*     */   private String certifID;
/*     */   private String name;
/*     */   private String nameUsed;
/*     */   private String sex;
/*     */   private Date birthDate;
/*     */   private String ethnicity;
/*     */   private String nativePlace;
/*     */   private String politics;
/*     */   private String maritalStatus;
/*     */   private String education;
/*     */   private String religiousBelief;
/*     */   private String careerType;
/*     */   private String career;
/*     */   private String mobileTel;
/*     */   private String fixedTel;
/*     */   private Boolean isSpecialPopulation;
/*     */   private String servedPlace;
/*     */   private String domicileAddress;
/*     */   private String domicileAddressDetail;
/*     */   private String presentAddress;
/*     */   private String presentAddressDetail;
/*     */   
/*     */   public Long getServedPersonID()
/*     */   {
/* 138 */     return this.servedPersonID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setServedPersonID(Long servedPersonID)
/*     */   {
/* 147 */     this.servedPersonID = servedPersonID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getServedPersonTypeValue()
/*     */   {
/* 156 */     return this.servedPersonTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setServedPersonTypeValue(String servedPersonTypeValue)
/*     */   {
/* 165 */     this.servedPersonTypeValue = servedPersonTypeValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getNetGridID()
/*     */   {
/* 174 */     return this.netGridID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetGridID(Long netGridID)
/*     */   {
/* 183 */     this.netGridID = netGridID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCertifID()
/*     */   {
/* 192 */     return this.certifID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCertifID(String certifID)
/*     */   {
/* 201 */     this.certifID = certifID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 210 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 219 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNameUsed()
/*     */   {
/* 228 */     return this.nameUsed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNameUsed(String nameUsed)
/*     */   {
/* 237 */     this.nameUsed = nameUsed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSex()
/*     */   {
/* 246 */     return this.sex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSex(String sex)
/*     */   {
/* 255 */     this.sex = sex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @DateTimeFormat(pattern="yyyy-MM-dd")
/*     */   @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
/*     */   public Date getBirthDate()
/*     */   {
/* 266 */     return this.birthDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBirthDate(Date birthDate)
/*     */   {
/* 275 */     this.birthDate = birthDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEthnicity()
/*     */   {
/* 284 */     return this.ethnicity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEthnicity(String ethnicity)
/*     */   {
/* 293 */     this.ethnicity = ethnicity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNativePlace()
/*     */   {
/* 302 */     return this.nativePlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNativePlace(String nativePlace)
/*     */   {
/* 311 */     this.nativePlace = nativePlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPolitics()
/*     */   {
/* 320 */     return this.politics;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPolitics(String politics)
/*     */   {
/* 329 */     this.politics = politics;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMaritalStatus()
/*     */   {
/* 338 */     return this.maritalStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaritalStatus(String maritalStatus)
/*     */   {
/* 347 */     this.maritalStatus = maritalStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getEducation()
/*     */   {
/* 356 */     return this.education;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEducation(String education)
/*     */   {
/* 365 */     this.education = education;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getReligiousBelief()
/*     */   {
/* 374 */     return this.religiousBelief;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReligiousBelief(String religiousBelief)
/*     */   {
/* 383 */     this.religiousBelief = religiousBelief;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCareerType()
/*     */   {
/* 392 */     return this.careerType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCareerType(String careerType)
/*     */   {
/* 401 */     this.careerType = careerType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCareer()
/*     */   {
/* 410 */     return this.career;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCareer(String career)
/*     */   {
/* 419 */     this.career = career;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMobileTel()
/*     */   {
/* 428 */     return this.mobileTel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMobileTel(String mobileTel)
/*     */   {
/* 437 */     this.mobileTel = mobileTel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFixedTel()
/*     */   {
/* 446 */     return this.fixedTel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFixedTel(String fixedTel)
/*     */   {
/* 455 */     this.fixedTel = fixedTel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Boolean getIsSpecialPopulation()
/*     */   {
/* 464 */     return this.isSpecialPopulation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsSpecialPopulation(Boolean isSpecialPopulation)
/*     */   {
/* 473 */     this.isSpecialPopulation = isSpecialPopulation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getServedPlace()
/*     */   {
/* 482 */     return this.servedPlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setServedPlace(String servedPlace)
/*     */   {
/* 491 */     this.servedPlace = servedPlace;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDomicileAddress()
/*     */   {
/* 500 */     return this.domicileAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDomicileAddress(String domicileAddress)
/*     */   {
/* 509 */     this.domicileAddress = domicileAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDomicileAddressDetail()
/*     */   {
/* 518 */     return this.domicileAddressDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDomicileAddressDetail(String domicileAddressDetail)
/*     */   {
/* 527 */     this.domicileAddressDetail = domicileAddressDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPresentAddress()
/*     */   {
/* 536 */     return this.presentAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPresentAddress(String presentAddress)
/*     */   {
/* 545 */     this.presentAddress = presentAddress;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getPresentAddressDetail()
/*     */   {
/* 554 */     return this.presentAddressDetail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPresentAddressDetail(String presentAddressDetail)
/*     */   {
/* 563 */     this.presentAddressDetail = presentAddressDetail;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\ServedPersonBasic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */