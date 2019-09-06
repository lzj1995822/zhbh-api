package com.jtzh.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jtzh.entity.TRSpecialServedPerson;

public abstract interface TRSpecialServedPersonMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);
  
  public abstract int insert(TRSpecialServedPerson paramTRSpecialServedPerson);
  
  public abstract TRSpecialServedPerson selectByPrimaryKey(Integer paramInteger);
  
  public abstract List<TRSpecialServedPerson> selectAll();
  
  public abstract int updateByPrimaryKey(TRSpecialServedPerson paramTRSpecialServedPerson);
  
  public abstract int deleteByTypeAndID(@Param("type") String paramString, @Param("id") Long paramLong);
}


/* Location:              C:\Users\rainb\Desktop\msmis.war!\WEB-INF\classes\com\gbt\dao\TRSpecialServedPersonMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */