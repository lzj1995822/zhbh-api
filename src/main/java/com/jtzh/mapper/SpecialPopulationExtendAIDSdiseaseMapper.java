package com.jtzh.mapper;

import com.jtzh.vo.gis.AIDSdiseaseVO;
import com.jtzh.vo.served.SpecialPsychoticInfoVO;
import com.jtzh.entity.SpecialPopulationExtendAIDSdisease;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SpecialPopulationExtendAIDSdiseaseMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SpecialPopulationExtendAIDSdisease paramSpecialPopulationExtendAIDSdisease);
  
  public abstract SpecialPopulationExtendAIDSdisease selectByPrimaryKey(Long paramLong);
  
  public abstract List<SpecialPopulationExtendAIDSdisease> selectAll();
  
  public abstract int updateByPrimaryKey(SpecialPopulationExtendAIDSdisease paramSpecialPopulationExtendAIDSdisease);
  
  public abstract List<SpecialPopulationExtendAIDSdisease> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<SpecialPsychoticInfoVO> getAIDSdiseaseInfo(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getAIDSdiseaseInfoCount(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<AIDSdiseaseVO> selectWithLocation(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SpecialPopulationExtendAIDSdiseaseMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */