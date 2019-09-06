package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.DisputeDealingPicture;

public abstract interface DisputeDealingPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(DisputeDealingPicture paramDisputeDealingPicture);
  
  public abstract DisputeDealingPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<DisputeDealingPicture> selectAll();
  
  public abstract int updateByPrimaryKey(DisputeDealingPicture paramDisputeDealingPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\DisputeDealingPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */