package com.jtzh.service;

import com.jtzh.vo.orgMember.ServedPersonBasicResponseVO;
import com.jtzh.vo.served.*;
import com.jtzh.entity.CODEServedPersonType;
import com.jtzh.entity.ServedPersonBasic;
import com.jtzh.entity.ServedPersonExtendFloatingPopulation;
import com.jtzh.entity.ServedPersonExtendResident;
import com.jtzh.entity.ServedPersonExtendStayedPerson;
import com.jtzh.entity.ServedPersonForeigner;

import java.util.HashMap;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public abstract interface ServedPersonService
{
  public abstract List<CODEServedPersonType> getServedPersonType();
  
  public abstract HashMap<String, List> getAllTypes();
  
  public abstract long uploadServedPersonPhoto(MultipartFile paramMultipartFile);
  
  public abstract boolean updateServedPersonPhoto(MultipartFile paramMultipartFile, Long paramLong);
  
  public abstract boolean addServedPersonBasic(ServedPersonBasicAddVO paramServedPersonBasicAddVO);
  
  public abstract ServedPersonBasicResponseVO query(ServedPersonBasicQueryVO paramServedPersonBasicQueryVO);
  
  public abstract HashMap<String, List> getServedPersonInfo(String paramString);
  
  public abstract boolean addFloating(ServedPersonExtendFloatingPopulation paramServedPersonExtendFloatingPopulation);
  
  public abstract boolean addResident(ServedPersonExtendResident paramServedPersonExtendResident);
  
  public abstract boolean addStayed(ServedPersonExtendStayedPerson paramServedPersonExtendStayedPerson);
  
  public abstract boolean addForeigner(ServedPersonForeigner paramServedPersonForeigner);
  
  public abstract boolean addAIDS(SpecialAIDSAddVO paramSpecialAIDSAddVO);
  
  public abstract boolean addDrug(SpecialDrugAddVO paramSpecialDrugAddVO);
  
  public abstract boolean addEmancipist(SpecialEmancipistAddVO paramSpecialEmancipistAddVO);
  
  public abstract boolean addPsychotic(SpecialPsychoticAddVO paramSpecialPsychoticAddVO);
  
  public abstract boolean updateServedPerson(String paramString1, String paramString2);
  
  public abstract boolean deleteServedPerson(String paramString1, String paramString2);
  
  public abstract List<ServedPersonBasic> selectByNameAndCertifID(String paramString1, String paramString2);
  public abstract ServedPersonBasicQuery selectByNameAndCertifIDGh(String paramString1, String paramString2, int page, int pageSize);
  public abstract boolean checkCertifID(String paramString);
  
  public abstract List getServedPersonCount();
  
  Object updateBasic(ServedPersonBasic basic);
  
  Object updateExtendRecord(ServedPersonExtendResident extend);
  
  public abstract boolean deleteBasic(Long ServedPersonID);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\ServedPersonService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */