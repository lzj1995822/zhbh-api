package com.jtzh.service;

import com.jtzh.vo.nonpublic.NonPublicEconomyOrgDetailVO;
import com.jtzh.vo.nonpublic.NonPublicEconomyOrgQueryVO;
import com.jtzh.vo.nonpublic.SocietyOrgDetailVO;
import com.jtzh.vo.nonpublic.SocietyOrgQueryVO;
import com.jtzh.entity.NonPublicEconomyOrg;
import com.jtzh.entity.SocietyOrg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public abstract interface NonpublicService
{
  public abstract HashMap getNopublicCode();
  
  public abstract NonPublicEconomyOrgQueryVO getNonPublicEconomyOrgInfo(String paramString1, String paramString2, Long paramLong, Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2);
  
  public abstract Map getNonPublicEconomyOrgDetailByCode(String paramString);
  
  public abstract NonPublicEconomyOrg getToUpdateInfo(String paramString);
  
  public abstract boolean addNonpublic(NonPublicEconomyOrg paramNonPublicEconomyOrg);
  
  public abstract boolean updateNonpublic(NonPublicEconomyOrg paramNonPublicEconomyOrg);
  
  public abstract boolean deleteNonpublic(String paramString);
  
  public abstract List getEconomyHistogram();
  
  public abstract SocietyOrgQueryVO getSocietyOrgInfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract List<SocietyOrgDetailVO> getSocietyOrgDetailByCode(String paramString);
  
  public abstract SocietyOrg getToUpdateSocietyOrgInfo(String paramString);
  
  public abstract boolean addSocietyOrg(SocietyOrg paramSocietyOrg);
  
  public abstract boolean updateSocietyOrg(SocietyOrg paramSocietyOrg);
  
  public abstract boolean deleteSocietyOrg(String paramString);
  
  public abstract List getSocietyOrgHistogram();
  
  public abstract boolean uploadEnterprisePicture(MultipartFile paramMultipartFile, String paramString);
  
  public abstract List<NonPublicEconomyOrgDetailVO> getNonPublicEconomyOrgDetailForGIS(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\NonpublicService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */