package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.SkynetPEDealingPicture;

public abstract interface SkynetPEDealingPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SkynetPEDealingPicture paramSkynetPEDealingPicture);
  
  public abstract SkynetPEDealingPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<SkynetPEDealingPicture> selectAll();
  
  public abstract List<SkynetPEDealingPicture> selectBySkynetPatrolEventDealingID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(SkynetPEDealingPicture paramSkynetPEDealingPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SkynetPEDealingPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */