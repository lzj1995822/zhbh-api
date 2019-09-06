/*     */ package com.jtzh.vo.orgMember;
/*     */ import java.text.SimpleDateFormat;

import com.jtzh.entity.OrgMember;
/*     */ 
/*     */ public class OrgMemberVO
/*     */ {
/*     */   private Long orgMemberID;
/*     */   private Long orgID;
/*     */   private String name;
/*     */   private Integer sex;
/*     */   private String ethnicity;
/*     */   private String politics;
/*     */   private String certID;
/*     */   private String birthDate;
/*     */   private String levelTypeName;
/*     */   private String positionTypeName;
/*     */   private String education;
/*     */   private String mobileTel;
/*     */   private String fixedTel;
/*     */   private Integer status;
/*     */   
/*     */   public OrgMemberVO() {}
/*     */   
/*     */   public OrgMemberVO(OrgMember member)
/*     */   {
/*  27 */     this.orgMemberID = member.getOrgMemberID();
/*  28 */     this.orgID = member.getOrgID();
/*  29 */     this.name = member.getName();
/*  30 */     this.sex = member.getSex();
/*  31 */     this.ethnicity = member.getEthnicity();
/*  32 */     this.politics = member.getPolitics();
/*  33 */     this.certID = member.getCertID();
/*  34 */     this.birthDate = new SimpleDateFormat("yyyy-MM-dd").format(member.getBirthDate());
/*  35 */     this.positionTypeName = member.getPositionTypeValue();
/*  36 */     this.levelTypeName = member.getLevelTypeValue();
/*  37 */     this.education = member.getEducation();
/*  38 */     this.mobileTel = member.getMobileTel();
/*  39 */     this.fixedTel = member.getFixedTel();
/*  40 */     this.status = member.getStatus();
/*     */   }
/*     */   
/*     */   public Long getOrgMemberID() {
/*  44 */     return this.orgMemberID;
/*     */   }
/*     */   
/*     */   public void setOrgMemberID(Long orgMemberID) {
/*  48 */     this.orgMemberID = orgMemberID;
/*     */   }
/*     */   
/*     */   public Long getOrgID() {
/*  52 */     return this.orgID;
/*     */   }
/*     */   
/*     */   public void setOrgID(Long orgID) {
/*  56 */     this.orgID = orgID;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  60 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  64 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Integer getSex() {
/*  68 */     return this.sex;
/*     */   }
/*     */   
/*     */   public void setSex(Integer sex) {
/*  72 */     this.sex = sex;
/*     */   }
/*     */   
/*     */   public String getEthnicity() {
/*  76 */     return this.ethnicity;
/*     */   }
/*     */   
/*     */   public void setEthnicity(String ethnicity) {
/*  80 */     this.ethnicity = ethnicity;
/*     */   }
/*     */   
/*     */   public String getPolitics() {
/*  84 */     return this.politics;
/*     */   }
/*     */   
/*     */   public void setPolitics(String politics) {
/*  88 */     this.politics = politics;
/*     */   }
/*     */   
/*     */   public String getCertID() {
/*  92 */     return this.certID;
/*     */   }
/*     */   
/*     */   public void setCertID(String certID) {
/*  96 */     this.certID = certID;
/*     */   }
/*     */   
/*     */   public String getBirthDate() {
/* 100 */     return this.birthDate;
/*     */   }
/*     */   
/*     */   public void setBirthDate(String birthDate) {
/* 104 */     this.birthDate = birthDate;
/*     */   }
/*     */   
/*     */   public String getLevelTypeName() {
/* 108 */     return this.levelTypeName;
/*     */   }
/*     */   
/*     */   public void setLevelTypeName(String levelTypeName) {
/* 112 */     this.levelTypeName = levelTypeName;
/*     */   }
/*     */   
/*     */   public String getPositionTypeName() {
/* 116 */     return this.positionTypeName;
/*     */   }
/*     */   
/*     */   public void setPositionTypeName(String positionTypeName) {
/* 120 */     this.positionTypeName = positionTypeName;
/*     */   }
/*     */   
/*     */   public String getEducation() {
/* 124 */     return this.education;
/*     */   }
/*     */   
/*     */   public void setEducation(String education) {
/* 128 */     this.education = education;
/*     */   }
/*     */   
/*     */   public String getMobileTel() {
/* 132 */     return this.mobileTel;
/*     */   }
/*     */   
/*     */   public void setMobileTel(String mobileTel) {
/* 136 */     this.mobileTel = mobileTel;
/*     */   }
/*     */   
/*     */   public String getFixedTel() {
/* 140 */     return this.fixedTel;
/*     */   }
/*     */   
/*     */   public void setFixedTel(String fixedTel) {
/* 144 */     this.fixedTel = fixedTel;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 148 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 152 */     this.status = status;
/*     */   }
/*     */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\orgMember\OrgMemberVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */