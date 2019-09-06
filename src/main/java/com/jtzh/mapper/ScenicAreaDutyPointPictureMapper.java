package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.ScenicAreaDutyPointPicture;

public abstract interface ScenicAreaDutyPointPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(ScenicAreaDutyPointPicture paramScenicAreaDutyPointPicture);
  
  public abstract ScenicAreaDutyPointPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<ScenicAreaDutyPointPicture> selectAll();
  
  public abstract int updateByPrimaryKey(ScenicAreaDutyPointPicture paramScenicAreaDutyPointPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ScenicAreaDutyPointPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */