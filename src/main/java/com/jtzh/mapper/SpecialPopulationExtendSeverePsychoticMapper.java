package com.jtzh.mapper;

import com.jtzh.vo.gis.SeverePsychoticVO;
import com.jtzh.vo.served.SpecialPsychoticInfoVO;
import com.jtzh.entity.SpecialPopulationExtendSeverePsychotic;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SpecialPopulationExtendSeverePsychoticMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SpecialPopulationExtendSeverePsychotic paramSpecialPopulationExtendSeverePsychotic);
  
  public abstract SpecialPopulationExtendSeverePsychotic selectByPrimaryKey(Long paramLong);
  
  public abstract List<SpecialPopulationExtendSeverePsychotic> selectAll();
  
  public abstract int updateByPrimaryKey(SpecialPopulationExtendSeverePsychotic paramSpecialPopulationExtendSeverePsychotic);
  
  public abstract List<SpecialPopulationExtendSeverePsychotic> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<SpecialPsychoticInfoVO> getPsychoticInfo(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getPsychoticInfoCount(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract List<SeverePsychoticVO> selectWithLocation(@Param("netGridID") Long paramLong);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SpecialPopulationExtendSeverePsychoticMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */