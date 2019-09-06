package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.InspectRecord;

public abstract interface InspectRecordMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract int insert(InspectRecord paramInspectRecord);
  
  public abstract InspectRecord selectByPrimaryKey(Long paramLong);
  
  public abstract InspectRecord getInspectRecDetail(Long paramLong);
  
  public abstract List<InspectRecord> selectAll();
  
  public abstract List<InspectRecord> getInspectRecInfo(@Param("name") String paramString1, @Param("date") String paramString2, @Param("code") String paramString3, @Param("start") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int getInspectRecInfoCount(@Param("name") String paramString1, @Param("date") String paramString2, @Param("code") String paramString3);
  
  public abstract int updateByPrimaryKey(InspectRecord paramInspectRecord);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\InspectRecordMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */