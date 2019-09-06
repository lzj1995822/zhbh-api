package com.jtzh.mapper;

import com.jtzh.vo.gis.CommunityCorrectionerVO;
import com.jtzh.vo.served.SpecialPsychoticInfoVO;
import com.jtzh.entity.SpecialPopulationExtendCommunityCorrectioner;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SpecialPopulationExtendCommunityCorrectionerMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SpecialPopulationExtendCommunityCorrectioner paramSpecialPopulationExtendCommunityCorrectioner);
  
  public abstract SpecialPopulationExtendCommunityCorrectioner selectByPrimaryKey(Long paramLong);
  
  public abstract List<SpecialPopulationExtendCommunityCorrectioner> selectAll();
  
  public abstract int updateByPrimaryKey(SpecialPopulationExtendCommunityCorrectioner paramSpecialPopulationExtendCommunityCorrectioner);
  
  public abstract List<SpecialPopulationExtendCommunityCorrectioner> selectByCertifID(@Param("certifID") String paramString);
  
  public abstract List<SpecialPsychoticInfoVO> getCommunityCorrectionerInfo(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getCommunityCorrectionerInfoCount(@Param("name") String paramString1, @Param("certifID") String paramString2, @Param("netGridID") Integer paramInteger);
  
  public abstract int getCount(@Param("netGridID") Long paramLong);
  
  public abstract List<CommunityCorrectionerVO> selectWithLocation(@Param("netGridID") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SpecialPopulationExtendCommunityCorrectionerMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */