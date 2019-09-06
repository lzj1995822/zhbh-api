/*      */ package com.jtzh.entity;
/*      */ 
/*      */ import java.util.Date;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SocietyOrg
/*      */ {
/*      */   private String enterpriseUSCcode;
/*      */   private Date establishDate;
/*      */   private Date creationDate;
/*      */   private String registerNumber;
/*      */   private String societyOrgName;
/*      */   private String registerManagOrgCode;
/*      */   private String headerName;
/*      */   private String livingHouse;
/*      */   private Date approvalDate;
/*      */   private String societyOrgTypeValue;
/*      */   private Integer status;
/*      */   private String responsiblePersonCertTypeValue;
/*      */   private String responsiblePersonCertifID;
/*      */   private String responsiblePersonName;
/*      */   private String responsiblePersonContact;
/*      */   private String officeAddress;
/*      */   private String regionalismCode;
/*      */   private String securityLeaderCertID;
/*      */   private String securityLeaderName;
/*      */   private String securityLeaderContact;
/*      */   private String attentionTypeValue;
/*      */   private Integer isCanConstructCPC;
/*      */   private Integer hasCPC;
/*      */   private Integer numberofCPCMember;
/*      */   private Integer hasLabourUnion;
/*      */   private Integer numberofLUMember;
/*      */   private Integer hasCYL;
/*      */   private Integer numberofLCYLMember;
/*      */   private Integer hasWomenFederation;
/*      */   private Integer numberofWomen;
/*      */   private String sourceofFunds;
/*      */   private Integer isOverseasBackground;
/*      */   private Double longitude;
/*      */   private Double latitude;
/*      */   private Long netGridID;
/*      */   
/*      */   public String getEnterpriseUSCcode()
/*      */   {
/*  330 */     return this.enterpriseUSCcode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setEnterpriseUSCcode(String enterpriseUSCcode)
/*      */   {
/*  342 */     this.enterpriseUSCcode = enterpriseUSCcode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Date getEstablishDate()
/*      */   {
/*  354 */     return this.establishDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setEstablishDate(Date establishDate)
/*      */   {
/*  366 */     this.establishDate = establishDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Date getCreationDate()
/*      */   {
/*  378 */     return this.creationDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setCreationDate(Date creationDate)
/*      */   {
/*  390 */     this.creationDate = creationDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getRegisterNumber()
/*      */   {
/*  402 */     return this.registerNumber;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setRegisterNumber(String registerNumber)
/*      */   {
/*  414 */     this.registerNumber = registerNumber;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSocietyOrgName()
/*      */   {
/*  426 */     return this.societyOrgName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSocietyOrgName(String societyOrgName)
/*      */   {
/*  438 */     this.societyOrgName = societyOrgName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getRegisterManagOrgCode()
/*      */   {
/*  450 */     return this.registerManagOrgCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setRegisterManagOrgCode(String registerManagOrgCode)
/*      */   {
/*  462 */     this.registerManagOrgCode = registerManagOrgCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getHeaderName()
/*      */   {
/*  474 */     return this.headerName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setHeaderName(String headerName)
/*      */   {
/*  486 */     this.headerName = headerName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getLivingHouse()
/*      */   {
/*  498 */     return this.livingHouse;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setLivingHouse(String livingHouse)
/*      */   {
/*  510 */     this.livingHouse = livingHouse;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Date getApprovalDate()
/*      */   {
/*  522 */     return this.approvalDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setApprovalDate(Date approvalDate)
/*      */   {
/*  534 */     this.approvalDate = approvalDate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSocietyOrgTypeValue()
/*      */   {
/*  546 */     return this.societyOrgTypeValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSocietyOrgTypeValue(String societyOrgTypeValue)
/*      */   {
/*  558 */     this.societyOrgTypeValue = societyOrgTypeValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getStatus()
/*      */   {
/*  570 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setStatus(Integer status)
/*      */   {
/*  582 */     this.status = status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getResponsiblePersonCertTypeValue()
/*      */   {
/*  594 */     return this.responsiblePersonCertTypeValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setResponsiblePersonCertTypeValue(String responsiblePersonCertTypeValue)
/*      */   {
/*  606 */     this.responsiblePersonCertTypeValue = responsiblePersonCertTypeValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getResponsiblePersonCertifID()
/*      */   {
/*  618 */     return this.responsiblePersonCertifID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setResponsiblePersonCertifID(String responsiblePersonCertifID)
/*      */   {
/*  630 */     this.responsiblePersonCertifID = responsiblePersonCertifID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getResponsiblePersonName()
/*      */   {
/*  642 */     return this.responsiblePersonName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setResponsiblePersonName(String responsiblePersonName)
/*      */   {
/*  654 */     this.responsiblePersonName = responsiblePersonName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getResponsiblePersonContact()
/*      */   {
/*  666 */     return this.responsiblePersonContact;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setResponsiblePersonContact(String responsiblePersonContact)
/*      */   {
/*  678 */     this.responsiblePersonContact = responsiblePersonContact;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getOfficeAddress()
/*      */   {
/*  690 */     return this.officeAddress;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setOfficeAddress(String officeAddress)
/*      */   {
/*  702 */     this.officeAddress = officeAddress;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getRegionalismCode()
/*      */   {
/*  714 */     return this.regionalismCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setRegionalismCode(String regionalismCode)
/*      */   {
/*  726 */     this.regionalismCode = regionalismCode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSecurityLeaderCertID()
/*      */   {
/*  738 */     return this.securityLeaderCertID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSecurityLeaderCertID(String securityLeaderCertID)
/*      */   {
/*  750 */     this.securityLeaderCertID = securityLeaderCertID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSecurityLeaderName()
/*      */   {
/*  762 */     return this.securityLeaderName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSecurityLeaderName(String securityLeaderName)
/*      */   {
/*  774 */     this.securityLeaderName = securityLeaderName;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSecurityLeaderContact()
/*      */   {
/*  786 */     return this.securityLeaderContact;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSecurityLeaderContact(String securityLeaderContact)
/*      */   {
/*  798 */     this.securityLeaderContact = securityLeaderContact;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getAttentionTypeValue()
/*      */   {
/*  810 */     return this.attentionTypeValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setAttentionTypeValue(String attentionTypeValue)
/*      */   {
/*  822 */     this.attentionTypeValue = attentionTypeValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getIsCanConstructCPC()
/*      */   {
/*  834 */     return this.isCanConstructCPC;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setIsCanConstructCPC(Integer isCanConstructCPC)
/*      */   {
/*  846 */     this.isCanConstructCPC = isCanConstructCPC;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getHasCPC()
/*      */   {
/*  858 */     return this.hasCPC;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setHasCPC(Integer hasCPC)
/*      */   {
/*  870 */     this.hasCPC = hasCPC;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getNumberofCPCMember()
/*      */   {
/*  882 */     return this.numberofCPCMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNumberofCPCMember(Integer numberofCPCMember)
/*      */   {
/*  894 */     this.numberofCPCMember = numberofCPCMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getHasLabourUnion()
/*      */   {
/*  906 */     return this.hasLabourUnion;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setHasLabourUnion(Integer hasLabourUnion)
/*      */   {
/*  918 */     this.hasLabourUnion = hasLabourUnion;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getNumberofLUMember()
/*      */   {
/*  930 */     return this.numberofLUMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNumberofLUMember(Integer numberofLUMember)
/*      */   {
/*  942 */     this.numberofLUMember = numberofLUMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getHasCYL()
/*      */   {
/*  954 */     return this.hasCYL;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setHasCYL(Integer hasCYL)
/*      */   {
/*  966 */     this.hasCYL = hasCYL;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getNumberofLCYLMember()
/*      */   {
/*  978 */     return this.numberofLCYLMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNumberofLCYLMember(Integer numberofLCYLMember)
/*      */   {
/*  990 */     this.numberofLCYLMember = numberofLCYLMember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getHasWomenFederation()
/*      */   {
/* 1002 */     return this.hasWomenFederation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setHasWomenFederation(Integer hasWomenFederation)
/*      */   {
/* 1014 */     this.hasWomenFederation = hasWomenFederation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getNumberofWomen()
/*      */   {
/* 1026 */     return this.numberofWomen;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNumberofWomen(Integer numberofWomen)
/*      */   {
/* 1038 */     this.numberofWomen = numberofWomen;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getSourceofFunds()
/*      */   {
/* 1050 */     return this.sourceofFunds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setSourceofFunds(String sourceofFunds)
/*      */   {
/* 1062 */     this.sourceofFunds = sourceofFunds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer getIsOverseasBackground()
/*      */   {
/* 1074 */     return this.isOverseasBackground;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setIsOverseasBackground(Integer isOverseasBackground)
/*      */   {
/* 1086 */     this.isOverseasBackground = isOverseasBackground;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Double getLongitude()
/*      */   {
/* 1098 */     return this.longitude;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setLongitude(Double longitude)
/*      */   {
/* 1110 */     this.longitude = longitude;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Double getLatitude()
/*      */   {
/* 1122 */     return this.latitude;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setLatitude(Double latitude)
/*      */   {
/* 1134 */     this.latitude = latitude;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Long getNetGridID()
/*      */   {
/* 1146 */     return this.netGridID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNetGridID(Long netGridID)
/*      */   {
/* 1158 */     this.netGridID = netGridID;
/*      */   }
/*      */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\entity\SocietyOrg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */