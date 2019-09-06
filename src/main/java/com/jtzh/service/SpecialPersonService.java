package com.jtzh.service;

import com.jtzh.vo.KeyPetitioners.KeyPetitionersQueryVO;
import com.jtzh.vo.keyYoungers.KeyYoungersQueryVO;
import com.jtzh.vo.served.SpecialPersonPieVO;
import com.jtzh.vo.served.SpecialPsychoticResponseVO;
import java.util.HashMap;
import java.util.List;

public abstract interface SpecialPersonService
{
  public abstract List getSpecialPersonCount();
  
  public abstract SpecialPsychoticResponseVO getPsychoticInfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SpecialPsychoticResponseVO getEmancipistInfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SpecialPsychoticResponseVO getDrugAddictsInfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SpecialPsychoticResponseVO getCommunityCorrectionerInfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SpecialPsychoticResponseVO getAIDSdiseasenfo(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract HashMap getSpecialDetail(String paramString1, String paramString2);
  
  public abstract boolean addSpecialPerson(String paramString1, String paramString2);
  
  public abstract boolean updateSpecialPerson(String paramString1, String paramString2);
  
  public abstract boolean deleteSpecialPerson(Long paramLong, String paramString);
  
  public abstract KeyYoungersQueryVO getKeyYoungersQuery(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract List getKeyYoungerHistogramCount();
  
  public abstract List getKeyYoungerPieCount();
  
  public abstract KeyPetitionersQueryVO getKeyPetitionersQuery(String paramString1, String paramString2, Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract List getKeyPetitionersPieCount();
  
  public abstract List getSpecialPersonCountByType();
  
  public abstract List<SpecialPersonPieVO> getSpecialPersonPieCount(String paramString);
  
  public abstract boolean checkSpecialPersonByCertifID(String paramString1, String paramString2);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\service\SpecialPersonService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */