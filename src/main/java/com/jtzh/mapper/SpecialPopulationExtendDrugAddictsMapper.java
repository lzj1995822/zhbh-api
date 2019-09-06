package com.jtzh.mapper;

import com.jtzh.vo.gis.DrugAddictsVO;
import com.jtzh.vo.served.SpecialPsychoticInfoVO;
import com.jtzh.entity.SpecialPopulationExtendDrugAddicts;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SpecialPopulationExtendDrugAddictsMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SpecialPopulationExtendDrugAddicts paramSpecialPopulationExtendDrugAddicts);
  
  public abstract SpecialPopulationExtendDrugAddicts selectByPrimaryKey(Long paramLong);
  
  public abstract List<SpecialPopulationExtendDrugAddicts> selectAll();
  
  public abstract int updateByPrimaryKey(SpecialPopulationExtendDrugAddicts paramSpecialPopulationExtendDrugAddicts);
  
  public abstract List<SpecialPopulationExtendDrugAddicts> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<SpecialPsychoticInfoVO> getDrugAddictsInfo(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getDrugAddictsInfoCount(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<DrugAddictsVO> selectWithLocation(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SpecialPopulationExtendDrugAddictsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */