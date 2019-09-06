package com.jtzh.mapper;

import com.jtzh.vo.gis.EmancipistVO;
import com.jtzh.vo.served.SpecialPsychoticInfoVO;
import com.jtzh.entity.SpecialPopulationExtendEmancipist;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SpecialPopulationExtendEmancipistMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SpecialPopulationExtendEmancipist paramSpecialPopulationExtendEmancipist);
  
  public abstract SpecialPopulationExtendEmancipist selectByPrimaryKey(Long paramLong);
  
  public abstract List<SpecialPopulationExtendEmancipist> selectAll();
  
  public abstract int updateByPrimaryKey(SpecialPopulationExtendEmancipist paramSpecialPopulationExtendEmancipist);
  
  public abstract List<SpecialPopulationExtendEmancipist> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<SpecialPsychoticInfoVO> getEmancipistInfo(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getEmancipistInfoCount(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<EmancipistVO> selectWithLocation(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SpecialPopulationExtendEmancipistMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */