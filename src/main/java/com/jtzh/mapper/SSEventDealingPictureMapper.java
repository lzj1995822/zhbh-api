package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.SSEventDealingPicture;

public abstract interface SSEventDealingPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SSEventDealingPicture paramSSEventDealingPicture);
  
  public abstract SSEventDealingPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<SSEventDealingPicture> selectAll();
  
  public abstract int updateByPrimaryKey(SSEventDealingPicture paramSSEventDealingPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SSEventDealingPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */