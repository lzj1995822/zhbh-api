/*    */ package com.jtzh.vo.orgMember;
/*    */ import java.util.List;

import com.jtzh.entity.CODELevelType;
import com.jtzh.entity.CODEOrganizationType;
import com.jtzh.entity.CODEPersonLevelType;
import com.jtzh.entity.CODEPersonPositionType;
import com.jtzh.entity.OrgBasicInf;
/*    */ 
/*    */ public class OrgMemberTypesVO
/*    */ {
/*    */   private List<CODELevelType> levelTypes;
/*    */   private List<CODEPersonLevelType> personLevelTypes;
/*    */   private List<CODEOrganizationType> organizationTypes;
/*    */   private List<CODEPersonPositionType> personPositionTypes;
/*    */   private List<OrgBasicInf> orgBasicInfs;
/*    */   
/*    */   public List<CODELevelType> getLevelTypes()
/*    */   {
/* 20 */     return this.levelTypes;
/*    */   }
/*    */   
/*    */   public void setLevelTypes(List<CODELevelType> levelTypes) {
/* 24 */     this.levelTypes = levelTypes;
/*    */   }
/*    */   
/*    */   public List<CODEPersonLevelType> getPersonLevelTypes() {
/* 28 */     return this.personLevelTypes;
/*    */   }
/*    */   
/*    */   public void setPersonLevelTypes(List<CODEPersonLevelType> personLevelTypes) {
/* 32 */     this.personLevelTypes = personLevelTypes;
/*    */   }
/*    */   
/*    */   public List<CODEPersonPositionType> getPersonPositionTypes() {
/* 36 */     return this.personPositionTypes;
/*    */   }
/*    */   
/*    */   public void setPersonPositionTypes(List<CODEPersonPositionType> personPositionTypes) {
/* 40 */     this.personPositionTypes = personPositionTypes;
/*    */   }
/*    */   
/*    */   public List<OrgBasicInf> getOrgBasicInfs() {
/* 44 */     return this.orgBasicInfs;
/*    */   }
/*    */   
/*    */   public void setOrgBasicInfs(List<OrgBasicInf> orgBasicInfs) {
/* 48 */     this.orgBasicInfs = orgBasicInfs;
/*    */   }
/*    */   
/*    */   public List<CODEOrganizationType> getOrganizationTypes() {
/* 52 */     return this.organizationTypes;
/*    */   }
/*    */   
/*    */   public void setOrganizationTypes(List<CODEOrganizationType> organizationTypes) {
/* 56 */     this.organizationTypes = organizationTypes;
/*    */   }
/*    */ }


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\vo\orgMember\OrgMemberTypesVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */