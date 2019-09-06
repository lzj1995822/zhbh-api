package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.ServedRecordVideoFile;

public abstract interface ServedRecordVideoFileMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int deleteByFileID(@Param("id") Long paramLong);
  
  public abstract int insert(ServedRecordVideoFile paramServedRecordVideoFile);
  
  public abstract ServedRecordVideoFile selectByPrimaryKey(Long paramLong);
  
  public abstract List<ServedRecordVideoFile> selectAll();
  
  public abstract ServedRecordVideoFile selectByRecordID(@Param("id") Long paramLong);
  
  public abstract int updateByPrimaryKey(ServedRecordVideoFile paramServedRecordVideoFile);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\ServedRecordVideoFileMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */