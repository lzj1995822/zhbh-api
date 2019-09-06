package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.SPProcessionPhoto;

public abstract interface SPProcessionPhotoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(SPProcessionPhoto paramSPProcessionPhoto);
  
  public abstract SPProcessionPhoto selectByPrimaryKey(Long paramLong);
  
  public abstract SPProcessionPhoto selectByPersonID(@Param("id") Long paramLong);
  
  public abstract List<SPProcessionPhoto> selectAll();
  
  public abstract int updateByPrimaryKey(SPProcessionPhoto paramSPProcessionPhoto);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\SPProcessionPhotoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */