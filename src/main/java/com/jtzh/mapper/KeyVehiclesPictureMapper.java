package com.jtzh.mapper;

import java.util.List;

import com.jtzh.entity.KeyVehiclesPicture;

public abstract interface KeyVehiclesPictureMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(KeyVehiclesPicture paramKeyVehiclesPicture);
  
  public abstract KeyVehiclesPicture selectByPrimaryKey(Long paramLong);
  
  public abstract List<KeyVehiclesPicture> selectAll();
  
  public abstract int updateByPrimaryKey(KeyVehiclesPicture paramKeyVehiclesPicture);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\KeyVehiclesPictureMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */