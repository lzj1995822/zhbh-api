package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.NetGridMemberPhoto;

public abstract interface NetGridMemberPhotoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByMemberID(@Param("id") Long paramLong);
  
  public abstract int insert(NetGridMemberPhoto paramNetGridMemberPhoto);
  
  public abstract NetGridMemberPhoto selectByPrimaryKey(Long paramLong);
  
  public abstract NetGridMemberPhoto selectByMemberID(@Param("id") Long paramLong);
  
  public abstract List<NetGridMemberPhoto> selectAll();
  
  public abstract int updateByPrimaryKey(NetGridMemberPhoto paramNetGridMemberPhoto);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\NetGridMemberPhotoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */